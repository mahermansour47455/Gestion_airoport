package com.airplane.demo;

import com.airplane.demo.entities.Aeroport;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class AjoutAeroportController implements Initializable {
    @FXML
    private TextField idNomAeroportt;

    @FXML
    private TextField idVilleAeroport;

    @FXML
    private TableColumn<Aeroport, String> nomaeroport;

    @FXML
    private TableColumn<Aeroport, Integer> numeroAeroport;

    @FXML
    private TableView<Aeroport> tabAeroport;

    @FXML
    private TableColumn<Aeroport, String> villeaeroport;

    @FXML
    public void AjouterAeroport(ActionEvent event) {
        Connection con = Connexion.getConnexionn();
        PreparedStatement preparedStatement = null;

        try {
            String query = "INSERT INTO aeroport (nomAeroport, villeAeroport) VALUES (?, ?)";
            preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1, idNomAeroportt.getText());
            preparedStatement.setString(2, idVilleAeroport.getText());

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information Dialog");
                alert.setHeaderText(null);
                alert.setContentText("Aéroport ajouté avec succès");
                alert.showAndWait();
                tabAeroport.setItems(getAeroport());


            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (preparedStatement != null) {
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        villeaeroport.setCellValueFactory(cellData -> cellData.getValue().villeAeroportProperty());
        nomaeroport.setCellValueFactory(cellData -> cellData.getValue().nomAeroportProperty());
        numeroAeroport.setCellValueFactory(cellData -> cellData.getValue().idAeroportProperty().asObject());
        tabAeroport.setItems(getAeroport());


    }
    private ObservableList<Aeroport> getAeroport() {
        ObservableList<Aeroport> aeroports = FXCollections.observableArrayList();
        Connection con = Connexion.getConnexionn();
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            statement = con.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM aeroport");
            while (resultSet.next()) {
                int id = resultSet.getInt("idAeroport");
                String nomAeroport = resultSet.getString("nomAeroport");
                String villeAeroport = resultSet.getString("villeAeroport");
                Aeroport aeroport = new Aeroport(id, nomAeroport, villeAeroport);
                aeroports.add(aeroport);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return aeroports;
    }

}
