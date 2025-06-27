package com.example.softlearning.applicationcore.entity.employee.dtos;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "employees")
public class EmployeeDTO {
    @Id

    @Column(name = "ident")
    private int ident;

    @Column(name = "name")
    private String name;

    @Column(name ="surname")
    private String  surname;

    @Column(name = "email")
    private String email;

    @Column(name = "number")
    private String number;

    @Column(name = "address")
    private String address;

    @Column(name = "antiquity")
    private String antiquity;

    @Column(name = "departament")
    private String department;

    @Column(name = "schedule")
    private String schedule;

    @Column(name = "bankaccount")
    private int  bankaccount;

    public EmployeeDTO() {
    }

    public EmployeeDTO(String name, String surname, String email, String number, String address,
            String antiquity, int ident, String department, String schedule, int bankaccount) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.number = number;
        this.address = address;
        this.antiquity = antiquity;
        this.ident = ident;
        this.department = department;
        this.schedule = schedule;
        this.bankaccount = bankaccount;
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

    public String getDepartment() {
        return department;
    }

    public String getSchedule() {
        return schedule;
    }

    public int getBankaccount() {
        return bankaccount;
    }

    @Override
    public String toString() {
        return "Treballador DTO identificador: " + ident + ", nom: " + name + ", cognoms: " + surname + ", correu elèctronic:" + email
                + ", número: " + number + ", adreça: " + address + ", antiguitat: " + antiquity + ", departament: "
                + department + ", horario: " + schedule + ", conta del banc: " + bankaccount + ".";
    }
}
