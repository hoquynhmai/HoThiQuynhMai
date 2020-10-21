package com.codegym.bai_1_quan_ly_khach_hang.repository;

import com.codegym.bai_1_quan_ly_khach_hang.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    List<Customer> findAllByNameContaining(String name);
}
