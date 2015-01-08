package com.trenduce.controller;

import com.trenduce.model.Collage;
import com.trenduce.model.Conversation;
import com.trenduce.model.UserProfile;
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

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public @ResponseBody
    List<UserProfile> getAllUsers(){

        List<UserProfile> users = new ArrayList<UserProfile>();

        return users;
    }


    @RequestMapping(value = "/{id}")
    public @ResponseBody UserProfile getUser(@PathVariable String id){

        //Find user using id
        UserProfile user = new UserProfile();

        return user;
    }

    @RequestMapping(value = "/{id}/following/{followid}")
    public void follow(@PathVariable String userId, @PathVariable String toFollowId){

    }

    @RequestMapping(value = "/{id}/unfollow/{followid}")
    public void unFollow(@PathVariable String id, @PathVariable String followid){

    }

    @RequestMapping(value = "/{id}/following")
    public void getAllFollowing(@PathVariable String id){

    }

    @RequestMapping(value = "/{id}/followers")
    public @ResponseBody List<UserProfile> getAllFollowers(@PathVariable String id){

        return null;
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
