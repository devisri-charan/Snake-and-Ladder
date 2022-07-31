package com.example.snake_and_ladder;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;

import java.awt.*;
import java.util.Arrays;

public class Board extends Pane {

    Rectangle[][] box = new Rectangle[10][10];
    GraphicsContext graphicsContext;
    Color[] color = new Color[100];
    DropShadow effect = new DropShadow(2, Color.BLACK);
    Canvas canvas = new Canvas();

    public Board(double width, double height) {
        this.setWidth(width);
        this.setHeight(height);
        canvas.widthProperty().bind(widthProperty());
        canvas.heightProperty().bind(heightProperty());
        this.getChildren().add(canvas);
        graphicsContext = canvas.getGraphicsContext2D();
        Arrays.fill(color, Color.BLACK);
        draw();
    }

    public void draw() {
        int index = 1;
        double a = getWidth() / 10;
        double b = getHeight() / 10;
        double dx, dy = (b * 10) - b;
        graphicsContext.setTextAlign(TextAlignment.CENTER);
        graphicsContext.setFont(Font.font(Font.getDefault().getFamily(), FontWeight.NORMAL, 20));
        graphicsContext.setLineWidth(0.5d);
        for (int i = 0, ii = (int) a; i < 10; i++, ii += a) {
            dx = 0;
            for (int j = 0, jj = (int) b; j < 10; j++, jj += b) {
                double md = dx;
                if (i % 2 == 1) {
                    md = a * 10 - (a + dx);
                }
                box[i][j] = new Rectangle();
                box[i][j].setRect(md, dy, a, b);
                graphicsContext.setEffect(effect);
                graphicsContext.setFill(color[index - 1]);
                graphicsContext.fillText(String.valueOf(index), md + a / 2, dy + b / 2);
                dx += a;
                index++;
                graphicsContext.setGlobalAlpha(1.0d);
                graphicsContext.setStroke(Color.web("#E91E63"));
                graphicsContext.setEffect(null);
                if (i == 0 && j < 9) {
                    graphicsContext.strokeLine(0, jj, a * 10, jj);
                }
            }
            if (i < 9) {
                graphicsContext.strokeLine(ii, 0, ii, b * 10);
            }
            dy -= b;
        }
        graphicsContext.setEffect(effect);
    }
}
