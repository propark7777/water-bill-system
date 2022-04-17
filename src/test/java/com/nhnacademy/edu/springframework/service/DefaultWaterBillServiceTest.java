package com.nhnacademy.edu.springframework.service;

import static org.assertj.core.api.Assertions.assertThat;

import com.nhnacademy.edu.springframework.config.AppConfig;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {AppConfig.class})
class DefaultWaterBillServiceTest {
    @Autowired
    WaterBillService defaultWaterBillService;

    @BeforeEach
    void setUp() {
    }

    @Test
    void calculateFee() {
        assertThat(defaultWaterBillService.calculateFee(1000)).isInstanceOf(List.class);
    }
}