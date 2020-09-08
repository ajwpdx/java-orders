package com.example.lambdaschool.javaorders.repositories;

import com.example.lambdaschool.javaorders.models.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
}
