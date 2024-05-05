package gui;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public abstract class Controller {
    private static String localization = "Kielce";
    public static boolean walking = true, driving = true, pollen = true;

    public void changeScene(Button button, String title, String fxml, int width, int height, Class c) {
        Stage stage = (Stage) button.getScene().getWindow();
        stage.setTitle(title);
        try {
            stage.setScene(new Scene(FXMLLoader.load(Objects.requireNonNull(c.getResource(fxml))), width, height));
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.show();
    }

    public static void setPreferences(boolean isWalking, boolean isDriving, boolean isPollen) {
        walking = isWalking;
        driving = isDriving;
        pollen = isPollen;
    }

    public static void setLocalization(String value) {
        localization = value;
    }

    public static String getLocalization() {
        return localization;
    }
}
