package com.airplane.demo;

import com.airplane.demo.entities.Reservation;
import com.airplane.demo.entities.Vol;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class ListeReservationController implements Initializable {

    @FXML
    private TableColumn<Vol, String> ColAA;

    @FXML
    private TableColumn<Reservation, Integer> Idreservation;

    @FXML
    private TableColumn<Vol, String> ColAd;

    @FXML
    private TableColumn<Vol, String> ColDA;

    @FXML
    private TableColumn<Vol, String> ColDD;

    @FXML
    private Button routerSurlesvols;

    @FXML
    private TableColumn<Vol, String> ColHA;

    @FXML
    private TableColumn<Vol, String> ColHD;

    @FXML
    private TableColumn<Reservation, String> EtatReservation;

    @FXML
    private TableColumn<Reservation, String> IdNomClient;

    @FXML
    private TableColumn<Reservation, Integer> IdNumVol;

    @FXML
    private TableColumn<Reservation, String> IdPassport;

    @FXML
    private TableColumn<Reservation, String> IdPrenomClient;

    @FXML
    private TableView<Vol> TablVol;

    @FXML
    private TableColumn<Vol, Integer> colId;

    @FXML
    private TableColumn<Vol, String> etat;

    @FXML
    private TableView<Reservation> tabReservation;

    @FXML
    void lesAeroports(ActionEvent event) {

    }

    @FXML
    void listerLesVols(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("adminPanel.fxml"));
        Parent home = fxmlLoader.load();
        Scene homeScene = new Scene(home, 1500, 800);

        Stage currentStage = (Stage) routerSurlesvols.getScene().getWindow();
        currentStage.setTitle("Home");
        currentStage.setScene(homeScene);
        currentStage.show();

    }

    @FXML
    void listerPassager(ActionEvent event) {

    }

    @FXML
    void listerReservation(ActionEvent event) {

        IdNomClient.setCellValueFactory(cellData -> cellData.getValue().nomClientProperty());
        IdPrenomClient.setCellValueFactory(cellData -> cellData.getValue().prenomClientProperty());
        IdPassport.setCellValueFactory(cellData -> cellData.getValue().numPassportProperty());
        IdNumVol.setCellValueFactory(cellData -> cellData.getValue().numVolProperty().asObject());
        EtatReservation.setCellValueFactory(cellData -> cellData.getValue().etatProperty());
        tabReservation.setItems(getReservation());

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colId.setCellValueFactory(cellData -> cellData.getValue().idVolProperty().asObject());
        ColAd.setCellValueFactory(cellData -> cellData.getValue().aeroportArriveeProperty());
        ColAA.setCellValueFactory(cellData -> cellData.getValue().aerropDepartProperty());
        ColHA.setCellValueFactory(cellData -> cellData.getValue().dateArriveeProperty());
        ColHD.setCellValueFactory(cellData -> cellData.getValue().dateDepartProperty());
        ColDA.setCellValueFactory(cellData -> cellData.getValue().heureArriveeProperty());
        ColDD.setCellValueFactory(cellData -> cellData.getValue().heureDepartProperty());
        etat.setCellValueFactory(cellData -> cellData.getValue().etatProperty());
        TablVol.setItems(getVols());

    }

    private ObservableList<Vol> getVols() {
        ObservableList<Vol> vols = FXCollections.observableArrayList();

        Connection con = Connexion.getConnexionn();
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            statement = con.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM `vol`");
            while (resultSet.next()) {
                int id = resultSet.getInt("idVol");
                String aeroportArriver = resultSet.getString("aeroportArrivee");
                String aeroportDepart = resultSet.getString("aerropDepart");
                String dateArriver = resultSet.getString("dateArrivee");
                String dateDepart = resultSet.getString("dateDepart");
                String heureArriver = resultSet.getString("heureArrivee");
                String heureDepart = resultSet.getString("heureDepart");
                String etat = resultSet.getString("etat");


                Vol vol = new Vol(id, aeroportArriver, aeroportDepart, dateArriver, dateDepart, heureArriver, heureDepart, etat);
                vols.add(vol);

            }


        } catch (Exception e) {
            e.printStackTrace();

        }

        return vols;
    }

    private ObservableList<Reservation> getReservation() {
        ObservableList<Reservation> reservations = FXCollections.observableArrayList();
        if (TablVol.getSelectionModel().getSelectedItem() == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText("Erreur");
            alert.setContentText("Veuillez selectionner un vol");
            alert.showAndWait();
        } else {
            int idVol = TablVol.getSelectionModel().getSelectedItem().getIdVol();


            Connection con = Connexion.getConnexionn();
            Statement statement = null;
            ResultSet resultSet = null;
            try {
                statement = con.createStatement();
                resultSet = statement.executeQuery("SELECT * FROM `reservation` WHERE `numVol` = " + idVol + " and `etat`= 'Confirmer' ");
                while (resultSet.next()) {
                    int id = resultSet.getInt("idReservation");
                    String nomClient = resultSet.getString("nomClient");
                    String prenomClient = resultSet.getString("prenomClient");
                    String numPassport = resultSet.getString("numPassport");
                    int numVol = resultSet.getInt("numVol");
                    String etat = resultSet.getString("etat");
                    Reservation reservation = new Reservation(id, nomClient, prenomClient, numPassport, numVol, etat);
                    reservations.add(reservation);
                }
            } catch (Exception e) {
                e.printStackTrace();

            }
        }
        return reservations;
    }

    @FXML
    public void ListToutLesReservation(ActionEvent event) {
        IdNomClient.setCellValueFactory(cellData -> cellData.getValue().nomClientProperty());
        IdPrenomClient.setCellValueFactory(cellData -> cellData.getValue().prenomClientProperty());
        IdPassport.setCellValueFactory(cellData -> cellData.getValue().numPassportProperty());
        IdNumVol.setCellValueFactory(cellData -> cellData.getValue().numVolProperty().asObject());
        tabReservation.setItems(getToutReservation());
    }

    private ObservableList<Reservation> getToutReservation() {
        ObservableList<Reservation> reservations = FXCollections.observableArrayList();
        Connection con = Connexion.getConnexionn();
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            statement = con.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM `reservation`");
            while (resultSet.next()) {
                int id = resultSet.getInt("idReservation");
                String nomClient = resultSet.getString("nomClient");
                String prenomClient = resultSet.getString("prenomClient");
                String numPassport = resultSet.getString("numPassport");
                int numVol = resultSet.getInt("numVol");
                String etat = resultSet.getString("etat");
                Reservation reservation = new Reservation(id, nomClient, prenomClient, numPassport, numVol, etat);
                reservations.add(reservation);
            }
            tabReservation.setItems(reservations);
        } catch (Exception e) {
            e.printStackTrace();

        }
        return reservations;
    }

    @FXML
    public void supprimerPassager(ActionEvent event) {
        if (tabReservation.getSelectionModel().getSelectedItem() == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText("Erreur");
            alert.setContentText("Veuillez selectionner un passager");
            alert.showAndWait();
        } else {
            int id = tabReservation.getSelectionModel().getSelectedItem().getIdReservation();
            Connection con = Connexion.getConnexionn();
            Statement statement = null;
            try {
                statement = con.createStatement();
                statement.executeUpdate("DELETE FROM `reservation` WHERE `idReservation` = " + id + "");
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information");
                alert.setHeaderText("Information");
                alert.setContentText("Passager supprimer avec succes");
                alert.showAndWait();
                tabReservation.setItems(getReservation());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    private ObservableList<Reservation> ListeReservationAnnuler(ActionEvent event) {
        ObservableList<Reservation> reservations = FXCollections.observableArrayList();
        Connection con = Connexion.getConnexionn();
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            statement = con.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM `reservation` where etat = 'Annuler'");
            while (resultSet.next()) {
                int id = resultSet.getInt("idReservation");
                String nomClient = resultSet.getString("nomClient");
                String prenomClient = resultSet.getString("prenomClient");
                String numPassport = resultSet.getString("numPassport");
                int numVol = resultSet.getInt("numVol");
                String etat = resultSet.getString("etat");
                Reservation reservation = new Reservation(id, nomClient, prenomClient, numPassport, numVol, etat);
                reservations.add(reservation);
            }
            tabReservation.setItems(reservations);
        } catch (Exception e) {
            e.printStackTrace();

        }
        return reservations;
    }
}
