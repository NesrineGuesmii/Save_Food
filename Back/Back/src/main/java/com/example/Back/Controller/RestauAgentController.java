package com.example.Back.Controller;

import com.example.Back.Entities.Product;
import com.example.Back.Entities.RestauAgent;
import com.example.Back.ServicesImp.RestauAgentServiceImp;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restauAgents")
@AllArgsConstructor
public class RestauAgentController {
    private final RestauAgentServiceImp restauAgentServiceImp;

    @GetMapping("/all")
    public ResponseEntity<List<RestauAgent>> getAllRestauAgents(){
        List<RestauAgent> restauAgents = restauAgentServiceImp.getAllRestauAgents();
        return new ResponseEntity<>(restauAgents, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<RestauAgent> getRestauAgentById(@PathVariable("id") Long id){
        RestauAgent restauAgent = restauAgentServiceImp.getRestauAgentById(id);
        return new ResponseEntity<>(restauAgent, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<RestauAgent> addRestauAgent(@RequestBody RestauAgent restauAgent){
        RestauAgent newRestauAgent = restauAgentServiceImp.addRestauAgent(restauAgent);
        return new ResponseEntity<>(newRestauAgent, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<RestauAgent> updateRestauAgent(@RequestBody RestauAgent restauAgent){
        RestauAgent updateRestauAgent = restauAgentServiceImp.updateRestauAgent(restauAgent);
        return new ResponseEntity<>(updateRestauAgent, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteRestauAgent(@PathVariable("id") Long id){
        restauAgentServiceImp.deleteRestauAgent(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
