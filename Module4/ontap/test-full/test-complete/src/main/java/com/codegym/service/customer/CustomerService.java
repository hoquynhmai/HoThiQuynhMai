package com.codegym.service.customer;

import com.codegym.entity.customer.Customer;
import com.codegym.entity.customer.CustomerType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CustomerService {
    List<Customer> findAll();

    Customer findById(String id);

    void deleteCustomer(String id);

    void save(Customer customer);

    void update(Customer customer);

    List<CustomerType> allCustomerType();


    // ----------------------- PAGING -------------------------------------
    Page<Customer> findAll(Pageable pageable);


    // --------------------------- SORT -------------------------------------
    Page<Customer> findAllAndSortByID(Pageable pageable);

    Page<Customer> findAllAndSortByName(Pageable pageable);

    Page<Customer> findAllAndSortByBirthDay(Pageable pageable);


    // -------------------------------SEARCH ------------------------------------
    Page<Customer> findByNameContaining(Pageable pageable, String name);

    Page<Customer> findByAddressContaining(Pageable pageable, String address);

    Page<Customer> findByNameAndAddressContaining(Pageable pageable, String name, String address);

    Page<Customer> findAllOfMe(Pageable pageable, String all);


    // -------------------------------- AJAX -----------------------------------------
    List<Customer> findByNameContainingAjax(String name);

    List<Customer> findAllScroll(int start, int limit);
}
