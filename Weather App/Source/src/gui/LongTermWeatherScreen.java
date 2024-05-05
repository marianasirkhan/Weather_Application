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

public class LongTermWeatherScreen extends Controller implements Initializable {
    public Button button;
    public AnchorPane menuClosed;
    public AnchorPane menuOpened;

    public List<WeatherDay> days = new ArrayList<>();

    public Label dayOneDateLabel;
    public Label dayOneWeatherLabel;
    public ImageView dayOnePicture;
    public AnchorPane dayOne;

    public Label dayTwoDateLabel;
    public Label dayTwoWeatherLabel;
    public ImageView dayTwoPicture;
    public AnchorPane dayTwo;

    public Label dayThreeDateLabel;
    public Label dayThreeWeatherLabel;
    public ImageView dayThreePicture;
    public AnchorPane dayThree;

    public Label dayFourDateLabel;
    public Label dayFourWeatherLabel;
    public ImageView dayFourPicture;
    public AnchorPane dayFour;

    public Label dayFiveDateLabel;
    public Label dayFiveWeatherLabel;
    public ImageView dayFivePicture;
    public AnchorPane dayFive;

    public Label daySixDateLabel;
    public Label daySixWeatherLabel;
    public ImageView daySixPicture;
    public AnchorPane daySix;

    public Label daySevenDateLabel;
    public Label daySevenWeatherLabel;
    public ImageView daySevenPicture;
    public AnchorPane daySeven;

    public Label dayOneDateLabel1;
    public Label dayOneWeatherLabel1;
    public ImageView dayOnePicture1;
    public AnchorPane dayOne1;

    public Label dayTwoDateLabel1;
    public Label dayTwoWeatherLabel1;
    public ImageView dayTwoPicture1;
    public AnchorPane dayTwo1;

    public Label dayThreeDateLabel1;
    public Label dayThreeWeatherLabel1;
    public ImageView dayThreePicture1;
    public AnchorPane dayThree1;

    public Label dayFourDateLabel1;
    public Label dayFourWeatherLabel1;
    public ImageView dayFourPicture1;
    public AnchorPane dayFour1;

    public Label dayFiveDateLabel1;
    public Label dayFiveWeatherLabel1;
    public ImageView dayFivePicture1;
    public AnchorPane dayFive1;

    public Label daySixDateLabel1;
    public Label daySixWeatherLabel1;
    public ImageView daySixPicture1;
    public AnchorPane daySix1;

    public Label daySevenDateLabel1;
    public Label daySevenWeatherLabel1;
    public ImageView daySevenPicture1;
    public AnchorPane daySeven1;

    public Label dayOneDateLabel11;
    public Label dayOneWeatherLabel11;
    public ImageView dayOnePicture11;
    public AnchorPane dayOne11;

    public Label dayTwoDateLabel11;
    public Label dayTwoWeatherLabel11;
    public ImageView dayTwoPicture11;
    public AnchorPane dayTwo11;

    public Label dayThreeDateLabel11;
    public Label dayThreeWeatherLabel11;
    public ImageView dayThreePicture11;
    public AnchorPane dayThree11;

    public Label dayFourDateLabel11;
    public Label dayFourWeatherLabel11;
    public ImageView dayFourPicture11;
    public AnchorPane dayFour11;

    public Label dayFiveDateLabel11;
    public Label dayFiveWeatherLabel11;
    public ImageView dayFivePicture11;
    public AnchorPane dayFive11;

    public Label daySixDateLabel11;
    public Label daySixWeatherLabel11;
    public ImageView daySixPicture11;
    public AnchorPane daySix11;

    public Label daySevenDateLabel11;
    public Label daySevenWeatherLabel11;
    public ImageView daySevenPicture11;
    public AnchorPane daySeven11;
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

    public void openChooseCityScreen() {changeScene(button, "Pogoda", "ChooseCityScreen.fxml",1280,720,this.getClass());}

    public void openSettings() {
        changeScene(button, "Pogoda", "SettingsScreen.fxml",1280,720,this.getClass());
    }

    public void exitApplication() {
        System.exit(0);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        LocalDate date = LocalDate.now();
        days.clear();
        for(int i = 0; i < 21; i++) {
            days.add(new WeatherDay(date.getDayOfMonth(), date.getMonth().getValue(), date.getDayOfWeek().getValue()));
            date = date.plusDays(1);
        }
        setWeather();
        cityLabel.setText(getLocalization());
    }

    public void setWeather() {
        String[] date = new String[21];
        String[] temperature = new String[21];
        Image[] image = new Image[21];
        for(int i = 0; i < 21; i++) {
            date[i] = days.get(i).dayOfWeekCut + " " + days.get(i).day + "." + days.get(i).month;
            temperature[i] = days.get(i).temperature + "°\n" + days.get(i).description;
            image[i] = new Image(days.get(i).picture);
        }

        dayOneDateLabel.setText(date[0]);
        dayOneWeatherLabel.setText(temperature[0]);
        dayOnePicture.setImage(image[0]);

        dayTwoDateLabel.setText(date[1]);
        dayTwoWeatherLabel.setText(temperature[1]);
        dayTwoPicture.setImage(image[1]);

        dayThreeDateLabel.setText(date[2]);
        dayThreeWeatherLabel.setText(temperature[2]);
        dayThreePicture.setImage(image[2]);

        dayFourDateLabel.setText(date[3]);
        dayFourWeatherLabel.setText(temperature[3]);
        dayFourPicture.setImage(image[3]);

        dayFiveDateLabel.setText(date[4]);
        dayFiveWeatherLabel.setText(temperature[4]);
        dayFivePicture.setImage(image[4]);

        daySixDateLabel.setText(date[5]);
        daySixWeatherLabel.setText(temperature[5]);
        daySixPicture.setImage(image[5]);

        daySevenDateLabel.setText(date[6]);
        daySevenWeatherLabel.setText(temperature[6]);
        daySevenPicture.setImage(image[6]);

        dayOneDateLabel1.setText(date[7]);
        dayOneWeatherLabel1.setText(temperature[7]);
        dayOnePicture1.setImage(image[7]);

        dayTwoDateLabel1.setText(date[8]);
        dayTwoWeatherLabel1.setText(temperature[8]);
        dayTwoPicture1.setImage(image[8]);

        dayThreeDateLabel1.setText(date[9]);
        dayThreeWeatherLabel1.setText(temperature[9]);
        dayThreePicture1.setImage(image[9]);

        dayFourDateLabel1.setText(date[10]);
        dayFourWeatherLabel1.setText(temperature[10]);
        dayFourPicture1.setImage(image[10]);

        dayFiveDateLabel1.setText(date[11]);
        dayFiveWeatherLabel1.setText(temperature[11]);
        dayFivePicture1.setImage(image[11]);

        daySixDateLabel1.setText(date[12]);
        daySixWeatherLabel1.setText(temperature[12]);
        daySixPicture1.setImage(image[12]);

        daySevenDateLabel1.setText(date[13]);
        daySevenWeatherLabel1.setText(temperature[13]);
        daySevenPicture1.setImage(image[13]);

        dayOneDateLabel11.setText(date[14]);
        dayOneWeatherLabel11.setText(temperature[14]);
        dayOnePicture11.setImage(image[14]);

        dayTwoDateLabel11.setText(date[15]);
        dayTwoWeatherLabel11.setText(temperature[15]);
        dayTwoPicture11.setImage(image[15]);

        dayThreeDateLabel11.setText(date[16]);
        dayThreeWeatherLabel11.setText(temperature[16]);
        dayThreePicture11.setImage(image[16]);

        dayFourDateLabel11.setText(date[17]);
        dayFourWeatherLabel11.setText(temperature[17]);
        dayFourPicture11.setImage(image[17]);

        dayFiveDateLabel11.setText(date[18]);
        dayFiveWeatherLabel11.setText(temperature[18]);
        dayFivePicture11.setImage(image[18]);

        daySixDateLabel11.setText(date[19]);
        daySixWeatherLabel11.setText(temperature[19]);
        daySixPicture11.setImage(image[19]);

        daySevenDateLabel11.setText(date[20]);
        daySevenWeatherLabel11.setText(temperature[20]);
        daySevenPicture11.setImage(image[20]);
    }
}
