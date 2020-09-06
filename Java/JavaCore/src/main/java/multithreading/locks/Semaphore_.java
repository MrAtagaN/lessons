package multithreading.locks;

import java.util.concurrent.Semaphore;


public class Semaphore_ {

    public static void main(String[] args) {
        Semaphore table = new Semaphore(2);

        Person person1 = new Person(table);
        Person person2 = new Person(table);
        Person person3 = new Person(table);
        Person person4 = new Person(table);
        Person person5 = new Person(table);

        person1.start();
        person2.start();
        person3.start();
        person4.start();
        person5.start();
    }

    static class Person extends Thread {
        private Semaphore table;

        public Person(Semaphore table) {
            this.table = table;
        }

        @Override
        public void run() {
            System.out.println(this.getName() + " Waiting table");
            try {
                table.acquire();
                System.out.println(this.getName() + " Eat at the table");
                Thread.sleep(1000);
                System.out.println(this.getName() + " Release table");
                table.release();
            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
