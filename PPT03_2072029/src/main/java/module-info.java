module com.example.ppt03_2072029 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.ppt03_2072029 to javafx.fxml;
    exports com.example.ppt03_2072029;
    exports com.example.ppt03_2072029.Controller;
    exports com.example.ppt03_2072029.Entity;
    opens com.example.ppt03_2072029.Controller to javafx.fxml;
}