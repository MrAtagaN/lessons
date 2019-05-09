package AWT;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Игровая логика
 */
public class Model implements Runnable {

    private int height;
    private int width;

    //volatile?
    private int anInt = 0;
    private  int[] pixels;
    private int imageSize;

    public Model(int width, int height) {
        this.height = height;
        this.width = width;
        this.imageSize = width * height;
        this.pixels = new int[imageSize * 3];
    }

    public int getAnInt() {
        return anInt;
    }

    public void setAnInt(int anInt) {
        this.anInt = anInt;
    }

    public int[] getPixels() {
        return pixels;
    }

    public void setPixels(int[] pixels) {
        this.pixels = pixels;
    }

    @Override
    public void run() {


        GameObject gameObject = new GameObject();
        gameObject.setColorRed(1000);
        gameObject.setX(100);
        gameObject.setY(100);


        while (true) {
            try {
                Thread.sleep(10);
                anInt++;
                gameObject.changeX(1);
                gameObject.changeY(1);

                drawBackground();
                drawObject(gameObject);


                if (anInt >= Integer.MAX_VALUE) {
                    anInt = 0;
                }

                //fillPixels();


            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    private void fillPixels() {
        //цикл по каждому пикселю
        //похоже что 1023 максимальный цвет
//        for (int i = 0; i < pixels.length; i += 3) {
//            pixels[i] = ; //красный цвет пикселя
//            pixels[i + 1] = pixelsModel[i+1]; //зеленый цвет пикселя
//            pixels[i + 2] = pixelsModel[i+2]; //синий цвет пикселя
//        }

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                //фон
                pixels[(x + y * width)*3] = getAnInt(); //красный цвет пикселя
                pixels[(x + y * width)*3 + 1] = getAnInt()*2; //зеленый цвет пикселя
                pixels[(x + y * width)*3 + 2] = getAnInt()*3; //синий цвет пикселя


            }
        }
    }

    private void drawObject(GameObject gameObject) {
//        int coordX = gameObject.getX();
//        int coordY = gameObject.getY();

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                if (gameObject.containCoords(x, y)) {
                    pixels[(x + y * width)*3] = gameObject.getColorRed(); //красный цвет пикселя
                    pixels[(x + y * width)*3 + 1] = gameObject.getColorGreen(); //зеленый цвет пикселя
                    pixels[(x + y * width)*3 + 2] = gameObject.getColorBlue(); //синий цвет пикселя
                }
            }
        }
    }


    private void drawBackground() {
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                //фон
                pixels[(x + y * width)*3]  = getAnInt(); //красный цвет пикселя
                pixels[(x + y * width)*3 + 1] = getAnInt()*2; //зеленый цвет пикселя
                pixels[(x + y * width)*3 + 2] = getAnInt()*3; //синий цвет пикселя
            }
        }
    }
}
