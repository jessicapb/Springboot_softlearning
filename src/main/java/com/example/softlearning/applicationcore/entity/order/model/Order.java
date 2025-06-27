package com.example.softlearning.applicationcore.entity.order.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.example.softlearning.applicationcore.entity.sharedkernel.domainservices.validations.Check;
import com.example.softlearning.applicationcore.entity.sharedkernel.model.exceptions.BuildException;
import com.example.softlearning.applicationcore.entity.sharedkernel.model.exceptions.ServiceException;
import com.example.softlearning.applicationcore.entity.sharedkernel.model.operations.Operation;
import com.example.softlearning.applicationcore.entity.sharedkernel.model.physics.PhysicalData;
import com.example.softlearning.applicationcore.entity.sharedkernel.model.products.Storable;

public class Order extends Operation implements Storable{
    protected String address;
    protected Set<String> phoneContact;
    protected String idClient;
    protected String name;
    protected String surname;
    protected String DNI;
    protected LocalDateTime paymentDate;//dia de pagament
    protected LocalDateTime deliveryDate;//fecha de entrega
    protected ArrayList<OrderDetail> shopCart;
    protected PhysicalData orderPackage;
    protected OrderStatus status;
    protected DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd-HH:mm:ss");

    protected Order(){
        this.phoneContact = new HashSet<String>();
        this.shopCart = new ArrayList<OrderDetail>();
        this.status = OrderStatus.CREATED;
    }

    //getInstance petit
    public static Order getInstanceOrder(String phoneContact, String idClient, String name, String surname) throws BuildException {
        String message ="";
        int error = 0;
        Order o = new Order();

        if((error = o.setPhoneContact(phoneContact)) !=0){
            message += Check.getErrorMessage(error);
        }
        
        if((error = o.setIdClient(idClient)) !=0){
            message += Check.getErrorMessage(error);
        }
        
        if((error = o.setName(name)) !=0){
            message += Check.getErrorMessage(error);
        }
        
        if((error = o.setSurname(surname)) !=0){
            message += Check.getErrorMessage(error);
        }
        
        if(message.length()>0){
            o = null;
            throw new BuildException(message);
        }
        return o;
    }

    //getInstance gran
    public static Order getInstanceOrder(int reference, String description, String initDate, String address, String phoneContact, 
        String idClient, String name, String surname, String DNI, String paymentDate, String deliveryDate,  String finishDate, double high, double width, 
        double depth, double weight, boolean fragil, double length, String shopCart) throws BuildException{
        String message ="";
        int error = 0;
        Order or = new Order();

        try{
            or.checkOperation(reference, description, initDate, null);
        }catch(BuildException e){
            message += e.getMessage();
        }

        try{
            or.orderPackage= PhysicalData.getInstancePhysical(high, width, length, weight, fragil, depth);
        }catch(BuildException e){
            message += e.getMessage();
        }

        if((error = or.setAddress(address)) !=0){
            message += Check.getErrorMessage(error);
        }

        if((error = or.setPhoneContact(phoneContact)) !=0){
            message += Check.getErrorMessage(error);
        }

        if((error = or.setIdClient(idClient)) !=0){
            message += Check.getErrorMessage(error);
        }

        if((error = or.setName(name)) !=0){
            message += Check.getErrorMessage(error);

        }

        if((error = or.setSurname(surname)) !=0){
            message += Check.getErrorMessage(error);
        }

        if((error = or.setDNI(DNI)) !=0){
            message += Check.getErrorMessage(error);
        }
    
        if (paymentDate != null) {
            try {
                if ((error = or.setPaymentDate(paymentDate)) != 0) {
                    message += Check.getErrorMessage(error);
                }
            } catch (Exception e) {
                message += e.getMessage();
            }
        }
    
        if (deliveryDate != null) {
            try {
                if ((error = or.setDeliveryDate(deliveryDate)) != 0) {
                    message += Check.getErrorMessage(error);
                }
            } catch (Exception e) {
                message += e.getMessage();
            }
        }

        if (finishDate != null) {
            try {
                if ((error = or.setFinishDate(finishDate)) != 0) {
                    message += Check.getErrorMessage(error);
                }
            } catch (Exception e) {
                message += e.getMessage();
            }
        }

        if(shopCart !=null){
            if((error = or.setShopCartDetails(shopCart)) !=0){
                message += Check.getErrorMessage(error);
            }
        }

        if(message.length()>0){
            or = null;
            throw new BuildException(message);
        }
        return or;
    }

    //Dades del pare
    public String getInitDate() {
        if(this.initDate != null){
            return this.initDate.format(formatter);
        }
        return "";
    }
    
    public int setInitDate(String initDate) {
        try {
            this.initDate = LocalDateTime.parse(initDate, formatter);
            this.status = OrderStatus.CREATED;
            return 0;
        } catch (Exception e) {
            System.out.println("Error amb la data d'inici");
            return -1;
        }
    }
    
    public String getFinishDate() {
        if(this.finishDate != null){
                return this.finishDate.format(formatter);
        }
        return "";
    }
    
    public int setFinishDate(String finishDate) {
        try {
            this.finishDate = LocalDateTime.parse(finishDate, formatter);
            this.status = OrderStatus.FINISHED;
            return 0;
        } catch (Exception e) {
            System.out.println("Error amb la data de finalització");
            return -1;
        }
    }

    public String getAddress() {
        return this.address;
    }

    public int setAddress(String address) {
        if(Check.minLenght(address, 6) !=0){
            return -2;
        }
        this.address = address;
        return 0;
    }

    public String getPhoneContact() {
        return this.phoneContact.toString();//join contenar o unir
    }

    public int setPhoneContact(String phoneContact) {
        if(Check.minLenght(phoneContact, 9) !=0){
            return -2;
        }
        this.phoneContact.add(phoneContact);
        return 0;
    }

    public String getIdClient() {
        return idClient;
    }

    public int setIdClient(String idClient) {
        if(Check.minLenght(idClient, 6) !=0){
            return -2;
        }
        this.idClient = idClient;
        return 0;
    }

    public String getName() {
        return this.name;
    }

    public int setName(String name) {
        if(Check.minLenght(name, 2) !=0){
            return -2;
        }
        this.name = name;
        return 0;
    }

    public String getSurname() {
        return this.surname;
    }

    public int setSurname(String surname) {
        if(Check.minLenght(surname, 4) !=0){
            return -2;
        }
        this.surname = surname;
        return 0;
    }

    public String getDNI() {
        return this.DNI;
    }

    public int setDNI(String DNI) {
        if(Check.minLenght(DNI, 9) !=0){
            return -2;
        }
        this.DNI = DNI;
        return 0;
    }

    public String getPaymentDate() {
        if(this.paymentDate !=null){
            return this.paymentDate.format(formatter);
        }
        return "";
    }

    public int setPaymentDate(String paymentDate) {
        try {
            this.paymentDate = LocalDateTime.parse(paymentDate, formatter);
            this.status = OrderStatus.CONFIRMED;
            return 0;
        } catch (Exception e) {
            System.out.println("Error amb la data de pagament");
            return -1;
        }
    }

    public String getDeliveryDate() {
        if(this.deliveryDate !=null){
            return this.deliveryDate.format(formatter);
        }
        return "";
    }

    public int setDeliveryDate(String deliveryDate)throws Exception {
        try {
            this.deliveryDate = LocalDateTime.parse(deliveryDate, formatter);
            this.status = OrderStatus.DELIVERED;
            return 0;
        } catch (Exception e) {
            System.out.println("Error amb la data d'entrega");
            return -1;
        }
    }

    //PhysicalData
    @Override
    public double getHigh() {
        return this.orderPackage.getHigh();
    }

    @Override
    public int setHigh(double high) {
        return this.orderPackage.setHigh(high);
    }

    @Override
    public double getLength() {
        return this.orderPackage.getLength();
    }

    @Override
    public int setLength(double length) {
        return this.orderPackage.setLength(length);
    }
    
    @Override
    public double getWeight(){
        return this.orderPackage.getWeight();
    }
    
    @Override
    public int setWeight(double weight) {
        return this.orderPackage.setWeight(weight);
    }
    
    @Override
    public double getWidth(){
        return this.orderPackage.getWidth();
    }

    @Override
    public int setWidth(double width) {  
        return this.orderPackage.setWidth(width) ;
    }
    
    @Override
    public double getVolume(){
        return  this.orderPackage.getLength() * this.orderPackage.getWidth() * this.orderPackage.getHigh();
    }
    
    @Override
    public double getCalcularVolum(){
        return this.orderPackage.getVolume();
    }
    
    @Override
    public boolean getFragil() {
        return this.orderPackage.getFragil();
    }
    
    @Override
    public int setFragil(boolean fragil) {
        return this.orderPackage.setFragil(fragil);
    }

    @Override
    public double getDepth() {
        return this.orderPackage.getDepth();
    }
    
    @Override
    public int setDepth(double depth) {
        return this.orderPackage.setDepth(depth);
    }

    public void setPackagedDimensions(String physics)throws BuildException{
        String[] parts = physics.split(",");
        double high = 0;
        double width = 0;
        double depth = 0;
        double weight = 0;
        boolean fragil = true;
        double length = 0;

        for(String part : parts){
            String[] keyvalue = part.split(":");
            switch (keyvalue[0]){

                case "h":
                high = Double.parseDouble(keyvalue[1]);
                break;

                case "w":
                width = Double.parseDouble(keyvalue[1]);
                break;

                case "d":
                depth = Double.parseDouble(keyvalue[1]);
                break;

                case "we":
                weight = Double.parseDouble(keyvalue[1]);
                break;

                case "f":
                fragil = Boolean.parseBoolean(keyvalue[1]);
                break;

                case "l":
                length = Double.parseDouble(keyvalue[1]);
                default:
                break;
            }
        }
        this.orderPackage = PhysicalData.getInstancePhysical(high, width, length, weight, fragil, depth);
        this.status = OrderStatus.FORTHCOMMING;
    }

    public String getPackedDimensions(){
        return "h: " + this.orderPackage.getHigh() + 
        ", w: " + this.orderPackage.getWidth() +
        ", l: " + this.orderPackage.getLength() +
        ", we: " + this.orderPackage.getWeight()+ 
        ", f: " + this.orderPackage.getFragil()+
        ", d: " + this.orderPackage.getDepth();       
    }
    

    //Carrito de la compra
    public int getNumDetails(){
        return this.shopCart.size();
    }

public int setDetail(String namearticles, int quantity, String referencenum, double individualPrice, int discount, double total){
    try {
        OrderDetail d = OrderDetail.getInstanceDetail(namearticles, quantity, referencenum, individualPrice, discount, total);
        this.shopCart.add(d);
        System.out.println("Detall afegit: " + d);
        return 0;
    } catch (BuildException e) {
        System.out.println("Error creant el carrito: " + e);
        return -1; 
    }
}


    public String getDetail(int pos)throws ServiceException{
        if(this.status == OrderStatus.CREATED){
            if (pos < 0 || pos > this.shopCart.size()) {
                return "Posició incorrecta"; 
            }
            
            OrderDetail d = this.shopCart.get(pos); 
            return d.getDetails();
        }
        throw new ServiceException("Sembla que no hi ha ningún Order Detail creat");
    }

    public String getDetail(String ref)throws ServiceException{
        if(this.status == OrderStatus.CREATED){
            String product ="";
            for(int i = 0; i < this.shopCart.size();i++){
                if(this.shopCart.get(i).getReference().equals(ref) == true){
                    product = this.shopCart.get(i).getDetails();
                }
            }
            return product;
        }
        throw new ServiceException("Sembla que no hi ha ningún Order Detail creat");
    }

    public int updateDetail(int pos, int amount)throws ServiceException{
        if(this.status == OrderStatus.CREATED){
            if (pos < 0 || pos >= this.shopCart.size()) {
                throw new ServiceException("No existeix el producte");
            } else {
                this.shopCart.get(pos).setQuantity(amount);
            }
            return 0;
        }else{
            throw new ServiceException("No es pot eliminar perquè està pagat.");
        }
    }

    public int updateDetail(String ref, int amount)throws ServiceException{
        if(this.status == OrderStatus.CREATED){
            for (int i = 0; i < this.shopCart.size(); i++) {
                if (this.shopCart.get(i).getReference().equals(ref)) {
                    this.shopCart.get(i).setQuantity(amount); 
                    return 0;
                }
            }
            throw new ServiceException("No existeix el producte");
        }else{
            throw new ServiceException("No es pot eliminar perquè està pagat.");
        }
    }

    public int deleteDetail(int pos)throws ServiceException{
        if(this.status == OrderStatus.CREATED){
            if (pos < 0 || pos > this.shopCart.size()) {
                throw new ServiceException("No existeix el producte");
            } else {
                this.shopCart.remove(pos);
            }
        }else{
            throw new ServiceException("No es pot eliminar perquè està pagat.");
        }
        return -1;
    }

    public int deleteDetail(String ref)throws ServiceException{
        if(this.status == OrderStatus.CREATED){
            for (int i = 0; i < this.shopCart.size(); i++) {
                if (this.shopCart.get(i).getReference().equals(ref)) {
                    this.shopCart.remove(i);
                    return 0;
                }
            }
            throw new ServiceException("No existeix el producte.");
        }else{
            throw new ServiceException("No es pot eliminar perquè està pagat.");
        }
    }

    public double getPrice(){
        double total = 0;
        if (this.shopCart != null) {
            for (int i = 0; i < this.shopCart.size(); i++) {
                total += this.shopCart.get(i).getTotal();
            }
        }
        return total;
    }

    public String getStatus(){
        return status.name();
    }
    
    public int shopcartcancelled(){
        if(this.status == OrderStatus.CREATED){
            if(this.shopCart.size() > 0){
                for(int i = 0; i < this.shopCart.size(); i++){
                    this.shopCart.remove(i);
                    this.status = OrderStatus.CANCELLED;
                }
                return 0;
            }else{
                return -2;
            }
        }
        return -1;
    }

    public int setShopCartDetails(String shopCart) throws BuildException{
        String namearticles = "";
        int quantity = 0;
        String referencenum = "";
        double individualPrice = 0;
        int discount = 0;
        double total = 0;
        
        String[] rows = shopCart.split(";");
        
        for (String row : rows) { 
            String[] columns = row.split(",");
            for (String column : columns) {
                String[] keyvalue = column.split(":");
                
                switch (keyvalue[0]) {
                    case "nomarticle":
                        namearticles =  keyvalue[1];
                        break;
                    case "quantitat":
                        quantity = Integer.parseInt(keyvalue[1]);
                        
                        break;
                    case "referencia":
                        referencenum = keyvalue[1];
                        break;
                    case "preuindividual":
                        individualPrice = Double.parseDouble(keyvalue[1]);
                        break;
                    case "descompte":
                        discount = Integer.parseInt(keyvalue[1]);
                        break;
                    case "total":
                        total = Double.parseDouble(keyvalue[1]);
                        System.out.println(total);
                        break;
                    default:
                }
            }
        }
        OrderDetail orderDetail = OrderDetail.getInstanceDetail(namearticles, quantity, referencenum, individualPrice, discount, total);
        this.shopCart.add(orderDetail);
        return 0;
    }

    public String getShopCartDetails(){
        String details = "";
        for(int i = 0; i <this.shopCart.size();i++){
            details += 
            "nomarticle:" + this.shopCart.get(i).getNamearticles() + "," + 
            "quantitat:" + this.shopCart.get(i).getQuantity() + ","+ 
            "referencia:" + this.shopCart.get(i).getReference() + "," + 
            "preuindividual:" + this.shopCart.get(i).getIndividualPrice() + "," + 
            "descompte:" + this.shopCart.get(i).getDiscount() + "," + 
            "total:" + this.shopCart.get(i).getTotal() + ";";
        }
        return details;
    }

    public List<OrderDetail> getShopCart() {
        return this.shopCart;
    }

    public String getDetails() {
        return "Factura Número d'operació: " + reference 
                + ", Descripció: " + description 
                + ", Data d'inici: " + this.getInitDate()
                + ", Adreça: " + address 
                + ", Número de contacte: " + phoneContact
                + ", Número de soci: " + idClient 
                + ", Nom del client: " + name 
                + ", Cognoms: " + surname 
                + ", DNI: " + DNI
                + ", Dia de pagament: " + this.getPaymentDate() 
                + ", Dia d'entrega: " + this.getDeliveryDate()
                + ", Data final: " + getFinishDate() 
                + ", Estat de la compra: " + this.getStatus() 
                + ", Carrito de la compra" + getShopCartDetails();
    }
}
