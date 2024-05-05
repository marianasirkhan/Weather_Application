package app;

import java.util.Random;

public class WeatherDay {
    Random rand = new Random();
    public int day, month;
    public String dayOfWeek, dayOfWeekCut;
    public int temperature, minTemperature, maxTemperature;
    public int wind, humidity, pressure, indexUv;
    public String description;
    public String walkingText, drivingText, pollenText;
    public String picture;

    public WeatherDay(int day, int month, int dayOfWeek) {
        setDate(day, month, dayOfWeek);
        generateWeather();
    }

    public void setDate(int day, int month, int dayOfWeek) {
        this.day = day;
        this.month = month;
        switch (dayOfWeek) {
            case 1 -> {
                this.dayOfWeek = "Poniedziałek";
                dayOfWeekCut = "pon.";
            }
            case 2 -> {
                this.dayOfWeek = "Wtorek";
                dayOfWeekCut = "wt.";
            }
            case 3 -> {
                this.dayOfWeek = "Środa";
                dayOfWeekCut = "śr.";
            }
            case 4 -> {
                this.dayOfWeek = "Czwartek";
                dayOfWeekCut = "czw.";
            }
            case 5 -> {
                this.dayOfWeek = "Piątek";
                dayOfWeekCut = "pt.";
            }
            case 6 -> {
                this.dayOfWeek = "Sobota";
                dayOfWeekCut = "sob.";
            }
            case 7 -> {
                this.dayOfWeek = "Niedziela";
                dayOfWeekCut = "niedz.";
            }
        }
    }

    public void generateWeather() {
        minTemperature = 5 + rand.nextInt(10);
        maxTemperature = 20 + rand.nextInt(10);
        temperature = minTemperature + rand.nextInt(maxTemperature);

        wind = 2 + rand.nextInt(15);
        humidity = rand.nextInt(60);
        pressure = 990 + rand.nextInt(90);
        indexUv = rand.nextInt(10);

        if(humidity > 30) {
            description = "Opady deszczu";
            picture = "/graphics/rainy.png";
            walkingText = "Będzie padać. Warto wziąć ze sobą parasol.";
            drivingText = "Mogą wystąpić utrudnienia spowodowane śliską nawierzchnią.";
            pollenText = "Stężenie pyłków będzie niewielkie.";
        }
        else {
            if(temperature < 10) {
                description = "Zachmurzenie całkowite";
                picture = "/graphics/cloudy-day.png";
                walkingText = "Warto ciepło się ubrać, temperatura będzie niewielka.";
                drivingText = "Brak utrudnień na drogach.";
                pollenText = "Stężenie pyłków będzie niewielkie.";
            }
            else if (temperature < 20) {
                description = "Częściowo słonecznie";
                picture = "/graphics/sunny.png";
                walkingText = "Będzie umiarkowanie ciepło";
                drivingText = "Brak utrudnień na drogach.";
                pollenText = "Stężenie pyłków będzie umiarkowane.";
            }
            else {
                description = "Słonecznie";
                picture = "/graphics/very-sunny.png";
                walkingText = "Będzie bardzo ciepło, warto wziąć ze sobą wodę";
                drivingText = "Brak utrudnień na drogach.";
                pollenText = "Stężenie pyłków będzie wysokie.";
            }
        }
    }

    public void setTitle(String value) {
        dayOfWeek = value;
    }
}
