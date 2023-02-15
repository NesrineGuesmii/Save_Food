package com.example.Back.Services;

import com.example.Back.Entities.Commandes;
import com.example.Back.Entities.Product;

import java.util.List;
import java.util.concurrent.ConcurrentMap;

public interface CommandeService {
    List<Commandes> getAllCommandes();

    Commandes getCommandeById(Long id);

    Commandes addCommande(Commandes commandes);

    Commandes updateCommande(Commandes commandes);

    void deleteCommandes(Long id);
}
