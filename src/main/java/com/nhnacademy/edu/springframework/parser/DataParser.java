package com.nhnacademy.edu.springframework.parser;

import java.io.IOException;
import java.util.List;

public interface DataParser {
    List<List<String>> parseData() throws IOException;
}
