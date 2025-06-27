package com.example.softlearning.applicationcore.entity.courses.dtos;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName = "Cursos")

public class CastellaCoursesDTO {
    private String description, department;
    private int code, hours;
    private double price;

    public CastellaCoursesDTO(){}

    public CastellaCoursesDTO(int code, double price, String description, int hours, String department) {
        this.code = code;
        this.price = price;
        this.description = description;
        this.hours = hours;
        this.department = department;
    }

    // Codi
    @JsonGetter("codigo_curso")
    public int getCode() {
        return code;
    }

    @JsonSetter("codigo_curso")
    public void setCode(int code) {
        this.code = code;
    }

    // Preu
    @JsonGetter("precio_curso")
    public double getPrice() {
        return price;
    }

    @JsonSetter("precio_curso")
    public void setPrice(double price) {
        this.price = price;
    }  

    // Decripció
    @JsonGetter("descripcion_curso")
    public String getDescription() {
        return description;
    }

    @JsonSetter("descripcion_curso")
    public void setDescription(String description) {
        this.description = description;
    }

    // Hores
    @JsonGetter("horas_curso")
    public int getHours() {
        return hours;
    }

    @JsonSetter("horas_curso")
    public void setHours(int hours) {
        this.hours = hours;
    }

    // Departament
    @JsonGetter("departamento_curso")
    public String getDepartment() {
        return department;
    }

    @JsonSetter("departamento_curso")
    public void setDepartment(String department) {
        this.department = department;
    }
}