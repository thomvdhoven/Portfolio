/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controls;

import Database.DbConnector;
import Model.Opleiding;
import Views.OpleidingView;
import java.sql.ResultSet;
import java.sql.SQLException;
import static javafx.collections.FXCollections.observableArrayList;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;

/**
 *
 * @author thomv
 */
public class OpleidingControl {
    private OpleidingView sv;
    private final ObservableList<String> items = observableArrayList();

    public OpleidingControl(){
        
    }
    
    public void showView(Pane p){
        sv = new OpleidingView(this);
        p.getChildren().add(sv);
    }
    
    
    //Haal alle data op en geef het aan de listview
    //wordt opgeroepen iedere keer als er een aanpassing wordt gemaakt zodat
    //de weergeven lijst overeenkomt met de database
    public void updateListView(ListView lv){
        items.clear();
        ResultSet rs;
        try {
            //st = new Student();
            rs = weergeven();
            lv.setItems(items);

            while (rs.next()) {
                items.add(rs.getString(1));
                System.out.println(rs.getString(1));
            }

        } catch (SQLException e) {

        }
    }
    
    //SQL Statements
    private ResultSet weergeven(){
        String sql;
        sql = "SELECT * FROM Opleiding";

        ResultSet rs;
        rs = DbConnector.getInstance().getData(sql);
        
        return rs;
    }
    
    //voeg een account toe met de data opgeslagen in het model
    public int invoegen(Opleiding st){
        int gelukt;
        String sql;
        sql = "INSERT INTO Opleiding VALUES(" +
                st.getOpleidingsnaam()+"," +
                "'"+st.getKerndocent()+"')";

        gelukt = DbConnector.getInstance().executeDML(sql);
        return gelukt;
    }
    
    //bewerk een account aan met de data doorgegeven naar de constructor met
    //de data in het model
    public int bewerken(int gn, Opleiding st){
        int gelukt;
        String sql;
        sql = "UPDATE Opleiding SET " +
                "opleidingsnaam = '" + st.getOpleidingsnaam() + "',"+
                "kerndocent = '" + st.getKerndocent() + "' "+
                "WHERE opleidingsnaam = "+gn;
        
        gelukt = DbConnector.getInstance().executeDML(sql);
        return gelukt;
    }
    
    //verwijder een account wiens naam overeen komt met dat van het model
    public int verwijderen(Opleiding st){
        int gelukt;
        String sql;
        sql = "DELETE FROM Opleiding WHERE Opleidingsnaam = "+st.getOpleidingsnaam();

        gelukt = DbConnector.getInstance().executeDML(sql);
        return gelukt;
    }
}
