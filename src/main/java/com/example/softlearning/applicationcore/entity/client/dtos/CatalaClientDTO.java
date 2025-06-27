package com.example.softlearning.applicationcore.entity.client.dtos;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName = "Clients")

public class CatalaClientDTO {
    private String name, surname, email, number, address, antiquity,paymentcode;
    private int ident;
    
    public CatalaClientDTO(){}
    
    public CatalaClientDTO(String name, String surname, String email, String number, String address, String antiquity,
            String paymentcode, int ident) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.number = number;
        this.address = address;
        this.antiquity = antiquity;
        this.paymentcode = paymentcode;
        this.ident = ident;
    }

    // Nom
    @JsonGetter("nom_client")
    public String getName() {
        return name;
    }

    @JsonSetter("nom_client")
    public void setName(String name){
        this.name = name;
    }

    // Cognoms
    @JsonGetter("cognoms_client")
    public String getSurname() {
        return surname;
    }

    @JsonSetter("cognoms_client")
    public void setSurname(String surname) {
        this.surname = surname;
    }

    // Aniversari
    @JsonGetter("aniversari_client")
    public String getAntiquity() {
        return antiquity;
    }

    @JsonSetter("aniversari_client")
    public void setAntiquity(String antiquity) {
        this.antiquity = antiquity;
    }

    // Correu
    @JsonGetter("email_client")
    public String getEmail() {
        return email;
    }

    @JsonSetter("email_client")
    public void setEmail(String email) {
        this.email = email;
    }

    // Número telèfon
    @JsonGetter("telefon_client")
    public String getNumber() {
        return number;
    }

    @JsonSetter("telefon_client")
    public void setNumber(String number) {
        this.number = number;
    }

    // Adreça
    @JsonGetter("adreca_client")
    public String getAddress() {
        return address;
    }

    @JsonSetter("adreca_client")
    public void setAddress(String address) {
        this.address = address;
    }

    // Número de soci
    @JsonGetter("soci_client")
    public int getIdent() {
        return ident;
    }

    @JsonSetter("soci_client")
    public void setIdent(int ident) {
        this.ident = ident;
    }

    // Mètode de pagament
    @JsonGetter("pagament_client")
    public String getPaymentcode() {
        return paymentcode;
    }

    @JsonSetter("pagament_client")
    public void setPaymentcode(String paymentcode) {
        this.paymentcode = paymentcode;
    }
}