package com.dataeconomy.framework.oAuth;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Objects;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.filter.OncePerRequestFilter;

import com.dataeconomy.framework.util.AppWebUtils;

public class JsonToUrlEncodedAuthenticationFilter extends OncePerRequestFilter {

	private static final String CLIENT_SECRET = "client_secret";
	private static final String AUTHORIZATION = "Authorization";

	@Override
	@SuppressWarnings("unchecked")
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		if (Objects.equals(request.getContentType(), "application/json")
				&& Objects.equals(request.getPathInfo(), "/oauth/token")) {
			InputStream is = request.getInputStream();
			ByteArrayOutputStream buffer = new ByteArrayOutputStream();
			int nRead;
			byte[] data = new byte[16384];
			while ((nRead = is.read(data, 0, data.length)) != -1) {
				buffer.write(data, 0, nRead);
			}
			buffer.flush();
			byte[] json = buffer.toByteArray();
			HashMap<String, String> result = AppWebUtils.convertJsonToObject(HashMap.class, new String(json));
			HashMap<String, String[]> r = new HashMap<>();
			for (String key : result.keySet()) {
				String[] val = new String[1];
				val[0] = result.get(key);
				r.put(key, val);
			}
			r.put("_method", new String[] { request.getMethod() });
			OAuth2HttpRequest newRequest = new OAuth2HttpRequest(request, r);
			newRequest.addHeaders(AUTHORIZATION, "Basic " + result.get(CLIENT_SECRET));
			filterChain.doFilter(newRequest, response);
		} else {
			filterChain.doFilter(request, response);
		}

	}
}