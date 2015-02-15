package com.trenduce.services;

import com.trenduce.model.Collage;
import com.trenduce.model.Comment;
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

    public List<Collage> getAllCollages(){

        return repository.findAll();
    }

    public  Collage getCollage(String id){
        return repository.findOne(id);
    }

    public List<Comment> getAllComments(String id){
        Collage collage = getCollage(id);

        if(collage == null || collage.getComments() == null){
            return new ArrayList<Comment>();
        }

        return collage.getComments();
    }

    public boolean addComment(String id){

        Collage collage = getCollage(id);
        collage.getComments().add(new Comment());
        save(collage);

        return true;
    }


    public void save(Collage collage){
        repository.save(collage);
    }
}
