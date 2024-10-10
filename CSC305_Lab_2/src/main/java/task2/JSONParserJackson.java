package main.java.task2;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;

class JSONParserJackson {

    JSONParserJackson(){

    }

    public static Person parseJSONJackson(String filePath) throws IOException{
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(new File(filePath), Person.class);
    }
}
