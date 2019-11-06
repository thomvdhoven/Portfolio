/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Controls.InschrijvingControl;
import Model.Inschrijving;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

/**
 *
 * @author thomv
 */
public class InschrijvingView extends HBox{
    private final TableView tv;
    private final TableColumn tcs, tcv, tco;
    private final Button btnToevoegen, btnAanpassen, btnVerwijderen;
    private final GridPane gp1, gp2;
    
    private final ComboBox cbxE, cbxR, cbxO;
    private final Text lblE, lblR, lblO, lblGelukt;
    
    private Inschrijving st;
    
    public InschrijvingView(InschrijvingControl sc){
        //toekennen van waarden
        tv = new TableView();
        tcs = new TableColumn("Email");
        tcv = new TableColumn("Ronde");
        tco = new TableColumn("Opleiding");
        
        //text
        lblE = new Text("E-mail ");
        lblR = new Text("Ronde ");
        lblO = new Text("Opleiding ");
        lblGelukt = new Text();
        
        //knoppen
        btnToevoegen = new Button("Toevoegen");
        btnAanpassen = new Button("Aanpassen");
        btnVerwijderen = new Button("Verwijderen");
        
        //textvelden
        cbxE = new ComboBox();
        cbxR = new ComboBox();
        cbxO = new ComboBox();
        
        tcs.setCellValueFactory(new PropertyValueFactory<Inschrijving, String>("studentemail"));
        tcv.setCellValueFactory(new PropertyValueFactory<Inschrijving, String>("voorlichtingsmomentronde"));
        tco.setCellValueFactory(new PropertyValueFactory<Inschrijving, String>("opleidingOpleidingsnaam"));
        
        tv.getColumns().addAll(tcs, tcv, tco);
        //Vul de tableview
        sc.updateTableView(tv);
        sc.fillCombobox(cbxE, cbxR, cbxO);
        
        //voeg action events toe aan de knoppen
        //vul eerst het model aan, roep dan de gewenste actie op en update de
        //listview met de nieuwe informatie
        btnToevoegen.setOnAction(event -> {
            st = new Inschrijving();
            st.setStudentemail(cbxE.getSelectionModel().getSelectedItem().toString());
            st.setVoorlichtingsmomentronde(Integer.valueOf(cbxR.getSelectionModel().getSelectedItem().toString()));
            st.setOpleidingOpleidingsnaam(Integer.valueOf(cbxO.getSelectionModel().getSelectedItem().toString()));
            if (sc.invoegen(st) != 0) {
                lblGelukt.setText("Gelukt");
            }
            else{
                lblGelukt.setText("Mislukt");
            }
            sc.updateTableView(tv);
        });
        
        btnAanpassen.setOnAction(event -> {
            st = new Inschrijving();
            st.setStudentemail(cbxE.getSelectionModel().getSelectedItem().toString());
            st.setVoorlichtingsmomentronde(Integer.valueOf(cbxR.getSelectionModel().getSelectedItem().toString()));
            st.setOpleidingOpleidingsnaam(Integer.valueOf(cbxO.getSelectionModel().getSelectedItem().toString()));
            if (sc.bewerken(tv.getSelectionModel().getSelectedIndex(), st) !=0){
                lblGelukt.setText("Gelukt");
            }
            else{
                lblGelukt.setText("Mislukt");
            
            }
            sc.updateTableView(tv);
        });
        
        btnVerwijderen.setOnAction(event ->{
            st = new Inschrijving();
            if (sc.verwijderen(tv.getSelectionModel().getSelectedIndex()) !=0){
                lblGelukt.setText("Gelukt");
            }
            else{
                lblGelukt.setText("Mislukt");
            }        
            sc.updateTableView(tv);
        });
        
        //Gridpane 1 staat links en houdt de listview vast
        gp1 = new GridPane();
        gp1.add(tv,0,0);
        gp1.add(btnVerwijderen,0,1);
        
        //Gridpane 2 staat rechts en huist het invulformulier
        gp2 = new GridPane();
        gp2.add(lblE, 0,1);
        gp2.add(lblR, 0,2);
        gp2.add(lblO, 0,0);
        gp2.add(cbxE,1,1);
        gp2.add(cbxR,1,2);
        gp2.add(cbxO,1,0);
        gp2.add(btnToevoegen,1,3);
        gp2.add(btnAanpassen,1,4);
        gp2.add(lblGelukt,0,5);
        
        
        getChildren().addAll(gp1, gp2);
    }
}
