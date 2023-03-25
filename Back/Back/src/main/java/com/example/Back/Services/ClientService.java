package com.example.Back.Services;

import com.example.Back.Entities.Client;

import java.util.List;

public interface ClientService {
    List<Client> getAllClients();

    Client getClientById(Long id);

    Client addClient(Client client);

    Client updateClient(Client client);

    void deleteClient(Long id);
}
