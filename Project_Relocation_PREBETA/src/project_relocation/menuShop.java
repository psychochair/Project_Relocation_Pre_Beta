/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project_relocation;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import static project_relocation.Project_Relocation.buttonFontFamily1;
import static project_relocation.Project_Relocation.buttonStyle1;
import static project_relocation.Project_Relocation.buttonStyle2;
import static project_relocation.Project_Relocation.labelStyle1;
import static project_relocation.Project_Relocation.labelStyle2;
import static project_relocation.Project_Relocation.sceneHeight;
import static project_relocation.Project_Relocation.sceneWidth;
import static project_relocation.Project_Relocation.user;

/**
 *
 * @author sandr
 */
public class menuShop extends Pane implements UI {
    
    Label numStars;
    Label fuelLabel;
    Label lifeLabel;
    String stars;
    
    Button fuel1;
    Button fuel2;
    Button fuel3;
    ImageView f1;
    ImageView f2;
    ImageView f3;
    
    Button hP1;
    Button hP2;
    Button hP3;
    ImageView h1;
    ImageView h2;
    ImageView h3;
  
    
    boolean fb1= false;
    boolean fb2= false;
    
    boolean eb1= false;
    boolean eb2= false;
    
    boolean hb1= false;
    boolean hb2= false;
    
    public menuShop(){
        
        
        //Background image
        Image background = new Image("menuShop.png",1300,650,true,true);
        ImageView backgroundView = new ImageView(background);
        
        this.getChildren().add(backgroundView);
        
         //MESSAGE ERROR OF THE ORDER OF UPGRADES
        Text error = new Text("");
        error.setFill(Color.WHITESMOKE);
        error.setStyle("-fx-text-fill: rgb(255, 204, 0); " + 
                 "-fx-font-family: "+buttonFontFamily1+"; " +
                "-fx-font-size: 40px; ");
        error.setLayoutX(470);
        error.setLayoutY(540);
        
        this.getChildren().add(error);
        
        //NUMBERS OF STARS
        HBox hStars = new HBox();
        
        Image image = new Image("starPNG.png");
        ImageView imageS = new ImageView(image);
        imageS.setFitHeight(30);
        imageS.setFitWidth(30);
        
        stars = Integer.toString(user.getStars());
        numStars = new Label(stars);
        numStars.setStyle("-fx-text-fill: rgb(255, 204, 0); " + 
                 "-fx-font-family: "+buttonFontFamily1+"; " +
                "-fx-font-size: 40px; ");
        numStars.setGraphic(imageS);
        numStars.setContentDisplay(ContentDisplay.RIGHT);
        
        hStars.setSpacing(10);
        hStars.getChildren().add((numStars));
        hStars.setLayoutX(70);
        hStars.setLayoutY(140);
        
        this.getChildren().add(hStars);
        
        //NUMBER Fuel
        HBox hFuel = new HBox();
        
        Image imageFuel = new Image("fuel.png");
        ImageView imageViewFuel = new ImageView(imageFuel);
        imageViewFuel.setFitHeight(30);
        imageViewFuel.setFitWidth(30);
        
        fuelLabel= new Label(Integer.toString(Project_Relocation.user.getFuelCapacity()));
        fuelLabel.setStyle("-fx-text-fill: rgb(255, 204, 0); "
                + "-fx-font-family: " + buttonFontFamily1 + "; "
                + "-fx-font-size: 40px; ");
        fuelLabel.setGraphic(imageViewFuel);
        fuelLabel.setContentDisplay(ContentDisplay.RIGHT);
        
        hFuel.setSpacing(10);
        hFuel.getChildren().add((fuelLabel));
        hFuel.setLayoutX(70);
        hFuel.setLayoutY(180);
        
        this.getChildren().add(hFuel);
        
        //life value display
        
        HBox hLife = new HBox();

        Image imageLife = new Image("heart.png");
        ImageView imageViewLife = new ImageView(imageLife);
        imageViewLife.setFitHeight(30);
        imageViewLife.setFitWidth(30);

        lifeLabel= new Label(Integer.toString(Project_Relocation.user.getProtection()));
        lifeLabel.setStyle("-fx-text-fill: rgb(255, 204, 0); "
                + "-fx-font-family: " + buttonFontFamily1 + "; "
                + "-fx-font-size: 40px; ");
        lifeLabel.setGraphic(imageViewLife);
        lifeLabel.setContentDisplay(ContentDisplay.RIGHT);
        
        hLife.setSpacing(10);
        hLife.getChildren().add((lifeLabel));
        hLife.setLayoutX(70);
        hLife.setLayoutY(220);
        
        this.getChildren().add(hLife);

        
        //BACK TO MENU SELECTION
        
        HBox buttonBack = new HBox();
        buttonBack.setLayoutX(160);
        buttonBack.setLayoutY(150);
        Button backMenu = new Button("Back");
        backMenu.setStyle(buttonStyle2);
        buttonBack.getChildren().add(backMenu);
        buttonBack.setAlignment(Pos.BOTTOM_RIGHT);
        
        this.getChildren().add(buttonBack);
        
        backMenu.setOnMouseClicked(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent event) {
                
                try {
                    Project_Relocation.setScene(Project_Relocation.getSelectionMenu());
                } catch (IOException ex) {
                    Logger.getLogger(menuShop.class.getName()).log(Level.SEVERE, null, ex);
                }
               
            }
    });
        //Rectangles= 3 types of Upgrades

        Rectangle rect1 = new Rectangle(900, 200);
        rect1.setFill(Color.TRANSPARENT);
        rect1.setStroke(Color.BLACK);
        
        Rectangle rect2 = new Rectangle(900, 200);
        rect2.setFill(Color.TRANSPARENT);
        rect2.setStroke(Color.BLACK);
        
//        Rectangle rect3 = new Rectangle(900, 200);
//        rect3.setFill(Color.TRANSPARENT);
//        rect3.setStroke(Color.BLACK);
        
        
        VBox rectangle = new VBox();
        rectangle.setLayoutX(300);
        rectangle.setLayoutY(20);
        rectangle.setAlignment(Pos.CENTER_LEFT);
        rectangle.setPadding(new Insets(10, 10, 10, 10));
        
        rectangle.getChildren().addAll(rect1, rect2);
        //rect3
        this.getChildren().add(rectangle);
        
        
        
        //FUEL UPGRADES
        HBox buttonFuel = new HBox();
        buttonFuel.toFront();
        buttonFuel.setSpacing(180);
        buttonFuel.setLayoutX(550);
        buttonFuel.setLayoutY(150);
        
        HBox fuelImage = new HBox();
        fuelImage.setSpacing(50);
        fuelImage.setLayoutX(400);
        fuelImage.setLayoutY(30);
        
        Image imageF1 = new Image("fuel.png",200,300,true,true);
        f1 = new ImageView(imageF1);
        fuel1= new Button("3 stars");
        fuel1.setStyle(buttonStyle2);
        
        Image imageF2 = new Image("fuel.png",200,300,true,true);
        f2 = new ImageView(imageF2);
        fuel2 = new Button("3 stars");
        fuel2.setStyle(buttonStyle2);
        
        Image imageF3 = new Image("fuel.png",200,300,true,true);
        f3 = new ImageView(imageF3);
        fuel3 = new Button("3 stars");
        fuel3.setStyle(buttonStyle2);
        
        buttonFuel.getChildren().addAll(fuel1, fuel2, fuel3);
        fuelImage.getChildren().addAll(f1, f2, f3);
        
        this.getChildren().addAll(fuelImage, buttonFuel);
        
        fuel1.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
              if(user.getStars() >= 3){
                  try {
                      user.setStars(user.getStars() -3);
                      user.setFuelCapacity(user.getFuelCapacity()+25);
                      fuel1.setDisable(true);
                      f1.setOpacity(0.5);
                      fb1= true;
                      error.setText("");
                      stars = Integer.toString(user.getStars());
                      numStars.setText(stars);
                      renderShop();
                        
                  } catch (IOException ex) {
                       error.setText("You do not have enough stars to buy the upgrade!");
                  }
              }
                  else{
                        error.setText("You do not have enough stars to" + "\n" + "buy the upgrade!");  
                          }
                
              
            }
            
        });
        
        fuel2.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                if(fb1== true){
                    if(user.getStars() >= 3){
                  try {
                    user.setStars(user.getStars() -3);
                    user.setFuelCapacity(user.getFuelCapacity()+25);
                    fuel2.setDisable(true);
                    f2.setOpacity(0.5);
                    fb2= true;
                    error.setText("");
                    stars = Integer.toString(user.getStars());
                    numStars.setText(stars);
                    renderShop();
                    
                  } catch (IOException ex) {
                      error.setText("You do not have enough stars to buy the upgrade!");
                  }
                     
                }
                    else{
                        error.setText("You do not have enough stars to" + "\n" + "buy the upgrade!");  
                          }
              }
                else{
                    error.setText("Must buy the upgrades in order!");
                }
            }
           
        });
        
        fuel3.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                if(fb2==true){
                    if(user.getStars() >= 3){
                  try {
                      user.setStars(user.getStars() -3);
                      user.setFuelCapacity(user.getFuelCapacity()+25);
                      fuel3.setDisable(true);
                      f3.setOpacity(0.5);
                      error.setText("");
                      stars = Integer.toString(user.getStars());
                      numStars.setText(stars);
                      renderShop();
                      
                  } catch (IOException ex) {
                      error.setText("You do not have enough stars to buy the upgrade!");
                  }   
              }
                    else{
                        error.setText("You do not have enough stars to" + "\n" + "buy the upgrade!");  
                          }
                }
                else{
                    error.setText("Must buy the upgrades in order!");
                }
                
            }
          
        });
        
//        //ENGINE UPGRADES
//        HBox buttonEngine = new HBox();
//        buttonEngine.toFront();
//        buttonEngine.setSpacing(180);
//        buttonEngine.setLayoutX(550);
//        buttonEngine.setLayoutY(550);
//        
//        HBox engineImage = new HBox();
//        engineImage.setSpacing(50);
//        engineImage.setLayoutX(410);
//        engineImage.setLayoutY(475);
//        
//        Image imageE1 = new Image("boardpng.png",200,300,true,true);
//        ImageView e1 = new ImageView(imageE1);
//        Button engine1 = new Button("3 stars");
//        engine1.setStyle(buttonStyle2);
//        
//        Image imageE2 = new Image("boardpng.png",200,300,true,true);
//        ImageView e2 = new ImageView(imageE2);
//        Button engine2 = new Button("3 stars");
//        engine2.setStyle(buttonStyle2);
//        
//        Image imageE3 = new Image("boardpng.png",200,300,true,true);
//        ImageView e3 = new ImageView(imageE3);
//        Button engine3 = new Button("3 stars");
//        engine3.setStyle(buttonStyle2);
//        
//        buttonEngine.getChildren().addAll(engine1, engine2, engine3);
//        engineImage.getChildren().addAll(e1, e2, e3);
//        
//        this.getChildren().addAll(engineImage, buttonEngine);
//        
//        engine1.setOnAction(new EventHandler<ActionEvent>() {
//            @Override public void handle(ActionEvent e) {
//              if(user.getStars() >= 3){
//                  try {
//                      user.setStars(user.getStars() -3);
//                      engine1.setDisable(true);
//                      e1.setOpacity(0.5);
//                      eb1= true;
//                      error.setText("");
//                      stars = Integer.toString(user.getStars());
//                      numStars.setText(stars);
//                      renderShop();
//                        
//                  } catch (IOException ex) {
//                     error.setText("You do not have enough stars to buy the upgrade!"); 
//                  }
//                
//              }
//              else{
//                        error.setText("You do not have enough stars to" + "\n" + "buy the upgrade!");  
//                          }
//                 
//            }
//            
//        });
//        
//        engine2.setOnAction(new EventHandler<ActionEvent>() {
//            @Override public void handle(ActionEvent e) {
//                if(eb1== true){
//                    if(user.getStars() >= 3){
//                  try {
//                      user.setStars(user.getStars() -3);
//                      engine2.setDisable(true);
//                      e2.setOpacity(0.5);
//                      eb2= true;
//                      error.setText("");
//                      stars = Integer.toString(user.getStars());
//                      numStars.setText(stars);
//                      renderShop();
//                        
//                  } catch (IOException ex) {
//                      error.setText("You do not have enough stars to buy the upgrade!"); 
//                  }
//                    
//                }
//                    else{
//                        error.setText("You do not have enough stars to" + "\n" + "buy the upgrade!");  
//                          }
//              }
//                else{
//                    error.setText("Must buy the upgrades in order!");
//                }
//            }
//                
//        });
//        
//        engine3.setOnAction(new EventHandler<ActionEvent>() {
//            @Override public void handle(ActionEvent e) {
//                if(eb2==true){
//                    if(user.getStars() >= 3){
//                  try {
//                      user.setStars(user.getStars() -3);
//                      engine3.setDisable(true);
//                      e3.setOpacity(0.5);
//                      error.setText("");
//                      stars = Integer.toString(user.getStars());
//                      numStars.setText(stars);
//                      renderShop();
//                        
//                  } catch (IOException ex) {
//                      error.setText("You do not have enough stars to buy the upgrade!"); 
//                  }
//                    
//                }
//                    else{
//                        error.setText("You do not have enough stars to" + "\n" + "buy the upgrade!");  
//                          }
//              } 
//                else{
//                    error.setText("Must buy the upgrades in order!");
//                }
//                
//            }
//        });
        
        //HP UPGRADES
        
        
        HBox buttonHP = new HBox();
        buttonHP.toFront();
        buttonHP.setSpacing(180);
        buttonHP.setLayoutX(550);
        buttonHP.setLayoutY(350);
        
        HBox hPImage = new HBox();
        hPImage.setSpacing(70);
        hPImage.setLayoutX(375);
        hPImage.setLayoutY(240);
        
        Image imageHP1 = new Image("heart.png",200,200,true,true);
        h1 = new ImageView(imageHP1);
        hP1 = new Button("3 stars");
        hP1.setStyle(buttonStyle2);
        
        Image imageHP2 = new Image("heart.png",200,200,true,true);
        h2 = new ImageView(imageHP2);
        hP2 = new Button("3 stars");
        hP2.setStyle(buttonStyle2);
        
        Image imageHP3 = new Image("heart.png",200,200,true,true);
        h3 = new ImageView(imageHP3);
        hP3 = new Button("3 stars");
        hP3.setStyle(buttonStyle2);
        
        buttonHP.getChildren().addAll(hP1, hP2, hP3);
        hPImage.getChildren().addAll(h1, h2, h3);
        
        this.getChildren().addAll(hPImage, buttonHP);
        
        hP1.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                if(user.getStars() >= 3){
                  try {
                      user.setStars(user.getStars() -3);
                      user.setProtection(user.getProtection()+5);
                      hP1.setDisable(true);
                      h1.setOpacity(0.5);
                      hb1= true;
                      error.setText("");
                      stars = Integer.toString(user.getStars());
                      numStars.setText(stars);
                      renderShop();
                        
                  } catch (IOException ex) {
                     error.setText("You do not have enough stars to buy the upgrade!"); 
                  }
                }
                else{
                        error.setText("You do not have enough stars to" + "\n" + "buy the upgrade!");  
                          }
            }
            
        });
        
        hP2.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                if(hb1== true){
                      if(user.getStars() >= 3){
                  try {
                      user.setStars(user.getStars() -3);
                      user.setProtection(user.getProtection()+5);
                      hP2.setDisable(true);
                      h2.setOpacity(0.5);
                      hb2= true;
                      error.setText("");
                      stars = Integer.toString(user.getStars());
                      numStars.setText(stars);
                      renderShop();
                        
                  } catch (IOException ex) {
                      error.setText("You do not have enough stars to buy the upgrade!"); 
                  }
                      }
                      else{
                        error.setText("You do not have enough stars to" + "\n" + "buy the upgrade!");  
                          }
                    
                }
                else{
                    error.setText("Must buy the upgrades in order!");
                }
            }
                
        });
        
        hP3.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                if(hb2==true){
                    if(user.getStars() >= 3){
                  try {
                      user.setStars(user.getStars() -3);
                      user.setProtection(user.getProtection()+5);
                      hP3.setDisable(true);
                      h3.setOpacity(0.5);
                      error.setText("");
                      stars = Integer.toString(user.getStars());
                      numStars.setText(stars);
                      renderShop();
                        
                  } catch (IOException ex) {
                      error.setText("You do not have enough stars to buy the upgrade!"); 
                  }
                    }
                    else{
                        error.setText("You do not have enough stars to" + "\n" + "buy the upgrade!");  
                          }
                }
                else{
                    error.setText("Must buy the upgrades in order!");
                }
                
            }
        });
        
        renderShop();
        
        
    }
    
    public void renderShop(){
        //System.out.print(Project_Relocation.user.getStars());
    numStars.setText(Integer.toString(Project_Relocation.user.getStars()));
    fuelLabel.setText(Integer.toString(Project_Relocation.user.getFuelCapacity()));
    lifeLabel.setText(Integer.toString(Project_Relocation.user.getProtection()));
    
    //CHECK WHAT THE USER HAS
        int fuel= (Project_Relocation.user.getFuelCapacity());
        int life= (Project_Relocation.user.getProtection());
        System.out.println("FUELLLLL " + fuel);
        System.out.println("LIFFEE " + life);
        
        switch (fuel) {
            case 125:
                fuel1.setDisable(true);
                f1.setOpacity(0.5);
                fb1= true;
                break;
            case 150:
                System.out.println("15000000");
                fuel1.setDisable(true);
                f1.setOpacity(0.5);
                fb1= true;
                fuel2.setDisable(true);
                f2.setOpacity(0.5);
                fb2= true;
                break;
            case 175:
                fuel1.setDisable(true);
                f1.setOpacity(0.5);
                fb1= true;
                fuel2.setDisable(true);
                f2.setOpacity(0.5);
                fb2= true;
                fuel3.setDisable(true);
                f3.setOpacity(0.5);
                break;
            default:
                break;
        }
        
        switch (life) {
            case 15:
                hP1.setDisable(true);
                h1.setOpacity(0.5);
                hb1= true;
                break;
            case 20:
                System.out.println("222000000 ");
                hP1.setDisable(true);
                h1.setOpacity(0.5);
                hb1= true;
                hP2.setDisable(true);
                h2.setOpacity(0.5);
                hb2= true;
                break;
            case 25:
                hP1.setDisable(true);
                h1.setOpacity(0.5);
                hb1= true;
                hP2.setDisable(true);
                h2.setOpacity(0.5);
                hb2= true;
                hP3.setDisable(true);
                h3.setOpacity(0.5);
                break;
            default:
                break;
        }
        }
    }
    

