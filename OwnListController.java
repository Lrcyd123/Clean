package com.example;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;

public class OwnListController {
    @FXML
    private ListView<String> ownListView;
    @FXML
    private TextField addItemField;

    private ObservableList<String> ownItems = FXCollections.observableArrayList();

    @FXML
    private void initialize() {
        ownListView.setItems(ownItems);
    }

    @FXML
    private void handleAdd(ActionEvent event) {
        String item = addItemField.getText();
        if (item != null && !item.trim().isEmpty()) {
            ownItems.add(item.trim());
            addItemField.clear();
        }
    }

    @FXML
    private void handleRemove(ActionEvent event) {
        String selected = ownListView.getSelectionModel().getSelectedItem();
        if (selected != null) {
            ownItems.remove(selected);
        }
    }
}
