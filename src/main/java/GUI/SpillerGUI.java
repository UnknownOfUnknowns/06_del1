package GUI;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;

//Viser information til spiller og giver mulighed for at rulle
public class SpillerGUI extends GridPane {
    private final Label spiller;
    private final Label point;
    private final Button rul;
    private TerningGUI terning1;
    private TerningGUI terning2;
    private final ImageView imageView1;
    private final ImageView imageView2;

    public SpillerGUI(String titel){
        rul= new Button("Rul");
        spiller = new Label(titel);
        point = new Label("Point: 0");
        terning1 = new TerningGUI(4);
        terning2 = new TerningGUI(1);
        imageView1 = new ImageView(terning1);
        imageView2 = new ImageView(terning2);
        add(spiller, 0,0);
        add(point, 0,1);
        add(imageView1, 0, 2);
        add(imageView2, 1, 2);
        add(rul, 0,3);
        setAlignment(Pos.CENTER);
        setVgap(10);
        setPadding(new Insets(10, 25, 10, 25));
    }

    public Button getRulKnap() {
        return rul;
    }

    public void opdater(int t1_val, int t2_val, int p){
        terning1 = new TerningGUI(t1_val);
        terning2 = new TerningGUI(t2_val);
        imageView1.setImage(terning1);
        imageView2.setImage(terning2);
        point.setText("Point: " + Integer.toString(p));
    }
}
