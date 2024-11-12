package com.sokheng.phone.model;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Customer {

    @Id
    private String id;
    private String name;
    private String address;
    private String phone_number;
    private String password;
    private String auth_token;

    public Customer() {
    }

    public Customer(String name, String address, String phone_number, String password) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.address = address;
        this.phone_number = phone_number;
        this.password = password;
        this.auth_token = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone_number() {
        return phone_number;
    }
    public void setPhone_number(String phoneNumber) {
        this.phone_number = phoneNumber;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public String getAuth() {
        return auth_token;
    }
    public void setAuth() {
        this.auth_token = UUID.randomUUID().toString();
    }
}
