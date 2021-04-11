package recursos;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.File;

public class AddImgR {
    private static final String url1 = "src/main/resources/img/";

    public static void AddImg(String url, ImageView btn) {
        File fileImgFondo = new File(AddImgR.url1 + url);
        Image imgFondo = new Image(fileImgFondo.toURI().toString());
        btn.setImage(imgFondo);
    }

    public static void addImg(String url, Stage stage) {
        File fileImgFondo = new File(AddImgR.url1 + url);
        Image ico = new Image(fileImgFondo.toURI().toString());
        stage.getIcons().add(ico);
    }
}
