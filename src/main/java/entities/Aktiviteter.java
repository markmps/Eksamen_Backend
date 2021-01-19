/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;

/**
 *
 * @author Marks
 */
@Entity
public class Aktiviteter implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date aktivitetsDato;
    private String aktivitetsType;
    private String tidpådagen;
    private String tid;
    private String distance;
    private String kommentar;
    @ManyToOne(cascade = CascadeType.PERSIST)
    private User user;
    @ManyToOne(cascade = CascadeType.PERSIST)
    private CityInfo cityinfo;
    @OneToOne(cascade = CascadeType.PERSIST)
    private Weather weather;
    
    public Aktiviteter() {
    }

    public Aktiviteter(String aktivitetsType, String tidpådagen, String tid, String distance, String kommentar, CityInfo cityinfo) {
        this.aktivitetsDato = new Date();
        this.aktivitetsType = aktivitetsType;
        this.tidpådagen = tidpådagen;
        this.tid = tid;
        this.distance = distance;
        this.kommentar = kommentar;
        this.cityinfo = cityinfo;
    }
    
     public Aktiviteter(String aktivitetsType, String tidpådagen, String tid, String distance, String kommentar) {
        this.aktivitetsDato = new Date();
        this.aktivitetsType = aktivitetsType;
        this.tidpådagen = tidpådagen;
        this.tid = tid;
        this.distance = distance;
        this.kommentar = kommentar;
    }

     public void setWeather(Weather weather) {
        this.weather = weather;
        if(weather != null){
            weather.setAktiviteter(this);
        }
    }
    
    public void setCity(CityInfo city) {
        if (cityinfo != null) {
            this.cityinfo = city;
            cityinfo.addAktivitet(this);
        } 
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public CityInfo getCityinfo() {
        return cityinfo;
    }

    public void setCityinfo(CityInfo cityinfo) {
        this.cityinfo = cityinfo;
    }
    
    
    
    public Date getAktivitetsDato() {
        return aktivitetsDato;
    }

    public void setAktivitetsDato(Date aktivitetsDato) {
        this.aktivitetsDato = aktivitetsDato;
    }

    public String getAktivitetsType() {
        return aktivitetsType;
    }

    public void setAktivitetsType(String aktivitetsType) {
        this.aktivitetsType = aktivitetsType;
    }

    public String getTidpådagen() {
        return tidpådagen;
    }

    public void setTidpådagen(String tidpådagen) {
        this.tidpådagen = tidpådagen;
    }

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String getKommentar() {
        return kommentar;
    }

    public void setKommentar(String kommentar) {
        this.kommentar = kommentar;
    }
    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    
    
}
