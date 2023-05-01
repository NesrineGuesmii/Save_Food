package com.example.Back.Reposiroty;

import com.example.Back.Entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
    Client findByEmail(String theEmail);

}
