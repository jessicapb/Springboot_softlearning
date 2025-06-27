package com.example.softlearning.applicationcore.entity.sharedkernel.domainservices.validations;

public class Check {
    //Buit set
    public static Boolean isNull(String s){
        return s == null ? true:false;
    }

    //Longitud del set
    public static int minLenght(String cadena, int longitud){
        if(cadena.trim().length() < longitud){
            return -1;
        }
        return 0;
    }

    //Negatiu set
    public static int isNegative (int n){
        if(n <= 0){
            return -3;
        }else{
            return 0;
        }
    }

    public static int isNegatived (double s){
        if(s <= 0){
            return -3;
        }else{
            return 0;
        }
    }

    //Identificador dels set (errors) dels fitxers del Stakeholders o Product
    public static String getErrorMessage(int e){
        switch (e) {
            case 0: return "Done, ";
            case -1: return "El camp està buit, ";
            case -2: return "El camp ha de ser més llarg, ";
            case -3: return "No pot ser negatiu o 0, ";
            default: return "Unknown error, ";
        }
    }
}
