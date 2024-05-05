package gui;

import com.jfoenix.controls.JFXToggleButton;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class SettingsScreen extends Controller implements Initializable {
    public AnchorPane menuClosed;
    public AnchorPane menuOpened;
    public Label selectedCity;
    public JFXToggleButton walkingToggle;
    public JFXToggleButton ridingToggle;
    public JFXToggleButton pollenToggle;
    public Button button;

    public void openMenu() {
        menuClosed.setVisible(false);
        menuOpened.setVisible(true);
    }

    public void closeMenu() {
        menuOpened.setVisible(false);
        menuClosed.setVisible(true);
    }

    public void openHomeScreen() {
        changeScene(button, "Pogoda", "MainScreen.fxml",1280,720,this.getClass());
    }

    public void openCalendar() {
        changeScene(button, "Pogoda", "LongTermWeatherScreen.fxml",1280,720,this.getClass());
    }

    public void openChooseCityScreen() {
        changeScene(button, "Pogoda", "ChooseCityScreen.fxml",1280,720,this.getClass());
    }

    public void openSettings() {
        changeScene(button, "Pogoda", "SettingsScreen.fxml",1280,720,this.getClass());
    }
    
    public void exitApplication() {
        System.exit(0);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        selectedCity.setText(getLocalization());
        walkingToggle.setSelected(walking);
        ridingToggle.setSelected(driving);
        pollenToggle.setSelected(pollen);
    }

    public void changeLocalization() {
        changeScene(button, "Pogoda", "ChooseCityScreen.fxml",1280,720,this.getClass());
    }

    public void toggleChanged() {
        setPreferences(walkingToggle.isSelected(), ridingToggle.isSelected(), pollenToggle.isSelected());
    }
}
