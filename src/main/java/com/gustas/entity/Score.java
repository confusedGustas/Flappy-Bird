package com.gustas.entity;

public class Score {

    private int score;

    public Score() {
        this.score = 0;
    }

    public void incrementScore() {
        score++;
    }

    public void resetScore() {
        score = 0;
    }

    public int getScore() {
        return score;
    }

}
