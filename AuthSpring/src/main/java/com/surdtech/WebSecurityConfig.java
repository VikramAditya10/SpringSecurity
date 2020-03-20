package com.surdtech;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	 public UserDetailsService userDetailsService() {
	        return new InMemoryUserDetailsManager(
	            User.withDefaultPasswordEncoder()
	                .username("enduser")
	                .password("password")
	                .roles("USER")
	                .build());
	    }
	 @Bean
	    PasswordEncoder passwordEncoder() {
	        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	    }

	    protected void configure(ClientDetailsServiceConfigurer clients) throws Exception {
	        clients
	            .inMemory()
	                .withClient("first-client")
	                .secret(passwordEncoder().encode("noonewilleverguess"))
	                .scopes("resource:read")
	                .authorizedGrantTypes("authorization_code")
	                .redirectUris("http://localhost:8081/oauth/login/client-app");
	    }
	/*@Autowired
	private CustomUserDetailsService userService;
	protected void configure(AuthenticationManagerBuilder auth)throws Exception {
		auth.userDetailsService(userService);
	}
	@Bean
	public PasswordEncoder 	passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
		
	}*/
}
