package sample;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.DragEvent;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Controller implements EventHandler<Event> {
    private Stage mStage;

    public Controller() {
        log("con");
    }

    public Controller(Stage stage) {
        setStage(stage);
    }

    public void setStage(Stage stage) {
        mStage = stage;
    }

    @FXML
    private GridPane myGridPane;

    @FXML
    private Button close;

    @FXML
    public void onDrop() {
        log("Hello drop");
    }


    @FXML
    public void onClick(Node node) {
        log("Hello click, nd = " + node);
    }

    @FXML
    private void onClick() {
        log("Hello click");
    }

    @FXML
    private void onKeyEvent(KeyEvent keyEvent) {
        log("Event = %s", keyEvent);
        switch (keyEvent.getCode()) {
            case ESCAPE:
                Scene s = myGridPane.getScene();
                log("close = %s", myGridPane);
                log("Scene = %s", s);
                log("Window = %s", s.getWindow());

                Stage g = (Stage) myGridPane.getScene().getWindow();
                g.close();
                break;
        }
    }

    @FXML
    private void onDragEvent(DragEvent dragEvent) {
        log("DragEvent = %s", dragEvent);

    }

    @FXML
    private void onMouseEvent(MouseEvent mouseEvent) {
        log("MouseEvent = %s", mouseEvent);

    }

    private static void log(String format, Object... param) {
        System.out.println(String.format(format, param));
    }

    @Override
    public void handle(Event event) {
        log("Event = %s", event.toString());
        if (event instanceof KeyEvent) {
            onKeyEvent((KeyEvent) event);
        }
        if (event instanceof DragEvent) {
            onDragEvent((DragEvent) event);
        }
        if (event instanceof MouseEvent) {
            onMouseEvent((MouseEvent) event);
        }
    }

}
