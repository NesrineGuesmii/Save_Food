package com.example.Back.ServicesImp;

import com.example.Back.Entities.DeliveryAgent;
import com.example.Back.Reposiroty.DeliveryAgentRepository;
import com.example.Back.Services.DeliveryAgentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class DeliveryAgentServiceImp implements DeliveryAgentService {

    private final DeliveryAgentRepository deliveryAgentRepository;

    @Override
    public List<DeliveryAgent> getAllDeliveryAgents() {
        return deliveryAgentRepository.findAll();
    }

    @Override
    public DeliveryAgent getDeliveryAgentById(Long id) {
        return deliveryAgentRepository.findById(id).orElseThrow(()-> new NoSuchElementException("No Agent by ID: " + id));
    }

    @Override
    public DeliveryAgent addDelliveryAgent(DeliveryAgent deliveryAgent) {
        return deliveryAgentRepository.save(deliveryAgent);
    }

    @Override
    public DeliveryAgent updateDeliveryAgent(DeliveryAgent deliveryAgent) {
        if(!deliveryAgentRepository.existsById(deliveryAgent.getPersonId())){
            throw new NoSuchElementException("No agent With ID: " + deliveryAgent.getPersonId());
        }

        return deliveryAgentRepository.save(deliveryAgent);
    }

    @Override
    public void deleteDeliveryAgent(Long id) {
        deliveryAgentRepository.deleteById(id);
    }
}
