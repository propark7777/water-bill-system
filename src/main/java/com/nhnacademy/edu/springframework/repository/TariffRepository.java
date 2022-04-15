package com.nhnacademy.edu.springframework.repository;

import java.io.IOException;
import java.util.List;

public interface TariffRepository {
    boolean load() throws IOException;

    List<Tariff> findTariffByUsage(int usage);
}
