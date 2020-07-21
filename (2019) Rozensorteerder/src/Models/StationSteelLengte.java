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
public class StationSteelLengte {
    double minSteelLengte;
    double maxSteelLengte;
    int aantalRozen;
    int station1;
    int station2;
    int station3;

    public StationSteelLengte() {
    }

    public double getMinSteelLengte() {
        return minSteelLengte;
    }

    public void setMinSteelLengte(double minSteelLengte) {
        this.minSteelLengte = minSteelLengte;
    }

    public double getMaxSteelLengte() {
        return maxSteelLengte;
    }

    public void setMaxSteelLengte(double maxSteelLengte) {
        this.maxSteelLengte = maxSteelLengte;
    }

    public int getAantalRozen() {
        return aantalRozen;
    }

    public void setAantalRozen(int aantalRozen) {
        this.aantalRozen = aantalRozen;
    }

    public int getStation1() {
        return station1;
    }

    public void setStation1(int station1) {
        this.station1 = station1;
    }

    public int getStation2() {
        return station2;
    }

    public void setStation2(int station2) {
        this.station2 = station2;
    }

    public int getStation3() {
        return station3;
    }

    public void setStation3(int station3) {
        this.station3 = station3;
    }
    
    public void populeerStation(ArrayList<XMLObject> products){
        station1 = 0;
        station2 = 0;
        station3 = 0;
        for (XMLObject p : products){
            double lengte = p.getGemetenLengte();
            if (lengte >= minSteelLengte && lengte <= maxSteelLengte){
                int station = p.getStationnummer();
                switch (station){
                    case 1:
                        station1++;
                        break;
                    case 2:
                        station2++;
                        break;
                    case 3:
                        station3++;
                        break;
                }
            }
        }
        
    }
    
}
