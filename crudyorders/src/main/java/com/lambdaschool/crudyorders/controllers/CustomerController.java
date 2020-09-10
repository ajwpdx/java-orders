package com.lambdaschool.crudyorders.controllers;

import com.lambdaschool.crudyorders.models.Customer;
import com.lambdaschool.crudyorders.models.Order;
import com.lambdaschool.crudyorders.services.CustomerServices;
import com.lambdaschool.crudyorders.views.OrderCounts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController
{
    @Autowired
    CustomerServices customerServices;

    // GET http://localhost:2019/customers/orders
    @GetMapping(value = "/orders", produces = "application/json")
    public ResponseEntity<?> listAllCustomers()
    {
        List<Customer> myList = customerServices.findAllCustomers();
        return new ResponseEntity<>(myList, HttpStatus.OK);
    }

    // GET http://localhost:2019/customers/customer/10
    @GetMapping(value= "/customer/{id}", produces = "application/json")
    public ResponseEntity<?> findCustomerById(@PathVariable long id)
    {
        Customer c = customerServices.findCustomerById(id);
        return new ResponseEntity<>(c, HttpStatus.OK);
    }

    // GET http://localhost:2019/customers/namelike/hol
    @GetMapping(value = "namelike/{subname}", produces = "application/json")
    public ResponseEntity<?> findCustomerByNameLike(@PathVariable String subname)
    {
        List<Customer> rtnList = customerServices.findByNameLike(subname);
        return new ResponseEntity<>(rtnList, HttpStatus.OK);
    }


    // GET http://localhost:2019/customers/orders/count
    @GetMapping(value = "orders/count", produces = "application/json")
    public ResponseEntity<?> countCustomerOrders()
    {
        List<OrderCounts> rtnList = customerServices.countOrdersByCustomer();
        return new ResponseEntity<>(rtnList, HttpStatus.OK);
    }

    // POST http://localhost:2019/customers/customer/
    @PostMapping(value = "/customer", consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> addCustomer(@Valid @RequestBody Customer newCustomer)
    {
        newCustomer.setCustcode(0);
        newCustomer = customerServices.save(newCustomer); //returning the id
        HttpHeaders responseHeaders = new HttpHeaders();
        URI newCustomerURI = ServletUriComponentsBuilder.fromCurrentRequest().path("/{custcode}").buildAndExpand(newCustomer.getCustcode()).toUri();
        responseHeaders.setLocation(newCustomerURI);
        return new ResponseEntity<>(newCustomer, responseHeaders, HttpStatus.CREATED); // data, header, status
    }

    // PUT http://localhost:2019/customers/customer/10
    @PutMapping(value = "/customer/{custcode}", consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> updateFullCustomer(@PathVariable long custcode, @Valid @RequestBody Customer updatedCustomer)
    {
        updatedCustomer.setCustcode(custcode);
        updatedCustomer = customerServices.save(updatedCustomer); //validating our customer

        return new ResponseEntity<>(updatedCustomer, HttpStatus.OK);
    }
    // PATCH  http://localhost:2019/customers/customer/10
    @PatchMapping(value = "/customer/{custcode}", consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> updatePartCustomer(@PathVariable long custcode, @RequestBody Customer updatedCustomer)
    {
        updatedCustomer = customerServices.update(updatedCustomer, custcode);
        return new ResponseEntity<>(updatedCustomer, HttpStatus.OK);
    }

    // DELETE http://localhost:2019/customers/customer/54
    @DeleteMapping(value = "/customer/{custcode}")
    public ResponseEntity<?> deleteCustomerById(@PathVariable long custcode)
    {
        customerServices.delete(custcode);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
