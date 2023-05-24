module com.airplane.demo {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires mysql.connector.j;
            
                            
    opens com.airplane.demo to javafx.fxml;
    exports com.airplane.demo;
}