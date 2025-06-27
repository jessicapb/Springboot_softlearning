package com.example.softlearning.applicationcore.entity.sharedkernel.model.operations;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.softlearning.applicationcore.entity.sharedkernel.model.exceptions.BuildException;

public class OperationOneTest {
    private OperationOne operation;

    @BeforeEach
    public void setUp() throws Exception {
        operation = new OperationOne();
        operation.checkOperation(13, "Javava", "2000/12/20-08:20:45", "2000/12/24-09:20:45");//(int reference, String description, String initDate, String finishDate
    }

        // GetInstance Correcta
    @Test
    void testgetInstanceOperation() {
        try {
            operation.checkOperation(13, "Javava", "2000/12/20-08:20:45", "2000/12/24-09:20:45");
            assertNotNull(operation);
        } catch (BuildException e) {
            fail();
        }
    }

    @Test
    void testgetInstanceOperationAllBad() {
        try {
            operation.checkOperation(-13, "", null, null);
            fail();
        } catch (BuildException e) {
            assertEquals("No pot ser negatiu o 0, El camp ha de ser més llarg, ",e.getMessage());
            //No pot ser negatiu o 0, El camp ha de ser més llarg, 
        }
    }

    @Test
    void testgetInstanceOperationBadReference() {
        try {
            operation.checkOperation(-13, "Javava", "2000/12/20-08:20:45", "2000/12/21-08:20:45");
            fail();
        } catch (BuildException e) {
            assertEquals("No pot ser negatiu o 0, ",e.getMessage());
        }
    }
    
    @Test
    void testgetInstanceOperationBadDescription() {
        try {
            operation.checkOperation(13, "", "2000/12/20-08:20:45", "2000/12/21-08:20:45");
            fail();
        } catch (BuildException e) {
            assertEquals("El camp ha de ser més llarg, ",e.getMessage());
        }
    }

    @Test
    void testGetDescription() {
        assertEquals("Javava", operation.getDescription());
    }
    
    @Test
    void testSetDescription() {
        int respuesta = operation.setDescription("buenas");
        assertEquals(0,respuesta);
    }

    @Test
    void testSetDescriptionSave() {
        operation.setDescription("buenas");
        assertEquals("buenas",operation.getDescription());
    }

    @Test
    void testSetDescriptionCorto() {
        int respuesta = operation.setDescription("b");
        assertEquals(-2,respuesta);
    }
    @Test
    void testSetDescriptionVacio() {
        int respuesta = operation.setDescription("");
        assertEquals(-2,respuesta);
    }
    
    @Test
    void testGetReference() {
        assertEquals(13, operation.getReference());
    }
    
    @Test
    void testSetReference() {
        int respuesta = operation.setReference(6);
        assertEquals(0,respuesta);
    }
    @Test
    void testSetReferenceSave() {
        operation.setReference(6);
        assertEquals(6,operation.getReference());
    }
    @Test
    void testSetReferenceZero() {
        int respuesta = operation.setReference(0);
        assertEquals(-3,respuesta);
    }
    @Test
    void testSetReferenceNegative() {
        int respuesta = operation.setReference(-10);
        assertEquals(-3,respuesta);
    }

    @Test
    void testGetInitDate() {
        assertEquals("2000/12/20-08:20:45", operation.getInitDate());
    }

    @Test
    void testSetInitDate() {
        int Respuesta=operation.setInitDate("2001/12/24-09:20:45");
        assertEquals(0,Respuesta);
    }
        void testSetInitDateSave() {
        operation.setInitDate("2001/12/24-09:20:45");
        assertEquals("2001/12/24-09:20:45",operation.getInitDate());
    }

    @Test
    void testGetFinishDate() {
        assertEquals("2000/12/24-09:20:45", operation.getFinishDate());
    }
    
    @Test
    void testSetFinishDateSave() {
        operation.setFinishDate("2000/12/24-09:20:45");
        assertEquals("2000/12/24-09:20:45", operation.getFinishDate());
    }

    @Test
    void testSetFinishDate() {
        int Respuesta = operation.setFinishDate("2000/12/24-09:20:45");
        assertEquals(0, Respuesta);
    }

    @Test
    void testGetDetails() {
        assertEquals("OperationOne: Referencia: 13, Descripció: Javava, Data de començament: 2000-12-20T08:20:45, Data final2000-12-24T09:20:45", operation.getDetails());
    }
}
