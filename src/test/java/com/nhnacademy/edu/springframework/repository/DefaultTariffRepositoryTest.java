package com.nhnacademy.edu.springframework.repository;

import static org.assertj.core.api.Assertions.assertThat;
import com.nhnacademy.edu.springframework.config.AppConfig;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {AppConfig.class})
class DefaultTariffRepositoryTest {
    @Autowired
    TariffRepository defaultTariffRepository;

    @BeforeEach
    void setUp() {
    }

    @Test
    void load() {
    }
    
    @DisplayName("사용량에 따른 요금표 찾기")
    @Test
    void findTariffByUsage() {
        assertThat(defaultTariffRepository.findTariffByUsage(1000)).isInstanceOf(List.class);
    }
}