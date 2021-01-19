/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 *
 * @author Marks
 */
@Entity
public class Weather implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String LocationName;
    private double temperature;
    private String skyText;
    private int humidity;
    private String windText;
    @OneToOne(mappedBy="weather",cascade = CascadeType.PERSIST)
    private Aktiviteter aktiviteter;
    
    public Weather() {
    }

    
    
    public Weather(String locationName, double temperature, String skyText, int humidity, String windText) {
        this.LocationName = locationName;
        this.temperature = temperature;
        this.skyText = skyText;
        this.humidity = humidity;
        this.windText = windText;
    }


    public Weather(String LocationName){
        this.LocationName = LocationName;
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

    public Aktiviteter getAktiviteter() {
        return aktiviteter;
    }

    public void setAktiviteter(Aktiviteter aktiviteter) {
        this.aktiviteter = aktiviteter;
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
