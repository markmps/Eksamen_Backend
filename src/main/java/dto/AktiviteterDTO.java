
package dto;

import entities.Aktiviteter;
import java.util.Date;



public class AktiviteterDTO {
    private Date aktivitetsDato;
    private String aktivitetsType;
    private String tidpådagen;
    private String tid;
    private String distance;
    private String kommentar;
    
    public AktiviteterDTO(){
        
    }

    public AktiviteterDTO(Aktiviteter atr) {
        this.aktivitetsDato = atr.getAktivitetsDato();
        this.aktivitetsType = atr.getAktivitetsType();
        this.tidpådagen = atr.getTidpådagen();
        this.tid = atr.getTid();
        this.distance = atr.getDistance();
        this.kommentar = atr.getKommentar();
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
    
    
}
