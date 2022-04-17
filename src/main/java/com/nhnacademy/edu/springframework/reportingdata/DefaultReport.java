package com.nhnacademy.edu.springframework.reportingdata;

import com.nhnacademy.edu.springframework.repository.WaterBill;
import com.nhnacademy.edu.springframework.service.WaterBillService;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;

public class DefaultReport implements Report{

    private final WaterBillService waterBillService;

    @Autowired
    public DefaultReport(WaterBillService waterBillService) {
        this.waterBillService = waterBillService;
    }

    @Override
    public List<WaterBill> reportResult() {
        Scanner scanner = new Scanner(System.in);
        int inputWaterUsage = scanner.nextInt();

        return waterBillService.calculateFee(inputWaterUsage)
            .stream().sorted(Comparator.comparingLong(WaterBill::getUnitPrice))
            .limit(5)
            .collect(Collectors.toList());
    }
}
