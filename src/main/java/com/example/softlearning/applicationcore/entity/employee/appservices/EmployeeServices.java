package com.example.softlearning.applicationcore.entity.employee.appservices;

import org.springframework.stereotype.Service;
import com.example.softlearning.applicationcore.entity.sharedkernel.model.exceptions.ServiceException;

@Service
public interface EmployeeServices {
    public String getByIdentToJson(int ident) throws ServiceException;
    public String getByIdentToXml(int ident) throws ServiceException;
    public String addFromJson(String employee) throws ServiceException;
    public String addFromXml(String employee) throws ServiceException;
    public String updateOneFromJson(String employee) throws ServiceException;
    public String updateOneFromXml(String employee) throws ServiceException;
    public void deleteByIdent(int ident) throws ServiceException;
}