package com.example.softlearning.applicationcore.entity.client.appservices;

import org.springframework.stereotype.Service;
import com.example.softlearning.applicationcore.entity.sharedkernel.model.exceptions.ServiceException;

@Service
public interface ClientServices {
    public String getByIdentToJson(int ident) throws ServiceException;
    public String getByIdentToXml(int ident) throws ServiceException;
    public String addFromJson(String client) throws ServiceException;
    public String addFromXml(String client) throws ServiceException;
    public String updateOneFromJson(String client) throws ServiceException;
    public String updateOneFromXml(String client) throws ServiceException;
    public void deleteByIdent(int ident) throws ServiceException;
}