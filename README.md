# SpringSecurity

1. Enabling the Authorization Server
@EnableAuthorizationServer
@SpringBootApplication

2. Configure Authorization Server

@Configuration
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter

3. Add End Users
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Bean
    @Override
    public UserDetailsService userDetailsService()

4. 

