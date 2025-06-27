package com.example.softlearning.applicationcore.entity.sharedkernel.domainservices.validations;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import com.example.softlearning.applicationcore.entity.sharedkernel.model.exceptions.GeneralDateTimeException;

public class DataCheck {
    public static int checkDNI(String dni) {
        if (dni == null || dni.trim().length() != 9) {
            return -1;
        }
        return 0;
    }
    
    public static int checkEmail (String em){
        if (em == null || em.trim().length() <= 20) {
            return -1;
        }
        return 0;
    }
    
    public static int checkString(String s, int min){
        if (s == null || s.trim().length() < min) {
            return -1;
        }
        return 0;
    }
    
    public static int checkNumber(int value, int min){
        if (value < min) {
            return -1;
        }
        return 0;
    }
    
    public static int checkNumber(double value, double min){
        if (value < min) {
            return -1;
        }
        return 0;
    }

    public static LocalDateTime convertStringToDateTime(String s, DateTimeFormatter formatter) throws GeneralDateTimeException {        
        try {
            return LocalDateTime.parse(s, formatter);
        } catch (NullPointerException e ) {
            throw new GeneralDateTimeException ("HEMOS RECIBIDO UN NULL EN LUGAR DE UNA FECHA");
        } catch (DateTimeParseException e) {
            throw new GeneralDateTimeException ("ERROR AL PARSEAR FECHA: " + e.getMessage());
        } catch (Exception e) {
            throw new GeneralDateTimeException ("ERROR INESPERADO: " + e);
        } 
    }
    
    public static LocalDate convertStringToDate(String s, DateTimeFormatter formatter) throws GeneralDateTimeException {        
        try {
            return LocalDate.parse(s, formatter);
        } catch (NullPointerException e ) {
            throw new GeneralDateTimeException ("HEMOS RECIBIDO UN NULL EN LUGAR DE UNA FECHA");
        } catch (DateTimeParseException e) {
            throw new GeneralDateTimeException ("ERROR AL PARSEAR FECHA: " + e.getMessage());
        } catch (Exception e) {
            throw new GeneralDateTimeException ("ERROR INESPERADO: " + e);
        } 
    }
}
