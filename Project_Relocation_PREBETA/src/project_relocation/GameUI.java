 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project_relocation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import static project_relocation.Project_Relocation.buttonStyle1;
import static project_relocation.Project_Relocation.buttonStyle2;
import static project_relocation.Project_Relocation.labelStyle1;
import static project_relocation.Project_Relocation.labelStyle2;

/**
 *
 * @author Marc
 */
public class GameUI extends Pane {

    int levelNb = 0;
    Pane finishedGamePopup = new Pane();
    Pane losePane = new Pane();
    Text deathReasonText = new Text("ddj");
    Pane winnerPane = new Pane();
    TimelineOrders timeline = new TimelineOrders();
    OrdersList ordersList = new OrdersList();
    Pane playAroundButton = new Pane();

    public GameUI() {

        playAroundButton.setMinWidth(100);
        playAroundButton.setMaxWidth(100);
        playAroundButton.setMinHeight(100);
        playAroundButton.setMaxHeight(100);
        playAroundButton.setLayoutX(Project_Relocation.sceneWidth - 110);
        playAroundButton.setLayoutY(Project_Relocation.sceneHeight - 110);
        Polygon triangle = new Polygon();
        triangle.getPoints().setAll(new Double[]{
            30.0, 20.0,
            30.0, 80.0,
            80.0, 50.0}
        );
        triangle.setFill(Color.WHITE);

        Circle playButton = new Circle(50, 50, 50, Color.RED);
        playAroundButton.getChildren().addAll(playButton, triangle);
        playAroundButton.toFront();

        playAroundButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                playAroundButton.requestFocus();
                readOrders(timeline.getOrders());

            }

        });

        this.getChildren().add(playAroundButton);

        timeline.setOnScroll(new EventHandler<ScrollEvent>() {
            @Override
            public void handle(ScrollEvent event) {
                scrollBlocs(event.getDeltaX());
            }
        });
        this.getChildren().addAll(timeline, ordersList);

    }

    public void addPopup(int nextLevelNodeName) {
        
        //POPUP WIN
        Text titleFinishedGame = new Text("Congrats you've just finished the game!");
        Button mSelectionFG = new Button("Level Selection");
        Button mainMenuFG = new Button("Main Menu");
        Button tryAgainFG = new Button("Try Again");

        titleFinishedGame.setStyle(labelStyle2 + " -fx-font-size: 20px");
        titleFinishedGame.setLayoutY(80);
        titleFinishedGame.setLayoutX(75);
        mSelectionFG.setStyle(buttonStyle1 + " -fx-font-size: 20px");
        mainMenuFG.setStyle(buttonStyle1 + " -fx-font-size: 20px");
        tryAgainFG.setStyle(buttonStyle1 + " -fx-font-size: 20px");
        mSelectionFG.setLayoutX(165);
        mSelectionFG.setLayoutY(300);
        tryAgainFG.setLayoutY(225);
        tryAgainFG.setLayoutX(190);
        mainMenuFG.setLayoutY(150);
        mainMenuFG.setLayoutX(180);

        mSelectionFG.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Project_Relocation.setScene(Project_Relocation.sceneSelectionMenu);
            }
        });
        mainMenuFG.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Project_Relocation.setScene(Project_Relocation.sceneMenu1);
            }
        });
        tryAgainFG.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Project_Relocation.setScene(Project_Relocation.getLevelScene(getLevelNb()));
            }
        });

        finishedGamePopup.getChildren().addAll(titleFinishedGame, mainMenuFG, tryAgainFG, mSelectionFG);
        finishedGamePopup.setStyle("-fx-border-width: 1;-fx-border-radius: 5;-fx-border-color: black; -fx-background-color:#fff");
        finishedGamePopup.setVisible(false);
        finishedGamePopup.setMinWidth(500);
        finishedGamePopup.setMinHeight(400);
        finishedGamePopup.setLayoutX(Project_Relocation.sceneWidth / 2 - 250);
        finishedGamePopup.setLayoutY(Project_Relocation.sceneHeight / 2 - 250);
        getChildren().add(finishedGamePopup);

        
        
        //LOSE POPUP
        
        Text titleLose = new Text("Sorry, you lost!");
        Button mSelectionLose = new Button("Level Selection");
        Button mainMenuLose = new Button("Main Menu");
        Button tryAgainLose = new Button("Try Again");

        titleLose.setStyle(labelStyle2 + " -fx-font-size: 20px");
        titleLose.setLayoutY(60);
        titleLose.setLayoutX(180);
        mSelectionLose.setStyle(buttonStyle1 + " -fx-font-size: 20px");
        mainMenuLose.setStyle(buttonStyle1 + " -fx-font-size: 20px");
        tryAgainLose.setStyle(buttonStyle1 + " -fx-font-size: 20px");
        mSelectionLose.setLayoutX(165);
        mSelectionLose.setLayoutY(320);
        tryAgainLose.setLayoutY(245);
        tryAgainLose.setLayoutX(190);
        mainMenuLose.setLayoutY(170);
        mainMenuLose.setLayoutX(180);

        mSelectionLose.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    Project_Relocation.setScene(Project_Relocation.getSelectionMenu());
                } catch (IOException ex) {
                    Logger.getLogger(GameUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        mainMenuLose.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Project_Relocation.setScene(Project_Relocation.sceneMenu1);
            }
        });
        tryAgainLose.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.out.println(nextLevelNodeName);
                Project_Relocation.setScene(Project_Relocation.getLevelScene(getLevelNb()));
            }
        });

        
        
        deathReasonText.setLayoutX(167);
        deathReasonText.setLayoutY(100);
        deathReasonText.setOpacity(0.5);
        deathReasonText.setTextAlignment(TextAlignment.CENTER);
        deathReasonText.setStyle(labelStyle2 + " -fx-font-size: 17px");
        
        
        losePane.getChildren().addAll(titleLose, mainMenuLose, tryAgainLose, mSelectionLose, deathReasonText);
        losePane.setStyle("-fx-border-width: 1;-fx-border-radius: 5;-fx-border-color: black; -fx-background-color:#fff");
        losePane.setVisible(false);
        losePane.setMinWidth(500);
        losePane.setMinHeight(400);
        losePane.setLayoutX(Project_Relocation.sceneWidth / 2 - 250);
        losePane.setLayoutY(Project_Relocation.sceneHeight / 2 - 250);
        getChildren().add(losePane);

        
        
        
        
        
        
        
        
        
        
        
        //WINNER
        
        Text titleWin = new Text("Congrat's you won!");
        Button nlWin = new Button("Next Level");
        Button mSelectionWin = new Button("Level Selection");
        Button mainMenuWin = new Button("Main Menu");
        Button tryAgainWin = new Button("Try Again");
        
        
        nlWin.setLayoutY(100);
        nlWin.setLayoutX(185);
        nlWin.setStyle(buttonStyle1 + " -fx-font-size: 20px");
        titleWin.setStyle(labelStyle2 + " -fx-font-size: 20px");
        titleWin.setLayoutY(70);
        titleWin.setLayoutX(170);
        mSelectionWin.setStyle(buttonStyle1 + " -fx-font-size: 20px");
        mainMenuWin.setStyle(buttonStyle1 + " -fx-font-size: 20px");
        tryAgainWin.setStyle(buttonStyle1 + " -fx-font-size: 20px");
        mSelectionWin.setLayoutX(165);
        mSelectionWin.setLayoutY(325);
        tryAgainWin.setLayoutY(250);
        tryAgainWin.setLayoutX(190);
        mainMenuWin.setLayoutY(175);
        mainMenuWin.setLayoutX(180);
        
        
        
        nlWin.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Project_Relocation.setScene(Project_Relocation.getLevelScene(getLevelNb()+1));
            }
        });
        
        mSelectionWin.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Project_Relocation.setScene(Project_Relocation.sceneSelectionMenu);
            }
        });
        mainMenuWin.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Project_Relocation.setScene(Project_Relocation.sceneMenu1);
            }
        });
        tryAgainWin.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Project_Relocation.setScene(Project_Relocation.getLevelScene(getLevelNb()));
            }
        });



        winnerPane.getChildren().addAll(titleWin, mainMenuWin, tryAgainWin, mSelectionWin, nlWin);
        winnerPane.setStyle("-fx-border-width: 1;-fx-border-radius: 5;-fx-border-color: black; -fx-background-color:#fff");
        winnerPane.setVisible(false);
        winnerPane.setMinWidth(500);
        winnerPane.setMinHeight(400);
        winnerPane.setLayoutX(Project_Relocation.sceneWidth / 2 - 250);
        winnerPane.setLayoutY(Project_Relocation.sceneHeight / 2 - 200);
        getChildren().add(winnerPane);
    }

    public void sendOrderToTimeline(Orders order, double positionx, double positiony) {
        timeline.addOrder(order, positionx, positiony);
    }

    public void scrollBlocs(double xvalue) {
        timeline.scrollBlocs(xvalue);

    }

    public void readOrders(ArrayList<Orders> x) {
    }

    public void displayLosePopup(String deathReason) {
        losePane.setVisible(true);
        setLosePopupText(deathReason);

    }

    public void displayWinPopup() {
        winnerPane.setVisible(true);

    }

    public int getLevelNb() {
        return levelNb;
    }
    

    public void renderStarsLevel() {
    }

    public void showArrows(boolean value) {
        ordersList.showArrows(value);
    }

    public void showArrowRight(boolean value) {
        ordersList.showArrowRight(value);
    }

    public void showArrowLeft(boolean value) {
        ordersList.showArrowLeft(value);
    }

    public void removeOrder(int x) {
        timeline.removeOrder(x);
    }

    public void lockPlayButton() {
        playAroundButton.setDisable(true);
    }

    public void unlockPlayButton() {
        playAroundButton.setDisable(false);
    }

    public void hidePopups() {

        losePane.setVisible(false);
        winnerPane.setVisible(false);
    }

    public void clearTimelineBlocs() {
        ordersList.clearTimelineBlocs();
    }

    public void resetLevel() {
    }

    public void displayFinishedGamePopup() {
        finishedGamePopup.setVisible(true);
    }
    public void setLosePopupText(String deathReason){
    deathReasonText.setText(deathReason);
    }
    
}
