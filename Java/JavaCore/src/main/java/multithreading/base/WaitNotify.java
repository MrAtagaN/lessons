package multithreading.base;

/**
 * Нить засыпает в месте wait и снимает блокировку. Когда нить будят (notify) выполнение продолжается с места wait
 * wait и notify можно вызывать только в синхронизиронных блоках
 */
public class WaitNotify {

    public static void main(String[] args) {
        Job job = new Job();

        Thread thread = new Thread(new Driver(job));
        thread.setName("Первый водитель");
        thread.start();

        Thread thread2 = new Thread(new Driver(job));
        thread2.setName("Второй водитель");
        thread2.start();
    }

    static class Driver implements Runnable {

        private Job job;

        public Driver(Job job) {
            this.job = job;
        }


        @Override
        public void run() {
            try {
                job.drive();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class Job {
        synchronized void drive() throws InterruptedException {
            System.out.println(Thread.currentThread().getName() + " Поехал");
            Thread.sleep(1000);
            this.notify(); //второй разбудит первого
            this.wait();
            System.out.println(Thread.currentThread().getName() + " Остановился");
        }
    }


}
