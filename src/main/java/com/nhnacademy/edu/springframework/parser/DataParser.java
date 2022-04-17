package com.nhnacademy.edu.springframework.parser;

import java.io.IOException;
import java.util.List;
import org.json.simple.parser.ParseException;

public interface DataParser {
    List<List<String>> parseData(String extensionName) throws IOException, ParseException;
}
