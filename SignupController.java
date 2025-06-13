package com.example;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;

public class SignupController {
    @FXML
    private TextField signupUsernameField;
    @FXML
    private PasswordField signupPasswordField;

    @FXML
    private void handleSignup(ActionEvent event) {
        String newUsername = signupUsernameField.getText();
        String newPassword = signupPasswordField.getText();

        if (newUsername == null || newUsername.isEmpty() || newPassword == null || newPassword.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Sign Up");
            alert.setHeaderText(null);
            alert.setContentText("Username and password cannot be empty.");
            alert.showAndWait();
            return;
        }

        try {
            File file = new File("users.txt");
            FileWriter writer = new FileWriter(file, true); // append mode
            writer.write(newUsername + "," + newPassword + System.lineSeparator());
            writer.close();

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Sign Up");
            alert.setHeaderText(null);
            alert.setContentText("Sign up successful!");
            alert.showAndWait();

            // Switch to login scene after successful signup
            try {
                com.example.App.setRoot("loginui");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        } catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Sign Up");
            alert.setHeaderText(null);
            alert.setContentText("Error saving user: " + e.getMessage());
            alert.showAndWait();
        }
    }
}
