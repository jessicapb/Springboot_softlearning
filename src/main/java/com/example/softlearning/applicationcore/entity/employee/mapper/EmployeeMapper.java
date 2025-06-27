package com.example.softlearning.applicationcore.entity.employee.mapper;

import com.example.softlearning.applicationcore.entity.employee.dtos.EmployeeDTO;
import com.example.softlearning.applicationcore.entity.employee.model.Employee;
import com.example.softlearning.applicationcore.entity.sharedkernel.model.exceptions.BuildException;

public class EmployeeMapper {
    public static Employee employeeFromDTO(EmployeeDTO edto) throws BuildException{
        return Employee.getInstanceEmployee(
            edto.getName(), 
            edto.getSurname(), 
            edto.getEmail(), 
            edto.getNumber(), 
            edto.getAddress(), 
            edto.getAntiquity(), 
            edto.getIdent(), 
            edto.getDepartment(), 
            edto.getSchedule(), 
            edto.getBankaccount()
        );
    }

    public static EmployeeDTO dtoFromEmployee(Employee e){
        return new EmployeeDTO(
            e.getName(),
            e.getSurname(),
            e.getEmail(),
            e.getNumber(),
            e.getAddress(),
            e.getAntiquity(),
            e.getIdent(),
            e.getDepartment(),
            e.getSchedule(),
            e.getBackaccount()
        );
    }
}
