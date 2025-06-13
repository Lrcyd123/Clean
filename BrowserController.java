package com.example;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.web.WebView;
import javafx.scene.web.WebEngine;
import javafx.event.ActionEvent;

public class BrowserController {
    @FXML
    private TextField urlField;
    @FXML
    private WebView webView;

    @FXML
    private void handleGo(ActionEvent event) {
        String url = urlField.getText();
        if (url == null || url.isEmpty()) {
            return;
        }
        if (!url.startsWith("http://") && !url.startsWith("https://")) {
            url = "http://" + url;
        }
        WebEngine engine = webView.getEngine();
        engine.load(url);
    }
}
