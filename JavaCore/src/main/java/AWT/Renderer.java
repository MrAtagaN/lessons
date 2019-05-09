package AWT;


import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

/**
 * Отрисовка изображения
 */
public class Renderer extends Canvas {

    private int width, height;
//    private int[] pixels;
//    private int imageSize;
    private BufferedImage image;
    private Model model;

    public Renderer(int width, int height, Model model) {
        this.width = width;
        this.height = height;
        this.model = model;
//        this.imageSize = width * height;
//        this.pixels = new int[imageSize * 3];
        image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
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
        graphics.drawImage(image, 0, 0, width, height, this);
        graphics.dispose();
        bufferStrategy.show();
    }


    /**
     * Изменение изображения вследствии изменения модели игры
     */
    public void update() {
        int[] pixels = model.getPixels();
        image.getRaster().setPixels(0, 0, width, height, pixels);
    }


}
