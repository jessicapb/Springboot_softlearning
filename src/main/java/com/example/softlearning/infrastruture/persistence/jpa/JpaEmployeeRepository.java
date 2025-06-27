package com.example.softlearning.infrastruture.persistence.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.softlearning.applicationcore.entity.employee.persistence.EmployeeRepository;
import com.example.softlearning.applicationcore.entity.employee.dtos.EmployeeDTO;

import jakarta.transaction.Transactional;

@Repository
public interface JpaEmployeeRepository extends JpaRepository<EmployeeDTO, Integer>, EmployeeRepository {
    public Optional<EmployeeDTO> findByident(int ident);

    public List<EmployeeDTO> findByName(String name);

    @Query(value = "SELECT e FROM EmployeeDTO e WHERE e.name LIKE %:name%")
    public List<EmployeeDTO> findByPartialName(String name);

    @Query(value = "SELECT count(*) FROM EmployeeDTO e WHERE e.name LIKE %:name%")
    public Integer countByPartialName(String name);

    @Transactional
    public EmployeeDTO save (EmployeeDTO employee);

    @Transactional
    public void deleteByIdent(int ident);
}
