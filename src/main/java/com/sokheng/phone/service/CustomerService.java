package com.sokheng.phone.service;

import org.springframework.stereotype.Service;

import com.sokheng.phone.model.Customer;
import com.sokheng.phone.repository.CustomerRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void saveCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    public List<Customer> getAllCustomer() {
        return customerRepository.findAll();
    }

    public Optional<Customer> getCustomerById(String id) {
        return customerRepository.findById(id);
    }

    public List<Customer> getCustomerByToken(String auth_token) {
        System.out.println(">> auth: " + auth_token);
        return customerRepository.findByAuthToken(auth_token);
    }

    public List<Customer> getCustomerByPhoneNumber(String phone_number) {
        return customerRepository.findByPhoneNumber(phone_number);
    }

    public void deleteCustomer(String id) {
        customerRepository.deleteById(id);
    }

    public Optional<Customer> authCustomer(String phoneNumber, String password) {
        return customerRepository.authCustomer(phoneNumber, password);
    }
}
