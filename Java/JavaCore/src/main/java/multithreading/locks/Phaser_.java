package multithreading.locks;

import java.util.concurrent.Phaser;

/**
 * arrive - инкремент счетчика фазы
 * awaitAdvance - поток ждет пока счетчик фазы не достигнет максимума
 */
public class Phaser_ {

    public static void main(String[] args) {
        Phaser phaser = new Phaser(2); //Количество потоков
        new Washer(phaser).start();
        new Washer(phaser).start();
    }


    static class Washer extends Thread {
        private Phaser phaser;

        public Washer(Phaser phaser) {
            this.phaser = phaser;
        }

        @Override
        public void run() {
            for (int i = 0; i < 3; i++) {
                System.out.println(getName() + " Washing the car");
                phaser.arriveAndAwaitAdvance(); //нить засыпает пока к phaser не придут 2 потока
            }

        }
    }
}
