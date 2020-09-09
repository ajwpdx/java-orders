package com.lambdaschool.crudyorders.controllers;

import com.lambdaschool.crudyorders.models.Agent;
import com.lambdaschool.crudyorders.services.AgentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/agents")
public class AgentController {

    @Autowired
    AgentServices agentServices;

    // http://localhost:2019/agents/agent/10
    @GetMapping(value ="/agent/{id}", produces = "application/json")
    public ResponseEntity<?> findAgentById(long id)
    {
        Agent a = agentServices.findAgentById(id);
        return new ResponseEntity<>(a, HttpStatus.OK);
    }

}
