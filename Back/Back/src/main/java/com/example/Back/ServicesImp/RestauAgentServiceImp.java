package com.example.Back.ServicesImp;

import com.example.Back.Entities.RestauAgent;
import com.example.Back.Reposiroty.RestauAgentRepository;
import com.example.Back.Services.RestauAgentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class RestauAgentServiceImp implements RestauAgentService {

    private final RestauAgentRepository restauAgentRepository;

    @Override
    public List<RestauAgent> getAllRestauAgents() {
        return restauAgentRepository.findAll();   }

    @Override
    public RestauAgent getRestauAgentById(Long id) {
        return restauAgentRepository.findById(id).orElseThrow(()->new NoSuchElementException("No Agent by this ID: " + id ));
    }

    @Override
    public RestauAgent addRestauAgent(RestauAgent restauAgent) {
        return restauAgentRepository.save(restauAgent);
    }

    @Override
    public RestauAgent updateRestauAgent(RestauAgent restauAgent) {
        if(!restauAgentRepository.existsById(restauAgent.getPersonId())){
            throw new NoSuchElementException("No RestauAgent With ID: " + restauAgent.getPersonId());
        }

        return restauAgentRepository.save(restauAgent);
    }

    @Override
    public void deleteRestauAgent(Long id) {
        restauAgentRepository.deleteById(id);
    }
}
