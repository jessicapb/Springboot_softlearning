package com.example.softlearning.applicationcore.entity.courses.appservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.example.softlearning.applicationcore.entity.courses.dtos.CoursesDTO;
import com.example.softlearning.applicationcore.entity.courses.mapper.CoursesMapper;
import com.example.softlearning.applicationcore.entity.courses.persistence.CoursesRepository;
import com.example.softlearning.applicationcore.entity.sharedkernel.appservices.serializers.Serializer;
import com.example.softlearning.applicationcore.entity.sharedkernel.appservices.serializers.Serializers;
import com.example.softlearning.applicationcore.entity.sharedkernel.appservices.serializers.SerializersCatalog;
import com.example.softlearning.applicationcore.entity.sharedkernel.model.exceptions.BuildException;
import com.example.softlearning.applicationcore.entity.sharedkernel.model.exceptions.ServiceException;

@Controller
public class CoursesServicesImpl implements CoursesServices{
    @Autowired
    private CoursesRepository coursesRepository;
    private Serializer<CoursesDTO> serializer;

    protected CoursesDTO getDTO(int code){
        return coursesRepository.findByCode(code).orElse(null);
    }

    protected CoursesDTO getByCode(int code)throws ServiceException{
        CoursesDTO cdto = this.getDTO(code);
        if(cdto == null){
            throw new ServiceException("courses " + code + " not found");
        }
        return cdto;
    }

    protected CoursesDTO checkInputData(String courses)throws ServiceException{
        try {
            CoursesDTO cdto = (CoursesDTO) this.serializer.desearialize(courses, CoursesDTO.class);
            CoursesMapper.coursesFromDTO(cdto);
            return cdto;
        } catch (BuildException e) {
            throw new ServiceException("error in the input courses data: " + e.getMessage());
        }
    }

    protected CoursesDTO newCourses(String courses)throws ServiceException{
        CoursesDTO cdto = this.checkInputData(courses);
        if(this.getDTO(cdto.getCode()) == null){
            return coursesRepository.save(cdto);
        }
        throw new ServiceException("courses " + cdto.getCode() + " alredy exists");
    }

    protected CoursesDTO updateCourses(String courses)throws ServiceException{
        try {
            CoursesDTO cdto = this.checkInputData(courses);
            this.getByCode(cdto.getCode());
            return coursesRepository.save(cdto);
        } catch (ServiceException e) {
            throw e;
        }
    }

    // Mètodes d'interficie
    @Override
    public String getByCodeToJson(int code)throws ServiceException{
        return SerializersCatalog.getInstace(Serializers.JSON_COURSES).serialize(this.getByCode(code));
    }

    @Override
    public String getByCodeToXml(int code)throws ServiceException{
        return SerializersCatalog.getInstace(Serializers.XML_COURSES).serialize(this.getByCode(code));
    }

    @Override
    public String addFromJson(String courses)throws ServiceException{
        this.serializer = SerializersCatalog.getInstace(Serializers.JSON_COURSES);
        return serializer.serialize(this.newCourses(courses));
    }

    @Override
    public String addFromXml(String courses)throws ServiceException{
        this.serializer = SerializersCatalog.getInstace(Serializers.XML_COURSES);
        return serializer.serialize(this.newCourses(courses));
    }

    @Override
    public String updateOneFromJson(String courses)throws ServiceException{
        try {
            this.serializer = SerializersCatalog.getInstace(Serializers.JSON_COURSES);
            return serializer.serialize(this.updateCourses(courses));
        } catch (Exception e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public String updateOneFromXml(String courses)throws ServiceException{
        this.serializer = SerializersCatalog.getInstace(Serializers.XML_COURSES);
        return serializer.serialize(this.updateCourses(courses));
    }

    @Override
    public void deleteByCode(int code)throws ServiceException{
        try {
            this.getByCode(code);
            coursesRepository.deleteByCode(code);
        } catch (ServiceException e) {
            throw e;
        }
    }
}
