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
public class Wait extends Orders {

    private double duration = 0;

    public Wait() {
        Label l1 = new Label("Wait");
        TextField tf1 = new TextField();
        tf1.setPromptText("Duration (s)");
        this.getChildren().addAll(l1, tf1);

        tf1.focusedProperty().addListener((ov, oldV, newV) -> {
            if (!newV) {
                try {
                    if (((Double.parseDouble(tf1.getText())) >= 0)) {

                        this.setDuration(Double.parseDouble(tf1.getText()));
                    } else {
                        tf1.setText("0 to 60");
                    }
                } catch (NumberFormatException ex) {
                    tf1.setText("No result");
                }

            }
        });

    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double x) {
        duration = x;
    }

}
