package com.nhnacademy.edu.springframework.config;

import com.nhnacademy.edu.springframework.reportingdata.DefaultReport;
import com.nhnacademy.edu.springframework.reportingdata.Report;
import com.nhnacademy.edu.springframework.repository.DefaultTariffRepository;
import com.nhnacademy.edu.springframework.repository.TariffRepository;
import com.nhnacademy.edu.springframework.service.DefaultWaterBillService;
import com.nhnacademy.edu.springframework.service.WaterBillService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
public class AppConfig {

    @Bean
    public TariffRepository defaultTariffRepository(){
        return new DefaultTariffRepository();
    }

    @Bean
    public WaterBillService defaultWaterBillService(TariffRepository defaultTariffRepository){
        return new DefaultWaterBillService(defaultTariffRepository);
    }

    @Bean
    public Report defaultReport(WaterBillService defaultWaterBillService){
        return new DefaultReport(defaultWaterBillService);
    }
}
