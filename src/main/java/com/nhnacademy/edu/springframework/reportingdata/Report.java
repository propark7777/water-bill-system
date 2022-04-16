package com.nhnacademy.edu.springframework.reportingdata;

import com.nhnacademy.edu.springframework.repository.WaterBill;
import java.util.List;

public interface Report {
    List<WaterBill> reportResult();
}
