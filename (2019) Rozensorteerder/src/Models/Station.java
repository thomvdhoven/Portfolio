/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author Thom
 */
public class Station {
    int stationnummer;
    double ingesteldeLengte;
    double ingesteldeSteeldikte;
    double ingesteldeKnophoogte;
    double ingesteldeKnopbreedte;
    double ingesteldeKleurMin;
    double ingesteldeKleurMax;
    double ingesteldeRijpheid;
    double ingesteldeRijpheidMin;
    double ingesteldeRijpheidMax;
    int ingesteldeCodering;
    int doorgelatenLengte;
    int doorgelatenSteeldikte;
    int doorgelatenKnophoogte;
    int doorgelatenKnopbreedte;
    int doorgelatenKleur;
    int doorgelatenRijpheid;
    int doorgelatenGeenCat;
    

    public Station(int stationnummer, double ingesteldeLengte, double ingesteldeSteeldikte, double ingesteldeKnophoogte, double ingesteldeKnopbreedte, double ingesteldeKleurMin, double ingesteldeKleurMax, double ingesteldeRijpheid, double ingesteldeRijpheidMin, double ingesteldeRijpheidMax, int ingesteldeCodering) {
        this.stationnummer = stationnummer;
        this.ingesteldeLengte = ingesteldeLengte;
        this.ingesteldeSteeldikte = ingesteldeSteeldikte;
        this.ingesteldeKnophoogte = ingesteldeKnophoogte;
        this.ingesteldeKnopbreedte = ingesteldeKnopbreedte;
        this.ingesteldeKleurMin = ingesteldeKleurMin;
        this.ingesteldeKleurMax = ingesteldeKleurMax;
        this.ingesteldeRijpheid = ingesteldeRijpheid;
        this.ingesteldeRijpheidMin = ingesteldeRijpheidMin;
        this.ingesteldeRijpheidMax = ingesteldeRijpheidMax;
        this.ingesteldeCodering = ingesteldeCodering;
    }
    
    

    public int getStationnummer() {
        return stationnummer;
    }

    public void setStationnummer(int stationnummer) {
        this.stationnummer = stationnummer;
    }

    public double getIngesteldeLengte() {
        return ingesteldeLengte;
    }

    public void setIngesteldeLengte(double ingesteldeLengte) {
        this.ingesteldeLengte = ingesteldeLengte;
    }

    public double getIngesteldeSteeldikte() {
        return ingesteldeSteeldikte;
    }

    public void setIngesteldeSteeldikte(double ingesteldeSteeldikte) {
        this.ingesteldeSteeldikte = ingesteldeSteeldikte;
    }

    public double getIngesteldeKnophoogte() {
        return ingesteldeKnophoogte;
    }

    public void setIngesteldeKnophoogte(double ingesteldeKnophoogte) {
        this.ingesteldeKnophoogte = ingesteldeKnophoogte;
    }

    public double getIngesteldeKnopbreedte() {
        return ingesteldeKnopbreedte;
    }

    public void setIngesteldeKnopbreedte(double ingesteldeKnopbreedte) {
        this.ingesteldeKnopbreedte = ingesteldeKnopbreedte;
    }

    public double getIngesteldeKleurMin() {
        return ingesteldeKleurMin;
    }

    public void setIngesteldeKleurMin(double ingesteldeKleurMin) {
        this.ingesteldeKleurMin = ingesteldeKleurMin;
    }

    public double getIngesteldeKleurMax() {
        return ingesteldeKleurMax;
    }

    public void setIngesteldeKleurMax(double ingesteldeKleurMax) {
        this.ingesteldeKleurMax = ingesteldeKleurMax;
    }

    public double getIngesteldeRijpheid() {
        return ingesteldeRijpheid;
    }

    public void setIngesteldeRijpheid(double ingesteldeRijpheid) {
        this.ingesteldeRijpheid = ingesteldeRijpheid;
    }

    public double getIngesteldeRijpheidMin() {
        return ingesteldeRijpheidMin;
    }

    public void setIngesteldeRijpheidMin(double ingesteldeRijpheidMin) {
        this.ingesteldeRijpheidMin = ingesteldeRijpheidMin;
    }

    public double getIngesteldeRijpheidMax() {
        return ingesteldeRijpheidMax;
    }

    public void setIngesteldeRijpheidMax(double ingesteldeRijpheidMax) {
        this.ingesteldeRijpheidMax = ingesteldeRijpheidMax;
    }

    public int getIngesteldeCodering() {
        return ingesteldeCodering;
    }

    public void setIngesteldeCodering(int ingesteldeCodering) {
        this.ingesteldeCodering = ingesteldeCodering;
    }

    public int getDoorgelatenLengte() {
        return doorgelatenLengte;
    }

    public void setDoorgelatenLengte(int doorgelatenLengte) {
        this.doorgelatenLengte = doorgelatenLengte;
    }

    public int getDoorgelatenSteeldikte() {
        return doorgelatenSteeldikte;
    }

    public void setDoorgelatenSteeldikte(int doorgelatenSteeldikte) {
        this.doorgelatenSteeldikte = doorgelatenSteeldikte;
    }

    public int getDoorgelatenKnophoogte() {
        return doorgelatenKnophoogte;
    }

    public void setDoorgelatenKnophoogte(int doorgelatenKnophoogte) {
        this.doorgelatenKnophoogte = doorgelatenKnophoogte;
    }

    public int getDoorgelatenKnopbreedte() {
        return doorgelatenKnopbreedte;
    }

    public void setDoorgelatenKnopbreedte(int doorgelatenKnopbreedte) {
        this.doorgelatenKnopbreedte = doorgelatenKnopbreedte;
    }

    public int getDoorgelatenKleur() {
        return doorgelatenKleur;
    }

    public void setDoorgelatenKleur(int doorgelatenKleur) {
        this.doorgelatenKleur = doorgelatenKleur;
    }

    public int getDoorgelatenRijpheid() {
        return doorgelatenRijpheid;
    }

    public void setDoorgelatenRijpheid(int doorgelatenRijpheid) {
        this.doorgelatenRijpheid = doorgelatenRijpheid;
    }

    public int getDoorgelatenGeenCat() {
        return doorgelatenGeenCat;
    }

    public void setDoorgelatenGeenCat(int doorgelatenGeenCat) {
        this.doorgelatenGeenCat = doorgelatenGeenCat;
    }

    public int getDoorgelatenTotaal(){
        return doorgelatenLengte
                + doorgelatenSteeldikte
                + doorgelatenKnophoogte
                + doorgelatenKnopbreedte
                + doorgelatenKleur
                + doorgelatenRijpheid
                + doorgelatenGeenCat;
    }
    
    
    
}
