package edu.school21.java_RESTful_API.controller;

import edu.school21.java_RESTful_API.controller.description.ClientApi;
import edu.school21.java_RESTful_API.dto.AddressDto;
import edu.school21.java_RESTful_API.dto.ClientDto;
import edu.school21.java_RESTful_API.mapper.AddressMapper;
import edu.school21.java_RESTful_API.mapper.ClientMapper;
import edu.school21.java_RESTful_API.model.Client;
import edu.school21.java_RESTful_API.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/clients")
@Transactional(readOnly = true)
public class ClientController implements ClientApi {

    private final ClientService clientService;
    private final ClientMapper clientMapper;
    private final AddressMapper addressMapper;

    @Autowired
    public ClientController(ClientService clientService, ClientMapper clientMapper, AddressMapper addressMapper) {
        this.clientService = clientService;
        this.clientMapper = clientMapper;
        this.addressMapper = addressMapper;
    }

    @Override
    public ResponseEntity<List<ClientDto>> getAllClientsWithLimitOffset(int limit, int offset) {
        List<ClientDto> listClientDto = clientMapper.toDTOList(clientService.getAll(limit, offset));
        return ResponseEntity.ok(listClientDto);
    }

    @Override
    public ResponseEntity<List<ClientDto>> getAllClients() {
        List<ClientDto> listClientDto = clientMapper.toDTOList(clientService.getAll());
        return ResponseEntity.ok(listClientDto);
    }

    @Override
    public ResponseEntity<ClientDto> getClientById(Long id) {
        return clientService.getById(id)
                .map(client -> ResponseEntity.ok(clientMapper.toDTO(client)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Override
    @Transactional
    public ResponseEntity<String> create(ClientDto clientDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return new ResponseEntity<>("Address or Client not valid", HttpStatus.BAD_REQUEST);

        Client newClient = clientService.save(clientMapper.toEntity(clientDto), addressMapper.toEntity(clientDto.getAddressDto()));
        if (newClient == null)
            return new ResponseEntity<>("Не удалось создать клиента", HttpStatus.BAD_REQUEST);
        else {
            URI locationNewClient = URI.create("http://localhost:8082/api/v1/clients/" + newClient.getId());
            return ResponseEntity.created(locationNewClient).build();
        }
    }

    @Override
    @Transactional
        public ResponseEntity<String> updateAddressFromClientById(Long id, AddressDto addressDto, BindingResult bindingResult) {
            if (bindingResult.hasErrors())
                return new ResponseEntity<>("Address not valid", HttpStatus.BAD_REQUEST);

            if (getClientById(id).getStatusCode() != HttpStatus.OK)
                return new ResponseEntity<>("Client not found", HttpStatus.NOT_FOUND);

            clientService.update(id, addressMapper.toEntity(addressDto));

            Optional<Client> updatedClientOptional = clientService.getById(id);
            if (updatedClientOptional.isPresent() &&
                    !addressMapper.toDTO(updatedClientOptional.get().getAddress()).equals(addressDto))
                return ResponseEntity.badRequest().body("Failed to update address");
            return ResponseEntity.ok("Address updated successfully");
        }

    @Override
    @Transactional
    public ResponseEntity<Void> delete(Long id) {
        if (clientService.delete(id))
            return ResponseEntity.noContent().build();
        else
            return ResponseEntity.notFound().build();
    }
}