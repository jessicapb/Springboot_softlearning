package com.example.softlearning.applicationcore.entity.courses.appservices;

import org.springframework.stereotype.Service;

import com.example.softlearning.applicationcore.entity.sharedkernel.model.exceptions.ServiceException;

@Service
public interface CoursesServices {
    public String getByCodeToJson (int code) throws ServiceException;
    public String getByCodeToXml (int code) throws ServiceException;
    public String addFromJson (String courses) throws ServiceException;
    public String addFromXml (String courses) throws ServiceException;
    public String updateOneFromJson (String book) throws ServiceException;
    public String updateOneFromXml (String book) throws ServiceException;
    public void deleteByCode(int code) throws ServiceException;
}
