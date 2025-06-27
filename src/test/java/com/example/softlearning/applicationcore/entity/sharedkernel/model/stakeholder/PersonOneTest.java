package com.example.softlearning.applicationcore.entity.sharedkernel.model.stakeholder;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.softlearning.applicationcore.entity.sharedkernel.model.exceptions.BuildException;

public class PersonOneTest {
    private PersonOne p;
    
    @BeforeEach
    public void setUp() throws Exception {
        p = new PersonOne();
        p.PersonCheck("Javava", "Javava", "javava@gmail.com", "45678", "Av.Montflorit", "2000-12-01", 12121212);
    }
    
    // GetInstance Correcta
    @Test
    void testgetInstancePerson() {
        try {
            p.PersonCheck("Javava", "Javava", "javava@gmail.com", "45678", "Av.Montflorit", "2000-12-01", 12121212);
            assertNotNull(p);
        } catch (BuildException e) {
            fail();
        }
    }
    
    // GetInstance Incorrecte
    @Test
    void testBadgetInstancePerson(){
        try{
            p.PersonCheck("", "", "", "", "", "2000-12-01", 0);
            fail();
        }catch (BuildException e) {
            assertEquals("El camp ha de ser més llarg, El camp ha de ser més llarg, El camp ha de ser més llarg, El camp ha de ser més llarg, El camp ha de ser més llarg, No pot ser negatiu o 0, ",e.getMessage());
        }
    }

    // GetInstance Incorrecte Nom
    @Test
    void testBadgetInstancePersonName(){
        try{
            p.PersonCheck("", "Javava", "javava@gmail.com", "45678", "Av.Montflorit", "2000-12-01", 12121212);
            fail();
        }catch (BuildException e) {
            assertEquals("El camp ha de ser més llarg, ",e.getMessage());
        }
    }
    
    // GetInstance Incorrecte Cognoms
    @Test
    void testBadgetInstancePersonSurname(){
        try{
            p.PersonCheck("Javava", "", "javava@gmail.com", "45678", "Av.Montflorit", "2000-12-01", 12121212);
            fail();
        }catch (BuildException e) {
            assertEquals("El camp ha de ser més llarg, ",e.getMessage());
        }
    }

    // GetInstance Incorrecte Email
    @Test
    void testBadgetInstancePersonEmail(){
        try{
            p.PersonCheck("Javava", "Javava", "", "45678", "Av.Montflorit", "2000-12-01", 12121212);
            fail();
        }catch (BuildException e) {
            assertEquals("El camp ha de ser més llarg, ",e.getMessage());
        }
    }
    
    // GetInstance Incorrecte Número
    @Test
    void testBadgetInstancePersonNumber(){
        try{
            p.PersonCheck("Javava", "Javava", "javava@gmail.com", "", "Av.Montflorit", "2000-12-01", 12121212);
            fail();
        }catch (BuildException e) {
            assertEquals("El camp ha de ser més llarg, ",e.getMessage());
        }
    }

    // GetInstance Incorrecte Adreça
    @Test
    void testBadgetInstancePersonAddress(){
        try{
            p.PersonCheck("Javava", "Javava", "javava@gmail.com", "45678", "", "2000-12-01", 12121212);
            fail();
        }catch (BuildException e) {
            assertEquals("El camp ha de ser més llarg, ",e.getMessage());
        }
    }

    // GetInstance Incorrecte Identificació
    @Test
    void testBadgetInstancePersonIdent(){
        try{
            p.PersonCheck("Javava", "Javava", "javava@gmail.com", "45678", "Av.Montflorit", "2000-12-01", 0);
            fail();
        }catch (BuildException e) {
            assertEquals("No pot ser negatiu o 0, ",e.getMessage());
        }
    }

    // Comprovar GetName
    @Test
    void testGetName() {
        assertEquals("Javava", p.getName());
    }

    // Comprovar el SetName
    @Test
    void testSetNameValid() {
        int result = p.setName("Java");
        assertEquals(0, result);// Validació exitosa
    }

    @Test
    void testSetNameSave() {
        p.setName("Java");
        assertEquals("Java", p.getName());// Valida que el valor és magatzem correctament
    }

    @Test
    void testSetNameNull() {
        int result= p.setName(null);
        assertEquals(-1, result);// Valida que el valor sigui null
    }

    @Test
    void testSetNameMinLength() {
        int result= p.setName("j");
        assertEquals(-2, result);// Valida que el valor es menor o té espai
    }
        @Test
    void testSetNameMinLengthSpaces() {
        int result= p.setName("                                            ");
        assertEquals(-2, result);// Valida que el valor es menor o té espai
    }

    // Comprovar GetSurname
    @Test
    void testGetSurname() {
        assertEquals("Javava", p.getSurname());
    }

    // Comprovar el SetSurname
    @Test
    void testSetSurnameValid() {
        int result = p.setSurname("Java");
        assertEquals(0, result);// Validació exitosa
    }

    @Test
    void testSetSurnameSave() {
        p.setSurname("Java");
        assertEquals("Java", p.getSurname());// Valida que el valor és magatzem correctament
    }

    @Test
    void testSetSurnameNull() {
        int result= p.setSurname(null);
        assertEquals(-1, result);// Valida que el valor sigui null
    }

    @Test
    void testSetSurnameMinLength() {
        int result= p.setSurname("J");
        assertEquals(-2, result);// Valida que el valor es menor o té espai
    }

    // Comprovar GetEmail
    @Test
    void testGetEmail() {
        assertEquals("javava@gmail.com", p.getEmail());
    }

    // Comprovar el SetEmail
    @Test
    void testSetEmailValid() {
        int result = p.setEmail("jav@gmail.com");
        assertEquals(0, result);// Validació exitosa
    }

    @Test
    void testSetEmailSave() {
        p.setEmail("jav@gmail.com");
        assertEquals("jav@gmail.com", p.getEmail());// Valida que el valor és magatzem correctament
    }

    @Test
    void testSetEmailNull() {
        int result= p.setEmail(null);
        assertEquals(-1, result);// Valida que el valor sigui null
    }

    @Test
    void testSetEmailMinLength() {
        int result= p.setEmail("J");
        assertEquals(-2, result);// Valida que el valor es menor o té espai
    }

    // Comprovar GetNumber
    @Test
    void testGetNumber() {
        assertEquals("45678", p.getNumber());
    }

    // Comprovar el SetNumber
    @Test
    void testSetNumberValid() {
        int result = p.setNumber("4567890");
        assertEquals(0, result);// Validació exitosa
    }

    @Test
    void testSetNumberSave() {
        p.setNumber("4567890");
        assertEquals("4567890", p.getNumber());// Valida que el valor és magatzem correctament
    }

    @Test
    void testSetNumberNull() {
        int result= p.setNumber(null);
        assertEquals(-1, result);// Valida que el valor sigui null
    }

    @Test
    void testSetNumberMinLength() {
        int result= p.setNumber(" ");
        assertEquals(-2, result);// Valida que el valor es menor o té espai
    }

    // Comprovar GetAddress
    @Test
    void testGetAddress() {
        assertEquals("Av.Montflorit",p.getAddress());
    }

    // Comprovar el SetAddress
    @Test
    void testSetAddressValid() {
        int result = p.setAddress("Av.Montflorit/32");
        assertEquals(0, result);// Validació exitosa
    }

    @Test
    void testSetAddressSave() {
        p.setAddress("Av.Montflorit/32");
        assertEquals("Av.Montflorit/32", p.getAddress());// Valida que el valor és magatzem correctament
    }

    @Test
    void testSetAddressNull() {
        int result= p.setAddress(null);
        assertEquals(-1, result);// Valida que el valor sigui null
    }

    @Test
    void testSetAddressMinLength() {
        int result= p.setAddress("j");
        assertEquals(-2, result);// Valida que el valor es menor o té espai
    }

    // Comprovar GetAntiquity
    @Test
    void testGetAntiquity() {
        assertEquals("2000-12-01",p.getAntiquity());
    }

    // Comprovar SetAntiquity
    @Test
    void testSetAntiquityValid() {
        int result = p.setAntiquity("2000-02-29");
        assertEquals(0, result);// Validació exitosa
    }

    @Test
    void testSetAntiquitySave() {
        p.setAntiquity("2000-02-29");
        assertEquals("2000-02-29", p.getAntiquity());// Valida que el valor és magatzem correctament
    }

    @Test
    void testSetAntiquityNull() {
        int result= p.setAntiquity(null);
        assertEquals(-1, result);// Valida que el valor sigui null
    }

    // Comprovar GetIdent
    @Test
    void testGetIdent() {
        assertEquals(12121212,p.getIdent());
    }

    // Comprovar SetIdent
    @Test
    void testSetIdentValid() {
        int result = p.setIdent(1212121);
        assertEquals(0, result);// Validació exitosa
    }

    @Test
    void testSetIdentSave() {
        p.setIdent(1212121);
        assertEquals(1212121, p.getIdent());// Valida que el valor és magatzem correctament
    }

    @Test
    void testSetIdentNegative() {
        int result = p.setIdent(-5);
        assertEquals(-3, result);// Valida que el valor és negatiu
    }

    // Comprovar el GetDetails
    @Test
    void testGetDetails() {
        assertEquals("PERSONONE: Nom: Javava, Cognoms: Javava, Email: javava@gmail.com, Número telèfon:: 45678, Adreça: Av.Montflorit, Antiguitat: 2000-12-01, Identificació: 12121212",p.getDetails());
    }
}