package com.example;

import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

public class BookViewController {

    @FXML
    private TableView<Book> bookTableView;
    @FXML
    private TableColumn<Book, String> titleColumn;
    @FXML
    private TableColumn<Book, String> authorColumn;
    @FXML
    private TableColumn<Book, Integer> yearColumn;

    private ObservableList<Book> bookList = FXCollections.observableArrayList();

    @FXML
    private void initialize() {
        titleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));
        authorColumn.setCellValueFactory(new PropertyValueFactory<>("author"));
        yearColumn.setCellValueFactory(new PropertyValueFactory<>("year"));

        // Example data
        bookList.add(new Book("The Wonderful Wizard of Oz", "\tL. Frank Baum", 1900));
        bookList.add(new Book("The Hunger Games", "Suzanne Collins", 2008));
        bookList.add(new Book("Alice's Adventures in Wonderland", "\tLewis Carroll", 1865));
        bookList.add(new Book("The Subtle Art of Not Giving a Fuck", "Mark Manson", 2016));
        bookList.add(new Book("Anne of Green Gables", "\tLucy Maud Montgomery", 1908));
        bookTableView.setItems(bookList);
    }

    @FXML
    private void handleAdd(ActionEvent event) {
        // TODO: Show dialog to add a new book
        bookList.add(new Book("New Book", "Unknown Author", 2024));
    }

    @FXML
    private void handleEdit(ActionEvent event) {
        // TODO: Implement edit logic
        Book selected = bookTableView.getSelectionModel().getSelectedItem();
        if (selected != null) {
            selected.setTitle(selected.getTitle() + " (Edited)");
            bookTableView.refresh();
        }
    }

    @FXML
    private void handleDelete(ActionEvent event) {
        Book selected = bookTableView.getSelectionModel().getSelectedItem();
        if (selected != null) {
            bookList.remove(selected);
        }
    }

    // Book class for demonstration
    public static class Book {
        private final javafx.beans.property.SimpleStringProperty title;
        private final javafx.beans.property.SimpleStringProperty author;
        private final javafx.beans.property.SimpleIntegerProperty year;

        public Book(String title, String author, int year) {
            this.title = new javafx.beans.property.SimpleStringProperty(title);
            this.author = new javafx.beans.property.SimpleStringProperty(author);
            this.year = new javafx.beans.property.SimpleIntegerProperty(year);
        }

        public String getTitle() { return title.get(); }
        public void setTitle(String value) { title.set(value); }
        public String getAuthor() { return author.get(); }
        public void setAuthor(String value) { author.set(value); }
        public int getYear() { return year.get(); }
        public void setYear(int value) { year.set(value); }
    }
}
