package com.nhnacademy.edu.springframework.parser;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonDataParser implements DataParser{

    @Override
    public List<List<String>> parseData(String extensionName) throws IOException, ParseException {
        Reader reader = new InputStreamReader(getClass().getClassLoader().getResourceAsStream("data/Tariff_20220331."+extensionName));
        JSONParser parser = new JSONParser();
        Object obj = parser.parse(reader);
        JSONArray jsonArray = (JSONArray)obj;

        List<List<String>> list = new ArrayList<>();
        if (!jsonArray.isEmpty() ){
            for (int i = 0; i < jsonArray.size(); i++) {
                List<String> data = new ArrayList<>();
                JSONObject jsonObject = (JSONObject) jsonArray.get(i);
                data.add(jsonObject.get("순번").toString());
                data.add(jsonObject.get("지자체명").toString());
                data.add(jsonObject.get("업종").toString());
                data.add(jsonObject.get("단계").toString());
                data.add(jsonObject.get("구간시작(세제곱미터)").toString());
                data.add(jsonObject.get("구간끝(세제곱미터)").toString());
                data.add(jsonObject.get("구간금액(원)").toString());
                list.add(data);
            }
        }
        return list;
    }

}
