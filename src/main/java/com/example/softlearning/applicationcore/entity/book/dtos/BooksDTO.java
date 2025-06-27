package com.example.softlearning.applicationcore.entity.book.dtos;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "books")
public class BooksDTO {
    @Id
    @Column(name = "code")
    private int code;

    @Column(name = "price")
    private double price;

    @Column(name = "description")
    private String description;

    @Column(name = "author")
    private String author;

    @Column(name = "title")
    private String title;

    @Column(name = "cover")
    private String cover;

    @Column(name = "page")
    private int page;

    @Column(name = "gender")
    private String gender;

    @Column(name = "editorial")
    private String editorial;

    @Column(name = "isbn")
    private String isbn;

    @Column(name = "high")
    private double high;

    @Column(name = "width")
    private double width;

    @Column(name = "length")
    private double length;

    @Column(name = "weight")
    private double weight;

    @Column(name = "fragil")
    private boolean fragil;

    @Column(name = "depth")
    private double depth;

    public BooksDTO(){
    }

    public BooksDTO(int code, double price, String description, String author, String title, String cover, int page, String gender, String editorial, 
    String isbn, double high, double width, double length, double weight,boolean fragil, double depth) {
        this.code = code;
        this.price = price;
        this.description = description;
        this.author = author;
        this.title = title;
        this.cover = cover;
        this.page = page;
        this.gender = gender;
        this.editorial = editorial;
        this.isbn = isbn;
        this.high = high;
        this.width = width;
        this.length = length;
        this.weight = weight;
        this.fragil= fragil;
        this.depth = depth;
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

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public String getCover() {
        return cover;
    }

    public int getPage() {
        return page;
    }

    public String getGender() {
        return gender;
    }

    public String getEditorial() {
        return editorial;
    }

    public String getISBN() {
        return isbn;
    }

    public double getHigh() {
        return high;
    }

    public double getWidth() {
        return width;
    }

    public double getLength() {
        return length;
    }

    public double getWeight() {
        return weight;
    }

    public boolean getFragil() {
        return fragil;
    }

    public double getDepth() {
        return depth;
    }

    @Override
    public String toString() {
        return "Llibre DTO codi: " + code + ", preu: " + price + ", descripció: " + description + ", autor: " + author
                + ", títol: " + title + ", portada: " + cover + ", pagines: " + page + ", genere: " + gender + ", editorial: "
                + editorial + ", ISBN: " + isbn + ", altura: " + high + ", amplada: " + width + ", longitud: " + length
                + ", pes: " + weight + ", fragil: " + fragil + ", profunditat: " + depth + ".";
    }
}
