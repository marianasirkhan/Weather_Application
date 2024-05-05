package gui;

import com.jfoenix.controls.JFXComboBox;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ChooseCityScreen extends Controller implements Initializable {
    public JFXComboBox<String> searchbar;
    public TextField searchbarText;
    public AnchorPane confirmAlert;
    public AnchorPane notFoundAlert;
    public Label chosenCity;
    public AnchorPane searchbarScene;
    public AnchorPane mapScene;
    public Button button;
    public AnchorPane menuClosed;
    public AnchorPane menuOpened;
    List<String> cities = new ArrayList<>();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        cities.add("Gdańsk");
        cities.add("Szczecin");
        cities.add("Bydgoszcz");
        cities.add("Białystok");
        cities.add("Poznań");
        cities.add("Warszawa");
        cities.add("Łódź");
        cities.add("Wrocław");
        cities.add("Kielce");
        cities.add("Katowice");
        cities.add("Kraków");
        for(String city: cities)
            searchbar.getItems().add(city);
    }

    public void searchbarClicked() {
        searchbar.show();
    }

    public void searchbarTextChanged() {
        searchbar.getItems().clear();
        for (String city : cities) {
            if (city.contains(searchbarText.getText()))
                searchbar.getItems().add(city);
        }
    }

    public void searchbarOptionClicked() {
        searchbarText.clear();
        try {
            searchbarText.appendText(searchbar.getValue());
        } catch (Exception e) {
            searchbarText.clear();
        }
    }

    public void saveButtonClicked() {
        confirmAlert.setVisible(false);
        notFoundAlert.setVisible(false);
        boolean cityRecognized = false;
        for (String city : cities) {
            if(city.equals(searchbarText.getText())) {
                cityRecognized = true;
                chosenCity.setText(city);
            }
        }
        if(cityRecognized)
            confirmAlert.setVisible(true);
        else
            notFoundAlert.setVisible(true);
    }

    public void alertAccepted() {
        setLocalization(chosenCity.getText());
        openHomeScreen();
    }

    public void alertClosed() {
        confirmAlert.setVisible(false);
        notFoundAlert.setVisible(false);
    }

    public void showSearchbar() {
        searchbarScene.setVisible(true);
        mapScene.setVisible(false);
    }

    public void showMap() {
        searchbarScene.setVisible(false);
        mapScene.setVisible(true);
    }

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

    public void gdanskSelected() {
        confirmAlert.setVisible(true);
        chosenCity.setText("Gdańsk");
    }

    public void szczecinSelected() {
        confirmAlert.setVisible(true);
        chosenCity.setText("Szczecin");
    }

    public void bydgoszczSelected() {
        confirmAlert.setVisible(true);
        chosenCity.setText("Bydgoszcz");
    }

    public void bialystokSelected() {
        confirmAlert.setVisible(true);
        chosenCity.setText("Białystok");
    }

    public void poznanSelected() {
        confirmAlert.setVisible(true);
        chosenCity.setText("Poznań");
    }

    public void warszawaSelected() {
        confirmAlert.setVisible(true);
        chosenCity.setText("Warszawa");
    }

    public void lodzSelected() {
        confirmAlert.setVisible(true);
        chosenCity.setText("Łódź");
    }

    public void wroclawSelected() {
        confirmAlert.setVisible(true);
        chosenCity.setText("Wrocław");
    }

    public void kielceSelected() {
        confirmAlert.setVisible(true);
        chosenCity.setText("Kielce");
    }

    public void katowiceSelected() {
        confirmAlert.setVisible(true);
        chosenCity.setText("Katowice");
    }

    public void krakowSelected() {
        confirmAlert.setVisible(true);
        chosenCity.setText("Kraków");
    }
}
