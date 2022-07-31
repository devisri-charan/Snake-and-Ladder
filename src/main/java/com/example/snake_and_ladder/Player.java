package com.example.snake_and_ladder;

import java.util.Random;

public class Player {

    MButton controller;
    int i = 0, j = 0;
    Random random = new Random();
    int number, laststep = 0;
    Board board;
    boolean locked = true, completed = false;
    int turn = 0;

    public Player(Board b) {
        this.board = b;
    }

    public void setController(MButton bt) {
        this.controller = bt;
    }

    public void rollDice() {
        number = (1 + random.nextInt(6));
        turn++;
    }

    public void reset() {
        turn = 0;
        locked = true;
        setLaststep(0);
        reachedEnd(false);
    }

    public int getDiceNumber() {
        return number;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public int getJ() {
        return j;
    }

    public void setJ(int j) {
        this.j = j;
    }

    public int getLaststep() {
        return laststep;
    }

    public void setLaststep(int laststep) {
        this.laststep = laststep;
    }

    public void unlock() {
        locked = false;
    }

    public boolean isLocked() {
        return locked;
    }

    public boolean hasReachedEnd() {
        return completed;
    }

    public void reachedEnd(boolean b) {
        completed = b;
    }
}
