/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author thomv
 */
public class Inschrijving {
    private String studentemail;
    private int voorlichtingsmomentronde, opleidingOpleidingsnaam;
    
    public Inschrijving(){
        
    }

    public String getStudentemail() {
        return studentemail;
    }

    public void setStudentemail(String studentemail) {
        this.studentemail = studentemail;
    }

    public int getVoorlichtingsmomentronde() {
        return voorlichtingsmomentronde;
    }

    public void setVoorlichtingsmomentronde(int voorlichtingsmomentronde) {
        this.voorlichtingsmomentronde = voorlichtingsmomentronde;
    }

    public int getOpleidingOpleidingsnaam() {
        return opleidingOpleidingsnaam;
    }

    public void setOpleidingOpleidingsnaam(int opleidingOpleidingsnaam) {
        this.opleidingOpleidingsnaam = opleidingOpleidingsnaam;
    }
    
    
}
