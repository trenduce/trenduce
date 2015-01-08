package com.trenduce.config;

import com.trenduce.security.AuthFailure;
import com.trenduce.security.AuthSuccess;
import com.trenduce.security.EntryPointUnauthorizedHandler;
import com.trenduce.security.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Created by prafulmantale on 1/4/15.
 */

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

    @Autowired
    private AuthFailure authFailure;

    @Autowired
    private AuthSuccess authSuccess;

    @Autowired
    private EntryPointUnauthorizedHandler entryPointUnauthorizedHandler;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    public void configAuthBuilder(AuthenticationManagerBuilder builder) throws Exception{

        builder.userDetailsService(userDetailsService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                .exceptionHandling()
                    .authenticationEntryPoint(entryPointUnauthorizedHandler)
                .and()
                .formLogin()
                    .successHandler(authSuccess)
                    .failureHandler(authFailure)
                .and()
                .authorizeRequests()
                    .antMatchers("/**")
                    .permitAll();
    }
}
