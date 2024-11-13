package com.sokheng.phone.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sokheng.phone.model.Product;
import com.sokheng.phone.service.ProductService;

@Controller
public class HomeController {

    private final ProductService productService;

    public HomeController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/")
    public String indexGet() {
        return "index";
    }

    @GetMapping("/home")
    public String homeGet() {
        return "home";
    }

    @PostMapping("/home")
    @ResponseBody
    public List<Product> homePost() {
        return productService.getAllProducts();
    }

}
