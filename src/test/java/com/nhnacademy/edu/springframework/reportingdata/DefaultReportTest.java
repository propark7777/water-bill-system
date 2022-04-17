package com.nhnacademy.edu.springframework.reportingdata;

import com.nhnacademy.edu.springframework.config.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class )
@ContextConfiguration(classes = {AppConfig.class})
class DefaultReportTest {
    @Autowired
    Report defaultReport;

    @DisplayName("데이터 뽑아오기")
    @Test
    void reportResult() {

    }
}