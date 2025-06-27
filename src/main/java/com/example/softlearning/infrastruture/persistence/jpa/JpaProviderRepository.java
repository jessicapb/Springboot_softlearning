package com.example.softlearning.infrastruture.persistence.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.softlearning.applicationcore.entity.provider.dtos.ProviderDTO;

import jakarta.transaction.Transactional;
@Repository
public interface JpaProviderRepository extends JpaRepository<ProviderDTO, Integer>{
    public Optional<ProviderDTO> findByident(int ident);

    public List<ProviderDTO> findByName(String name);

    @Query(value = "SELECT p FROM ProviderDTO p WHERE p.name LIKE %:name%")
    public List<ProviderDTO> findByPartialName(String name);

    @Query(value = "SELECT count(*) FROM ProviderDTO p WHERE p.name LIKE %:name%")
    public Integer countByPartialName(String name);

    @Transactional
    public ProviderDTO save(ProviderDTO provider);

    @Transactional
    public void deleteByident(int ident);
}