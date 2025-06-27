package com.example.softlearning.applicationcore.entity.courses.model;

import com.example.softlearning.applicationcore.entity.sharedkernel.domainservices.validations.Check;
import com.example.softlearning.applicationcore.entity.sharedkernel.model.exceptions.BuildException;
import com.example.softlearning.applicationcore.entity.sharedkernel.model.products.Product;

public class Courses extends Product{
    protected int hours;
    protected String department;
    protected int password;

    protected Courses(){
    }

    public static Courses getInstanceCourses(int code, double price, String description, int hours, String department) throws BuildException{
        String message ="";
        int error = 0;
        Courses c = new Courses();

        try{
            c.CheckProduct(code, price, description);
        }catch(BuildException e){
            message += e.getMessage();
        }

        if((error = c.setHours(hours)) !=0){
            message += Check.getErrorMessage(error);
        }

        if((error = c.setDepartment(department)) !=0){
            message += Check.getErrorMessage(error);
        }
        
        if((error = c.setPassword(7989)) !=0){
            message += Check.getErrorMessage(error);
        }
        
        if(message.length()>0){
            c = null;
            throw new BuildException(message);
        }
        return c;
    }

    public int getHours() {
        return hours;
    }

    public int setHours(int hours) {
        if(Check.isNegative(hours) !=0){
            return -3;
        }
        this.hours = hours;
        return 0;
    }

    public String getDepartment() {
        return department;
    }

    public int setDepartment(String department) {
        if(Check.isNull(department) == true){
            return -1;
        }

        if(Check.minLenght(department, 3) !=0){
            return -2;
        }
        this.department = department;
        return 0;
    }

    public int getPassword() {
        return password;
    }

    public int setPassword(int password) {
        if(Check.isNegative(password) !=0){
            return -3;
        }
        this.password = password;
        return 0;
    }

    @Override
    public String getDetails() {
        return "CURS: Codi del producte:" + code + ", Preu:" + price + ", Descripció:" + description + ", Hores:" + hours + ", Departament:" + department + "";
    }   
}