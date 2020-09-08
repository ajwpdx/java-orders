package com.lambdaschool.crudyorders.repositories;

import com.lambdaschool.crudyorders.models.Payment;
import org.springframework.data.repository.CrudRepository;

public interface PaymentsRepository extends CrudRepository<Payment, Long> {
}
