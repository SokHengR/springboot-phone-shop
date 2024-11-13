package com.sokheng.phone.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sokheng.phone.model.Product;

public interface ProductRepository extends JpaRepository<Product, String> {

    @Query("SELECT p FROM Product p WHERE LOWER(p.brand_name) = LOWER(:brand_name)")
    List<Product> findByBrandName(@Param("brand_name") String brand_name);

}