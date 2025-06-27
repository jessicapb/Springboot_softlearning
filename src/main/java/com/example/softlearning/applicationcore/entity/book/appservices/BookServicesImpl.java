package com.example.softlearning.applicationcore.entity.book.appservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.example.softlearning.applicationcore.entity.book.dtos.BooksDTO;
import com.example.softlearning.applicationcore.entity.book.mappers.BooksMapper;
import com.example.softlearning.applicationcore.entity.book.persistence.BookRepository;
import com.example.softlearning.applicationcore.entity.sharedkernel.appservices.serializers.Serializer;
import com.example.softlearning.applicationcore.entity.sharedkernel.appservices.serializers.Serializers;
import com.example.softlearning.applicationcore.entity.sharedkernel.appservices.serializers.SerializersCatalog;
import com.example.softlearning.applicationcore.entity.sharedkernel.model.exceptions.BuildException;
import com.example.softlearning.applicationcore.entity.sharedkernel.model.exceptions.ServiceException;

@Controller
public class BookServicesImpl implements BookServices{
    @Autowired
    private BookRepository bookRepository;
    private Serializer<BooksDTO> serializer;
    
    // Serveis per el llibre
    protected BooksDTO getDTO(int code){
        return bookRepository.findByCode(code).orElse(null);
    }

    protected BooksDTO getByCode(int code)throws ServiceException{
        BooksDTO bdto = this.getDTO(code);
        if(bdto == null){
            throw new ServiceException("book " + code + " not found");
        }
        return bdto;
    }

    protected BooksDTO checkInputData(String book)throws ServiceException{
        try {
            BooksDTO bdto = (BooksDTO) this.serializer.desearialize(book, BooksDTO.class);
            BooksMapper.bookFromDTO(bdto);
            return bdto;
        } catch (BuildException e) {
            throw new ServiceException("error in the input book data: " + e.getMessage());
        }
    }

    protected BooksDTO newBook(String book)throws ServiceException{
        BooksDTO bdto = this.checkInputData(book);
        if(this.getDTO(bdto.getCode()) == null){
            return bookRepository.save(bdto);
        }
        throw new ServiceException("book " + bdto.getCode() + " alredy exists");
    }

    protected BooksDTO updateBook(String book)throws ServiceException{
        try {
            BooksDTO bdto = this.checkInputData(book);
            this.getByCode(bdto.getCode());
            return bookRepository.save(bdto);
        } catch (ServiceException e) {
            throw e;
        }
    }

    // Mètodes d'interficie
    @Override
    public String getByCodeToJson(int code)throws ServiceException{
        return SerializersCatalog.getInstace(Serializers.JSON_BOOK).serialize(this.getByCode(code));
    }

    @Override
    public String getByCodeToXml(int code)throws ServiceException{
        return SerializersCatalog.getInstace(Serializers.XML_BOOK).serialize(this.getByCode(code));
    }

    @Override
    public String addFromJson(String book)throws ServiceException{
        this.serializer = SerializersCatalog.getInstace(Serializers.JSON_BOOK);
        return serializer.serialize(this.newBook(book));
    }

    @Override
    public String addFromXml(String book)throws ServiceException{
        this.serializer = SerializersCatalog.getInstace(Serializers.XML_BOOK);
        return serializer.serialize(this.newBook(book));
    }

    @Override
    public String updateOneFromJson(String book)throws ServiceException{
        try {
            this.serializer = SerializersCatalog.getInstace(Serializers.JSON_BOOK);
            return serializer.serialize(this.updateBook(book));
        } catch (Exception e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public String updateOneFromXml(String book)throws ServiceException{
        this.serializer = SerializersCatalog.getInstace(Serializers.XML_BOOK);
        return serializer.serialize(this.updateBook(book));
    }

    @Override
    public void deleteByCode(int code)throws ServiceException{
        try {
            this.getByCode(code);
            bookRepository.deleteByCode(code);
        } catch (ServiceException e) {
            throw e;
        }
    }
}
