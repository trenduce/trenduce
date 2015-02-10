package com.trenduce.services;

import com.trenduce.model.Collage;
import com.trenduce.repositories.CollageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public void save(Collage collage){
        repository.save(collage);
    }
}
