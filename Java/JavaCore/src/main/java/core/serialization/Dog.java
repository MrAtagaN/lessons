package core.serialization;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Dog extends Animal implements Serializable {

    private static final long serialVersionUID = 2443586659397303241L;
    private boolean houndDog;


    public Dog(boolean houndDog, int age, int weight) {
        super(age, weight);
        this.houndDog = houndDog;
    }

    private void readObject(ObjectInputStream inputStream) throws ClassNotFoundException, IOException {
        // perform the default de-serialization first
        inputStream.defaultReadObject();

        System.out.println("Custom deserialization");
    }

    private void writeObject(ObjectOutputStream outputStream) throws IOException {
        // perform the default serialization for all non-transient, non-static fields
        outputStream.defaultWriteObject();

        System.out.println("Custom serialization");
    }


    @Override
    public String toString() {
        return "Dog{" +
                "houndDog=" + houndDog +
                ", age=" + age +
                ", weight=" + weight +
                '}';
    }
}

