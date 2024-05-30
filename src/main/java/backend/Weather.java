package backend;

import java.io.Serializable;
import java.util.Random;

public class Weather implements Serializable {

    public enum WeatherType {
        SUNNY, RAINY, WINDY, NONE
    }

    private WeatherType currentWeather;

    public Weather() {
        this.currentWeather = WeatherType.NONE;
    }

    public void setWeather(WeatherType weather) {
        this.currentWeather = weather;
    }

    public WeatherType getCurrentWeather() {
        return currentWeather;
    }

    public void randomizeWeather() {
        Random random = new Random();
        int randomNumber = random.nextInt(4); // Generate a random number between 0 and 2

        // Map the random number to a weather type
        switch (randomNumber) {
            case 0:
                currentWeather = WeatherType.SUNNY;
                break;
            case 1:
                currentWeather = WeatherType.RAINY;
                break;
            case 2:
                currentWeather = WeatherType.WINDY;
                break;
            case 3:
                currentWeather = WeatherType.NONE;
        }
    }
}
