package main.java.task1;

class Award {
    private final String name;
    private final Integer year;

    Award(String name, Integer year){
        this.name = name;
        this.year = year;
    }

    @Override
    public String toString(){
        return name + ", " + year;
    }
}