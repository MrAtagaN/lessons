package core.serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Main {


    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Dog dog = new Dog(true, 5, 15);

        FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\AtagaN\\Desktop\\testOutputSerialization.txt");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(dog);
        fileOutputStream.close();
        objectOutputStream.close();


        FileInputStream fileInputStream = new FileInputStream("C:\\Users\\AtagaN\\Desktop\\testOutputSerialization.txt");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        Dog deserializedDog = (Dog) objectInputStream.readObject();
        objectInputStream.close();
        fileInputStream.close();

        System.out.println(deserializedDog);
    }
}
