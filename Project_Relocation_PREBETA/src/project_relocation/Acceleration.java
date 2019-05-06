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
public class Acceleration extends Orders {

    private double accelerationValue = 0;
    private double durationAcceleration = 0;

    public Acceleration() {
        Label l1 = new Label("Acceleration");
        TextField tf1 = new TextField();
        tf1.setPromptText("Acceleration (m/s^2)");
        TextField tf2 = new TextField();
        tf2.setPromptText("Duration (s)");
        this.getChildren().addAll(l1, tf1, tf2);

        tf1.focusedProperty().addListener((ov, oldV, newV) -> {
            if (!newV) {

                try {

                    //DETERMINE ACCELERATION MAX
                    if ((Double.parseDouble(tf1.getText())) >= 0 && (Double.parseDouble(tf1.getText())) <=200) {
                        this.setAcceleration(Double.parseDouble(tf1.getText()));
                    } else {
                        //DETERMINE ACCELERATION MAX
                        tf1.setText("0 to 200");
                    }

                } catch (NumberFormatException ex) {
                    tf1.setText("No Result");
                }

            }
        });

        tf2.focusedProperty().addListener((ov, oldV, newV) -> {
            if (!newV) {

                try {
                    if (((Double.parseDouble(tf2.getText())) >= 0)) {
                        this.setDuration(Double.parseDouble(tf2.getText()));
                    } else {
                        tf2.setText("0 to 60");
                    }

                } catch (NumberFormatException ex) {
                    tf2.setText("No Result");
                }
            }
        });

    }

    public double getAcceleration() {
        return accelerationValue;
    }

    public double getDuration() {
        return durationAcceleration;
    }

    public void setAcceleration(double accelerationValue) {
        this.accelerationValue = accelerationValue;
    }

    public void setDuration(double durationAcceleration) {
        this.durationAcceleration = durationAcceleration;
    }

}
