package multithreading;

public class ThreadLocal_ {

    private static ThreadLocal<String> threadLocal = new ThreadLocal<>();

    public static void main(String[] args) throws InterruptedException {
        threadLocal.set("Hello World");
        Thread threadOne = new ThreadOne();
        threadOne.start();
        Thread threadTwo = new ThreadTwo();
        threadTwo.start();

        threadOne.join();
        threadTwo.join();

        System.out.println("Main thread threadLocal: " + threadLocal.get());
    }

    static class ThreadOne extends Thread {
        @Override
        public void run() {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("ThreadOne threadLocal: "+ threadLocal.get());
        }
    }

    static class ThreadTwo extends Thread {
        @Override
        public void run() {
            System.out.println("ThreadTwo threadLocal: " + threadLocal.get());
        }
    }
}
