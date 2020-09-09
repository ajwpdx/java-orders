package com.lambdaschool.crudyorders.controllers;

import com.lambdaschool.crudyorders.models.Customer;
import com.lambdaschool.crudyorders.models.Order;
import com.lambdaschool.crudyorders.services.CustomerServices;
import com.lambdaschool.crudyorders.views.OrderCounts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController
{
    @Autowired
    CustomerServices customerServices;

    // http://localhost:2019/customers/orders
    @GetMapping(value = "/orders", produces = "application/json")
    public ResponseEntity<?> listAllCustomers()
    {
        List<Customer> myList = customerServices.findAllCustomers();
        return new ResponseEntity<>(myList, HttpStatus.OK);
    }

    // http://localhost:2019/customers/customer/10
    @GetMapping(value= "/customer/{id}", produces = "application/json")
    public ResponseEntity<?> findCustomerById(@PathVariable long id)
    {
        Customer c = customerServices.findCustomerById(id);
        return new ResponseEntity<>(c, HttpStatus.OK);
    }

    // http://localhost:2019/customers/namelike/hol
    @GetMapping(value = "namelike/{subname}", produces = "application/json")
    public ResponseEntity<?> findCustomerByNameLike(@PathVariable String subname)
    {
        List<Customer> rtnList = customerServices.findByNameLike(subname);
        return new ResponseEntity<>(rtnList, HttpStatus.OK);
    }


    // http://localhost:2019/customers/orders/count
    @GetMapping(value = "orders/count", produces = "application/json")
    public ResponseEntity<?> countCustomerOrders()
    {
        List<OrderCounts> rtnList = customerServices.countOrdersByCustomer();
        return new ResponseEntity<>(rtnList, HttpStatus.OK);
    }

}
