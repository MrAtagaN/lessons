package multithreading;

import java.util.concurrent.Exchanger;

/**
 * Обмен данными между потоками
 */
public class Exchanger_ {

    public static void main(String[] args) throws InterruptedException {
        Exchanger<String> exchanger = new Exchanger<>();

        new Person("Max", exchanger).start();
        Thread.sleep(3000);
        new Person("Ann", exchanger).start();
    }


    static class Person extends Thread {

        private String name;
        private Exchanger<String> exchanger;

        public Person(String name, Exchanger<String> exchanger) {
            this.name = name;
            this.exchanger = exchanger;
        }

        @Override
        public void run() {
            System.out.println(this.name + " send message: " + "Hello this is " + this.name);
            try {
                String message =  exchanger.exchange("Hello this is " + this.name);
                System.out.println(this.name + " receive message: " + message);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
