package com.example.csclab2;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.Group;
import javafx.scene.layout.VBox;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        //Make our labels and put them in a VBox
        Label air = new Label("Annual Interest Rate:");
        Label noy = new Label("Number of Years:");
        Label la = new Label("Loan Amount:");
        Label mp = new Label("Monthly Payment");
        Label tp = new Label("Total Payment");

        VBox labelsBox = new VBox(16);
        labelsBox.getChildren().addAll(air, noy, la, mp, tp);

        //Make our text fields and put them in a VBox
        TextField airIn = new TextField();
        TextField noyIn = new TextField();
        TextField laIn = new TextField();
        TextField mpOut = new TextField();
        TextField tpOut = new TextField();

        VBox textFieldBox = new VBox(8);
        textFieldBox.getChildren().addAll(airIn, noyIn, laIn, mpOut, tpOut);
        textFieldBox.setLayoutX(150);

        //Make our button
        Button calcButton = new Button("Calculate");
        calcButton.setLayoutX(150);
        calcButton.setLayoutY(180);

        //Lump all of the items into a group
        Group grp = new Group(labelsBox, textFieldBox, calcButton);
        //Add our function for the button (I didn't know how to get a function outside of here to acknowledge the variables in the start function.)
        calcButton.setOnAction(e->{
            double annualInterestRate = Double.parseDouble(airIn.getText());
            int numberOfYears = Integer.parseInt(noyIn.getText());
            int loanAmount = Integer.parseInt(laIn.getText());
            double monthly = annualInterestRate/1200;
            double monthlyPayment = loanAmount * monthly /
                    (1 - 1 / Math.pow(1 + monthly, numberOfYears * 12));
            mpOut.setText("$" + String.valueOf(monthlyPayment));
            double totalPayment = monthlyPayment * 12 * numberOfYears;
            tpOut.setText("$" + String.valueOf(totalPayment));
        });
        //Set up the scene using the group.
        Scene scene = new Scene(grp, 320, 240);

        stage.setTitle("LoanCalculator");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}