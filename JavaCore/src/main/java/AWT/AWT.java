package AWT;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;

public class AWT {
    public static void main(String[] args) {
        JFrame jFrame = new JFrame();
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension demension = toolkit.getScreenSize();
        jFrame.setBounds(demension.width/4, demension.height/4, demension.width/2, demension.height/2);

        jFrame.add(new MyComponent());

    }

    static class MyComponent extends JComponent {
        @Override
        public void paint(Graphics graphics) {
            Graphics2D graphics2D = (Graphics2D) graphics;

            Line2D line2D = new Line2D.Double(0,0,123,123);
            graphics2D.draw(line2D);
        }


    }





}
