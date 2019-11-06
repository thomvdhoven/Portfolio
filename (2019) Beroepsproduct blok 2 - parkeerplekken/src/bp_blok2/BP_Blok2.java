package bp_blok2;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class BP_Blok2 extends Application {

    
    public void start(Stage primaryStage){
        Pane root = new Pane();
        Scene scene = new Scene(root, 500, 500);
        new TextPage(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Blok 2 - Beroepsproduct - Monumenten in Breda");
        primaryStage.show();
        
    }
    public static void main(String[] args) {
        launch(args);
    }
    
}
