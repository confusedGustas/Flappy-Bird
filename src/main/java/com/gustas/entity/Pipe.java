package com.gustas.entity;

import com.gustas.Constants;
import java.awt.Color;
import java.awt.Graphics;

public class Pipe extends GameObject {

    private boolean passed = false;

    public Pipe(int x, int y, int width, int height) {
        super(x, y, width, height);
    }

    @Override
    public void update() {
        x -= Constants.PIPE_SPEED;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(new Color(5, 163, 5));
        g.fillRect(x, y, width, height);
    }

    public boolean isPassed() {
        return passed;
    }

    public void setPassed(boolean passed) {
        this.passed = passed;
    }

}