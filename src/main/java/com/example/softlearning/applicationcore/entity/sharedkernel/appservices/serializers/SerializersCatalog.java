package com.example.softlearning.applicationcore.entity.sharedkernel.appservices.serializers;

import java.util.TreeMap;

import com.example.softlearning.applicationcore.entity.book.dtos.BooksDTO;
// import com.example.softlearning.applicationcore.entity.ClientCompany.dtos.CatalaClientCompanyDTO;
import com.example.softlearning.applicationcore.entity.book.dtos.CastellaBookDTO;
import com.example.softlearning.applicationcore.entity.book.dtos.CatalaBookDTO;
import com.example.softlearning.applicationcore.entity.client.dtos.CastellaClientDTO;
import com.example.softlearning.applicationcore.entity.client.dtos.CatalaClientDTO;
import com.example.softlearning.applicationcore.entity.client.dtos.ClientsDTO;
import com.example.softlearning.applicationcore.entity.courses.dtos.CastellaCoursesDTO;
import com.example.softlearning.applicationcore.entity.courses.dtos.CatalaCoursesDTO;
import com.example.softlearning.applicationcore.entity.courses.dtos.CoursesDTO;
import com.example.softlearning.applicationcore.entity.employee.dtos.CastellaEmployeeDTO;
import com.example.softlearning.applicationcore.entity.employee.dtos.CatalaEmployeeDTO;
import com.example.softlearning.applicationcore.entity.employee.dtos.EmployeeDTO;
import com.example.softlearning.applicationcore.entity.order.dtos.CastellaOrderDTO;
import com.example.softlearning.applicationcore.entity.order.dtos.CatalaOrderDTO;
import com.example.softlearning.applicationcore.entity.order.dtos.OrderDTO;
import com.example.softlearning.applicationcore.entity.provider.dtos.CastellaProviderDTO;
import com.example.softlearning.applicationcore.entity.provider.dtos.CatalaProviderDTO;

public class SerializersCatalog {
    private static TreeMap<Serializers, Serializer > catalog = new TreeMap<>();

    private static void loadCatalog(){
        // Llibre
        catalog.put(Serializers.JSON_BOOK, new JacksonSerializer<BooksDTO>());
        catalog.put(Serializers.XML_BOOK, new JacksonXMLSerializer<BooksDTO>());
        
        // CatalaLlibre
        catalog.put(Serializers.JSON_CAT_BOOK,new JacksonSerializer<CatalaBookDTO>());
        catalog.put(Serializers.XML_CAT_BOOK,new JacksonXMLSerializer<CatalaBookDTO>());

        // CastellaLlibre
        catalog.put(Serializers.JSON_CAST_BOOK,new JacksonSerializer<CastellaBookDTO>());
        catalog.put(Serializers.XML_CAST_BOOK,new JacksonXMLSerializer<CastellaBookDTO>());

        // Client
        catalog.put(Serializers.JSON_CLIENT, new JacksonSerializer<ClientsDTO>());
        catalog.put(Serializers.XML_CLIENT, new JacksonXMLSerializer<ClientsDTO>());

        // CatalaClient
        catalog.put(Serializers.JSON_CAT_CLIENT,new JacksonSerializer<CatalaClientDTO>());
        catalog.put(Serializers.XML_CAT_CLIENT,new JacksonXMLSerializer<CatalaClientDTO>());

        // // CastellaClient
        catalog.put(Serializers.JSON_CAST_CLIENT,new JacksonSerializer<CastellaClientDTO>());        
        catalog.put(Serializers.XML_CAST_CLIENT,new JacksonXMLSerializer<CastellaClientDTO>());

        // Curs 
        catalog.put(Serializers.JSON_COURSES, new JacksonSerializer<CoursesDTO>());
        catalog.put(Serializers.XML_COURSES, new JacksonXMLSerializer<CoursesDTO>());

        // CatalaCurs
        catalog.put(Serializers.JSON_CAT_COURSES,new JacksonSerializer<CatalaCoursesDTO>());
        catalog.put(Serializers.XML_CAT_COURSES,new JacksonXMLSerializer<CatalaCoursesDTO>());

        // CastellaCurs
        catalog.put(Serializers.JSON_CAST_COURSES, new JacksonSerializer<CastellaCoursesDTO>());
        catalog.put(Serializers.XML_CAST_COURSES, new JacksonXMLSerializer<CastellaCoursesDTO>());

        // Compra
        catalog.put(Serializers.JSON_ORDER, new JacksonSerializer<OrderDTO>());
        catalog.put(Serializers.XML_ORDER, new JacksonXMLSerializer<OrderDTO>());

        // CatalaCompra
        catalog.put(Serializers.JSON_CAT_ORDER,new JacksonSerializer<CatalaOrderDTO>());
        catalog.put(Serializers.XML_CAT_ORDER,new JacksonXMLSerializer<CatalaOrderDTO>());

        // CastellaCompra
        catalog.put(Serializers.JSON_CAST_ORDER,new JacksonSerializer<CastellaOrderDTO>());
        catalog.put(Serializers.XML_CAST_ORDER,new JacksonXMLSerializer<CastellaOrderDTO>());

        // Treballador
        catalog.put(Serializers.JSON_EMPLOYEE, new JacksonSerializer<EmployeeDTO>());
        catalog.put(Serializers.XML_EMPLOYEE, new JacksonXMLSerializer<EmployeeDTO>());

        // CatalaTreballador
        catalog.put(Serializers.JSON_CAT_EMPLOYEE,new JacksonSerializer<CatalaEmployeeDTO>());
        catalog.put(Serializers.XML_CAT_EMPLOYEE, new JacksonXMLSerializer<CatalaEmployeeDTO>());

        // CastellaTreballador
        catalog.put(Serializers.JSON_CAST_EMPLOYEE, new JacksonSerializer<CastellaEmployeeDTO>());
        catalog.put(Serializers.XML_CAST_EMPLOYEE, new JacksonXMLSerializer<CastellaEmployeeDTO>());

        // Proveïdor
        catalog.put(Serializers.JSON_PROVIDER, new JacksonSerializer<EmployeeDTO>());
        catalog.put(Serializers.XML_PROVIDER, new JacksonXMLSerializer<EmployeeDTO>());

        // CatalaProveïdor
        catalog.put(Serializers.JSON_CAT_PROVIDER, new JacksonSerializer<CatalaProviderDTO>());
        catalog.put(Serializers.XML_CAT_PROVIDER, new JacksonXMLSerializer<CatalaProviderDTO>());

        // CastellaProveïdor
        catalog.put(Serializers.JSON_CAST_PROVIDER, new JacksonSerializer<CastellaProviderDTO>());
        catalog.put(Serializers.XML_CAST_PROVIDER, new JacksonXMLSerializer<CastellaProviderDTO>());

        // // CatalaEmpresaClient
        // catalog.put(Serializers.JSON_CLIENTCOM,new JacksonSerializer<CatalaClientCompanyDTO>());
        // catalog.put(Serializers.XML_CLIENTCOM, new JacksonXmlSerializer<CatalaClientCompanyDTO>());
    }

    public static Serializer getInstace(Serializers type){
        if(catalog.isEmpty()){
            loadCatalog();
        }
        return catalog.get(type);
    }
}
