package com.example.snake_and_ladder;

import javafx.scene.control.Button;

public class MButton extends Button {

    int position;

    public MButton(int i) {
        position = i;
    }

    public int getPlayerIndex() {
        return position;
    }
}
