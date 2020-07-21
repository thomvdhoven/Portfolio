/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rozensorteerder;

import Models.XMLObject;
import java.util.ArrayList;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

/**
 *
 * @author Thom
 */
public class StationView {
    public StationView(ArrayList<XMLObject> products, int stations, Pane root){
        GridPane gp = new GridPane();
        //ArrayList<Integer> perS = new ArrayList<>();
        int[] perS = new int[stations+1];
        
        for (XMLObject p : products){
            perS[p.getStationnummer()]++;
        }
        
        for(int i = 1; i <= stations; i++){
            Label l1 = new Label("Station " + i + ": ");
            Label l2 = new Label("" + perS[i]);
            Label l3 = new Label(" rozen");
            
            l2.setAlignment(Pos.CENTER_RIGHT);
            
            gp.add(l1, 0, i);
            gp.add(l2, 1, i);
            gp.add(l3, 2, i);
        }
        root.getChildren().add(gp);
    }
}
