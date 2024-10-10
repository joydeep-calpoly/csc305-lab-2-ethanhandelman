package main.java.task1;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class Person {
    private final List<Award> awards;
    private final List<String> knownFor;
    private final String name;

    Person(String name, List<Award> awards, List<String> knownFor){
        this.name = name;
        this.awards = new ArrayList<>(awards);
        this.knownFor = new ArrayList<>(knownFor);
    }

    private List<String> getAwardsAsStringList(){
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