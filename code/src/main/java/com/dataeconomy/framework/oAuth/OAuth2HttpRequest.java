package com.dataeconomy.framework.oAuth;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import org.springframework.security.web.savedrequest.Enumerator;

public class OAuth2HttpRequest extends HttpServletRequestWrapper {
	private final HashMap<String, String[]> params;
	private final HashMap<String, String> headers = new HashMap<>();

	public OAuth2HttpRequest(HttpServletRequest request, HashMap<String, String[]> params) {
		super(request);
		this.params = params;
	}

	@Override
	public String getParameter(String name) {
		if (this.params.containsKey(name)) {
			return this.params.get(name)[0];
		}
		return "";
	}

	@Override
	public Map<String, String[]> getParameterMap() {
		return this.params;
	}

	@Override
	public Enumeration<String> getParameterNames() {
		return new Enumerator<>(params.keySet());
	}

	@Override
	public String[] getParameterValues(String name) {
		return params.get(name);
	}

	/**
	 * The default behavior of this method is to return getHeader(String name)
	 * on the wrapped request object.
	 */
	@Override
	public String getHeader(String name) {
		String value = headers.get(name);
		if (value != null) {
			return value;
		} else {
			return super.getHeader(name);
		}
	}

	public void addHeaders(String key, String value) {
		headers.put(key, value);
	}
}