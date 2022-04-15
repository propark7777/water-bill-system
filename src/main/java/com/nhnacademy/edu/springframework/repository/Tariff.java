package com.nhnacademy.edu.springframework.repository;

public class Tariff {
    private int seq;
    private String city;
    private String usingSector;
    private int stage;
    private int startSection;
    private int endSection;
    private long unitPrice;
    private long defaultCharge;

    public Tariff(int seq, String city, String usingSector, int stage, int startSection,
                  int endSection,
                  long unitPrice) {
        this.seq = seq;
        this.city = city;
        this.usingSector = usingSector;
        this.stage = stage;
        this.startSection = startSection;
        this.endSection = endSection;
        this.unitPrice = unitPrice;
        this.defaultCharge = 0L;
    }

    public int getSeq() {
        return seq;
    }

    public String getCity() {
        return city;
    }

    public String getUsingSector() {
        return usingSector;
    }

    public int getStage() {
        return stage;
    }

    public int getStartSection() {
        return startSection;
    }

    public int getEndSection() {
        return endSection;
    }

    public long getUnitPrice() {
        return unitPrice;
    }

    public long getDefaultCharge() {
        return defaultCharge;
    }

    @Override
    public String toString() {
        return "Tariff{" +
            "seq=" + seq +
            ", city='" + city + '\'' +
            ", usingSector='" + usingSector + '\'' +
            ", stage=" + stage +
            ", startSection=" + startSection +
            ", endSection=" + endSection +
            ", unitPrice=" + unitPrice +
            ", defaultCharge=" + defaultCharge +
            '}';
    }
}
