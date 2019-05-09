package AWT;


import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

/**
 * Отрисовка изображения
 */
public class Renderer extends Canvas{

    private int width, height;
    private int[] pixels;
    private int imageSize;
    BufferedImage image;
    Model model;

    public Renderer(int width, int height, Model model) {
        this.width = width;
        this.height = height;
        this.model = model;
        this.imageSize = width * height;
        this.pixels = new int[imageSize * 3];
        image = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
    }


    /**
     * Вывод изображения
     */
    public void render() {
        BufferStrategy bufferStrategy = this.getBufferStrategy();
        if (bufferStrategy == null) {
            createBufferStrategy(3);
            return;
        }
        Graphics graphics = bufferStrategy.getDrawGraphics();
        graphics.drawImage(image, 0,0,width, height, this);
        graphics.dispose();
        bufferStrategy.show();
    }


    /**
     * Изменение изображения вследствии изменения модели игры
     */
    public void tick() {
        //цикл по каждому пикселю
        for (int i = 0; i < imageSize * 3; i += 3) {
            pixels[i] = model.getAnInt(); //красный цвет пикселя
            pixels[i+1] = model.getAnInt()*2; //зеленый цвет пикселя
            pixels[i+2] = model.getAnInt()*3; //синий цвет пикселя
            //похоже что 1023 максимальный цвет
        }

        image.getRaster().setPixels(0,0,width,height, pixels);
    }


}
