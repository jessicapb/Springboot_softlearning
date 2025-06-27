package com.example.softlearning.applicationcore.entity.sharedkernel.model.stakeholder;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.example.softlearning.applicationcore.entity.sharedkernel.domainservices.validations.Check;
import com.example.softlearning.applicationcore.entity.sharedkernel.model.exceptions.BuildException;

public abstract class Person {
    protected String name;
    protected String surname;
    protected String email;
    protected String number;
    protected String address;
    protected LocalDate antiquity;
    protected int ident;
    protected DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    protected Person(){
    }

    public void PersonCheck(String name, String surname, String email, String number, String address, String antiquity, int ident) throws BuildException{
        String message = "";
        int error = 0;
        
        if((error = setName(name)) !=0){
            message +=  Check.getErrorMessage(error);
        }

        if((error = setSurname(surname)) !=0){
            message += Check.getErrorMessage(error);
        }

        if((error = setEmail(email)) !=0){
            message += Check.getErrorMessage(error);
        }

        if((error = setNumber(number)) !=0){
            message += Check.getErrorMessage(error);
        }

        if((error = setAddress(address)) !=0){
            message += Check.getErrorMessage(error);
        }
        
        if((error = setAntiquity(antiquity)) !=0){
            message += Check.getErrorMessage(error);
        }
        
        if((error=setIdent(ident)) !=0){
            message += Check.getErrorMessage(error);
        }
        
        if(message.length()>0){
            throw new BuildException(message);
        }
    }

    public String getName() {
        return name;
    }

    public int setName(String name) {
        if(Check.isNull(name) == true){
            return -1;
        }
        if(Check.minLenght(name, 3) !=0){
            return -2;
        }
        this.name = name;
        return 0;
    }

    public String getSurname() {
        return surname;
    }

    public int setSurname(String surname) {
        if(Check.isNull(surname) == true){
            return -1;
        }
        if(Check.minLenght(surname, 3) !=0){
            return -2;
        }
        this.surname = surname;
        return 0;
    }

    public String getEmail() {
        return email;
    }

    public int setEmail(String email) {
        if(Check.isNull(email) == true){
            return -1;
        }
        if(Check.minLenght(email, 2) !=0){
            return -2;
        }
        this.email = email;
        return 0;
    }

    public String getNumber() {
        return number;
    }

    public int setNumber(String number) {
        if(Check.isNull(number) == true){
            return -1;
        }
        if(Check.minLenght(number, 3) !=0){
            return -2;
        }
        this.number = number;
        return 0;
    }

    public String getAddress() {
        return address;
    }

    public int setAddress(String address) {
        if(Check.isNull(address) == true){
            return -1;
        }

        if(Check.minLenght(address, 6) !=0){
            return -2;
        }
        this.address = address;
        return 0;
    }

    public String getAntiquity() {
        return this.antiquity.format(formatter);
    }

    public int setAntiquity(String antiquity) {
        if(Check.isNull(antiquity) == true){
            return -1;
        }
        this.antiquity = LocalDate.parse(antiquity, formatter);
        return 0;
    }

    public int getIdent() {
        return ident;
    }

    public int setIdent(int ident) {
        if(Check.isNegative(ident) !=0){
            return -3;
        }
        this.ident = ident;
        return 0;
    }

    public abstract String getDetails();
}
