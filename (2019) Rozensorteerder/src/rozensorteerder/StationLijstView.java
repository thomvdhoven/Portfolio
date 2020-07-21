/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rozensorteerder;

import Models.Station;
import Models.StationVerzameling;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import static javafx.collections.FXCollections.observableArrayList;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 *
 * @author Thom
 */
public class StationLijstView {
    HBox vbox = new HBox();
    
    ListView<String> lvStations;
    ObservableList<String> items;
    GridPane gpStationData = new GridPane();
    
    Label lblStationnummer = new Label();
    Label lblLengte = new Label();
    Label lblSteeldikte = new Label();
    Label lblKnophoogte = new Label();
    Label lblKnopBreedte = new Label();
    Label lblKleurMin = new Label();
    Label lblKleurMax = new Label();
    Label lblRijpheid = new Label();
    Label lblRijpheidMin = new Label();
    Label lblRijpheidMax = new Label();
    Label lblCodering = new Label();
    Label lblDLengte = new Label();
    Label lblDSteeldikte = new Label();
    Label lblDKnophoogte = new Label();
    Label lblDKnopbreedte = new Label();
    Label lblDKleur = new Label();
    Label lblDRijpheid = new Label();
    Label lblDGeenCat = new Label();
    Label lblDTotaal = new Label();
    
    public StationLijstView(StationVerzameling sv, Pane p){
        items = observableArrayList();
        lvStations = new ListView<>();
                
        for(int i=1;i<=sv.aantal();i++){
            String str = new String();
            if (i < 10){
                str = "Station 0" + i;
            } else{
                str = "Station " + i;
            }
            
            items.add(str);
            //lvStations.getItems().add(str);
        }
        lvStations.setItems(items);
        
        lvStations.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>(){
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue){
               gpStationData.getChildren().clear();
                gpStationData = StationLabel();
                StationData(sv, Integer.parseInt(newValue.substring(newValue.length() - 2)), gpStationData);
                
            }
        });
        
        
        
        vbox.getChildren().add(lvStations);
        
        gpStationData = StationLabel();
        
        
        
        vbox.getChildren().add(gpStationData);
        
        
        
        p.getChildren().add(vbox);
    }
    
    void StationData(StationVerzameling sv, int i, GridPane g){
        Station s = sv.zoek(i);
        lblStationnummer = new Label(Integer.toString(s.getStationnummer()));
        lblLengte = new Label(Double.toString(s.getIngesteldeLengte()));
        lblSteeldikte = new Label(Double.toString(s.getIngesteldeSteeldikte()));
        lblKnophoogte = new Label(Double.toString(s.getIngesteldeKnophoogte()));
        lblKnopBreedte = new Label(Double.toString(s.getIngesteldeKnopbreedte()));
        lblKleurMin = new Label(Double.toString(s.getIngesteldeKleurMin()));
        lblKleurMax = new Label(Double.toString(s.getIngesteldeKleurMax()));
        lblRijpheid = new Label(Double.toString(s.getIngesteldeRijpheid()));
        lblRijpheidMin = new Label(Double.toString(s.getIngesteldeRijpheidMin()));
        lblRijpheidMax = new Label(Double.toString(s.getIngesteldeRijpheidMax()));
        lblCodering = new Label(Integer.toString(s.getIngesteldeCodering()));
        
        lblDLengte = new Label("  " + Integer.toString(s.getDoorgelatenLengte()) + " doorgelaten");
        lblDSteeldikte = new Label("  " + Integer.toString(s.getDoorgelatenSteeldikte()) + " doorgelaten");
        lblDKnophoogte = new Label("  " + Integer.toString(s.getDoorgelatenKnophoogte()) + " doorgelaten");
        lblDKnopbreedte = new Label("  " + Integer.toString(s.getDoorgelatenKnopbreedte()) + " doorgelaten");
        lblDKleur = new Label("  " + Integer.toString(s.getDoorgelatenKleur()) + " doorgelaten");
        lblDRijpheid = new Label("  " + Integer.toString(s.getDoorgelatenRijpheid()) + " doorgelaten");
        lblDGeenCat = new Label(Integer.toString(s.getDoorgelatenGeenCat()) + " ongecategoriseerd doorgelaten");
        lblDTotaal = new Label(Integer.toString(s.getDoorgelatenTotaal()) + " totaal doorgelaten");
        
        //g.getChildren().clear();
        
        //gpStationData.getChildren().clear();
        g.add(lblStationnummer, 1, 0);
        g.add(lblLengte, 1, 1);
        g.add(lblSteeldikte, 1, 2);
        g.add(lblKnophoogte, 1, 3);
        g.add(lblKnopBreedte, 1, 4);
        g.add(lblKleurMin, 1, 5);
        g.add(lblKleurMax, 1, 6);
        g.add(lblRijpheid, 1, 7);
        g.add(lblRijpheidMin, 1, 8);
        g.add(lblRijpheidMax, 1, 9);
        g.add(lblCodering, 1, 10);
        
        g.add(lblDLengte, 2, 1);
        g.add(lblDSteeldikte, 2, 2);
        g.add(lblDKnophoogte, 2, 3);
        g.add(lblDKnopbreedte, 2, 4);
        g.add(lblDKleur, 2, 5);
        g.add(lblDRijpheid, 2, 7);
        //g.add(lblDGeenCat, 0, 11);
        g.add(lblDTotaal, 2, 12);
        
        vbox.getChildren().add(g);
    }
    
    GridPane StationLabel(){
        GridPane g = new GridPane();
        
        Label lbl1 = new Label("Stationnummer: ");
        Label lbl2 = new Label("Lengte: ");
        Label lbl3 = new Label("Steeldikte: ");
        Label lbl4 = new Label("Knophoogte: ");
        Label lbl5 = new Label("Knopbreedte: ");
        Label lbl6 = new Label("Kleur min: ");
        Label lbl7 = new Label("Kleur max: ");
        Label lbl8 = new Label("Rijpheid: ");
        Label lbl9 = new Label("Rijpheid min: ");
        Label lbl10 = new Label("Rijpheid max: ");
        Label lbl11 = new Label("Codering: ");
        
        g.add(lbl1, 0, 0);
        g.add(lbl2, 0, 1);
        g.add(lbl3, 0, 2);
        g.add(lbl4, 0, 3);
        g.add(lbl5, 0, 4);
        g.add(lbl6, 0, 5);
        g.add(lbl7, 0, 6);
        g.add(lbl8, 0, 7);
        g.add(lbl9, 0, 8);
        g.add(lbl10, 0, 9);
        g.add(lbl11, 0, 10);
        
        return g;
    }
    
}
