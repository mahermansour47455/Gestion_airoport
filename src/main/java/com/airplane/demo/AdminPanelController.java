package com.airplane.demo;

import com.airplane.demo.entities.Vol;
import com.airplane.demo.entities.escale;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

public class AdminPanelController implements Initializable {
    @FXML
    private TableColumn<Vol, String> ColAA;

    @FXML
    private TableColumn<Vol, String> ColAd;

    @FXML
    private Button BtnReservation;

    @FXML
    private TableColumn<Vol, String> ColDA;

    @FXML
    private TableColumn<Vol, String> ColDD;

    @FXML
    private TableColumn<Vol, String> ColHA;
    @FXML
    private DatePicker DateDepartId;

    @FXML
    private TableColumn<Vol, String> ColHD;

    @FXML
    private TableView<Vol> TablVol;

    @FXML
    private TableColumn<Vol, Integer> colId;

    @FXML
    private TableColumn<Vol, String> etat;

    //escale table
    @FXML
    private TableColumn<escale, String> HAriiver;

    @FXML
    private TableColumn<escale, String> HEscale;
    @FXML
    private DatePicker DateRech;

    @FXML
    private TableView<escale> tabEscale;

    @FXML
    private TableColumn<escale, String> AEscale;

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

    public void RechercherParDate(ActionEvent event) {
        ObservableList<Vol> vols = FXCollections.observableArrayList();
        if (DateRech.getValue() != null && DateDepartId.getValue() != null) {

            Date dateDepart = java.sql.Date.valueOf(DateRech.getValue());
            Date dateDepart1 = java.sql.Date.valueOf(DateDepartId.getValue());
            Connection con = Connexion.getConnexionn();
            Statement statement = null;
            ResultSet resultSet = null;
            List<Vol> tempVols = new ArrayList<>();
            try {
                statement = con.createStatement();
                resultSet = statement.executeQuery("SELECT * FROM `vol` WHERE dateDepart = '" + dateDepart + "' and dateArrivee = '" + dateDepart1 + "'");
                //je veut tester si il y a des resultats
                while (resultSet.next()) {
                    // Récupérer les données du résultat
                    int id = resultSet.getInt("idVol");
                    String aeroportArriver = resultSet.getString("aeroportArrivee");
                    String aeroportDepart = resultSet.getString("aerropDepart");
                    String dateArriver = resultSet.getString("dateArrivee");
                    String dateDeparte = resultSet.getString("dateDepart");
                    String heureArriver = resultSet.getString("heureArrivee");
                    String heureDepart = resultSet.getString("heureDepart");
                    String etat = resultSet.getString("etat");

                    // Créer une instance de Vol
                    Vol vol = new Vol(id, aeroportArriver, aeroportDepart, dateArriver, dateDeparte, heureArriver, heureDepart, etat);

                    // Ajouter le vol à la liste vols
                    tempVols.add(vol);
                }

// Vérifier si la liste vols est vide
                if (tempVols.isEmpty()) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Erreur");
                    alert.setHeaderText("Erreur");
                    alert.setContentText("Aucun vol n'est disponible");
                    alert.showAndWait();
                } else {
                    vols.addAll(tempVols);
                    TablVol.setItems(vols); // Refresh the TableView with the updated data

                    System.out.println("ok");
                }

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText("Erreur");
            alert.setContentText("Veuillez saisir le date de depart et la date d'arriver");
            alert.showAndWait();
        }
    }
    private ObservableList<escale> getEscale() {
        ObservableList<escale> escales = FXCollections.observableArrayList();
        if(TablVol.getSelectionModel().getSelectedItem() != null) {
            //recuperer l'id du vol selectionner (idVol
            int idVol = TablVol.getSelectionModel().getSelectedItem().getIdVol();
            System.out.println(idVol);

            Connection con = Connexion.getConnexionn();
            Statement statement = null;
            ResultSet resultSet = null;
            try {
                statement = con.createStatement();
                resultSet = statement.executeQuery("SELECT * FROM escale where idVol = " + idVol + "");
                while (resultSet.next()) {
                    int id = resultSet.getInt("idEscale");
                    String nomAeroport = resultSet.getString("nomAeroport");
                    String heureArriver = resultSet.getString("heureDepart");
                    String heureDepart = resultSet.getString("heureArrivee");
                    escale escale = new escale(nomAeroport, heureArriver, heureDepart, idVol);
                    escales.add(escale);


                }


            } catch (Exception e) {
                e.printStackTrace();

            }

            return escales;
        }
        else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText("Erreur");
            alert.setContentText("Veuillez selectionner un vol");
            alert.showAndWait();


            }
        return null;

    }
    public void ListerLesEscales(ActionEvent evnet)
    {
        HAriiver.setCellValueFactory(cellData -> cellData.getValue().heurArriverProperty());
        HEscale.setCellValueFactory(cellData -> cellData.getValue().heureDepartProperty());
        AEscale.setCellValueFactory(cellData -> cellData.getValue().nomAeroportProperty());
        tabEscale.setItems(getEscale());
    }

    public void listerPassager(ActionEvent event)
    {

    }
    public void listerReservation(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ListeReservation.fxml"));
        Parent home = fxmlLoader.load();
        Scene homeScene = new Scene(home, 1500, 800);

        Stage currentStage = (Stage) BtnReservation.getScene().getWindow();
        currentStage.setTitle("Home");
        currentStage.setScene(homeScene);
        currentStage.show();
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("succes");
        alert.setHeaderText("succes");
        alert.setContentText("Wellcome in the liste of reservation");
        alert.showAndWait();


    }
    public void lesAeroports(ActionEvent event)
    {

    }

    public void listerLesVols(ActionEvent event)
    {
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

    @FXML
    private Button btnLogout;

    @FXML
    public void Logout(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("hello-view.fxml"));
        Parent home = fxmlLoader.load();
        Scene homeScene = new Scene(home, 1500, 800);

        Stage currentStage = (Stage) btnLogout.getScene().getWindow();
        currentStage.setTitle("Home");
        currentStage.setScene(homeScene);
        currentStage.show();
    }

}
