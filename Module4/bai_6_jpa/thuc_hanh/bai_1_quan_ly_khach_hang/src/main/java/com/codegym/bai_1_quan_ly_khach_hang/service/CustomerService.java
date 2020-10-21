package com.codegym.bai_1_quan_ly_khach_hang.service;

import com.codegym.bai_1_quan_ly_khach_hang.entity.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerService {
    List<Customer> findAll();

    Optional<Customer> findById(int id);

    void save(Customer customer);

    void update(Customer customer);

    void remove(int id);

    void remove(String name);
}
