package com.lambdaschool.crudyorders.services;

import com.lambdaschool.crudyorders.models.Agent;

public interface AgentServices
{

    Agent findAgentById(long id);

    Agent save(Agent agent);
}