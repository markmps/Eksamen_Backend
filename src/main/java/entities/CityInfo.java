/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author Marks
 */
@Entity
public class CityInfo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    private String municipality;
    private int population;
    @OneToMany(mappedBy = "cityinfo",cascade = CascadeType.PERSIST)
    private List<Aktiviteter> aktiviteter;

    public CityInfo() {
    }

    public CityInfo(String name, String municipality, int population) {
        this.name = name;
        this.municipality = municipality;
        this.population = population;
        this.aktiviteter = new ArrayList<>();
    }

     public void addAktivitet(Aktiviteter atr) {
        if (aktiviteter != null) {
            aktiviteter.add(atr);
        }
    }

    public List<Aktiviteter> getAktiviteter() {
        return aktiviteter;
    }

    public void setAktiviteter(List<Aktiviteter> aktiviteter) {
        this.aktiviteter = aktiviteter;
    }
    
     
     
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getMunicipality() {
        return municipality;
    }

    public void setMunicipality(String municipality) {
        this.municipality = municipality;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }
    
    
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    
}
