package com.trenduce.repositories;

import com.trenduce.model.Collage;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by prafulmantale on 1/5/15.
 */

@Repository
public interface CollageRepository extends MongoRepository<Collage, String> {

    public List<Collage> findByCreatedBy(String userName);
}
