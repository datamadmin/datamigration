package com.dataeconomy.framework.oAuth;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.error.DefaultOAuth2ExceptionRenderer;
import org.springframework.security.oauth2.provider.error.OAuth2ExceptionRenderer;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.mvc.support.DefaultHandlerExceptionResolver;

import com.dataeconomy.framework.errorHandler.AppException;
import com.dataeconomy.framework.util.AppBundle;
import com.dataeconomy.framework.util.MessageJson;
import com.dataeconomy.workbench.constant.MessagesEnum;

public class OAuth2ExceptionEntryPoint implements AuthenticationEntryPoint {

	protected final Log logger = LogFactory.getLog(getClass());
	private String typeName = OAuth2AccessToken.BEARER_TYPE;
	private OAuth2ExceptionRenderer exceptionRenderer = new DefaultOAuth2ExceptionRenderer();
	private HandlerExceptionResolver handlerExceptionResolver = new DefaultHandlerExceptionResolver();

	private String realmName = "oauth";

	public void setRealmName(String realmName) {
		this.realmName = realmName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authException) throws IOException, ServletException {
		doHandle(request, response, authException);
	}

	public void setExceptionRenderer(OAuth2ExceptionRenderer exceptionRenderer) {
		this.exceptionRenderer = exceptionRenderer;
	}

	protected final void doHandle(HttpServletRequest request, HttpServletResponse response, Exception authException)
			throws IOException, ServletException {
		try {
			ResponseEntity<MessageJson> result = getExceptionMessage(authException);
			result = enhanceResponse(result, authException);
			exceptionRenderer.handleHttpEntityResponse(result, new ServletWebRequest(request, response));
			response.flushBuffer();
		} catch (ServletException e) {
			// Re-use some of the default Spring dispatcher behaviour - the
			// exception came from the filter chain and
			// not from an MVC handler so it won't be caught by the dispatcher
			// (even if there is one)
			if (handlerExceptionResolver.resolveException(request, response, this, e) == null) {
				throw e;
			}
		} catch (IOException e) {
			throw e;
		} catch (RuntimeException e) {
			throw e;
		} catch (Exception e) {
			// Wrap other Exceptions. These are not expected to happen
			throw new RuntimeException(e);
		}
	}

	private ResponseEntity<MessageJson> enhanceResponse(ResponseEntity<MessageJson> response, Exception exception) {
		HttpHeaders headers = response.getHeaders();
		String existing = null;
		if (headers.containsKey("WWW-Authenticate")) {
			existing = extractTypePrefix(headers.getFirst("WWW-Authenticate"));
		}
		StringBuilder builder = new StringBuilder();
		builder.append(typeName + " ");
		builder.append("realm=\"" + realmName + "\"");
		if (existing != null) {
			builder.append(", " + existing);
		}
		HttpHeaders update = new HttpHeaders();
		update.putAll(response.getHeaders());
		update.set("WWW-Authenticate", builder.toString());
		return new ResponseEntity<MessageJson>(response.getBody(), update, response.getStatusCode());
	}

	private String extractTypePrefix(String header) {
		String existing = header;
		String[] tokens = existing.split(" +");
		if (tokens.length > 1 && !tokens[0].endsWith(",")) {
			existing = StringUtils.arrayToDelimitedString(tokens, " ").substring(existing.indexOf(" ") + 1);
		}
		return existing;
	}

	private ResponseEntity<MessageJson> getExceptionMessage(Throwable th) {
		logger.error(th, th);
		MessageJson json = null;
		if (th instanceof AppException) {
			AppException ke = (AppException) th;
			json = new MessageJson(501, ke.getMessage());
		} else {
			json = new MessageJson(501, AppBundle.getString(MessagesEnum.UNEXPECTEDFAILURE.getBundle(),
					MessagesEnum.UNEXPECTEDFAILURE.getKey()));
		}
		return new ResponseEntity<MessageJson>(json, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
