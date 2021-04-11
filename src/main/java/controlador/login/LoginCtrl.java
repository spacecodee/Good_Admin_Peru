package controlador.login;

import execute.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import recursos.AddImgR;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginCtrl implements Initializable {
    private double xOffset = 0;
    private double yOffset = 0;
    private int i = 0;
    public static Stage stageModal = null;

    @FXML
    private ImageView btnMinimize, btnMaxiMin, btnClose, iconPass, btnEye, iconUser;
    @FXML
    private HBox pnlContent;
    @FXML
    private VBox pnlFrom;
    @FXML
    private AnchorPane pnlLeft;
    @FXML
    private PasswordField pwsUser;
    @FXML
    private TextField txtUser;
    @FXML
    private Button btnLogin;
    @FXML
    private Label lblSmsErr;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        AddImgR.AddImg("close.png", this.btnClose);
        AddImgR.AddImg("minimize.png", this.btnMinimize);
        AddImgR.AddImg("maximize.png", this.btnMaxiMin);

        AddImgR.AddImg("login/password.png", this.iconPass);
        AddImgR.AddImg("login/user.png", this.iconUser);
        AddImgR.AddImg("login/eye-close.png", this.btnEye);

        this.lblSmsErr.setVisible(false);
        this.movePanel();
    }

    @FXML
    public void btnCloseOnClick(MouseEvent event) {
        if (event.getSource() == this.btnClose) {
            Stage stage = (Stage) this.btnClose.getScene().getWindow();
            stage.close();
        }
    }

    @FXML
    public void btnMaxiMin(MouseEvent event) {
        if (event.getSource() == this.btnMaxiMin) {
            Stage stage = (Stage) this.btnMaxiMin.getScene().getWindow();
            //Rectangle2D primScreenBounds = Screen.getPrimary().getVisualBounds();

            stage.setFullScreen(!stage.isFullScreen());
            if (stage.isFullScreen()) {
                AddImgR.AddImg("retraer.png", this.btnMaxiMin);

                this.pnlContent.setStyle("-fx-background-radius: 0px");
                this.pnlLeft.setStyle("-fx-background-radius: 0px");
                this.pnlFrom.setStyle("-fx-padding: 200px 200px 0px 200px");
            } else {
                AddImgR.AddImg("maximize.png", this.btnMaxiMin);

                this.pnlContent.setStyle("-fx-background-radius: 20px");
                this.pnlLeft.setStyle("-fx-background-radius: 20px 0px 0px 20px");
                this.pnlFrom.setStyle("-fx-padding: 0px 150px 0px 150px");
            }
        }
    }

    @FXML
    public void btnMinimizeOnClick(MouseEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setIconified(true);
    }

    @FXML
    public void btnEyeOnClick(MouseEvent event) {
        if (event.getSource() == this.btnEye) {
            if (this.i % 2 == 0) {
                if (!this.pwsUser.getText().trim().equalsIgnoreCase("")) {
                    AddImgR.AddImg("login/eye-open.png", this.btnEye);
                    this.pwsUser.setPromptText(this.pwsUser.getText());
                    this.pwsUser.setText("");
                    this.pwsUser.setEditable(false);
                }
            } else {
                if (!this.pwsUser.getPromptText().trim().equalsIgnoreCase("Password")) {
                    AddImgR.AddImg("login/eye-close.png", this.btnEye);
                    this.pwsUser.setText(this.pwsUser.getPromptText());
                    this.pwsUser.setPromptText("Password");
                    this.pwsUser.setEditable(true);
                }
            }
            this.i++;

        }
    }

    @FXML
    public void btnLoginOnClikc(ActionEvent event) {
        if (event.getSource() == this.btnLogin) {
            this.validateLogin();
        }
    }

    //ejemplo de cómo se crea un modal
    private void createModal() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/vistafxml/modales/modal-aviso.fxml"));
            Parent root = fxmlLoader.load();
            Scene scene = new Scene(root, 800, 500);
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            scene.setFill(Color.TRANSPARENT); //hacerlo transparente
            stage.setTitle("Space Codee: Good Admin");
            stage.setScene(scene);
            stage.initStyle(StageStyle.TRANSPARENT); //que no se vea el decorado y sea transparente
            stage.show();
            LoginCtrl.stageModal = stage;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }

    }

    private void movePanel() {
        pnlContent.setOnMousePressed(e -> {
            xOffset = e.getSceneX();
            yOffset = e.getSceneY();

        });
        pnlContent.setOnMouseDragged(event -> {
            Main.stage1.setX(event.getScreenX() - xOffset);
            Main.stage1.setY(event.getScreenY() - yOffset);
            Main.stage1.setOpacity(0.7f);
        });
        pnlContent.setOnDragDone((e) -> Main.stage1.setOpacity(1.0f));
        pnlContent.setOnMouseReleased((e) -> Main.stage1.setOpacity(1.0f));

    }

    public void validateLogin() {
        if (this.txtUser.getText().trim().isEmpty() || this.pwsUser.getText().trim().isEmpty()) {
            //this.createModal();
            //Main.stage1.setOpacity(0.9f);
            //AddImgR.AddImg("modales/warning.png", ModalAvisoCtrl.imgWarning);
            //ModalAvisoCtrl.lblWarning.setText("Todos los campos son necesarios".toUpperCase());
            this.lblSmsErr.setText("Todos los campos son necesarios".toUpperCase());
            this.lblSmsErr.setVisible(true);
        } else {
            this.lblSmsErr.setVisible(false);
            //Main.stage1.setOpacity(1);
        }
    }
}
