package com.example.Back.Services;

import com.example.Back.Entities.RestauAgent;

import java.util.List;

public interface RestauAgentService {
    List<RestauAgent> getAllRestauAgents();

    RestauAgent getRestauAgentById(Long id);

    RestauAgent addRestauAgent(RestauAgent restauAgent);

    RestauAgent updateRestauAgent(RestauAgent restauAgent);

    void deleteRestauAgent(Long id);
}
