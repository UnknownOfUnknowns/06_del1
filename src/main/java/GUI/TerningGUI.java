package GUI;

import javafx.scene.image.Image;

//Loader terning billede
public class TerningGUI extends Image {
    TerningGUI(int terning_nummer){
        super("file:src/main/resources/Terninger/"+ terning_nummer +"Terning.png");
    }

}