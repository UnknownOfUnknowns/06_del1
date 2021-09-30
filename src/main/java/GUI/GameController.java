package GUI;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.AmbientLight;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import spil.Spil;
import spil.Spiller;

import java.util.Timer;


public class GameController extends Application {
    private SpillerGUI s1_gui;
    private SpillerGUI s2_gui;
    private Label status_label;
    private Spiller s1;
    private Spiller s2;
    private Spil spil;
    @Override
    public void start(Stage stage) throws Exception {
        setup_skærm(stage);
        setup_spil();
    }
    private void setup_skærm(Stage stage){
        s1_gui = new SpillerGUI("Spiller 1");
        s2_gui = new SpillerGUI("Spiller 2");
        s1_gui.getRulKnap().setOnAction(this::håndterRul);
        s2_gui.getRulKnap().setOnAction(this::håndterRul);
        status_label = new Label("Velkommen til spillet");
        AnchorPane pane = new AnchorPane(s1_gui, status_label, s2_gui);
        pane.setPrefWidth(500);
        AnchorPane.setTopAnchor(status_label,20.0);
        AnchorPane.setLeftAnchor(status_label, 200.0);
        AnchorPane.setTopAnchor(s1_gui, 20.0);
        AnchorPane.setLeftAnchor(s1_gui, 20.0);
        AnchorPane.setTopAnchor(s2_gui, 20.0);
        AnchorPane.setRightAnchor(s2_gui, 20.0);

        pane.setStyle("-fx-background-color: red");
        Group root = new Group(pane);

        Scene scene = new Scene(root,500, 155);
        stage.setTitle("Test");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    private void setup_spil(){
        s1 = new Spiller();
        s2 = new Spiller();
        spil = new Spil(s1,s2);
    }

    public static void main(String[] args) {
        launch();
    }
    public void håndterRul(ActionEvent e){
        try {
            status_label.setText("Velkommen til spillet");
            if (e.getSource() == s1_gui.getRulKnap()) {
                spil.tag_tur(s1);
                int[] status = s1.getStatus();
                s1_gui.opdater(status[0], status[1], status[2]);
            }else{
                spil.tag_tur(s2);
                int[] status = s2.getStatus();
                s2_gui.opdater(status[0], status[1], status[2]);
            }
            if(spil.vinder() != null){
                String vinder = (spil.vinder() == s1) ? "Tillykke spiller 1" : "Tillykke spiller 2";
                status_label.setText(vinder);
            }
        }catch (Exception excep){
            if(excep.getMessage().equals("Spiller udenfor tur")){
                status_label.setText("Det er ikke din tur");
            }
        }
    }
}
