module org.dmiit3iy {
    requires javafx.controls;
    requires javafx.fxml;
    requires javax.mail.api;

    opens org.dmiit3iy to javafx.fxml;
    opens org.dmiit3iy.controllers to javafx.fxml;
    exports org.dmiit3iy;
    exports org.dmiit3iy.controllers;
    exports org.dmiit3iy.util;
    exports org.dmiit3iy.model;
}
