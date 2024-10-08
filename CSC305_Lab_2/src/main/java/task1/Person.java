package main.java.task1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Person {
    private List<Award> awards;
    private List<String> knownFor;
    private String name;

    public Person(String name){
        this.name = name;
        awards = new ArrayList<>();
        knownFor = new ArrayList<>();
    }

    public Person(){
        this.name = "";
        awards = new ArrayList<>();
        knownFor = new ArrayList<>();
    }

    public void setName(String name){
        this.name = name;
    }

    public void addAward(Award a){
        awards.add(a);
    }

    public void addKnownFor(String s){
        knownFor.add(s);
    }

    public List<Award> getAwards(){
        return Collections.unmodifiableList(awards);
    }

    public List<String> getKnownFor(){
        return knownFor;
    }

    public List<String> getAwardsAsStringList(){
        return awards.stream()
                .map(Award::toString).collect(Collectors.toList());

    }

    @Override
    public String toString() {
        return name + "\n\nKnown For:\n\t"
                + String.join("\n\t", knownFor) +
                "\n\nAwards:\n\t" +
                String.join("\n\t", getAwardsAsStringList());
    }
}