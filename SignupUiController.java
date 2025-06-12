package com.example;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
public class SignupUiController {
     @FXML
    private Button PSUBUTTON;

    @FXML
    private TextField SUEFIELD;

    @FXML
    private Button SULGBTN;

    @FXML
    private PasswordField SUPFIELD;

    @FXML
    private TextField SUUFIELD;

    @FXML
    void HandleLogin(ActionEvent event) throws IOException {
        App.setRoot("loginui");
        

    }
}
