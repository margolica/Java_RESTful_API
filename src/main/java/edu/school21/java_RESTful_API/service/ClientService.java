package edu.school21.java_RESTful_API.service;

import edu.school21.java_RESTful_API.model.Address;
import edu.school21.java_RESTful_API.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import edu.school21.java_RESTful_API.repository.ClientRepository;


import java.util.List;
import java.util.Optional;

@Service
public class ClientService  {

    private final ClientRepository clientRepository;
    private final AddressService addressService;

    @Autowired
    public ClientService(ClientRepository clientRepository,@Lazy AddressService addressService) {
        this.clientRepository = clientRepository;
        this.addressService = addressService;
    }

    public Optional<Client> getById(Long id) {
        return clientRepository.findById(id);
    }

    public Client save(Client client, Address address) {
        address.setClient(client);
        client.setAddress(address);
        return clientRepository.save(client);
    }

    public void update(Long id, Address address) {
        addressService.update(getById(id).get().getAddress().getId(), address);
    }

    public List<Client> getAll(int limit, int offset) {
        return clientRepository.findAll().subList(offset, limit);
    }

    public List<Client> getAll() {
        return clientRepository.findAll();
    }

    public boolean delete(Long id) {
        Optional<Client> client = clientRepository.findById(id);
        if (client.isPresent()) {
            clientRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
