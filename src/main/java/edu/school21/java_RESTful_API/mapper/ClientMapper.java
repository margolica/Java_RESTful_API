package edu.school21.java_RESTful_API.mapper;

import edu.school21.java_RESTful_API.dto.ClientDto;
import edu.school21.java_RESTful_API.model.Client;

import java.util.List;


public interface ClientMapper {

    Client toEntity(ClientDto clientDto);

    ClientDto toDTO(Client client);

    List<ClientDto> toDTOList(List<Client> clients);
}
