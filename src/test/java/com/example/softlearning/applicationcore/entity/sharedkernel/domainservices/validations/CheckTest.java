package com.example.softlearning.applicationcore.entity.sharedkernel.domainservices.validations;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class CheckTest {
    // Comprovar el null
    @Test
    void testIsNull() {
        assertTrue(Check.isNull(null)); 
    }

    @Test
    void testIsNotNull() {
        assertFalse(Check.isNull("Hola"));
    }

    // Comprovar el minLenght
    @Test
    void testMinLengthValid() {
        assertEquals(0, Check.minLenght("Java", 3)); 
    }

    @Test
    void testMinLengthInvalid() {
        assertEquals(-1, Check.minLenght("Hi", 3)); 
    }

    @Test
    void testMinLengthTrim() {
        assertEquals(0, Check.minLenght("  Hola  ", 4)); 
    }

    @Test
    void testMinLengthEmpty() {
        assertEquals(-1, Check.minLenght("   ", 1)); 
    }

    // Comprovar el negatiu de int
    @Test
    void testIsNegative() {
        assertEquals(-3, Check.isNegative(-5)); 
    }

    @Test
    void testIsZeroNegative() {
        assertEquals(-3, Check.isNegative(0));
    }

    @Test
    void testIsPositive() {
        assertEquals(0, Check.isNegative(5)); 
    }

    // Comprovar el negatiu de double
    @Test
    void testIsNegativeDouble() {
        assertEquals(-3, Check.isNegatived(-2.5));
    }

    @Test
    void testIsZeroNegativeDouble() {
        assertEquals(-3, Check.isNegatived(0.0));
    }

    @Test
    void testIsPositiveDouble() {
        assertEquals(0, Check.isNegatived(2.5)); 
    }

    // Comprovar getErrorMessage
    @Test
    void testGetErrorMessageDone() {
        assertEquals("Done, ", Check.getErrorMessage(0)); 
    }

    @Test
    void testGetErrorMessageEmptyField() {
        assertEquals("El camp està buit, ", Check.getErrorMessage(-1)); 
    }

    @Test
    void testGetErrorMessageTooShort() {
        assertEquals("El camp ha de ser més llarg, ", Check.getErrorMessage(-2)); 
    }

    @Test
    void testGetErrorMessageNegativeOrZero() {
        assertEquals("No pot ser negatiu o 0, ", Check.getErrorMessage(-3));
    }

    @Test
    void testGetErrorMessageUnknown() {
        assertEquals("Unknown error, ", Check.getErrorMessage(999)); 
    }
}