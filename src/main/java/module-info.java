module com.calculatriceimt {
    requires transitive javafx.controls;
    requires javafx.fxml;

    opens com.calculatriceimt to javafx.fxml;
    exports com.calculatriceimt;
}
