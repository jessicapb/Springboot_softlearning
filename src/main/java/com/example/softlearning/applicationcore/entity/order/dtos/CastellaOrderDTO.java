package com.example.softlearning.applicationcore.entity.order.dtos;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName = "Compra")

public class CastellaOrderDTO {
    private String description, initDate, finishDate, address, phoneContact, idClient, name, surname, DNI, paymentDate, deliveryDate, shopCart,status;
    private int reference; 
    private double high, width, depth, weight, length;
    private boolean fragil;

    public CastellaOrderDTO(){}

    public CastellaOrderDTO(int reference, String description, String initDate, String address, String phoneContact, 
    String idClient, String name, String surname, String DNI, String paymentDate, String deliveryDate, String finishDate, double high, double width, 
    double depth, double weight, boolean fragil, double length, String shopCart, String status){
        this.reference = reference;
        this.description = description;
        this.initDate = initDate;
        this.address = address;
        this.phoneContact = phoneContact; 
        this.idClient = idClient;
        this.name = name;
        this.surname = surname;
        this.DNI = DNI;
        this.paymentDate = paymentDate;
        this.deliveryDate = deliveryDate;
        this.finishDate = finishDate;
        this.high = high;
        this.width = width;
        this.depth = depth;
        this.weight = weight;
        this.fragil = fragil;
        this.length = length;
        this.shopCart = shopCart;
        this.status = status;
    }

    // Referencia
    @JsonGetter("referencia_compra")
    public int getReference() {
        return reference;
    }

    @JsonSetter("referencia_compra")
    public void setReference(int reference) {
        this.reference = reference;
    }

    // Descripció
    @JsonGetter("descripcion_compra")
    public String getDescription() {
        return description;
    }

    @JsonSetter("descripcion_compra")
    public void setDescription(String description) {
        this.description = description;
    }

    // Data d'inici
    @JsonGetter("fechainicio_compra")
    public String getInitDate() {
        return initDate;
    }

    @JsonSetter("fechainicio_compra")
    public void setInitDate(String initDate) {
        this.initDate = initDate;
    }

    // Adreça
    @JsonGetter("direccion_compra")
    public String getAddress() {
        return address;
    }

    @JsonSetter("direccion_compra")
    public void setAddress(String address) {
        this.address = address;
    }

    // Número telèfon
    @JsonGetter("telefono_compra")
    public String getPhoneContact() {
        return phoneContact;
    }

    @JsonSetter("telefono_compra")
    public void setPhoneContact(String phoneContact) {
        this.phoneContact = phoneContact;
    }

    // Idclient
    @JsonGetter("idcliente_compra")
    public String getIdClient() {
        return idClient;
    }

    @JsonSetter("idcliente_compra")
    public void setIdClient(String idClient) {
        this.idClient = idClient;
    }

    // Nom
    @JsonGetter("nombre_compra")
    public String getName() {
        return name;
    }

    @JsonSetter("nombre_compra")
    public void setName(String name) {
        this.name = name;
    }

    // Cognoms
    @JsonGetter("apellidos_compra")
    public String getSurname() {
        return surname;
    }

    @JsonSetter("apellidos_compra")
    public void setSurname(String surname) {
        this.surname = surname;
    }

    // DNI
    @JsonGetter("DNI_compra")
    public String getDNI() {
        return DNI;
    }

    @JsonSetter("DNI_compra")
    public void setDNI(String dNI) {
        DNI = dNI;
    }

    // Data de pagament
    @JsonGetter("fechapago_compra")
    public String getPaymentDate() {
        return paymentDate;
    }

    @JsonSetter("fechapago_compra")
    public void setPaymentDate(String paymentDate) {
        this.paymentDate = paymentDate;
    }

    // Data d'entrega
    @JsonGetter("fechaentrega_compra")
    public String getDeliveryDate() {
        return deliveryDate;
    }

    @JsonSetter("fechaentrega_compra")
    public void setDeliveryDate(String deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    // Data final
    @JsonGetter("fechafinal_compra")
    public String getFinishDate() {
        return finishDate;
    }

    @JsonSetter("fechafinal_compra")
    public void setFinishDate(String finishDate) {
        this.finishDate = finishDate;
    }

    // Altura
    @JsonGetter("altura_compra")
    public double getHigh() {
        return high;
    }

    @JsonSetter("altura_compra")
    public void setHigh(double high) {
        this.high = high;
    }

    // Amplada
    @JsonGetter("ancho_compra")
    public double getWidth() {
        return width;
    }

    @JsonSetter("ancho_compra")
    public void setWidth(double width) {
        this.width = width;
    }

    // Profunditat
    @JsonGetter("profundidad_compra")
    public double getDepth() {
        return depth;
    }

    @JsonSetter("profundidad_compra")
    public void setDepth(double depth) {
        this.depth = depth;
    }

    // Pes
    @JsonGetter("peso_compra")
    public double getWeight() {
        return weight;
    }

    @JsonSetter("peso_compra")
    public void setWeight(double weight) {
        this.weight = weight;
    }

    // Fragil
    @JsonGetter("fragil_compra")
    public boolean getFragil() {
        return fragil;
    }

    @JsonSetter("fragil_compra")
    public void setFragil(boolean fragil) {
        this.fragil = fragil;
    }

    // Longitud
    @JsonGetter("longitud_compra")
    public double getLength() {
        return length;
    }

    @JsonSetter("longitud_compra")
    public void setLength(double length) {
        this.length = length;
    }

    // Carrito compra
    @JsonGetter("carritocompra_compra")
    public String getShopCart() {
        return shopCart;
    }

    @JsonSetter("carritocompra_compra")
    public void setShopCart(String shopCart) {
        this.shopCart = shopCart;
    }

    // Estat
    @JsonGetter("estado_compra")
    public String getStatus() {
        return status;
    }
    
    @JsonSetter("estado_compra")
    public void setStatus(String status) {
        this.status = status;
    }
}
