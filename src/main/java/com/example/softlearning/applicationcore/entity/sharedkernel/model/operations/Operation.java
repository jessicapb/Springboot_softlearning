package com.example.softlearning.applicationcore.entity.sharedkernel.model.operations;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.example.softlearning.applicationcore.entity.sharedkernel.domainservices.validations.Check;
import com.example.softlearning.applicationcore.entity.sharedkernel.model.exceptions.BuildException;

public abstract class Operation {
    protected int reference;
    protected String description;
    protected LocalDateTime initDate;//data de començament
    protected LocalDateTime finishDate;//dia de final
    protected DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd-HH:mm:ss");

    protected Operation(){
    }

    public void checkOperation(int reference, String description, String initDate, String finishDate) throws BuildException{
        String message = "";
        int error = 0;
        if((error= setReference(reference)) !=0){
            message +=  Check.getErrorMessage(error);
        }
        
        if((error= setDescription(description)) !=0){
            message +=  Check.getErrorMessage(error);
        }

        if(initDate !=null){
            if((error = setInitDate(initDate)) !=0){
                message +=  Check.getErrorMessage(error);
            }
        }

        if(finishDate !=null){
            if((error = setFinishDate(finishDate)) !=0){
                message +=  Check.getErrorMessage(error);
            }
        }

        if(message.length()>0){
            throw new BuildException(message);
        }
    }

    public int getReference() {
        return reference;
    }

    public int setReference(int reference) {
        if(Check.isNegative(reference) !=0){
            return -3;
        }
        this.reference = reference;
        return 0;
    }

    public String getDescription() {
        return description;
    }

    public int setDescription(String description) {
        if(Check.minLenght(description, 5) !=0){
            return -2;
        }
        this.description = description;
        return 0;
    }

    public String getInitDate() {
        if(this.initDate != null){
            return this.initDate.format(formatter);
        }
        return "";
    }

    public int setInitDate(String initDate) {
        this.initDate = LocalDateTime.parse(initDate,formatter);
        return 0;
    }


    public String  getFinishDate() {
        if(this.finishDate !=null){
            return this.finishDate.format(formatter);
        }
        return "";
    }

    public int setFinishDate(String  finishDate) {
        this.finishDate = LocalDateTime.parse(finishDate,formatter);
        return 0;
    }

    public abstract String getDetails();
}
