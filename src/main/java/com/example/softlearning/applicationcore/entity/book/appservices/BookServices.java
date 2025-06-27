package com.example.softlearning.applicationcore.entity.book.appservices;

import com.example.softlearning.applicationcore.entity.sharedkernel.model.exceptions.ServiceException;
import org.springframework.stereotype.Service;

@Service
public interface BookServices {
    public String getByCodeToJson (int code) throws ServiceException;
    public String getByCodeToXml (int code) throws ServiceException;
    public String addFromJson (String book) throws ServiceException;
    public String addFromXml (String book) throws ServiceException;
    public String updateOneFromJson(String book) throws ServiceException;
    public String updateOneFromXml(String book) throws ServiceException;
    public void deleteByCode(int code) throws ServiceException;
}
