package com.lambdaschool.crudyorders.services;

import com.lambdaschool.crudyorders.models.Order;
import com.lambdaschool.crudyorders.repositories.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

@Transactional
@Service(value = "orderService")
public class OrderServicesImpl implements OrderServices{

    @Autowired
    OrdersRepository orderrepos;

    @Override
    public Order findOrderById(long id) {
        return orderrepos.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Order " + id + " Not Found!"));
    }

    @Transactional
    @Override
    public Order save(Order order) {
        return orderrepos.save(order);
    }
}
