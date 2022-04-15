package com.nhnacademy.edu.springframework.repository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DefaultTariffRepository implements TariffRepository {
    public static void main(String[] args) throws IOException {
        DefaultTariffRepository d = new DefaultTariffRepository();
        d.load();
        System.out.println(d.findTariffByUsage(1000));
    }
    private final List<Tariff> tariffs = new ArrayList<>();

    @Override
    public boolean load() throws IOException {
        String line;
        try(BufferedReader br = new BufferedReader(
            new InputStreamReader(
                getClass().getClassLoader().getResourceAsStream("data/Tariff_20220331.csv")))) {
            List<String> csv = new ArrayList<>();
            List<List<String>> list = new ArrayList<>();

            while ((line = br.readLine()) != null ) {
                String regex = ",";
                int limit = -1;
                String[] column = line.split(regex, limit);
                if ( line.equals("") ) {
                    line = " ";
                }
                csv = Arrays.asList(column);
                list.add(csv);

            }
            System.out.println(list);
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
        }
        System.out.println(tariffs.get(0));
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
