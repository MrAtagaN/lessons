package patterns.structural;

/**
 * https://refactoring.guru/ru/design-patterns/bridge
 */
public class Bridge {

    public static void main(String[] args) {
        Shape redSquare = new Square(new RedColor());
        redSquare.draw();

        Shape blueSquare = new Square(new BlueColor());
        blueSquare.draw();

        Shape redTriangle = new Triangle(new RedColor());
        redTriangle.draw();

    }


    interface Shape {
        void draw();
    }

    /**
     * Класс в терминеах паттерна - Абстракция
     */
    static class Square implements Shape {
        private Color color;

        public Square(Color color) {
            this.color = color;
        }

        public void draw() {
            System.out.println("Draw "+ color.getValue() + " Square");
        }
    }

    /**
     * Класс в терминеах паттерна - Абстракция
     */
    static class Triangle implements Shape {
        private Color color;

        public Triangle(Color color) {
            this.color = color;
        }

        public void draw() {
            System.out.println("Draw "+ color.getValue() + " Triangle");
        }
    }


    interface Color {
        String getValue();
    }


    /**
     * Класс в терминеах паттерна - Реализация
     */
    static class RedColor implements Color {
        private final String color = "RED";

        public String getValue() {
            return color;
        }
    }

    /**
     * Класс в терминеах паттерна - Реализация
     */
    static class BlueColor implements Color {
        private final String color = "BLUE";

        public String getValue() {
            return color;
        }
    }
}
