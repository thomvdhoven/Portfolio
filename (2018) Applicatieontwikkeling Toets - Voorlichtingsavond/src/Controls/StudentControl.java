/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controls;

import Database.DbConnector;
import Model.Student;
import Views.StudentView;
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
public class StudentControl {
    private StudentView sv;
    private final ObservableList<String> items = observableArrayList();

    public StudentControl(){
        
    }
    
    public void showView(Pane p){
        sv = new StudentView(this);
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
        sql = "SELECT * FROM Student";

        ResultSet rs;
        rs = DbConnector.getInstance().getData(sql);
        
        return rs;
    }
    
    //voeg een account toe met de data opgeslagen in het model
    public int invoegen(Student st){
        int gelukt;
        String sql;
        sql = "INSERT INTO Student VALUES(";
        sql += "'"+st.getEmail()+"',";
        sql += "'"+st.getNaam()+"',";
        sql += "'"+st.getTelefoonnummer()+"')";

        gelukt = DbConnector.getInstance().executeDML(sql);
        return gelukt;
    }
    
    //bewerk een account aan met de data doorgegeven naar de constructor met
    //de data in het model
    public int bewerken(String gn, Student st){
        int gelukt;
        String sql;
        sql = "UPDATE Student SET " +
                "email = '" + st.getEmail() + "',"+
                "naam = '" + st.getNaam() + "',"+
                "telefoonnummer = '" + st.getTelefoonnummer() + "' "+
                "WHERE email = '"+gn+"'";
        
        gelukt = DbConnector.getInstance().executeDML(sql);
        return gelukt;
    }
    
    //verwijder een account wiens naam overeen komt met dat van het model
    public int verwijderen(Student st){
        int gelukt;
        String sql;
        sql = "DELETE FROM Student WHERE email = '"+st.getEmail()+"'";

        gelukt = DbConnector.getInstance().executeDML(sql);
        return gelukt;
    }
}
