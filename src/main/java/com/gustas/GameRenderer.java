package com.gustas;

import com.gustas.entity.Bird;
import com.gustas.entity.Pipe;
import java.awt.*;
import java.util.List;

public class GameRenderer {

    Font defaultFont = new Font("Arial", Font.BOLD, 24);

    public void renderGame(Graphics graphics, Bird bird, List<Pipe> pipes, boolean isGameStarted, boolean gameOver, int score) {
        bird.draw(graphics);
        pipes.forEach(pipe -> pipe.draw(graphics));
        graphics.setFont(defaultFont);
        renderText(graphics, isGameStarted, gameOver, score);
    }

    public void renderText(Graphics graphics, boolean isGameStarted, boolean gameOver, int score) {
        Rectangle screenCenter = new Rectangle(0, 0, Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT);

        graphics.setColor(Color.BLACK);
        graphics.drawString("Score: " + score, Constants.WINDOW_WIDTH / 2 - 55, 50);

        if (!isGameStarted) {
            drawCenteredString(graphics, "Press Space to Start", screenCenter, defaultFont, Color.BLACK);
        }

        if (gameOver) {
            drawCenteredString(graphics, "Game Over", screenCenter, defaultFont, Color.RED);
        }
    }

    public void drawCenteredString(Graphics g, String text, Rectangle rect, Font font, Color color) {
        g.setFont(font);
        g.setColor(color);

        FontMetrics metrics = g.getFontMetrics(font);
        int x = rect.x + (rect.width - metrics.stringWidth(text)) / 2 - 10;
        int y = rect.y + (rect.height - metrics.getHeight()) / 2 + metrics.getAscent();

        g.drawString(text, x, y);
    }

}
