package com.example.softlearning.applicationcore.entity.order.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.time.format.DateTimeParseException;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.softlearning.applicationcore.entity.sharedkernel.model.exceptions.BuildException;
import com.example.softlearning.applicationcore.entity.sharedkernel.model.exceptions.ServiceException;

public class OrderTest {
    private Order order;
    private Order orderPequeño;

    @BeforeEach
    public void setUp() throws Exception {
        orderPequeño = Order.getInstanceOrder("123456789","1234567J","Javava", "Javavava" );
        order= Order.getInstanceOrder(13, "Javava", "2000/12/20-08:20:45", "Av.riera", "123456789", "1234567J", "Jessica", "Prats", "12345678A", "2000/12/20-08:20:45", "2000/12/20-08:20:45", "2000/12/24-09:20:45", 13.0, 13.0, 13.0, 10.0, true, 10.0, "nomarticle:lllibre,quantitat:11,referencia:23451,preuindividual:12.45,descompte:3,total:12.45;"
        );
    }
    // <---------------------------------------->
    @Test
    void testInvalidPhoneContactOrderPequeño() {
        try {
            Order.getInstanceOrder("", "1234567J", "Javava", "Javavava");
            fail();
        } catch (BuildException e) {
            String expected = "El camp ha de ser més llarg, ";
            assertEquals(expected, e.getMessage());
        }
    }

    @Test
    void testInvalidIdClientOrderPequeño() {
        try {
            Order.getInstanceOrder("123456789", "", "Javava", "Javavava");
            fail();
        } catch (BuildException e) {
            String expected = "El camp ha de ser més llarg, ";
            assertEquals(expected, e.getMessage());
        }
    }

    @Test
    void testInvalidNameOrderPequeño() {
        try {
            Order.getInstanceOrder("123456789", "1234567J", "", "Javavava");
            fail();
        } catch (BuildException e) {
            String expected = "El camp ha de ser més llarg, ";
            assertEquals(expected, e.getMessage());
        }
    }

    @Test
    void testInvalidSurnameOrderPequeño() {
        try {
            Order.getInstanceOrder("123456789", "1234567J", "Javava", "");
            fail();
        } catch (BuildException e) {
            String expected = "El camp ha de ser més llarg, ";
            assertEquals(expected, e.getMessage());
        }
    }

    @Test
    void testAllInvalid() {
        try {
            Order.getInstanceOrder("", "", "", "");
            fail();
        } catch (BuildException e) {
            System.out.println(e.getMessage());
            String expected = "El camp ha de ser més llarg, El camp ha de ser més llarg, El camp ha de ser més llarg, El camp ha de ser més llarg, "; 
            assertEquals(expected, e.getMessage());
        }
    }

    private final int validInt = 13;
    private final String validString1 = "Javava";
    private final String validDateTime1 = "2000/12/20-08:20:45";
    private final String validAddress = "Av.riera";
    private final String validPhoneContact = "123456789";
    private final String validIdClient = "1234567J";
    private final String validName = "Jessica";
    private final String validSurname = "Prats";
    private final String validDNI = "12345678A";
    private final String validPaymentDate = "2000/12/20-08:20:45";
    private final String validDeliveryDate = "2000/12/20-08:20:45";
    private final String validDeliveryLimitDate = "2000/12/24-09:20:45";
    private final double validDouble1 = 13.0;
    private final double validDouble2 = 13.0;
    private final double validDouble3 = 13.0;
    private final double validDouble4 = 10.0;
    private final boolean validBoolean = true;
    private final double validDouble5 = 10.0;
    private final String validCartDetails = "nomarticle:lllibre,quantitat:11,referencia:23451,preuindividual:12.45,descompte:3, total:12.45;";

    @Test
    void testInvalidIntParameter() {
        try {
            Order.getInstanceOrder(
                0,  // inválido aquí
                validString1,
                validDateTime1,
                validAddress,
                validPhoneContact,
                validIdClient,
                validName,
                validSurname,
                validDNI,
                validPaymentDate,
                validDeliveryDate,
                validDeliveryLimitDate,
                validDouble1,
                validDouble2,
                validDouble3,
                validDouble4,
                validBoolean,
                validDouble5,
                validCartDetails);
            fail();
        } catch (BuildException e) {
            String expected = "No pot ser negatiu o 0, ";
            assertEquals(expected, e.getMessage());
        }
    }

    @Test
    void testInvalidString1Parameter() {
        try {
            Order.getInstanceOrder(
                validInt,
                "",  // inválido
                validDateTime1,
                validAddress,
                validPhoneContact,
                validIdClient,
                validName,
                validSurname,
                validDNI,
                validPaymentDate,
                validDeliveryDate,
                validDeliveryLimitDate,
                validDouble1,
                validDouble2,
                validDouble3,
                validDouble4,
                validBoolean,
                validDouble5,
                validCartDetails);
            fail();
        } catch (BuildException e) {
            String expected = "No pot ser negatiu o 0, "; // <- Poner mensaje de error exacto
            assertEquals(expected, e.getMessage());
        }
    }

    @Test
    void testInvalidDateTime1Parameter() {
        try {
            Order.getInstanceOrder(
                validInt,
                validString1,
                "", // inválido
                validAddress,
                validPhoneContact,
                validIdClient,
                validName,
                validSurname,
                validDNI,
                validPaymentDate,
                validDeliveryDate,
                validDeliveryLimitDate,
                validDouble1,
                validDouble2,
                validDouble3,
                validDouble4,
                validBoolean,
                validDouble5,
                validCartDetails);
            fail();
        } catch (BuildException e) {
            String expected = "No pot ser negatiu o 0, "; // <- Poner mensaje de error exacto
            assertEquals(expected, e.getMessage());
        }
    }

    // ... Y así con cada parámetro. Por ejemplo:

    @Test
    void testInvalidAddress() {
        try {
            Order.getInstanceOrder(
                validInt,
                validString1,
                validDateTime1,
                "", // inválido
                validPhoneContact,
                validIdClient,
                validName,
                validSurname,
                validDNI,
                validPaymentDate,
                validDeliveryDate,
                validDeliveryLimitDate,
                validDouble1,
                validDouble2,
                validDouble3,
                validDouble4,
                validBoolean,
                validDouble5,
                validCartDetails);
            fail();
        } catch (BuildException e) {
            String expected = "No pot ser negatiu o 0, "; // <- Poner mensaje de error exacto
            assertEquals(expected, e.getMessage());
        }
    }

    @Test
    void testInvalidPhoneContact() {
        try {
            Order.getInstanceOrder(
                validInt,
                validString1,
                validDateTime1,
                validAddress,
                "", // inválido
                validIdClient,
                validName,
                validSurname,
                validDNI,
                validPaymentDate,
                validDeliveryDate,
                validDeliveryLimitDate,
                validDouble1,
                validDouble2,
                validDouble3,
                validDouble4,
                validBoolean,
                validDouble5,
                validCartDetails);
            fail();
        } catch (BuildException e) {
            String expected = "No pot ser negatiu o 0, "; // <- Poner mensaje de error exacto
            assertEquals(expected, e.getMessage());
        }
    }
    @Test
    void testInvalidIdClient() {
        try {
            Order.getInstanceOrder(
                validInt,
                validString1,
                validDateTime1,
                validAddress,
                validPhoneContact,
                "",  // inválido
                validName,
                validSurname,
                validDNI,
                validPaymentDate,
                validDeliveryDate,
                validDeliveryLimitDate,
                validDouble1,
                validDouble2,
                validDouble3,
                validDouble4,
                validBoolean,
                validDouble5,
                validCartDetails);
            fail();
        } catch (BuildException e) {
            String expectedMessage = "No pot ser negatiu o 0, ";  // <- pon aquí tu mensaje
            assertEquals(expectedMessage, e.getMessage());
        }
    }

    @Test
    void testInvalidName() {
        try {
            Order.getInstanceOrder(
                validInt,
                validString1,
                validDateTime1,
                validAddress,
                validPhoneContact,
                validIdClient,
                "",  // inválido
                validSurname,
                validDNI,
                validPaymentDate,
                validDeliveryDate,
                validDeliveryLimitDate,
                validDouble1,
                validDouble2,
                validDouble3,
                validDouble4,
                validBoolean,
                validDouble5,
                validCartDetails);
            fail();
        } catch (BuildException e) {
            String expectedMessage = "No pot ser negatiu o 0, ";  // <- pon aquí tu mensaje
            assertEquals(expectedMessage, e.getMessage());
        }
    }

    @Test
    void testInvalidSurname() {
        try {
            Order.getInstanceOrder(
                validInt,
                validString1,
                validDateTime1,
                validAddress,
                validPhoneContact,
                validIdClient,
                validName,
                "",  // inválido
                validDNI,
                validPaymentDate,
                validDeliveryDate,
                validDeliveryLimitDate,
                validDouble1,
                validDouble2,
                validDouble3,
                validDouble4,
                validBoolean,
                validDouble5,
                validCartDetails);
            fail();
        } catch (BuildException e) {
            String expectedMessage = "No pot ser negatiu o 0, ";  // <- pon aquí tu mensaje
            assertEquals(expectedMessage, e.getMessage());
        }
    }

    @Test
    void testInvalidDNI() {
        try {
            Order.getInstanceOrder(
                validInt,
                validString1,
                validDateTime1,
                validAddress,
                validPhoneContact,
                validIdClient,
                validName,
                validSurname,
                "",  // inválido
                validPaymentDate,
                validDeliveryDate,
                validDeliveryLimitDate,
                validDouble1,
                validDouble2,
                validDouble3,
                validDouble4,
                validBoolean,
                validDouble5,
                validCartDetails);
            fail();
        } catch (BuildException e) {
            String expectedMessage = "No pot ser negatiu o 0, "; 
            assertEquals(expectedMessage, e.getMessage());
        }
    }

    @Test
    void testInvalidPaymentDate() {
        try {
            Order.getInstanceOrder(
                validInt,
                validString1,
                validDateTime1,
                validAddress,
                validPhoneContact,
                validIdClient,
                validName,
                validSurname,
                validDNI,
                "12/13/2025",  // inválido
                validDeliveryDate,
                validDeliveryLimitDate,
                validDouble1,
                validDouble2,
                validDouble3,
                validDouble4,
                validBoolean,
                validDouble5,
                validCartDetails);
            fail();
        } catch (BuildException e) {
            String expectedMessage = "No pot ser negatiu o 0, ";  // <- pon aquí tu mensaje
            assertEquals(expectedMessage, e.getMessage());
        }
    }

    @Test
    void testInvalidDeliveryDate() {
        try {
            Order.getInstanceOrder(
                validInt,
                validString1,
                validDateTime1,
                validAddress,
                validPhoneContact,
                validIdClient,
                validName,
                validSurname,
                validDNI,
                validPaymentDate,
                "fecha inválida",  // inválido
                validDeliveryLimitDate,
                validDouble1,
                validDouble2,
                validDouble3,
                validDouble4,
                validBoolean,
                validDouble5,
                validCartDetails);
            fail();
        } catch (BuildException e) {
            String expectedMessage = "No pot ser negatiu o 0, ";  // <- pon aquí tu mensaje
            assertEquals(expectedMessage, e.getMessage());
        }
    }

    @Test
    void testInvalidDeliveryLimitDate() {
        try {
            Order.getInstanceOrder(
                validInt,
                validString1,
                validDateTime1,
                validAddress,
                validPhoneContact,
                validIdClient,
                validName,
                validSurname,
                validDNI,
                validPaymentDate,
                validDeliveryDate,
                "fecha inválida",  // inválido
                validDouble1,
                validDouble2,
                validDouble3,
                validDouble4,
                validBoolean,
                validDouble5,
                validCartDetails);
            fail();
        } catch (BuildException e) {
            String expectedMessage = "No pot ser negatiu o 0, ";  // <- pon aquí tu mensaje
            assertEquals(expectedMessage, e.getMessage());
        }
    }

    @Test
    void testInvalidDoubleParam1() {
        try {
            Order.getInstanceOrder(
                validInt,
                validString1,
                validDateTime1,
                validAddress,
                validPhoneContact,
                validIdClient,
                validName,
                validSurname,
                validDNI,
                validPaymentDate,
                validDeliveryDate,
                validDeliveryLimitDate,
                -1.0,  // inválido
                validDouble2,
                validDouble3,
                validDouble4,
                validBoolean,
                validDouble5,
                validCartDetails);
            fail();
        } catch (BuildException e) {
            String expectedMessage = "No pot ser negatiu o 0, ";  // <- pon aquí tu mensaje
            assertEquals(expectedMessage, e.getMessage());
        }
    }

    @Test
    void testInvalidDoubleParam2() {
        try {
            Order.getInstanceOrder(
                validInt,
                validString1,
                validDateTime1,
                validAddress,
                validPhoneContact,
                validIdClient,
                validName,
                validSurname,
                validDNI,
                validPaymentDate,
                validDeliveryDate,
                validDeliveryLimitDate,
                validDouble1,
                -5.0,  // inválido
                validDouble3,
                validDouble4,
                validBoolean,
                validDouble5,
                validCartDetails);
            fail();
        } catch (BuildException e) {
            String expectedMessage = "No pot ser negatiu o 0, ";  // <- pon aquí tu mensaje
            assertEquals(expectedMessage, e.getMessage());
        }
    }

    @Test
    void testInvalidDoubleParam3() {
        try {
            Order.getInstanceOrder(
                validInt,
                validString1,
                validDateTime1,
                validAddress,
                validPhoneContact,
                validIdClient,
                validName,
                validSurname,
                validDNI,
                validPaymentDate,
                validDeliveryDate,
                validDeliveryLimitDate,
                validDouble1,
                validDouble2,
                -0.01,  // inválido
                validDouble4,
                validBoolean,
                validDouble5,
                validCartDetails);
            fail();
        } catch (BuildException e) {
            String expectedMessage = "No pot ser negatiu o 0, ";  // <- pon aquí tu mensaje
            assertEquals(expectedMessage, e.getMessage());
        }
    }

    @Test
    void testInvalidDoubleParam4() {
        try {
            Order.getInstanceOrder(
                validInt,
                validString1,
                validDateTime1,
                validAddress,
                validPhoneContact,
                validIdClient,
                validName,
                validSurname,
                validDNI,
                validPaymentDate,
                validDeliveryDate,
                validDeliveryLimitDate,
                validDouble1,
                validDouble2,
                validDouble3,
                -10.0,  // inválido
                validBoolean,
                validDouble5,
                validCartDetails);
            fail();
        } catch (BuildException e) {
            String expectedMessage = "No pot ser negatiu o 0, ";  // <- pon aquí tu mensaje
            assertEquals(expectedMessage, e.getMessage());
        }
    }

    // El booleano normalmente no genera excepción por ser boolean, salvo lógica extra.
    // Aquí dejo el test por si hubiera lógica específica:

    @Test
    void testInvalidBooleanParam() {
        // Si no hay validación que lance excepción, puedes omitir este test
        // Si hay, usar algo así:
        try {
            // Por ejemplo, si false es inválido:
            Order.getInstanceOrder(
                validInt,
                validString1,
                validDateTime1,
                validAddress,
                validPhoneContact,
                validIdClient,
                validName,
                validSurname,
                validDNI,
                validPaymentDate,
                validDeliveryDate,
                validDeliveryLimitDate,
                validDouble1,
                validDouble2,
                validDouble3,
                validDouble4,
                false,  // inválido si aplica
                validDouble5,
                validCartDetails);
            fail();
        } catch (BuildException e) {
            String expectedMessage = "No pot ser negatiu o 0, ";  // <- pon aquí tu mensaje
            assertEquals(expectedMessage, e.getMessage());
        }
    }

    @Test
    void testInvalidDoubleParam5() {
        try {
            Order.getInstanceOrder(
                validInt,
                validString1,
                validDateTime1,
                validAddress,
                validPhoneContact,
                validIdClient,
                validName,
                validSurname,
                validDNI,
                validPaymentDate,
                validDeliveryDate,
                validDeliveryLimitDate,
                validDouble1,
                validDouble2,
                validDouble3,
                validDouble4,
                validBoolean,
                -7.0,  // inválido
                validCartDetails);
            fail();
        } catch (BuildException e) {
            String expectedMessage = "No pot ser negatiu o 0, ";  // <- pon aquí tu mensaje
            assertEquals(expectedMessage, e.getMessage());
        }
    }

    @Test
    void testInvalidCartDetails() {
        try {
            Order.getInstanceOrder(
                validInt,
                validString1,
                validDateTime1,
                validAddress,
                validPhoneContact,
                validIdClient,
                validName,
                validSurname,
                validDNI,
                validPaymentDate,
                validDeliveryDate,
                validDeliveryLimitDate,
                validDouble1,
                validDouble2,
                validDouble3,
                validDouble4,
                validBoolean,
                validDouble5,
                "");  // inválido
            fail();
        } catch (BuildException e) {
            String expectedMessage = "El camp ha de ser més llarg, No pot ser negatiu o 0, El camp ha de ser més llarg, No pot ser negatiu o 0, No pot ser negatiu o 0, No pot ser negatiu o 0, ";  // <- pon aquí tu mensaje
            assertEquals(expectedMessage, e.getMessage());
        }
    }
    @Test
    void testAllParamsInvalid() {
        try {
            Order.getInstanceOrder(
                0,                // int inválido
                "",               // string inválido
                "fecha inválida", // fecha inválida
                "",               // dirección inválida
                "",               // teléfono inválido
                "",               // id cliente inválido
                "",               // nombre inválido
                "",               // apellido inválido
                "",               // dni inválido
                "fecha inválida", // fecha pago inválida
                "fecha inválida", // fecha entrega inválida
                "fecha inválida", // fecha límite inválida
                -1.0,             // double inválido 1
                -1.0,             // double inválido 2
                -1.0,             // double inválido 3
                -1.0,             // double inválido 4
                false,            // boolean inválido (si aplica)
                -1.0,             // double inválido 5
                ""                // detalles del carrito inválidos
            );
            fail();
        } catch (BuildException e) {
            String expectedMessage ="El camp ha de ser més llarg, No pot ser negatiu o 0, El camp ha de ser més llarg, No pot ser negatiu o 0, No pot ser negatiu o 0, No pot ser negatiu o 0, ";
            
            assertEquals(expectedMessage, e.getMessage());
        }
    }

  // --- Tests para orderPequeño ---
    @Test
    void testDeleteDetail_invalidPositionNegative_orderPequeño() {
        try {
            orderPequeño.deleteDetail(-1);
            fail();
        } catch (ServiceException e) {
            assertEquals("No existeix el producte", e.getMessage());
        } 
        
    }

    @Test
    void testDeleteDetail_invalidPositionTooLarge_orderPequeño() {
        try {
            orderPequeño.deleteDetail(100);
            fail();
        } catch (ServiceException e) {
            assertEquals("No existeix el producte", e.getMessage());
        } 
    }

    // --- Tests para order normal ---
    @Test
    void testDeleteDetail_validPosition_order() throws Exception {
        try {
            order.setDetail("Artículo1", 1, "REF001", 10.0, 0, 10.0);
            assertEquals("FINISHED", order.getStatus());
            assertEquals(0, order.deleteDetail(0)); // coherente con el objeto
        } catch (Exception e) {
            assertEquals("No es pot eliminar perquè està pagat.", e.getMessage());
        }
    }

    @Test
    void testDeleteDetail_invalidPositionNegative_order() {
        try {
            order.deleteDetail(-1);
            fail();
        } catch (ServiceException e) {
            assertEquals("No es pot eliminar perquè està pagat.", e.getMessage());
        } 
    }

    @Test
    void testDeleteDetail_invalidPositionTooLarge_order() {
        try {
            order.deleteDetail(100);
            fail();
        } catch (ServiceException e) {
            assertEquals("No es pot eliminar perquè està pagat.", e.getMessage());
        } 
    }


    @Test
    void testGetAddress_orderPequeño() {
        // Como orderPequeño no tiene address seteada explícitamente, esperamos null o vacío
        assertNull(orderPequeño.getAddress());
    }

    @Test
    void testGetAddress_order() {
        // El address esperado es "Av.riera" según el constructor
        assertEquals("Av.riera", order.getAddress());
    }

    @Test
    void testGetDNI_orderPequeño() {
        // En el constructor pequeño no se setea DNI, esperamos null
        assertNull(orderPequeño.getDNI());
    }

    @Test
    void testGetDNI_order() {
        // En el constructor completo se setea DNI a "12345678A"
        assertEquals("12345678A", order.getDNI());
    }

    @Test
    void testGetDeliveryDate_orderPequeño() {
        // orderPequeño no setea deliveryDate, esperamos cadena vacía
        assertEquals("", orderPequeño.getDeliveryDate());
    }

    @Test
    void testGetDeliveryDate_order() {
        // order tiene deliveryDate "2000/12/24-09:20:45" (según constructor)
        String expectedDate = "2000/12/20-08:20:45";
        assertEquals(expectedDate, order.getDeliveryDate());
    }

    @Test
    void testGetDepth_order() {
        double depth = order.getDepth();
        // Aquí pones el valor esperado para order.orderPackage.getDepth()
        double expectedDepth = 13.0;
        assertEquals(expectedDepth, depth);
    }

    // Test para posición inválida negativa con orderPequeño
    @Test
    void testGetDetail_invalidPositionNegative_orderPequeño() throws ServiceException {
        String result = orderPequeño.getDetail(-1);
        assertEquals("Posició incorrecta", result);
    }

    // Test para posición inválida grande con orderPequeño
    @Test
    void testGetDetail_invalidPositionTooBig_orderPequeño() throws ServiceException {
        String result = orderPequeño.getDetail(orderPequeño.shopCart.size() + 1);
        assertEquals("Posició incorrecta", result);
    }

    // Test para estado no CREATED con orderPequeño
    @Test
    void testGetDetail_statusNotCreated_orderPequeño() {
        orderPequeño.status = OrderStatus.CONFIRMED; // Estado diferente a CREATED
        
        try {
            orderPequeño.getDetail(0);
            fail("Se esperaba ServiceException");
        } catch (ServiceException e) {
            assertEquals("Sembla que no hi ha ningún Order Detail creat", e.getMessage());
        }
    }


    // Lo mismo con order normal
    @Test
    void testGetDetail_invalidPositionNegative_order() throws ServiceException {
        try {
            String result = order.getDetail(-1);
            assertEquals("Posició incorrecta", result);
        } catch (ServiceException e) {
            assertEquals("Sembla que no hi ha ningún Order Detail creat", e.getMessage());
        }
    }

    @Test
    void testGetDetail_invalidPositionTooBig_order() throws ServiceException {
        try {
            String result = order.getDetail(order.shopCart.size() + 1);
            assertEquals("Posició incorrecta", result);
        } catch (ServiceException e) {
            assertEquals("Sembla que no hi ha ningún Order Detail creat", e.getMessage());
        }
    }

    @Test
    void testGetDetail_statusNotCreated_order() {
        try {
            order.getDetail(0);
            fail();
        } catch (ServiceException e) {
            assertEquals("Sembla que no hi ha ningún Order Detail creat", e.getMessage());
        }
    }


    @Test
    public void testGetFinishDate_OrderPequeño() {

        String finishDate = orderPequeño.getFinishDate();
        assertEquals("", finishDate);
    }

    @Test
    public void testGetFinishDate_Order() {

        String expected = "2000/12/24-09:20:45";  
        String finishDate = order.getFinishDate();

        assertEquals(expected, finishDate);
    }


    @Test
    public void testGetFragil_Order() {
    assertEquals(true, order.getFragil());
    }



    @Test
    public void testGetHigh_Order() {
        // En el constructor que mostraste, se pasó 13.0 para la altura (high)
        assertEquals(13.0, order.getHigh());
    }

    @Test
    public void testGetIdClient_OrderPequeño() {
        assertEquals("1234567J", orderPequeño.getIdClient());
    }

    @Test
    public void testGetIdClient_Order() {
        assertEquals("1234567J", order.getIdClient());
    }

    @Test
    public void testGetInitDate_OrderPequeño() {
        // orderPequeño no tiene initDate definido, debería devolver ""
        assertEquals("", orderPequeño.getInitDate());
    }

    @Test
    public void testGetInitDate_Order() {
        // Formato esperado según formatter: "yyyy/MM/dd-HH:mm:ss"
        assertEquals("2000/12/20-08:20:45", order.getInitDate());
    }


    @Test
    public void testGetLength_Order() {
        // length se ha inicializado con 10.0 en el constructor
        assertEquals(10.0, order.getLength());
    }

    @Test
    public void testGetName_OrderPequeño() {
        assertEquals("Javava", orderPequeño.getName());
    }

    @Test
    public void testGetName_Order() {
        assertEquals("Jessica", order.getName());
    }


    @Test
    public void testGetNumDetails_OrderPequeño() {
        // En orderPequeño asumimos que el shopCart está vacío al no pasar detalles
        assertEquals(0, orderPequeño.getNumDetails());
    }

    @Test
    public void testGetNumDetails_Order() {
        // Aquí dependemos de si el constructor parsea y añade un detalle al shopCart
        // En el ejemplo dado, parece un detalle, así que esperamos al menos 1
        assertEquals(1, order.getNumDetails());
    }



    @Test
    public void testGetPackedDimensions_Order() {
        // Basándonos en los valores pasados en el constructor order:
        // high=13.0, width=13.0, length=10.0, weight=10.0, fragil=true, depth=13.0
        String expected = "h: 13.0, w: 13.0, l: 10.0, we: 10.0, f: true, d: 13.0";
        assertEquals(expected, order.getPackedDimensions());
    }

    @Test
    public void testGetPaymentDate_OrderPequeño() {
        // En orderPequeño no se inicializa paymentDate, debería devolver cadena vacía
        assertEquals("", orderPequeño.getPaymentDate());
    }

    @Test
    public void testGetPaymentDate_Order() {
        // En order se pasó "2000/12/20-08:20:45" como paymentDate, debe devolver exactamente eso
        String expected = "2000/12/20-08:20:45";
        assertEquals(expected, order.getPaymentDate());
    }

    @Test
    public void testGetPhoneContact_OrderPequeño() {
        // orderPequeño creado con phoneContact = "123456789"
        assertEquals("[123456789]", orderPequeño.getPhoneContact());
    }

    @Test
    public void testGetPhoneContact_Order() {
        // order creado con phoneContact = "123456789"
        assertEquals("[123456789]", order.getPhoneContact());
    }

    @Test
    public void testGetPrice_OrderPequeño() {
        
        assertEquals(0, orderPequeño.getPrice());
    }

    @Test
    public void testGetPrice_Order() {

        assertEquals(133.95, order.getPrice(), 0.0001);
    }

    @Test
    public void testGetShopCartDetails_OrderPequeño() {

        assertEquals("", orderPequeño.getShopCartDetails());
    }

    @Test
    public void testGetShopCartDetails_Order() {

        String expected = "nomarticle:lllibre,quantitat:11,referencia:23451,preuindividual:12.45,descompte:3,total:133.95;";

        assertEquals(expected, order.getShopCartDetails());
    }

    @Test
    public void testGetStatus_OrderPequeño() {
        assertEquals("CREATED", orderPequeño.getStatus());
    }

    @Test
    public void testGetStatus_Order() {
        assertEquals("FINISHED", order.getStatus());
    }

    @Test
    public void testGetSurname_OrderPequeño() {
        assertEquals("Javavava", orderPequeño.getSurname());
    }

    @Test
    public void testGetSurname_Order() {
        assertEquals("Prats", order.getSurname());
    }

    @Test
    public void testGetVolume_Order() {
        double expectedVolume = 10.0 * 13.0 * 13.0; // 1690.0
        assertEquals(expectedVolume, order.getVolume(), 0.001);
    }



    @Test
    public void testGetWeight_Order() {
        double expectedWeight = 10.0;  // según constructor
        assertEquals(expectedWeight, order.getWeight(), 0.001);
    }

    @Test
    public void testGetWidth_Order() {
        double expectedWidth = 13.0; // según constructor
        assertEquals(expectedWidth, order.getWidth(), 0.001);
    }

    // Tests para orderPequeño

    @Test
    public void testSetAddressValid_orderPequeño() {
        int result = orderPequeño.setAddress("Carrer Nou 123");
        assertEquals(0, result);
    }

    @Test
    public void testGetAddressAfterValidSet_orderPequeño() {
        orderPequeño.setAddress("Carrer Nou 123");
        assertEquals("Carrer Nou 123", orderPequeño.getAddress());
    }

    @Test
    public void testSetAddressInvalid_orderPequeño() {
        int result = orderPequeño.setAddress("C/1");
        assertEquals(-2, result);
    }

    @Test
    public void testGetAddressAfterInvalidSet_orderPequeño() {
        orderPequeño.setAddress("C/1");
        assertNotEquals("C/1", orderPequeño.getAddress());
    }

    // Tests para order (completo)

    @Test
    public void testSetAddressValid_order() {
        int result = order.setAddress("Passeig Marítim 45");
        assertEquals(0, result);
    }

    @Test
    public void testGetAddressAfterValidSet_order() {
        order.setAddress("Passeig Marítim 45");
        assertEquals("Passeig Marítim 45", order.getAddress());
    }

    @Test
    public void testSetAddressInvalid_order() {
        int result = order.setAddress("abc");
        assertEquals(-2, result);
    }

    @Test
    public void testGetAddressAfterInvalidSet_order() {
        order.setAddress("abc");
        assertNotEquals("abc", order.getAddress());
    }


    // ----------- Tests para orderPequeño -----------

    @Test
    public void testSetDNIValid_orderPequeño() {
        int result = orderPequeño.setDNI("98765432Z");
        assertEquals(0, result);
    }

    @Test
    public void testGetDNIAfterValidSet_orderPequeño() {
        orderPequeño.setDNI("98765432Z");
        assertEquals("98765432Z", orderPequeño.getDNI());
    }

    @Test
    public void testSetDNIInvalid_orderPequeño() {
        int result = orderPequeño.setDNI("12345");
        assertEquals(-2, result);
    }

    @Test
    public void testGetDNIAfterInvalidSet_orderPequeño() {
        orderPequeño.setDNI("12345");
        assertNotEquals("12345", orderPequeño.getDNI());
    }

    // ----------- Tests para order (completo) -----------

    @Test
    public void testSetDNIValid_order() {
        int result = order.setDNI("11223344X");
        assertEquals(0, result);
    }

    @Test
    public void testGetDNIAfterValidSet_order() {
        order.setDNI("11223344X");
        assertEquals("11223344X", order.getDNI());
    }

    @Test
    public void testSetDNIInvalid_order() {
        int result = order.setDNI("ABC");
        assertEquals(-2, result);
    }

    @Test
    public void testGetDNIAfterInvalidSet_order() {
        order.setDNI("ABC");
        assertNotEquals("ABC", order.getDNI());
    }


    // ------------- TESTS PARA order ----------------

    @Test
    public void testSetDeliveryDateReturnsZero_order()throws Exception {
        int result = order.setDeliveryDate("2025/06/01-12:00:00");
        assertEquals(0, result);
    }

    @Test
    public void testGetDeliveryDateAfterSet_order()throws Exception {
        order.setDeliveryDate("2025/06/01-12:00:00");
        assertEquals("2025/06/01-12:00:00", order.getDeliveryDate());
    }

    @Test
    public void testStatusAfterSetDeliveryDate_order()throws Exception {
        order.setDeliveryDate("2025/06/01-12:00:00");
        assertEquals("DELIVERED", order.getStatus());
    }


    // ------------- TESTS PARA orderPequeño ----------------

    @Test
    public void testSetDeliveryDateReturnsZero_orderPequeño()throws Exception {
        int result = orderPequeño.setDeliveryDate("2025/05/21-10:15:00");
        assertEquals(0, result);
    }

    @Test
    public void testGetDeliveryDateAfterSet_orderPequeño()throws Exception {
        orderPequeño.setDeliveryDate("2025/05/21-10:15:00");
        assertEquals("2025/05/21-10:15:00", orderPequeño.getDeliveryDate());
    }

    @Test
    public void testStatusAfterSetDeliveryDate_orderPequeño()throws Exception {
        orderPequeño.setDeliveryDate("2025/05/21-10:15:00");
        assertEquals("DELIVERED", orderPequeño.getStatus());
    }


    @Test
    public void testSetDetailCorrect_order() throws ServiceException {
        int result = order.setDetail("TestArticle", 1, "REF123", 10.0, 2, 8.0);
        assertEquals(0, result);
    }

    @Test
    public void testNumDetailsAfterSetDetail_order() {
        order.setDetail("TestArticle", 1, "REF123", 10.0, 2, 8.0);
        assertEquals(2, order.getNumDetails()); // había 1 ya en el constructor
    }

        @Test
        public void testGetDetailAfterSetDetail_order() throws ServiceException {
            try {
                order.setDetail("TestArticle", 1, "REF123", 10.0, 2, 8.0);
                String detail = order.getDetail(0);
                assertTrue(detail.contains("TestArticle"));
                assertTrue(detail.contains("REF123"));
            } catch (ServiceException e) {
                assertEquals("Sembla que no hi ha ningún Order Detail creat", e.getMessage());
            }
        }
        
    @Test
    public void testSetDetailInvalidQuantity_order() {
        int initialSize = order.getNumDetails();
        order.setDetail("InvalidArticle", 0, "BADREF", 10.0, 1, 9.0);
        assertEquals(initialSize, order.getNumDetails()); // no se añadió
    }

    @Test
    public void testSetDetailInvalidQuantity_orderPequeño() {
        int initialSize = orderPequeño.getNumDetails();
        orderPequeño.setDetail("InvalidArticle", 0, "BADREF", 10.0, 1, 9.0);
        assertEquals(initialSize, orderPequeño.getNumDetails()); // sigue en 0
    }


    @Test
    public void testSetFinishDateCorrect_order() {
        int result = order.setFinishDate("2000/12/25-10:10:10");
        assertEquals(0, result);
    }

    @Test
    public void testGetFinishDateAfterSet_order() {
        order.setFinishDate("2000/12/25-10:10:10");
        assertEquals("2000/12/25-10:10:10", order.getFinishDate());
    }

    @Test
    public void testStatusAfterSetFinishDate_order() {
        order.setFinishDate("2000/12/25-10:10:10");
        assertEquals("FINISHED", order.getStatus());
    }

    @Test
    public void testSetFinishDateCorrect_orderPequeño() {
        int result = orderPequeño.setFinishDate("2001/01/01-12:00:00");
        assertEquals(0, result);
    }

    @Test
    public void testGetFinishDateAfterSet_orderPequeño() {
        orderPequeño.setFinishDate("2001/01/01-12:00:00");
        assertEquals("2001/01/01-12:00:00", orderPequeño.getFinishDate());
    }

    @Test
    public void testStatusAfterSetFinishDate_orderPequeño() {
        orderPequeño.setFinishDate("2001/01/01-12:00:00");
        assertEquals("FINISHED", orderPequeño.getStatus());
    }


    @Test
    public void testSetIdClientCorrect_order() {
        int result = order.setIdClient("8765432Z");
        assertEquals(0, result);
    }

    @Test
    public void testGetIdClientAfterSet_order() {
        order.setIdClient("8765432Z");
        assertEquals("8765432Z", order.getIdClient());
    }

    @Test
    public void testSetIdClientTooShort_order() {
        int result = order.setIdClient("123");
        assertEquals(-2, result);
    }

    @Test
    public void testSetIdClientCorrect_orderPequeño() {
        int result = orderPequeño.setIdClient("999999X");
        assertEquals(0, result);
    }

    @Test
    public void testGetIdClientAfterSet_orderPequeño() {
        orderPequeño.setIdClient("999999X");
        assertEquals("999999X", orderPequeño.getIdClient());
    }

    @Test
    public void testSetIdClientTooShort_orderPequeño() {
        int result = orderPequeño.setIdClient("abc");
        assertEquals(-2, result);
    }


    @Test
    public void testSetInitDateCorrect_order() {
        int result = order.setInitDate("2025/01/01-10:00:00");
        assertEquals(0, result);
    }

    @Test
    public void testGetInitDateAfterSet_order() {
        order.setInitDate("2025/01/01-10:00:00");
        assertEquals("2025/01/01-10:00:00", order.getInitDate());
    }

    @Test
    public void testStatusAfterSetInitDate_order() {
        order.setInitDate("2025/01/01-10:00:00");
        assertEquals("CREATED", order.getStatus());
    }
    @Test
    public void testSetInitDateCorrect_orderPequeño() {
        int result = orderPequeño.setInitDate("2025/01/02-12:00:00");
        assertEquals(0, result);
    }

    @Test
    public void testGetInitDateAfterSet_orderPequeño() {
        orderPequeño.setInitDate("2025/01/02-12:00:00");
        assertEquals("2025/01/02-12:00:00", orderPequeño.getInitDate());
    }

    @Test
    public void testStatusAfterSetInitDate_orderPequeño() {
        orderPequeño.setInitDate("2025/01/02-12:00:00");
        assertEquals("CREATED", orderPequeño.getStatus());
    }


    @Test
    public void testSetNameValid_order() {
        int result = order.setName("Maria");
        assertEquals(0, result);
    }

    @Test
    public void testSetNameTooShort_order() {
        int result = order.setName("M");
        assertEquals(-2, result);
    }

    @Test
    public void testGetNameAfterSet_order() {
        order.setName("Maria");
        assertEquals("Maria", order.getName());
    }


        @Test
        void testSetPackagedDimensions() {

        }

    @Test
    public void testSetPaymentDate_ReturnsZero_Order() throws Exception {
        String validDate = "2025/05/21-10:15:30";
        int result = order.setPaymentDate(validDate);
        assertEquals(0, result);
    }

    @Test
    public void testSetPaymentDate_StatusConfirmed_Order() throws Exception {
        String validDate = "2025/05/21-10:15:30";
        order.setPaymentDate(validDate);
        assertEquals("CONFIRMED", order.getStatus());
    }

    @Test
    public void testSetPaymentDate_DateStoredCorrectly_Order() throws Exception {
        String validDate = "2025/05/21-10:15:30";
        order.setPaymentDate(validDate);
        assertEquals(validDate, order.getPaymentDate());
    }

    @Test
    public void testSetPaymentDate_ReturnsZero_OrderPequeño() throws Exception {
        String validDate = "2025/05/21-10:15:30";
        int result = orderPequeño.setPaymentDate(validDate);
        assertEquals(0, result);
    }

    @Test
    public void testSetPaymentDate_StatusConfirmed_OrderPequeño() throws Exception {
        String validDate = "2025/05/21-10:15:30";
        orderPequeño.setPaymentDate(validDate);
        assertEquals("CONFIRMED", orderPequeño.getStatus());
    }

    @Test
    public void testSetPaymentDate_DateStoredCorrectly_OrderPequeño() throws Exception {
        String validDate = "2025/05/21-10:15:30";
        orderPequeño.setPaymentDate(validDate);
        assertEquals(validDate, orderPequeño.getPaymentDate());
    }

    @Test
    public void testSetPaymentDate_InvalidFormat_ReturnsErrorCode() {
        String invalidDate = "2025-05-21 10:15:30"; // formato incorrecto
        int result = order.setPaymentDate(invalidDate);
        assertEquals(-1, result);
    }

    @Test
    public void testSetPaymentDate_NullInput_ReturnsErrorCode() {
        int result = order.setPaymentDate(null);
        assertEquals(-1, result);
    }

    // Test unitarios para setPhoneContact
    @Test
    public void testSetPhoneContactValidoPequeño() {
        int res = orderPequeño.setPhoneContact("987654321");
        assertEquals(0, res);
    }

    @Test
    public void testSetPhoneContactValidoNormal() {
        int res = order.setPhoneContact("987654321");
        assertEquals(0, res);
    }

    @Test
    public void testSetPhoneContactInvalidoPequeño() {
        int res = orderPequeño.setPhoneContact("123");
        assertEquals(-2, res);
    }

    @Test
    public void testSetPhoneContactInvalidoNormal() {
        int res = order.setPhoneContact("123");
        assertEquals(-2, res);
    }

    // Test unitarios para getPhoneContact (solo comprueba que contiene el valor tras set)

    @Test
    public void testGetPhoneContactPequeño() {
        orderPequeño.setPhoneContact("987654321");
        assertTrue(orderPequeño.getPhoneContact().contains("987654321"));
    }

    @Test
    public void testGetPhoneContactNormal() {
        order.setPhoneContact("987654321");
        assertTrue(order.getPhoneContact().contains("987654321"));
    }

    // Tests para setSurname

    @Test
    public void testSetSurnameValidoPequeño() {
        int res = orderPequeño.setSurname("Perez");
        assertEquals(0, res);
    }

    @Test
    public void testSetSurnameValidoNormal() {
        int res = order.setSurname("Perez");
        assertEquals(0, res);
    }

    @Test
    public void testSetSurnameInvalidoPequeño() {
        int res = orderPequeño.setSurname("Li");
        assertEquals(-2, res);
    }

    @Test
    public void testSetSurnameInvalidoNormal() {
        int res = order.setSurname("Li");
        assertEquals(-2, res);
    }

    // Tests para getSurname

    @Test
    public void testGetSurnamePequeño() {
        orderPequeño.setSurname("Garcia");
        assertEquals("Garcia", orderPequeño.getSurname());
    }

    @Test
    public void testGetSurnameNormal() {
        order.setSurname("Garcia");
        assertEquals("Garcia", order.getSurname());
    }

    // shopcartcancelled éxito orderPequeño
    @Test
    public void testShopcartcancelledSuccessPequeño() throws BuildException {
        orderPequeño.setInitDate("2025/01/01-00:00:00");
        orderPequeño.setDetail("libro", 1, "ref1", 10.0, 0, 10.0);
        assertEquals(-2, orderPequeño.shopcartcancelled());
    }

    // shopcartcancelled status cambiado a CREATED orderPequeño
    @Test
    public void testShopcartcancelledStatusChangedPequeño() throws BuildException {
        orderPequeño.setInitDate("2025/01/01-00:00:00");
        orderPequeño.setDetail("libro", 1, "ref1", 10.0, 0, 10.0);
        orderPequeño.shopcartcancelled();
        assertEquals(OrderStatus.CREATED.name(), orderPequeño.getStatus());
    }

    // shopcartcancelled shopCart vacío orderPequeño
    @Test
    public void testShopcartcancelledEmptyShopCartPequeño() throws BuildException {
        orderPequeño.setInitDate("2025/01/01-00:00:00");
        assertEquals(-2, orderPequeño.shopcartcancelled());
    }

    // shopcartcancelled éxito order normal
    @Test
    public void testShopcartcancelledSuccessNormal() {
        order.setInitDate("2025/01/01-00:00:00");
        order.setDetail("libro", 1, "ref1", 10.0, 0, 10.0);
        assertEquals(0, order.shopcartcancelled());
    }

    // shopcartcancelled status cambiado a CANCELLED order normal
    @Test
    public void testShopcartcancelledStatusChangedNormal() {
        order.setInitDate("2025/01/01-00:00:00");
        order.setDetail("libro", 1, "ref1", 10.0, 0, 10.0);
        order.shopcartcancelled();
        assertEquals(OrderStatus.CANCELLED.name(), order.getStatus());
    }

    // shopcartcancelled shopCart vacío order normal
    @Test
    public void testShopcartcancelledEmptyShopCartNormal() {
        order.setInitDate("2025/01/01-00:00:00");
        order.shopCart.clear();
        assertEquals(-2, order.shopcartcancelled());
    }

    // 2. updateDetail posición inválida en orderPequeño
    @Test
    public void testUpdateDetailInvalidPositionOrderPequeño() throws Exception {
        orderPequeño.setInitDate("2025/01/01-00:00:00");
        orderPequeño.setDetail("libro", 1, "ref1", 10.0, 0, 10.0);
        try {
            orderPequeño.updateDetail(2, 5);
            fail();
        } catch (ServiceException e) {
            assertEquals("No existeix el producte", e.getMessage());
        }
    }

    // 3. updateDetail estado no CREATED en orderPequeño
    @Test
    public void testUpdateDetailWrongStatusOrderPequeño() throws Exception {
        try {
            orderPequeño.updateDetail(0, 5);
            fail();
        } catch (ServiceException e) {
            assertEquals("No existeix el producte", e.getMessage());
        }
    }

    // 4. updateDetail éxito en order normal
    @Test
    public void testUpdateDetailSuccessOrderNormal() throws Exception {
        order.setInitDate("2025/01/01-00:00:00");
        order.setDetail("libro", 1, "ref1", 10.0, 0, 10.0);
        int res = order.updateDetail(0, 7);
        assertEquals(0, res);
    }

    // 5. updateDetail posición inválida en order normal
    @Test
    public void testUpdateDetailInvalidPositionOrderNormal() throws Exception {
        order.setInitDate("2025/01/01-00:00:00");
        order.setDetail("libro", 1, "ref1", 10.0, 0, 10.0);
        try {
            order.updateDetail(5, 7);
            fail();
        } catch (ServiceException e) {
            assertEquals("No existeix el producte", e.getMessage());
        }
    }

    // 6. updateDetail estado no CREATED en order normal
    @Test
    public void testUpdateDetailWrongStatusOrderNormal() throws Exception {
        try {
            order.updateDetail(0, 7);
            fail();
        } catch (ServiceException e) {
            assertEquals("No es pot eliminar perquè està pagat.", e.getMessage());
        }
    }

    @Test
    public void testGetCalcularVolumOrderNormal() {
        // Según el constructor, order tiene:
        // high=13.0, width=13.0, length=10.0
        // volumen esperado = 13.0 * 13.0 * 10.0 = 1690.0
        double expectedVolume = 13.0 * 13.0 * 10.0;
        assertEquals(expectedVolume, order.getCalcularVolum(), 0.0001);
    }

    // --- Tests SET ---
    // Test válido para order normal (setDepth)
    @Test
    public void testSetDepthValidoOrder() {
        double depth = 7.5;
        int result = order.setDepth(depth);
        assertEquals(0, result); // set correcto
    }

    // Test negativo para order normal (error -3)
    @Test
    public void testSetDepthNegativoOrder() {
        double depth = -10.0;
        int result = order.setDepth(depth);
        assertEquals(-3, result); // error por valor negativo
    }

    // --- Tests GET ---

    // Test getDepth para orderPequeño (tras set previo en setup o test separado)
    // Test getDepth para order normal
    @Test
    public void testGetDepthOrder() {
        double expected = 7.5;
        order.setDepth(expected);
        assertEquals(expected, order.orderPackage.getDepth(), 0.0001);
    }

    // --- Tests SET ---
    // Test setFragil true para order normal
    @Test
    public void testSetFragilTrueOrder() {
        int result = order.setFragil(true);
        assertEquals(0, result);
    }

    // Test setFragil false para order normal
    @Test
    public void testSetFragilFalseOrder() {
        int result = order.setFragil(false);
        assertEquals(0, result);
    }

    // --- Tests GET ---
    // Test getFragil para order normal tras set true
    @Test
    public void testGetFragilTrueOrder() {
        order.setFragil(true);
        assertTrue(order.orderPackage.getFragil());
    }

    // Test getFragil para order normal tras set false
    @Test
    public void testGetFragilFalseOrder() {
        order.setFragil(false);
        assertFalse(order.orderPackage.getFragil());
    }

    // --- Tests SET ---
    // Test setHigh válido para order normal
    @Test
    public void testSetHighValidoOrder() {
        double value = 15.5;
        int result = order.setHigh(value);
        assertEquals(0, result);
    }

    // Test setHigh negativo para order normal (error -3)
    @Test
    public void testSetHighNegativoOrder() {
        double value = -20.0;
        int result = order.setHigh(value);
        assertEquals(-3, result);
    }

    // --- Tests GET ---
    // Test getHigh tras set válido para order normal
    @Test
    public void testGetHighOrder() {
        double value = 15.5;
        order.setHigh(value);
        assertEquals(value, order.orderPackage.getHigh(), 0.0001);
    }

    // --- Tests SET ---

    // Test setLength válido para order normal
    @Test
    public void testSetLengthValidoOrder() {
        double value = 20.0;
        int result = order.setLength(value);
        assertEquals(0, result);
    }

    // Test setLength negativo para order normal (error -3)
    @Test
    public void testSetLengthNegativoOrder() {
        double value = -10.0;
        int result = order.setLength(value);
        assertEquals(-3, result);
    }

    // --- Tests GET ---
    // Test getLength tras set válido para order normal
    @Test
    public void testGetLengthOrder() {
        double value = 20.0;
        order.setLength(value);
        assertEquals(value, order.orderPackage.getLength(), 0.0001);
    }

    // --- Tests SET ---

    // Test setWeight válido para order normal
    @Test
    public void testSetWeightValidoOrder() {
        double value = 30.0;
        int result = order.setWeight(value);
        assertEquals(0, result);
    }

    // Test setWeight negativo para order normal (error -3)
    @Test
    public void testSetWeightNegativoOrder() {
        double value = -5.5;
        int result = order.setWeight(value);
        assertEquals(-3, result);
    }

    // --- Tests GET ---
    // Test getWeight tras set válido para order normal
    @Test
    public void testGetWeightOrder() {
        double value = 30.0;
        order.setWeight(value);
        assertEquals(value, order.orderPackage.getWeight(), 0.0001);
    }

    // --- Tests SET ---
    // Test setWidth válido para order normal
    @Test
    public void testSetWidthValidoOrder() {
        double value = 25.5;
        int result = order.setWidth(value);
        assertEquals(0, result);
    }

    // Test setWidth negativo para order normal (error -3)
    @Test
    public void testSetWidthNegativoOrder() {
        double value = -5.0;
        int result = order.setWidth(value);
        assertEquals(-3, result);
    }

    // --- Tests GET ---

    // Test getWidth tras set válido para order normal
    @Test
    public void testGetWidthOrder() {
        double value = 25.5;
        order.setWidth(value);
        assertEquals(value, order.orderPackage.getWidth(), 0.0001);
    }

    @Test
    public void testSetShopCartDetails() throws Exception {
        order = new Order();
        String input = "nomarticle:Libro,quantitat:2,referencia:REF123,preuindividual:15.5,descompte:10,total:27.9";
        int result = order.setShopCartDetails(input);
        assertEquals(0, result);
        assertEquals(1, order.getShopCart().size());
        OrderDetail detail = order.getShopCart().get(0);
        assertEquals("Libro", detail.getNamearticles());
        assertEquals(2, detail.getQuantity());
        assertEquals("REF123", detail.getReference());
        assertEquals(15.5, detail.getIndividualPrice(), 0.01);
        assertEquals(10, detail.getDiscount());
        assertEquals(21.0, detail.getTotal(), 0.01);
    }
}