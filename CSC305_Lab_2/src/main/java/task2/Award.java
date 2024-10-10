package main.java.task2;

import com.fasterxml.jackson.annotation.JsonProperty;

class Award {
    private final String name;
    private final Integer year;

    Award(@JsonProperty("name") String name, @JsonProperty("year") Integer year){
        this.name = name;
        this.year = year;
    }

    @Override
    public String toString(){
        return name + ", " + year;
    }
}