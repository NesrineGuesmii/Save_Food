package com.example.Back.ServicesImp;

import com.example.Back.Entities.Client;
import com.example.Back.Reposiroty.ClientRepository;
import com.example.Back.Services.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class ClientServiceImp implements ClientService {

    private final ClientRepository clientRepository;

    @Override
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    @Override
    public Client getClientById(Long id) {
        return clientRepository.findById(id).orElseThrow(()-> new NoSuchElementException("No client by ID: " + id));
    }

    @Override
    public Client addClient(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public Client updateClient(Client client) {
        if(!clientRepository.existsById(client.getPersonId())){
            throw new NoSuchElementException("No client With ID: " + client.getPersonId());
        }

        return clientRepository.save(client);
    }

    @Override
    public void deleteClient(Long id) {
        clientRepository.deleteById(id);
    }
}
