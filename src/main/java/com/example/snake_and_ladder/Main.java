package com.example.snake_and_ladder;

import javafx.animation.PathTransition;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.InnerShadow;
import javafx.scene.layout.*;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.util.Objects;

public class Main extends Application {

    AudioClip backgroundMusic;
    AudioClip diceRoll;
    AudioClip snakeAttack;
    AudioClip moveOnLadder;
    double width = 550, height = 550;
    int noOfSnakes = 10, noOfLadders = 10, noOfPlayers = 1;
    int[][] snake = new int[noOfSnakes][4], ladder = new int[noOfLadders][4];
    Board board = new Board(width, height);
    Dice dice = new Dice(120, 120);
    Snake[] snakes = new Snake[noOfSnakes];
    Ladder[] ladders = new Ladder[noOfLadders];
    Player[] players = new Player[1];
    Circle[] tokens, playerColor;
    MButton[] controls;
    Color[] colors = new Color[2];

    @Override
    public void start(Stage stage) {

        backgroundMusic = new AudioClip(Main.class.getResource("game.mp3").toString());
        diceRoll = new AudioClip(Main.class.getResource("Dice Roll.mp3").toString());
        snakeAttack = new AudioClip(Main.class.getResource("snake attack.mp3").toString());
        moveOnLadder = new AudioClip(Main.class.getResource("move on ladder.mp3").toString());
        colors[0] = Color.RED;
        colors[1] = Color.YELLOW;
        noOfPlayers = 2;
        players = new Player[noOfPlayers];
        tokens = new Circle[noOfPlayers];
        playerColor = new Circle[noOfPlayers];
        controls = new MButton[noOfPlayers];

        StackPane root = new StackPane();

        BorderPane rootPane = new BorderPane();

        BorderPane leftBorderPane = new BorderPane();

        BorderPane centralBorderPane = new BorderPane();
        centralBorderPane.setPadding(new Insets(0, 10, 20, 10));

        HBox titleBox = new HBox();
        titleBox.setId("titlebox");
        titleBox.setAlignment(Pos.TOP_CENTER);
        titleBox.setPadding(new Insets(10));

        HBox controlsBox = new HBox();
        controlsBox.setAlignment(Pos.CENTER_LEFT);
        controlsBox.setPadding(new Insets(0, 0, 0, 10));

        VBox primaryControlsBox = new VBox(10);
        primaryControlsBox.setAlignment(Pos.CENTER);

        HBox resetContainer = new HBox();
        resetContainer.setPadding(new Insets(0, 10, 20, 10));
        resetContainer.setAlignment(Pos.CENTER_LEFT);

        VBox graphContainer = new VBox();
        graphContainer.setAlignment(Pos.CENTER_LEFT);
        graphContainer.setFillWidth(true);

        HBox diceContainer = new HBox();
        diceContainer.setPadding(new Insets(10, 10, 10, 10));
        diceContainer.setAlignment(Pos.CENTER);
        diceContainer.setFillHeight(false);

        Text title = new Text("Snake And Ladder by Devi Sri Charan and Vasanth");
        title.setFont(Font.font(Font.getDefault().getFamily(), FontWeight.BOLD, 32));
        title.setId("title");
        titleBox.getChildren().add(title);

        ////////////////Drawing Snakes////////////////////////

        snake[0][0] = 2; snake[0][1] = 3;       snake[0][2] = 1; snake[0][3] = 7;
        snake[1][0] = 2; snake[1][1] = 5;       snake[1][2] = 1; snake[1][3] = 5;
        snake[2][0] = 2; snake[2][1] = 7;       snake[2][2] = 1; snake[2][3] = 3;
        snake[3][0] = 5; snake[3][1] = 8;       snake[3][2] = 3; snake[3][3] = 7;
        snake[4][0] = 5; snake[4][1] = 6;       snake[4][2] = 3; snake[4][3] = 5;
        snake[5][0] = 5; snake[5][1] = 4;       snake[5][2] = 3; snake[5][3] = 3;
        snake[6][0] = 9; snake[6][1] = 8;       snake[6][2] = 7; snake[6][3] = 7;
        snake[7][0] = 9; snake[7][1] = 6;       snake[7][2] = 7; snake[7][3] = 5;
        snake[8][0] = 9; snake[8][1] = 4;       snake[8][2] = 7; snake[8][3] = 3;
        snake[9][0] = 9; snake[9][1] = 1;       snake[9][2] = 3; snake[9][3] = 0;


        for (int i = 0; i < snakes.length; ++i) {
            if (i<3){
                snakes[i] = new Snake(board.box[snake[i][0]][snake[i][1]], board.box[snake[i][2]][snake[i][3]], width / 20);
                snakes[i].setColor(Color.rgb(10, 191, 4));
                snakes[i].drawOn(board);
                snakes[i].setI1(snake[i][0]);
                snakes[i].setJ1(snake[i][1]);
                snakes[i].setI2(snake[i][2]);
                snakes[i].setJ2(snake[i][3]);
            }
            else if((i >= 3)&&(i < 9)){
                snakes[i] = new Snake(board.box[snake[i][0]][snake[i][1]], board.box[snake[i][2]][snake[i][3]], width / 20);
                snakes[i].setColor(Color.rgb(10, 191, 4));
                snakes[i].drawOn1(board);
                snakes[i].setI1(snake[i][0]);
                snakes[i].setJ1(snake[i][1]);
                snakes[i].setI2(snake[i][2]);
                snakes[i].setJ2(snake[i][3]);
            }
            else {
                snakes[i] = new Snake(board.box[snake[i][0]][snake[i][1]], board.box[snake[i][2]][snake[i][3]], width / 20);
                snakes[i].setColor(Color.rgb(10, 191, 4));
                snakes[i].drawOn2(board);
                snakes[i].setI1(snake[i][0]);
                snakes[i].setJ1(snake[i][1]);
                snakes[i].setI2(snake[i][2]);
                snakes[i].setJ2(snake[i][3]);
            }
        }

        ////////////////////Drawing Ladders/////////////////////////////


        ladder[0][0] = 1; ladder[0][1] = 6; ladder[0][2] = 0; ladder[0][3] = 4;
        ladder[1][0] = 1; ladder[1][1] = 4; ladder[1][2] = 0; ladder[1][3] = 6;
        ladder[2][0] = 1; ladder[2][1] = 2; ladder[2][2] = 0; ladder[2][3] = 8;
        ladder[3][0] = 4; ladder[3][1] = 2; ladder[3][2] = 3; ladder[3][3] = 6;
        ladder[4][0] = 4; ladder[4][1] = 4; ladder[4][2] = 3; ladder[4][3] = 4;
        ladder[5][0] = 4; ladder[5][1] = 6; ladder[5][2] = 3; ladder[5][3] = 2;
        ladder[6][0] = 8; ladder[6][1] = 2; ladder[6][2] = 6; ladder[6][3] = 3;
        ladder[7][0] = 8; ladder[7][1] = 4; ladder[7][2] = 6; ladder[7][3] = 5;
        ladder[8][0] = 8; ladder[8][1] = 6; ladder[8][2] = 6; ladder[8][3] = 7;
        ladder[9][0] = 8; ladder[9][1] = 0; ladder[9][2] = 4; ladder[9][3] = 0;



        for (int i = 0; i < ladder.length; ++i) {
            if (i<6){
                ladders[i] = new Ladder(board.box[ladder[i][0]][ladder[i][1]], board.box[ladder[i][2]][ladder[i][3]], width / 20);
                ladders[i].setColor(Color.rgb(143, 254, 248));
                ladders[i].drawOn(board);
                ladders[i].setI1(ladder[i][0]);
                ladders[i].setJ1(ladder[i][1]);
                ladders[i].setI2(ladder[i][2]);
                ladders[i].setJ2(ladder[i][3]);
            }
            else if ((i >= 6)&&(i < 9)){
                ladders[i] = new Ladder(board.box[ladder[i][0]][ladder[i][1]], board.box[ladder[i][2]][ladder[i][3]], width / 20);
                ladders[i].setColor(Color.rgb(143, 254, 248));
                ladders[i].drawOn1(board);
                ladders[i].setI1(ladder[i][0]);
                ladders[i].setJ1(ladder[i][1]);
                ladders[i].setI2(ladder[i][2]);
                ladders[i].setJ2(ladder[i][3]);
            }

            else{
                ladders[i] = new Ladder(board.box[ladder[i][0]][ladder[i][1]], board.box[ladder[i][2]][ladder[i][3]], width / 20);
                ladders[i].setColor(Color.rgb(143, 254, 248));
                ladders[i].drawOn2(board);
                ladders[i].setI1(ladder[i][0]);
                ladders[i].setJ1(ladder[i][1]);
                ladders[i].setI2(ladder[i][2]);
                ladders[i].setJ2(ladder[i][3]);
            }
        }

        ////////////////////////////Setting Controls/////////////////////////////////////

        for (int i = 0; i < noOfPlayers; ++i) {
            HBox controlSet = new HBox(20);
            controlSet.setAlignment(Pos.TOP_CENTER);

            controls[i] = new MButton(i);
            if (i==0) {
                controls[i].setMinWidth(150);
                controls[i].setText("Vasanth");
            }
            if (i==1) {
                controls[i].setMinWidth(150);
                controls[i].setText("Devi Sri Charan");
            }
            players[i] = new Player(board);
            players[i].setController(controls[i]);
            controls[i].setDisable(!(i == 0));

            controls[i].setOnAction(ae -> {
                MButton mb = (MButton) ae.getSource();
                int index = mb.getPlayerIndex();
                if (!players[index].isLocked()) {
                    diceRoll.play();
                    players[index].rollDice();
                    dice.setShow(true);
                    dice.update(players[index].getDiceNumber());
                    if (players[index].getLaststep() + 1 >= 95) {
                        switch (players[index].getLaststep() + players[index].getDiceNumber() + 1) {
                            case 101 -> {
                                players[index].reachedEnd(true);
                                if (players[index].getLaststep() == 99) {
                                    tokens[index].setFill(Color.rgb(0, 0, 0, 0.0));
                                    controls[index].setDisable(true);
                                }
                                move(players[index].getLaststep(), players[index].getLaststep() + players[index].getDiceNumber() - 1, index);
                                FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("snakeAndLadder.fxml"));
                                Scene scene1 = null;
                                try {
                                    scene1 = new Scene(fxmlLoader.load());
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                                stage.setScene(scene1);
                                stage.show();
                            }
                            case 100, 99, 98, 97, 96, 95 -> {
                                move(players[index].getLaststep(), players[index].getLaststep() + players[index].getDiceNumber(), index);
                                players[index].setLaststep(players[index].getLaststep() + players[index].getDiceNumber());
                            }
                            default -> {
                            }
                        }

                    } else {
                        move(players[index].getLaststep(), players[index].getLaststep() + players[index].getDiceNumber(), index);
                        players[index].setLaststep(players[index].getLaststep() + players[index].getDiceNumber());
                    }

                }

                if (players[index].isLocked()) {
                    diceRoll.play();
                    players[index].rollDice();
                    dice.setShow(true);
                    dice.update(players[index].getDiceNumber());
                    if (players[index].getDiceNumber() == 6 || players[index].getDiceNumber() == 1) {
                        players[index].setLaststep(0);
                        players[index].unlock();
                        tokens[index].setFill(colors[index]);
                        tokens[index].setCenterX(board.box[0][0].getCenterX());
                        tokens[index].setCenterY(board.box[0][0].getCenterY());
                    }
                }
                if (index == controls.length - 1) {
                    controls[0].setDisable(false);
                    players[0].controller.requestFocus();
                    controls[index].setDisable(true);
                } else {
                    controls[index + 1].setDisable(false);
                    controls[index].setDisable(true);
                }
            });

            tokens[i] = new Circle();
            tokens[i].setRadius(height / 30);
            tokens[i].setFill(Color.ALICEBLUE);
            DropShadow innerShadow = new DropShadow(3, Color.BLACK);
            innerShadow.setInput(new InnerShadow(2, Color.BLACK));
            tokens[i].setEffect(innerShadow);
            tokens[i].setCenterX(board.box[0][0].getCenterX());
            tokens[i].setCenterY(board.box[0][0].getCenterY());

            playerColor[i] = new Circle();
            playerColor[i].setRadius(height / 40);
            playerColor[i].setFill(colors[i]);

            controls[i].setPrefSize(height / 20 + 10, height / 20);

            controlSet.getChildren().addAll(controls[i], playerColor[i]);
            controlSet.getStyleClass().add("controls");
            primaryControlsBox.getChildren().add(controlSet);

            board.getChildren().add(tokens[i]);

        }

        diceContainer.getChildren().add(dice);
        controlsBox.getChildren().addAll(primaryControlsBox, diceContainer);
        leftBorderPane.setTop(controlsBox);

        /////////////////////Adding Reset Button//////////////////////////////

        Button reset = new Button("Reset");
        reset.setMinWidth(300);
        reset.setOnAction(ae -> {
            for (int i = 0; i < noOfPlayers; ++i) {
                players[i].controller.setDisable(!(i == 0));
                PathTransition pathTransition = new PathTransition();
                Path path = new Path();
                path.getElements().add(new MoveTo(board.box[players[i].getI()][players[i].getJ()].getCenterX(), board.box[players[i].getI()][players[i].getJ()].getCenterY()));
                path.getElements().add(new LineTo(board.box[0][0].getCenterX(), board.box[0][0].getCenterY()));
                pathTransition.setPath(path);
                pathTransition.setNode(tokens[i]);
                pathTransition.setDuration(Duration.seconds(1));
                pathTransition.play();
                players[i].reset();
            }
            dice.setShow(false);
        });
        reset.setFont(Font.font(Font.getDefault().getFamily(), FontWeight.BOLD, 10));
        reset.setId("reset");
        resetContainer.getChildren().add(reset);
        leftBorderPane.setBottom(resetContainer);

        ////////////////////Adding Board////////////////////////////

        centralBorderPane.setCenter(board);

        //////////////////////Arranging The View///////////////////////////

        board.setId("board");
        dice.setId("dice");

        AnchorPane anchorPane = new AnchorPane();
        anchorPane.setPadding(new Insets(0, 0, 50, 0));

        Label circle = new Label("X");
        circle.setId("floatinglabel");
        circle.setMinSize(48, 48);
        circle.setTextAlignment(TextAlignment.CENTER);
        circle.setAlignment(Pos.CENTER);
        circle.setFont(Font.font(Font.getDefault().getFamily(), FontWeight.BOLD, 30));
        DropShadow dropShadow = new DropShadow();
        dropShadow.setBlurType(BlurType.THREE_PASS_BOX);
        dropShadow.setRadius(10);
        circle.setEffect(dropShadow);
        anchorPane.getChildren().addAll(titleBox, circle);
        rootPane.setTop(anchorPane);
        rootPane.setLeft(leftBorderPane);
        rootPane.setCenter(centralBorderPane);
        root.getChildren().add(rootPane);
        Scene scene = new Scene(root);
        scene.getStylesheets().add(Objects.requireNonNull(Main.class.getResource("stylesheet.css")).toExternalForm());
        stage.setTitle("Snake And Ladder by Devi Sri Charan and Vasanth");
        stage.setScene(scene);
        backgroundMusic.play();
        stage.show();

        titleBox.setMinWidth(rootPane.getWidth());
        circle.setTranslateX(rootPane.getWidth() - 50 - 20);
        circle.setTranslateY(titleBox.getHeight() - 25);
        circle.setOnMouseClicked(me -> {
            stage.close();
            backgroundMusic.stop();
        });
    }

    public void move(int from, int to, int index) {
        Path path = new Path();
        String s;
        if (String.valueOf(from).length() == 1) {
            s = "0".concat(String.valueOf(from));
        } else {
            s = String.valueOf(from);
        }
        MoveTo m = new MoveTo();
        int dx = Integer.parseInt(Character.toString(s.charAt(0)));
        int dy = Integer.parseInt(Character.toString(s.charAt(1)));
        m.setX(board.box[dx][dy].getCenterX());
        m.setY(board.box[dx][dy].getCenterY());
        path.getElements().add(m);
        for (int i = from + 1; i <= to; ++i) {
            if (Integer.toString(i).length() == 1) {
                s = "0".concat(Integer.toString(i));
            } else {
                s = Integer.toString(i);
            }
            dx = Integer.parseInt(Character.toString(s.charAt(0)));
            dy = Integer.parseInt(Character.toString(s.charAt(1)));
            LineTo l = new LineTo();
            l.setX(board.box[dx][dy].getCenterX());
            l.setY(board.box[dx][dy].getCenterY());
            path.getElements().add(l);
        }
        final int dxx = dx;
        final int dyy = dy;
        PathTransition pt = new PathTransition();
        pt.setDuration(Duration.seconds((to - from) <= 2 ? 1 : 2));
        pt.setCycleCount(1);
        pt.setPath(path);
        pt.setNode(tokens[index]);
        pt.setOnFinished(ae -> {
            players[index].setI(dxx);
            players[index].setJ(dyy);
            if (players[index].hasReachedEnd()) {
                tokens[index].setFill(Color.rgb(0, 0, 0, 0.0));
                controls[index].setDisable(true);
            }
            for (Snake snake : snakes) {
                if (snake.getI1() == players[index].getI() && snake.getJ1() == players[index].getJ()) {
                    moveOnSnake(snake, index);
                    break;
                }
            }
            for (Ladder ladder : ladders) {
                if (ladder.getI2() == players[index].getI() && ladder.getJ2() == players[index].getJ()) {
                    moveOnLadder(ladder, index);
                    break;
                }
            }

        });
        pt.play();
    }

    public void moveOnSnake(Snake snake, int index) {
        snakeAttack.play();
        PathTransition pt = new PathTransition();
        pt.setDuration(Duration.seconds(2));
        pt.setCycleCount(1);
        pt.setPath(snake.getPath());
        pt.setNode(tokens[index]);
        pt.setOnFinished(ae -> {
            players[index].setI(snake.getI2());
            players[index].setJ(snake.getJ2());
            players[index].setLaststep(Integer.parseInt(String.valueOf(snake.getI2()).concat(String.valueOf(snake.getJ2()))));
        });
        pt.play();
    }

    public void moveOnLadder(Ladder ladder, int index) {
        moveOnLadder.play();
        PathTransition pt = new PathTransition();
        pt.setDuration(Duration.seconds(2));
        pt.setCycleCount(1);
        pt.setPath(ladder.getPath());
        pt.setNode(tokens[index]);
        pt.setOnFinished(ae -> {
            players[index].setI(ladder.getI1());
            players[index].setJ(ladder.getJ1());
            players[index].setLaststep(Integer.parseInt(String.valueOf(ladder.getI1()).concat(String.valueOf(ladder.getJ1()))));
        });
        pt.play();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
