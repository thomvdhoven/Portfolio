/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.util.Date;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author thomv
 */
@XmlRootElement
public class XMLObject {
    int programmanummer;
    double gemetenLengte;
    double gemetenSteeldikte;
    double gemetenKnophoogte;
    double gemetenKnopbreedte;
    double gemetenKleurwaarde;
    double gemetenRijpheid;
    double gemetenCoderingBoven;
    double gemetenCoderingOnder;
    int stationnummer;
    Date inserttime;

    public XMLObject() {
    }

    public int getProgrammanummer() {
        return programmanummer;
    }

    @XmlElement
    public void setProgrammanummer(int programmanummer) {
        this.programmanummer = programmanummer;
    }

    public double getGemetenLengte() {
        return gemetenLengte;
    }

    @XmlElement
    public void setGemetenLengte(double gemetenLengte) {
        this.gemetenLengte = gemetenLengte;
    }

    public double getGemetenSteeldikte() {
        return gemetenSteeldikte;
    }

    @XmlElement
    public void setGemetenSteeldikte(double gemetenSteeldikte) {
        this.gemetenSteeldikte = gemetenSteeldikte;
    }

    public double getGemetenKnopHoogte() {
        return gemetenKnophoogte;
    }

    @XmlElement
    public void setGemetenKnopHoogte(double gemetenKnopHoogte) {
        this.gemetenKnophoogte = gemetenKnopHoogte;
    }

    public double getGemetenKnopbreedte() {
        return gemetenKnopbreedte;
    }

    @XmlElement
    public void setGemetenKnopbreedte(double gemetenKnopbreedte) {
        this.gemetenKnopbreedte = gemetenKnopbreedte;
    }

    public double getGemetenKleurwaarde() {
        return gemetenKleurwaarde;
    }

    @XmlElement
    public void setGemetenKleurwaarde(double gemetenKleurwaarde) {
        this.gemetenKleurwaarde = gemetenKleurwaarde;
    }

    public double getGemetenRijpheid() {
        return gemetenRijpheid;
    }

    @XmlElement
    public void setGemetenRijpheid(double gemetenRijpheid) {
        this.gemetenRijpheid = gemetenRijpheid;
    }

    public double getGemetenCoderingBoven() {
        return gemetenCoderingBoven;
    }

    @XmlElement
    public void setGemetenCoderingBoven(double gemetenCoderingBoven) {
        this.gemetenCoderingBoven = gemetenCoderingBoven;
    }

    public double getGemetenCoderingOnder() {
        return gemetenCoderingOnder;
    }

    @XmlElement
    public void setGemetenCoderingOnder(double gemetenCoderingOnder) {
        this.gemetenCoderingOnder = gemetenCoderingOnder;
    }

    public int getStationnummer() {
        return stationnummer;
    }

    @XmlElement
    public void setStationnummer(int stationnummer) {
        this.stationnummer = stationnummer;
    }

    public Date getInserttime() {
        return inserttime;
    }

    @XmlElement
    public void setInserttime(Date inserttime) {
        this.inserttime = inserttime;
    }
    
    
}
