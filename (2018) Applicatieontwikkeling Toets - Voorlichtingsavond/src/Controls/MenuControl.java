/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controls;

import Views.MenuView;
import javafx.scene.layout.Pane;

/**
 *
 * @author thomv
 */
public class MenuControl {
    private final MenuView mv;
    private final StudentControl sc;
    private final OpleidingControl oc;
    private final VoorlichtingsmomentControl vc;
    private final InschrijvingControl ic;
    
    public MenuControl(Pane p){
        mv = new MenuView(this);
        sc = new StudentControl();
        oc = new OpleidingControl();
        vc = new VoorlichtingsmomentControl();
        ic = new InschrijvingControl();
        
        p.getChildren().add(mv);
        
    }
    
    public void navStudent(Pane p){
        p.getChildren().clear();
        sc.showView(p);
    }
    
    public void navOpleiding(Pane p){
        p.getChildren().clear();
        oc.showView(p);
    }
    
    public void navVoorlichtingsmoment(Pane p){
        p.getChildren().clear();
        vc.showView(p);
    }
    
    public void navInschrijving(Pane p){
        p.getChildren().clear();
        ic.showView(p);
    }
}
