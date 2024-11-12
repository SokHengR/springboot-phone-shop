package com.sokheng.phone.repository;

import com.sokheng.phone.model.Customer;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CustomerRepository extends JpaRepository<Customer, String> {

    @Query("SELECT c FROM Customer c WHERE c.phone_number = :phone_number AND c.password = :password")
    Optional<Customer> authCustomer(@Param("phone_number") String phone_number, @Param("password") String password);

    @Query("SELECT c FROM Customer c WHERE c.phone_number = :phone_number")
    List<Customer> findByPhoneNumber(@Param("phone_number") String phone_number);
}