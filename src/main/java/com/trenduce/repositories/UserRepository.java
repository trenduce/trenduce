package com.trenduce.repositories;

import com.trenduce.model.UserProfile;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by prafulmantale on 1/4/15.
 */
@Repository
public interface UserRepository extends MongoRepository<UserProfile, String>{

    public List<UserProfile> findByUserName(String userName);
    public List<UserProfile> findByEmailId(String emailId);
}
