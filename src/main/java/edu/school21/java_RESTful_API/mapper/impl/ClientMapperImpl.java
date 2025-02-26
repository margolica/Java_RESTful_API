package edu.school21.java_RESTful_API.mapper.impl;

import edu.school21.java_RESTful_API.dto.ClientDto;
import edu.school21.java_RESTful_API.mapper.AddressMapper;
import edu.school21.java_RESTful_API.mapper.ClientMapper;
import edu.school21.java_RESTful_API.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ClientMapperImpl implements ClientMapper {

    @Autowired
    AddressMapper addressMapper;

    @Override
    public Client toEntity(ClientDto clientDto) {
        if ( clientDto == null ) {
            return null;
        }

        Client.ClientBuilder client = Client.builder();

        client.firstName( clientDto.getFirstName() );
        client.lastName( clientDto.getLastName() );
        client.birthday(clientDto.getBirthday());
        client.gender( clientDto.getGender() );
        client.registrationDate(clientDto.getRegistrationDate());

        client.address(addressMapper.toEntity(clientDto.getAddressDto()));

        return client.build();
    }

    @Override
    public ClientDto toDTO(Client client) {
        if ( client == null ) {
            return null;
        }

        ClientDto clientDto = new ClientDto();

        clientDto.setFirstName(client.getFirstName());
        clientDto.setLastName(client.getLastName());
        clientDto.setBirthday(client.getBirthday());
        clientDto.setGender(client.getGender());
        clientDto.setRegistrationDate(client.getRegistrationDate());

        clientDto.setAddressDto(addressMapper.toDTO(client.getAddress()));

        return clientDto;
    }

    @Override
    public List<ClientDto> toDTOList(List<Client> clients) {
        if ( clients == null ) {
            return null;
        }

        List<ClientDto> list = new ArrayList<ClientDto>( clients.size() );
        for ( Client client : clients ) {
            list.add( toDTO( client ) );
        }

        return list;
    }
}
