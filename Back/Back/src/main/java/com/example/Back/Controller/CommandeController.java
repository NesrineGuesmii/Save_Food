package com.example.Back.Controller;

import com.example.Back.Entities.Commandes;
import com.example.Back.Entities.Product;
import com.example.Back.ServicesImp.CommandeServiceImp;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/commandes")
@AllArgsConstructor
public class CommandeController {
    private final CommandeServiceImp commandeServiceImp;

    @GetMapping("/all")
    public ResponseEntity<List<Commandes>> getAllCommandes(){
        List<Commandes> commandes = commandeServiceImp.getAllCommandes();
        return new ResponseEntity<>(commandes, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Commandes> getCommandesById(@PathVariable("id") Long id){
        Commandes commande = commandeServiceImp.getCommandeById(id);
        return new ResponseEntity<>(commande, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Commandes> addCommande(@RequestBody Commandes commandes){
        Commandes newCommande = commandeServiceImp.addCommande(commandes);
        return new ResponseEntity<>(newCommande, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Commandes> updateCommande(@RequestBody Commandes commandes){
        Commandes updateCommande = commandeServiceImp.updateCommande(commandes);
        return new ResponseEntity<>(updateCommande, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteCommande(@PathVariable("id") Long id){
        commandeServiceImp.deleteCommandes(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
