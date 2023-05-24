package com.airplane.demo.entities;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class personne {

    private SimpleStringProperty idPersonne;
    private SimpleStringProperty nom;
    private SimpleStringProperty prenom;
    private SimpleStringProperty email;
    private SimpleStringProperty password;
    private SimpleStringProperty role;
    private SimpleStringProperty numTel;
    private SimpleStringProperty adresse;
    private SimpleIntegerProperty idVol;
    public personne(String nom, String prenom, String email, String password, String role, String numTel, String adresse, int idVol) {
        this.nom = new SimpleStringProperty(nom);
        this.prenom = new SimpleStringProperty(prenom);
        this.email = new SimpleStringProperty(email);
        this.password = new SimpleStringProperty(password);
        this.role = new SimpleStringProperty(role);
        this.numTel = new SimpleStringProperty(numTel);
        this.adresse = new SimpleStringProperty(adresse);
        this.idVol = new SimpleIntegerProperty(idVol);
    }

    public String getIdPersonne() {
        return idPersonne.get();
    }

    public SimpleStringProperty idPersonneProperty() {
        return idPersonne;
    }

    public void setIdPersonne(String idPersonne) {
        this.idPersonne.set(idPersonne);
    }

    public String getNom() {
        return nom.get();
    }

    public SimpleStringProperty nomProperty() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom.set(nom);
    }

    public String getPrenom() {
        return prenom.get();
    }

    public SimpleStringProperty prenomProperty() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom.set(prenom);
    }

    public String getEmail() {
        return email.get();
    }

    public SimpleStringProperty emailProperty() {
        return email;
    }

    public void setEmail(String email) {
        this.email.set(email);
    }

    public String getPassword() {
        return password.get();
    }

    public SimpleStringProperty passwordProperty() {
        return password;
    }

    public void setPassword(String password) {
        this.password.set(password);
    }

    public String getRole() {
        return role.get();
    }

    public SimpleStringProperty roleProperty() {
        return role;
    }

    public void setRole(String role) {
        this.role.set(role);
    }

    public String getNumTel() {
        return numTel.get();
    }

    public SimpleStringProperty numTelProperty() {
        return numTel;
    }

    public void setNumTel(String numTel) {
        this.numTel.set(numTel);
    }

    public String getAdresse() {
        return adresse.get();
    }

    public SimpleStringProperty adresseProperty() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse.set(adresse);
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
}
