package com.example.softlearning.applicationcore.entity.sharedkernel.model.products;

public interface Storable {
    public double getHigh();
    public double getWidth();
    public double getLength();
    public double getWeight();
    public double getCalcularVolum();
    public boolean getFragil();
    public double getDepth();
    public int setHigh(double high);
    public int setLength(double length);
    public int setWidth(double width);
    public double getVolume();
    public int setFragil(boolean fragil);
    public int setDepth(double depth);
    public int setWeight(double weight);
}
