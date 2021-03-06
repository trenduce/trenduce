package com.trenduce.services;

import com.trenduce.model.Collage;
import com.trenduce.model.Comment;
import com.trenduce.model.Like;
import com.trenduce.model.UserProfile;
import com.trenduce.repositories.CollageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.ResourceLoader;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by prafulmantale on 1/5/15.
 */
@Service
public class CollageService{

    private ResourceLoader resourceLoader;

    @Autowired
    private CollageRepository repository;


    @Autowired
    private UserService userService;

    private static int PAGE_SIZE = 30;


    public List<Collage> getAllCollages(Integer pageNumber){

        if(pageNumber == null){
            pageNumber = 0;
        }

        Page<Collage> page = repository.findAll(new PageRequest(pageNumber, PAGE_SIZE));

        Iterator<Collage> list =  page.iterator();
        List<Collage> collages = new ArrayList<Collage>();
        while(list.hasNext()){
            Collage collage = list.next();
            collages.add(collage);
        }

        return collages;
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
                comment.getUserId() == null || comment.getUserId().isEmpty()){
            return false;
        }

        UserProfile profile = userService.findUser(comment.getUserId());

        if(profile == null){
            return false;
        }

        Collage collage = getCollage(id);

        if(collage == null){
            return false;
        }

        comment.setFirstName(profile.getFirstName());
        comment.setLastName(profile.getLastName());
        comment.setImageUrl(profile.getImageUrl());

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

        if(like == null || like.getUserId() == null || like.getUserId().isEmpty()){
            return false;
        }

        UserProfile profile = userService.findUser(like.getUserId());

        if(profile == null){
            return false;
        }

        Collage collage = getCollage(id);

        if(collage == null){
            return false;
        }

        if(collage.getLikes().contains(like) == false) {

            collage.getLikes().add(like);

            save(collage);
        }

        return true;
    }

    public boolean unLike(String id, Like like){

        if(id == null || id.isEmpty()){
            return false;
        }

        if(like == null || like.getUserId() == null || like.getUserId().isEmpty()){
            return false;
        }

        UserProfile profile = userService.findUser(like.getUserId());

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

    public boolean addTags(String id, List<String> tags){

        if(id == null || id.isEmpty() || tags == null || tags.size() == 0){
            return false;
        }

        Collage collage = getCollage(id);

        if(collage == null){
            return false;
        }

        collage.getTags().addAll(tags);

        save(collage);

        return true;
    }


    public boolean addCollage(String userName, String title, String fileUrl){

        if(userName == null || userName.isEmpty()){
            return false;
        }

        if(title == null || title.isEmpty()){
            return false;
        }

        try {

            Collage collage = new Collage();
            collage.setCreatedBy(userName);
            collage.setTitle(title);
            collage.setImageUrl("../images/" + fileUrl);

            save(collage);
        }
        catch (Exception ex){
            return false;
        }

        return true;
    }

    public void save(Collage collage){
        repository.save(collage);
    }


}
