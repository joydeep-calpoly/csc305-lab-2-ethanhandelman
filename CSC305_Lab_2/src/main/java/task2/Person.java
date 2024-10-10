package main.java.task2;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

class Person {
    private final List<Award> awards;
    private final List<String> knownFor;
    private final String name;

    Person(@JsonProperty("name") String name, @JsonProperty("awards") List<Award> awards, @JsonProperty("knownFor") List<String> knownFor){
        this.name = name;
        this.awards = Collections.unmodifiableList(awards);
        this.knownFor = Collections.unmodifiableList(knownFor);
    }

    private List<String> getAwardsAsStringList(){
        return Collections.unmodifiableList(awards.stream()
                .map(Award::toString).collect(Collectors.toList()));
    }

    @Override
    public String toString() {
        return name + "\n\nKnown For:\n\t"
                + String.join("\n\t", knownFor) +
                "\n\nAwards:\n\t" +
                String.join("\n\t", getAwardsAsStringList());
    }
}