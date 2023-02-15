package com.example.Back.Reposiroty;

import com.example.Back.Entities.Commandes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommandeRepository extends JpaRepository<Commandes, Long> {
}
