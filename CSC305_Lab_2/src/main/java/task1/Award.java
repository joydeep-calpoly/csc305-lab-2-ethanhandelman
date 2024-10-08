package main.java.task1;

public class Award {
    private String name;
    private Integer year;

    public Award(String name, Integer year){
        this.name = name;
        this.year = year;
    }

    public Award(){};

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String toString(){
        return name + ", " + year;
    }
}