package com.example.softlearning.applicationcore.entity.client.dtos;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName = "Clientes")

public class CastellaClientDTO {
    private String name, surname, email, number, address, antiquity,paymentcode;
    private int ident;

    public CastellaClientDTO(){}

    public CastellaClientDTO(String name, String surname, String email, String number, String address, String antiquity,
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
    @JsonGetter("nombre_cliente")
    public String getName() {
        return name;
    }

    @JsonSetter("nombre_cliente")
    public void setName(String name){
        this.name = name;
    }

    // Cognoms
    @JsonGetter("apellidos_cliente")
    public String getSurname() {
        return surname;
    }

    @JsonSetter("apellidos_cliente")
    public void setSurname(String surname) {
        this.surname = surname;
    }

    // Aniversari
    @JsonGetter("cumpleaños_cliente")
    public String getAntiquity() {
        return antiquity;
    }

    @JsonSetter("cumpleaños_cliente")
    public void setAntiquity(String antiquity) {
        this.antiquity = antiquity;
    }

    // Email
    @JsonGetter("email_cliente")
    public String getEmail() {
        return email;
    }

    @JsonSetter("email_cliente")
    public void setEmail(String email) {
        this.email = email;
    }

    // Número telèfon
    @JsonGetter("teléfono_cliente")
    public String getNumber() {
        return number;
    }

    @JsonSetter("teléfono_cliente")
    public void setNumber(String number) {
        this.number = number;
    }

    // Adreça
    @JsonGetter("dirección_cliente")
    public String getAddress() {
        return address;
    }

    @JsonSetter("dirección_cliente")
    public void setAddress(String address) {
        this.address = address;
    }

    // Número de soci
    @JsonGetter("socio_cliente")
    public int getIdent() {
        return ident;
    }

    @JsonSetter("socio_cliente")
    public void setIdent(int ident) {
        this.ident = ident;
    }

    // Mètode de pagament
    @JsonGetter("pago_cliente")
    public String getPaymentcode() {
        return paymentcode;
    }

    @JsonSetter("pago_cliente")
    public void setPaymentcode(String paymentcode) {
        this.paymentcode = paymentcode;
    }
}