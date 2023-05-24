package com.airplane.demo;

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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    @FXML
    private Button ClientBtn;

    @FXML
    private Button btnlogin;

    @FXML
    private TextField email;

    @FXML
    private PasswordField password;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void login(ActionEvent event) throws SQLException {
        PreparedStatement st=null;
        ResultSet rs=null;
        Connection con = Connexion.getConnexionn();
        try{
            String sql="SELECT * FROM `personne` WHERE `email`=? AND `password`=?";
            st=con.prepareStatement(sql);
            st.setString(1, email.getText());
            st.setString(2, password.getText());
            rs=st.executeQuery();

            if (rs.next()) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information Dialog");
                alert.setHeaderText(null);
                alert.setContentText("Login successful");
                alert.showAndWait();
                try {
                    if(rs.getString("role").equals("ADMIN"))
                    {
                        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("adminPanel.fxml"));
                        Parent home = fxmlLoader.load();
                        Scene homeScene = new Scene(home, 1500, 800);

                        Stage currentStage = (Stage) btnlogin.getScene().getWindow();
                        currentStage.setTitle("Home");
                        currentStage.setScene(homeScene);
                        currentStage.show();
                    }
                    else{
                        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("escale.fxml"));
                        Parent home = fxmlLoader.load();
                        Scene homeScene = new Scene(home, 1600, 800);

                        Stage currentStage = (Stage) btnlogin.getScene().getWindow();
                        currentStage.setTitle("Home");
                        currentStage.setScene(homeScene);
                        currentStage.show();
                    }

                } catch (Exception e) {
                    System.out.println("error");


                }
            }
            else{
                System.out.println("login failed");
                System.out.println("email: "+email.getText());
                System.out.println("password: "+password.getText());
            }
        }
        catch(Exception e){
            System.out.println("error");
        }


    }
    public void ClientBtn(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("client.fxml"));
        Parent home = fxmlLoader.load();
        Scene homeScene = new Scene(home, 1500, 800);

        Stage currentStage = (Stage) btnlogin.getScene().getWindow();
        currentStage.setTitle("Home");
        currentStage.setScene(homeScene);
        currentStage.show();

    }
}