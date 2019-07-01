package core.reflection;

public class Person extends Human {

    private String name = "AtagaN";
    private int age = 666;


    public Person() {
    }

    private Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    private String getName() {
        return name;
    }

    private int getAge() {
        return age;
    }

    private void printData() {
        System.out.println("Name is " + name + ", age is " + age);
    }
}
