package com.trenduce.services;

import com.trenduce.model.Collage;
import com.trenduce.model.Comment;
import com.trenduce.model.Like;
import com.trenduce.model.UserProfile;
import com.trenduce.repositories.CollageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by prafulmantale on 1/5/15.
 */
@Service
public class CollageService {

    @Autowired
    private CollageRepository repository;

    @Autowired
    private UserService userService;


    public List<Collage> getAllCollages(){

        return repository.findAll();
    }

    public  Collage getCollage(String id){
        Collage collage = repository.findOne(id);
        return collage;
    }

    public List<Comment> getAllComments(String id){
        Collage collage = getCollage(id);

        if(collage == null || collage.getComments() == null){
            return new ArrayList<Comment>();
        }

        return collage.getComments();
    }

    public boolean addComment(String id, Comment comment){

        if(id == null || id.isEmpty()){
            return false;
        }

        if(comment == null || comment.getText().isEmpty() ||
                comment.getUser() == null || comment.getUser().isEmpty()){
            return false;
        }

        UserProfile profile = userService.findUserByName(comment.getUser());

        if(profile == null){
            return false;
        }

        Collage collage = getCollage(id);

        if(collage == null){
            return false;
        }

        collage.getComments().add(comment);
        save(collage);

        return true;
    }

    public List<Like> getAllLikes(String id){
        Collage collage = getCollage(id);

        if(collage == null || collage.getComments() == null){
            return new ArrayList<Like>();
        }

        return collage.getLikes();
    }

    public boolean addLike(String id, Like like){

        if(id == null || id.isEmpty()){
            return false;
        }

        if(like == null || like.getUser() == null || like.getUser().isEmpty()){
            return false;
        }

        UserProfile profile = userService.findUserByName(like.getUser());

        if(profile == null){
            return false;
        }

        Collage collage = getCollage(id);

        if(collage == null){
            return false;
        }

        if(collage.getLikes().contains(like) == false) {

            collage.setLikesCount(collage.getLikesCount() + 1);
            collage.getLikes().add(like);

            save(collage);
        }

        return true;
    }

    public boolean unLike(String id, Like like){

        if(id == null || id.isEmpty()){
            return false;
        }

        if(like == null || like.getUser() == null || like.getUser().isEmpty()){
            return false;
        }

        UserProfile profile = userService.findUserByName(like.getUser());

        if(profile == null){
            return false;
        }

        Collage collage = getCollage(id);

        if(collage == null){
            return false;
        }

        if(collage.getLikes().contains(like)) {
            collage.setLikesCount(collage.getLikesCount() - 1);
            collage.getLikes().remove(like);
            save(collage);
        }

        return true;
    }


    public boolean addViewed(String id){
        if(id == null || id.isEmpty()){
            return false;
        }

        Collage collage = getCollage(id);

        if(collage == null){
            return false;
        }

        collage.setViewCount(collage.getViewCount() + 1);
        save(collage);

        return true;
    }


    public List<Collage> getAllStylesByUser(String userName){

        if(userName == null || userName.isEmpty()){
            return new ArrayList<Collage>();
        }

        List<Collage> list = repository.findByCreatedBy(userName);

        if(list == null){
            return new ArrayList<Collage>();
        }

        return list;
    }

    public void save(Collage collage){
        repository.save(collage);
    }
}
