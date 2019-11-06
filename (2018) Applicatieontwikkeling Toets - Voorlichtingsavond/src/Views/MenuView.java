/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Controls.MenuControl;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 *
 * @author thomv
 */
public class MenuView extends VBox{
    
    private Pane p;
    private MenuBar menuBar;
    private Menu mnStudent, mnOpleiding, mnVoorlichtingsmoment, mnInschrijving;
    private MenuItem miStudent, miOpleiding, miVoorlichtingsmoment, miInschrijving;
    
    public MenuView(MenuControl mc){
        p = new Pane();
        
        menuBar = new MenuBar();
        mnStudent = new Menu("Student");
        mnOpleiding = new Menu("Opleiding");
        mnVoorlichtingsmoment = new Menu("Voorlichtingsmoment");
        mnInschrijving = new Menu("Inschrijving");
        miStudent = new MenuItem("Student");
        miOpleiding = new MenuItem("Opleiding");
        miVoorlichtingsmoment = new MenuItem("Voorlichtingsmoment");
        miInschrijving = new MenuItem("Inschrijving");
        
        mnStudent.getItems().add(miStudent);
        mnOpleiding.getItems().add(miOpleiding);
        mnVoorlichtingsmoment.getItems().add(miVoorlichtingsmoment);
        mnInschrijving.getItems().add(miInschrijving);
        
        miStudent.setOnAction(event ->{
            mc.navStudent(p);
        });
        
        miOpleiding.setOnAction(event ->{
            mc.navOpleiding(p);
        });
        
        miVoorlichtingsmoment.setOnAction(event ->{
            mc.navVoorlichtingsmoment(p);
        });
        
        miInschrijving.setOnAction(event ->{
            mc.navInschrijving(p);
        });
        
        menuBar.getMenus().addAll(mnStudent, mnOpleiding, mnVoorlichtingsmoment, mnInschrijving);
        getChildren().addAll(menuBar, p);
        
    }
    
    
}
