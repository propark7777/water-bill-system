package com.nhnacademy.edu.springframework.repository;

import com.nhnacademy.edu.springframework.parser.DataParser;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

public class DefaultTariffRepository implements TariffRepository {
    private DataParser dataParser;
    private final List<Tariff> tariffs = new ArrayList<>();

    @Autowired
    public DefaultTariffRepository(DataParser dataParser) {
        this.dataParser = dataParser;
    }

    @Override
    public boolean load() throws IOException {
        List<List<String>> list = dataParser.parseData();

            for (int i =1; i< list.size();i++){
                int seq = Integer.parseInt(list.get(i).get(0));
                String city = list.get(i).get(1);
                String usingSector = list.get(i).get(2);
                int stage = Integer.parseInt(list.get(i).get(3));
                int startSection = Integer.parseInt(list.get(i).get(4));
                int endSection = Integer.parseInt(list.get(i).get(5));
                long unitPrice = Long.parseLong(list.get(i).get(6));
                tariffs.add(
                    new Tariff(seq,city,usingSector,stage,
                        startSection,endSection,unitPrice));
            }
        return true;
    }

    @Override
    public List<Tariff> findTariffByUsage(int usage) {
        List<Tariff> rtTariff = new ArrayList<>();
        for (Tariff t : tariffs){
            if(usage >= t.getStartSection() && usage < t.getEndSection()){
                rtTariff.add(t);
            }
        }
        return rtTariff;
    }
}
