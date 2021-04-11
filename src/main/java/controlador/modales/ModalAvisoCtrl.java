package controlador.modales;

import controlador.login.LoginCtrl;
import execute.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import recursos.AddImgR;

import java.net.URL;
import java.util.ResourceBundle;

public class ModalAvisoCtrl implements Initializable {
    private double xOffset = 0;
    private double yOffset = 0;

    @FXML
    private ImageView imgMensaje;
    @FXML
    private Label lblSms;
    @FXML
    private Button btnAcept;
    @FXML
    private BorderPane pnlModal;

    //staticos
    public static ImageView imgWarning;
    public static  Label lblWarning;
    public static Button btnWarning;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ModalAvisoCtrl.imgWarning = this.imgMensaje;
        ModalAvisoCtrl.lblWarning = this.lblSms;
        ModalAvisoCtrl.btnWarning = this.btnAcept;

        AddImgR.AddImg("modales/checked.png", this.imgMensaje);

        this.movePanel();
    }

    public void btnAceptOnAction(ActionEvent e) {
        if (e.getSource() == this.btnAcept) {
            Stage stage = (Stage) this.btnAcept.getScene().getWindow();
            stage.close();
            Main.stage1.setOpacity(1);
        }
    }

    private void movePanel() {
        pnlModal.setOnMousePressed(e -> {
            xOffset = e.getSceneX();
            yOffset = e.getSceneY();

        });
        pnlModal.setOnMouseDragged(event -> {
            LoginCtrl.stageModal.setX(event.getScreenX() - xOffset);
            LoginCtrl.stageModal.setY(event.getScreenY() - yOffset);
            LoginCtrl.stageModal.setOpacity(0.8f);
        });
        pnlModal.setOnDragDone((e) -> LoginCtrl.stageModal.setOpacity(1.0f));
        pnlModal.setOnMouseReleased((e) -> LoginCtrl.stageModal.setOpacity(1.0f));

    }

}
