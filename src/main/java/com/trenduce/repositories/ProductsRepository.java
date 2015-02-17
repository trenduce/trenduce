package com.trenduce.repositories;

import com.trenduce.model.Category;
import com.trenduce.model.Product;
import com.trenduce.model.UserProfile;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by prafulmantale on 1/5/15.
 */

@Repository
public interface ProductsRepository extends MongoRepository<Product, String> {

    public List<Product> findBySku(String sku);
    public List<Product> findByCategory(Category category);

}
