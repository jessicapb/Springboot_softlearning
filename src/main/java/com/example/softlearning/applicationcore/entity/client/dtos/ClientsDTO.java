package com.example.softlearning.applicationcore.entity.client.dtos;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "clients")
public class ClientsDTO {
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

    @Column(name = "paymentcode")
    private String paymentcode;

    public ClientsDTO(){
    }

    public ClientsDTO(String name, String surname, String email, String number, String address, String antiquity, int ident, String paymentcode) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.number = number;
        this.address = address;
        this.antiquity = antiquity;
        this.ident = ident;
        this.paymentcode = paymentcode;
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

    public String getPaymentcode() {
        return paymentcode;
    }

    @Override
    public String toString() {
        return "Client DTO identificador: " + ident + ", nom: " + name + ", cognoms: " + surname + ", correu elèctronic: " + email
                + ", número: " + number + ", adreça: " + address + ", antiguitat: " + antiquity + ", mètode de pagament: "
                + paymentcode + ".";
    }
}
