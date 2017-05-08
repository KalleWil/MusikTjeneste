
package musiktjeneste;


import com.mpatric.mp3agic.ID3v2;
import com.mpatric.mp3agic.InvalidDataException;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import javax.imageio.ImageIO;
import javax.swing.DefaultListModel;
import javax.swing.Icon;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import org.jaudiotagger.audio.exceptions.CannotReadException;
import org.jaudiotagger.audio.exceptions.InvalidAudioFrameException;
import org.jaudiotagger.audio.exceptions.ReadOnlyFileException;
import org.jaudiotagger.tag.TagException;
import com.mpatric.mp3agic.Mp3File;
import com.mpatric.mp3agic.UnsupportedTagException;
import java.awt.Image;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;



/**
 *
 * @author Kalle Wilsen
 */
public class GUI extends javax.swing.JPanel{

    Faner ejer;
    MusikAfspiller afspiller;
    DefaultListModel DLMPath = new DefaultListModel();
    DefaultListModel DLMName = new DefaultListModel();
    

    public GUI() throws IOException {
     
     initComponents();
     
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jSlider1 = new javax.swing.JSlider();
        jLabel3 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(0, 0, 0));

        jButton1.setBackground(new java.awt.Color(51, 51, 51));
        jButton1.setForeground(new java.awt.Color(153, 153, 153));
        jButton1.setText("Play");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(51, 51, 51));
        jButton3.setForeground(new java.awt.Color(153, 153, 153));
        jButton3.setText("Stop");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel1.setForeground(new java.awt.Color(153, 153, 153));
        jLabel1.setText("00:00");

        jLabel4.setForeground(new java.awt.Color(153, 153, 153));
        jLabel4.setText("00:00");

        jLabel2.setForeground(new java.awt.Color(153, 153, 153));
        jLabel2.setText("--");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(204, 204, 204));
        jLabel5.setText("Song name");

        jLabel6.setForeground(new java.awt.Color(102, 102, 102));
        jLabel6.setText("Artist");

        jLabel7.setForeground(new java.awt.Color(102, 102, 102));
        jLabel7.setText("Album");

        jTable1.setAutoCreateRowSorter(true);
        jTable1.setBackground(new java.awt.Color(0, 0, 0));
        jTable1.setForeground(new java.awt.Color(204, 204, 204));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "", "Song name", "Artist", "Album", "Songlength"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setFillsViewportHeight(true);
        jTable1.setGridColor(new java.awt.Color(0, 0, 0));
        jTable1.setSelectionBackground(new java.awt.Color(51, 51, 51));
        jTable1.setSelectionForeground(new java.awt.Color(204, 204, 204));
        jTable1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable1.setShowHorizontalLines(false);
        jTable1.setShowVerticalLines(false);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
        }

        jSlider1.setBackground(new java.awt.Color(0, 0, 0));
        jSlider1.setValue(0);
        jSlider1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jSlider1MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jSlider1MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jSlider1MouseReleased(evt);
            }
        });

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel1))
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, 789, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(417, 417, 417)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(289, 289, 289))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 497, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(7, 7, 7)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(jButton3)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        
        if(afspiller.player != null && jButton1.getText()=="Pause")
        {
            
            jLabel2.setText("Pause");
            jButton1.setText("Play");
            afspiller.pause();
            
        }
        else if (afspiller.paused == false && jSlider1.getValue()==0)
        {
            
            jLabel2.setText("Play");
            jButton1.setText("Pause");
            afspiller.afspil();
                    
        }
        else
        {
            
            jLabel2.setText("Resume");
            jButton1.setText("Pause");
            afspiller.resume(jSlider1.getValue());
            
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    
    
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
    
    jLabel2.setText("Stop");
    jSlider1.setValue(0);
    jLabel1.setText("00:00");
    jButton1.setText("Play");
    afspiller.stop();
    
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        if (evt.getClickCount() == 2) {
            afspiller.stop();
            int index = jTable1.getSelectedRow();
            System.out.println(index);
            System.out.println(DLMName.get(index));
            System.out.println(DLMPath.get(index));
            afspiller.playlistIndex = index;
            System.out.println("Afspiller index: " + afspiller.playlistIndex);
            afspiller.file=(File) DLMPath.get(index);
            try {
                afspiller.songUpdate(afspiller.file);
            } catch (FileNotFoundException ex) {
            } catch (CannotReadException | TagException | ReadOnlyFileException | InvalidAudioFrameException ex) {
            }

            System.out.println("Songname: " + afspiller.songName);
            System.out.println("Artist: " + afspiller.artistName);
            System.out.println("Album: " + afspiller.albumName);
             
            if(afspiller.songName!=null)
            {
            jLabel5.setText(afspiller.songName);
            jLabel6.setText(afspiller.artistName);
            jLabel7.setText(afspiller.albumName);
            }
            else{
                jLabel5.setText(afspiller.file.getName());
                jLabel6.setText("");
                jLabel7.setText("");
            }
            

            jLabel2.setText("Play");
            jButton1.setText("Pause");
            afspiller.afspil();
            try {        
                getAlbumart();
            } catch (IOException | TagException | ReadOnlyFileException | InvalidAudioFrameException | UnsupportedTagException | InvalidDataException ex) {
            }
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void jSlider1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jSlider1MouseClicked
        
    }//GEN-LAST:event_jSlider1MouseClicked

    private void jSlider1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jSlider1MousePressed
        afspiller.pause();
    }//GEN-LAST:event_jSlider1MousePressed

    private void jSlider1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jSlider1MouseReleased
        if(jButton1.getText()!="Play"){
            afspiller.resume(jSlider1.getValue());
        }
    }//GEN-LAST:event_jSlider1MouseReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    public javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    public javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSlider jSlider1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables

 public void update(){
    
    SwingUtilities.invokeLater(new Runnable() {
    public void run() {
        try {
            int tid = 0;
            if(afspiller.songLength!=0)
            {
                if((int)(afspiller.songLength/24000)==afspiller.duration)
                {
                tid = ((int)(((afspiller.songLength)-(afspiller.FIS.available()))/24000));  // 192 BITrate
                }
                else if((int)(afspiller.songLength/40000)==afspiller.duration)
                { 
                tid = ((int)(((afspiller.songLength)-(afspiller.FIS.available()))/40000));  // 320 BITrate

                }
                else if((int)(afspiller.songLength/16000)==afspiller.duration)
                { 
                tid = ((int)(((afspiller.songLength)-(afspiller.FIS.available()))/16000));  // 128 BITrate

                }
            
            jSlider1.setMaximum((int) ((afspiller.songLength)));
            jSlider1.setValue((int) (( afspiller.songLength - ( afspiller.FIS.available()) )));
            }
            else
            {
                tid=0;
            }
            TimeZone tz = TimeZone.getTimeZone("UTC");
            SimpleDateFormat df = new SimpleDateFormat("mm:ss");
            df.setTimeZone(tz);
            String millisString = df.format(new Date(tid*1000));
            jLabel1.setText(millisString);
            
            df.setTimeZone(tz);
            String millisString2 = df.format(new Date(afspiller.duration*1000));
            jLabel4.setText(millisString2);
            

            if(afspiller.paused==false && afspiller.stopped==false)
            {
                if(afspiller.FIS.available()==0){
                    afspiller.stop();
                    if(afspiller.playlistIndex<(DLMPath.getSize()-1))
                    {
                    afspiller.playlistIndex=afspiller.playlistIndex+1;
                    afspiller.file=(File) DLMPath.get(afspiller.playlistIndex);
                    try {
                afspiller.songUpdate(afspiller.file);
            } catch (FileNotFoundException ex) {
            } catch (CannotReadException | TagException | ReadOnlyFileException | InvalidAudioFrameException ex) {
            }

            System.out.println("Songname: " + afspiller.songName);
            System.out.println("Artist: " + afspiller.artistName);
            System.out.println("Album: " + afspiller.albumName);
             
            if(afspiller.songName!=null)
            {
            jLabel5.setText(afspiller.songName);
            jLabel6.setText(afspiller.artistName);
            jLabel7.setText(afspiller.albumName);
            }
            else{
                jLabel5.setText(afspiller.file.getName());
                jLabel6.setText("");
                jLabel7.setText("");
            }
            

            jLabel2.setText("Play");
            jButton1.setText("Pause");
            afspiller.afspil();
                        try {
                            getAlbumart();
                        } catch (TagException | ReadOnlyFileException | InvalidAudioFrameException | UnsupportedTagException | InvalidDataException ex) {
                        }
            jTable1.setRowSelectionInterval(afspiller.playlistIndex,afspiller.playlistIndex);
                }
                    else{
                        System.out.println("Playlist done");
                        afspiller.stop();
                    }
            }
            }
        } catch (IOException ex) {
        }
    }
    });     
 }
 
 
 public void initialize() throws FileNotFoundException, CannotReadException, TagException, ReadOnlyFileException, InvalidAudioFrameException
 { 
     
   
    for(File dirCounter:afspiller.filesDir){
    String checkMp3;
    checkMp3 = dirCounter.getPath();
    if(checkMp3.endsWith(".mp3"))
    {
    
    DLMPath.addElement(dirCounter);
    try {
            afspiller.songUpdate(dirCounter);
                
            } catch (FileNotFoundException ex) {
            } catch (CannotReadException | TagException | ReadOnlyFileException | InvalidAudioFrameException ex) {
            }
    DLMName.addElement(dirCounter.getName());
    DefaultTableModel tableModel = (DefaultTableModel)jTable1.getModel();
    TimeZone tz = TimeZone.getTimeZone("UTC");
    SimpleDateFormat df = new SimpleDateFormat("mm:ss");
    df.setTimeZone(tz);
    String millisString = df.format(new Date(afspiller.duration*1000));
    //ImageIcon iconTest = new ImageIcon(getClass().getResource("node.jpg"));
    if(afspiller.songName!=null){
    tableModel.addRow(new Object[]{null, afspiller.songName,afspiller.artistName,afspiller.albumName,millisString});
    }
    else{
        tableModel.addRow(new Object[]{null,dirCounter.getName(),null,null,millisString});
    }
    
    }
    }
 }
 
 
 
 public void getAlbumart() throws IOException, TagException, ReadOnlyFileException, InvalidAudioFrameException, UnsupportedTagException, InvalidDataException 
   {

        Mp3File mp3file = new Mp3File(afspiller.file.getPath());
        
        ID3v2 id3v2Tag = (ID3v2) mp3file.getId3v2Tag();
        byte[] imageData = id3v2Tag.getAlbumImage();
        if(imageData!=null)
        {
        Image img = ImageIO.read(new ByteArrayInputStream(imageData)).getScaledInstance(80, 80, BufferedImage.SCALE_SMOOTH);
        jLabel3.setIcon(new ImageIcon(img));
        }
        else{
        Image icon = new ImageIcon(this.getClass().getResource("node.jpg")).getImage();
        Image iconFitToSize = icon.getScaledInstance(80, 80, Image.SCALE_SMOOTH);
        jLabel3.setIcon(new ImageIcon(iconFitToSize));

        }
}
       
   
 


 
 
}


