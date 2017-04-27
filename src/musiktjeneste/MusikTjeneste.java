
package musiktjeneste;

import java.io.*;
import javax.swing.*;

/**
 *
 * @author Kalle Wilsen
 */



public class MusikTjeneste {

 
   
    public static void main(String[] args) throws InterruptedException, IOException {
        
        JFrame vindue = new JFrame("Musiktjeneste");
        Faner faner = new Faner();

        vindue.add(faner);
        vindue.pack();
        vindue.setVisible(true);
        
        
 
}
        
    }