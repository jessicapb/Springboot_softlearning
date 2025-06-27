package com.example.softlearning.infrastruture.persistence.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.softlearning.applicationcore.entity.client.dtos.ClientsDTO;
import com.example.softlearning.applicationcore.entity.client.persistence.ClientRepository;

import jakarta.transaction.Transactional;

@Repository
public interface JpaClientRepository extends JpaRepository<ClientsDTO, Integer>, ClientRepository{
    public Optional<ClientsDTO> findByident(int ident);

    public List<ClientsDTO> findByName(String name);

    @Query(value = "SELECT c FROM ClientsDTO c WHERE c.name LIKE %:name%")
    public List<ClientsDTO> findByPartialName(String name);
    
    @Query(value = "SELECT count(*) FROM ClientsDTO c WHERE c.name LIKE %:name%")
    public Integer countByPartialName(String name);

    @Transactional
    public ClientsDTO save (ClientsDTO client);

    @Transactional
    public void deleteByIdent(int ident);
}
