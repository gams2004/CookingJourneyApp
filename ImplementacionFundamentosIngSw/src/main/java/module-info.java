module appcocina.implementacionfundamentosingsw {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.jfoenix;
    requires java.sql;


    opens appcocina.implementacionfundamentosingsw to javafx.fxml;
    exports appcocina.implementacionfundamentosingsw;
}