package com.demo.productservice.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product {
    @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;
    String name;
    String category;
    String sub_category;
    double price;
    String size;
    int count;
    String image;

    public Product(String name, String category, String sub_category, double price, String size, int count, String image) {

        this.name = name;
        this.category = category;
        this.sub_category = sub_category;
        this.price = price;
        this.size = size;
        this.count = count;
        this.image = image;
    }

    public Product(Integer id, String name, String category, String sub_category, double price, String size, int count, String image) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.sub_category = sub_category;
        this.price = price;
        this.size = size;
        this.count = count;
        this.image = image;
    }

    public Product(){


    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSub_category() {
        return sub_category;
    }

    public void setSub_category(String sub_category) {
        this.sub_category = sub_category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
