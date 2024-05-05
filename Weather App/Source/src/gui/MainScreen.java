package gui;

import app.WeatherDay;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class MainScreen extends Controller implements Initializable {
    public AnchorPane menuOpened;
    public AnchorPane menuClosed;
    public AnchorPane dayOne;
    public AnchorPane dayTwo;
    public AnchorPane dayThree;
    public AnchorPane dayFour;
    public AnchorPane dayFive;
    public List<WeatherDay> days = new ArrayList<>();
    public AnchorPane walkingPane;
    public AnchorPane drivingPane;
    public AnchorPane pollenPane;
    public Label dayBigLabel;
    public Label dateLabel;
    public Label maxMinTemperatureLabel;
    public Label windLabel;
    public Label humidityLabel;
    public Label pressureLabel;
    public Label indexUvLabel;
    public Label dayOneDateLabel;
    public Label dayOneWeatherLabel;
    public Label dayTwoDateLabel;
    public Label dayTwoWeatherLabel;
    public Label dayThreeDateLabel;
    public Label dayThreeWeatherLabel;
    public Label dayFourDateLabel;
    public Label dayFourWeatherLabel;
    public Label dayFiveDateLabel;
    public Label dayFiveWeatherLabel;
    public Label temperatureLabel;
    public Label descriptionLabel;
    public Label walkingLabel;
    public Label drivingLabel;
    public Label pollenLabel;
    public ImageView dayOnePicture;
    public ImageView dayTwoPicture;
    public ImageView dayThreePicture;
    public ImageView dayFourPicture;
    public ImageView dayFivePicture;
    public ImageView bigPicture;
    public Button button;
    public Label cityLabel;

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

    public void resetDays() {
        dayOne.setStyle("-fx-background-color: #e2e2e2; -fx-background-radius: 15;");
        dayTwo.setStyle("-fx-background-color: #e2e2e2; -fx-background-radius: 15;");
        dayThree.setStyle("-fx-background-color: #e2e2e2; -fx-background-radius: 15;");
        dayFour.setStyle("-fx-background-color: #e2e2e2; -fx-background-radius: 15;");
        dayFive.setStyle("-fx-background-color: #e2e2e2; -fx-background-radius: 15;");
    }
    public void dayOnePressed() {
        resetDays();
        dayOne.setStyle("-fx-background-color: #20b7d8; -fx-background-radius: 15;");
        setWeather(0);
    }

    public void dayTwoPressed() {
        resetDays();
        dayTwo.setStyle("-fx-background-color: #20b7d8; -fx-background-radius: 15;");
        setWeather(1);
    }

    public void dayThreePressed() {
        resetDays();
        dayThree.setStyle("-fx-background-color: #20b7d8; -fx-background-radius: 15;");
        setWeather(2);
    }

    public void dayFourPressed() {
        resetDays();
        dayFour.setStyle("-fx-background-color: #20b7d8; -fx-background-radius: 15;");
        setWeather(3);
    }

    public void dayFivePressed() {
        resetDays();
        dayFive.setStyle("-fx-background-color: #20b7d8; -fx-background-radius: 15;");
        setWeather(4);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        LocalDate date = LocalDate.now();
        days.clear();
        for(int i = 0; i < 5; i++) {
            days.add(new WeatherDay(date.getDayOfMonth(), date.getMonth().getValue(), date.getDayOfWeek().getValue()));
            date = date.plusDays(1);
        }
        days.get(0).setTitle("Dzisiaj");
        days.get(1).setTitle("Jutro");
        cityLabel.setText(getLocalization());
        setWeather(0);
        setTips();
        setSimplifiedWeather();
    }

    public void setTips() {
        walkingPane.setVisible(walking);
        if(driving) {
            if(walking)
                drivingPane.setLayoutY(195);
            else
                drivingPane.setLayoutY(80);
            drivingPane.setVisible(true);
        } else
            drivingPane.setVisible(false);
        if(pollen) {
            if(walking && driving)
                pollenPane.setLayoutY(310);
            else if (!walking && !driving)
                pollenPane.setLayoutY(80);
            else
                pollenPane.setLayoutY(195);
            pollenPane.setVisible(true);
        } else
            pollenPane.setVisible(false);
    }

    public void setSimplifiedWeather() {
        String[] date = new String[5];
        String[] temperature = new String[5];
        Image[] image = new Image[5];
        for(int i = 0; i < 5; i++) {
            date[i] = days.get(i).dayOfWeekCut + " " + days.get(i).day + "." + days.get(i).month;
            temperature[i] = days.get(i).temperature + "°\n" + days.get(i).description;
            image[i] = new Image(days.get(i).picture);
        }
        dayOneDateLabel.setText(date[0]);
        dayOnePicture.setImage(image[0]);
        dayOneWeatherLabel.setText(temperature[0]);
        dayTwoDateLabel.setText(date[1]);
        dayTwoPicture.setImage(image[1]);
        dayTwoWeatherLabel.setText(temperature[1]);
        dayThreeDateLabel.setText(date[2]);
        dayThreePicture.setImage(image[2]);
        dayThreeWeatherLabel.setText(temperature[2]);
        dayFourDateLabel.setText(date[3]);
        dayFourPicture.setImage(image[3]);
        dayFourWeatherLabel.setText(temperature[3]);
        dayFiveDateLabel.setText(date[4]);
        dayFivePicture.setImage(image[4]);
        dayFiveWeatherLabel.setText(temperature[4]);
    }

    public void setWeather(int dayIndex) {
        WeatherDay day = days.get(dayIndex);

        walkingLabel.setText(day.walkingText);
        drivingLabel.setText(day.drivingText);
        pollenLabel.setText(day.pollenText);

        dayBigLabel.setText(day.dayOfWeek);
        dateLabel.setText(day.day + "." + day.month);
        bigPicture.setImage(new Image(day.picture));
        temperatureLabel.setText(day.temperature + "°");
        descriptionLabel.setText(day.description);

        maxMinTemperatureLabel.setText(day.maxTemperature + "°/" + day.minTemperature + "°");
        windLabel.setText(day.wind + " km/h");
        humidityLabel.setText(day.humidity + "%");
        pressureLabel.setText(day.pressure + " mbar");
        indexUvLabel.setText(day.indexUv + " z 10");
    }
}
