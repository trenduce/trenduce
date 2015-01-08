package com.trenduce.repositories;

import com.trenduce.model.UserProfile;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by prafulmantale on 1/4/15.
 */
@Repository
public interface UserRepository extends MongoRepository<UserProfile, String>{

    public UserProfile findByUserName(String userName);

}
