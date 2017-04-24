/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package musiktjeneste;

import java.io.*;
import javax.swing.*;

/**
 *
 * @author Kalle Wilsen
 */



public class MusikTjeneste {
    
 
//    
    public static void main(String[] args) throws InterruptedException, IOException {
    
        JFrame vindue = new JFrame("Musiktjeneste");
        
        vindue.add(new Faner());
        vindue.pack();
        vindue.setVisible(true);
 
}
        
    }