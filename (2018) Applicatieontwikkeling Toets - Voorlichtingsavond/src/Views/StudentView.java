/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Controls.StudentControl;
import Model.Student;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

/**
 *
 * @author thomv
 */
public class StudentView extends HBox{
    
    private final ListView lv;
    private final Button btnToevoegen, btnAanpassen, btnVerwijderen;
    private final GridPane gp1, gp2;
    
    private final TextField txtE, txtN, txtT;
    private final Text lblE, lblN, lblT, lblGelukt;
    
    private Student st;
    
    public StudentView(StudentControl sc){
        //toekennen van waarden
        lv = new ListView();
        
        //text
        lblE = new Text("E-mail ");
        lblN = new Text("Naam ");
        lblT = new Text("Telefoonnummer ");
        lblGelukt = new Text();
        
        //knoppen
        btnToevoegen = new Button("Toevoegen");
        btnAanpassen = new Button("Aanpassen");
        btnVerwijderen = new Button("Verwijderen");
        
        //textvelden
        txtE = new TextField();
        txtN = new TextField();
        txtT = new TextField();
        
        //Vul de listview
        sc.updateListView(lv);
        
        //voeg action events toe aan de knoppen
        //vul eerst het model aan, roep dan de gewenste actie op en update de
        //listview met de nieuwe informatie
        btnToevoegen.setOnAction(event -> {
            st = new Student();
            st.setEmail(txtE.getText());
            st.setNaam(txtN.getText());
            st.setTelefoonnummer(txtT.getText());
            if (sc.invoegen(st) != 0) {
                lblGelukt.setText("Gelukt");
            }
            else{
                lblGelukt.setText("Mislukt");
            }
            sc.updateListView(lv);
        });
        
        btnAanpassen.setOnAction(event -> {
            st = new Student();
            st.setEmail(txtE.getText());
            st.setNaam(txtN.getText());
            st.setTelefoonnummer(txtT.getText());
            if (sc.bewerken(lv.getSelectionModel().getSelectedItem().toString(), st) !=0){
                lblGelukt.setText("Gelukt");
            }
            else{
                lblGelukt.setText("Mislukt");
            
            }
            sc.updateListView(lv);
        });
        
        btnVerwijderen.setOnAction(event ->{
            st = new Student();
            st.setEmail(lv.getSelectionModel().getSelectedItem().toString());
            if (sc.verwijderen(st) !=0){
                lblGelukt.setText("Gelukt");
            }
            else{
                lblGelukt.setText("Mislukt");
            }            
            sc.updateListView(lv);
        });
        
        //Gridpane 1 staat links en houdt de listview vast
        gp1 = new GridPane();
        gp1.add(lv,0,0);
        gp1.add(btnVerwijderen,0,1);
        
        //Gridpane 2 staat rechts en huist het invulformulier
        gp2 = new GridPane();
        gp2.add(lblE, 0,1);
        gp2.add(lblT, 0,2);
        gp2.add(lblN, 0,0);
        gp2.add(txtE,1,1);
        gp2.add(txtT,1,2);
        gp2.add(txtN,1,0);
        gp2.add(btnToevoegen,1,3);
        gp2.add(btnAanpassen,1,4);
        gp2.add(lblGelukt,0,5);
        
        
        getChildren().addAll(gp1, gp2);
    }
    
    
}
