package com.example.softlearning.applicationcore.entity.courses.dtos;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "courses")
public class CoursesDTO {
    @Id
    @Column(name ="code")
    private int code;

    @Column(name = "price")
    private double price;

    @Column(name = "description")
    private String description;

    @Column(name = "hours")
    private int hours;

    @Column(name = "department")
    private String department;

    public CoursesDTO(){
    }

    public CoursesDTO(int code, double price, String description, int hours, String department) {
        this.code = code;
        this.price = price;
        this.description = description;
        this.hours = hours;
        this.department = department;
    }

    public int getCode() {
        return code;
    }

    public double getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public int getHours() {
        return hours;
    }

    public String getDepartment() {
        return department;
    }

    @Override
    public String toString() {
        return "Curs DTO codi: " + code + ", preu: " + price + ", descripció: " + description + ", hores: " + hours + ", departament: " + department + ".";
    }
}