
package dto;

import entities.CityInfo;


public class CityInfoDTO {
    
    private String name;
    private String municipality;
    private int population;
    
    public CityInfoDTO(){
        
    }

    public CityInfoDTO(CityInfo cinfo) {
        this.name = cinfo.getName();
        this.municipality = cinfo.getMunicipality();
        this.population = cinfo.getPopulation();
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
    
    
}
