/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project_relocation;

import javafx.scene.Group;

/**
 *
 * @author Marc
 */
public class myGroup extends Group{
    myGroup(){
    
    }
    
    public void scrollBlocs(double value){
    ((GameUI)getParent()).scrollBlocs(value);
    }
    public void sendOrderToTimeline(Orders order, double x, double y){
    ((GameUI)getParent()).sendOrderToTimeline(order, x, y);
    }
    public void removeOrder(int x){
    ((GameUI)getParent()).removeOrder(x);
    }   
    public int getLevelNb(){
    return ((GameUI)getParent()).getLevelNb();

    }
    public void displayLosePopup(String deathReason){
    ((GameUI) getParent()).displayLosePopup(deathReason);
    }
    public void displayWinPopup(){
    ((GameUI) getParent()).displayWinPopup();
    }
    public void showArrows(boolean val){
    ((GameUI)getParent()).showArrows(val);
    }
    public void showArrowRight(boolean val){
    ((GameUI)getParent()).showArrowRight(val);
    }
    public void showArrowLeft(boolean val){
    ((GameUI)getParent()).showArrowLeft(val);
    }
    
    public void unlockPlayButton(){
    
    ((GameUI)getParent()).unlockPlayButton();
    }
        public void lockPlayButton(){
    
    ((GameUI)getParent()).lockPlayButton();
    }
        
        public void hidePopups(){
        ((GameUI)getParent()).hidePopups();
        }
        
        public void clearTimelineBlocs(){
        ((GameUI)getParent()).clearTimelineBlocs();
        }
        public void displayFinishedGamePopup(){
        ((GameUI) getParent()).displayFinishedGamePopup();
        }
}
