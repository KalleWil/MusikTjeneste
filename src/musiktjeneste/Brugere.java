/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package musiktjeneste;

/**
 *
 * @author Julian
 */
public class Brugere {
    
    private String navn;
    private String kode;  
    private boolean abonnent;
 
    
    public String getNavn(){
    return navn;
    }
    
    public boolean getAbonnentStatus(){
        return abonnent;
    }

    public String getKode(){
        return kode;
    }
     
    public void setNavn(String s) {
        navn = s;
    }

    public void setAbonnentStatus(boolean a) {
        abonnent = a;
    }
    
    public void setKode(String s) {
        kode = s;
    }
}
