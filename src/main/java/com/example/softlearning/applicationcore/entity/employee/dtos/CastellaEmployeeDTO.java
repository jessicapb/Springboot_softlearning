package com.example.softlearning.applicationcore.entity.employee.dtos;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName = "Trabajador")

public class CastellaEmployeeDTO {
    private String name, surname, email, number, address, antiquity, department, schedule;
    private int ident, bankaccount;

    public CastellaEmployeeDTO(){}
    
    public CastellaEmployeeDTO(String name, String surname, String email, String number, String address, String antiquity,
            String department, String schedule, int ident, int bankaccount) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.number = number;
        this.address = address;
        this.antiquity = antiquity;
        this.department = department;
        this.schedule = schedule;
        this.ident = ident;
        this.bankaccount = bankaccount;
    }

    // Nom
    @JsonGetter("nombre_trabajador")
    public String getName() {
        return name;
    }

    @JsonSetter("nombre_trabajador")
    public void setName(String name) {
        this.name = name;
    }

    // Cognoms
    @JsonGetter("apellidos_trabajador")
    public String getSurname() {
        return surname;
    }

    @JsonSetter("apellidos_trabajador")
    public void setSurname(String surname) {
        this.surname = surname;
    }

    // Email
    @JsonGetter("email_treballador")
    public String getEmail() {
        return email;
    }

    @JsonSetter("email_treballador")
    public void setEmail(String email) {
        this.email = email;
    }

    // Número telèfon
    @JsonGetter("telefono_trabajador")
    public String getNumber() {
        return number;
    }

    @JsonSetter("telefono_trabajador")
    public void setNumber(String number) {
        this.number = number;
    }

    // Adreça
    @JsonGetter("dirección_trabajador")
    public String getAddress() {
        return address;
    }

    @JsonSetter("dirección_trabajador")
    public void setAddress(String address) {
        this.address = address;
    }

    // Aniversari
    @JsonGetter("cumpleaños_trabajador")
    public String getAntiquity() {
        return antiquity;
    }

    @JsonSetter("cumpleaños_trabajador")
    public void setAntiquity(String antiquity) {
        this.antiquity = antiquity;
    }

    // Departament
    @JsonGetter("departamento_trabajador")
    public String getDepartment() {
        return department;
    }

    @JsonSetter("departamento_trabajador")
    public void setDepartment(String department) {
        this.department = department;
    }

    // Horari
    @JsonGetter("horario_trabajador")
    public String getSchedule() {
        return schedule;
    }

    @JsonSetter("horario_trabajador")
    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    // Número de treballador
    @JsonGetter("numero_trabajador")
    public int getIdent() {
        return ident;
    }

    @JsonSetter("numero_trabajador")
    public void setIdent(int ident) {
        this.ident = ident;
    }

    // Compta del banc
    @JsonGetter("cuentabanco_trabajador")
    public int getBankaccount() {
        return bankaccount;
    }

    @JsonSetter("cuentabanco_trabajador")
    public void setBankaccount(int bankaccount) {
        this.bankaccount = bankaccount;
    }
}
