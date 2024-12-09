package com.gustas.handler;

import com.gustas.controller.GameController;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class InputHandler extends KeyAdapter {

    private final GameController gameController;

    public InputHandler(GameController gameController) {
        this.gameController = gameController;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            gameController.notifyKeyPressed(e.getKeyCode());
        }
    }

}