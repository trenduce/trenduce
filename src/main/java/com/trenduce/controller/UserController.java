package com.trenduce.controller;

import com.trenduce.model.Collage;
import com.trenduce.model.Conversation;
import com.trenduce.model.UserUpdateRequest;
import com.trenduce.model.UserProfile;
import com.trenduce.services.CollageService;
import com.trenduce.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by prafulmantale on 1/4/15.
 */
@Controller
@RequestMapping("/users")
@Scope("session")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private CollageService collageService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public @ResponseBody
    List<UserProfile> getAllUsers(){

        List<UserProfile> users = userService.getAllUsers();

        if(users == null || users.size() == 0){
            users = new ArrayList<UserProfile>();
        }

        return users;
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<String> updateProfile(@RequestBody UserUpdateRequest request){

        boolean isSuccess = false;

        userService.updateUser(request);

        return new ResponseEntity<String>(isSuccess ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
    }


    @RequestMapping(value = "/{identication}")
    public @ResponseBody UserProfile getUser(@PathVariable String identication){

        //Find user using id
        UserProfile user = userService.findUser(identication);

        if(user == null){
            user = new UserProfile();
        }

        return user;
    }

    @RequestMapping(value = "/{identity}/following")
    public @ResponseBody List<UserProfile> getAllFollowing(@PathVariable String identity){

        if(identity == null || identity.isEmpty()){
            return new ArrayList<UserProfile>();
        }
        return userService.getAllFollowing(identity);

    }

    @RequestMapping(value = "/{identity}/following/{toFollowidentity}")
    public ResponseEntity<String> follow(@PathVariable String identity, @PathVariable String toFollowidentity){

        boolean isSuccess = userService.follow(identity, toFollowidentity);
        return new ResponseEntity<String>(isSuccess ? HttpStatus.OK : HttpStatus.BAD_REQUEST);

    }

    @RequestMapping(value = "/{userId}/unfollow/{toUnfollowId}")
    public ResponseEntity<String> unFollow(@PathVariable String userId, @PathVariable String toUnfollowId){

        boolean isSuccess = userService.unfollow(userId, toUnfollowId);
        return new ResponseEntity<String>(isSuccess ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
    }


    @RequestMapping(value = "/{identity}/followers")
    public @ResponseBody List<UserProfile> getAllFollowers(@PathVariable String identity){

        if(identity == null || identity.isEmpty()){
            return new ArrayList<UserProfile>();
        }

        return userService.getAllFollowers(identity);
    }

    @RequestMapping(value = "/{username}/styles")
    public @ResponseBody List<Collage> getAllStylesFromUser(@PathVariable String username){

        return collageService.getAllStylesByUser(username);
    }

    @RequestMapping(value = "/{username}/conversations")
    public @ResponseBody List<Conversation> getAllConversations(@PathVariable String username){

        return null;
    }

    @RequestMapping(value = "/{id}/conversations/{cid}")
    public @ResponseBody Conversation getAllConversation(@PathVariable String id, @PathVariable String cid){

        return null;
    }

}
