package com.trenduce.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.social.UserIdSource;
import org.springframework.social.config.annotation.ConnectionFactoryConfigurer;
import org.springframework.social.config.annotation.EnableSocial;
import org.springframework.social.config.annotation.SocialConfigurer;
import org.springframework.social.connect.ConnectionFactoryLocator;
import org.springframework.social.connect.UsersConnectionRepository;
import org.springframework.social.facebook.connect.FacebookConnectionFactory;
import org.springframework.social.google.connect.GoogleConnectionFactory;
import org.springframework.social.linkedin.connect.LinkedInConnectionFactory;
import org.springframework.social.twitter.connect.TwitterConnectionFactory;
import sun.plugin.liveconnect.SecurityContextHelper;

import javax.activation.DataSource;
import javax.inject.Inject;

/**
 * Created by prafulmantale on 2/9/15.
 */
@Configuration
@EnableSocial
public class SocialConfig implements SocialConfigurer{

//    @Inject
//    private DataSource dataSource;

    @Override
    public void addConnectionFactories(ConnectionFactoryConfigurer connectionFactoryConfigurer, Environment environment) {

        connectionFactoryConfigurer.addConnectionFactory(new TwitterConnectionFactory(
                environment.getProperty("twitter.appKey"),
                environment.getProperty("twitter.appSecrete")
        ));

        connectionFactoryConfigurer.addConnectionFactory(new FacebookConnectionFactory(
                environment.getProperty("facebook.appKey"),
                environment.getProperty("facebook.appSecrete")
        ));

        connectionFactoryConfigurer.addConnectionFactory(new GoogleConnectionFactory(
                environment.getProperty("google.appKey"),
                environment.getProperty("google.appSecrete")
        ));

        connectionFactoryConfigurer.addConnectionFactory(new LinkedInConnectionFactory(
                environment.getProperty("linkedin.appKey"),
                environment.getProperty("linkedin.appSecrete")
        ));
    }

    @Override
    public UserIdSource getUserIdSource() {
        return new UserIdSource() {
            @Override
            public String getUserId() {
                Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

                if(authentication == null){
                    throw new IllegalStateException("Unable to get connection repository. no user");
                }

                return authentication.getName();
            }
        };
    }

    @Override
    public UsersConnectionRepository getUsersConnectionRepository(ConnectionFactoryLocator connectionFactoryLocator) {
        return null;
    }
}
