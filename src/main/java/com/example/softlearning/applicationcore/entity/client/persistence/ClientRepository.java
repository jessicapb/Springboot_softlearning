package com.example.softlearning.applicationcore.entity.client.persistence;

import java.util.List;
import java.util.Optional;

import com.example.softlearning.applicationcore.entity.client.dtos.ClientsDTO;

public interface ClientRepository {
    public Optional<ClientsDTO> findByident(int ident);

    public List<ClientsDTO> findByName(String name);

    public List<ClientsDTO> findByPartialName(String name);

    public Integer countByPartialName(String name);

    public ClientsDTO save (ClientsDTO client);

    public void deleteByIdent(int id);
}
