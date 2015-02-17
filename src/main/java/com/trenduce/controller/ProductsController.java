package com.trenduce.controller;

import com.trenduce.model.Product;
import com.trenduce.services.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by prafulmantale on 1/4/15.
 */

@Controller
@RequestMapping("/products")
public class ProductsController {

    @Autowired
    private ProductsService productsService;

    @RequestMapping(value = "/")
    public @ResponseBody
    List<Product> getAllProducts(){

        return productsService.getAllProducts();
    }

    @RequestMapping(value = "/{id}")
    public @ResponseBody Product getProduct(@PathVariable String id){
        return null;
    }
}
