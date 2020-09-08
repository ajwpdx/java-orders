package com.example.lambdaschool.javaorders.repositories;

import com.example.lambdaschool.javaorders.models.Payment;
import org.springframework.data.repository.CrudRepository;

public interface PaymentRepository extends CrudRepository<Payment, Long> {
}
