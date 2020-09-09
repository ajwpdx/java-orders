package com.lambdaschool.crudyorders.services;

import com.lambdaschool.crudyorders.models.Customer;

import java.util.List;

public interface CustomerServices {

    List<Customer> findAllCustomers();

    Customer findCustomerById(long id);

    List<Customer> findByNameLike(String subname);

    Customer save(Customer customer);
}
