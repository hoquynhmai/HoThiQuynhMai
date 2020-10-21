package com.codegym.bai_1_quan_ly_khach_hang.service;

import com.codegym.bai_1_quan_ly_khach_hang.entity.Customer;
import com.codegym.bai_1_quan_ly_khach_hang.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImp implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<Customer> findAll() {
        return this.customerRepository.findAll();
    }

    @Override
    public Optional<Customer> findById(int id) {
        return this.customerRepository.findById(id);
    }

    @Override
    public void save(Customer customer) {
        this.customerRepository.save(customer);
    }

    @Override
    public void update(Customer customer) {
        this.customerRepository.save(customer);
    }

    @Override
    public void remove(int id) {
        this.customerRepository.deleteById(id);
    }

    @Override
    public void remove(String name) {
        List<Customer> customerList = this.customerRepository.findAllByNameContaining(name);
        this.customerRepository.deleteAll(customerList);
    }
}
