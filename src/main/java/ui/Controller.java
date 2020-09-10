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


    BinaryOperations BinOp;

    private ArrayList<Integer> inputs = new ArrayList<>();
    private String userInput = "";
    private String operation = "";
    private String storedInput = "";

    @FXML
    private void handle1Button() {
        updateDisplay("1");
    }
    @FXML
    private void handle0Button() {
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
        updateOperation("+");
    }

    @FXML
    private void handleToggle() {
    }


    private void updateDisplay(String input){
         userInput = userInput + input;
         display.setText(storedInput + " " + operation + " " + userInput);
    }

    private void updateOperation(String newOperation) {
        storedInput = userInput;
        userInput = "";
        operation = newOperation;

    }

}
