package com.nhnacademy.edu.springframework.parser;

import static org.assertj.core.api.Assertions.assertThat;

import com.nhnacademy.edu.springframework.config.AppConfig;
import java.io.IOException;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class )
@ContextConfiguration(classes = {AppConfig.class})
class CSVDataParserTest {

    @Autowired
    DataParser csvDataParser;

    @BeforeEach
    void setUp() {

    }

    @DisplayName("csv 파일을 읽어오는지 확인")
    @Test
    void load() throws IOException, ParseException {

        assertThat(csvDataParser.parseData("csv").get(0).get(0)).isEqualTo("1");
        assertThat(csvDataParser.parseData("csv").get(0).get(1)).isEqualTo(" 동두천시 ");
        assertThat(csvDataParser.parseData("csv").get(0).get(2)).isEqualTo(" 가정용 ");
        assertThat(csvDataParser.parseData("csv").get(0).get(3)).isEqualTo("1");
        assertThat(csvDataParser.parseData("csv").get(0).get(4)).isEqualTo("1");
        assertThat(csvDataParser.parseData("csv").get(0).get(5)).isEqualTo("20");
        assertThat(csvDataParser.parseData("csv").get(0).get(6)).isEqualTo("690");
        assertThat(csvDataParser.parseData("csv").get(0).get(7)).isEmpty();

    }
}