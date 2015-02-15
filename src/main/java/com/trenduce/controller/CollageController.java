package com.trenduce.controller;

import com.trenduce.model.Collage;
import com.trenduce.model.Comment;
import com.trenduce.services.CollageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by prafulmantale on 1/4/15.
 */

@Controller
@RequestMapping(value = "/styles")
public class CollageController {

    /*

        Implement pagination

     */

    @Autowired
    private CollageService collageService;

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    List<Collage> getAll(){

        List<Collage> list = collageService.getAllCollages();

        return list;
    }

    @RequestMapping(value = "/{id}")
    public @ResponseBody Collage getCollage(@PathVariable String id){

        return collageService.getCollage(id);
    }

    @RequestMapping(value = "/{id}/comments")
    public  @ResponseBody
    List<Comment> getAllComments(@PathVariable String id){
        return collageService.getAllComments(id);
    }

    @RequestMapping(value = "/like/{id}")
    public  @ResponseBody
    Comment like(@PathVariable String id){
        return null;
    }

    @RequestMapping(value = "/unlike/{id}")
    public  @ResponseBody
    Comment unlike(@PathVariable String id){
        return null;
    }
}
