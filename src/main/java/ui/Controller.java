package ui;

import backend.BinaryOperations;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

import static javafx.application.Platform.exit;

public class Controller {
    @FXML
    Label display;

    private ArrayList<Integer> inputs = new ArrayList<>();
    private String userInput = "";
    private String operation = "";
    private String storedInput = "";
    private boolean isResult = false;

    @FXML
    private void handle1Button() {
        if (isResult == false)
            updateDisplay("1");
    }
    @FXML
    private void handle0Button() {
        if (isResult == false)
            updateDisplay("0");
    }
    @FXML
    private void handleClearButton() {
        userInput = "";
        storedInput = "";
        operation = "";
        updateDisplay("");
    }
    @FXML
    private void handleAddButton() {
        if (userInput != "" && storedInput == "") {
            updateOperation("+");
        } else if (userInput == "" && storedInput != "" && operation != ""){
            operation = "+";
            display.setText(storedInput + " " + operation);
        }
    }
    @FXML
    private void handleDivButton() {
        if (userInput != "" && storedInput == "") {
            updateOperation("/");
        } else if (userInput == "" && storedInput != "" && operation != ""){
            operation = "/";
            display.setText(storedInput + " " + operation);
        }
    }
    @FXML
    private void handleSqrButton() {
        /*if (userInput != "" && storedInput == "" && operation == "");
        int num = Integer.parseInt(userInput, 2);
        int result = 0;
        BinaryOperations.sqrt(num);
        display.setText("0b" + Integer.toBinaryString(result));
        userInput = Integer.toBinaryString(result);
        isResult = true;*/
    }

    @FXML
    private void handleEqual() {
        int one = Integer.parseInt(storedInput, 2);
        int two = Integer.parseInt(userInput, 2);
        System.out.println(one);
        System.out.println(two);
        int result = 0;
        switch (operation) {
            case "+":
                result = BinaryOperations.Add(one, two);
                break;
            case "/":
                result = BinaryOperations.Divide(one, two);
                break;
        }
        display.setText("0b" + Integer.toBinaryString(result));
        storedInput = "";
        operation = "";
        userInput = Integer.toBinaryString(result);
        isResult = true;
    }

    private void updateDisplay(String input){
         userInput = userInput + input;
         display.setText(storedInput + " " + operation + " " + userInput);
    }

    private void updateOperation(String newOperation) {
        isResult = false;
        storedInput = userInput;
        userInput = "";
        operation = newOperation;
        display.setText(storedInput + " " + operation);

    }

}
