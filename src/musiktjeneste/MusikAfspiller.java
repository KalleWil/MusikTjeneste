/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package musiktjeneste;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.*;
import javazoom.jl.player.advanced.AdvancedPlayer;
import java.io.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.UnsupportedAudioFileException;
//import java.util.logging.Level;
//import java.util.logging.Logger;
import org.apache.tika.exception.TikaException;
import org.xml.sax.ContentHandler;
import org.xml.sax.helpers.DefaultHandler;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.Parser;
import org.apache.tika.parser.mp3.Mp3Parser;
import org.jaudiotagger.audio.AudioFile;
import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.audio.exceptions.CannotReadException;
import org.jaudiotagger.audio.exceptions.InvalidAudioFrameException;
import org.jaudiotagger.audio.exceptions.ReadOnlyFileException;
import org.jaudiotagger.tag.TagException;
import org.xml.sax.SAXException;

/**
 *
 * @author Kalle Wilsen
 */
public final class MusikAfspiller { 
    //File file = new File("C:\\Users\\Kalle Wilsen\\Music\\Destiny s Child - Say My Name (Cyril Hahn Remix) [mp3edm.eu].mp3");
    //File file = new File("C:\\Users\\Kalle Wilsen\\Documents\\Skoleopgaver\\Java - Objektorienteret programmering\\Projekter\\MusikTjeneste\\src\\musiktjeneste\\bip.mp3");
    //File file = new File("C:\\Users\\Kalle Wilsen\\Music\\Flume - Say It ft. Tove Lo (Illenium Remix).mp3");
    File file = new File("");
    
    
    
    
    
    File dir = new File("\\Users\\Kalle Wilsen\\Music\\");
    File[] filesDir = dir.listFiles();
    
    
    public String filename = file.getName();
    GUI afspillerPanel;
    
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
    public boolean paused = false;
    public boolean stopped = true;
    public boolean montørTilstand = false;
    
    public boolean alwaysUpdate = true;
    
    public int duration;

    Date dato = new Date();
    java.util.Scanner tastatur = new java.util.Scanner(System.in);  // Opreter Scanner class med navn "tastatur"
 
    
    private ArrayList<Brugere> BrugerListe = new ArrayList<Brugere>(); // arraylist med elementer af typen 'Brugere' 
    private ArrayList<String> HandlingerListe = new ArrayList<String>();    // Til at logge alle relevante handlinger
    
    public String songName;
    public String artistName;
    public String albumName;
    
    public MusikAfspiller() throws IOException, FileNotFoundException, UnsupportedAudioFileException, CannotReadException, TagException, ReadOnlyFileException, InvalidAudioFrameException{
        indlæsBrugere();    // indlæser brugere fra "Brugere.txt"
        indlæsOmsætning();  // indlæser tidligere omsætning. Info til montør
        
    }
    
public void songUpdate() throws FileNotFoundException, CannotReadException, TagException, ReadOnlyFileException, InvalidAudioFrameException
{
    try{     
        AudioFile audioFile = AudioFileIO.read(file);
        duration = audioFile.getAudioHeader().getTrackLength();
        InputStream input = new FileInputStream(new File(file.getPath()));
        ContentHandler handler = new DefaultHandler();
        Metadata metadata = new Metadata();
        Parser parser = new Mp3Parser();
        ParseContext parseCtx = new ParseContext();
        parser.parse(input,handler, metadata,parseCtx);
        
        songName = metadata.get("title");
        artistName = metadata.get("xmpDM:artist");
        albumName = metadata.get("xmpDM:album");
        
         } catch (IOException | TikaException | SAXException e){
          e.printStackTrace();
      }
}
    
public void update()
    {
        System.out.println("Update blev kaldt");
        afspillerPanel.initialize();
    new Thread(){
    public void run(){
     while (true){
         try {       
             afspillerPanel.update();
             Thread.sleep(100);
         } catch (InterruptedException ex) {
         }
        }
    }
    }.start();

        
    }
    
public void afspil()
{ if(stopped==true)
{
    try{
        FIS = new FileInputStream(file);
        BIS = new BufferedInputStream(FIS);
        player = new AdvancedPlayer(BIS);

        songLength = FIS.available(); // returnerer estimat af, hvor mange bytes sangen fylder  // har en værdi på 4379262 bytes
        songLengthCurrent = songLength;
        //fileLocation = file + "";

        
        new Thread(){
            public void run(){
                try{ player.play(); }
                catch (Exception e){}
            }
        }.start();
        paused = false;
        stopped = false;
        System.out.println("Afspil");
        
            
        omsætning += 5;         // fortjenste på 5 kr pr. afspillet sang
        gemOmsætning();
        
        HandlingerListe.add("Følgende sang blev afspillet:  " + songName);
        skrivLog();
        }catch(IOException e){} catch (JavaLayerException ex) {
            System.out.println("Sangen findes ikke");
            }
}
} 

public void stop(){
    if(player != null){
        player.close();
/*        player = null;
        pauseLocation = 0;
        songLength = 0;
        songLengthCurrent = 0; */
        paused = false;
        stopped = true;
        System.out.println("Stop");
   }
}


public void pause(){
  if(player != null){
       try {
           pauseLocation = FIS.available();
           player.close();
           stopped = false;
           paused = true;
           System.out.println("Pause");
       } catch (IOException ex) {
       }
   }
}

public void resume(long resumeTime)
{
    if(paused==true)
    {
    try{

        FIS = new FileInputStream(file);
        BIS = new BufferedInputStream(FIS);
        FIS.skip(resumeTime);   //songLength-pauseLocation
        songLengthCurrent = FIS.available();
        player = new AdvancedPlayer(BIS);



        new Thread(){
            public void run(){
                try{ player.play(); 
                }
                catch (JavaLayerException e){}
            }
        }   .start();
        paused = false;
        stopped = false;
        System.out.println("Resume");
        }   catch(IOException | JavaLayerException e){}
} 
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
                while (linje != null )//&& linje.startsWith("\\//") == false) // læs fra filen indtil den er tom, og så længe linjen IKKE starter med //
                {
            
                   if (linje.startsWith("#"))
                   {
                       linje = input.readLine();
                       continue;
                   }
                   
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
                   bruger.setNavn(navn);                // benytter princippet bag indkapsling af klasser
                   bruger.setAbonnentStatus(abonnent);  // -||-

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
            System.out.print(n.getNavn());
            
            
            if( n.getAbonnentStatus() == true)
            {
                System.out.println("\t Er abonnent");
            } 
            
            if (n.getAbonnentStatus() == false)
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
    
    public boolean montørLogin() throws IOException
    {
        System.out.println("Indtast kode");
        String kode = tastatur.nextLine();
        if ("1337".equals(kode))    // 1337 er koden
        {
            System.out.println("Logget ind som montør");
            montørTilstand = true;
            HandlingerListe.add("Montørtilstand aktiveret");
            skrivLog();
            return true;
        } else{
            System.out.println("Koden er forkert");
            montørTilstand = false;
            HandlingerListe.add("Montørtilstand forsøgt aktiveret, person skrev koden " + kode);
            skrivLog();
            return false;
        }

    }
    
    private void skrivLog() throws IOException
    {
        
        FileWriter fil = new FileWriter ("log.txt");
        PrintWriter ud = new PrintWriter(fil);
        
        for (String s: HandlingerListe){    // gennemgå hele arraylisten
            ud.println(s);                  // udskriv hvert string element, på en ny linje i filen log.txt
        }
        ud.close();                         // luk outputstream
    }
    
    public void getLog() throws IOException
    {
        if ( montørTilstand == false){
            System.out.println("Log først ind som montør");
            }
        else if( montørTilstand == true){
            
            BufferedReader ind = new BufferedReader(new FileReader("log.txt"));
            
            String linje = ind.readLine();
            while( linje != null )          // læs indtil filen er tom
            {
                System.out.println(linje);
                linje = ind.readLine();             // læs ny linje
            }
            ind.close();                    // luk inputstream
        }
    }
}
