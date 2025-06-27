package com.example.softlearning.applicationcore.entity.client.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import com.example.softlearning.applicationcore.entity.sharedkernel.model.exceptions.BuildException;
import org.junit.jupiter.api.BeforeEach;

public class ClientTest {
    private Client client;
    
    @BeforeEach
    public void setUp() throws Exception {
        client = Client.getInstanceClient("Javava", "Javava", "javava@gmail.com", "45678", "Av.Montflorit", "2000-12-01", 12121212, "Targeta");
    }

    // GetInstance Correcta
    @Test
    void testGetInstanceClient() {
        try {
            Client client = Client.getInstanceClient("Javava", "Javava", "javava@gmail.com", "45678", "Av.Montflorit", "2000-12-01", 12121212, "Targeta");
            assertNotNull(client);
        } catch (BuildException e) {
            fail();
        }
    }

    // GetInstance Incorrecte
    @Test
    void testBadGetInstanceClient(){
        try{
            Client client = Client.getInstanceClient("", "", "", "", "", "2000-12-01", 0, "");
            fail();
        }catch (BuildException e) {
            assertEquals("El camp ha de ser més llarg, El camp ha de ser més llarg, El camp ha de ser més llarg, El camp ha de ser més llarg, El camp ha de ser més llarg, No pot ser negatiu o 0, El camp ha de ser més llarg, ",e.getMessage());
        }
    }

    // GetInstance Incorrecte Nom
    @Test
    void testBadGetInstanceClientName(){
        try{
            Client client = Client.getInstanceClient("", "Javava", "javava@gmail.com", "45678", "Av.Montflorit", "2000-12-01", 12121212, "Targeta");
            fail();
        }catch (BuildException e) {
            assertEquals("El camp ha de ser més llarg, ",e.getMessage());
        }
    }

    // GetInstance Incorrecte Cognoms
    @Test
    void testBadGetInstanceClientSurname(){
        try{
            Client client = Client.getInstanceClient("Javava", "", "javava@gmail.com", "45678", "Av.Montflorit", "2000-12-01", 12121212, "Targeta");
            fail();
        }catch (BuildException e) {
            assertEquals("El camp ha de ser més llarg, ",e.getMessage());
        }
    }

    // GetInstance Incorrecte Email
    @Test
    void testBadGetInstanceClientEmail(){
        try{
            Client client = Client.getInstanceClient("Javava", "Javava", "", "45678", "Av.Montflorit", "2000-12-01", 12121212, "Targeta");
            fail();
        }catch (BuildException e) {
            assertEquals("El camp ha de ser més llarg, ",e.getMessage());
        }
    }

    // GetInstance Incorrecte Número
    @Test
    void testBadGetInstanceClientNumber(){
        try{
            Client client = Client.getInstanceClient("Javava", "Javava", "javava@gmail.com", "", "Av.Montflorit", "2000-12-01", 12121212, "Targeta");
            fail();
        }catch (BuildException e) {
            assertEquals("El camp ha de ser més llarg, ",e.getMessage());
        }
    }

    // GetInstance Incorrecte Adreça
    @Test
    void testBadGetInstanceClientAddress(){
        try{
            Client client = Client.getInstanceClient("Javava", "Javava", "javava@gmail.com", "45678", "", "2000-12-01", 12121212, "Targeta");
            fail();
        }catch (BuildException e) {
            assertEquals("El camp ha de ser més llarg, ",e.getMessage());
        }
    }

    // GetInstance Incorrecte Identificació
    @Test
    void testBadGetInstanceClientIdent(){
        try{
            Client client = Client.getInstanceClient("Javava", "Javava", "javava@gmail.com", "45678", "Av.Montflorit", "2000-12-01", 0, "Targeta");
            fail();
        }catch (BuildException e) {
            assertEquals("No pot ser negatiu o 0, ",e.getMessage());
        }
    }

    // GetInstance Incorrecte Mètode de pagament
    @Test
    void testBadGetInstanceClientPaymentcode(){
        try{
            Client client = Client.getInstanceClient("Javava", "Javava", "javava@gmail.com", "45678", "Av.Montflorit", "2000-12-01", 12121212, "t");
            fail();
        }catch (BuildException e) {
            assertEquals("El camp ha de ser més llarg, ",e.getMessage());
        }
    }

    // Comprovar el GetPaymentCode
    @Test
    void testGetPaymentcode() {
        assertEquals("Targeta",client.getPaymentcode());
    }

    // Comprovar el SetPaymentCode
    @Test
    void testSetPaymentcodeValid() {
        int result = client.setPaymentcode("Targeta");
        assertEquals(0, result);// Validació exitosa
    }

    @Test
    void testSetPaymentcodeSave() {
        client.setPaymentcode("Targeta");
        assertEquals("Targeta", client.getPaymentcode());// Valida que el valor és magatzem correctament
    }

    @Test
    void testSetPaymentcodeNull() {
        int result = client.setPaymentcode(null);
        assertEquals(-1, result);// Valida que el valor sigui null
    }

    @Test
    void testSetPaymentcodeMinLength() {
        int result = client.setPaymentcode("T");
        assertEquals(-2, result);// Valida que el valor es menor
    }
        @Test
    void testSetPaymentcodeNotSpace() {
        int result = client.setPaymentcode(" ");
        assertEquals(-2, result);// Valida que el valor es menor
    }

    // Comprovar GetDetails
    @Test
    void testGetDetails() {
        assertEquals("CLIENT: Nom: Javava, Cognoms: Javava, Aniversari: 2000-12-01, Email: javava@gmail.com, Número telèfon: 45678, Adreça: Av.Montflorit, Número de soci: 12121212, Mètode de pagament: Targeta",client.getDetails());
    }
}