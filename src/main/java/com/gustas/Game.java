package com.gustas;

import com.gustas.controller.GameController;
import javax.swing.*;

public class Game extends JFrame {

    private static Game instance;

    private Game() {
        setTitle("Flappy Bird");
        setSize(Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    public static Game getInstance() {
        if (instance == null) {
            instance = new Game();
        }
        return instance;
    }

    public void startGame() {
        GameController gameController = new GameController();
        add(gameController);
        setVisible(true);
        gameController.start();
    }

    public static void main(String[] args) {
        Game.getInstance().startGame();
    }

}