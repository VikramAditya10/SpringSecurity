package com.surdtech;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;

public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter{
@Autowired
DataSource datasource;
public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
	clients
	.jdbc(this.datasource)
	.passwordEncoder(PasswordEncoderFactories.createDelegatingPasswordEncoder());
}
}
