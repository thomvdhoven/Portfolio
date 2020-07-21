/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Thom
 */
public class StationVerzameling {
    ArrayList<Station> stations = new ArrayList<>();
    
    public StationVerzameling(){};
    
    public void voegToe(int stationnummer, double ingesteldeLengte, double ingesteldeSteeldikte, double ingesteldeKnophoogte, double ingesteldeKnopbreedte, double ingesteldeKleurMin, double ingesteldeKleurMax, double ingesteldeRijpheid, double ingesteldeRijpheidMin, double ingesteldeRijpheidMax, int ingesteldeCodering){
        boolean bestaat = false;
        for (Station s : stations){
            if (s.stationnummer == stationnummer){bestaat = true;}
        }
        if (!bestaat){
            Station station = new Station(stationnummer, ingesteldeLengte, ingesteldeSteeldikte, ingesteldeKnophoogte, ingesteldeKnopbreedte, ingesteldeKleurMin, ingesteldeKleurMax, ingesteldeRijpheid, ingesteldeRijpheidMin, ingesteldeRijpheidMax, ingesteldeCodering);
            stations.add(station);
        }
    
    }
    
    public Station zoek(int stationnummer){
        for (Station s : stations){
            if (s.stationnummer == stationnummer){return s;}
        }
        Station s = new Station(stationnummer, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0);
        return s;
    }
    
    public int aantal(){
        return stations.size();
    }
    
    public void doorgelaten(ArrayList<XMLObject> producten){
        ArrayList<XMLObject> pv = producten;
        //Iterator<XMLObject> i = pv.iterator();
        Iterator<Station> si = stations.iterator();
        for (int index = 1; index <= stations.size(); index++){
            Station s = zoek(index);
            for(XMLObject p : pv){
                
                if (p.stationnummer > s.stationnummer){
                    if (p.getGemetenLengte() < s.ingesteldeLengte){
                        //s.setDoorgelatenLengte(s.getDoorgelatenLengte() + 1);
                        s.doorgelatenLengte++;
                    } else if (p.gemetenSteeldikte < s.ingesteldeSteeldikte){
                        //s.setDoorgelatenSteeldikte(s.getDoorgelatenSteeldikte() + 1);
                        s.doorgelatenSteeldikte++;
                    }
                    else if (p.gemetenKnophoogte < s.ingesteldeKnophoogte){
                        s.doorgelatenKnophoogte++;
                    }
                    else if (p.gemetenKnopbreedte < s.ingesteldeKnopbreedte){
                        s.doorgelatenKnopbreedte++;
                    }
                    else if (p.gemetenKleurwaarde < s.ingesteldeKleurMax){
                        s.doorgelatenKleur++;
                    }
                    else if (p.gemetenRijpheid < s.ingesteldeRijpheidMax){
                        s.doorgelatenRijpheid++;
                    }
                    else{
                        s.doorgelatenGeenCat++;
                    }
                    //s.doorgelatenLengte++;
                }
                else{
                    
                }
            }
        }
    }
}
