package ui;

import backend.BinaryOperations;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;

public class Controller {
    @FXML
    Label display;

    private String userInput = "";
    private String operation = "";
    private String storedInput = "";
    private boolean isResult = false;
    private boolean isBinary = true;

    @FXML
    private void handleToggleButton() {
        try {
            if (isResult == true) {
                if (isBinary == true) {
                    display.setText(Integer.toString(BinaryOperations.BinaryToDecimal((int) Long.parseLong(userInput))));
                    isBinary = false;
                } else {
                    display.setText(userInput);
                    isBinary = true;
                }
            }
        }catch (Exception e){
            infoBox("Number to big", "Error", null);
        }

    }

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
        isResult = false;
        display.setText("");
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
    private void handleSubButton(){
        if (userInput != "" && storedInput == "") {
            updateOperation("-");
        } else if (userInput == "" && storedInput != "" && operation != ""){
            operation = "-";
            display.setText(storedInput + " " + operation);
        }
    }

    @FXML
    private void handleMultiButton(){
        if (userInput != "" && storedInput == "") {
            updateOperation("*");
        } else if (userInput == "" && storedInput != "" && operation != ""){
            operation = "*";
            display.setText(storedInput + " " + operation);
        }
    }

    @FXML
    private void handleSqrButton() {
        try {
            if (userInput != "" && storedInput == "" && operation == "") {
                int num = Integer.parseInt(userInput, 2);
                int result = 0;
                result = BinaryOperations.sqrt(num);
                display.setText(Integer.toBinaryString(result));
                userInput = Integer.toBinaryString(result);
                isResult = true;
            }
        }catch (Exception e){
            infoBox("Number to big", "Error", null);
        }
    }

    @FXML
    private void handlePowButton() {
        try {
            if (userInput != "" && storedInput == "" && operation == "") {
                int num = Integer.parseInt(userInput, 2);
                int result = 0;
                result = BinaryOperations.Multiply(num, num);
                display.setText(Integer.toBinaryString(result));
                userInput = Integer.toBinaryString(result);
                isResult = true;
            }
        }catch (Exception e){
            infoBox("Number to big", "Error", null);
        }
    }

    @FXML
    private void handleEqual() {
        if(userInput != "" && storedInput != "" && operation != "") {
            try {
                int one = Integer.parseInt(storedInput, 2);
                int two = Integer.parseInt(userInput, 2);
                int result = 0;
                switch (operation) {
                    case "+":
                        result = BinaryOperations.Add(one, two);
                        break;
                    case "/":
                        result = BinaryOperations.Divide(one, two);
                        break;
                    case "-":
                        result = BinaryOperations.Subtract(one, two);
                        break;
                    case "*":
                        result = BinaryOperations.Multiply(one, two);
                        break;
                }
                display.setText(Integer.toBinaryString(result));
                storedInput = "";
                operation = "";
                userInput = Integer.toBinaryString(result);
                isResult = true;
            } catch (Exception e) {
                infoBox("Number to big", "Error", null);
            }
        }
    }

    private void updateDisplay(String input){
         userInput = userInput + input;
         display.setText(storedInput + " " + operation + " " + userInput);
    }

    private void updateOperation(String newOperation) {
        if(userInput != ""){
            isResult = false;
            storedInput = userInput;
            userInput = "";
            operation = newOperation;
            display.setText(storedInput + " " + operation);
        }
    }

    public static void infoBox(String infoMessage, String titleBar, String headerMessage)
    {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titleBar);
        alert.setHeaderText(headerMessage);
        alert.setContentText(infoMessage);
        alert.showAndWait();
    }

}
