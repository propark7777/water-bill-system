package com.nhnacademy.edu.springframework.parser;

import static org.assertj.core.api.Assertions.assertThat;

import com.nhnacademy.edu.springframework.config.AppConfig;
import java.io.IOException;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class )
@ContextConfiguration(classes = {AppConfig.class})
class JsonDataParserTest {
    @Autowired
    DataParser jsonDataParser;

    @DisplayName("JSON 파일 읽어 오는지 확인")
    @Test
    void parseData() throws IOException, ParseException {
        assertThat(jsonDataParser.parseData("json").get(0).get(0)).isEqualTo("1");
        assertThat(jsonDataParser.parseData("json").get(0).get(1)).isEqualTo("동두천시");
        assertThat(jsonDataParser.parseData("json").get(0).get(2)).isEqualTo("가정용");
        assertThat(jsonDataParser.parseData("json").get(0).get(3)).isEqualTo("1");
        assertThat(jsonDataParser.parseData("json").get(0).get(4)).isEqualTo("1");
        assertThat(jsonDataParser.parseData("json").get(0).get(5)).isEqualTo("20");
        assertThat(jsonDataParser.parseData("json").get(0).get(6)).isEqualTo("690");
    }
}