package com.lambdaschool.crudyorders.services;


import com.lambdaschool.crudyorders.models.Customer;

import com.lambdaschool.crudyorders.repositories.CustomersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service(value = "customerServices")
public class CustomerServicesImpl
        implements CustomerServices {

    @Autowired
    CustomersRepository customerrepos;

    @Transactional
    @Override
    public Customer save(Customer customer) { return customerrepos.save(customer);}
}