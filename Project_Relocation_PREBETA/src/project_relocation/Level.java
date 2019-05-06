/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project_relocation;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.logging.Logger;
import javafx.animation.Animation;
import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.SequentialTransition;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import static project_relocation.Project_Relocation.buttonFontFamily1;
import static project_relocation.Project_Relocation.buttonStyle2;
import static project_relocation.Project_Relocation.sceneWidth;
import static project_relocation.Project_Relocation.user;
import static project_relocation.menuSelection.renderSelectionMenu;

/**
 *
 * @author sandr
 */
public class Level extends Pane {
//timer to check collisions

    AnimationTimer timer;

    boolean timelineReadyToRead = false;
    boolean rocketHasDied = false;

    //sequential transition for all the orders
    SequentialTransition theTimelineAnimation = new SequentialTransition();

    private double fuelCap = Project_Relocation.user.getFuelCapacity();
    private double lifeCap = Project_Relocation.user.getProtection();
    Rocket rocketGroup = new Rocket();
    private String backgroundImgLink = "";
    private String floorImgLink = "";
    private Platform platform;
    public double platformY = 0;
    private String name;
    private double gravity = 14;
    private int[] timeSinceCollisionArray;
    private Obstacle[] obstacles;
    private Star[] stars;
    private ArrayList<Orders> theOrdersList = new ArrayList<Orders>();

    double levelHeight = Project_Relocation.sceneHeight - 120;
    double levelWidth = Project_Relocation.sceneWidth - 120;

    String starsN = Integer.toString(Project_Relocation.user.getStars());
    Label numStars = new Label(starsN);
    Label lifeLabel = new Label(Integer.toString(Project_Relocation.user.getProtection()));
    Rectangle fuelRectangleBack = new Rectangle();
    Rectangle fuelRectangle = new Rectangle();
    double fuelDefaultWidth = 90;
    Text lvl;

    public Level() {
       //Display du carree 
        this.toBack();
        this.setLayoutY(0);
        this.setLayoutX(120);
        this.setMinHeight(levelHeight);
        this.setMinWidth(levelWidth);
        this.setMaxHeight(levelHeight);
        this.setMaxWidth(levelWidth);
        this.setStyle("-fx-border-width: 1;"
                + "-fx-border-radius: 5;"
                + "-fx-border-color: black;");
        
        //MUTE AND ON
        
        
        Image imageSound = new Image("Music.png");
        ImageView imageViewSound = new ImageView(imageSound);
        imageViewSound.setFitHeight(30);
        imageViewSound.setFitWidth(30);
        imageViewSound.setLayoutX(sceneWidth - 150);
        imageViewSound.setLayoutY(10);

        Image imageSound1 = new Image("Mute.png");
        ImageView imageViewSound1 = new ImageView(imageSound1);
        imageViewSound1.setFitHeight(30);
        imageViewSound1.setFitWidth(30);
        imageViewSound1.setLayoutX(sceneWidth - 150);
        imageViewSound1.setLayoutY(10);
        
        imageViewSound.setOnMouseClicked(new EventHandler<MouseEvent>(){
            public void handle(MouseEvent t) {
                Project_Relocation.songPlayer.play();
                imageViewSound.setVisible(false);
                imageViewSound1.setVisible(true);
            }
    });
        
        imageViewSound1.setOnMouseClicked(new EventHandler<MouseEvent>(){
            public void handle(MouseEvent t) {
                Project_Relocation.songPlayer.pause();
                imageViewSound1.setVisible(false);
                imageViewSound.setVisible(true);
            }
    });

        this.getChildren().addAll(imageViewSound, imageViewSound1);

        //QUIT BUTTON
        HBox quit = new HBox();
        Button buttonQuit = new Button("Quit");

        quit.setLayoutX(sceneWidth - 225);
        quit.setLayoutY(5);
        buttonQuit.setStyle(buttonStyle2);
        quit.getChildren().add(buttonQuit);

        this.getChildren().add(quit);

        buttonQuit.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

                try {
                    Project_Relocation.setScene(Project_Relocation.getSelectionMenu());
                } catch (IOException ex) {
                    Logger.getLogger(Level.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                }

            }
        });
//
//        quit.setOnMouseClicked(new EventHandler<MouseEvent>() {
//            @Override
//            public void handle(MouseEvent event) {
//
//                Project_Relocation.setScene(Project_Relocation.getSelectionMenu());
//
//            }
//        });
        //NUMBERS OF STARS layout

        HBox hStars = new HBox();

        Image image = new Image("starPNG.png");
        ImageView imageS = new ImageView(image);
        imageS.setFitHeight(30);
        imageS.setFitWidth(30);


        numStars.setStyle("-fx-text-fill: rgb(255, 204, 0); "
                + "-fx-font-family: " + buttonFontFamily1 + "; "
                + "-fx-font-size: 40px; ");
        numStars.setGraphic(imageS);
        numStars.setContentDisplay(ContentDisplay.RIGHT);

        hStars.setSpacing(10);
        hStars.getChildren().add((numStars));
        hStars.setLayoutX(sceneWidth - 315);
        hStars.setLayoutY(-5);

        this.getChildren().add(hStars);

        //FUEL VALUE DISPLAY

        HBox hFuel = new HBox();

        Image imageFuel = new Image("fuel.png");
        ImageView imageViewFuel = new ImageView(imageFuel);
        imageViewFuel.setFitHeight(30);
        imageViewFuel.setFitWidth(30);

        Pane fuelPane = new Pane();
        
        fuelRectangleBack.setWidth(100);
        fuelRectangleBack.setHeight(30);
        fuelRectangleBack.setFill(Color.TRANSPARENT);
        fuelRectangleBack.setStroke(Color.BLACK);
        
        fuelRectangle.setWidth(fuelDefaultWidth);
        fuelRectangle.setHeight(20);
        fuelRectangle.setFill(Color.RED);
        fuelRectangle.setTranslateY(5);
        fuelRectangle.setTranslateX(5);

        fuelPane.getChildren().addAll(fuelRectangle,fuelRectangleBack);
        
        hFuel.setSpacing(10);
        hFuel.getChildren().addAll(imageViewFuel, fuelPane);
        hFuel.setLayoutX(10);
        hFuel.setLayoutY(10);

        this.getChildren().add(hFuel);
       
        
        //life value display
        
        HBox hLife = new HBox();

        Image imageLife = new Image("heart.png");
        ImageView imageViewLife = new ImageView(imageLife);
        imageViewLife.setFitHeight(30);
        imageViewLife.setFitWidth(30);


        lifeLabel.setStyle("-fx-text-fill: rgb(255, 204, 0); "
                + "-fx-font-family: " + buttonFontFamily1 + "; "
                + "-fx-font-size: 40px; ");
        lifeLabel.setGraphic(imageViewLife);
        lifeLabel.setContentDisplay(ContentDisplay.LEFT);

        hLife.setSpacing(10);
        hLife.getChildren().add((lifeLabel));
        hLife.setLayoutX(170);
        hLife.setLayoutY(-5);

        this.getChildren().add(hLife);
        
        //LEVEL DISPLAY + GRAVITY
        HBox hLevel = new HBox();

        Pane levelPane = new Pane();
        
        Rectangle levelRectangleBack = new Rectangle();
        levelRectangleBack.setWidth(200);
        levelRectangleBack.setHeight(30);
        levelRectangleBack.setFill(Color.TRANSPARENT);
        levelRectangleBack.setStroke(Color.BLACK);
        
        lvl = new Text("");
        lvl.setStyle("-fx-font-size: 18px");
        lvl.setLayoutX(5);
        lvl.setLayoutY(15);
        lvl.setFill(Color.RED);
        lvl.setTranslateY(5);
        lvl.setTranslateX(5);

        levelPane.getChildren().addAll(levelRectangleBack, lvl);
        
        hLevel.setSpacing(5);
        hLevel.getChildren().add(levelPane);
        hLevel.setLayoutX(sceneWidth - 528);
        hLevel.setLayoutY(10);

        this.getChildren().add(hLevel);
        
        
        //rocket and its layout
        Image rocketImage = new Image("rocketProjFinal.png", 80, 80, true, true);
        ImageView rocketImageView = new ImageView(rocketImage);
        rocketImageView.setLayoutX(5);
        rocketImageView.setLayoutY(0);

        rocketGroup.getChildren().addAll(rocketImageView);
        rocketGroup.setLayoutY(levelHeight - 100);
        rocketGroup.setLayoutX(levelWidth / 2 - 20);

        //hp    //action when timeline has finished and no crash happened
        theTimelineAnimation.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                timelineIsFinished();
            }
        });

        this.getChildren().add(rocketGroup);

        //runs every frame to check collisions
        
        timer = new AnimationTimer() {
            @Override
            public void handle(long l) {
                if (!rocketHasDied) {
                    
                    
                    addOneFrameToTimer();
                    
                    

                    removeFuel();
                    System.out.print("REMOVE FUEEEL");

                    //CHECK COLLISION BOUNDS OF GAME
                    if (rocketGroup.getBoundsInParent().getMinX() <= -10 || rocketGroup.getBoundsInParent().getMaxX() >= levelWidth) {
                        isDead("You crashed into the "+"\n"+"level bounds");
                    } else if (rocketGroup.getBoundsInParent().getMinY() <= 10 || rocketGroup.getBoundsInParent().getMaxY() >= levelHeight) {
                        isDead("You crashed into the "+"\n"+"level bounds");
                    }

                    //CHECK IF THE ROCKET HAS BEEN ROTATED, IF NO DONT NEED TO CHECK FOR 4 COORDS
                    //COORDS OF PLATFORM
                    double platformRightX = platform.getX() + platform.getWidth() + 30;
                    double platformLeftX = platform.getX();
                    
                    double platformTopY = platform.getBoundsInParent().getMinY()+30;
                    double platformBottomY = platform.getBoundsInParent().getMaxY()+30;

                    //COORDS OF un-ROATATED ROCKET 
                    double currentAngleGroupRad = Math.toRadians(rocketGroup.getRotate());
                    double cosAngle = Math.cos(currentAngleGroupRad);
                    double sinAngle = Math.sin(currentAngleGroupRad);
                    double centerX = rocketGroup.getBoundsInParent().getMaxX() - (rocketGroup.getBoundsInParent().getWidth() / 2);
                    double centerY = rocketGroup.getBoundsInParent().getMaxY() - (rocketGroup.getBoundsInParent().getHeight() / 2);
                    double leftX = centerX - (rocketGroup.getWidth() / 2) + 15;
                    double rightX = centerX + (rocketGroup.getWidth() / 2) - 15;
                    double topY = centerY - rocketGroup.getHeight() + 10;
                    double bottomY = centerY + rocketGroup.getHeight() - 10;

                    //COORDS OF UN-ROTATED ROCKET RELATIVE TO ORIGIN
                    double tempLeftX = leftX - centerX;
                    double tempRightX = rightX - centerX;
                    double tempTopY = topY - centerY;
                    double tempBottomY = bottomY - centerY;

                    //COORDS OF ROTATED ROCKET RELATIVE TO ORIGIN
                    double[] newXArray = new double[]{(tempLeftX * cosAngle) - (tempTopY * sinAngle), (tempLeftX * cosAngle) - (tempBottomY * sinAngle), (tempRightX * cosAngle) - (tempTopY * sinAngle), (tempRightX * cosAngle) - (tempBottomY * sinAngle)};
                    double[] newYArray = new double[]{(tempTopY * cosAngle) + (tempLeftX * sinAngle), (tempBottomY * cosAngle) + (tempLeftX * sinAngle), (tempTopY * cosAngle) + (tempRightX * sinAngle), (tempBottomY * cosAngle) + (tempRightX * sinAngle)};
                    for (int i = 0; i < 4; i++) {
                        //CHANGE ROCKET COORDS TO MAKE THE ROT RELATIVE TO ITSELF
                        double xCoord = newXArray[i] + centerX;
                        double yCoord = newYArray[i] + centerY;

                        //CHECK COLLISION PLATFORM
                        if (xCoord < platformRightX && xCoord > platformLeftX - 10 && yCoord < platformBottomY && yCoord > platformTopY) {
                            System.out.print("yp");
                            if (centerY < platformTopY - 5 && rocketGroup.getRotate() > -15 && rocketGroup.getRotate() < 15) {
                                try {
                                    justWon();
                                } catch (IOException ex) {
                                    Logger.getLogger(Level.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                                }
                                
                            } else {
                                //crashed below
                                isDead("You crashed into the "+"\n"+"platform");
                            }

                        }

                        //CHECK COLLISION WITH OBSTACLES
                        for (int z = 0; z < obstacles.length; z++) {
                            if(timeSinceCollisionArray[z]>=500){
                            if (rocketGroup.getRotate() == 0) {
                                if (rocketGroup.getBoundsInParent().intersects(obstacles[z].getBoundsInParent())) {
                                    
                                        crashAndComeBack(true, false, false, false);
                                    removeFromLife(obstacles[z].getCoi());
                                    
                                    
                                }

                            } else {
                                double xLeftCoordObstacle = obstacles[z].getTranslateX() + obstacles[z].getLayoutX();
                            double yTopCoordObstacle = obstacles[z].getTranslateY() + obstacles[z].getLayoutY();
                            if (xCoord < xLeftCoordObstacle + obstacles[z].getWidth() - 20 && xCoord > xLeftCoordObstacle + 15 && yCoord < yTopCoordObstacle + obstacles[z].getHeight() && yCoord > yTopCoordObstacle) {
                                boolean top = true;
                                boolean bottom = true;
                                boolean left = true;
                                boolean right = true;
              

                                for (int q = 0; q < newXArray.length; q++) {
                                    double xCoordOther = newXArray[q] + centerX;
                                    double yCoordOther = newYArray[q] + centerY;
                                    if (xCoord > xCoordOther) {
                                        left = false;

                                    } else if (xCoord < xCoordOther) {
                                        right = false;

                                    } else if (yCoord < yCoordOther) {
                                        bottom = false;

                                    } else {
                                        top = false;
                                    }

                                }

                                crashAndComeBack(top, right, bottom, left);
                                removeFromLife(obstacles[z].getCoi());
                            }
                            }
                            }
                        }

                        //check stars collisions
                        for (int v = 0; v < stars.length; v++) {
                            double xLeftCoordStar = stars[v].getTranslateX() + stars[v].getLayoutX()-10;
                            double yTopCoordStar = stars[v].getTranslateY() + stars[v].getLayoutY()-10;
                            if (xCoord < xLeftCoordStar+20 && xCoord > xLeftCoordStar - 50 && yCoord > yTopCoordStar - stars[v].getRadiusY() - 20 && yCoord < yTopCoordStar + 40) {
                                if (stars[v].visibleProperty().get() == true) {
                                    try {
                                        caughtStar(v);
                                    } catch (IOException ex) {
                                        Logger.getLogger(Level.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                                    }
                                }

                            }

                        }

                    }

                }

            }
        };

    }

    public String getBackgroundImg() {
        return backgroundImgLink;
    }

    public void setBackgroundImg(String backgroundImg) {
        this.backgroundImgLink = backgroundImg;
    }

    public String getFloorImg() {
        return floorImgLink;
    }

    public void setFloorImg(String floorImg) {
        this.floorImgLink = floorImg;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getGravity() {
        return gravity;
    }

    public void setGravity(double game) {
        this.gravity = game;
    }

    public Obstacle[] getObstacles() {
        return obstacles;
    }

    public void setObstacles(Obstacle[] obstacles) {
        this.obstacles = obstacles;
    }

    public void readOrders(ArrayList<Orders> x) {

        //read orders of timeline
        //reset rocket to initial state
        resetRocket();
        theOrdersList = x;

        //read each order
        for (int i = 0; i < x.size(); i++) {
            Orders theBlock = x.get(i);

            //check classname of block if rot, wait,acc; 
            //so, grosso modo, it checks classes, calculate final x and y, and angle, according to gravity, adds in keyframe, adds keyframe in timeline, adds timeline in sequential transition
            switch (theBlock.getClass().getName()) {
                case "project_relocation.Acceleration":
                    //basics physics shit 
                    double currentTranslateX = rocketGroup.getPosX();
                    double currentTranslateY = rocketGroup.getPosY();

                    Timeline accelerateTimeline = new Timeline();
                    double accelerationValue = ((Acceleration) (theBlock)).getAcceleration();
                    double accXValue = accelerationValue * Math.cos(rocketGroup.getAngle() * Math.PI / 180);
                    double accYValue = (accelerationValue * Math.sin(rocketGroup.getAngle() * Math.PI / 180)) - gravity;

                    double accelerationTime = ((Acceleration) (theBlock)).getDuration();
                    double finalX = currentTranslateX + (0.5 * accelerationTime * accelerationTime * accXValue);
                    double finalY = currentTranslateY + (-0.5 * accelerationTime * accelerationTime * accYValue);
                    rocketGroup.setPosY(finalY);
                    rocketGroup.setPosX(finalX);

                    KeyFrame move = new KeyFrame(javafx.util.Duration.millis(accelerationTime * 1000),
                            new KeyValue(rocketGroup.translateYProperty(), finalY),
                            new KeyValue(rocketGroup.translateXProperty(), finalX));
                    accelerateTimeline.getKeyFrames().add(move);
                    accelerateTimeline.setAutoReverse(false);
                    accelerateTimeline.setCycleCount(1);

                    theTimelineAnimation.getChildren().add(accelerateTimeline);
                    break;

                case "project_relocation.Wait":

                    double currentTranslateForWait = rocketGroup.getPosY();
                    Timeline waitTimeline = new Timeline();

                    double waitValue = ((Wait) (theBlock)).getDuration();

                    double finalYAfterWait = 0;
                    if (currentTranslateForWait != 0) {
                        finalYAfterWait = currentTranslateForWait + (0.5 * waitValue * waitValue * gravity);
                    }

                    KeyFrame wait = new KeyFrame(javafx.util.Duration.millis(waitValue * 1000),
                            new KeyValue(rocketGroup.translateYProperty(), finalYAfterWait));
                    waitTimeline.getKeyFrames().add(wait);
                    waitTimeline.setAutoReverse(false);
                    waitTimeline.setCycleCount(1);
                    rocketGroup.setPosY(finalYAfterWait);
                    theTimelineAnimation.getChildren().add(waitTimeline);
                    break;

                case "project_relocation.Rotation":

                    double currentTranslateForRot = rocketGroup.getPosY();
                    Timeline rotationTimeline = new Timeline();

                    double rotationValue = ((Rotation) (theBlock)).getAngle();

                    double actualAngle = rocketGroup.getAngle();
                    double finalAngle = actualAngle + rotationValue;
                    rocketGroup.setAngle(finalAngle);
                    double finalYAfterRotation = 0;
                    if (currentTranslateForRot != 0) {
                        finalYAfterRotation = currentTranslateForRot + (0.5 * 2 * 2 * gravity);
                    }

                    KeyFrame rotate = new KeyFrame(javafx.util.Duration.millis(2000),
                            new KeyValue(rocketGroup.translateYProperty(), finalYAfterRotation),
                            new KeyValue(rocketGroup.rotateProperty(), -finalAngle + 90));
                    rotationTimeline.getKeyFrames().add(rotate);
                    rotationTimeline.setAutoReverse(false);
                    rotationTimeline.setCycleCount(1);

                    theTimelineAnimation.getChildren().add(rotationTimeline);

                    rocketGroup.setPosY(finalYAfterRotation);

                    break;
            }

        }

        //reads timeline
        theTimelineAnimation.play();

        //timeline when finished, if called, means not died, not won, still life left
        theTimelineAnimation.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                theTimelineAnimation.stop();
                timelineIsFinished();
            }

        });

        timer.start();
        lockPlayButton();
    }

    
    
    
    
      public int getLevelNb(){
    return ((myGroup) getParent()).getLevelNb();
    }
    
    
    
    
    
    
    
    
    //level builder with stars, platform, and obstacles
    public void levelBuilder(double gravity, String backgroundImgLink, Obstacle[] obstacles, Platform winPlatform, Star[] stars) {
        //, String platform, String levelName, double gravity, DynamicObject[] dynamicObjs,  
        this.stars = stars;
        this.obstacles = obstacles;
        
        timeSinceCollisionArray = new int[obstacles.length];
        for(int i=0;i<timeSinceCollisionArray.length;i++){
        timeSinceCollisionArray[i] = 500;
        }
        
        
        this.backgroundImgLink = backgroundImgLink;
        //this.floorImgLink = floorImgLink;
        this.gravity = (double) Math.round((Math.pow(gravity, 1.5)) * 100) / 100;
        

        
        lvl.setText("Level " + ((GameUI)this.getParent()).getLevelNb() + " | Gravity: " + this.gravity);
        Image backgroundImage = new Image(this.backgroundImgLink, levelWidth, levelHeight, false, false);
        ImageView backgroundImageView = new ImageView(backgroundImage);
        backgroundImageView.setLayoutX(0);
        backgroundImageView.setLayoutY(0);

//        Image floorImage = new Image(this.floorImgLink, levelWidth, 50, false, false);
//        ImageView floorImageView = new ImageView(floorImage);
//        floorImageView.setLayoutX(0);
//        floorImageView.setLayoutY(levelHeight - 50);

        this.getChildren().add(backgroundImageView);

//        this.getChildren().add(floorImageView);
//        floorImageView.toBack();
        backgroundImageView.toBack();

        for (int i = 0; i < this.obstacles.length; i++) {
            this.getChildren().add(this.obstacles[i]);

        }
        for (int i = 0; i < this.stars.length; i++) {
            this.getChildren().add(this.stars[i]);
        }
        platformY = winPlatform.getLayoutY();
        this.platform = winPlatform;
        this.getChildren().add(platform);
        platform.toFront();

    }

    //crashed and some life left + if during timeline, animation to move away from obstacle
    public void crashAndComeBack(boolean top, boolean right, boolean bottom, boolean left) {
if(lifeCap>0){

        SequentialTransition st1 = new SequentialTransition();
        timer.stop();
        theTimelineAnimation.stop();
        Timeline rotationTimeline = new Timeline();

        double finalYAfterRotation = rocketGroup.getTranslateY();
        double finalXAfterRotation = rocketGroup.getTranslateX();
//four different ways to crash 
        if (top) {
            finalYAfterRotation += 100;
        }
        if (bottom) {
            finalYAfterRotation -= 100;

        }
        if (left) {
            finalXAfterRotation += 100;
        }
        if (right) {
            finalXAfterRotation -= 100;
        }

        checkCurrentPositionInTimeline(finalXAfterRotation, finalYAfterRotation, theTimelineAnimation.getCurrentTime());
//grosso modo, create a keyframe, adds in timeline
        KeyFrame rotate = new KeyFrame(javafx.util.Duration.millis(2000),
                new KeyValue(rocketGroup.rotateProperty(), 720),
                new KeyValue(rocketGroup.translateYProperty(), finalYAfterRotation),
                new KeyValue(rocketGroup.translateXProperty(), finalXAfterRotation));

        rotationTimeline.getKeyFrames().add(rotate);
        rotationTimeline.setAutoReverse(false);
        rotationTimeline.setCycleCount(1);
        st1.setCycleCount(1);
        //continue original timeline when this crash animation is done
        st1.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
if(lifeCap>0){
                while (!timelineReadyToRead) {

                }
                theTimelineAnimation.play();
                timer.start();

            }
            }
        });
        st1.getChildren().addAll(rotationTimeline);

        st1.play();
    }else{

theTimelineAnimation.stop();
timer.stop();
}
    }

    //total death no life (hp)
    public void isDead(String deathReason) {
        theTimelineAnimation.stop();
        timer.stop();
        displayLife(0);
        lockPlayButton();
        rocketHasDied = true;
        theTimelineAnimation.stop();
        ((myGroup) getParent()).displayLosePopup(deathReason);

    }

    //landed on platform with some hp left
    public void justWon() throws IOException {
        System.out.println(((myGroup)this.getParent()).getLevelNb());
        if(((myGroup)this.getParent()).getLevelNb()>user.getLevelsCompleted()){
            Project_Relocation.user.setLevelsCompleted(((myGroup)this.getParent()).getLevelNb());
            renderSelectionMenu();
        }
        rocketHasDied = true;
        theTimelineAnimation.stop();
        if(getLevelNb() == 18){
            System.out.println("MARCCCCCCCCCCCCCCCCCCCCCCCCCCCCC");
        ((myGroup) getParent()).displayFinishedGamePopup();
        }else{
        ((myGroup) getParent()).displayWinPopup();
        }
        

    }

//timeline finished, but life left
    public void timelineIsFinished() {
        isDead("The timeline finished"+"\n"+" but you didn't land"+"\n"+" on the platform");
    }

    //check what is current position in timeline reading.
    public void checkCurrentPositionInTimeline(double x, double y, javafx.util.Duration timeSinceStartSequence) {
        double millisSequence = timeSinceStartSequence.toMillis();
        double timeAfterAnim = 0;
        int nextPosInTimeline = 0;
        Marc:
        for (int w = 0; w < theOrdersList.size(); w++) {
            Orders theBlock = theOrdersList.get(w);
            switch (theBlock.getClass().getName()) {
                case "project_relocation.Acceleration":
                    timeAfterAnim += (((Acceleration) (theBlock)).getDuration() * 1000);
                    if (timeAfterAnim > millisSequence) {
                        nextPosInTimeline = w + 1;
                        break Marc;
                    }

                    break;

                case "project_relocation.Wait":

                    timeAfterAnim += (((Wait) (theBlock)).getDuration() * 1000);

                    if (timeAfterAnim > millisSequence) {
                        nextPosInTimeline = w + 1;

                    }
                    break;

                case "project_relocation.Rotation":
                    timeAfterAnim += 2000;
                    if (timeAfterAnim > millisSequence) {
                        nextPosInTimeline = w + 1;

                    }

                    break;
            }

        }

        createNewTimeline(x, y, nextPosInTimeline);

    }

    //creates new timeline to read after crash animation. Starts 1 block after current one
    public void createNewTimeline(double x, double y, int pos) {

        double totalX = 0;
        double totalY = 0;
        double rotateAngle = rocketGroup.getRotate();
        theTimelineAnimation.stop();
        theTimelineAnimation.getChildren().clear();

        for (int w = pos; w < theOrdersList.size(); w++) {
            Orders theBlock = theOrdersList.get(w);
            switch (theBlock.getClass().getName()) {
                case "project_relocation.Acceleration":

                    double currentTranslateX = totalX;
                    double currentTranslateY = totalY;

                    Timeline accelerateTimeline = new Timeline();
                    double accelerationValue = ((Acceleration) (theBlock)).getAcceleration();
                    double accXValue = 0;
                    if (rotateAngle != 90 && rotateAngle != 180) {
                        accXValue = accelerationValue * Math.cos(rocketGroup.getAngle() * Math.PI / 180);
                    }
                    double accYValue = (accelerationValue * Math.sin(rotateAngle * Math.PI / 180)) - gravity;

                    double accelerationTime = ((Acceleration) (theBlock)).getDuration();
                    double finalX = currentTranslateX + (0.5 * accelerationTime * accelerationTime * accXValue);
                    double finalY = currentTranslateY + (-0.5 * accelerationTime * accelerationTime * accYValue);
                    totalY = finalY;
                    totalX = finalX;

                    KeyFrame move = new KeyFrame(javafx.util.Duration.millis(accelerationTime * 1000),
                            new KeyValue(rocketGroup.translateYProperty(), finalY),
                            new KeyValue(rocketGroup.translateXProperty(), finalX));
                    accelerateTimeline.getKeyFrames().add(move);
                    accelerateTimeline.setAutoReverse(false);
                    accelerateTimeline.setCycleCount(1);

                    theTimelineAnimation.getChildren().add(accelerateTimeline);
                    break;

                case "project_relocation.Wait":

                    double currentTranslateForWait = totalY;
                    Timeline waitTimeline = new Timeline();

                    double waitValue = ((Wait) (theBlock)).getDuration();

                    double finalYAfterWait = 0;
                    if (currentTranslateForWait != 0) {
                        finalYAfterWait = currentTranslateForWait + (0.5 * waitValue * waitValue * gravity);
                    }

                    KeyFrame wait = new KeyFrame(javafx.util.Duration.millis(waitValue * 1000),
                            new KeyValue(rocketGroup.translateYProperty(), finalYAfterWait));
                    waitTimeline.getKeyFrames().add(wait);
                    waitTimeline.setAutoReverse(false);
                    waitTimeline.setCycleCount(1);
                    totalY = finalYAfterWait;
                    theTimelineAnimation.getChildren().add(waitTimeline);

                    break;

                case "project_relocation.Rotation":

                    double currentTranslateForRot = totalY;
                    Timeline rotationTimeline = new Timeline();

                    double rotationValue = ((Rotation) (theBlock)).getAngle();

                    double actualAngle = rotateAngle;
                    double finalAngle = actualAngle + rotationValue;

                    rotateAngle = finalAngle;
                    double finalYAfterRotation = 0;
                    if (currentTranslateForRot != 0) {
                        finalYAfterRotation = currentTranslateForRot + (0.5 * 2 * 2 * gravity);
                    }

                    KeyFrame rotate = new KeyFrame(javafx.util.Duration.millis(2000),
                            new KeyValue(rocketGroup.translateYProperty(), finalYAfterRotation),
                            new KeyValue(rocketGroup.rotateProperty(), -finalAngle + 90));
                    rotationTimeline.getKeyFrames().add(rotate);
                    rotationTimeline.setAutoReverse(false);
                    rotationTimeline.setCycleCount(1);

                    theTimelineAnimation.getChildren().add(rotationTimeline);

                    totalY = finalYAfterRotation;

                    break;
            }

        }
        timelineReadyToRead = true;

    }

    //resets the rocket when play button pressed
    public void resetRocket() {
        rocketHasDied = false;
        rocketGroup.setTranslateX(0);
        rocketGroup.setTranslateY(0);
        rocketGroup.setRotate(0);
        rocketGroup.setAngle(90);
        rocketGroup.setPosX(0);
        rocketGroup.setPosY(0);

        theTimelineAnimation.stop();
        theTimelineAnimation.getChildren().clear();
    }

//when star is caught
    public void caughtStar(int v) throws IOException {
        stars[v].setVisible(false);
    Project_Relocation.user.addSpecificStar(getLevelNb(), v+1);
    updateStarString();
        

    }

    public void removeFromLife(double v) {
        
        lifeCap -= v;
        if (lifeCap <= 0) {

            displayLife(0);
            isDead("You have no more life");
        } else {
            displayLife(lifeCap);
        }
        System.out.println("LIIIFe" + lifeCap);
    }

    //render stars every time set scene to level
    public void renderStars() {
    numStars.setText(Integer.toString(Project_Relocation.user.getStars()));
        int[] starsList = Project_Relocation.user.getLevelStars(((myGroup)this.getParent()).getLevelNb());
    for(int i=0;i<starsList.length;i++){
    if(starsList[i]==1){
    stars[i].setVisible(false);
    }else{
        stars[i].setVisible(true);
    }
    
    }
    }

    public void resetLife() {
        lifeCap = Project_Relocation.user.getProtection();
        displayLife(lifeCap);
        System.out.print("LIIIIIIFE"+lifeCap);
    }

    public void resetFuel() {
        fuelCap = Project_Relocation.user.getFuelCapacity();
        displayFuel(fuelCap);
    }

    public void removeFuel() {
        fuelCap -= 0.1;
        if (fuelCap <= 0) {
            displayFuel(0);
            isDead("You have no more fuel");
        } else {
            displayFuel(fuelCap);
        }
        System.out.println("FUELELLELELEL"+fuelCap);
    }

    public void displayLife(double x) {
        lifeLabel.setText(Double.toString(x));
    }

    public void displayFuel(double x) {
        double rectRatio = x/Project_Relocation.user.getFuelCapacity();
        fuelRectangle.setWidth(fuelDefaultWidth*rectRatio);
    }
    public void restartLevel() {
        timer.stop();
        resetFuel();
        resetLife();
        renderStars();
//        clearTimelineBlocs();
        resetRocket();
        unlockPlayButton();
        ((myGroup) getParent()).hidePopups();
    }

    public void lockPlayButton() {
        ((myGroup) getParent()).lockPlayButton();
    }

    public void unlockPlayButton() {
        ((myGroup) getParent()).unlockPlayButton();
    }
    public void clearTimelineBlocs() {
        ((myGroup) getParent()).clearTimelineBlocs();
    }
  
    
    public void updateStarString(){
    String stars = Integer.toString(user.getStars());
                      numStars.setText(stars);
    }
    
    public void addOneFrameToTimer(){
    for(int i =0;i<timeSinceCollisionArray.length;i++){
    timeSinceCollisionArray[i]+=1;
    }
    }
}
