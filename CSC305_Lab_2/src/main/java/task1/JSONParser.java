package main.java.task1;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.*;

import java.nio.charset.StandardCharsets;
import java.util.*;
import java.io.*;
import org.apache.commons.io.IOUtils;

public class JSONParser {
    public static Person parseJSONJackson(String filePath) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(new File(filePath), Person.class);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
    public static Person parseJSONManual(String fileName){
        Person p = new Person();
        try {
            FileInputStream is = new FileInputStream(fileName);
            String jsonTxt = IOUtils.toString(is, StandardCharsets.UTF_8);
            System.out.println(jsonTxt);

            JSONObject json = new JSONObject(jsonTxt);
            JSONArray jsonAwards = json.getJSONArray("awards");

            for(int i = 0; i < jsonAwards.length(); i++){
                JSONObject current = jsonAwards.getJSONObject(i);
                p.addAward(new Award(current.getString("name"), current.getInt("year")));
            }

            JSONArray jsonKnowns = json.getJSONArray("knownFor");

            for(int i = 0; i < jsonKnowns.length(); i++){
                p.addKnownFor(jsonKnowns.getString(i));
            }

            p.setName(json.getString("name"));
        } catch (Exception ex){
            ex.printStackTrace();
        }
        return p;
    }

    public static void main(String[] args) {
        String[] files = {"input1.json", "input2.json", "input3.json"};
        List<Person> personsManual = new ArrayList<>();
        List<Person> personsJackson = new ArrayList<>();

        for(String file : files){
            personsManual.add(parseJSONManual(file));
            personsJackson.add(parseJSONJackson(file));
        }

        System.out.println("Persons manually parsed using org.json:\n");
        for(Person p : personsManual){
            System.out.println(p);
            System.out.println();
        }

        System.out.println("Persons automatically parsed using Jackson libraries:\n");
        for(Person p : personsJackson){
            System.out.println(p);
            System.out.println();
        }
    }
}
