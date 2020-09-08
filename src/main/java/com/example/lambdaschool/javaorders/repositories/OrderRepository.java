package com.example.lambdaschool.javaorders.repositories;

import com.example.lambdaschool.javaorders.models.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Long> {
}
