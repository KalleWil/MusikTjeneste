/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package musiktjeneste;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.UnsupportedAudioFileException;
import org.jaudiotagger.audio.exceptions.CannotReadException;
import org.jaudiotagger.audio.exceptions.InvalidAudioFrameException;
import org.jaudiotagger.audio.exceptions.ReadOnlyFileException;
import org.jaudiotagger.tag.TagException;

/**
 *
 * @author Julian
 */
public class ManuelJTests {
    
    public static void main(String[] args) throws IOException, FileNotFoundException, UnsupportedAudioFileException, CannotReadException, TagException, TagException, ReadOnlyFileException, ReadOnlyFileException, InvalidAudioFrameException, InvalidAudioFrameException, ReadOnlyFileException 
    {
        MusikAfspiller a = new MusikAfspiller();
        
        /*
        // 1.test
        a.montørTilstand = true;
        a.getLog();
        */
        
        // 2. test
        int i = 0;
        i = a.findDenneBruger("Test");
        if (i == -1){
            System.out.println("Metoden virker efter hensigten\nTest 2 succes");
        } else {
            System.out.println("Metoden gør ikke, hvad den burde gøre");
        }
        
        
        // 3. test
        a.omsætning = 100;
        if ( a.omsætning == 100){
            System.out.println("Test 3 succes");
        } else {
            System.out.println("Test 3 failed");
        }
    }
}
