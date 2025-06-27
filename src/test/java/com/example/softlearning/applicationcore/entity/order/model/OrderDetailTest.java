package com.example.softlearning.applicationcore.entity.order.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.softlearning.applicationcore.entity.sharedkernel.model.exceptions.BuildException;

public class OrderDetailTest {
    private OrderDetail orderdetail;

    @BeforeEach
    public void setUp() throws Exception{
        orderdetail = OrderDetail.getInstanceDetail("Javava", 13, "12345A", 12.34, 5, 10.45);
    }
    // GetInstance Correcta
    @Test
    void testGetInstanceDetail() {
        try {
            orderdetail = OrderDetail.getInstanceDetail("Javava", 13, "12345A", 12.34, 5, 10.45);
            assertNotNull(orderdetail);
        } catch (BuildException e) {
            fail();
        }
    }

    // GetInstance Incorrecta
    @Test
    void testGetInstanceDetailIncorrecta() {
        try{
            orderdetail = OrderDetail.getInstanceDetail("      ", -13, "    ", 0, -5, -12.78);
            fail();
        }catch (BuildException e) {
            assertEquals("El camp ha de ser més llarg, No pot ser negatiu o 0, El camp ha de ser més llarg, No pot ser negatiu o 0, No pot ser negatiu o 0, No pot ser negatiu o 0, ",e.getMessage());
        }
    }

    // GetInstance Incorrecta Namearticles
    @Test
    void testGetInstanceDetailNameIncorrect() {
        try{
            orderdetail = OrderDetail.getInstanceDetail("J", 13, "12345A", 12.34, 5, 10.45);
            fail();
        }catch (BuildException e) {
            assertEquals("El camp ha de ser més llarg, ",e.getMessage());
        }
    }

    // GetInstance Incorrecta Quantity
    @Test
    void testGetInstanceDetailQuantityIncorrect() {
        try{
            orderdetail = OrderDetail.getInstanceDetail("Javava", -13, "12345A", 12.34, 5, 10.45);
            fail();
        }catch (BuildException e) {
            assertEquals("No pot ser negatiu o 0, ",e.getMessage());
        }
    }

    // GetInstance Incorrecta ReferenceNum
    @Test
    void testGetInstanceDetailReferenceNumberIncorrect() {
        try{
            orderdetail = OrderDetail.getInstanceDetail("Javava", 13, "1", 12.34, 5, 10.45);
            fail();
        }catch (BuildException e) {
            assertEquals("El camp ha de ser més llarg, ",e.getMessage());
        }
    }

    // GetInstance Incorrecta IndividualPrice
    @Test
    void testGetInstanceDetailIndividualPriceIncorrect() {
        try{
            orderdetail = OrderDetail.getInstanceDetail("Javava", 13, "1313", 0, 5, 10.45);
            fail();
        }catch (BuildException e) {
            assertEquals("No pot ser negatiu o 0, ",e.getMessage());
        }
    }

    // GetInstance Incorrecta IndividualPrice
    @Test
    void testGetInstanceDetailDiscountIncorrect() {
        try{
            orderdetail = OrderDetail.getInstanceDetail("Javava", 13, "1313", 10.24, -5, 10.45);
            fail();
        }catch (BuildException e) {
            assertEquals("No pot ser negatiu o 0, ",e.getMessage());
        }
    }

    // GetInstance Incorrecta IndividualPrice
    @Test
    void testGetInstanceDetailTotalIncorrect() {
        try{
            orderdetail = OrderDetail.getInstanceDetail("Javava", 13, "1313", 10.24, 5, 0);
            fail();
        }catch (BuildException e) {
            assertEquals("No pot ser negatiu o 0, ",e.getMessage());
        }
    }

    @Test
    void testGetDetails() {
        assertEquals("nomarticleJavava, quantitat13, referencia12345A, preuindividual12.34, descompte5, total155.42",orderdetail.getDetails());
    }

    @Test
    void testGetDiscount() {
        assertEquals(5,orderdetail.getDiscount());
    }

    @Test
    void testSetDiscount() {
        int  Respuesta = orderdetail.setDiscount(5);
        assertEquals(0, Respuesta);
    }

    @Test
    void testSetDiscountSave() {
        orderdetail.setDiscount(5);
        assertEquals(5, orderdetail.getDiscount());
    }

    @Test
    void testSetDiscountZero() {
        int Respuesta = orderdetail.setDiscount(0);
        assertEquals(-3, Respuesta);
    }

    @Test
    void testSetDiscountNegative() {
        int Respuesta = orderdetail.setDiscount(-10);
        assertEquals(-3, Respuesta);
    }
    
    @Test
    void testGetIndividualPrice() {
        assertEquals(12.34,orderdetail.getIndividualPrice());
    }

    @Test
    void testSetIndividualPrice() {
        int respuesta = orderdetail.setIndividualPrice(12);
        assertEquals(0,respuesta);
    }
    @Test
    void testSetIndividualPriceSave() {
        orderdetail.setIndividualPrice(12);
        assertEquals(12,orderdetail.getIndividualPrice());
    }
    @Test
    void testSetIndividualPriceZero() {
        int respuesta =orderdetail.setIndividualPrice(0);
        assertEquals(-3,respuesta);
    }
    @Test
    void testSetIndividualPriceNegative() {
        int respuesta = orderdetail.setIndividualPrice(-15);
        assertEquals(-3,respuesta);
    }

    @Test
    void testGetNamearticles() {
        assertEquals("Javava",orderdetail.getNamearticles());
    }

    @Test
    void testSetNamearticlesSave() {
        orderdetail.setNamearticles("Javava");
        assertEquals("Javava", orderdetail.getNamearticles());
    }

    @Test
    void testSetNamearticles() {
        int Respuesta = orderdetail.setNamearticles("Javava");
        assertEquals(0, Respuesta);
    }
    
    @Test
    void testSetNamearticlesSpaceString() {
        int Respuesta = orderdetail.setNamearticles("        ");
        assertEquals(-2, Respuesta);
    }
    
    @Test
    void testSetNamearticlesMinLength() {
        int Respuesta = orderdetail.setNamearticles("i");
        assertEquals(-2, Respuesta);
    }

    @Test
    void testGetQuantity() {
        assertEquals(13,orderdetail.getQuantity());
    }

    @Test
    void testSetQuantity() {
        int Respuesta = orderdetail.setQuantity(12);
        assertEquals(0,Respuesta);
    }
    @Test
    void testSetQuantitySave() {
        orderdetail.setQuantity(12);
        assertEquals(12,orderdetail.getQuantity());
    }
    
    @Test
    void testSetQuantityZero() {
        int Respuesta = orderdetail.setQuantity(0);
        assertEquals(-3,Respuesta);
    }
        @Test
    void testSetQuantityNegative() {
        int Respuesta = orderdetail.setQuantity(-12);
        assertEquals(-3,Respuesta);
    }
    
    @Test
    void testGetReference() {
        assertEquals("12345A",orderdetail.getReference());
    }

    @Test
    void testSetReference() {
        int respuesta = orderdetail.setReference("1212");
        assertEquals(0,respuesta);
    }
    
    @Test
    void testSetReferenceSave() {
        orderdetail.setReference("1212");
        assertEquals("1212",orderdetail.getReference());
    }

    @Test
    void testSetReferenceSpace() {
        int Respuesta = orderdetail.setReference("        ");
        assertEquals(-2,Respuesta);
    }

    @Test
    void testSetReferenceMinLength() {
        int Respuesta = orderdetail.setReference("j");
        assertEquals(-2,Respuesta);
    }
    @Test
    void testGetTotal() {
        assertEquals(155.42,orderdetail.getTotal());
    }
    
    @Test
    void testSetTotal() {
        int Respuesta = orderdetail.setTotal(540);
        assertEquals(0,Respuesta);
    }

    @Test
    void testSetTotalSave() {
        orderdetail.setTotal(155.42);
        assertEquals(155.42,orderdetail.getTotal());
    }

    @Test
    void testSetTotalZero() {
        int Respuesta = orderdetail.setTotal(0);
        assertEquals(-3,Respuesta);
    }
    @Test
    void testSetTotalNegative() {
        int Respuesta = orderdetail.setTotal(-40);
        assertEquals(-3,Respuesta);
    }
}
