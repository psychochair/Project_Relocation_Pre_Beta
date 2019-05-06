package project_relocation;

import java.util.ArrayList;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import sun.net.www.content.image.png;

/**
 *
 * @author chasa
 */
public class Level_03 extends GameUI {
//creates the level engine
    Level levelUI = new Level();

    public Level_03() {
        //level number
        this.levelNb = 3;

        this.getChildren().add(levelUI);
        
        //adds the win and lose popup
        this.addPopup(2);

        //level design with obstacles and objects
        Star star1 = new Star(new double[]{235, 300});
        Star star2 = new Star(new double[]{500, 200});
        Star star3 = new Star(new double[]{700, 250});
        
        Platform platform = new Platform(800, 400);
        Obstacle o1 = new Obstacle(4, new double[]{100, 175}, "buildingPNG.png");
        Obstacle o2 = new Obstacle(4, new double[]{100, 325}, "buildingPNG.png");
        Obstacle o3 = new Obstacle(4, new double[]{350, 50}, "mountainPNG.png");
        Obstacle o4 = new Obstacle(4, new double[]{500, 50}, "mountainPNG.png");

        //consyructor for the level with objects
        levelUI.levelBuilder(9.8,"planet1.png", new Obstacle[]{o4,o1,o2,o3}, platform, new Star[]{star1,star2,star3});
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
