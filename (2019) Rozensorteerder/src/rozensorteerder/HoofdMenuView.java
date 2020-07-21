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
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.DirectoryChooser;
import javafx.stage.Window;

/**
 *
 * @author Thom
 */
public class HoofdMenuView {
    public HoofdMenuView(ArrayList<XMLObject> products, Pane root, StationVerzameling sv){
        VBox vb = new VBox();
        StackPane sp = new StackPane();
        
        MenuBar mb = new MenuBar();
        Menu m1 = new Menu("menu1");
        MenuItem mi1 = new MenuItem("test");
        MenuItem mi2 = new MenuItem("test2");
        MenuItem mi3 = new MenuItem("test3");
        Menu m2 = new Menu("Stations");
        MenuItem mi21 = new MenuItem("Instellingen");
        mi1.setOnAction(e -> {
            sp.getChildren().clear();
            XMLObjectTabelView xotv = new XMLObjectTabelView(products, sp);
        });
        mi2.setOnAction(e -> {
            sp.getChildren().clear();
            StationView st = new StationView(products, 11, sp);
        });
        mi3.setOnAction(e ->{
            sp.getChildren().clear();
            RozenTabelControl rtc = new RozenTabelControl();
            double[][] var2 = { {1.0, 2.0}, {2.0, 3.0}, {3.0, 4.0}, {4.0, 5.0}, {5.0, 6.0}, {6.0, 7.0},
                    {7.0, 8.0},{8.0, 9.0},{9.0, 10.0},{10.0, 11.0},{11.0, 12.0}};
            double[][] var1 = { {0.0, 725.0}, {725.0, 750.0}, {750.0, 775.0},
                    {775.0, 800.0}, {800.0, 825.0}, {825.0, 850.0}, {850.0, 875.0},
                    {875.0, 900.0}, {900.0, 925.0}, {925.0, 950.0}, {950.0, 975.0}, 
                    {975.0, 1000.0}, {1025.0, 2000.0}
            };
            rtc.fillTabel(sp, var1, var2, products);
        });
        mi21.setOnAction(e ->{
            sp.getChildren().clear();
            StationLijstView st = new StationLijstView(sv, sp);
        });
        m1.getItems().add(mi1);
        m1.getItems().add(mi2);
        m1.getItems().add(mi3);
        
        m2.getItems().add(mi21);
        
        mb.getMenus().add(m1);
        mb.getMenus().add(m2);
        
        
        vb.getChildren().addAll(mb, sp);
        root.getChildren().add(vb);
    }
}
