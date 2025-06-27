package com.example.softlearning.applicationcore.entity.employee.model;

import com.example.softlearning.applicationcore.entity.sharedkernel.domainservices.validations.Check;
import com.example.softlearning.applicationcore.entity.sharedkernel.model.exceptions.BuildException;
import com.example.softlearning.applicationcore.entity.sharedkernel.model.stakeholder.Person;

public class Employee extends Person{
    protected String department;
    protected String schedule;
    protected int bankaccount;

    protected Employee(){
    }

    public static Employee getInstanceEmployee(String name, String surname, String email, String number, String address,
            String antiquity, int ident, String department, String schedule, int bankaccount)throws BuildException {
        String message ="";
        int error = 0;
        Employee em = new Employee();

        try {
            em.PersonCheck(name, surname, email, number, address,antiquity, ident);
        } catch (BuildException e) {
            message += e.getMessage();
        }

        if((error = em.setDepartment(department)) !=0){
            message += Check.getErrorMessage(error);
        }

        if((error = em.setSchedule(schedule)) !=0){
            message += Check.getErrorMessage(error);
        }

        if((error = em.setbankaccount(bankaccount)) !=0){
            message += Check.getErrorMessage(error);
        }

        if(message.length()>0){
            em = null;
            throw new BuildException(message);
        }
        return em;
    }

    public String getDepartment() {
        return department;
    }

    public int setDepartment(String department) {
        if(Check.isNull(department) == true){
            return -1;
        }
        if(Check.minLenght(department, 2) !=0){
            return -2;
        }
        this.department = department;
        return 0;
    }

    public String getSchedule() {
        return schedule;
    }

    public int setSchedule(String schedule) {
        if(Check.isNull(schedule) == true){
            return -1;
        }
        if(Check.minLenght(schedule, 4) !=0){
            return -2;
        }
        if(Check.isNegative(ident) !=0){
            return -3;
        }
        this.schedule = schedule;
        return 0;
    }

    public int getBackaccount() {
        return bankaccount;
    }

    public int setbankaccount(int bankaccount) {
        if(Check.isNegative(bankaccount) !=0){
            return -3;
        }
        this.bankaccount = bankaccount;
        return 0;
    }

    @Override
    public String getDetails() {
        return "TREBALLADOR: Nom: " + name + ", Cognoms: " + surname + ", Email: " + email
                + ", Número telèfon: " + number + ", Adreça: " + address + ", Antiguitat: " + antiquity + ", Identificador: " + ident + ", Departament: "
                + department + ", Horari Laboral: " + schedule + ", Conta del banc: " + bankaccount + "";
    }
}