package org.dmiit3iy.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.WindowEvent;
import org.dmiit3iy.App;

import org.dmiit3iy.model.Mail;
import org.dmiit3iy.service.MailService;
import org.dmiit3iy.util.Utils;

import java.util.ArrayList;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.stream.Collectors;

public class MainController {
    @FXML
    public TextField emailTextField;
    @FXML
    public TextArea letterTextArea;
    @FXML
    public TextField titleTextField;
    @FXML
    public ListView<String> listViewEmails;
    public Button sendMailButton1;

    private ArrayList<String> emails = new ArrayList<>();
    private MailService mailService = new MailService();

    /**
     * Метод добавления email в список отправки
     */
    @FXML
    private javafx.scene.control.Button closeButton;

    @FXML
    public void addEmailButton(ActionEvent actionEvent) {
        String email = emailTextField.getText();
        if (Utils.isEmail(email)) {
            emails.add(email);
            ObservableList<String> observableList = FXCollections.observableArrayList(emails);
            //  listViewEmails=new ListView<String>(observableList);
            listViewEmails.setItems(observableList);

            //TODO тут добавить в список LIstView

        } else App.showMessage("Ошибка", "Введите email в формате username@domain.com", Alert.AlertType.ERROR);
        emailTextField.clear();
    }

    @FXML
    public void sendMailButton(ActionEvent actionEvent) {
        if ((!titleTextField.getText().isBlank()) && (!letterTextArea.getText().isBlank())) {
            ArrayList<String> list = (ArrayList<String>) listViewEmails.getItems().stream().collect(Collectors.toList());
            //System.out.println(list);
            Mail mail = new Mail(titleTextField.getText(), letterTextArea.getText(), list);
            mailService.add(mail);
        } else {
            App.showMessage("Ошибка", "Заполните все поля пред отправкой", Alert.AlertType.INFORMATION);
        }
        titleTextField.clear();
        letterTextArea.clear();
    }


    public void clearEmailsButton(ActionEvent actionEvent) {
        listViewEmails.getItems().clear();
    }

    private javafx.event.EventHandler<WindowEvent> closeEventHandler = new javafx.event.EventHandler<WindowEvent>() {
        @Override
        public void handle(WindowEvent event) {
            mailService.stop();
        }
    };

    public javafx.event.EventHandler<WindowEvent> getCloseEventHandler() {
        return closeEventHandler;
    }

}
