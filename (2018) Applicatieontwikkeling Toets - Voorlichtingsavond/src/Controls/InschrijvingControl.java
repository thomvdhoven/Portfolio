/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controls;

import Database.DbConnector;
import Model.Inschrijving;
import Views.InschrijvingView;
import java.sql.ResultSet;
import java.sql.SQLException;
import static javafx.collections.FXCollections.observableArrayList;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import javafx.scene.layout.Pane;

/**
 *
 * @author thomv
 */
public class InschrijvingControl {
    private InschrijvingView sv;
    private final ObservableList<Inschrijving> items = observableArrayList();
    private Inschrijving in;
    

    public InschrijvingControl(){
        
    }
    
    public void showView(Pane p){
        sv = new InschrijvingView(this);
        p.getChildren().add(sv);
    }
    
    
    //Haal alle data op en geef het aan de listview
    //wordt opgeroepen iedere keer als er een aanpassing wordt gemaakt zodat
    //de weergeven lijst overeenkomt met de database
    
    public void updateTableView(TableView tv){
        items.clear();
        ResultSet rs;
        try {
            //st = new Student();
            rs = weergeven();
            //tc1.setCellValueFactory(items1);

            while (rs.next()) {
                in = new Inschrijving();
                in.setStudentemail(rs.getString(1));
                in.setVoorlichtingsmomentronde(rs.getInt(2));
                in.setOpleidingOpleidingsnaam(rs.getInt(3));
                
                items.add(in);
                
            }
            tv.setItems(items);

        } catch (SQLException e) {

        }
    }
    
    public void fillCombobox(ComboBox cbxE, ComboBox cbxR, ComboBox cbxO){
        
        fillComboItems(cbxE, "Student");
        fillComboItems(cbxO, "Opleiding");
        fillComboItems(cbxR, "Voorlichtingsmoment");
    }
    
    private void fillComboItems(ComboBox cbx, String table){
        ObservableList<String> itemcbx = observableArrayList();
        String sql;
        sql = "SELECT * FROM " + table;
        
        ResultSet rs;
        rs = DbConnector.getInstance().getData(sql);
        try{
            while (rs.next()){
                itemcbx.add(rs.getString(1));
            }
        }catch (SQLException e) {
            
        }
        
        cbx.setItems(itemcbx);
    }
    
    //SQL Statements
    private ResultSet weergeven(){
        String sql;
        sql = "SELECT * FROM Inschrijving";

        ResultSet rs;
        rs = DbConnector.getInstance().getData(sql);
        
        return rs;
    }
    
    //voeg een account toe met de data opgeslagen in het model
    public int invoegen(Inschrijving st){
        int gelukt;
        String sql;
        sql = "INSERT INTO Inschrijving VALUES(";
        sql += "'"+st.getStudentemail()+"',";
        sql += "'"+st.getVoorlichtingsmomentronde()+"',";
        sql += "'"+st.getOpleidingOpleidingsnaam()+"')";

        gelukt = DbConnector.getInstance().executeDML(sql);
        return gelukt;
    }
    
    //bewerk een account aan met de data doorgegeven naar de constructor met
    //de data in het model
    public int bewerken(int i, Inschrijving st){
        int gelukt;
        String sql;
        Inschrijving st2 = new Inschrijving();
        
        st2 = items.get(i);
        
        sql = "UPDATE Inschrijving SET " +
                "studentemail = '" + st.getStudentemail() + "',"+
                "voorlichtingsmomentronde = '" + st.getVoorlichtingsmomentronde() + "',"+
                "opleidingOpleidingsnaam = '" + st.getOpleidingOpleidingsnaam() + "' "+
                "WHERE studentemail = '"+st2.getStudentemail()+"' AND voorlichtingsmomentronde = " + st2.getVoorlichtingsmomentronde();
        
        gelukt = DbConnector.getInstance().executeDML(sql);
        return gelukt;
    }
    
    //verwijder een account wiens naam overeen komt met dat van het model
    public int verwijderen(int i){
        int gelukt;
        String sql;
        Inschrijving st = new Inschrijving();
        
        st = items.get(i);
        
        sql = "DELETE FROM Inschrijving WHERE studentemail = '"+st.getStudentemail()+
                "' AND voorlichtingsmomentronde = " + st.getVoorlichtingsmomentronde();

        gelukt = DbConnector.getInstance().executeDML(sql);
        return gelukt;
    }
}
