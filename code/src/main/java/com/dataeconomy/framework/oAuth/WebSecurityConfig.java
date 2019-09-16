package com.dataeconomy.framework.oAuth;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.access.channel.ChannelProcessingFilter;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.dataeconomy.framework.util.AppWebUtils;

@EnableWebSecurity
@Order(Ordered.HIGHEST_PRECEDENCE)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	ApplicationAuthProvider applicationAuthProvider;

	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(applicationAuthProvider);
	}

	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManager();
	}


	@Override
	protected void configure(final HttpSecurity http) throws Exception {
		CorsConfigurationSource source = corsConfigurationSource();
		http.requestMatchers().antMatchers("/app/**","/assets/**", "/css/**", "/js/**")
		.antMatchers(HttpMethod.OPTIONS).and()
		.addFilterBefore(new org.springframework.web.filter.CorsFilter(source), ChannelProcessingFilter.class)
		.addFilterAfter(new HtmlModeFilter(), ChannelProcessingFilter.class).sessionManagement()
		.sessionCreationPolicy(SessionCreationPolicy.STATELESS).and().anonymous().disable()
		.securityContext().and().csrf().disable()
		.formLogin().disable()		
		.logout().disable().csrf().disable()		
		.exceptionHandling()
		.authenticationEntryPoint((request, response, e) -> {
					String json = String.format("{\"message\": \"%s\"}", e.getMessage());
					response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
					response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
					response.setCharacterEncoding("UTF-8");
					response.getWriter().write(json);
				});
		http.requestMatchers().antMatchers("/app/**","/assets/**", "/css/**", "/js/**").and().headers().defaultsDisabled().cacheControl();
	}

	@Bean(name = "corsConfigurationSource")
	public CorsConfigurationSource corsConfigurationSource() {
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", AppWebUtils.corsConfiguration());
		return source;
	}

}
