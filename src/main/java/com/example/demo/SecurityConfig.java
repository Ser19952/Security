package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.authorization.AuthenticatedAuthorizationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    public void configure (AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("User")
                .password("{noop}root")
                .authorities("read" , "write")
                .and()
                .withUser("Root")
                .password("User")
                .authorities("read");

    }

    @Override
    public void configure (HttpSecurity httpSecurity) throws Exception {
        httpSecurity.formLogin()
                .and()
                .authorizeRequests().antMatchers("/by- city").permitAll()
                .and()
                .authorizeRequests().anyRequest().authenticated();

    }
}
