package com.example;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.event.ActionEvent;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;

public class LoginController {
    @FXML
    private TextField usernameField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private TextField signupUsernameField;
    @FXML
    private PasswordField signupPasswordField;

    @FXML
    private void handleLogin(ActionEvent event) {
        String username = usernameField.getText();
        String password = passwordField.getText();

        // Simple login logic example
        if ("user".equals(username) && "pass".equals(password)) {
            System.out.println("Login successful!");
            // Show a success message
            javafx.scene.control.Alert alert = new javafx.scene.control.Alert(javafx.scene.control.Alert.AlertType.INFORMATION);
            alert.setTitle("Login");
            alert.setHeaderText(null);
            alert.setContentText("Login successful!");
            alert.showAndWait();

            // Switch to another scene (e.g., browserui)
            try {
                com.example.App.setRoot("browserui");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Invalid credentials.");
            javafx.scene.control.Alert alert = new javafx.scene.control.Alert(javafx.scene.control.Alert.AlertType.ERROR);
            alert.setTitle("Login");
            alert.setHeaderText(null);
            alert.setContentText("Invalid credentials.");
            alert.showAndWait();
        }
        System.out.println("Login button clicked: " + username + " / " + password);
    }

    @FXML
    private void handleSignup(ActionEvent event) {
        String newUsername = signupUsernameField.getText();
        String newPassword = signupPasswordField.getText();
        // Save user data to a text file
        try {
            File file = new File("users.txt");
            FileWriter writer = new FileWriter(file, true); // append mode
            writer.write(newUsername + "," + newPassword + System.lineSeparator());
            writer.close();
            System.out.println("User signed up and saved: " + newUsername);
        } catch (IOException e) {
            System.out.println("Error saving user: " + e.getMessage());
        }
    }

    @FXML
    private void HandleSignup(ActionEvent event) {
        // TODO: Implement sign up logic or switch to sign up scene
        System.out.println("Sign up button clicked!");
    }
}
