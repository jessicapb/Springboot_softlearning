package com.example.softlearning.applicationcore.entity.provider.mapper;

import com.example.softlearning.applicationcore.entity.provider.dtos.ProviderDTO;
import com.example.softlearning.applicationcore.entity.provider.model.Provider;
import com.example.softlearning.applicationcore.entity.sharedkernel.model.exceptions.BuildException;

public class ProviderMapper {
    public static Provider providerFromDTO(ProviderDTO pdto) throws BuildException{
        return Provider.getInstanceProvider(
            pdto.getName(), 
            pdto.getSurname(),
            pdto.getEmail(),
            pdto.getNumber(),
            pdto.getAddress(),
            pdto.getAntiquity(),
            pdto.getIdent(),
            pdto.getSponsors(),
            pdto.getWorkers(),
            pdto.getSocialreason()
        );
    }

    public static ProviderDTO dtoFromProvider(Provider p){
        return new ProviderDTO(
            p.getName(),
            p.getSurname(),
            p.getEmail(),
            p.getNumber(),
            p.getAddress(),
            p.getAntiquity(),
            p.getIdent(),
            p.getSponsors(),
            p.getWorkers(),
            p.getSocialreason()
        );
    }
}