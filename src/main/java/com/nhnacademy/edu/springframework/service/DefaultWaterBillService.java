package com.nhnacademy.edu.springframework.service;

import com.nhnacademy.edu.springframework.repository.Tariff;
import com.nhnacademy.edu.springframework.repository.TariffRepository;
import com.nhnacademy.edu.springframework.repository.WaterBill;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

public class DefaultWaterBillService implements WaterBillService{

    TariffRepository tariffRepository;

    @Autowired
    public DefaultWaterBillService(TariffRepository tariffRepository) {
        this.tariffRepository = tariffRepository;
    }

    @Override
    public List<WaterBill> calculateFee(int usage) {
        List<Tariff> tariffs = tariffRepository.findTariffByUsage(usage);
        List<WaterBill> waterBills = new ArrayList<>();
        for (Tariff t : tariffs){
            String city = t.getCity();
            String usingSector = t.getUsingSector();
            long unitPrice = t.getUnitPrice();
            long totalFee = unitPrice * usage;
            WaterBill waterBill = new WaterBill(city,usingSector,unitPrice,totalFee);
            waterBills.add(waterBill);
        }
        return waterBills;
    }
}
