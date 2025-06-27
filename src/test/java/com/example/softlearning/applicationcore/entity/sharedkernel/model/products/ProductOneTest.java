package com.example.softlearning.applicationcore.entity.sharedkernel.model.products;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.softlearning.applicationcore.entity.sharedkernel.model.exceptions.BuildException;

public class ProductOneTest {
    private ProductOne product;
    
    @BeforeEach
    public void setUp() throws Exception {
        product = new ProductOne();
        product.CheckProduct(13, 12.34, "Javava");
    }
    
    // GetInstance Correcta
    @Test
    void testgetInstanceProduct() {
        try {
            product.CheckProduct(13, 12.34, "Javava");
            assertNotNull(product);
        } catch (BuildException e) {
            fail();
        }
    }
    
    // GetInstance Incorrecte
    @Test
    void testBadgetInstanceProduct(){
        try{
            product.CheckProduct(0, 0, null);
            fail();
        }catch (BuildException e) {
            assertEquals("No pot ser negatiu o 0, No pot ser negatiu o 0, El camp està buit, ",e.getMessage());
        }
    }
    
    // GetInstance Codi
    @Test
    void testBadgetInstanceCode(){
        try{
            product.CheckProduct(-10, 20, "Javava");
            fail();
        }catch (BuildException e) {
            assertEquals("No pot ser negatiu o 0, ",e.getMessage());
        }
    }
    
    // GetInstance Price
    @Test
    void testBadgetInstancePrice(){
        try{
            product.CheckProduct(10, 0, "Javava");
            fail();
        }catch (BuildException e) {
            assertEquals("No pot ser negatiu o 0, ",e.getMessage());
        }
    }
    
    // GetInstance Description
    @Test
    void testBadgetInstanceDescription(){
        try{
            product.CheckProduct(10, 10, "        ");
            fail();
        }catch (BuildException e) {
            assertEquals("El camp ha de ser més llarg, ",e.getMessage());
        }
    }
    
    // Comprovar GetCode
    @Test
    void testGetcode() {
        assertEquals(13, product.getcode());
    }
    
    // Comprovar el SetName
    @Test
    void testSetCode() {
        int result = product.setcode(13);
        assertEquals(0, result);
    }
    
    @Test
    void testSetCodeSave() {
        product.setcode(13);
        assertEquals(13, product.getcode());// Valida que el valor és magatzem correctament
    }
    
    @Test
    void testSetCodeNegative() {
        int result = product.setcode(-158);
        assertEquals(-3, result);//  Valida que el valor és negatiu
    }
        @Test
    void testSetCodeZero() {
        int result = product.setcode(0);
        assertEquals(-3, result);//  Valida que el valor és Zero
    }

    // Comprovar GetPrice
    @Test
    void testGetprice() {
        assertEquals(12.34, product.getprice());
    }
    
    // Comprovar el SetPrice
    @Test
    void testSetprice() {
        int result = product.setprice(12.34);
        assertEquals(0, result);
    }
    
    @Test
    void testSetpriceSave() {
        product.setprice(12.34);
        assertEquals(12.34, product.getprice());// Valida que el valor és magatzem correctament
    }
    
    @Test
    void testSetpriceNegative() {
        int result = product.setprice(-138);
        assertEquals(-3, result);//  Valida que el valor és negatiu
    
    }
    
    @Test
    void testSetpriceZero() {
        int result = product.setprice(0);
        assertEquals(-3, result);//  Valida que el valor és negatiu
    }
    
    // Comprovar GetDescription
    @Test
    void testGetdescription() {
        assertEquals("Javava", product.getdescription());
    }
    
    // Comprovar SetDescription
    @Test
    void testSetdescription() {
        int result = product.setdescription("Javava");
        assertEquals(0, result);// Validació exitosa
    }
    
    @Test
    void testSetdescriptionSave() {
        product.setdescription("Javava");
        assertEquals("Javava", product.getdescription());// Valida que el valor és magatzem correctament
    }
    
    @Test
    void testSetdescriptionNull() {
        int result= product.setdescription(null);
        assertEquals(-1, result);// Valida que el valor sigui null
    }
    
    @Test
    void testSetAddressMinLength() {
        int result= product.setdescription("      ");
        assertEquals(-2, result);// Valida que el valor es menor o té espai
    }
    
    // Comprovar el GetDetails
    @Test
    void testGetDetails() {
        assertEquals("PRODUCTONE: Codi: 13, Preu: 12.34, Descripció: Javava", product.getDetails());
    }
}
