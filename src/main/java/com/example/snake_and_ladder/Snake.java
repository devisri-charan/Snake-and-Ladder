package com.example.snake_and_ladder;

import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.*;

import java.awt.Rectangle;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Snake {

    Rectangle box1, box2;
    double width;
    Paint color = Color.WHITE;
    Path path = new Path();
    int i1, i2, j1, j2;

    public Snake(Rectangle box1, Rectangle box2, double width) {
        this.box1 = box1;
        this.box2 = box2;
        this.width = width;
        path.setStrokeLineCap(StrokeLineCap.ROUND);
        path.setStrokeLineJoin(StrokeLineJoin.ROUND);
        path.setStrokeWidth(width / 3);
    }

    public void drawOn(Board board) {
        double x1 = box1.getCenterX();
        double y1 = box1.getCenterY();
        double x2 = box2.getCenterX();
        double y2 = box2.getCenterY();
        List<Point> p = new ArrayList<>();
        double slope = (y2 - y1) / (x2 - x1);
        double yy = Math.abs(y2 - y1) / 3;

        for (double i = y1; i <= y2; i += yy) {
            Point pt = new Point();
            pt.setLocation((((i - y1) / slope) + x1), i);
            p.add(pt);
        }

        path.getElements().add(new MoveTo(p.get(0).getX(), p.get(0).getY()));
        Point p1, p2;
        for (int i = 1; i < p.size(); ++i) {
            p1 = p.get(i - 1);
            p2 = p.get(i);
            if (x2 < x1) {
                path.getElements().add(new CubicCurveTo(p1.getX(), p1.getY(), (p1.getX() + p2.getX()) / 2 + ((i % 2 == 0) ? -width : width), (p1.getY() + p2.getY()) / 2 - ((i % 2 == 1) ? -width : width), p2.getX(), p2.getY()));
            } else {
                path.getElements().add(new CubicCurveTo(p1.getX(), p1.getY(), (p1.getX() + p2.getX()) / 2 + ((i % 2 == 0) ? -width : width), (p1.getY() + p2.getY()) / 2 + ((i % 2 == 1) ? -width : width), p2.getX(), p2.getY()));
            }
        }
        path.setStroke(color);
        board.getChildren().add(path);
    }

    public void drawOn1(Board board)  {
        double x1 = box1.getCenterX();
        double y1 = box1.getCenterY();
        double x2 = box2.getCenterX();
        double y2 = box2.getCenterY();
        List<Point> p = new ArrayList<>();
        double slope = (y2 - y1) / (x2 - x1);
        double yy = Math.abs(y2 - y1) / 5;
        for (double i = y1; i <= y2; i += yy) {
            Point pt = new Point();
            pt.setLocation((((i - y1) / slope) + x1), i);
            p.add(pt);
        }
        path.getElements().add(new MoveTo(p.get(0).getX(), p.get(0).getY()));
        Point p1, p2;
        for (int i = 1; i < p.size(); ++i) {
            p1 = p.get(i - 1);
            p2 = p.get(i);
            if (x2 < x1) {
                path.getElements().add(new CubicCurveTo(p1.getX(), p1.getY(), (p1.getX() + p2.getX()) / 2 + ((i % 2 == 0) ? -width : width), (p1.getY() + p2.getY()) / 2 - ((i % 2 == 1) ? -width : width), p2.getX(), p2.getY()));
            } else {
                path.getElements().add(new CubicCurveTo(p1.getX(), p1.getY(), (p1.getX() + p2.getX()) / 2 + ((i % 2 == 0) ? -width : width), (p1.getY() + p2.getY()) / 2 + ((i % 2 == 1) ? -width : width), p2.getX(), p2.getY()));
            }
        }
        path.setStroke(color);
        board.getChildren().add(path);
    }

    public void drawOn2(Board board) {
        double x1 = box1.getCenterX();
        double y1 = box1.getCenterY();
        double x2 = box2.getCenterX();
        double y2 = box2.getCenterY();
        List<Point> p = new ArrayList<>();
        double slope = (y2 - y1) / (x2 - x1);
        double yy = Math.abs(y2 - y1) / 8;
        for (double i = y1; i <= y2; i += yy) {
            Point pt = new Point();
            pt.setLocation((((i - y1) / slope) + x1), i);
            p.add(pt);
        }
        path.getElements().add(new MoveTo(p.get(0).getX(), p.get(0).getY()));
        Point p1, p2;
        for (int i = 1; i < p.size(); ++i) {
            p1 = p.get(i - 1);
            p2 = p.get(i);
            if (x2 < x1) {
                path.getElements().add(new CubicCurveTo(p1.getX(), p1.getY(), (p1.getX() + p2.getX()) / 2 + ((i % 2 == 0) ? -width : width), (p1.getY() + p2.getY()) / 2 - ((i % 2 == 1) ? -width : width), p2.getX(), p2.getY()));
            } else {
                path.getElements().add(new CubicCurveTo(p1.getX(), p1.getY(), (p1.getX() + p2.getX()) / 2 + ((i % 2 == 0) ? -width : width), (p1.getY() + p2.getY()) / 2 + ((i % 2 == 1) ? -width : width), p2.getX(), p2.getY()));
            }
        }
        path.setStroke(color);
        board.getChildren().add(path);
    }

    public void setColor(Color c) {
        this.color = c;
    }

    public Path getPath() {
        return path;
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

}
