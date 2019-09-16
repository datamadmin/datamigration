package com.dataeconomy.framework.oAuth;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.web.access.channel.ChannelProcessingFilter;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.dataeconomy.framework.util.AppWebUtils;

@Configuration
@EnableResourceServer
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {

	@Override
	public void configure(final HttpSecurity http) throws Exception {
		http.requestMatchers().antMatchers("/api/**").and()
				.addFilterBefore(new org.springframework.web.filter.CorsFilter(corsConfigurationSource()),
						ChannelProcessingFilter.class)
				.authorizeRequests().antMatchers("/api/**").authenticated().and().sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS).and().anonymous().disable().securityContext()
				.and().csrf().disable().httpBasic().disable().formLogin().disable().logout().disable().csrf().disable();
		http.requestMatchers().antMatchers("/api/**").and().headers().defaultsDisabled().cacheControl();
	}

	private CorsConfigurationSource corsConfigurationSource() {
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", AppWebUtils.corsConfiguration());
		return source;
	}

}