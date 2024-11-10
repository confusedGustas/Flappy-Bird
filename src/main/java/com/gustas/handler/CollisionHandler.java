package com.gustas.handler;

import com.gustas.Constants;
import com.gustas.entity.Bird;
import com.gustas.entity.Pipe;
import java.util.List;

public class CollisionHandler {

    public boolean checkPipeCollision(Bird bird, List<Pipe> pipes) {
        for (Pipe pipe : pipes) {
            if (bird.getX() < pipe.getX() + pipe.getWidth() &&
                    bird.getX() + bird.getWidth() > pipe.getX() &&
                    bird.getY() < pipe.getY() + pipe.getHeight() &&
                    bird.getY() + bird.getHeight() > pipe.getY()) {
                return true;
            }
        }
        return false;
    }

    public boolean checkBoundaryCollision(Bird bird) {
        return bird.getY() > Constants.WINDOW_HEIGHT || bird.getY() < 0;
    }

}
