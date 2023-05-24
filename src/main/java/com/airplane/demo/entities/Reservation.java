package com.airplane.demo.entities;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Reservation {

    public SimpleIntegerProperty idReservation;
    private SimpleStringProperty nomClient;
    private SimpleStringProperty prenomClient;
    private SimpleStringProperty numPassport;
    private SimpleIntegerProperty numVol;
    private SimpleStringProperty etat;
    public Reservation(Integer id,String nomClient, String prenomClient, String numPassport, int vol, String etat) {
        this.idReservation = new SimpleIntegerProperty(id);

        this.nomClient = new SimpleStringProperty(nomClient);
        this.prenomClient = new SimpleStringProperty(prenomClient);
        this.numPassport = new SimpleStringProperty(numPassport);
        this.numVol = new SimpleIntegerProperty(vol);
        this.etat = new SimpleStringProperty(etat);

    }


    public SimpleIntegerProperty idReservationProperty() {
        return idReservation;
    }
    public void setIdReservation(int idReservation) {
        this.idReservation.set(idReservation);
    }

    public String getNomClient() {
        return nomClient.get();
    }

    public SimpleStringProperty nomClientProperty() {
        return nomClient;
    }

    public void setNomClient(String nomClient) {
        this.nomClient.set(nomClient);
    }

    public String getPrenomClient() {
        return prenomClient.get();
    }

    public SimpleStringProperty prenomClientProperty() {
        return prenomClient;
    }

    public void setPrenomClient(String prenomClient) {
        this.prenomClient.set(prenomClient);
    }

    public String getNumPassport() {
        return numPassport.get();
    }

    public SimpleStringProperty numPassportProperty() {
        return numPassport;
    }

    public void setNumPassport(String numPassport) {
        this.numPassport.set(numPassport);
    }

    public int getNumVol() {
        return numVol.get();
    }

    public SimpleIntegerProperty numVolProperty() {
        return numVol;
    }

    public void setNumVol(int numVol) {
        this.numVol.set(numVol);
    }

    public int getIdReservation() {
        return idReservation.get();
    }

    public String getEtat() {
        return etat.get();
    }

    public SimpleStringProperty etatProperty() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat.set(etat);
    }
}