package com.trenduce.controller;

import com.trenduce.model.Collage;
import com.trenduce.model.Comment;
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

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public @ResponseBody
    List<Collage> getAll(){

        List<Collage> list = new ArrayList<Collage>();


        return list;
    }

    @RequestMapping(value = "/{id}")
    public @ResponseBody Collage getCollage(@PathVariable String id){
        return null;
    }

    @RequestMapping(value = "/comment/{id}")
    public  @ResponseBody
    Comment comment(@PathVariable String id){
        return null;
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
