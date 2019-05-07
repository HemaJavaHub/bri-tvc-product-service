package com.demo.productservice.service;

import com.demo.productservice.models.Product;
import com.demo.productservice.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    public void addProduct(Product product) {
        productRepository.save(product);
    }

    public List<Product> findByCategory(String category){
        return productRepository.findByCategory(category);
    }
    public List<Product> findByCategoryAndSubCategory(String category,String sub_category){
        return productRepository.findByCategoryAndSubCategory(category,sub_category);
    }

    public void updateProductCount(Integer id,int qty) {
         productRepository.updateProductCount(id,qty);
         if(productRepository.findById(id).get().getCount()==0){
             productRepository.restockInventory(id);
         }
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
}
