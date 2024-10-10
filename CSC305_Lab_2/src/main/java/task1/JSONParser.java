package main.java.task1;
import org.json.*;

import java.nio.charset.StandardCharsets;
import java.util.*;
import java.io.*;
import org.apache.commons.io.IOUtils;

class JSONParser {

    //private constructor to ensure no outer classes can create the object
    JSONParser(){

    }

    static Person parseJSONManual(String fileName) throws JSONException, IOException{
        FileInputStream is = new FileInputStream(fileName);
        String jsonTxt = IOUtils.toString(is, StandardCharsets.UTF_8);
        //System.out.println(jsonTxt);

        JSONObject json = new JSONObject(jsonTxt);

        JSONArray jsonAwards = json.getJSONArray("awards");
        List<Award> awards = new ArrayList<>();

        for(int i = 0; i < jsonAwards.length(); i++){
            JSONObject current = jsonAwards.getJSONObject(i);
            awards.add(new Award(current.getString("name"), current.getInt("year")));
        }

        JSONArray jsonKnowns = json.getJSONArray("knownFor");
        List<String> knowns = new ArrayList<>();

        for(int i = 0; i < jsonKnowns.length(); i++){
            knowns.add(jsonKnowns.getString(i));
        }

        return new Person(json.getString("name"), awards, knowns);
    }

}
