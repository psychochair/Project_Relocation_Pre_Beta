/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project_relocation;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

/**
 *
 * @author sandr
 */
public class Obstacle extends Pane{
    
    private double coi;
    private double[] positions;
    private String imageLink= "";
    
    public Obstacle(){
        
    }
    
    public Obstacle(double coi, double[] pos, String imageLink){
    this.coi = coi;
    this.positions = pos;
    this.imageLink = imageLink;
    
    Image obstacleImage = new Image(imageLink,90,90,true,true);
    ImageView obsImageView = new ImageView(obstacleImage);
    
      obsImageView.setLayoutX(0);
      obsImageView.setLayoutY(0);
      
      this.setLayoutX(pos[0]);
     this.setLayoutY(pos[1]);
//     
//     if(this.imageLink == "alien.png"||this.imageLink == "buildingPNG.png"||this.imageLink == "flagPNG.png"|| this.imageLink == "myshPNG.png"){
//    Ellipse elli = new Ellipse(45,50,45,50);
//    this.getChildren().addAll(obsImageView,elli);
//     }else{
//    Rectangle rect = new Rectangle(0,0,90,90);
//    this.getChildren().addAll(obsImageView, rect);
//     }
this.getChildren().addAll(obsImageView);
    }

    public double getCoi() {
        return coi;
    }

    public void setCoi(double coi) {
        this.coi = coi;
    }

    public double[] getPositions() {
        return positions;
    }

    public void setPositions(double[] positions) {
        this.positions = positions;
    }

    public String getImagelink() {
        return imageLink;
    }

    public void setImagelink(String imagelink) {
        this.imageLink = imagelink;
    }

    
}
