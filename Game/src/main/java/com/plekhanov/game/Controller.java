package com.plekhanov.game;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Controller extends KeyAdapter {

    private Model model;

    public Controller(Model model) {
        this.model = model;
    }

    public void setModel(Model model) {
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

        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            model.getPlayer().setShoot(false);
        }
    }


    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            model.getPlayer().jumpUp();
            Game.startGame();
        }

        if (e.getKeyCode() == KeyEvent.VK_D) {
            model.getPlayer().setMoveRight(true);
        }

        if (e.getKeyCode() == KeyEvent.VK_A) {
            model.getPlayer().setMoveLeft(true);
        }

        //выход из игры
        if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
            System.exit(0);
        }

        //выстрел
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            model.getPlayer().setShoot(true);
        }

        //смена уровней
        if (e.getKeyCode() == KeyEvent.VK_1) {
            model.loadLevel(1);
        }
        if (e.getKeyCode() == KeyEvent.VK_2) {
            model.loadLevel(2);
        }
        if (e.getKeyCode() == KeyEvent.VK_3) {
            model.loadLevel(3);
        }

    }


}
