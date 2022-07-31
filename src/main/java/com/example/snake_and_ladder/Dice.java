package com.example.snake_and_ladder;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.InnerShadow;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

import java.util.Objects;

public class Dice extends Canvas {

    boolean show = false;
    InnerShadow innerShadow = new InnerShadow(5, Color.BLACK);
    GraphicsContext graphicsContext;

    public Dice(double width, double height) {
        this.setWidth(width);
        this.setHeight(height);
        innerShadow.setBlurType(BlurType.THREE_PASS_BOX);
        graphicsContext = getGraphicsContext2D();
        graphicsContext.setEffect(innerShadow);
    }

    public void setShow(boolean b) {
        show = b;
    }

    public void update(int number) {
        if (show) {

            for (int i = 1 ; i <= 6 ; i++){
                Image image = new Image(Objects.requireNonNull(Dice.class.getResource("dice"+ i + ".png")).toString());
                graphicsContext.drawImage(image,0,0,120,120);
            }

            switch (number) {
                case 1 -> {
                    Image image = new Image(Objects.requireNonNull(Dice.class.getResource("dice1.png")).toString());
                    graphicsContext.drawImage(image,0,0,120,120);
                }

                case 2 -> {
                    Image image = new Image(Objects.requireNonNull(Dice.class.getResource("dice2.png")).toString());
                    graphicsContext.drawImage(image,0,0,120,120);
                }

                case 3 -> {
                    Image image = new Image(Objects.requireNonNull(Dice.class.getResource("dice3.png")).toString());
                    graphicsContext.drawImage(image,0,0,120,120);
                }

                case 4 -> {
                    Image image = new Image(Objects.requireNonNull(Dice.class.getResource("dice4.png")).toString());
                    graphicsContext.drawImage(image,0,0,120,120);
                }

                case 5 -> {
                    Image image = new Image(Objects.requireNonNull(Dice.class.getResource("dice5.png")).toString());
                    graphicsContext.drawImage(image,0,0,120,120);
                }

                case 6 -> {
                    Image image = new Image(Objects.requireNonNull(Dice.class.getResource("dice6.png")).toString());
                    graphicsContext.drawImage(image,0,0,120,120);
                }

                default -> {
                }
            }
        }
    }
}
