package com.example.softlearning.applicationcore.entity.sharedkernel.appservices.serializers;

import com.example.softlearning.applicationcore.entity.sharedkernel.model.exceptions.ServiceException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class JacksonXMLSerializer<T> implements Serializer<T> {
    private XmlMapper mapper = new XmlMapper();

    public String serialize(T object)throws ServiceException{
        try {
            return this.mapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    public T desearialize(String source, Class<T> object)throws ServiceException{
        try {
            return mapper.readValue(source, object);
        } catch (JsonProcessingException e) {
            throw new ServiceException(e.getMessage());
        }
    }
}
