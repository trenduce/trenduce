package com.trenduce.repositories;

import com.trenduce.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by prafulmantale on 1/5/15.
 */

@Repository
public interface ProductsRepository extends MongoRepository<Product, String> {
}
