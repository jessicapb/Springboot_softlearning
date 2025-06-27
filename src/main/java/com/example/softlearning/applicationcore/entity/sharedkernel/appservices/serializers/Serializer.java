package com.example.softlearning.applicationcore.entity.sharedkernel.appservices.serializers;

import com.example.softlearning.applicationcore.entity.sharedkernel.model.exceptions.ServiceException;

public interface Serializer<T>  {
    public String serialize(T object)throws ServiceException;
    public T desearialize(String s, Class<T> object)throws ServiceException;
}
