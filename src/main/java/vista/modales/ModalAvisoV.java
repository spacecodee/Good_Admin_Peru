package vista.modales;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import recursos.AddImgR;

public class ModalAvisoV extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/vistafxml/modales/modal-aviso.fxml"));
        Scene scene = new Scene(root, 800, 500);
        Stage stage1 = new Stage();

        scene.setFill(Color.TRANSPARENT); //hacerlo transparente
        stage1.initModality(Modality.APPLICATION_MODAL);
        AddImgR.addImg("logo.png", stage1);
        stage1.setTitle("Space Codee: Good Admin");
        stage1.setScene(scene);
        stage1.initStyle(StageStyle.TRANSPARENT); //que no se vea el decorado y sea transparente
        stage1.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
