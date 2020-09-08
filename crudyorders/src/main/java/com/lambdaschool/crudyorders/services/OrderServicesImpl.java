package com.lambdaschool.crudyorders.services;

import com.lambdaschool.crudyorders.models.Order;
import com.lambdaschool.crudyorders.repositories.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service(value = "orderService")
public class OrderServicesImpl implements OrderServices{

    @Autowired
    OrdersRepository orderrepos;

    @Transactional

    @Override
    public Order save(Order order) {
        return orderrepos.save(order);
    }
}
