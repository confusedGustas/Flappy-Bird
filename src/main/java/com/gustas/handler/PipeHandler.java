package com.gustas.handler;

import com.gustas.Constants;
import com.gustas.entity.Pipe;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class PipeHandler {

    private final List<Pipe> pipes = new ArrayList<>();
    private int ticks = 0;

    public void updatePipes() {
        ticks++;
        if (ticks % Constants.PIPE_GEN_INTERVAL == 0) {
            generatePipes();
        }

        Iterator<Pipe> it = pipes.iterator();
        while (it.hasNext()) {
            Pipe pipe = it.next();
            pipe.update();
            if (pipe.getX() + pipe.getWidth() < 0) {
                it.remove();
            }
        }
    }

    private void generatePipes() {
        Random random = new Random();
        int gapY = random.nextInt(Constants.WINDOW_HEIGHT - Constants.PIPE_GAP - 100) + 50;

        pipes.add(new Pipe(Constants.WINDOW_WIDTH, 0, Constants.PIPE_WIDTH, gapY));
        pipes.add(new Pipe(Constants.WINDOW_WIDTH, gapY + Constants.PIPE_GAP, Constants.PIPE_WIDTH, Constants.WINDOW_HEIGHT - (gapY + Constants.PIPE_GAP)));
    }

    public List<Pipe> getPipes() {
        return pipes;
    }

}