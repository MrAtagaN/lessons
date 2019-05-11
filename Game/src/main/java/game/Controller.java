package game;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Controller extends KeyAdapter {

    private Model model;

    public Controller(Model model) {
        this.model = model;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_D) {
           model.getPlayer().setMoveRight(false);
        }

        if (e.getKeyCode() == KeyEvent.VK_A) {
            model.getPlayer().setMoveLeft(false);
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {

        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            model.getPlayer().jumpUp();
        }

        if (e.getKeyCode() == KeyEvent.VK_D) {
            model.getPlayer().setMoveRight(true);
        }

        if (e.getKeyCode() == KeyEvent.VK_A) {
            model.getPlayer().setMoveLeft(true);
        }

    }




}
