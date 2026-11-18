package com.mycompany.matressgui;

public class ProductCalculations implements IProductCalculations {

    // Rates used in the calculations
    private static final double VAT_RATE = 0.15;        // 15%
    private static final double COMMISSION_RATE = 0.05; // 5%

    private final double price;

    // Stores the price passed in when the object is created
    public ProductCalculations(double price) {
        this.price = price;
    }

    @Override
    public double GetVat() {
        return price * VAT_RATE;
    }

    @Override
    public double GetCommission() {
        return price * COMMISSION_RATE;
    }

    // Total = price + VAT + commission
    @Override
    public double GetTotal() {
        return price + GetVat() + GetCommission();
    }
}