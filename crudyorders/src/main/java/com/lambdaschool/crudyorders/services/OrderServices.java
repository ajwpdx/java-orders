package com.lambdaschool.crudyorders.services;

import com.lambdaschool.crudyorders.models.Order;

public interface OrderServices {


    Order findOrderById(long id);

    Order save(Order order);

    void delete(long ordnum);

}
