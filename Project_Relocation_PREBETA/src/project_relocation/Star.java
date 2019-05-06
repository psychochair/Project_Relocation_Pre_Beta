/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project_relocation;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Ellipse;

/**
 *
 * @author Marc
 */
public class Star extends Ellipse {
    
    private double[] positions;
    private String imageLink= "starPNG.png";
    
    public Star(double[] pos){
        
        
        this.positions = pos;
    
    Image starImage = new Image(imageLink,false);
    
    this.setRadiusX(30);
    this.setRadiusY(30);
      this.setLayoutX(pos[0]);
     this.setLayoutY(pos[1]);
  ImagePattern starPat = new ImagePattern(starImage);
     this.setFill(starPat);
     
     
     
    
    }
    
}
