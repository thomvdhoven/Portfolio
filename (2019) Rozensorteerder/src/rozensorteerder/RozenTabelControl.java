/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rozensorteerder;

import Models.XMLObject;
import java.util.ArrayList;
import java.util.Arrays;
import javafx.application.Application;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Callback;

/**
 *
 * @author thomv
 */
public class RozenTabelControl {
    public void tabel(Pane root, int[][] totaal){
        //StackPane root = new StackPane();
        //int[][] staffArray = {{"nice to ", "have", "titles"},
        //                         {"a", "b", "c"},
        //                         {"d", "e", "f"}};
        ObservableList<int[]> data = FXCollections.observableArrayList();
        data.addAll(Arrays.asList(totaal));
        TableView<int[]> table = new TableView<>();
        for (int i = 0; i < totaal[0].length; i++) {
            /*TableColumn tc = new TableColumn("wow");
            final int colNo = i;
            tc.setCellValueFactory(new Callback<CellDataFeatures<String[], String>, ObservableValue<String>>() {
                @Override
                public ObservableValue<String> call(CellDataFeatures<String[], String> p) {
                    return new SimpleStringProperty((p.getValue()[colNo]));
                }
            });*/
            
            TableColumn tc = new TableColumn<>("wow");
            tc.setCellValueFactory(new PropertyValueFactory<Integer[], Integer>("wow"));
            
            tc.setPrefWidth(90);
            table.getColumns().add(tc);
        }
        table.setItems(data);
        root.getChildren().add(table);
    }
    
    public void fillTabel(Pane root, double[][] var1, double[][] var2, ArrayList<XMLObject> products){
        int[][] totaal = new int[var1.length][var2.length];
        for (int i=0; i < var1.length; i++ ){
           for (int ii=0; ii < var2.length; ii++ ){
                for (XMLObject product : products){
                    System.out.println(var1[i][0] + " >= " + product.getGemetenLengte());
                    if (product.getGemetenLengte() >= var1[i][0] && product.getGemetenLengte() < var1[i][1]){
                        System.out.println(i + ", " + ii);
                        System.out.println(var1[ii][0] + " >= " + product.getStationnummer());
                        if (product.getGemetenSteeldikte() >= var2[ii][0] && product.getGemetenSteeldikte() < var2[ii][1] ){
                            totaal[i][ii]++;
                            System.out.println(i + ", " + ii);
                        }
                    }
                }
            } 
        }
        maakGP(root, totaal, var1, var2);
    }
    
    public void maakGP(Pane root, int[][] totaal, double[][] var1, double[][] var2){
        GridPane gp = new GridPane();
        gp.setGridLinesVisible(true);
        
        for (int j=0;j<var1.length;j++){
            Label lbl1 = new Label(" " + var1[j][0] + " - " + var1[j][1] + " ");
            gp.add(lbl1, j+1, 0);
        }
        
        for (int j=0;j<var2.length;j++){
            Label lbl1 = new Label(" " + var2[j][0] + " - " + var2[j][1] + " ");
            gp.add(lbl1, 0, j+1);
        }
        
        for (int i=0;i<totaal.length;i++){
            for (int ii=0;ii<totaal[0].length;ii++){
                Label lbl = new Label(" "+totaal[i][ii] + " ");
                gp.add(lbl, i+1, ii+1);
            }
        }
        root.getChildren().add(gp);
    }
    
}
