package com.nhnacademy.edu.springframework;

import com.nhnacademy.edu.springframework.reportingdata.Report;
import com.nhnacademy.edu.springframework.repository.TariffRepository;
import java.io.IOException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.json.simple.parser.ParseException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BootStrap {
    private static final Log log = LogFactory.getLog(BootStrap.class);
    public static void main(String[] args) throws IOException, ParseException {
        log.warn("BootStrap Start!!!");
        AnnotationConfigApplicationContext context =
            new AnnotationConfigApplicationContext("com.nhnacademy.edu.springframework");
        TariffRepository tariffRepository =
            context.getBean("defaultTariffRepository", TariffRepository.class);

        tariffRepository.load("json");

        Report report = context.getBean("defaultReport", Report.class);
        report.reportResult();
        report.reportResult();
        report.reportResult();
    }
}
