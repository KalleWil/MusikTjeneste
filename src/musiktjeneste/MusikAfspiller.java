
package musiktjeneste;

import com.mpatric.mp3agic.InvalidDataException;
import com.mpatric.mp3agic.UnsupportedTagException;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.advanced.AdvancedPlayer;
import java.io.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import javax.sound.sampled.UnsupportedAudioFileException;
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
    
    public int playlistIndex;

    Date dato = new Date();
    java.util.Scanner tastatur = new java.util.Scanner(System.in);  // Opreter Scanner class med navn "tastatur"
 
    
    public ArrayList<Brugere> BrugerListe = new ArrayList<Brugere>(); // arraylist med elementer af typen 'Brugere' 
    private ArrayList<String> HandlingerListe = new ArrayList<String>();    // Til at logge alle relevante handlinger
    
    public String songName;
    public String artistName;
    public String albumName;
    
    
    
    
    public MusikAfspiller() throws IOException, FileNotFoundException, UnsupportedAudioFileException, CannotReadException, TagException, ReadOnlyFileException, InvalidAudioFrameException{
        indlæsBrugere();    // indlæser brugere fra "Brugere.txt"
        indlæsOmsætning();  // indlæser tidligere omsætning. Info til montør
        System.out.println("Startup complete");
    }
    
    
    
public void songUpdate(File pathFile) throws FileNotFoundException, CannotReadException, TagException, ReadOnlyFileException, InvalidAudioFrameException
{
    try{     
        AudioFile audioFile = AudioFileIO.read(pathFile);
        duration = audioFile.getAudioHeader().getTrackLength();
        InputStream input = new FileInputStream(new File(pathFile.getPath()));
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
    
public void update() throws IOException, UnsupportedTagException, InvalidDataException
    {
        System.out.println("Update blev kaldt");
        try {
            afspillerPanel.initialize();
        } catch (FileNotFoundException | CannotReadException | TagException | ReadOnlyFileException | InvalidAudioFrameException ex) {
            ex.printStackTrace();
        }
    new Thread()
    {
    public void run()
    {
        while (true)
        {
            try 
            {       
                afspillerPanel.update();
                Thread.sleep(100);
            } catch (InterruptedException ex) 
                {
                    ex.printStackTrace();
                }
        }
    }
}.start();
}
    
public void afspil()
{ 
    if(stopped==true)
    {
        try
        {
            FIS = new FileInputStream(file);
            BIS = new BufferedInputStream(FIS);
            player = new AdvancedPlayer(BIS);

            songLength = FIS.available(); // returnerer estimat af, hvor mange bytes sangen fylder  // har en værdi på 4379262 bytes
            songLengthCurrent = songLength;
            //fileLocation = file + "";


            new Thread()
            {
                public void run(){
                    try{ player.play();
                    }
                    catch (Exception e)
                    {
                        e.printStackTrace();
                    }
                }
            }.start();
            paused = false;
            stopped = false;
            System.out.println("Afspil");


            omsætning += 5;         // fortjenste på 5 kr pr. afspillet sang
            gemOmsætning();

            HandlingerListe.add("Følgende sang blev afspillet:  " + songName);
            skrivLog();
        }catch(IOException e){} catch (JavaLayerException ex) 
        {
            System.out.println("Sangen findes ikke");
            ex.printStackTrace();
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
           ex.printStackTrace();
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
                catch (JavaLayerException e){
                    e.printStackTrace();
                }
            }
        }   .start();
        paused = false;
        stopped = false;
        System.out.println("Resume");
        }   catch(IOException | JavaLayerException e)
        {
            e.printStackTrace();
        }
    } 
}



//
// Metode til at indlæse brugere, fra en liste kaldet "Brugere.txt"
//  

    public void indlæsBrugere() throws FileNotFoundException, IOException {
        
        BufferedReader input = new BufferedReader(new FileReader("Brugere.txt"));
        String linje = input.readLine();
        
        if ( input.readLine() == null ) // hvis filen er tom, indlæs da standardindstillinger - Dette er for at undgå programfejl
        {
            FileWriter fil = new FileWriter("Brugere.txt");
            try (PrintWriter ud = new PrintWriter(fil))
            {
                ud.println("# Dette dokument indeholder alle brugere af vores musikafspillertjeneste");
                ud.println("# 1 angiver premiumabonnement");
                ud.println("# 0 angiver ikke-premiumabonnement");
                ud.println("Julian 1234 1");
                ud.println("Kalle 1234 1");
                ud.println("Lasse 1234 1");
                ud.println("Troels 1234 0");
                ud.close(); // lukker outputstreamen til denne fil
            }
            fil.close();
        }else {
            {
                while (linje != null ) // læs fra filen indtil den er tom, og så længe linjen IKKE starter med //
                {
                    if (linje.startsWith("#"))
                    {
                        linje = input.readLine();
                        continue;
                    }
                    
                   String navn;
                   String kode;
                   boolean abonnent;

                   String[] bidder;
                   bidder = linje.split(" ");  // split ordende op i bidder adskildt af mellemrum, og gem hver enkelt bid i array 

                   navn = bidder[0];
                   kode = bidder[1];

                   if (Integer.parseInt(bidder[2]) == 1) // brugeren er premiumabonnent hvis der står "1" ud fra deres navn i filen
                   {
                       abonnent = true;
                   } else {
                       abonnent = false;
                   }

                   Brugere bruger = new Brugere();
                   bruger.setNavn(navn);                // benytter princippet bag indkapsling af klasser
                   bruger.setAbonnentStatus(abonnent);  // -||-
                   bruger.setKode(kode);

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
    
    
    
    /*
    * Metode til at gemme omsætning i fil "Omsætning.txt"
    */
    
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
    
    
    
    /*
    * Metode til at indlæse omsætningn fra tidligere dage, denne metode kaldes ved programstart
    */
    
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
    
    
    /*
    * Metode der returnerer den givne montørtilstand
    */
    
    private boolean getMontørLogin()
    {
        return montørTilstand;
    }
    
    /*
    * Metode til at logge ind som montør. Der kræves en bestemt kode før man er logget ind
    */
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
    
    
    
    /*
    * Metode til at skrive log
    */
    
    private void skrivLog() throws IOException
    {
        
        FileWriter fil = new FileWriter ("log.txt");
        PrintWriter ud = new PrintWriter(fil);
        
        for (String s: HandlingerListe)     // gennemgå hele arraylisten
        {    
            ud.println(s);                  // udskriv hvert string element, på en ny linje i filen log.txt
        }
        ud.close();                         // luk outputstream
    }
    
    
    
    
    /*
    * Metode til at læse logs, bruges kun fra montørpanel
    */
    
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
    
    
    
    /*
    * Denne metode returnerer det element, hvor den givne bruger findes. Finds brugeren ikke returneres -1
    * Metoden bruges til at logge ind i musikafspilleren
    */
    
    public int findDenneBruger(String brugernavn)
    {
        int tæller = 0;
        for (Brugere b : BrugerListe)
        {
            if (b.getNavn().matches(brugernavn)) return tæller;
            tæller++;
        }
        return -1;
    }
}