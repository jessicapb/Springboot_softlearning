package com.example.softlearning.applicationcore.entity.client.mappers;

import com.example.softlearning.applicationcore.entity.client.dtos.ClientsDTO;
import com.example.softlearning.applicationcore.entity.client.model.Client;
import com.example.softlearning.applicationcore.entity.sharedkernel.model.exceptions.BuildException;

public class ClientMapper {
    public static Client clientFromDTO(ClientsDTO cdto) throws BuildException{
        return Client.getInstanceClient(
            cdto.getName(), 
            cdto.getSurname(), 
            cdto.getEmail(), 
            cdto.getNumber(),
            cdto.getAddress(),
            cdto.getAntiquity(), 
            cdto.getIdent(),
            cdto.getPaymentcode()
        );
    }

    public static ClientsDTO dtoFromClient(Client c){
        return new ClientsDTO(
            c.getName(), 
            c.getSurname(), 
            c.getEmail(), 
            c.getNumber(),
            c.getAddress(),
            c.getAntiquity(), 
            c.getIdent(),
            c.getPaymentcode()            
        );
    }
}
