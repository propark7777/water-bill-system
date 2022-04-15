package com.nhnacademy.edu.springframework.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DefaultTariffRepositoryTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void load() {
    }
    
    @DisplayName("사용량에 따른 요금표 찾기")
    @Test
    void findTariffByUsage() {
        TariffRepository dt = mock(DefaultTariffRepository.class);
        assertThat(dt.findTariffByUsage(1000)).isInstanceOf(List.class);
        verify(dt,times(1)).findTariffByUsage(1000);
    }
}