package com.airplane.demo;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;


public class VolController implements Initializable {
    @FXML
    private TextField aeroportArriver;

    @FXML
    private TextField aeroportDepart;

    @FXML
    private DatePicker dateArriver;

    @FXML
    private DatePicker datedepart;

    @FXML
    private TextField vharriver;

    @FXML
    private TextField vhdepart;

    @FXML
    private Button btnaddvol;
    @FXML
    private Button AddEscales;
    @FXML
    void addVol(ActionEvent event) {
        PreparedStatement st=null;
        ResultSet rs=null;
        Connection con = Connexion.getConnexionn();
        String dateArriver = this.dateArriver.getValue().toString();
        String datedepart = this.datedepart.getValue().toString();
        String varriver = this.aeroportArriver.getText();
        String vdepart = this.aeroportDepart.getText();
        String vharriver = this.vharriver.getText();
        String vhdepart = this.vhdepart.getText();
        try{

            String sql="INSERT INTO vol(aerropDepart,aeroportArrivee,heureDepart,heureArrivee,dateDepart,dateArrivee) VALUES (?,?,?,?,?,?)";
            st=con.prepareStatement(sql);
            st.setString(1, vdepart);
            st.setString(2, varriver);
            st.setString(3, vhdepart);
            st.setString(4, vharriver);
            st.setString(5, datedepart);
            st.setString(6, dateArriver);
            int e=st.executeUpdate();
            if(e == 1){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information Dialog");
                alert.setHeaderText(null);
                alert.setContentText("Vol added successfully");
                alert.showAndWait();
            }
            else{
                System.out.println("error");
            }

            }catch (SQLException e) {
            System.out.println(e.getMessage());
        }


    }

    @FXML
    void addescale(ActionEvent event) throws IOException {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("vous Avez Etre rediriger vers la page d'ajout d'escale");
        alert.showAndWait();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("escale.fxml"));
        Parent home = fxmlLoader.load();
        Scene homeScene = new Scene(home, 1500, 800);

        Stage currentStage = (Stage) AddEscales.getScene().getWindow();
        currentStage.setTitle("Home");
        currentStage.setScene(homeScene);
        currentStage.show();




    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
