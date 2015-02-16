package com.trenduce.config;

import com.trenduce.repositories.UserRepository;
import com.trenduce.security.AuthFailure;
import com.trenduce.security.AuthSuccess;
import com.trenduce.security.EntryPointUnauthorizedHandler;
import com.trenduce.security.UserDetailsServiceImpl;
import com.trenduce.services.TrenduceSocialUserDetailsService;
import com.trenduce.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.social.security.SocialUserDetailsService;
import org.springframework.social.security.SpringSocialConfigurer;

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
    private UserService userService;


//    @Override
//    public void configure(WebSecurity web) throws Exception{
//        web
//                .ignoring()
//                .antMatchers("/static/**");
//    }
//
//    @Autowired
//    public void configAuthBuilder(AuthenticationManagerBuilder builder) throws Exception{
//
//        builder
//                .userDetailsService(userDetailsService)
//                .passwordEncoder(passwordEncoder());
//    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                .authorizeRequests()
                    .antMatchers("/**")
                    .permitAll();

//                .formLogin()
//                    .loginPage("/login")
//                    .loginProcessingUrl("/login/authenticate")
//                    .failureUrl("/login?error=bad_credentials")
//                .and()
//                    .logout()
//                        .deleteCookies("JSESSIONID")
//                        .logoutUrl("/logout")
//                        .logoutSuccessUrl("/login")
//                .and()
//                    .authorizeRequests()
//                        .antMatchers(
//                                "/auth/**",
//                                "/login",
//                                "/signup/**",
//                                "/user/register/**"
//                        ).permitAll()
//                    .antMatchers("/**").hasRole("USER")
//                .and()
//                    .apply(new SpringSocialConfigurer());

//                .csrf().disable()
//                .exceptionHandling()
//                    .authenticationEntryPoint(entryPointUnauthorizedHandler)
//                .and()
//                .formLogin()
//                    .successHandler(authSuccess)
//                    .failureHandler(authFailure)
//                .and()
//                .authorizeRequests()
//                    .antMatchers("/**")
//                    .permitAll();
    }



//    @Bean
//    public PasswordEncoder passwordEncoder(){
//        return new BCryptPasswordEncoder(10);
//    }
//
//    @Bean
//    public SocialUserDetailsService socialUserDetailsService(){
//        return new TrenduceSocialUserDetailsService(userDetailsService());
//    }
//
//    @Bean
//    public UserDetailsService userDetailsService(){
//        return new UserDetailsServiceImpl(userService);
//    }
}
