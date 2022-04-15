package com.nhnacademy.edu.springframework.repository;

public class WaterBill {
    private String city;
    private String usingSector;
    private long unitPrice;
    private long totalFee;

    public WaterBill(String city, String usingSector, long unitPrice, long totalFee) {
        this.city = city;
        this.usingSector = usingSector;
        this.unitPrice = unitPrice;
        this.totalFee = totalFee;
    }
}
