package com.airplane.demo.entities;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

import java.text.SimpleDateFormat;

public class escale {
    private SimpleStringProperty idEscale;

    private SimpleStringProperty nomAeroport;
    private SimpleStringProperty heureDepart;
    private SimpleStringProperty heurArriver;

    private SimpleIntegerProperty vol;




    public String getIdEscale() {
        return idEscale.get();
    }

    public SimpleStringProperty idEscaleProperty() {
        return idEscale;
    }

    public void setIdEscale(String idEscale) {
        this.idEscale.set(idEscale);
    }

    public escale(String nomAeroport, String heureDepart, String heurArriver, int vol) {
        this.nomAeroport = new SimpleStringProperty(nomAeroport);
        this.heureDepart = new SimpleStringProperty(heureDepart);
        this.heurArriver = new SimpleStringProperty(heurArriver);
        this.vol = new SimpleIntegerProperty(vol);
    }

    public String getNomAeroport() {
        return nomAeroport.get();
    }

    public SimpleStringProperty nomAeroportProperty() {
        return nomAeroport;
    }

    public void setNomAeroport(String nomAeroport) {
        this.nomAeroport.set(nomAeroport);
    }

    public String getHeureDepart() {
        return heureDepart.get();
    }

    public SimpleStringProperty heureDepartProperty() {
        return heureDepart;
    }

    public void setHeureDepart(String heureDepart) {
        this.heureDepart.set(heureDepart);
    }

    public String getHeurArriver() {
        return heurArriver.get();
    }

    public SimpleStringProperty heurArriverProperty() {
        return heurArriver;
    }

    public void setHeurArriver(String heurArriver) {
        this.heurArriver.set(heurArriver);
    }

}
