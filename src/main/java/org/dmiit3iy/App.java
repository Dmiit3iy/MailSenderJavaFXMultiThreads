package org.dmiit3iy;

import javafx.application.Application;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.WindowEvent;
import org.dmiit3iy.controllers.MainController;
import org.dmiit3iy.service.MailService;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
//        scene = new Scene(loadFXML("main"), 640, 480);
//        stage.setScene(scene);
//        stage.show();
//        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
//            public void handle(WindowEvent event) {
//
//                System.out.println("Stage is closing");
//            }
//        });


        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("main" + ".fxml"));


        Parent root = fxmlLoader.load();
        scene = new Scene(root, 640, 480);
      stage.setScene(scene);
        stage.show();



        MainController controller = fxmlLoader.getController();

        stage.setOnCloseRequest(controller.getCloseEventHandler());




    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

    public static void showMessage(String title, String message, Alert.AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }


}