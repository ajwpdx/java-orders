package com.lambdaschool.crudyorders.services;


import com.lambdaschool.crudyorders.models.Customer;

import com.lambdaschool.crudyorders.repositories.CustomersRepository;
import com.lambdaschool.crudyorders.views.OrderCounts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Service(value = "customerServices")
public class CustomerServicesImpl implements CustomerServices {

    @Autowired
    CustomersRepository customerrepos;

    @Override
    public List<Customer> findAllCustomers() {
        List<Customer> list = new ArrayList<>();
        customerrepos.findAll().iterator().forEachRemaining(list::add);
        return list;
    }

    @Override
    public Customer findCustomerById(long id) {
        return customerrepos.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Customer " + id + " Not Found!"));
    }

    @Override
    public List<Customer> findByNameLike(String subname) {
        List<Customer> list = customerrepos.findByCustnameContainingIgnoreCase (subname);
        return list;
    }

    @Override
    public List<OrderCounts> countOrdersByCustomer() {
        List<OrderCounts> list = customerrepos.findOrderCounts();
        return null;
    }

    @Transactional
    @Override
    public Customer save(Customer customer) { return customerrepos.save(customer);}
}