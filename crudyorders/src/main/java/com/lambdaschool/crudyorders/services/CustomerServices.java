package com.lambdaschool.crudyorders.services;

import com.lambdaschool.crudyorders.models.Customer;
import com.lambdaschool.crudyorders.views.OrderCounts;

import java.util.List;

public interface CustomerServices {

    List<Customer> findAllCustomers();

    Customer findCustomerById(long id);

    List<Customer> findByNameLike(String subname);

    List<OrderCounts> countOrdersByCustomer();

    Customer save(Customer customer);
}
