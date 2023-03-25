package com.example.Back.Services;

import com.example.Back.Entities.DeliveryAgent;


import java.util.List;

public interface DeliveryAgentService {
    List<DeliveryAgent> getAllDeliveryAgents();

    DeliveryAgent getDeliveryAgentById(Long id);

    DeliveryAgent addDelliveryAgent(DeliveryAgent deliveryAgent);

    DeliveryAgent updateDeliveryAgent(DeliveryAgent deliveryAgent);

    void deleteDeliveryAgent(Long id);
}
