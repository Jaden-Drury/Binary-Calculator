package ui;

import backend.BinaryOperations;
import javafx.fxml.FXML;
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
       /* if (isResult == true){
            if(isBinary == true){
                display.setText(BinaryOperations.toDecimal(Integer.parseInt(userInput, 2)));
                isBinary = false;
            }else{
                display.setText(userInput);
                isBinary = true;
            }
        } */

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
        /*if (userInput != "" && storedInput == "" && operation == "");
        int num = Integer.parseInt(userInput, 2);
        int result = 0;
        BinaryOperations.sqrt(num);
        display.setText("0b" + Integer.toBinaryString(result));
        userInput = Integer.toBinaryString(result);
        isResult = true;*/
    }

    @FXML
    private void handlePowButton() {
        /*if (userInput != "" && storedInput == "" && operation == "");
        int num = Integer.parseInt(userInput, 2);
        int result = 0;
        BinaryOperations.pow(num);
        display.setText("0b" + Integer.toBinaryString(result));
        userInput = Integer.toBinaryString(result);
        isResult = true;*/
    }

    @FXML
    private void handleEqual() {
        if(userInput != "" && storedInput != "" && operation != ""){
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
        }
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
