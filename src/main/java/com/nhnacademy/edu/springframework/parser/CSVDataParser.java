package com.nhnacademy.edu.springframework.parser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CSVDataParser implements DataParser {

    @Override
    public List<List<String>> parseData(String extensionName) throws IOException {
        String line;
        try(BufferedReader br = new BufferedReader(
            new InputStreamReader(
                getClass().getClassLoader().getResourceAsStream("data/Tariff_20220331."+extensionName)))) {
            List<String> csv = new ArrayList<>();
            List<List<String>> list = new ArrayList<>();
            while ((line = br.readLine()) != null) {
                String regex = ",";
                int limit = -1;
                String[] column = line.split(regex, limit);
                if (line.equals("")) {
                    line = " ";
                }
                csv = Arrays.asList(column);
                list.add(csv);
            }
            list.remove(0);

            return list;
        }
    }
}
