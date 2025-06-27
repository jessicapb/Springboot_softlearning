package com.example.softlearning.applicationcore.entity.provider.dtos;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName = "Proveïdor")

public class CatalaProviderDTO {
    private String name, surname, email, number, address, antiquity, sponsors, socialreason;
    private int ident, workers;

    public CatalaProviderDTO(){}

    public CatalaProviderDTO(String name, String surname, String email, String number, String address, String antiquity,
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
    @JsonGetter("nom_proveïdor")
    public String getName() {
        return name;
    }

    @JsonSetter("nom_proveïdor")
    public void setName(String name) {
        this.name = name;
    }

    // Cognoms
    @JsonGetter("cognoms_proveïdor")
    public String getSurname() {
        return surname;
    }

    @JsonSetter("cognoms_proveïdor")
    public void setSurname(String surname) {
        this.surname = surname;
    }

    // Correu
    @JsonGetter("email_proveïdor")
    public String getEmail() {
        return email;
    }

    @JsonSetter("email_proveïdor")
    public void setEmail(String email) {
        this.email = email;
    }

    // Número telèfon
    @JsonGetter("telefon_proveïdor")
    public String getNumber() {
        return number;
    }

    @JsonSetter("telefon_proveïdor")
    public void setNumber(String number) {
        this.number = number;
    }

    // Adreça
    @JsonGetter("adreca_proveïdor")
    public String getAddress() {
        return address;
    }

    @JsonSetter("adreca_proveïdor")
    public void setAddress(String address) {
        this.address = address;
    }

    // Aniversari
    @JsonGetter("aniversari_proveïdor")
    public String getAntiquity() {
        return antiquity;
    }

    @JsonSetter("aniversari_proveïdor")
    public void setAntiquity(String antiquity) {
        this.antiquity = antiquity;
    }

    // Patrocinadors
    @JsonGetter("patrocinadors_proveïdor")
    public String getSponsors() {
        return sponsors;
    }

    @JsonSetter("patrocinadors_proveïdor")
    public void setSponsors(String sponsors) {
        this.sponsors = sponsors;
    }

    // Raó social
    @JsonGetter("raosocial_proveïdor")
    public String getSocialreason() {
        return socialreason;
    }

    @JsonSetter("raosocial_proveïdor")
    public void setSocialreason(String socialreason) {
        this.socialreason = socialreason;
    }

    // Identificació
    @JsonGetter("identificacio_proveïdor")
    public int getIdent() {
        return ident;
    }

    @JsonSetter("identificacio_proveïdor")
    public void setIdent(int ident) {
        this.ident = ident;
    }

    // Treballadors
    @JsonGetter("treballadors_proveïdor")
    public int getWorkers() {
        return workers;
    }

    @JsonSetter("treballadors_proveïdor")
    public void setWorkers(int workers) {
        this.workers = workers;
    }
}
