package com.demo.productservice.controllers;

import com.demo.productservice.models.Product;
import com.demo.productservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping("/products/saveproduct")
    public String postProduct(@RequestBody Product product){
        productService.addProduct(product);
        return "saved";
    }
    @GetMapping("/products/categories/{category}")
    public List<Product> findProductsByCategory(@PathVariable String category){
        return productService.findByCategory(category);
    }

    @GetMapping("/products/categories/{category}/sub/{sub_category}")
    public List<Product> findProductsByCategoryAndSubCategory(@PathVariable String category,@PathVariable String sub_category){
        return productService.findByCategoryAndSubCategory(category,sub_category);
    }

    @GetMapping("/products/{id}")
    public void updateProductCount(@PathVariable Integer id,@PathVariable int qty){
         productService.updateProductCount(id,qty);
    }
    @CrossOrigin("*")
    @GetMapping("/products")
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }




}
