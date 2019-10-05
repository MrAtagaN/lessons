package patterns.behavior;

public class Template_ {

    public static void main(String[] args) {
        GameTemplate gameTemplate = new GameTemplate();
        gameTemplate.execute();

    }

    /**
     * Шаблонные действия вынесены в абстрактный класс
     */
    private static abstract class Template {

        abstract void stepOne();

        abstract void stepTwo();

        abstract void stepTree();

        public void execute() {
            System.out.println("Template method");
            stepOne();
            System.out.println("...");
            stepTwo();
            System.out.println("...");
            stepTree();
        }
    }

    /**
     * Имплементация методов
     */
    private static class GameTemplate extends Template {

        public void stepOne() {
            System.out.println("step one");
        }

        public void stepTwo() {
            System.out.println("step two");
        }

        public void stepTree() {
            System.out.println("step tree");
        }
    }


}
