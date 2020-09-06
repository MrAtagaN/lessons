package patterns.creational;

public class Prototype {

    public static void main(String[] args) {

    }


    /**
     * Прототип клонирует себя
     */
    static class User implements Cloneable {

        @Override
        public User clone() throws CloneNotSupportedException {
            return (User) super.clone();
        }
    }


}
