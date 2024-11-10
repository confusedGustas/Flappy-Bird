package com.gustas.controller;

import com.gustas.GameRenderer;
import com.gustas.entity.Bird;
import com.gustas.entity.Pipe;
import com.gustas.entity.Score;
import com.gustas.handler.CollisionHandler;
import com.gustas.handler.InputHandler;
import com.gustas.handler.PipeHandler;
import javax.swing.*;
import java.awt.*;

public class GameController extends JPanel {

    private final Bird bird;
    private final PipeHandler pipeManager;
    private final CollisionHandler collisionHandler;
    private final GameRenderer gameRenderer;
    private final Score score;
    private boolean gameOver = false;
    private boolean isGameStarted = false;

    public GameController() {
        bird = new Bird(150, 300, 30, 30);
        pipeManager = new PipeHandler();
        collisionHandler = new CollisionHandler();
        gameRenderer = new GameRenderer();
        score = new Score();
        InputHandler inputHandler = new InputHandler(this);

        setFocusable(true);
        requestFocusInWindow();
        addKeyListener(inputHandler);
        setBackground(new Color(0, 128, 255));
    }

    public void start() {
        Timer timer = new Timer(20, e -> {
            if (isGameStarted && !gameOver) {
                bird.update();
                pipeManager.updatePipes();
                checkCollisions();
                updateScore();
            }
            repaint();
        });
        timer.start();
    }

    public void startGame() {
        if (!isGameStarted) {
            isGameStarted = true;
            score.resetScore();
        } else if (!gameOver) {
            bird.jump();
        }
    }

    private void checkCollisions() {
        if (collisionHandler.checkPipeCollision(bird, pipeManager.getPipes()) ||
                collisionHandler.checkBoundaryCollision(bird)) {
            gameOver = true;
        }
    }

    private void updateScore() {
        for (Pipe pipe : pipeManager.getPipes()) {
            if (!pipe.isPassed() && pipe.getY() == 0 && pipe.getX() + pipe.getWidth() < bird.getX()) {
                score.incrementScore();
                pipe.setPassed(true);
                break;
            }
        }
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        gameRenderer.renderGame(graphics, bird, pipeManager.getPipes(), isGameStarted, gameOver, score.getScore());
    }

}
