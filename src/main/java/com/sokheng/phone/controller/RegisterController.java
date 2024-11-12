package com.sokheng.phone.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sokheng.phone.model.Customer;
import com.sokheng.phone.model.ResponseMessage;
import com.sokheng.phone.service.CustomerService;

@Controller
public class RegisterController {

    private final CustomerService customerService;

    public RegisterController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/register")
    public String registerGet() {
        return "register";
    }

    @GetMapping("/register/success")
    public String registerSuccessGet() {
        return "register_success";
    }

    @PostMapping("/register")
    @ResponseBody
    public ResponseMessage registerPost(@RequestParam String username, @RequestParam String address,
            @RequestParam String phone_number, @RequestParam String password) {

        // Input validation
        if (username.isEmpty() || phone_number.isEmpty() || password.isEmpty()) {
            return new ResponseMessage("fail", "Username, phone number and password are required.");
        }

        // Check if the phone number is already registered
        List<Customer> existingCustomer = customerService.getCustomerByPhoneNumber(phone_number);
        if (existingCustomer.size() > 0) {
            return new ResponseMessage("fail", "This phone number is already registered.");
        }

        // Create and save the new customer
        Customer newCustomer = new Customer(username, address, phone_number, password);
        customerService.saveCustomer(newCustomer);

        return new ResponseMessage("success", "Registered successfully.");
    }

}
