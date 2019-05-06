/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project_relocation;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author sandr
 */
public class Platform extends Rectangle{
    Image platformImage = new Image("platformPNG.png", false);
    ImagePattern iPattern = new ImagePattern(platformImage);
    private double width = 130;
    private double height = 20;
    private double posX;
    private double posY;
    
    public Platform(double x, double y){
 
 super(x, y, 130, 20);
 this.setFill(iPattern);
 

    }
}
