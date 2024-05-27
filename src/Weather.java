public class Weather {
    
    public enum WeatherType {
        SUNNY, RAINY, SANDSTORM, HAIL, SNOW, WINDY, NONE
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
        
}

