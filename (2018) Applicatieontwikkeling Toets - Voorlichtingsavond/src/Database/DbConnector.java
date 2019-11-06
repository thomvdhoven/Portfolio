/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DbConnector {
    
    //zorg ervoor dat er maar 1 connectie kan zijn met de db
    private static final DbConnector instance = new DbConnector();
    protected DbConnector(){
        
    }
    
    public static DbConnector getInstance(){
        return instance;
    }
    
    //maak een connectie aan
    private Connection createConnection(){
        Connection conn = null;
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            String strConnString = "jdbc:oracle:thin:@localhost:1521:xe";
            conn = DriverManager.getConnection(strConnString,"toetsB1","wachtwoord");
        }catch(Exception e){
            System.err.println(e.getMessage());
        }        
        return conn;        
    }
    
    //haal data op uit de db
    public ResultSet getData(String strSQL){
        ResultSet result = null;
        try{
            Statement stmt = createConnection().createStatement();
            result = stmt.executeQuery(strSQL);
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
        return result;
    }  
    
    //pas data aan in de db
    public int executeDML(String strSQL){
        int result = 0;
        try{
            Statement stmt = createConnection().createStatement();
            result = stmt.executeUpdate(strSQL);
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
        return result;
    }
}

