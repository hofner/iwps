package com.ericsson.bugs.sdt.dtra.iwp.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * The Class IwpSecurityConfig.
 */
@Configuration
@EnableWebSecurity
public class IwpSecurityConfig extends WebSecurityConfigurerAdapter {

    private final static String ANY_URL = "/**/*";

    /**
     * {@inheritDoc}
     */
    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.antMatcher(ANY_URL).authorizeRequests().anyRequest().permitAll();
    }

}
