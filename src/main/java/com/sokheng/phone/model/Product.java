package com.sokheng.phone.model;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Product {

    @Id
    private String id;
    private String name;
    private double price;
    private int in_stock;
    private String brand_name;
    private String detail;
    private int star_count;

    public Product() {
    }

    public Product(String name, double price, int in_stock, String brand_name, String detail, int star_count) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.price = price;
        this.in_stock = in_stock;
        this.brand_name = brand_name;
        this.detail = detail;
        this.star_count = star_count;
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getIn_stock() {
        return in_stock;
    }

    public void setIn_stock(int in_stock) {
        this.in_stock = in_stock;
    }

    public String getBrand_name() {
        return brand_name;
    }

    public void setBrand_name(String brand_name) {
        this.brand_name = brand_name;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public int getStar_count() {
        return star_count;
    }

    public void setStar_count(int star_count) {
        this.star_count = star_count;
    }

}
