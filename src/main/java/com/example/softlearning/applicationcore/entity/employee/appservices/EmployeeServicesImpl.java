package com.example.softlearning.applicationcore.entity.employee.appservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.example.softlearning.applicationcore.entity.employee.dtos.EmployeeDTO;
import com.example.softlearning.applicationcore.entity.employee.mapper.EmployeeMapper;
import com.example.softlearning.applicationcore.entity.employee.persistence.EmployeeRepository;
import com.example.softlearning.applicationcore.entity.sharedkernel.appservices.serializers.Serializer;
import com.example.softlearning.applicationcore.entity.sharedkernel.appservices.serializers.Serializers;
import com.example.softlearning.applicationcore.entity.sharedkernel.appservices.serializers.SerializersCatalog;
import com.example.softlearning.applicationcore.entity.sharedkernel.model.exceptions.BuildException;
import com.example.softlearning.applicationcore.entity.sharedkernel.model.exceptions.ServiceException;

@Controller
public class EmployeeServicesImpl implements EmployeeServices{
    @Autowired
    private EmployeeRepository employeeRepository;
    private Serializer<EmployeeDTO> serializer;

    // Serveis per el llibre
    protected EmployeeDTO getDTO(int ident){
        return employeeRepository.findByident(ident).orElse(null);
    }

    protected EmployeeDTO getByIdent(int ident)throws ServiceException{
        EmployeeDTO edto = this.getDTO(ident);
        if(edto == null){
            throw new ServiceException("employee " + ident + " not found");
        }
        return edto;
    }

    protected EmployeeDTO checkInputData(String employee)throws ServiceException{
        try{
            EmployeeDTO edto = (EmployeeDTO) this.serializer.desearialize(employee, EmployeeDTO.class);
            EmployeeMapper.employeeFromDTO(edto);
            return edto;
        }catch(BuildException e){
            throw new ServiceException("error in the input employee data: " + e.getMessage());
        }
    }

    protected EmployeeDTO newEmployee(String employee)throws ServiceException{
        EmployeeDTO edto = this.checkInputData(employee);
        if(this.getDTO(edto.getIdent()) == null){
            return employeeRepository.save(edto);
        }
        throw new ServiceException("employee" + edto.getIdent() + " alredy exists");
    }

    protected EmployeeDTO updateEmployee(String employee)throws ServiceException{
        try{
            EmployeeDTO edto = this.checkInputData(employee);
            this.getByIdent(edto.getIdent());
            return employeeRepository.save(edto);
        }catch(ServiceException e){
            throw e;
        }
    }

    // Mètodes d'inteficie
    @Override
    public String getByIdentToJson(int ident)throws ServiceException{
        return SerializersCatalog.getInstace(Serializers.JSON_EMPLOYEE).serialize(this.getByIdent(ident));
    }

    @Override
    public String getByIdentToXml(int ident)throws ServiceException{
        return SerializersCatalog.getInstace(Serializers.XML_EMPLOYEE).serialize(this.getByIdent(ident));
    }

    @Override
    public String addFromJson(String employee)throws ServiceException{
        this.serializer = SerializersCatalog.getInstace(Serializers.JSON_EMPLOYEE);
        return serializer.serialize(this.newEmployee(employee));
    }

    @Override
    public String addFromXml(String employee)throws ServiceException{
        this.serializer = SerializersCatalog.getInstace(Serializers.XML_EMPLOYEE);
        return serializer.serialize(this.newEmployee(employee));
    }

    @Override
    public String updateOneFromJson(String employee)throws ServiceException{
        this.serializer = SerializersCatalog.getInstace(Serializers.JSON_EMPLOYEE);
        return serializer.serialize(this.updateEmployee(employee));
    }

    @Override
    public String updateOneFromXml(String employee)throws ServiceException{
        this.serializer = SerializersCatalog.getInstace(Serializers.XML_EMPLOYEE);
        return serializer.serialize(this.updateEmployee(employee));
    }

    @Override
    public void deleteByIdent(int ident)throws ServiceException{
        try {
            this.getByIdent(ident);
            employeeRepository.deleteByIdent(ident);
        } catch (ServiceException e) {
            throw e;
        }
    }
}