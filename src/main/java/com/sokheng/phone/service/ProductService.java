package com.sokheng.phone.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sokheng.phone.model.Product;
import com.sokheng.phone.repository.ProductRepository;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void saveProduct(Product Product) {
        productRepository.save(Product);
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Optional<Product> getProductById(String id) {
        return productRepository.findById(id);
    }

    public List<Product> getProductByBrand(String brand_name) {
        return productRepository.findByBrandName(brand_name);
    }

    public void deleteCustomer(String id) {
        productRepository.deleteById(id);
    }

}
