package app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Objects;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception{
        Parent login = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("../gui/ChooseCityScreen.fxml")));
        stage.setTitle("Pogoda");
        stage.setScene(new Scene(login, 1280, 720));
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}