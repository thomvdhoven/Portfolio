/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.util.ArrayList;

/**
 *
 * @author thomv
 */
public class ColEntry {
    double minSL;
    double maxSL;
    int totaal;

    public double getMinSL() {
        return minSL;
    }

    public void setMinSL(double minSL) {
        this.minSL = minSL;
    }

    public double getMaxSL() {
        return maxSL;
    }

    public void setMaxSL(double maxSL) {
        this.maxSL = maxSL;
    }

    public int getTotaal() {
        return totaal;
    }

    public void setTotaal(int totaal) {
        this.totaal = totaal;
    }

    public ColEntry(double minSL, double maxSL) {
        this.minSL = minSL;
        this.maxSL = maxSL;
    }
    
    public void fillColEntry(ArrayList<XMLObject> products){
        
    }
}
