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


    public UserProfile findUser(String identity){

        UserProfile userProfile = userRepository.findOne(identity);

        if(userProfile != null){
            return userProfile;
        }

        List<UserProfile> userProfiles = userRepository.findByEmailId(identity);

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

    public List<UserProfile> getAllFollowing(String identity){

        //TODO -- Error messages and exceptions throwing in case of improper data
        UserProfile userProfile = findUser(identity);

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

    public boolean follow(String identity, String toFollowidentity){

        if(identity == null || identity.isEmpty() ||
                toFollowidentity == null || toFollowidentity == null){
            return false;

        }
        UserProfile userProfile = findUser(identity);

        if(userProfile == null){
            return false;
        }

        UserProfile toFollowUserProfile = findUser(toFollowidentity);

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

    public boolean unfollow(String identity, String toUnFollowIdentity){

        if(identity == null || identity.isEmpty() ||
                toUnFollowIdentity == null || toUnFollowIdentity == null){
            return false;

        }
        UserProfile userProfile = findUser(identity);

        if(userProfile == null){
            return false;
        }

        UserProfile toUnFollowUserProfile = findUser(toUnFollowIdentity);

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


    public List<UserProfile> getAllFollowers(String identity){

        //TODO -- Error messages and exceptions throwing in case of improper data
        UserProfile userProfile = findUser(identity);

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


    public UserProfile addUser(UserProfile userProfile){

        if(userProfile == null){
            return null;
        }

        return saveProfile(userProfile);
    }

    public boolean updateUser(UserUpdateRequest request){

        if (request == null || request.getUserId() == null ||
                request.getUserId().isEmpty()){
            return false;
        }

        UserProfile existingProfile = findUser(request.getUserId());

        if(existingProfile == null){
            return false;
        }

        existingProfile.setAge(request.getAge());
        existingProfile.setFirstName(request.getFirstName());
        existingProfile.setLastName(request.getLastName());

        saveProfile(existingProfile);

        return true;
    }

    private UserProfile saveProfile(UserProfile userProfile){

        return userRepository.save(userProfile);
    }

}
