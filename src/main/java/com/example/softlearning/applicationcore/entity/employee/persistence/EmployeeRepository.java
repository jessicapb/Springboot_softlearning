package com.example.softlearning.applicationcore.entity.employee.persistence;

import java.util.List;
import java.util.Optional;

import com.example.softlearning.applicationcore.entity.employee.dtos.EmployeeDTO;

public interface EmployeeRepository {
    public Optional<EmployeeDTO> findByident(int ident);

    public List<EmployeeDTO> findByName(String name);

    public List<EmployeeDTO> findByPartialName(String name);

    public Integer countByPartialName(String name);

    public EmployeeDTO save (EmployeeDTO employee);

    public void deleteByIdent(int id);
}