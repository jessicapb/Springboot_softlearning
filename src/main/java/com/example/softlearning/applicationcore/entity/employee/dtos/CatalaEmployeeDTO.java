package com.example.softlearning.applicationcore.entity.employee.dtos;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName = "Treballador")

public class CatalaEmployeeDTO {
    private String name, surname, email, number, address, antiquity, department, schedule;
    private int ident, bankaccount;

    public CatalaEmployeeDTO(){}
    
    public CatalaEmployeeDTO(String name, String surname, String email, String number, String address, String antiquity,
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
    @JsonGetter("nom_treballador")
    public String getName() {
        return name;
    }

    @JsonSetter("nom_treballador")
    public void setName(String name) {
        this.name = name;
    }

    // Cognoms
    @JsonGetter("cognoms_treballador")
    public String getSurname() {
        return surname;
    }

    @JsonSetter("cognoms_treballador")
    public void setSurname(String surname) {
        this.surname = surname;
    }

    // Correu
    @JsonGetter("email_treballador")
    public String getEmail() {
        return email;
    }

    @JsonSetter("email_treballador")
    public void setEmail(String email) {
        this.email = email;
    }

    // Número telèfon
    @JsonGetter("telefon_treballador")
    public String getNumber() {
        return number;
    }

    @JsonSetter("telefon_treballador")
    public void setNumber(String number) {
        this.number = number;
    }

    // Adreça
    @JsonGetter("adreca_treballador")
    public String getAddress() {
        return address;
    }

    @JsonSetter("adreca_treballador")
    public void setAddress(String address) {
        this.address = address;
    }

    // Aniversari
    @JsonGetter("aniversari_treballador")
    public String getAntiquity() {
        return antiquity;
    }

    @JsonSetter("aniversari_treballador")
    public void setAntiquity(String antiquity) {
        this.antiquity = antiquity;
    }

    // Departament
    @JsonGetter("departament_treballador")
    public String getDepartment() {
        return department;
    }

    @JsonSetter("departament_treballador")
    public void setDepartment(String department) {
        this.department = department;
    }

    // Horari
    @JsonGetter("horari_treballador")
    public String getSchedule() {
        return schedule;
    }

    @JsonSetter("horari_treballador")
    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    // Número de treballador
    @JsonGetter("numero_treballador")
    public int getIdent() {
        return ident;
    }

    @JsonSetter("numero_treballador")
    public void setIdent(int ident) {
        this.ident = ident;
    }

    // Compta del banc
    @JsonGetter("comptabanc_treballador")
    public int getBankaccount() {
        return bankaccount;
    }

    @JsonSetter("comptabanc_treballador")
    public void setBankaccount(int bankaccount) {
        this.bankaccount = bankaccount;
    }
}
