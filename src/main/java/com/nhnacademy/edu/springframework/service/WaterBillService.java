package com.nhnacademy.edu.springframework.service;

import com.nhnacademy.edu.springframework.repository.WaterBill;
import java.util.List;

public interface WaterBillService {
    List<WaterBill> calculateFee(int usage);
}
