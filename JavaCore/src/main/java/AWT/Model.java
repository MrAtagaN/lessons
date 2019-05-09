package AWT;

/**
 * Игровая логика
 */
public class Model implements Runnable {

    private int anInt; //volatile?

    public int getAnInt() {
        return anInt;
    }

    public void setAnInt(int anInt) {
        this.anInt = anInt;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(10);
                anInt ++;

                if (anInt >= Integer.MAX_VALUE) {
                    anInt = 0;
                }


            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
