package com.airplane.demo.entities;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

public class Vol {
    private SimpleIntegerProperty idVol;
    private SimpleStringProperty aerropDepart;
    private SimpleStringProperty aeroportArrivee;
    private SimpleStringProperty heureDepart;
    private SimpleStringProperty heureArrivee;
    private SimpleStringProperty dateDepart;
    private SimpleStringProperty dateArrivee;


    private ArrayList<escale> escales;

    private SimpleStringProperty Etat;

    public Vol(int idVol, String aerropDepart, String aeroportArrivee, String heureDepart, String heureArrivee, String dateDepart, String dateArrivee,String Etat) {
        this.idVol = new SimpleIntegerProperty(idVol);
        this.aerropDepart = new SimpleStringProperty(aerropDepart);
        this.aeroportArrivee = new SimpleStringProperty(aeroportArrivee);
        this.heureDepart = new SimpleStringProperty(heureDepart);
        this.heureArrivee = new SimpleStringProperty(heureArrivee);
        this.dateDepart = new SimpleStringProperty(dateDepart);
        this.dateArrivee = new SimpleStringProperty(dateArrivee);
        this.Etat = new SimpleStringProperty(Etat);

    }



    public int getIdVol() {
        return idVol.get();
    }

    public SimpleIntegerProperty idVolProperty() {
        return idVol;
    }

    public void setIdVol(int idVol) {
        this.idVol.set(idVol);
    }

    public String getAerropDepart() {
        return aerropDepart.get();
    }

    public SimpleStringProperty aerropDepartProperty() {
        return aerropDepart;
    }

    public SimpleStringProperty dateDepartProperty() {
        return dateDepart;
    }

    public SimpleStringProperty dateArriveeProperty() {
        return dateArrivee;
    }

    public void setAerropDepart(String aerropDepart) {
        this.aerropDepart.set(aerropDepart);
    }

    public String getAeroportArrivee() {
        return aeroportArrivee.get();
    }

    public SimpleStringProperty aeroportArriveeProperty() {
        return aeroportArrivee;
    }

    public void setAeroportArrivee(String aeroportArrivee) {
        this.aeroportArrivee.set(aeroportArrivee);
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

    public String getHeureArrivee() {
        return heureArrivee.get();
    }

    public SimpleStringProperty heureArriveeProperty() {
        return heureArrivee;
    }

    public void setHeureArrivee(String heureArrivee) {
        this.heureArrivee.set(heureArrivee);
    }

    public SimpleStringProperty getDateDepartProperty() {
        return dateDepart;
    }

    public void setDateDepart(SimpleStringProperty dateDepart) {
        this.dateDepart = dateDepart;
    }

    public SimpleStringProperty getDateArriveeProperty() {
        return dateArrivee;
    }

    public void setDateArrivee(SimpleStringProperty dateArrivee) {
        this.dateArrivee = dateArrivee;
    }

    public ArrayList<escale> getEscales() {
        return escales;
    }

    public void setEscales(ArrayList<escale> escales) {
        this.escales = escales;
    }

    public String getEtat() {
        return Etat.get();
    }

    public SimpleStringProperty etatProperty() {
        return Etat;
    }

    public void setEtat(SimpleStringProperty etat) {
        Etat = etat;
    }
}
