package main.java.task1;

import java.util.ArrayList;
import java.util.List;

import static main.java.task1.JSONParser.parseJSONManual;

class Driver {

    Driver(){

    }
    public static void main(String[] args) {
        String[] files = {"input1.json", "input2.json", "input3.json"};
        List<Person> personsManual = new ArrayList<>();

        for(String file : files){
            try {
                personsManual.add(parseJSONManual(file));
            } catch (Exception ex){
                ex.printStackTrace();
            }
        }

        System.out.println("Persons manually parsed using org.json:\n");
        for(Person p : personsManual){
            System.out.println(p + "\n");
        }
    }
}
