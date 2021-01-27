package GUI;

import GUI.CONTROLLER.MainViewController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main extends Application {
    private Stage primaryStage;

    @Override
    public void start(Stage primaryStage) throws Exception {
        System.out.printf("%-30s%s%n", LocalDateTime.now( ), " Initialized");
        this.primaryStage=primaryStage;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("View.fxml"));
        Parent root = loader.load();
        MainViewController mainViewController=loader.getController();
        mainViewController.setMain(this);
        primaryStage.initStyle(StageStyle.TRANSPARENT);
        primaryStage.setTitle("Private Movie Collection");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public static void main(String[] args) {launch(args);}

}
