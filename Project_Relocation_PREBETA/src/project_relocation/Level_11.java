/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project_relocation;

import java.util.ArrayList;
import javafx.collections.ObservableList;
import javafx.scene.Node;

/**
 *
 * @author sandr
 */
public class Level_11 extends GameUI{
    
    Level levelUI=new Level();
     
    public Level_11() {
        //level number
        this.levelNb = 11;

        this.getChildren().add(levelUI);
        
        //adds the win and lose popup
        this.addPopup(2);

        //level design with obstacles and objects
        Star star1 = new Star(new double[]{100, 320});
        Star star2 = new Star(new double[]{140, 205});
        Star star3 = new Star(new double[]{190, 380});
        
        Platform platform = new Platform(150, 440);
        Obstacle o1 = new Obstacle(4, new double[]{400, 300}, "rockPiPNG.png");
        Obstacle o2 = new Obstacle(4, new double[]{230, 250}, "rockPiPNG.png");
        Obstacle o3 = new Obstacle(4, new double[]{350, 100}, "mushPNG.png");
        Obstacle o4 = new Obstacle(4, new double[]{480, 380}, "mushPNG.png");

        //consyructor for the level with objects
        levelUI.levelBuilder(3.1416,"planet4.png", new Obstacle[]{o4,o1,o2,o3}, platform, new Star[]{star1,star2,star3});
        build();
    }
    
    
    
//Get the level number
    public int getLevelNb() {

        return levelNb;
    }
    
    
    
//put all the nodes in a group to put levelUi in the back
    public void build(){
        ObservableList<Node> list = this.getChildren();
       
        myGroup g = new myGroup();
        g.getChildren().addAll(list);
        
        this.getChildren().add(g);
        levelUI.toBack();
    }

    
    
 //method to read orders in timeline   
    public void readOrders(ArrayList<Orders> x) {
        levelUI.readOrders(x);

    }

    
 //method to render the stars every time the level is launched
    public void renderStarsLevel() {
        levelUI.renderStars();

    }
            public void resetLevel(){
    levelUI.restartLevel();
    }
}


