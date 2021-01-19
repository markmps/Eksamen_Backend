
package dto;

import entities.Weather;


public class WeatherDTO {
    
    private String LocationName;
    private double temperature;
    private String skyText;
    private int humidity;
    private String windText;

    public WeatherDTO() {
    }

    public WeatherDTO(Weather wapi) {
        
        this.LocationName = wapi.getLocationName();
        this.temperature = wapi.getTemperature();
        this.skyText = wapi.getSkyText();
        this.humidity = wapi.getHumidity();
        this.windText = wapi.getWindText();
    }
    

    public String getLocationName() {
        return LocationName;
    }

    public void setLocationName(String locationName) {
        this.LocationName = locationName;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public String getSkyText() {
        return skyText;
    }

    public void setSkyText(String skyText) {
        this.skyText = skyText;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public String getWindText() {
        return windText;
    }

    public void setWindText(String windText) {
        this.windText = windText;
    }

    

    
}
