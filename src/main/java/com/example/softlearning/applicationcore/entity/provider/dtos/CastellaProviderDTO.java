package com.example.softlearning.applicationcore.entity.provider.dtos;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName = "Proveedor")

public class CastellaProviderDTO {
    private String name, surname, email, number, address, antiquity, sponsors, socialreason;
    private int ident, workers;

    public CastellaProviderDTO(){}

    public CastellaProviderDTO(String name, String surname, String email, String number, String address, String antiquity,
            String sponsors, String socialreason, int ident, int workers) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.number = number;
        this.address = address;
        this.antiquity = antiquity;
        this.sponsors = sponsors;
        this.socialreason = socialreason;
        this.ident = ident;
        this.workers = workers;
    }

    // Nom
    @JsonGetter("nombre_proveedor")
    public String getName() {
        return name;
    }

    @JsonSetter("nombre_proveedor")
    public void setName(String name) {
        this.name = name;
    }

    // Cognoms
    @JsonGetter("apellidos_proveedor")
    public String getSurname() {
        return surname;
    }

    @JsonSetter("apellidos_proveedor")
    public void setSurname(String surname) {
        this.surname = surname;
    }

    // Email
    @JsonGetter("email_proveedor")
    public String getEmail() {
        return email;
    }

    @JsonSetter("email_proveedor")
    public void setEmail(String email) {
        this.email = email;
    }

    // Número telèfon
    @JsonGetter("telefono_proveedor")
    public String getNumber() {
        return number;
    }

    @JsonSetter("telefono_proveedor")
    public void setNumber(String number) {
        this.number = number;
    }

    // Adreça
    @JsonGetter("dirección_proveedor")
    public String getAddress() {
        return address;
    }

    @JsonSetter("dirección_proveedor")
    public void setAddress(String address) {
        this.address = address;
    }

    // Aniversari
    @JsonGetter("cumpleaños_proveedor")
    public String getAntiquity() {
        return antiquity;
    }

    @JsonSetter("cumpleaños_proveedor")
    public void setAntiquity(String antiquity) {
        this.antiquity = antiquity;
    }

    // Patrocinadors
    @JsonGetter("patrocinador_proveedor")
    public String getSponsors() {
        return sponsors;
    }

    @JsonSetter("patrocinador_proveedor")
    public void setSponsors(String sponsors) {
        this.sponsors = sponsors;
    }

    // Raó social
    @JsonGetter("razonsocial_proveedor")
    public String getSocialreason() {
        return socialreason;
    }

    @JsonSetter("razonsocial_proveedor")
    public void setSocialreason(String socialreason) {
        this.socialreason = socialreason;
    }

    // Identificador
    @JsonGetter("identificador_proveedor")
    public int getIdent() {
        return ident;
    }

    @JsonSetter("identificador_proveedor")
    public void setIdent(int ident) {
        this.ident = ident;
    }

    // Treballadors
    @JsonGetter("trabajadores_proveedor")
    public int getWorkers() {
        return workers;
    }

    @JsonSetter("trabajadores_proveedor")
    public void setWorkers(int workers) {
        this.workers = workers;
    }
}
