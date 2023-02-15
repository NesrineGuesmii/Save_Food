package com.example.Back.ServicesImp;

import com.example.Back.Entities.Commandes;
import com.example.Back.Reposiroty.CommandeRepository;
import com.example.Back.Services.CommandeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class CommandeServiceImp implements CommandeService {

    private final CommandeRepository commandeRepository;

    @Override
    public List<Commandes> getAllCommandes() {
        return commandeRepository.findAll();
    }

    @Override
    public Commandes getCommandeById(Long id) {
        return commandeRepository.findById(id).orElseThrow(()-> new NoSuchElementException("No commande by ID: " + id));
    }

    @Override
    public Commandes addCommande(Commandes commandes) {
        return commandeRepository.save(commandes);
    }

    @Override
    public Commandes updateCommande(Commandes commandes) {
        if(!commandeRepository.existsById(commandes.getId())){
            throw new NoSuchElementException("No commande With ID: " + commandes.getId());
        }

        return commandeRepository.save(commandes);
    }

    @Override
    public void deleteCommandes(Long id) {
        commandeRepository.deleteById(id);
    }
}
