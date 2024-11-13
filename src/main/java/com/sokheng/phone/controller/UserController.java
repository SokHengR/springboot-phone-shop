package com.sokheng.phone.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sokheng.phone.model.Customer;
import com.sokheng.phone.service.CustomerService;

@Controller
public class UserController {

    private final CustomerService customerService;

    public UserController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/user")
    public String userGet() {
        return "user";
    }

    @PostMapping("/user")
    @ResponseBody
    public List<Customer> userPost(@RequestParam String auth_token) {
        // Remove surrounding quotes if present
        if (auth_token.startsWith("\"") && auth_token.endsWith("\"")) {
            auth_token = auth_token.substring(1, auth_token.length() - 1);
        }
    
        System.out.println(">> " + auth_token); // Should print without quotes
        return customerService.getCustomerByToken(auth_token);
    }    
}
