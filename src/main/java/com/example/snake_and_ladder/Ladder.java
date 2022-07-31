package com.example.snake_and_ladder;

import java.awt.Point;
import java.awt.Rectangle;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.DropShadow;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Line;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.StrokeLineCap;
import javafx.scene.shape.StrokeLineJoin;

public class Ladder {

    Rectangle box1, box2;
    double width;
    Paint color = Color.WHITE;
    int i1, i2, j1, j2;
    Path path = new Path();

    public Ladder(Rectangle box1, Rectangle box2, double width) {
        this.box1 = box1;
        this.box2 = box2;
        this.width = width;
        path.getElements().add(new MoveTo(getBottom().getX(), getBottom().getY()));
        path.getElements().add(new LineTo(getTop().getX(), getTop().getY()));
    }

    public void drawOn(Board board) {
        double x1 = box1.getCenterX();
        double y1 = box1.getCenterY();
        double x2 = box2.getCenterX();
        double y2 = box2.getCenterY();
        double stroke = width / 5;
        DropShadow dropShadow = new DropShadow();
        dropShadow.setRadius(width / 4);
        dropShadow.setColor(Color.BLACK);
        dropShadow.setBlurType(BlurType.THREE_PASS_BOX);
        Line line1 = new Line(x1 - width / 2, y1, x2 - width / 2, y2);
        Line line2 = new Line(x1 + width / 2, y1, x2 + width / 2, y2);
        line1.setStroke(color);
        line1.setEffect(dropShadow);
        line1.setStrokeWidth(stroke);
        line1.setStrokeLineCap(StrokeLineCap.ROUND);
        line1.setStrokeLineJoin(StrokeLineJoin.ROUND);
        line2.setStroke(color);
        line2.setEffect(dropShadow);
        line2.setStrokeWidth(stroke);
        line2.setStrokeLineCap(StrokeLineCap.ROUND);
        line2.setStrokeLineJoin(StrokeLineJoin.ROUND);
        board.getChildren().addAll(line1, line2);
        double x11 = x1 - width / 2;
        double x22 = x2 - width / 2;
        double slope = (y2 - y1) / (x22 - x11);
        double yy = Math.abs(y2 - y1) / 4;
        for (double i = y1 + yy; i <= y2 - yy / 2; i += yy) {
            Line line3 = new Line((((i - y1) / slope) + x11), i, (((i - y1) / slope) + x11 + width), i);
            line3.setStroke(color);
            DropShadow dropShadow1 = new DropShadow();
            dropShadow1.setRadius(width / 8);
            dropShadow1.setColor(Color.BLACK);
            dropShadow1.setBlurType(BlurType.THREE_PASS_BOX);
            line3.setEffect(dropShadow1);
            line3.setStrokeWidth(stroke);
            line3.setStrokeLineCap(StrokeLineCap.ROUND);
            line3.setStrokeLineJoin(StrokeLineJoin.ROUND);
            board.getChildren().add(line3);
        }
    }

    public void drawOn1(Board board) {
        double x1 = box1.getCenterX();
        double y1 = box1.getCenterY();
        double x2 = box2.getCenterX();
        double y2 = box2.getCenterY();
        double stroke = width / 5;
        DropShadow dropShadow = new DropShadow();
        dropShadow.setRadius(width / 4);
        dropShadow.setColor(Color.BLACK);
        dropShadow.setBlurType(BlurType.THREE_PASS_BOX);
        Line line1 = new Line(x1 - width / 2, y1, x2 - width / 2, y2);
        Line line2 = new Line(x1 + width / 2, y1, x2 + width / 2, y2);
        line1.setStroke(color);
        line1.setEffect(dropShadow);
        line1.setStrokeWidth(stroke);
        line1.setStrokeLineCap(StrokeLineCap.ROUND);
        line1.setStrokeLineJoin(StrokeLineJoin.ROUND);
        line2.setStroke(color);
        line2.setEffect(dropShadow);
        line2.setStrokeWidth(stroke);
        line2.setStrokeLineCap(StrokeLineCap.ROUND);
        line2.setStrokeLineJoin(StrokeLineJoin.ROUND);
        board.getChildren().addAll(line1, line2);
        double x11 = x1 - width / 2;
        double x22 = x2 - width / 2;
        double slope = (y2 - y1) / (x22 - x11);
        double yy = Math.abs(y2 - y1) / 8;
        for (double i = y1 + yy; i <= y2 - yy / 2; i += yy) {
            Line line3 = new Line((((i - y1) / slope) + x11), i, (((i - y1) / slope) + x11 + width), i);
            line3.setStroke(color);
            DropShadow dropShadow1 = new DropShadow();
            dropShadow1.setRadius(width / 8);
            dropShadow1.setColor(Color.BLACK);
            dropShadow1.setBlurType(BlurType.THREE_PASS_BOX);
            line3.setEffect(dropShadow1);
            line3.setStrokeWidth(stroke);
            line3.setStrokeLineCap(StrokeLineCap.ROUND);
            line3.setStrokeLineJoin(StrokeLineJoin.ROUND);
            board.getChildren().add(line3);
        }
    }

    public void drawOn2(Board board) {
        double x1 = box1.getCenterX();
        double y1 = box1.getCenterY();
        double x2 = box2.getCenterX();
        double y2 = box2.getCenterY();
        double stroke = width / 5;
        DropShadow dropShadow = new DropShadow();
        dropShadow.setRadius(width / 4);
        dropShadow.setColor(Color.BLACK);
        dropShadow.setBlurType(BlurType.THREE_PASS_BOX);
        Line line1 = new Line(x1 - width / 2, y1, x2 - width / 2, y2);
        Line line2 = new Line(x1 + width / 2, y1, x2 + width / 2, y2);
        line1.setStroke(color);
        line1.setEffect(dropShadow);
        line1.setStrokeWidth(stroke);
        line1.setStrokeLineCap(StrokeLineCap.ROUND);
        line1.setStrokeLineJoin(StrokeLineJoin.ROUND);
        line2.setStroke(color);
        line2.setEffect(dropShadow);
        line2.setStrokeWidth(stroke);
        line2.setStrokeLineCap(StrokeLineCap.ROUND);
        line2.setStrokeLineJoin(StrokeLineJoin.ROUND);
        board.getChildren().addAll(line1, line2);
        double x11 = x1 - width / 2;
        double x22 = x2 - width / 2;
        double slope = (y2 - y1) / (x22 - x11);
        double yy = Math.abs(y2 - y1) / 10;
        for (double i = y1 + yy; i <= y2 - yy / 2; i += yy) {
            Line line3 = new Line((((i - y1) / slope) + x11), i, (((i - y1) / slope) + x11 + width), i);
            line3.setStroke(color);
            DropShadow dropShadow1 = new DropShadow();
            dropShadow1.setRadius(width / 8);
            dropShadow1.setColor(Color.BLACK);
            dropShadow1.setBlurType(BlurType.THREE_PASS_BOX);
            line3.setEffect(dropShadow1);
            line3.setStrokeWidth(stroke);
            line3.setStrokeLineCap(StrokeLineCap.ROUND);
            line3.setStrokeLineJoin(StrokeLineJoin.ROUND);
            board.getChildren().add(line3);
        }
    }

    private Point getBottom() {
        Point p = new Point();
        p.setLocation(box2.getCenterX(), box2.getCenterY());
        return p;
    }

    private Point getTop() {
        Point p = new Point();
        p.setLocation(box1.getCenterX(), box1.getCenterY());
        return p;
    }

    public void setColor(Paint c) {
        this.color = c;
    }

    public int getI1() {
        return i1;
    }

    public void setI1(int i1) {
        this.i1 = i1;
    }

    public int getI2() {
        return i2;
    }

    public void setI2(int i2) {
        this.i2 = i2;
    }

    public int getJ1() {
        return j1;
    }

    public void setJ1(int j1) {
        this.j1 = j1;
    }

    public int getJ2() {
        return j2;
    }

    public void setJ2(int j2) {
        this.j2 = j2;
    }

    public Path getPath() {
        return path;
    }

}
