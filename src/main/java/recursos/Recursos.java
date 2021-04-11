package recursos;

import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Recursos {
    private static double xOffset = 0;
    private static double yOffset = 0;

    public static void moverPanel(Pane pane, Stage stage) {
        pane.setOnMousePressed(e -> {
            Recursos.xOffset = e.getSceneX();
            Recursos.yOffset = e.getSceneY();

        });
        pane.setOnMouseDragged(event -> {
            stage.setX(event.getScreenX() - Recursos.xOffset);
            stage.setY(event.getScreenY() - Recursos.yOffset);
            stage.setOpacity(0.7f);
        });
        pane.setOnDragDone((e) -> stage.setOpacity(1.0f));
        pane.setOnMouseReleased((e) -> stage.setOpacity(1.0f));
    }
}
