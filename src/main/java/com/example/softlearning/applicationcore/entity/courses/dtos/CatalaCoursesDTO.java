package com.example.softlearning.applicationcore.entity.courses.dtos;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName = "Curs")

public class CatalaCoursesDTO {
    private String description, department;
    private int code, hours;
    private double price;

    public CatalaCoursesDTO(){}

    public CatalaCoursesDTO(int code, double price, String description, int hours, String department) {
        this.code = code;
        this.price = price;
        this.description = description;
        this.hours = hours;
        this.department = department;
    }

    // Codi
    @JsonGetter("codi_curs")
    public int getCode() {
        return code;
    }

    @JsonSetter("codi_curs")
    public void setCode(int code) {
        this.code = code;
    }

    // Preu
    @JsonGetter("preu_curs")
    public double getPrice() {
        return price;
    }

    @JsonSetter("preu_curs")
    public void setPrice(double price) {
        this.price = price;
    }  

    // Decripció
    @JsonGetter("descripcio_curs")
    public String getDescription() {
        return description;
    }

    @JsonSetter("descripcio_curs")
    public void setDescription(String description) {
        this.description = description;
    }

    // Hores
    @JsonGetter("hores_curs")
    public int getHours() {
        return hours;
    }

    @JsonSetter("hores_curs")
    public void setHours(int hours) {
        this.hours = hours;
    }

    // Departament
    @JsonGetter("departament_curs")
    public String getDepartment() {
        return department;
    }

    @JsonSetter("departament_curs")
    public void setDepartment(String department) {
        this.department = department;
    }
}