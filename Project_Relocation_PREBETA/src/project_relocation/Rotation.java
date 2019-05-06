/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project_relocation;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;

/**
 *
 * @author Marc
 */
public class Rotation extends Orders {

    private double angle = 0;

    public Rotation() {
        Label l1 = new Label("Rotation");

        TextField tf1 = new TextField();
        tf1.setPromptText("Angle (degrees)");
        this.getChildren().addAll(l1, tf1);

        tf1.focusedProperty().addListener((ov, oldV, newV) -> {
            if (!newV) {

                try {

                    this.setAngle(Double.parseDouble(tf1.getText()));

                } catch (NumberFormatException ex) {
                    tf1.setText("No Result");
                }

            }
        });

    }

    public double getAngle() {
        return angle;
    }

    public void setAngle(double x) {
        angle = x;
    }
}
