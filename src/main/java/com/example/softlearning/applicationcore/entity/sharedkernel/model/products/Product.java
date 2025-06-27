package com.example.softlearning.applicationcore.entity.sharedkernel.model.products;


import com.example.softlearning.applicationcore.entity.sharedkernel.domainservices.validations.Check;
import com.example.softlearning.applicationcore.entity.sharedkernel.model.exceptions.BuildException;

public abstract class Product implements Marketable{
    protected int code;
    protected double price;
    protected String description;

    protected Product(){
    }
    
    public void CheckProduct (int code, double price, String description) throws BuildException {
        String message = "";
        int error = 0;

        if((error = setcode(code)) !=0){
            message += Check.getErrorMessage(error);
        }
        
        if((error = setprice(price)) !=0){
            message += Check.getErrorMessage(error);
        }

        if((error = setdescription(description)) !=0){
            message += Check.getErrorMessage(error);
        }

        if(message.length()>0){
            throw new BuildException(message);
        }
    }

    public int getcode() {
        return code;
    }

    public  int setcode(int code) {
        if(Check.isNegative(code) !=0){
            return -3;
        }
        this.code = code;
        return 0;
    }

    public double getprice() {
        return price;
    }

    public int setprice(double price) {
        if(Check.isNegatived(price) !=0){
            return -3;
        }
        this.price = price;
        return 0;
    }

    public String getdescription() {
        return description;
    }

    public int setdescription(String description) {
        if(Check.isNull(description) == true){
            return -1;
        }
        if(Check.minLenght(description, 4) !=0){
            return -2;
        }
        this.description = description;
        return 0;
    }

    public abstract String getDetails();
}
