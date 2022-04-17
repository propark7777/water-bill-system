package com.nhnacademy.edu.springframework.repository;

import java.io.IOException;
import java.util.List;
import org.json.simple.parser.ParseException;

public interface TariffRepository {
    boolean load(String extensionName) throws IOException, ParseException;

    List<Tariff> findTariffByUsage(int usage);
}
