package com.example.softlearning.applicationcore.entity.sharedkernel.model.physics;

import com.example.softlearning.applicationcore.entity.sharedkernel.model.exceptions.BuildException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;

class PhysicalDataTest {
    private PhysicalData p;

    @BeforeEach
    public void setUp() throws Exception {
        p = PhysicalData.getInstancePhysical(10, 5, 4, 15, true, 3);
    }
    
    // GetInstance Correcte
    @Test
    void testGetInstancePhysical() {
        try {
            PhysicalData p = PhysicalData.getInstancePhysical(10, 5, 4, 15, true, 3);
            assertNotNull(p);
        } catch (BuildException e) {
            fail();
        }
    }

    // GetIntance Incorrecte
    @Test
    void testGetBadInstancePhysical() throws BuildException {
        try {
            PhysicalData p = PhysicalData.getInstancePhysical(-10, -5, 0, 0, false, -3);
            fail();
        } catch (BuildException e) {
            assertEquals("No pot ser negatiu o 0, No pot ser negatiu o 0, No pot ser negatiu o 0, No pot ser negatiu o 0, No pot ser negatiu o 0, ",e.getMessage());
        }
    }

    // GetIntance Incorrecte High
    @Test
    void testGetBadInstancePhysicalHigh() throws BuildException {
        try {
            PhysicalData p = PhysicalData.getInstancePhysical(-10, 5, 10, 10, false, 13);
            fail();
        } catch (BuildException e) {
            assertEquals("No pot ser negatiu o 0, ",e.getMessage());
            
        }
    }

    // GetIntance IncorrecteWidth
    @Test
    void testGetBadInstancePhysicalWidth() throws BuildException {
        try {
            PhysicalData p = PhysicalData.getInstancePhysical(10, -5, 10, 10, false, 13);
            fail();
        } catch (BuildException e) {
            assertEquals("No pot ser negatiu o 0, ",e.getMessage());
            
        }
    }

    // GetIntance Incorrecte Length
    @Test
    void testGetBadInstancePhysicalLength() throws BuildException {
        try {
            PhysicalData p = PhysicalData.getInstancePhysical(10, 5, 0, 10, false, 13);
            fail();
        } catch (BuildException e) {
            assertEquals("No pot ser negatiu o 0, ",e.getMessage());
            
        }
    }

    // GetIntance Incorrecte Weight
    @Test
    void testGetBadInstancePhysicalWeight() throws BuildException {
        try {
            PhysicalData p = PhysicalData.getInstancePhysical(10, 5, 4, 0, false, 6);
            fail();
        } catch (BuildException e) {
            assertEquals("No pot ser negatiu o 0, ",e.getMessage());
        }
    }

    // GetIntance Incorrecte Depth
    @Test
    void testGetBadInstancePhysicalDepth() throws BuildException {
        try {
            PhysicalData p = PhysicalData.getInstancePhysical(10, 5, 4, 8, false, -3);
            fail();
        } catch (BuildException e) {
            assertEquals("No pot ser negatiu o 0, ",e.getMessage());
            
        }
    }

    // Comprovar el GetHigh
    @Test
    void testGetHigh() {
        assertEquals(10, p.getHigh());
    }

    // Comprovar el SetHigh
    @Test
    void testSetHighValid() {
        int result = p.setHigh(25.5);
        assertEquals(0, result);// Validació exitosa
    }

    @Test
    void testSetHighSave() {
        p.setHigh(25.5);
        assertEquals(25.5, p.getHigh());// Valida que el valor és magatzem correctament
    }

    @Test
    void testSetHighNegativeZero() {
        int result = p.setHigh(-0);
        assertEquals(-3, result);// Valida que el valor és negatiu
    }

    @Test
    void testSetHighNegative() {
        int result = p.setHigh(-10);
        assertEquals(-3, result);// Valida que el valor és negatiu
    }

    // Comprovar el GetWidth
    @Test
    void testGetWidth() {
        assertEquals(5, p.getWidth());
    }

    // Comprovar el SetWidth
    @Test
    void testSetWidthValid() {
        int result = p.setWidth(10);
        assertEquals(0, result);// Validació exitosa
    }

    @Test
    void testSetWidthSave() {
        p.setWidth(10);
        assertEquals(10, p.getWidth());// Valida que el valor és magatzem correctament
    }

    @Test
    void testSetWidthNegative() {
        int result = p.setWidth(-5);
        assertEquals(-3, result);// Valida que el valor és negatiu
    }
        @Test
    void testSetWidthZero() {
        int result = p.setWidth(0);
        assertEquals(-3, result);// Valida que el valor és negatiu
    }

    // Comprovar el GetLength
    @Test
    void testGetLength() {
        assertEquals(4, p.getLength());
    }

    // Comprovar el SetLength
    @Test
    void testSetLengthValid() {
        int result = p.setLength(40);
        assertEquals(0, result);// Validació exitosa
    }

    @Test
    void testSetLengthValidZero() {
        int result = p.setLength(0);
        assertEquals(-3, result);// Validació exitosa
    }

    @Test
    void testSetLengthSave() {
        p.setLength(40);
        assertEquals(40, p.getLength());// Valida que el valor és magatzem correctament
    }

    @Test
    void testSetLengthNegative() {
        int result = p.setLength(-5);
        assertEquals(-3, result);// Valida que el valor és negatiu
    }

    // Comprovar el GetWeight
    @Test
    void testGetWeight() {
        assertEquals(15, p.getWeight());
    }

    // Comprovar el SetWeight
    @Test
    void testSetWeightValid() {
        int result = p.setWeight(80.5);
        assertEquals(0, result);// Validació exitosa
    }

    @Test
    void testSetWeightSave() {
        p.setWeight(80.5);
        assertEquals(80.5, p.getWeight());// Valida que el valor és magatzem correctament
    }

    @Test
    void testSetWeightNegative() {
        int result = p.setWeight(-10);
        assertEquals(-3, result);// Valida que el valor és negatiu
    }
    @Test
    void testSetWeightZero() {
        int result = p.setWeight(0);
        assertEquals(-3, result);// Valida que el valor és negatiu
    }

    // Comprovar el GetFragil
    @Test
    void testGetFragil() {
        assertTrue(p.getFragil());
    }

    // Comprovar SetFragil
    @Test
    void testSetFragilValid() {
        int result = p.setFragil(true);
        assertEquals(0, result);
        assertTrue(p.getFragil());// Valida que el valor és magatzem correctament mirar
    }

    @Test
    void testSetFragilInvalid() {
        int result = p.setFragil(false);
        assertEquals(0, result);
        assertFalse(p.getFragil());// Valida que el valor és magatzem correctament mirar
    }

    // Comprovar GetDepth
    @Test
    void testGetDepth() {
        assertEquals(3, p.getDepth());
    }

    // Comprovar SetDepth
    @Test
    void testSetDepthValid() {
        int result = p.setDepth(12.5);
        assertEquals(0, result);// Validació exitosa
    }

    @Test
    void testSetDepthSave() {
        p.setDepth(12.5);
        assertEquals(12.5, p.getDepth());// Valida que el valor és magatzem correctament
    }

    @Test
    void testSetDepthNegative() {
        int result = p.setDepth(-5.0);
        assertEquals(-3, result); // Valida quan el valor es negatiu
    }
    @Test
    void testSetDepthNegativeZero() {
        int result = p.setDepth(0);
        assertEquals(-3, result); // Valida quan el valor es negatiu
    }

    // Comprovar el GetVolume
    @Test
    void testGetVolume() {
        double expectedVolume = 10 * 5 * 4;
        assertEquals(expectedVolume, p.getVolume());
    }

    // Calcular el volum
    @Test
    void testGetCalcularVolum() {
        int length = 5;
        int width = 4;
        int high = 3;

        int expectedVolume = 60;
        int actualVolume = PhysicalData.getCalcularVolum(length, width, high);
        assertEquals(expectedVolume, actualVolume);
    }
}