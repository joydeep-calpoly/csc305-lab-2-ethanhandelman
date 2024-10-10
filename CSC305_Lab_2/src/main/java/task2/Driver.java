package main.java.task2;

import java.util.ArrayList;
import java.util.List;


class Driver {

    Driver(){

    }

    public static void main(String[] args) {
        String[] files = {"input1.json", "input2.json", "input3.json"};
        List<Person> personsJackson = new ArrayList<>();

        for(String file : files){
            try {
                personsJackson.add(JSONParserJackson.parseJSONJackson(file));
            } catch (Exception ex){
                ex.printStackTrace();
            }
        }

        System.out.println("Persons automatically parsed using Jackson libraries:\n");
        for(Person p : personsJackson){
            System.out.println(p + "\n");
        }
    }
}
