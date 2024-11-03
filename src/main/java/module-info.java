module com.calculatriceimt {
    requires transitive javafx.controls;
    requires javafx.fxml;

    opens com.calculatriceimt to javafx.fxml;
    opens com.calculatriceimt.View to javafx.fxml;
    exports com.calculatriceimt;
    exports com.calculatriceimt.View to javafx.graphics, javafx.fxml;
}
