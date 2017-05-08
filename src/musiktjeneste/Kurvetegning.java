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
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.*;

/**
 *
 * @author Julian
 */
public class Kurvetegning extends JPanel {
    
    public Kurvetegning()
    {
        JFrame vindue = new JFrame("Kurve");
        vindue.add(this);
        vindue.setSize(400, 450);
        vindue.setVisible(true);
    }
    
    
    
    public void paintComponent(Graphics g) // metoden kommer fra Jpanel, og overrides af os med nedenstående kode. Den kaldes kun af systemet
    {
        super.paintComponent(g);
        int y = 400;                        // grafen skal starte i x,y (0,400)
        
        g.drawString("Ugens hit", 200, 50);
        g.drawString("y-akse = afspilninger", 10, 10);
        g.drawString("x-akse = ugens dage", 265, 400);
        g.setColor(Color.blue);

            g.drawLine(0, 400, 50, 360);
            g.drawLine(50, 360, 100, 280);
            g.drawLine(100, 280, 150, 200);
            g.drawLine(150, 200, 200, 60);
            g.drawLine(200, 60, 250, 140);
            g.drawLine(250, 140, 300, 200);
            g.drawLine(300, 200, 350, 210);
            
    }
}
