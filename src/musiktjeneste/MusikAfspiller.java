/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package musiktjeneste;

/*import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
*/ //import java.io.PrintWriter;
//import java.util.logging.Level;
//import java.util.logging.Logger;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.*;
import javazoom.jl.player.advanced.AdvancedPlayer;
import java.io.*;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Kalle Wilsen
 */
public final class MusikAfspiller { 
    
    
    
    FileInputStream FIS;
    BufferedInputStream BIS;
    
    public AdvancedPlayer player;
    
    public long pauseLocation;
    public long songLength;
    public long songLengthCurrent;
    
    public String fileLocation; 
    public String omsætningDato;
    
    public int antalAfBrugere;
    public int omsætning = 0;
    public boolean paused;
    public boolean stopped;
    public boolean montørTilstand = false;

    Date dato = new Date();
    java.util.Scanner tastatur = new java.util.Scanner(System.in);  // Opreter Scanner class med navn "tastatur"
 
    
    private ArrayList<Brugere> BrugerListe = new ArrayList<Brugere>(); // arraylist med elementer af typen 'Brugere' 
    private ArrayList<String> HandlingerListe = new ArrayList<String>();    // Til at logge alle relevante handlinger
    
    public MusikAfspiller() throws IOException, FileNotFoundException{
        indlæsBrugere();    // indlæser brugere fra "Brugere.txt"
        indlæsOmsætning();  // indlæser tidligere omsætning. Info til montør
        System.out.println("Startup complete =)");
    }
    
    
public void afspil()
{
    try{
        File file = new File("C:\\Users\\Julian Køster\\Documents\\NetBeansProjects\\MusikTjeneste\\build\\classes\\musiktjeneste\\bip.mp3");
        FIS = new FileInputStream(file);
        BIS = new BufferedInputStream(FIS);
        player = new AdvancedPlayer(BIS);

        songLength = FIS.available(); // returnerer estimat af, hvor mange bytes sangen fylder  // har en værdi på 4379262 bytes
        songLengthCurrent = songLength;
        fileLocation = file + "";

        
        new Thread(){
            public void run(){
                try{ player.play(); }
                catch (Exception e){}
            }
        }.start();
        System.out.println("Afspil");
        omsætning += 5;         // fortjenste på 5 kr pr. afspillet sang
        gemOmsætning();
        }catch(IOException e){} catch (JavaLayerException ex) {
            System.out.println("Sangen findes ikke");
            }
} 

public void stop(){
    if(player != null){
        player.close();
        player = null;
        pauseLocation = 0;
        songLength = 0;
        songLengthCurrent = 0;
        paused = false;
        stopped = true;
        System.out.println("Stop");
   }
}


public void pause(){
   if(player != null){
       try {
           pauseLocation = FIS.available();
           songLengthCurrent = FIS.available();
           player.close();
           player = null;
           paused = true;
           stopped = false;
           System.out.println("Pause");
       } catch (IOException ex) {
       }
   }
}

public void resume()
{
    try{

        FIS = new FileInputStream(fileLocation);
        BIS = new BufferedInputStream(FIS);
        FIS.skip(songLength-pauseLocation);
        songLengthCurrent = FIS.available();
        player = new AdvancedPlayer(BIS);



        new Thread(){
            @Override
            public void run(){
                try{ player.play(); 
                }
                catch (JavaLayerException e){}
            }
        }   .start();
        System.out.println("Resume");
        }   catch(IOException | JavaLayerException e){}
} 



//
// Metode til at indlæse brugere, fra en liste kaldet "Brugere.txt"
//  

    public void indlæsBrugere() throws FileNotFoundException, IOException {
        
        BufferedReader input = new BufferedReader(new FileReader("Brugere.txt"));
        String linje = input.readLine();
        
        if ( input.readLine() == null ) // hvis filen er tom, indlæs da standardindstillinger
        {
            FileWriter fil = new FileWriter("Brugere.txt");
            try (PrintWriter ud = new PrintWriter(fil))
            {
                ud.println("// Dette dokument indeholder alle brugere af vores musikafspillertjeneste");
                ud.println("// 1 angiver premiumabonnement");
                ud.println("// 0 angiver ikke-premiumabonnement");
                ud.println("Julian 1");
                ud.println("Kalle 1");
                ud.println("Lasse 1");
                ud.println("Troels 0");
                ud.close(); // lukker outputstreamen til denne fil
            }
            fil.close();
        }else {
            /*
                    if ( linje.startsWith("/") == false){
                System.out.println("Det virkede");
            }
            */
            {
                while (linje != null && linje.startsWith("\\//") == false) // læs fra filen indtil den er tom, og så længe linjen IKKE starter med //
                {
            
                   String navn;
                   boolean abonnent;

                   String[] bidder;
                   bidder = linje.split(" ");  // split ordende op i bidder adskildt af mellemrum, og gem hver enkelt bid i array 
                   navn = bidder[0];

                   if (Integer.parseInt(bidder[1]) == 1) // brugeren er premiumabonnent hvis der står "1" ud fra deres navn i filen
                   {
                       abonnent = true;
                   } else {
                       abonnent = false;
                   }

                   Brugere bruger = new Brugere();
                   bruger.navn = navn;
                   bruger.abonnent = abonnent;

                   BrugerListe.add(bruger);
                   linje = input.readLine(); // læs en ny linje
     
                   antalAfBrugere++; 
                }
            }
        }        
    }
    
    /*
    * Metode til at udskrive de nuværende brugere af musiktjenesten
    */
    public void udskrivBrugere()
    {
        for (Brugere n: BrugerListe){
            System.out.print(n.navn);
            
            
            if( n.abonnent == true)
            {
                System.out.println("\t Er abonnent");
            } 
            
            if (n.abonnent == false)
            {
                System.out.println("\t Er ikke abonnent");
            }
        }
    }
    
    public void gemOmsætning() throws IOException
    {
        FileWriter fil = new FileWriter("Omsætning.txt");
        try (PrintWriter ud = new PrintWriter(fil))
        {
            
            ud.println(omsætning);
            ud.print(dato.toLocaleString());
            ud.close();
        }    

    }
    
    private void indlæsOmsætning() throws IOException
    {
        BufferedReader input = new BufferedReader(new FileReader("Omsætning.txt"));
        String linje = input.readLine();
        
        while (linje != null )
        {
            String[] bidder = linje.split(" ");
            omsætning = Integer.parseInt(bidder[0]);
             
            linje = input.readLine(); // læser næste linje

            omsætningDato = linje;
            linje = input.readLine();
        }
        input.close();
    }
    
    private boolean getMontørLogin()
    {
        return montørTilstand;
    }
    
    public void montørLogin(String kode)
    {
        System.out.println("Indtast kode");
        String s = tastatur.nextLine();
        if ("1337".equals(kode))    // 1337 er koden
        {
            System.out.println("Logget ind som montør");
            montørTilstand = true;
            HandlingerListe.add("Montørtilstand aktiveret");
        } else{
            System.out.println("Koden er forkert");
            montørTilstand = false;
            HandlingerListe.add("Montørtilstand forsøgt aktiveret, person skrev koden" + kode);
        }
    }
}


