package com.codegym.service.customer.impl;

import com.codegym.entity.customer.Customer;
import com.codegym.entity.customer.TypeCustomer;
import com.codegym.repository.customer.CustomerRepository;
import com.codegym.repository.customer.TypeCustomerRepository;
import com.codegym.service.customer.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository xRepository;

    @Autowired
    private TypeCustomerRepository typeCustomerRepository;

    @Override
    public List<Customer> findAll() {
        return this.xRepository.findAll();
    }

    @Override
    public Page<Customer> findAll(Pageable pageable) {
        return this.xRepository.findAll(pageable);
    }

    @Override
    public Customer findById(String id) {
        return this.xRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Customer customer) {
        this.xRepository.save(customer);
    }

    @Override
    public void update(Customer customer) {
        this.xRepository.save(customer);
    }

    @Override
    public void remove(String id) {
        this.xRepository.deleteById(id);
    }

    @Override
    public List<TypeCustomer> findAllTypeCustomer() {
        return this.typeCustomerRepository.findAll();
    }

    @Override
    public Page<Customer> findByNameContaining(Pageable pageable, String name) {
        return this.xRepository.findByNameContaining(pageable, name);
    }
}
