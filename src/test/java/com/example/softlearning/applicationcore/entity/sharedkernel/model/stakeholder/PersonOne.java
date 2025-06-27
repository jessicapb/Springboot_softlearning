package com.example.softlearning.applicationcore.entity.sharedkernel.model.stakeholder;

public class PersonOne extends Person{
    @Override
    public String getDetails() {
        return "PERSONONE: Nom: " + name + ", Cognoms: " + surname + ", Email: " + email + ", Número telèfon:: " + number
                + ", Adreça: " + address + ", Antiguitat: " + antiquity + ", Identificació: " + ident + "";
    }
}
