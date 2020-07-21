/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rozensorteerder;

import Models.StationVerzameling;
import Models.XMLObject;
import java.io.File;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.StackPane;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;
import javax.xml.bind.JAXBException;

/**
 *
 * @author thomv
 */
public class RozenSorteerder extends Application{
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) throws JAXBException{
        /*
        DirectoryChooser drc = new DirectoryChooser();
        File dir = drc.showDialog(primaryStage);
        
        while(dir == null){
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Please select a directory \nSelecteer een map alstublieft");
            alert.showAndWait();
            System.exit(0);
        }*/
        
        
        XMLReader xmlreader = new XMLReader();
        ArrayList<XMLObject> producten = new ArrayList<>();
        StationVerzameling sv = new StationVerzameling();
        
        producten = xmlreader.readJSON();
        sv = xmlreader.checkStations();
        sv.doorgelaten(producten);
        System.out.println(producten);
        
        StackPane root = new StackPane();
        /*RozenTabelControl rtc = new RozenTabelControl();
        double[][] var2 = { {1.0, 2.0}, {2.0, 3.0}, {3.0, 4.0}, {4.0, 5.0}, {5.0, 6.0}, {6.0, 7.0},
                {7.0, 8.0},{8.0, 9.0},{9.0, 10.0},{10.0, 11.0},{11.0, 12.0}};
        double[][] var1 = { {0.0, 725.0}, {725.0, 750.0}, {750.0, 775.0},
                {775.0, 800.0}, {800.0, 825.0}, {825.0, 850.0}, {850.0, 875.0},
                {875.0, 900.0}, {900.0, 925.0}, {925.0, 950.0}, {950.0, 975.0}, 
                {975.0, 1000.0}, {1025.0, 2000.0}
        };
        rtc.fillTabel(root, var1, var2, producten);*/
        //XMLObjectTabelView xotv = new XMLObjectTabelView(producten, root);
        HoofdMenuView hmv = new HoofdMenuView(producten, root, sv);
        primaryStage.setScene(new Scene(root, 650, 250));
        primaryStage.show();
    }
    
}
