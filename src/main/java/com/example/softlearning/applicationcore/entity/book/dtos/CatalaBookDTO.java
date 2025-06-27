package com.example.softlearning.applicationcore.entity.book.dtos;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName = "Llibres")

public class CatalaBookDTO {
    private String description, author, title, cover, gender, editorial, ISBN;
    private int code, page;
    private double price, high, width, length,  weight, depth;
    private boolean fragil;

    public CatalaBookDTO(){}
    public CatalaBookDTO(int code, double price, String description, String author, String title, String cover, int page,
            String gender, String editorial, String iSBN, double high, double width, double length, double weight,
            boolean fragil, double depth) {
        this.code = code;
        this.price = price;
        this.description = description;
        this.author = author;
        this.title = title;
        this.cover = cover;
        this.page = page;
        this.gender = gender;
        this.editorial = editorial;
        this.ISBN = iSBN;
        this.high = high;
        this.width = width;
        this.length = length;
        this.weight = weight;
        this.fragil = fragil;
        this.depth = depth;
    }

    // Codi
    @JsonGetter("codi_llibre")
    public int getCode() {
        return code;
    }

    @JsonSetter("codi_llibre")
    public void setCode(int code) {
        this.code = code;
    }

    // Price
    @JsonGetter("preu_llibre")
    public double getPrice() {
        return price;
    }

    @JsonSetter("preu_llibre")
    public void setPrice(double price) {
        this.price = price;
    }

    // Descripció
    @JsonGetter("descripcio_llibre")
    public String getDescription() {
        return description;
    }

    @JsonSetter("descripcio_llibre")
    public void setDescription(String description) {
        this.description = description;
    }

    // Autor
    @JsonGetter("autor_llibre")
    public String getAuthor() {
        return author;
    }

    @JsonSetter("autor_llibre")
    public void setAuthor(String author) {
        this.author = author;
    }

    // Títol
    @JsonGetter("titol_llibre")
    public String getTitle() {
        return title;
    }

    @JsonSetter("titol_llibre")
    public void setTitle(String title) {
        this.title = title;
    }

    // Portada
    @JsonGetter("portada_llibre")
    public String getCover() {
        return cover;
    }

    @JsonSetter("portada_llibre")
    public void setCover(String cover) {
        this.cover = cover;
    }

    // Pàgines
    @JsonGetter("pagines_llibre")
    public int getPage() {
        return page;
    }

    @JsonSetter("pagines_llibre")
    public void setPage(int page) {
        this.page = page;
    }

    // Gènere
    @JsonGetter("genere_llibre")
    public String getGender() {
        return gender;
    }

    @JsonSetter("genere_llibre")
    public void setGender(String gender) {
        this.gender = gender;
    }

    // Editorial
    @JsonGetter("editorial_llibre")
    public String getEditorial() {
        return editorial;
    }

    @JsonSetter("editorial_llibre")
    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    // ISBN
    @JsonGetter("isbn_llibre")
    public String getISBN() {
        return ISBN;
    }

    @JsonSetter("isbn_llibre")
    public void setISBN(String iSBN) {
        ISBN = iSBN;
    }

    // Altura
    @JsonGetter("altura_llibre")
    public double getHigh() {
        return high;
    }

    @JsonSetter("altura_llibre")
    public void setHigh(double high) {
        this.high = high;
    }

    // Amplada
    @JsonGetter("amplada_llibre")
    public double getWidth() {
        return width;
    }

    @JsonSetter("amplada_llibre")
    public void setWidth(double width) {
        this.width = width;
    }

    // Longitud
    @JsonGetter("longitud_llibre")
    public double getLength() {
        return length;
    }

    @JsonSetter("longitud_llibre")
    public void setLength(double length) {
        this.length = length;
    }

    // Pes
    @JsonGetter("pes_llibre")
    public double getWeight() {
        return weight;
    }

    @JsonSetter("pes_llibre")
    public void setWeight(double weight) {
        this.weight = weight;
    }

    // Fragil
    @JsonGetter("fragil_llibre")
    public boolean getFragil() {
        return fragil;
    }

    @JsonSetter("fragil_llibre")
    public void setFragil(boolean fragil) {
        this.fragil = fragil;
    }

    // Profunditat
    @JsonGetter("profunditat_llibre")
    public double getDepth() {
        return depth;
    }

    @JsonSetter("profunditat_llibre")
    public void setDepth(double depth) {
        this.depth = depth;
    }
}