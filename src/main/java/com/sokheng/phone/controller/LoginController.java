package com.sokheng.phone.controller;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sokheng.phone.model.Customer;
import com.sokheng.phone.model.ResponseMessage;
import com.sokheng.phone.service.CustomerService;

@Controller
public class LoginController {

    private final CustomerService customerService;

    public LoginController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/login")
    public String loginGet() {
        return "login";
    }

    @PostMapping("/login")
    @ResponseBody
    public ResponseMessage loginPost(@RequestParam String phone_number, @RequestParam String password) {
        Optional<Customer> authedCustomer = customerService.authCustomer(phone_number, password);

        if (authedCustomer.isPresent()) {
            Customer customer = authedCustomer.get();
            customer.setAuth();

            return new ResponseMessage("success", customer.getAuth());
        } else {
            return new ResponseMessage("fail", "Incorrect phone number or password.");
        }
    }

}
