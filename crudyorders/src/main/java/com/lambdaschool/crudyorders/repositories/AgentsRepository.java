package com.lambdaschool.crudyorders.repositories;


import com.lambdaschool.crudyorders.models.Agent;
import org.springframework.data.repository.CrudRepository;

public interface AgentsRepository extends CrudRepository<Agent, Long> {
}
