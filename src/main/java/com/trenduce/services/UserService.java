package com.trenduce.services;

import com.trenduce.model.UserProfile;
import com.trenduce.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by prafulmantale on 1/5/15.
 */
@Service
public class UserService {

    private static final String TAG = UserService.class.getSimpleName();

    @Autowired
    private UserRepository userRepository;

    public List<UserProfile> getAllUsers(){

        return userRepository.findAll();
    }


    public UserProfile findUserByName(String userName){
        List<UserProfile> userProfiles = userRepository.findByUserName(userName);

        if(userProfiles == null || userProfiles.size() == 0){
            return null;
        }

        return userProfiles.get(0);
    }

    public List<UserProfile> getAllFollowing(String userName){

        //TODO -- Error messages and exceptions throwing in case of improper data
        UserProfile userProfile = findUserByName(userName);

        if(userProfile == null){
            return new ArrayList<UserProfile>();
        }

        if(userProfile.getFollowing() == null || userProfile.getFollowing().size() == 0){
            return new ArrayList<UserProfile>();
        }

        Iterable<UserProfile> list =  userRepository.findAll(userProfile.getFollowing());

        List<UserProfile> userProfiles = new ArrayList<UserProfile>();

        for(UserProfile userProfile1 : list){
            userProfiles.add(userProfile1);
        }

        return userProfiles;
    }

    public boolean follow(String userName, String toFollowUserName){

        if(userName == null || userName.isEmpty() ||
                toFollowUserName == null || toFollowUserName == null){
            return false;

        }
        List<UserProfile> userProfiles = userRepository.findByUserName(userName);

        if(userProfiles == null || userProfiles.size() == 0){
            return false;
        }

        List<UserProfile> toFollowUserProfiles = userRepository.findByUserName(toFollowUserName);

        if(toFollowUserProfiles == null || toFollowUserProfiles.size() == 0){
            return false;
        }

        try {

            //TODO - Validate if the relationship already exists
            UserProfile userProfile = userProfiles.get(0);
            UserProfile toFollowUserProfile = toFollowUserProfiles.get(0);

            userProfile.getFollowing().add(toFollowUserProfile.getId());

            toFollowUserProfile.getFollowers().add(userProfile.getId());

            saveProfile(userProfile);
            saveProfile(toFollowUserProfile);
        }
        catch (Exception ex){

            System.out.println("Exception in  " + TAG + ".follow()");
            return false;
        }

        return true;
    }

    public boolean unfollow(String userName, String toUnFollowUserName){

        if(userName == null || userName.isEmpty() ||
                toUnFollowUserName == null || toUnFollowUserName == null){
            return false;

        }
        List<UserProfile> userProfiles = userRepository.findByUserName(userName);

        if(userProfiles == null || userProfiles.size() == 0){
            return false;
        }

        List<UserProfile> toUnFollowUserProfiles = userRepository.findByUserName(toUnFollowUserName);

        if(toUnFollowUserProfiles == null || toUnFollowUserProfiles.size() == 0){
            return false;
        }

        try {

            UserProfile userProfile = userProfiles.get(0);
            UserProfile toFollowUserProfile = toUnFollowUserProfiles.get(0);

            userProfile.getFollowing().remove(toFollowUserProfile.getId());

            toFollowUserProfile.getFollowers().remove(userProfile.getId());

            saveProfile(userProfile);
            saveProfile(toFollowUserProfile);
        }
        catch (Exception ex){

            System.out.println("Exception in  " + TAG + ".unfollow()");
            return false;
        }

        return true;
    }


    public List<UserProfile> getAllFollowers(String userName){

        //TODO -- Error messages and exceptions throwing in case of improper data
        UserProfile userProfile = findUserByName(userName);

        if(userProfile == null){
            return new ArrayList<UserProfile>();
        }

        if(userProfile.getFollowers() == null || userProfile.getFollowers().size() == 0){
            return new ArrayList<UserProfile>();
        }

        Iterable<UserProfile> list =  userRepository.findAll(userProfile.getFollowers());

        List<UserProfile> userProfiles = new ArrayList<UserProfile>();

        for(UserProfile userProfile1 : list){
            userProfiles.add(userProfile1);
        }

        return userProfiles;
    }


    private void saveProfile(UserProfile userProfile){

        userRepository.save(userProfile);
    }

}
