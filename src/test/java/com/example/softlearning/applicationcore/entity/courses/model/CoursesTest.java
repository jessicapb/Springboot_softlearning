package com.example.softlearning.applicationcore.entity.courses.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.softlearning.applicationcore.entity.sharedkernel.model.exceptions.BuildException;

public class CoursesTest {
    private Courses course;

    @BeforeEach
    public void setUp() throws Exception{
        course = Courses.getInstanceCourses(1313, 23.45, "Javava", 234, "M12");
    }

    // GetInstance Correcta
    @Test
    void testGetInstanceCourses() {
        try {
            course = Courses.getInstanceCourses(1313, 23.45, "Javava", 234, "M12");
            assertNotNull(course);
        } catch (BuildException e) {
            fail();
        }
    }
    
    // GetInstance Incorrecta
    @Test
    void testBadGetInstanceCourses() {
        try {
            course = Courses.getInstanceCourses(-1, -1, "J", -234, "M");
            fail();
        } catch (BuildException e) {
            assertEquals("No pot ser negatiu o 0, No pot ser negatiu o 0, El camp ha de ser més llarg, No pot ser negatiu o 0, El camp ha de ser més llarg, ", e.getMessage());
        }
    }

    // GetInstance Incorrecta Codi
    @Test
    void testBadGetInstanceCoursesCode() {
        try {
            course = Courses.getInstanceCourses(-1313, 23.45, "Javava", 234, "M12");
            fail();
        } catch (BuildException e) {
            assertEquals("No pot ser negatiu o 0, ", e.getMessage());
        }
    }

    @Test
    void testGetDepartment() {

    }

    @Test
    void testGetDetails() {

    }

    @Test
    void testGetHours() {

    }



    @Test
    void testGetPassword() {

    }

    @Test
    void testSetDepartment() {

    }

    @Test
    void testSetHours() {

    }

    @Test
    void testSetPassword() {

    }
}
