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
public class Level_18 extends GameUI{
    
    Level levelUI=new Level();
     
    public Level_18(){
//level number
        this.levelNb = 18;

        this.getChildren().add(levelUI);
        
        //adds the win and lose popup
        this.addPopup(2);

        //level design with obstacles and objects
        Star star1 = new Star(new double[]{150, 150});
        Star star2 = new Star(new double[]{125, 650});
        Star star3 = new Star(new double[]{875, 375});
        
        Platform platform = new Platform(900, 450);
        Obstacle o1 = new Obstacle(4, new double[]{775, 225}, "boardpng.png");
        Obstacle o4 = new Obstacle(4, new double[]{450, 150}, "boardpng.png");
        Obstacle o2 = new Obstacle(4, new double[]{350, 250}, "bureauPNG.png");
        Obstacle o3 = new Obstacle(4, new double[]{725, 375}, "bureauPNG.png");

        //constructor for the level with objects
        levelUI.levelBuilder(14.798,"planet6.png", new Obstacle[]{o1,o2,o3,o4}, platform, new Star[]{star1,star2,star3});
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