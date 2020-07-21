/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rozensorteerder;

import Models.XMLObject;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

/**
 *
 * @author Thom
 */


public class XMLObjectTabelView extends Pane {
    VBox vbox;
    GridPane gpData;
    GridPane gpTabel;
    
    TableView tv;
    TableColumn tc1;
    TableColumn tc2;
    TableColumn tc3;
    TableColumn tc4;
    TableColumn tc5;
    TableColumn tc6;
    TableColumn tc7;
    
    ObservableList<XMLObject> data;
    
    public XMLObjectTabelView(ArrayList<XMLObject> products, StackPane root){
        
        vbox = new VBox();
        gpData = new GridPane();
        gpTabel = new GridPane();
        
        data = FXCollections.observableArrayList(products);
        
        tv = new TableView();
        tv.prefWidthProperty().bind(root.widthProperty());
        //tv.prefHeightProperty().bind(root.heightProperty());
        tc1 = new TableColumn("lengte");
        tc2 = new TableColumn("steeldikte");
        tc3 = new TableColumn("knophoogte");
        tc4 = new TableColumn("knopbreedte");
        tc5 = new TableColumn("kleurwaarde");
        tc6 = new TableColumn("rijpheid");
        tc7 = new TableColumn("datum");
        
        tc1.setCellValueFactory(
            new PropertyValueFactory<XMLObject ,String>("gemetenLengte"));
        tc2.setCellValueFactory(
            new PropertyValueFactory<XMLObject,String>("gemetenSteeldikte"));
        tc3.setCellValueFactory(
            new PropertyValueFactory<XMLObject,String>("gemetenKnopHoogte"));
        tc4.setCellValueFactory(
            new PropertyValueFactory<XMLObject,String>("gemetenKnopbreedte"));
        tc5.setCellValueFactory(
            new PropertyValueFactory<XMLObject,String>("gemetenKleurwaarde"));
        tc6.setCellValueFactory(
            new PropertyValueFactory<XMLObject,String>("gemetenRijpheid"));
        tc7.setCellValueFactory(
            new PropertyValueFactory<XMLObject,String>("inserttime"));
        
        tv.getColumns().addAll(tc1, tc2, tc3, tc4, tc5, tc6, tc7);
        tv.setItems(data);
        
        gpTabel.getChildren().add(tv);
        
        root.getChildren().add(gpTabel);
    }
    
}
