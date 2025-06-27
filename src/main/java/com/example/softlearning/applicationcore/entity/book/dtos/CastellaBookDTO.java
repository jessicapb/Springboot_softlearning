package com.example.softlearning.applicationcore.entity.book.dtos;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName = "Llibros")

public class CastellaBookDTO {
    private String description, author, title, cover, gender, editorial, ISBN;
    private int code, page;
    private double price, high, width, length,  weight, depth;
    private boolean fragil;
    public CastellaBookDTO(){}

    public CastellaBookDTO(int code, double price, String description, String author, String title, String cover, int page,
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
    @JsonGetter("codigo_libro")
    public int getCode() {
        return code;
    }

    @JsonSetter("codigo_libro")
    public void setCode(int code) {
        this.code = code;
    }

    // Price
    @JsonGetter("precio_libro")
    public double getPrice() {
        return price;
    }

    @JsonSetter("precio_libro")
    public void setPrice(double price) {
        this.price = price;
    }

    // Descripció
    @JsonGetter("descripcion_libro")
    public String getDescription() {
        return description;
    }

    @JsonSetter("descripcion_libro")
    public void setDescription(String description) {
        this.description = description;
    }

    // Autor
    @JsonGetter("autor_libro")
    public String getAuthor() {
        return author;
    }

    @JsonSetter("autor_libro")
    public void setAuthor(String author) {
        this.author = author;
    }

    // Títol
    @JsonGetter("titulo_libro")
    public String getTitle() {
        return title;
    }

    @JsonSetter("titulo_libro")
    public void setTitle(String title) {
        this.title = title;
    }

    // Portada
    @JsonGetter("portada_libro")
    public String getCover() {
        return cover;
    }

    @JsonSetter("portada_libro")
    public void setCover(String cover) {
        this.cover = cover;
    }

    // Pàgines
    @JsonGetter("paginas_libro")
    public int getPage() {
        return page;
    }

    @JsonSetter("paginas_libro")
    public void setPage(int page) {
        this.page = page;
    }

    // Gènere
    @JsonGetter("genero_libro")
    public String getGender() {
        return gender;
    }

    @JsonSetter("genero_libro")
    public void setGender(String gender) {
        this.gender = gender;
    }

    // Editorial
    @JsonGetter("editorial_libro")
    public String getEditorial() {
        return editorial;
    }

    @JsonSetter("editorial_libro")
    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    // ISBN
    @JsonGetter("isbn_libro")
    public String getISBN() {
        return ISBN;
    }

    @JsonSetter("isbn_libro")
    public void setISBN(String iSBN) {
        ISBN = iSBN;
    }

    // Altura
    @JsonGetter("altura_libro")
    public double getHigh() {
        return high;
    }

    @JsonSetter("altura_libro")
    public void setHigh(double high) {
        this.high = high;
    }

    // Amplada
    @JsonGetter("ancho_libro")
    public double getWidth() {
        return width;
    }

    @JsonSetter("ancho_libro")
    public void setWidth(double width) {
        this.width = width;
    }

    // Longitud
    @JsonGetter("longitud_libro")
    public double getLength() {
        return length;
    }

    @JsonSetter("longitud_libro")
    public void setLength(double length) {
        this.length = length;
    }

    // Pes
    @JsonGetter("peso_libro")
    public double getWeight() {
        return weight;
    }

    @JsonSetter("peso_libro")
    public void setWeight(double weight) {
        this.weight = weight;
    }

    // Fragil
    @JsonGetter("fragil_libro")
    public boolean getFragil() {
        return fragil;
    }

    @JsonSetter("fragil_libro")
    public void setFragil(boolean fragil) {
        this.fragil = fragil;
    }

    // Profunditat
    @JsonGetter("profundidad_libro")
    public double getDepth() {
        return depth;
    }

    @JsonSetter("profundidad_libro")
    public void setDepth(double depth) {
        this.depth = depth;
    }
}