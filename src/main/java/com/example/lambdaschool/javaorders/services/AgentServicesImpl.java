package com.example.lambdaschool.javaorders.services;

import com.example.lambdaschool.javaorders.models.Agent;
import com.example.lambdaschool.javaorders.repositories.AgentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Transactional
@Service(value = "agentService")
public interface AgentServicesImpl implements AgentServices {

    @Autowired
    AgentRepository agentrepos;

    @Transactional
    @Override
    public Agent save(Agent agent) { return agentrepos.save(agent)}
}
