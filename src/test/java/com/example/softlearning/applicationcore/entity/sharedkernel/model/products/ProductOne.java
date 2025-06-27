package com.example.softlearning.applicationcore.entity.sharedkernel.model.products;

public class ProductOne extends Product{
    @Override
    public String getDetails() {
        return "PRODUCTONE: Codi: " + code + ", Preu: " + price + ", Descripció: " + description + "";
    }
}
