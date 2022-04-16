package com.nhnacademy.edu.springframework;

import com.nhnacademy.edu.springframework.reportingdata.DefaultReport;
import com.nhnacademy.edu.springframework.reportingdata.Report;
import com.nhnacademy.edu.springframework.repository.TariffRepository;
import com.nhnacademy.edu.springframework.repository.WaterBill;
import com.nhnacademy.edu.springframework.service.WaterBillService;
import java.io.IOException;
import java.util.List;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BootStrap {
    public static void main(String[] args) throws IOException {
        AnnotationConfigApplicationContext context =
            new AnnotationConfigApplicationContext("com.nhnacademy.edu.springframework");
        TariffRepository tariffRepository =
            context.getBean("defaultTariffRepository", TariffRepository.class);

        tariffRepository.load();

          WaterBillService waterBillService =
              context.getBean("defaultWaterBillService", WaterBillService.class);

        Report report = context.getBean("defaultReport", Report.class);
        report.reportResult();
        report.reportResult();
        report.reportResult();
    }
}
