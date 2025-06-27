package com.example.softlearning.applicationcore.entity.order.dtos;

public class OrderDTO {
    private final String description, initDate, finishDate, address, phoneContact, idClient, name, surname, DNI, paymentDate, deliveryDate, shopCart;
    private final int reference; 
    private final double high, width, depth, weight, length;
    private final boolean fragil;

    public OrderDTO(int reference, String description, String initDate, String address, String phoneContact, 
    String idClient, String name, String surname, String DNI, String paymentDate, String deliveryDate, String finishDate, double high, double width, 
    double depth, double weight, boolean fragil, double length, String shopCart){
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
    }

    public int getReference() {
        return reference;
    }

    public String getDescription() {
        return description;
    }

    public String getInitDate() {
        return initDate;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneContact() {
        return phoneContact;
    }

    public String getIdClient() {
        return idClient;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getDNI() {
        return DNI;
    }

    public String getPaymentDate() {
        return paymentDate;
    }

    public String getDeliveryDate() {
        return deliveryDate;
    }

    public String getFinishDate() {
        return finishDate;
    }

    public double getHigh() {
        return high;
    }

    public double getWidth() {
        return width;
    }

    public double getDepth() {
        return depth;
    }

    public double getWeight() {
        return weight;
    }

    public boolean getisFragil() {
        return fragil;
    }

    public double getLength() {
        return length;
    }

    public String getShopCartDetails(){
        return shopCart;
    }
}
