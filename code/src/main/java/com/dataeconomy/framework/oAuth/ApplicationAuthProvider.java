package com.dataeconomy.framework.oAuth;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import com.dataeconomy.datamigration.service.UserService;
import com.dataeconomy.framework.constants.ErrorCodeEnum;
import com.dataeconomy.framework.errorHandler.AppException;
import com.dataeconomy.framework.util.AppUser;

@Component
public class ApplicationAuthProvider implements AuthenticationProvider, InitializingBean {

	protected final Log logger = LogFactory.getLog(getClass());

	@Autowired
	UserService userService;

	public final void afterPropertiesSet() throws Exception {

	}

	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String username = (authentication.getPrincipal() == null) ? "NONE_PROVIDED" : authentication.getName();
		AppUser user = this.userService.getUserForLogin(username, authentication.getCredentials().toString());
		if (user == null) {
			throw new AppException(ErrorCodeEnum.INVALID_CREDENTIALS.key);
		}
		UsernamePasswordAuthenticationToken result = new UsernamePasswordAuthenticationToken(user,
				authentication.getCredentials(), null);
		result.setDetails(authentication.getDetails());
		return result;
	}

	public boolean supports(Class<?> authentication) {
		return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
	}

}
