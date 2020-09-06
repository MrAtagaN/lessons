package core.serialization;


import java.io.Serializable;

public class Animal implements Serializable {


    private static final long serialVersionUID = -3124050047556606386L;

    protected int age;
    protected int weight;

    public Animal(int age, int weight) {
        this.age = age;
        this.weight = weight;
    }

    public int getAge() {
        return age;
    }

    public int getWeight() {
        return weight;
    }
}
