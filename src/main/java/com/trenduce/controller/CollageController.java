package com.trenduce.controller;

import com.trenduce.model.Collage;
import com.trenduce.model.Comment;
import com.trenduce.model.Like;
import com.trenduce.services.CollageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
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
    List<Collage> getAll(@RequestParam(required = false) Integer pageNumber){

        List<Collage> list = collageService.getAllCollages(pageNumber);

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

    @RequestMapping(value = "/{id}/comment", method = RequestMethod.POST)
    public ResponseEntity<String>
     addComment(@PathVariable String id, @RequestBody Comment comment){

        boolean isSuccess = collageService.addComment(id, comment);

        return new ResponseEntity<String>(isSuccess ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
    }


    @RequestMapping(value = "/{id}/likes", method = RequestMethod.GET)
    public  @ResponseBody List<Like>
    getAllLikes(@PathVariable String id){

        return collageService.getAllLikes(id);
    }


    @RequestMapping(value = "/{id}/like", method = RequestMethod.POST)
    public  ResponseEntity<String>
    like(@PathVariable String id, @RequestBody Like like){

        boolean isSuccess = collageService.addLike(id, like);

        return new ResponseEntity<String>(isSuccess ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(value = "/{id}/unlike")
    public  ResponseEntity<String> unlike(@PathVariable String id, @RequestBody Like like){

        boolean isSuccess = collageService.unLike(id, like);

        return new ResponseEntity<String>(isSuccess ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(value = "/{id}/viewed")
    public  ResponseEntity<String> viewed(@PathVariable String id){

        boolean isSuccess = collageService.addViewed(id);

        return new ResponseEntity<String>(isSuccess ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(value = "/{id}/tag")
    public ResponseEntity<String> addTags(@PathVariable String id, @RequestBody List<String> tags){

        boolean isSuccess = collageService.addTags(id, tags);

        return new ResponseEntity<String>(isSuccess ? HttpStatus.OK : HttpStatus.BAD_REQUEST);

    }



    @RequestMapping(value = "/upload", method = RequestMethod.GET)
    public String upload(){
        return "upload";
    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public ResponseEntity<String> uploadCollage(@RequestParam(value = "name", required = false) String name,
                   @RequestParam("file") MultipartFile file){
        boolean isSuccess = false;

        if (!file.isEmpty()) {
            try {
                byte[] bytes = file.getBytes();
                File file1 = new File(name);
                BufferedOutputStream stream =
                        new BufferedOutputStream(new FileOutputStream(file1));
                stream.write(bytes);
                stream.close();

                System.out.println("Name: " + file1.getAbsolutePath());

                isSuccess = true;

            } catch (Exception e) {

            }
        } else {

        }

        //isSuccess = collageService.addCollage("");

        return new ResponseEntity<String>(isSuccess ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
    }
}
