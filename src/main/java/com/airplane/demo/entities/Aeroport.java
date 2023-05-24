package com.airplane.demo.entities;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Aeroport {

    private SimpleIntegerProperty idAeroport;
    private SimpleStringProperty nomAeroport;
    private SimpleStringProperty villeAeroport;

    public Aeroport(int idAeroport, String nomAeroport, String villeAeroport) {
        this.idAeroport = new SimpleIntegerProperty(idAeroport);
        this.nomAeroport = new SimpleStringProperty(nomAeroport);
        this.villeAeroport = new SimpleStringProperty(villeAeroport);
    }


    public int getIdAeroport() {
        return idAeroport.get();
    }

    public SimpleIntegerProperty idAeroportProperty() {
        return idAeroport;
    }

    public void setIdAeroport(int idAeroport) {
        this.idAeroport.set(idAeroport);
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

    public String getVilleAeroport() {
        return villeAeroport.get();
    }

    public SimpleStringProperty villeAeroportProperty() {
        return villeAeroport;
    }

    public void setVilleAeroport(String villeAeroport) {
        this.villeAeroport.set(villeAeroport);
    }

    @Override
    public String toString() {
        return nomAeroport.get();

    }
}
