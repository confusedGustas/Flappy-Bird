package com.gustas.entity;

import com.gustas.Constants;
import java.awt.Color;
import java.awt.Graphics;

public class Bird extends GameObject {

    private int velocity = 0;

    public Bird(int x, int y, int width, int height) {
        super(x, y, width, height);
    }

    public void jump() {
        velocity = -Constants.BIRD_JUMP;
    }

    @Override
    public void update() {
        velocity += Constants.GRAVITY;
        y += velocity;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(new Color(255, 255, 30));
        g.fillRect(x, y, width, height);
    }

}
