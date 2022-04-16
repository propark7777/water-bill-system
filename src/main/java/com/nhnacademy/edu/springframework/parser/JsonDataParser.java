package com.nhnacademy.edu.springframework.parser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class JsonDataParser implements DataParser{
    public static void main(String[] args) throws IOException {
        JsonDataParser jp = new JsonDataParser();
        jp.parseData();
    }
    @Override
    public List<List<String>> parseData() throws IOException {
        String line;
        String result = "";
        try(BufferedReader br = new BufferedReader(
            new InputStreamReader(
                getClass().getClassLoader().getResourceAsStream("data/Tariff_20220331.json")))) {
            List<String> csv = new ArrayList<>();
            List<List<String>> list = new ArrayList<>();

            while ((line = br.readLine()) != null) {
                result = result.concat(line);
            }


            System.out.println(result);
            return list;
        }

    }
}
