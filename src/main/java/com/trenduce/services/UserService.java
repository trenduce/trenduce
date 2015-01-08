package com.trenduce.services;

import com.trenduce.model.UserProfile;
import com.trenduce.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by prafulmantale on 1/5/15.
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserProfile findUserByName(String userName){
        return userRepository.findByUserName(userName);
    }

}
