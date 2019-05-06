/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project_relocation;


import java.io.File;
import static javafx.application.Platform.runLater;
import javafx.beans.Observable;
import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.util.Duration;
import static project_relocation.Project_Relocation.buttonFontFamily1;
import static project_relocation.Project_Relocation.buttonStyle1;
import static project_relocation.Project_Relocation.sceneHeight;
import static project_relocation.Project_Relocation.sceneWidth;


/**
 *
 * @author Marc
 */
public class MenuInstructions extends Pane implements UI{
    
    //Label time;
    Duration duration;
    MediaPlayer mediaPlayer;
    
    public MenuInstructions(){
        
        Image background = new Image("menu1Background3.png",1300,650,true,true);
        ImageView backgroundView = new ImageView(background);
        
        this.getChildren().add(backgroundView);
        
        //The location of your file
        Media media = new Media(new File("src/Project_Relocation_First_Fuel.mp4").toURI().toString());

        mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setAutoPlay(false);
        MediaView mediaView = new MediaView(mediaPlayer);
        mediaView.setFitHeight(800);
        mediaView.setFitWidth(800);


        HBox toolBar = new HBox();
        toolBar.setPadding(new Insets(20));
        toolBar.setAlignment(Pos.CENTER);
        toolBar.alignmentProperty().isBound();
        toolBar.setSpacing(5);

        toolBar.setStyle("-fx-background-color: Transparent");
        //BorderPane borderPane = new BorderPane();
        //borderPane.setStyle("-fx-background-color: Black");

        DropShadow dropshadow = new DropShadow();
        dropshadow.setOffsetY(5.0);
        dropshadow.setOffsetX(5.0);
        dropshadow.setColor(Color.WHITE);

        mediaView.setEffect(dropshadow);

        //TOOL BAR CREATION
        Image pausedButtonImage = new Image("Pause.png");
        ImageView pausedButtonImageView = new ImageView(pausedButtonImage);
        pausedButtonImageView.setFitHeight(30);
        pausedButtonImageView.setFitWidth(30);

        Button pauseButton = new Button();
        pauseButton.setGraphic(pausedButtonImageView);
        pauseButton.setStyle("-fx-background-color: Black");

        pauseButton.setOnAction((ActionEvent e) -> {
            mediaPlayer.pause();
        });

        pauseButton.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
        pauseButton.setStyle("-fx-background-color: Black");
        pauseButton.setStyle("-fx-body-color: Black");
        });
        pauseButton.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
        pauseButton.setStyle("-fx-background-color: Black");
        });

        Image playButtonImage = new Image("Play.png");
        ImageView playButtonImageView = new ImageView(playButtonImage);
        playButtonImageView.setFitHeight(30);
        playButtonImageView.setFitWidth(30);

        Button playButton = new Button();
        playButton.setGraphic(playButtonImageView);
        playButton.setStyle("-fx-background-color: Black");

        playButton.setOnAction((ActionEvent e) -> {
            mediaPlayer.play();
        });
        playButton.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
        playButton.setStyle("-fx-background-color: Black");
        playButton.setStyle("-fx-body-color: Black");
        });
        playButton.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
        playButton.setStyle("-fx-background-color: Black");
        });

        Image forwardButtonImage = new Image("Forward.png");
        ImageView forwardButtonImageView = new ImageView(forwardButtonImage);
        forwardButtonImageView.setFitHeight(30);
        forwardButtonImageView.setFitWidth(30);

        Button forwardButton = new Button();
        forwardButton.setGraphic(forwardButtonImageView);
        forwardButton.setStyle("-fx-background-color: Black");

        forwardButton.setOnAction((ActionEvent e) -> {
        mediaPlayer.seek(mediaPlayer.getCurrentTime().multiply(1.5));
        });
        forwardButton.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
        forwardButton.setStyle("-fx-background-color: Black");
        forwardButton.setStyle("-fx-body-color: Black");
        });
        forwardButton.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
        forwardButton.setStyle("-fx-background-color: Black");
        });


        Image backButtonImage = new Image("Back.png");
        ImageView backButtonImageView = new ImageView(backButtonImage);
        backButtonImageView.setFitHeight(30);
        backButtonImageView.setFitWidth(30);

        Button backButton = new Button();
        backButton.setGraphic(backButtonImageView);
        backButton.setStyle("-fx-background-color: Black");

        backButton.setOnAction((ActionEvent e) -> {
        mediaPlayer.seek(mediaPlayer.getCurrentTime().divide(1.5));
        });
        backButton.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
        backButton.setStyle("-fx-background-color: Black");
        backButton.setStyle("-fx-body-color: Black");
        });
        backButton.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
        backButton.setStyle("-fx-background-color: Black");
        });


        Image reloadButtonImage = new Image("Reload.png");
        ImageView reloadButtonImageView = new ImageView(reloadButtonImage);
        reloadButtonImageView.setFitHeight(30);
        reloadButtonImageView.setFitWidth(30);

        Button reloadButton = new Button();
        reloadButton.setGraphic(reloadButtonImageView);
        reloadButton.setStyle("-fx-background-color: Black");

        reloadButton.setOnAction((ActionEvent e) -> {
        mediaPlayer.seek(mediaPlayer.getStartTime());
        });
        reloadButton.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
        reloadButton.setStyle("-fx-background-color: Black");
        reloadButton.setStyle("-fx-body-color: Black");
        });
        reloadButton.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
        reloadButton.setStyle("-fx-background-color: Black");
        });


        //TIME OF VIDEO
        Label timeLabel = new Label();
        timeLabel.setStyle("-fx-text-fill: Yellow");
        timeLabel.textProperty().bind(
        Bindings.createStringBinding(() -> {
            Duration time = mediaPlayer.getCurrentTime();
            return String.format("%4d:%02d:%04.1f",
                (int) time.toHours(),
                (int) time.toMinutes() % 60,
                time.toSeconds() % 3600);
        },
        mediaPlayer.currentTimeProperty()));


        HBox hBox = new HBox();
        Text instructions = new Text(
                "           Instructions       " + " \n\n" +
                "1- Drag and Drop the blocs  " + "\n" +
                "   desired in the timeline  " + " \n\n" +
                "2- Enter the values desired "+ "\n\n" +
                "3- Play your timeline and   " + " \n" +
                "   be carefull to check your"+ "\n" +
                "   remaining fuel and life so" + " \n" +
                "   you won't die            "+ "\n\n" +
                "4- Catch stars to buy different" + " \n" +
                "   upgrades in the store    "+ "\n\n" +
                "5- Be carefull to the obstacles," + " \n" +
                "   they make you lose life  "+ "\n\n" +
                "6- Land on the platform to  " + " \n" +
                "   complete the level       ");

        instructions.setFill(Color.YELLOW);
        instructions.setStyle("-fx-font-family:" + buttonFontFamily1 + ";"
                        + "-fx-font-size: 20px; " );

        HBox buttonBack = new HBox();
        Button backMenu = new Button("Back");
        backMenu.setStyle(buttonStyle1);
        buttonBack.getChildren().add(backMenu);
        buttonBack.setAlignment(Pos.BOTTOM_RIGHT);
        
        
        backMenu.setOnMouseClicked(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent event) {
                
            Project_Relocation.setScene(Project_Relocation.sceneNewGameMenu);
               
            }
    });
        HBox buttonNext = new HBox();
        Button nextMenu = new Button("Start");
        nextMenu.setStyle(buttonStyle1);
        buttonNext.getChildren().add(nextMenu);
        buttonNext.setAlignment(Pos.BOTTOM_RIGHT);
        
        
        
        nextMenu.setOnMouseClicked(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent event) {
                
            Project_Relocation.setScene(Project_Relocation.sceneLevel1);
               
            }
    });
        
        instructions.setLayoutX(sceneWidth/2 + 290);
        instructions.setLayoutY(sceneHeight/2 - 240);

        mediaView.setLayoutX(50);
        mediaView.setLayoutY(50);

        hBox.getChildren().addAll(buttonBack, buttonNext);
        hBox.setLayoutX(sceneWidth/2 - 303);
        hBox.setLayoutY(sceneHeight/2 + 220);

        toolBar.getChildren().addAll( backButton,forwardButton, playButton, pauseButton, reloadButton, timeLabel);
        toolBar.setLayoutX(sceneWidth/2 - 350);
        toolBar.setLayoutY(sceneHeight - 200);

        this.getChildren().addAll(instructions, hBox, mediaView, toolBar);


            }



            }