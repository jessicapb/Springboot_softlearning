package com.example.softlearning.applicationcore.entity.sharedkernel.model.physics;

import com.example.softlearning.applicationcore.entity.sharedkernel.domainservices.validations.Check;
import com.example.softlearning.applicationcore.entity.sharedkernel.model.exceptions.BuildException;

public class PhysicalData {
    protected double high; //altura
    protected double width; //amplada
    protected double length; //longitud
    protected double weight; //pes
    protected boolean fragil; //fragil
    protected double depth; //profunditat
    protected double volume; //volum ho calcula la clase

    protected PhysicalData(){
    }

    public static PhysicalData getInstancePhysical(double high, double width, double length, double weight, boolean fragil, double depth) throws BuildException{
        String message = "";
        PhysicalData p = new PhysicalData();
        int error = 0;

        if((error = p.setHigh(high)) !=0){
            message += Check.getErrorMessage(error);
        }
        
        if((error = p.setWidth(width)) !=0){
            
            message += Check.getErrorMessage(error);
        }

        if((error = p.setLength(length)) !=0){
            message += Check.getErrorMessage(error);
        }

        if((error = p.setWeight(weight)) !=0){
            message += Check.getErrorMessage(error);
        }

        if((error = p.setFragil(fragil)) !=0){
            message += Check.getErrorMessage(error);
        }

        if((error = p.setDepth(depth)) !=0){
            message += Check.getErrorMessage(error);
        }

        if(message.length()>0){
            p = null;
            throw new BuildException(message);
        }
        return p;
    }

    public double getHigh() {
        return high;
    }

    public int setHigh(double high) {
        if(Check.isNegatived(high) !=0){
            return -3;
        }
        this.high = high;
        return 0;
    }

    public double getWidth() {
        return width;
    }

    public int setWidth(double width) {
        if(Check.isNegatived(width) !=0){
            return -3;
        }
        this.width = width;
        return 0;
    }

    public double getLength() {
        return length;
    }

    public int setLength(double length) {
        if(Check.isNegatived(length) !=0){
            return -3;
        }
        this.length = length;
        return 0;
    }

    public double getWeight() {
        return weight;
    }

    public int setWeight(double weight) {
        if(Check.isNegatived(weight) !=0){
            return -3;
        }
        this.weight = weight;
        return 0;
    }

    public double getVolume(){
        this.volume = this.length * this.width * this.high;
        return this.volume;
    }
    
    public static int getCalcularVolum(int length, int width, int high){
        int volume;
        volume = length*width*high;
        return volume;
    }

    public boolean getFragil() {
        return fragil;
    }

    public int setFragil(boolean fragil) {
        this.fragil = fragil;
        return 0;
    }

    public double getDepth() {
        return depth;
    }

    public int setDepth(double depth) {
        if(Check.isNegatived(depth) !=0){
            return -3;
        }
        this.depth = depth;
        return 0;
    }
}