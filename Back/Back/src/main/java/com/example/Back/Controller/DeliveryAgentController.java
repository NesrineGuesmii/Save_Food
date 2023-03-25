package com.example.Back.Controller;

import com.example.Back.Entities.Commandes;
import com.example.Back.Entities.DeliveryAgent;
import com.example.Back.Reposiroty.DeliveryAgentRepository;
import com.example.Back.ServicesImp.DeliveryAgentServiceImp;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/deliveryAgents")
@AllArgsConstructor
public class DeliveryAgentController {

    private final DeliveryAgentServiceImp deliveryAgentServiceImp;
    private final DeliveryAgentRepository deliveryAgentRepository;

    @GetMapping("/all")
    public ResponseEntity<List<DeliveryAgent>> getAllDeliveryAgents(){
        List<DeliveryAgent> deliveryAgents = deliveryAgentServiceImp.getAllDeliveryAgents();
        return new ResponseEntity<>(deliveryAgents, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<DeliveryAgent> getDeliveryAgentById(@PathVariable("id") Long id){
        DeliveryAgent deliveryAgent = deliveryAgentServiceImp.getDeliveryAgentById(id);
        return new ResponseEntity<>(deliveryAgent, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<DeliveryAgent> addDeliveryAgent(@RequestBody DeliveryAgent deliveryAgent){
        DeliveryAgent newDeliveryAgent = deliveryAgentServiceImp.addDelliveryAgent(deliveryAgent);
        return new ResponseEntity<>(newDeliveryAgent, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<DeliveryAgent> updateDeliveryAgent(@RequestBody DeliveryAgent deliveryAgent){
        DeliveryAgent updateDeliveryAgenty = deliveryAgentServiceImp.updateDeliveryAgent(deliveryAgent);
        return new ResponseEntity<>(updateDeliveryAgenty, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteDeliveryAgent(@PathVariable("id") Long id){
        deliveryAgentServiceImp.deleteDeliveryAgent(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
