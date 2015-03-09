package com.trenduce.security;

import com.trenduce.model.UserProfile;
import com.trenduce.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

/**
 * Created by prafulmantale on 1/4/15.
 */
@Component
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserService service;

    @Autowired
    public UserDetailsServiceImpl(UserService service) {
        this.service = service;
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

        UserProfile user = service.findUser(userName);

        if(user == null){
            //Throw exception
            throw  new UsernameNotFoundException("Username " + userName + " not found.");
        }

        TrenduceUserDetails principle = new TrenduceUserDetails.Builder()
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .id(user.getId())
                .password(user.getPassword())
                .role(user.getRole())
                .signInProvider(user.getSignInProvider())
                .userName(user.getEmailId())
                .build();

        return principle;

    }
}
