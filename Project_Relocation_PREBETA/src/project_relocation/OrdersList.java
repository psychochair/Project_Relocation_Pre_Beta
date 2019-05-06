/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project_relocation;

import java.util.ArrayList;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;

/**
 *
 * @author Marc
 */
public class OrdersList extends GridPane {

    
    //groups for the arrows in timeline
    Group leftArrowGroup = new Group();
    Group rightArrowGroup = new Group();
    //arrows in timeline
Polygon rightTriangle = new Polygon();
Polygon leftTriangle = new Polygon();


    public OrdersList() {
leftArrowGroup.setVisible(false);
rightArrowGroup.setVisible(false);
        //build the trianges for arrows in timeline
        leftTriangle.getPoints().setAll(new Double[]{
            30.0, 20.0,
            30.0, 60.0,
            60.0, 40.0}
        );
        
        rightTriangle.getPoints().setAll(new Double[]{
            60.0, 20.0,
            60.0, 60.0,
            30.0, 40.0}
        );
        leftTriangle.setFill(Color.BLACK);
        rightTriangle.setFill(Color.BLACK);

        leftArrowGroup.setTranslateX(10);
        leftArrowGroup.setTranslateY(Project_Relocation.sceneHeight - 110);
        leftArrowGroup.getChildren().addAll(rightTriangle);
        leftArrowGroup.setOnMouseClicked(new EventHandler<MouseEvent>() {
            
            
            //swcrolls the timeline orders when arrow click
            public void handle(MouseEvent event) {
                scrollBlocs(120);
            }

        });
        this.add(leftArrowGroup, 0, 0);

        rightArrowGroup.setTranslateX(Project_Relocation.sceneWidth - 175);
        rightArrowGroup.setTranslateY(Project_Relocation.sceneHeight - 110);
        rightArrowGroup.getChildren().addAll(leftTriangle);
        rightArrowGroup.setOnMouseClicked(new EventHandler<MouseEvent>() {

            
         //swcrolls the timeline orders when arrow click
            public void handle(MouseEvent event) {
                scrollBlocs(-120);
            }

        });
        this.add(rightArrowGroup, 0, 0);

        this.setMaxWidth(120);
        this.setMinWidth(120);
        this.setMinHeight(Project_Relocation.sceneHeight - 120);
        this.setStyle("-fx-background-color: #fff;-fx-border-width: 2;"
                + "-fx-border-radius: 5;"
                + "-fx-border-color: black;");

        this.setLayoutX(0);
        this.setLayoutY(0);

//CREATE THE 3 BLOCKS for acc, rot and wait
        Acceleration AccBlock = new Acceleration();
        Wait WaitBlock = new Wait();
        Rotation RotBlock = new Rotation();

        this.add(AccBlock, 0, 0);
        add(WaitBlock, 0, 1);
        add(RotBlock, 0, 2);
       

    }

    //creates new block when old block is dragged in timeline
    public void newBlock(Orders x, int row) {
        add(x, 0, row);
    }

    //when block deleted from orderslist
    public void deleteOrder(Orders x) {
        this.getChildren().remove(x);
    }

    //receives scroll order
    public void scrollBlocs(double xvalue) {

        ((myGroup)getParent()).scrollBlocs(xvalue);
    }

    //adds the order values to the arraylist timeline
    public void sendOrderToTimeline(Orders order, double x, double y) {
        ((myGroup) getParent()).sendOrderToTimeline(order, x, y);

    }
    
    //shows arrows when block overlap bounds
    public void showArrows(boolean value){
    rightArrowGroup.setVisible(value);
    leftArrowGroup.setVisible(value);
            
    }
    public void showArrowLeft(boolean value){
    leftArrowGroup.setVisible(value);      
    }
    public void showArrowRight(boolean value){
    rightArrowGroup.setVisible(value);      
    }
    
    
    
        //when block deleted from timeline

    public void removeOrder(int x){
    ((myGroup)getParent()).removeOrder(x);
    }
    
    public void clearTimelineBlocs(){
    
        getChildren().clear();
        
        Acceleration AccBlock = new Acceleration();
        Wait WaitBlock = new Wait();
        Rotation RotBlock = new Rotation();

        add(AccBlock, 0, 0);
        add(WaitBlock, 0, 1);
        add(RotBlock, 0, 2);
        
    }
}
