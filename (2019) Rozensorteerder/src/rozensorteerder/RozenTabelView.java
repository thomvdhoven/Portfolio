/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rozensorteerder;

import Models.XMLObject;
import java.util.ArrayList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 *
 * @author thomv
 */
public class RozenTabelView extends Pane {
    VBox vbox;
    GridPane gpData;
    GridPane gpTabel;
    
    TableView tv;
    TableColumn tc1;
    TableColumn tc2;
    TableColumn tc3;
    
    
    
    public RozenTabelView(ArrayList<XMLObject> products){
        vbox = new VBox();
        gpData = new GridPane();
        gpTabel = new GridPane();
        
        tv = new TableView();
        tc1 = new TableColumn("station1");
        tc2 = new TableColumn("station2");
        tc3 = new TableColumn("station3");
    }
    
}
