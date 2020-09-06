package core.serialization;

import java.io.*;

/**
 * {@link Serializable } - Стандартная сериализация
 * readObject - своя десериализация
 * writeObject - своя сериализация
 *
 * {@link Externalizable } - Своя сериализация
 */
public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Dog dog = new Dog(true, 5, 15);

        //записываем в файл
        FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\AtagaN\\Desktop\\testOutputSerialization.txt");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(dog);
        fileOutputStream.close();
        objectOutputStream.close();

        //считываем из файла
        FileInputStream fileInputStream = new FileInputStream("C:\\Users\\AtagaN\\Desktop\\testOutputSerialization.txt");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        Dog deserializedDog = (Dog) objectInputStream.readObject();
        objectInputStream.close();
        fileInputStream.close();

        System.out.println(deserializedDog);
    }
}
