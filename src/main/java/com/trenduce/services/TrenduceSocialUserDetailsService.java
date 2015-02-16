package com.trenduce.services;

import org.springframework.dao.DataAccessException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.social.security.SocialUserDetails;
import org.springframework.social.security.SocialUserDetailsService;

/**
 * Created by prafulmantale on 2/15/15.
 */
public class TrenduceSocialUserDetailsService implements SocialUserDetailsService {

    private UserDetailsService userDetailsService;

    public TrenduceSocialUserDetailsService(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Override
    public SocialUserDetails loadUserByUserId(String userId) throws UsernameNotFoundException, DataAccessException {

        UserDetails userDetails = userDetailsService.loadUserByUsername(userId);

        return (SocialUserDetails) userDetails;
    }
}
