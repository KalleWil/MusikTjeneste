
package musiktjeneste;


import java.awt.event.*;

import java.io.*;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import org.jaudiotagger.audio.exceptions.CannotReadException;
import org.jaudiotagger.audio.exceptions.InvalidAudioFrameException;
import org.jaudiotagger.audio.exceptions.ReadOnlyFileException;
import org.jaudiotagger.tag.TagException;

/**
 *
 * @author Kalle Wilsen
 */



public class MusikTjeneste{

   
    public static void main(String[] args) throws InterruptedException, IOException, FileNotFoundException, UnsupportedAudioFileException, CannotReadException, TagException, ReadOnlyFileException, InvalidAudioFrameException {
        
        JFrame vindue = new JFrame("Musiktjeneste");
        Faner faner = new Faner();
        ImageIcon icon = new ImageIcon("NodeIcon.png");
        
        vindue.add(faner);
        vindue.setIconImage(icon.getImage());
        vindue.pack();
        vindue.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        vindue.setVisible(true);
}
}
 


