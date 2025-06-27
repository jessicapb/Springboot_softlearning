package com.example.softlearning.applicationcore.entity.book.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.softlearning.applicationcore.entity.sharedkernel.model.exceptions.BuildException;

public class BooksTest {
    private Books b;
    
    @BeforeEach
    public void setUp() throws Exception {
        b = Books.getInstanceBooks(13, 45.67, "aafffs", "Autor", "Harry Potter", "Dura", 134, "Fantasia", "Santillana",
                "987500505", 12.45, 34.56, 34.32, 12.45, true, 12.4);
    }
    
    // GetInstance Correcta
    @Test
    void testGetInstanceBook() {
        try {
            Books b = Books.getInstanceBooks(13, 45.67, "aafffs", "Autor", "Harry Potter", "Dura", 134, "Fantasia",
                    "Santillana", "987500505", 12.45, 34.56, 34.32, 12.45, true, 12.4);
            assertNotNull(b);
        } catch (BuildException e) {
            fail();
        }
    }
    
    // GetInstance Incorrecta
    @Test
    void testBadGetInstanceBook() {
        try {
            Books b = Books.getInstanceBooks(0, 0, "", "", "", "", 0, "", "", "", 0, 0, 0, 0, false, 0);
            fail();
        } catch (BuildException e) {
            assertEquals(
                    "No pot ser negatiu o 0, No pot ser negatiu o 0, El camp ha de ser més llarg, No pot ser negatiu o 0, No pot ser negatiu o 0, No pot ser negatiu o 0, No pot ser negatiu o 0, No pot ser negatiu o 0, El camp ha de ser més llarg, El camp ha de ser més llarg, El camp ha de ser més llarg, No pot ser negatiu o 0, El camp ha de ser més llarg, El camp ha de ser més llarg, El camp ha de ser més llarg, ",
                    e.getMessage());
            System.out.println(e.getMessage());
        }
    }
    
    // GetInstance BadCode
    @Test
    void testGetInstanceBookBadCode() {
        try {
            Books b = Books.getInstanceBooks(0, 45.67, "aafffs", "Autor", "Harry Potter", "Dura", 134, "Fantasia",
                    "Santillana", "987500505", 12.45, 34.56, 34.32, 12.45, true, 12.40);
            fail();
        } catch (BuildException e) {
            assertEquals("No pot ser negatiu o 0, ", e.getMessage());
        }
    }
    
    // GetInstance BadPrice
    @Test
    void testGetInstanceBookBadPrice() {
        try {
            Books b = Books.getInstanceBooks(13, -45.67, "aafffs", "Autor", "Harry Potter", "Dura", 134, "Fantasia",
                    "Santillana", "987500505", 12.45, 34.56, 34.32, 12.45, true, 12.4);
            fail();
        } catch (BuildException e) {
            assertEquals("No pot ser negatiu o 0, ", e.getMessage());
        }
    }
    
    // GetInstance BadDescription
    @Test
    void testGetInstanceBookBadDescription() {
        try {
            Books b = Books.getInstanceBooks(13, 45.67, "     ", "Autor", "Harry Potter", "Dura", 134, "Fantasia",
                    "Santillana", "987500505", 12.45, 34.56, 34.32, 12.45, true, 12.4);
            fail();
        } catch (BuildException e) {
            assertEquals("El camp ha de ser més llarg, ", e.getMessage());
        }
    }
    
    // GetInstance BadAuthor
    @Test
    void testGetInstanceBookBadAuthor() {
        try {
            Books b = Books.getInstanceBooks(13, 45.67, "aafffs", "", "Harry Potter", "Dura", 134, "Fantasia",
                    "Santillana", "987500505", 12.45, 34.56, 34.32, 12.45, true, 12.4);
            fail();
        } catch (BuildException e) {
            assertEquals("El camp ha de ser més llarg, ", e.getMessage());
        }
    }
    
    // GetInstance BadTitle
    @Test
    void testGetInstanceBookBadTitle() {
        try {
            Books b = Books.getInstanceBooks(13, 45.67, "aafffs", "Autor", "H", "Dura", 134, "Fantasia", "Santillana",
                    "987500505", 12.45, 34.56, 34.32, 12.45, true, 12.4);
            fail();
        } catch (BuildException e) {
            assertEquals("El camp ha de ser més llarg, ", e.getMessage());
        }
    }
    
    // GetInstance BadCover
    @Test
    void testGetInstanceBookBadCover() {
        try {
            Books b = Books.getInstanceBooks(13, 45.67, "aafffs", "Autor", "Harry Potter", "", 134, "Fantasia",
                    "Santillana", "987500505", 12.45, 34.56, 34.32, 12.45, true, 12.4);
            fail();
        } catch (BuildException e) {
            assertEquals("El camp ha de ser més llarg, ", e.getMessage());
        }
    }
    
    // GetInstance BadPage
    @Test
    void testGetInstanceBookBadPage() {
        try {
            Books b = Books.getInstanceBooks(13, 45.67, "aafffs", "Autor", "Harry Potter", "Dura", -134, "Fantasia",
                    "Santillana", "987500505", 12.45, 34.56, 34.32, 12.45, true, 12.4);
            fail();
        } catch (BuildException e) {
            assertEquals("No pot ser negatiu o 0, ", e.getMessage());
        }
    }
    
    // GetInstance BadGender
    @Test
    void testGetInstanceBookBadGender() {
        try {
            Books b = Books.getInstanceBooks(13, 45.67, "aafffs", "Autor", "Harry Potter", "Dura", 134, "",
                    "Santillana", "987500505", 12.45, 34.56, 34.32, 12.45, true, 12.4);
            fail();
        } catch (BuildException e) {
            assertEquals("El camp ha de ser més llarg, ", e.getMessage());
        }
    }
    
    // GetInstance BadEditorial
    @Test
    void testGetInstanceBookBadEditorial() {
        try {
            Books b = Books.getInstanceBooks(13, 45.67, "aafffs", "Autor", "Harry Potter", "Dura", 134, "Fantasia", "S",
                    "987500505", 12.45, 34.56, 34.32, 12.45, true, 12.4);
            fail();
        } catch (BuildException e) {
            assertEquals("El camp ha de ser més llarg, ", e.getMessage());
        }
    }
    
    // GetInstance BadISBN
    @Test
    void testGetInstanceBookBadISBN() {
        try {
            Books b = Books.getInstanceBooks(13, 45.67, "aafffs", "Autor", "Harry Potter", "Dura", 134, "Fantasia",
                    "Santillana", "      ", 12.45, 34.56, 34.32, 12.45, true, 12.4);
            fail();
        } catch (BuildException e) {
            assertEquals("El camp ha de ser més llarg, ", e.getMessage());
        }
    }
    
    // GetInstance BadHigh
    @Test
    void testGetInstanceBookBadHigh() {
        try {
            Books b = Books.getInstanceBooks(13, 45.67, "aafffs", "Autor", "Harry Potter", "Dura", 134, "Fantasia",
                    "Santillana", "987500505", 0, 34.56, 34.32, 12.45, true, 12.4);
            fail();
        } catch (BuildException e) {
            assertEquals("No pot ser negatiu o 0, ", e.getMessage());
        }
    }
    
    // GetInstance BadWidth
    @Test
    void testGetInstanceBookBadWidth() {
        try {
            Books b = Books.getInstanceBooks(13, 45.67, "aafffs", "Autor", "Harry Potter", "Dura", 134, "Fantasia",
                    "Santillana", "987500505", 12.45, -34.56, 34.32, 12.45, true, 12.4);
            fail();
        } catch (BuildException e) {
            assertEquals("No pot ser negatiu o 0, ", e.getMessage());
        }
    }
    
    // GetInstance BadLength
    @Test
    void testGetInstanceBookBadLength() {
        try {
            Books b = Books.getInstanceBooks(13, 45.67, "aafffs", "Autor", "Harry Potter", "Dura", 134, "Fantasia",
                    "Santillana", "987500505", 12.45, 34.56, 0, 12.45, true, 12.4);
            fail();
        } catch (BuildException e) {
            assertEquals("No pot ser negatiu o 0, ", e.getMessage());
        }
    }
    
    // GetInstance BadWeight
    @Test
    void testGetInstanceBookBadWeight() {
        try {
            Books b = Books.getInstanceBooks(13, 45.67, "aafffs", "Autor", "Harry Potter", "Dura", 134, "Fantasia",
                    "Santillana", "987500505", 12.45, 34.56, 34.32, -12.45, true, 12.4);
            fail();
        } catch (BuildException e) {
            assertEquals("No pot ser negatiu o 0, ", e.getMessage());
        }
    }
    
    // GetInstance BadDepth
    @Test
    void testGetInstanceBookBadDepth() {
        try {
            Books b = Books.getInstanceBooks(13, 45.67, "aafffs", "Autor", "Harry Potter", "Dura", 134, "Fantasia",
                    "Santillana", "987500505", 12.45, 34.56, 34.32, 12.45, true, -12.4);
            fail();
        } catch (BuildException e) {
            assertEquals("No pot ser negatiu o 0, ", e.getMessage());
        }
    }
    
    // Comprovar el GetAuthor
    @Test
    void testGetAuthor() {
        assertEquals("Autor", b.getAuthor());
    }
    
    // Comprovar el SetAuthor
    @Test
    void testSetAuthor() {
        int Respuesta = b.setAuthor("Daniel");
        assertEquals(0, Respuesta);
    }
    
    @Test
    void testSetAuthorSave() {
        b.setAuthor("antonio pere reverte");
        assertEquals("antonio pere reverte", b.getAuthor());
    }
    
    @Test
    void testSetAuthorNull() {
        int Respuesta = b.setAuthor(null);
        assertEquals(-1, Respuesta);
    }
    
    @Test
    void testSetAuthorSpacesString() {
        int Respuesta = b.setAuthor("                            ");
        assertEquals(-2, Respuesta);
    }
    
    @Test
    void testSetAuthorBadMinLength() {
        int Respuesta = b.setAuthor("ik");
        assertEquals(-2, Respuesta);
    }
    
    // Comprovar el GetTitle
    @Test
    void testGetTitle() {
        assertEquals("Harry Potter", b.getTitle());
    }
    
    // Comprovar el SetTitle
    @Test
    void testSetTitleSave() {
        b.setTitle("El ritmo de la guerra");
        assertEquals("El ritmo de la guerra", b.getTitle());
    }
    
    @Test
    void testSetTitle() {
        int Resultado = b.setTitle("El ritmo de la guerra");
        assertEquals(0, Resultado);
    }
    
    @Test
    void testSetTitleNull() {
        int Resultado = b.setTitle(null);
        assertEquals(-1, Resultado);
    }
    
    @Test
    void testSetTitleSpaceString() {
        int Resultado = b.setTitle("                     ");
        assertEquals(-2, Resultado);
    }
    
    @Test
    void testSetTitleMinLength() {
        int Resultado = b.setTitle("h");
        assertEquals(-2, Resultado);
    }
    
    // Comprovar el GetCover
    @Test
    void testGetCover() {
        assertEquals("Dura", b.getCover());
    }
    
    // Comprovar el SetCover
    @Test
    void testSetCoverSave() {
        b.setCover("Blanda");
        assertEquals("Blanda", b.getCover());
    }
    
    @Test
    void testSetCover() {
        int respuesta = b.setCover(null);
        assertEquals(-1, respuesta);
    }
    
    @Test
    void testSetCoverNull() {
        int respuesta = b.setCover("Blanda");
        assertEquals(0, respuesta);
    }
    
    @Test
    void testSetCoverSpaceString() {
        int respuesta = b.setCover("                         ");
        assertEquals(-2, respuesta);
    }
    
    @Test
    void testSetCoverMinLength() {
        int respuesta = b.setCover("a");
        assertEquals(-2, respuesta);
    }
    
    // Comprovar el GetPage
    @Test
    void testGetPage() {
        assertEquals(134, b.getPage());
    }
    
    // Comprovar el SetPage
    @Test
    void testSetPageSave() {
        b.setPage(500);
        assertEquals(500, b.getPage());
    }
    
    @Test
    void testSetPage() {
        int Respuesta = b.setPage(500);
        assertEquals(0, Respuesta);
    }
    
    @Test
    void testSetPageZero() {
        int Respuesta = b.setPage(0);
        assertEquals(-3, Respuesta);
    }
    
    @Test
    void testSetPageNegative() {
        int Respuesta = b.setPage(-500);
        assertEquals(-3, Respuesta);
    }
    
    // Comprovar el GetGender
    @Test
    void testGetGender() {
        assertEquals("Fantasia", b.getGender());
    }
    
    // Comprovar el SetGender
    @Test
    void testSetGenderSave() {
        b.setGender("Historia");
        assertEquals("Historia", b.getGender());
    }
    
    @Test
    void testSetGender() {
        int respuesta = b.setGender("Historia");
        assertEquals(0, respuesta);
    }
    
    @Test
    void testSetGenderNull() {
        int respuesta = b.setGender(null);
        assertEquals(-1, respuesta);
    }
    
    @Test
    void testSetGenderStringSpaces() {
        int respuesta = b.setGender("               ");
        assertEquals(-2, respuesta);
    }
    
    @Test
    void testSetGenderMinLength() {
        int respuesta = b.setGender("j");
        assertEquals(-2, respuesta);
    }
    
    // Comprovar el GetEditorial
    @Test
    void testGetEditorial() {
        assertEquals("Santillana", b.getEditorial());
    }
    
    // Comprovar el SetEditorial
    @Test
    void testSetEditorialSave() {
        b.setEditorial("mi editorial");
        assertEquals("mi editorial", b.getEditorial());
    }
    
    @Test
    void testSetEditorial() {
        int respuesta = b.setEditorial("mi editorial");
        assertEquals(0, respuesta);
    }
    
    @Test
    void testSetEditorialNull() {
        int respuesta = b.setEditorial(null);
        assertEquals(-1, respuesta);
    }
    
    @Test
    void testSetEditorialSpaceString() {
        int respuesta = b.setEditorial("                   ");
        assertEquals(-2, respuesta);
    }
    
    @Test
    void testSetEditorialminLength() {
        int respuesta = b.setEditorial("j");
        assertEquals(-2, respuesta);
    }
    
    // Comprovar el GetISBN
    @Test
    void testGetISBN() {
        assertEquals("987500505", b.getISBN());
    }
    
    // Comprovar el SetISBN
    @Test
    void testSetISBNSave() {
        b.setISBN("987500506");
        assertEquals("987500506", b.getISBN());
    }
    
    @Test
    void testSetISBN() {
        int respuesta = b.setISBN("987500506");
        assertEquals(0, respuesta);
    }
    
    @Test
    void testSetISBNlNull() {
        int respuesta = b.setISBN(null);
        assertEquals(-1, respuesta);
    }
    
    @Test
    void testSetISBNlSpaceString() {
        int respuesta = b.setISBN("                    ");
        assertEquals(-2, respuesta);
    }
    
    @Test
    void testSetEditorialISBNlminLength() {
        int respuesta = b.setISBN("j");
        assertEquals(-2, respuesta);
    }
    
    // PhysicalData
    // Comprovar el GetCalcularVolume
    @Test
    void testGetCalcularVolume() {
        double result = b.getVolume();
        double delta = 0.0001;
        assertEquals(14766.93504, result, delta);
    }
    
    // Comprovar el GetDepth
    @Test
    void testGetDepth() {
        assertEquals(12.4, b.getDepth());
    }
    
    // Comprovar el setDepth
    @Test
    void setDepthZero() {
        assertEquals(-3, b.setDepth(0));
    }
    
    @Test
    void setDepthNegativo() {
        assertEquals(-3, b.setDepth(-6));
    }
    
    @Test
    void setDepthExito() {
        assertEquals(0, b.setDepth(17.76)); // Exito
    }
    
    @Test
    void setDepthSave() {
        b.setDepth(15.76);
        assertEquals(15.76, b.getDepth());
    }
    
    // Comprovar el GetFragil
    @Test
    void testGetFragil() {
        assertEquals(true,b.getFragil());
    }
    
    // Comprovar el SetFragil
    @Test
    void testSetFragil() {
        assertEquals(0,b.setFragil(false));
    }
    
    void testSetFragilSave() {
        b.setFragil(false);
        assertEquals(false,b.getFragil());
    }
    
    // Comprovar el GetHigh
    @Test
    void testGetHigh() {
        assertEquals(12.45, b.getHigh());
    }
    
    // Comprovar el SetHigh
    @Test
    void testSetHigh() {
        assertEquals(0,b.setHigh(16.57));
    }  
    
    @Test
    void testSetHighSave() {
        b.setHigh(17.89);
        assertEquals(17.89,b.getHigh());
    }
    
    @Test
    void testSetHighSaveZero() {
        assertEquals(-3, b.setHigh(0));
    }   
    
    @Test
    void setHighNegativo() {
        assertEquals(-3, b.setHigh(-6));
    }
    
    // Comprovar el GetLength
    @Test
    void testGetLength() {
        assertEquals(34.32, b.getLength());
    }
    
    // Comprovar el SetLength
    @Test
    void testSetLength() {
        assertEquals(0,b.setLength(13.57));
    }  
    
    @Test
    void testSetLengthSave() {
        b.setLength(34.32);
        assertEquals(34.32,b.getLength());
    }
    
    @Test
    void testSetLengthSaveZero() {
        assertEquals(-3, b.setLength(0));
    }   
    
    @Test
    void setLengthNegativo() {
        assertEquals(-3, b.setLength(-12));
    }
    
    // Comprovar el GetVolume
    @Test
    void testGetVolume() {
        double delta = 0.0001;
        assertEquals(14766.93504,b.getVolume(),delta);
    }
    
    // Comprovar el GetWeight
    @Test
    void testGetWeight() {
        assertEquals(12.45, b.getWeight());
    }
    
    // Comprovar el SetWeight
    @Test
    void testSetWeight() {
        assertEquals(0,b.setWeight(13.57));
    }  
    
    @Test
    void testSetWeightSave() {
        b.setWeight(100.32);
        assertEquals(100.32,b.getWeight());
    }
    
    @Test
    void testSetWeightSaveZero() {
        assertEquals(-3, b.setWeight(0));
    }   
    
    @Test
    void SetWeightNegativo() {
        assertEquals(-3, b.setWeight(-1));
    }
    
    // Comprovar el GetWeight
    @Test
    void testGetWidth() {
        assertEquals(34.56, b.getWidth());
    }
    
    // Comprovar el SetWidth
    @Test
    void testSetWidth() {
        assertEquals(0,b.setWidth(6.57));
    }  
    
    @Test
    void testSetWidthtSave() {
        b.setWidth(67.78);
        assertEquals(67.78,b.getWidth());
    }
    
    @Test
    void testSetWidthSaveZero() {
        assertEquals(-3, b.setWidth(0));
    }   
    
    @Test
    void SeWidthtNegativo() {
        assertEquals(-3, b.setWidth(-12.34));
    }
    
    // Comprovar GetDetails
    @Test
    void testgetDetails() {
        //LLIBRE: Codi producte: 13, Preu: 45.67, Descripció: aafffs, Autora: Autor, Títol: Harry Potter, Tapa: Dura, Pàgines: 134, Genere: Fantasia, Editorial: Santillana, ISBN: 987500505, Altura: 12.45, Amplada34.56, Longitud: 34.32, Pes: 12.45, Fràgil: true, Profunditat: 12.4
        assertEquals("LLIBRE: Codi producte: 13, Preu: 45.67, Descripció: aafffs, Autora: Autor, Títol: Harry Potter, Tapa: Dura, Pàgines: 134, Genere: Fantasia, Editorial: Santillana, ISBN: 987500505, Altura: 12.45, Amplada34.56, Longitud: 34.32, Pes: 12.45, Fràgil: true, Profunditat: 12.4",b.getDetails());
    }
}
