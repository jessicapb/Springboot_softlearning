package com.example.softlearning.applicationcore.entity.provider.dtos;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "providers")
public class ProviderDTO {
    @Id
    @Column(name = "ident")
    private int ident;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "email")
    private String email;

    @Column(name = "number")
    private String number;

    @Column(name = "address")
    private String address;

    @Column(name = "antiquity")
    private String antiquity;

    @Column(name = "sponsors")
    private String sponsors;

    @Column(name = "workers")
    private int workers;

    @Column(name = "socialreason")
    private String socialreason;

    public ProviderDTO(){
    }

    public ProviderDTO(String name, String surname, String email, String number, String address, String antiquity, int ident, 
    String sponsors, int workers, String socialreason) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.number = number;
        this.address = address;
        this.antiquity = antiquity;
        this.ident = ident;
        this.sponsors = sponsors;
        this.workers = workers;
        this.socialreason = socialreason;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmail() {
        return email;
    }

    public String getNumber() {
        return number;
    }

    public String getAddress() {
        return address;
    }

    public String getAntiquity() {
        return antiquity;
    }

    public int getIdent() {
        return ident;
    }

    public String getSponsors() {
        return sponsors;
    }

    public int getWorkers() {
        return workers;
    }

    public String getSocialreason() {
        return socialreason;
    }

    @Override
    public String toString() {
        return "Proveïdor DTO identificador: " + ident + ", nom: " + name + ", cognoms: " + surname + ", correu elèctronic: " + email
                + ", número: " + number + ", adreça: " + address + ", antiguitat: " + antiquity + ", esponsors: " + sponsors
                + ", treballadors: " + workers + ", raó social: " + socialreason + "]";
    }
}
