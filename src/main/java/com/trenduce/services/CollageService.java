package com.trenduce.services;

import com.trenduce.model.Collage;
import com.trenduce.model.Comment;
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
        collage.getComments().add(comment);
        save(collage);

        return true;
    }

    public boolean addLike(String id){

        if(id == null || id.isEmpty()){
            return false;
        }


        Collage collage = getCollage(id);
        collage.setLikesCount(collage.getLikesCount() + 1);
        save(collage);

        return true;
    }

    public boolean unLike(String id){

        if(id == null || id.isEmpty()){
            return false;
        }


        Collage collage = getCollage(id);
        collage.setLikesCount(collage.getLikesCount() - 1);
        save(collage);

        return true;
    }


    public void save(Collage collage){
        repository.save(collage);
    }
}
