package com.example.softlearning.applicationcore.entity.provider.model;

import com.example.softlearning.applicationcore.entity.sharedkernel.domainservices.validations.Check;
import com.example.softlearning.applicationcore.entity.sharedkernel.model.exceptions.BuildException;
import com.example.softlearning.applicationcore.entity.sharedkernel.model.stakeholder.CompanyData;
import com.example.softlearning.applicationcore.entity.sharedkernel.model.stakeholder.Person;
import com.example.softlearning.applicationcore.entity.sharedkernel.model.stakeholder.Stakeholder;

public class Provider extends Person implements Stakeholder{
    protected String sponsors;
    protected CompanyData comp;

    protected Provider(){
    }

    public static Provider getInstanceProvider(String name, String surname, String email, String number, String address, String antiquity, int ident, 
            String sponsors, int workers, String socialreason)throws BuildException {
        String message = "";
        int error = 0;

        Provider pr = new Provider();
        try {
        pr.PersonCheck(name, surname, email, number, address, antiquity, ident);
        } catch (BuildException e) {
        message += e.getMessage();
        }

        try {
            pr.comp = CompanyData.getInstanceCompanyData(workers, socialreason);
        } catch (BuildException e) {
            message += e.getMessage();
        }

        if ((error = pr.setSponsors(sponsors)) != 0) {
            message += Check.getErrorMessage(error);
        }

        if(message.length()>0){
            pr = null;
            throw new BuildException(message);
        }
        return pr;
    }

    public String getSponsors(){
        return sponsors;
    }

    public int setSponsors(String sponsors) {
        if(Check.isNull(sponsors) == true){
            return -1;
        }
        if(Check.minLenght(sponsors, 3) !=0){
            return -2;
        }
        this.sponsors = sponsors;
        return 0;
    }

    //MÈTODES COMPANYDATA
    public int getWorkers() {
        return this.comp.getWorkers();
    }

    public String getSocialreason() {
        return this.comp.getSocialreason();
    }

    public String getCompanyType() {
        return this.comp.getCompanyType();
    }

    @Override
    public String getDetails() {
        return "PROVEÏDOR: Nom: " + name + ", Cognoms: " + surname + ", Email: " + email + ", Número telèfon: " + number
                + ", Adreça: " + address + ", Antiguitat: " + antiquity + ", Identificador: " + ident + ", Empresa on treballa: " + sponsors
                + ", Treballadors: " + this.getWorkers() + ", Empresa: " + this.getSocialreason() +"";
    }
}
