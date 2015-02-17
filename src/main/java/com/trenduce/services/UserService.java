package com.trenduce.services;

import com.trenduce.model.UserUpdateRequest;
import com.trenduce.model.UserProfile;
import com.trenduce.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

    public UserProfile findUserByEmailId(String emailId){
        List<UserProfile> userProfiles = userRepository.findByEmailId(emailId);

        if(userProfiles == null || userProfiles.size() == 0){
            return null;
        }

        return userProfiles.get(0);
    }

    public UserProfile findUserByUserNameOrEmailId(String userName, String emailId){
        List<UserProfile> userProfiles = userRepository.findByUserNameOrEmailId(userName, emailId);

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
        UserProfile userProfile = findUserByName(userName);

        if(userProfile == null){
            return false;
        }

        UserProfile toFollowUserProfile = findUserByName(toFollowUserName);

        if(toFollowUserProfile == null){
            return false;
        }

        try {

            //TODO - Validate if the relationship already exists

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
        UserProfile userProfile = findUserByName(userName);

        if(userProfile == null){
            return false;
        }

        UserProfile toUnFollowUserProfile = findUserByName(toUnFollowUserName);

        if(toUnFollowUserProfile == null){
            return false;
        }

        try {

            userProfile.getFollowing().remove(toUnFollowUserProfile.getId());

            toUnFollowUserProfile.getFollowers().remove(userProfile.getId());

            saveProfile(userProfile);
            saveProfile(toUnFollowUserProfile);
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


    public void addUser(UserProfile userProfile){

        if(userProfile == null){
            return;
        }

        saveProfile(userProfile);
    }

    public boolean updateUser(UserUpdateRequest request){

        if (request == null || request.getUserName() == null ||
                request.getUserName().isEmpty()){
            return false;
        }

        UserProfile existingProfile = findUserByName(request.getUserName());

        if(existingProfile == null){
            return false;
        }

        existingProfile.setAge(request.getAge());
        existingProfile.setFirstName(request.getFirstName());
        existingProfile.setLastName(request.getLastName());

        return true;
    }

    private void saveProfile(UserProfile userProfile){

        userRepository.save(userProfile);
    }

}
