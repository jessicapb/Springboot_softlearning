package com.example.softlearning.applicationcore.entity.client.appservices;

import java.security.Provider.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.example.softlearning.applicationcore.entity.client.dtos.ClientsDTO;
import com.example.softlearning.applicationcore.entity.client.mappers.ClientMapper;
import com.example.softlearning.applicationcore.entity.client.persistence.ClientRepository;
import com.example.softlearning.applicationcore.entity.sharedkernel.appservices.serializers.Serializer;
import com.example.softlearning.applicationcore.entity.sharedkernel.appservices.serializers.Serializers;
import com.example.softlearning.applicationcore.entity.sharedkernel.appservices.serializers.SerializersCatalog;
import com.example.softlearning.applicationcore.entity.sharedkernel.model.exceptions.BuildException;
import com.example.softlearning.applicationcore.entity.sharedkernel.model.exceptions.ServiceException;

@Controller
public class ClientServicesImpl implements ClientServices{
    @Autowired
    private ClientRepository clientRepository;
    private Serializer<ClientsDTO> serializer;

    // Serveis per el llibre
    protected ClientsDTO getDTO(int ident){
        return clientRepository.findByident(ident).orElse(null);
    }

    protected ClientsDTO getByIdent(int ident)throws ServiceException{
        ClientsDTO cdto = this.getDTO(ident);
        if(cdto == null){
            throw new ServiceException("client " + ident + " not found");
        }
        return cdto;
    }

    protected ClientsDTO checkInputData(String client)throws ServiceException{
        try{
            ClientsDTO cdto = (ClientsDTO) this.serializer.desearialize(client, ClientsDTO.class);
            ClientMapper.clientFromDTO(cdto);
            return cdto;
        }catch(BuildException e){
            throw new ServiceException("error in the input client data: " + e.getMessage());
        }
    }

    protected ClientsDTO newClient(String client)throws ServiceException{
        ClientsDTO cdto = this.checkInputData(client);
        if(this.getDTO(cdto.getIdent()) == null){
            return clientRepository.save(cdto);
        }
        throw new ServiceException("client" + cdto.getIdent() + " alredy exists");
    }

    protected ClientsDTO updateClient(String client)throws ServiceException{
        try{
            ClientsDTO cdto = this.checkInputData(client);
            this.getByIdent(cdto.getIdent());
            return clientRepository.save(cdto);
        }catch(ServiceException e){
            throw e;
        }
    }

    // Mètodes d'inteficie
    @Override
    public String getByIdentToJson(int ident)throws ServiceException{
        return SerializersCatalog.getInstace(Serializers.JSON_CLIENT).serialize(this.getByIdent(ident));
    }

    @Override
    public String getByIdentToXml(int ident)throws ServiceException{
        return SerializersCatalog.getInstace(Serializers.XML_CLIENT).serialize(this.getByIdent(ident));
    }

    @Override
    public String addFromJson(String client)throws ServiceException{
        this.serializer = SerializersCatalog.getInstace(Serializers.JSON_CLIENT);
        return serializer.serialize(this.newClient(client));
    }

    @Override
    public String addFromXml(String client)throws ServiceException{
        this.serializer = SerializersCatalog.getInstace(Serializers.XML_CLIENT);
        return serializer.serialize(this.newClient(client));
    }

    @Override
    public String updateOneFromJson(String client)throws ServiceException{
        this.serializer = SerializersCatalog.getInstace(Serializers.JSON_CLIENT);
        return serializer.serialize(this.updateClient(client));
    }

    @Override
    public String updateOneFromXml(String client)throws ServiceException{
        this.serializer = SerializersCatalog.getInstace(Serializers.XML_CLIENT);
        return serializer.serialize(this.updateClient(client));
    }

    @Override
    public void deleteByIdent(int ident)throws ServiceException{
        try {
            this.getByIdent(ident);
            clientRepository.deleteByIdent(ident);
        } catch (ServiceException e) {
            throw e;
        }
    }
}