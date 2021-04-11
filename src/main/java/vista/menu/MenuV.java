package vista.menu;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import recursos.AddImgR;

public class MenuV extends Application {
    public static Stage stage1 = null;

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/vistafxml/menu/menuinit.fxml"));
        Scene scene = new Scene(root, 1280, 720);
        scene.setFill(Color.TRANSPARENT); //hacerlo transparente
        AddImgR.addImg("logo.png", stage);
        stage.setTitle("Space Codee: Good Admin");
        stage.setScene(scene);
        stage.initStyle(StageStyle.TRANSPARENT); //que no se vea el decorado y sea transparente
        MenuV.stage1 = stage;
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
