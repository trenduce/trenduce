package com.trenduce.controller;

import com.trenduce.model.Collage;
import com.trenduce.model.Conversation;
import com.trenduce.model.UserProfile;
import com.trenduce.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
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
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public @ResponseBody
    List<UserProfile> getAllUsers(){

        List<UserProfile> users = userService.getAllUsers();

        if(users == null || users.size() == 0){
            users = new ArrayList<UserProfile>();
        }

        return users;
    }


    @RequestMapping(value = "/{username}")
    public @ResponseBody UserProfile getUser(@PathVariable String username){

        //Find user using id
        UserProfile user = userService.findUserByName(username);

        if(user == null){
            user = new UserProfile();
        }

        return user;
    }

    @RequestMapping(value = "/{username}/following")
    public @ResponseBody List<UserProfile> getAllFollowing(@PathVariable String username){

        if(username == null || username.isEmpty()){

        }
        return userService.getAllFollowing(username);

    }

    @RequestMapping(value = "/{userId}/following/{toFollowId}")
    public ResponseEntity<String> follow(@PathVariable String userId, @PathVariable String toFollowId){

        boolean isSuccess = userService.follow(userId, toFollowId);
        return new ResponseEntity<String>(isSuccess ? HttpStatus.OK : HttpStatus.BAD_REQUEST);

    }

    @RequestMapping(value = "/{userId}/unfollow/{toUnfollowId}")
    public ResponseEntity<String> unFollow(@PathVariable String userId, @PathVariable String toUnfollowId){

        boolean isSuccess = userService.unfollow(userId, toUnfollowId);
        return new ResponseEntity<String>(isSuccess ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
    }


    @RequestMapping(value = "/{username}/followers")
    public @ResponseBody List<UserProfile> getAllFollowers(@PathVariable String username){

        if(username == null || username.isEmpty()){
            return new ArrayList<UserProfile>();
        }

        return userService.getAllFollowers(username);
    }

    @RequestMapping(value = "/{id}/styles")
    public @ResponseBody List<Collage> getAllStylesFromUser(@PathVariable String id){

        return null;
    }

    @RequestMapping(value = "/{id}/conversations")
    public @ResponseBody List<Conversation> getAllConversations(@PathVariable String id){

        return null;
    }

    @RequestMapping(value = "/{id}/conversations/{cid")
    public @ResponseBody Conversation getAllConversation(@PathVariable String id, @PathVariable String cid){

        return null;
    }

}
