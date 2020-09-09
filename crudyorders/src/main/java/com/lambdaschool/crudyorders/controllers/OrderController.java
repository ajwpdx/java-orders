package com.lambdaschool.crudyorders.controllers;

import com.lambdaschool.crudyorders.models.Order;
import com.lambdaschool.crudyorders.services.OrderServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    OrderServices orderServices;

    //http://localhost:2019/orders/order/7
    @GetMapping(value = "/order/{id}", produces = "application/json")
    public ResponseEntity<?> findOrderById(@PathVariable long id)
    {
        Order o = orderServices.findOrderById(id);
        return new ResponseEntity<>(o, HttpStatus.OK);
    }


}
