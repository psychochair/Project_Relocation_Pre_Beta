/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project_relocation;

import java.util.ArrayList;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author sandr
 */
public class TimelineOrders extends Pane {

    private ArrayList<Orders> ordersList = new ArrayList<Orders>();

    public TimelineOrders() {

        //SET WIDTH AND HEIGHT TIMELINE
        this.setMinWidth(Project_Relocation.sceneWidth - 120);
        this.setMaxWidth(Project_Relocation.sceneWidth - 120);
        this.setMinHeight(120);
        this.setMaxHeight(120);
        this.setLayoutX(0);
        this.setLayoutY(Project_Relocation.sceneHeight - 120);

        //STYLE OF TIMELINE
        this.setStyle("-fx-background-color: #fff;-fx-border-width: 2;"
                + "-fx-border-radius: 5;"
                + "-fx-border-color: black;");
        this.setTranslateX(0);

    }

    public void scrollBlocs(double xvalue) {
        if (!ordersList.isEmpty()) {

            if (xvalue > 0) {
                if (ordersList.get(0).getTranslateX() < 5) {

                    for (int i = 0; i < ordersList.size(); i++) {

                        ordersList.get(i).setTranslateX(ordersList.get(i).getTranslateX() + xvalue);
                    }
                }
            } else {
                if (ordersList.get(ordersList.size() - 1).getTranslateX() >= Project_Relocation.sceneWidth - 300) {

                    for (int i = 0; i < ordersList.size(); i++) {

                        ordersList.get(i).setTranslateX(ordersList.get(i).getTranslateX() + xvalue);

                    }

                }

            }
            makeInvisible();

        }

    }

    public ArrayList<Orders> getOrders() {
        return ordersList;
    }

    public void addOrder(Orders order, double positionX, double positionY) {

        if (ordersList.isEmpty()) {
            order.setTranslateX(80);
            order.setTranslateY(0 - order.getLayoutY() + Project_Relocation.sceneHeight - 120 + (60 - order.getHeight() / 2));
            ordersList.add(order);

        } else {

            double blockPositionX = order.getTranslateX();
            boolean isAlreadyAdded = false;
            for (int i = 0; i < ordersList.size(); i++) {
                double timelineX = ordersList.get(i).getTranslateX();
                if (blockPositionX < timelineX && !isAlreadyAdded) {
                    ordersList.get(i).setTranslateX(timelineX);
                    order.setTranslateX(timelineX);
                    ordersList.add(i, order);
                    ordersList.get(i).setPositionInTimeline(i + 1);
                    order.positionInTimeline = i;
                    isAlreadyAdded = true;
                    order.setTranslateY(-order.getLayoutY() + Project_Relocation.sceneHeight - 60 - (order.getHeight() / 2));
                } else {
                    if (isAlreadyAdded) {
                        ordersList.get(i).setTranslateX(timelineX + 120);
                        ordersList.get(i).setPositionInTimeline(i);

                    }

                }

            }
            if (!isAlreadyAdded) {
                order.setTranslateY(-order.getLayoutY() + Project_Relocation.sceneHeight - 60 - (order.getHeight() / 2));
                order.setTranslateX(ordersList.get(ordersList.size() - 1).getTranslateX() + 120);
                ordersList.add(order);
                order.positionInTimeline = ordersList.size() - 1;
            }

        }

        makeInvisible();

    }

    public void modifyOrder(Orders[] orders) {

    }

    public void swapOrder(Orders[] orders) {

    }

    public void removeOrder(int x) {
        ordersList.remove(x);
        if (x != ordersList.size()) {
            boolean reachedX = false;
            for (int i = 0; i < ordersList.size(); i++) {

                ordersList.get(i).setPositionInTimeline(i);

                if (i == x) {
                    reachedX = true;
                }
                if (reachedX) {
                    ordersList.get(i).setTranslateX(ordersList.get(i).getTranslateX() - 120);
                }

            }
        }

        makeInvisible();
    }

    public double getWidthTimeline() {

        return this.getWidth();
    }

    public void makeInvisible() {
        for (int i = 0; i < ordersList.size(); i++) {
            if (ordersList.get(i).getTranslateX() + ordersList.get(i).getWidth() >= Project_Relocation.sceneWidth - 200 || ordersList.get(i).getTranslateX() < 0) {
                ordersList.get(i).setVisible(false);
            } else {
                ordersList.get(i).setVisible(true);

            }

        }
        if (ordersList.size() > 8) {
            if (ordersList.get(ordersList.size() - 1).getTranslateX() + ordersList.get(ordersList.size() - 1).getWidth() >= Project_Relocation.sceneWidth - 200) {
                ((myGroup) getParent()).showArrowRight(true);
                System.out.println("HNE1 ");
            } else {
                ((myGroup) getParent()).showArrowRight(false);
            }
            if (ordersList.get(0).getTranslateX() < 0) {

                ((myGroup) getParent()).showArrowLeft(true);
                System.out.println("HNENUS2 ");
            } else {
                ((myGroup) getParent()).showArrowLeft(false);

            }

        } else {

            ((myGroup) getParent()).showArrows(false);
        }
    }

}
