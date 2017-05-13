
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
import java.awt.Color;
import java.awt.Component;
import java.awt.Frame;
import java.awt.Image;
import java.awt.Window;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;



/**
 *
 * @author Kalle Wilsen
 */
public class GUI extends javax.swing.JPanel{

    Faner ejer;
    MusikAfspiller afspiller;
    DefaultListModel DLMPath = new DefaultListModel();
    DefaultListModel DLMName = new DefaultListModel();
    DefaultTableModel overtableModel = new DefaultTableModel();
    
    
    

    
    

    public GUI() throws IOException {
     
     initComponents();
     
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        panel1 = new java.awt.Panel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jSlider1 = new javax.swing.JSlider();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(0, 0, 0));

        jTable1.setAutoCreateRowSorter(true);
        jTable1.setBackground(new java.awt.Color(0, 0, 0));
        jTable1.setForeground(new java.awt.Color(204, 204, 204));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "", "Song name", "Artist", "Album", ""
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_LAST_COLUMN);
        jTable1.setFillsViewportHeight(true);
        jTable1.setGridColor(new java.awt.Color(0, 0, 0));
        jTable1.setRowHeight(35);
        jTable1.setRowMargin(-10);
        jTable1.setSelectionBackground(new java.awt.Color(51, 51, 51));
        jTable1.setSelectionForeground(new java.awt.Color(204, 204, 204));
        jTable1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable1.getTableHeader().setReorderingAllowed(false);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(1);
        }

        panel1.setBackground(new java.awt.Color(51, 51, 51));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(204, 204, 204));
        jLabel5.setText("Song name");

        jLabel6.setForeground(new java.awt.Color(102, 102, 102));
        jLabel6.setText("Artist");

        jLabel7.setForeground(new java.awt.Color(102, 102, 102));
        jLabel7.setText("Album");

        jSlider1.setBackground(new java.awt.Color(51, 51, 51));
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

        jLabel1.setForeground(new java.awt.Color(153, 153, 153));
        jLabel1.setText("00:00");

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

        jLabel2.setForeground(new java.awt.Color(153, 153, 153));
        jLabel2.setText("--");

        jButton2.setBackground(new java.awt.Color(51, 51, 51));
        jButton2.setForeground(new java.awt.Color(153, 153, 153));
        jButton2.setText("Afslut");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel4.setForeground(new java.awt.Color(153, 153, 153));
        jLabel4.setText("00:00");

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE)))
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                        .addComponent(jButton2))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSlider1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton3)
                    .addComponent(jButton2)
                    .addComponent(jLabel2)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE))
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18))
            .addGroup(panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 359, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        
        if(afspiller.player != null && jButton1.getText()=="Pause")
        {
            
            jLabel2.setText("Pause");
            jButton1.setText("Play");
            afspiller.pause();
            overtableModel.setValueAt(" | |", afspiller.playlistIndex, 0);
            
            
        }
        else if (afspiller.paused == false && jSlider1.getValue()==0)
        {
            
            jLabel2.setText("Play");
            jButton1.setText("Pause");
            afspiller.afspil();
            overtableModel.setValueAt(" ►", afspiller.playlistIndex, 0);
                    
        }
        else
        {
            
            jLabel2.setText("Resume");
            jButton1.setText("Pause");
            afspiller.resume(jSlider1.getValue());
            overtableModel.setValueAt(" ►", afspiller.playlistIndex, 0);
            
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    
    
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
    
    jLabel2.setText("Stop");
    jSlider1.setValue(0);
    jLabel1.setText("00:00");
    jButton1.setText("Play");
    afspiller.stop();
    overtableModel.setValueAt("", afspiller.playlistIndex, 0);
    
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
                ex.printStackTrace();
            } catch (CannotReadException | TagException | ReadOnlyFileException | InvalidAudioFrameException ex) {
                ex.printStackTrace();
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
            for(int counter=0;counter<overtableModel.getRowCount();counter++){
                overtableModel.setValueAt("", counter, 0);
            }
            overtableModel.setValueAt(" ►", index, 0);
            try {        
                getAlbumart();
            } catch (IOException | TagException | ReadOnlyFileException | InvalidAudioFrameException | UnsupportedTagException | InvalidDataException ex) {
            ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void jSlider1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jSlider1MouseClicked
        
    }//GEN-LAST:event_jSlider1MouseClicked

    private void jSlider1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jSlider1MousePressed
        afspiller.paused=true;
        afspiller.pause();
    }//GEN-LAST:event_jSlider1MousePressed

    private void jSlider1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jSlider1MouseReleased
        if(jButton1.getText()!="Play"){
            afspiller.resume(jSlider1.getValue());
        }
    }//GEN-LAST:event_jSlider1MouseReleased

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        ejer.skiftPanel(1);
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
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
    private java.awt.Panel panel1;
    // End of variables declaration//GEN-END:variables

 public void update(){
    
    SwingUtilities.invokeLater(new Runnable() {
    public void run() {
        try {
            int tid = 0;
            if(afspiller.songLength!=0 && afspiller.paused==false && afspiller.stopped==false)
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
            int sliderValue = (int) (( afspiller.songLength - ( afspiller.FIS.available())));
            jSlider1.setValue(sliderValue);
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
            } catch (   FileNotFoundException | CannotReadException | TagException | ReadOnlyFileException | InvalidAudioFrameException ex) {
                ex.printStackTrace();
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
            overtableModel.setValueAt("", afspiller.playlistIndex-1, 0);
            overtableModel.setValueAt(" ►", afspiller.playlistIndex, 0);

            
                        try {
                            getAlbumart();
                        } catch (TagException | ReadOnlyFileException | InvalidAudioFrameException | UnsupportedTagException | InvalidDataException ex) {
                        ex.printStackTrace();
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
            ex.printStackTrace();
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
                ex.printStackTrace();
            } catch (CannotReadException | TagException | ReadOnlyFileException | InvalidAudioFrameException ex) {
                ex.printStackTrace();
            }
    DLMName.addElement(dirCounter.getName());
    DefaultTableModel tableModel = (DefaultTableModel)jTable1.getModel();
    overtableModel = tableModel;
    TimeZone tz = TimeZone.getTimeZone("UTC");
    SimpleDateFormat df = new SimpleDateFormat("mm:ss");
    df.setTimeZone(tz);
    String millisString = df.format(new Date(afspiller.duration*1000));
    if(afspiller.songName!=null){
    overtableModel.addRow(new Object[]{null, afspiller.songName,afspiller.artistName,afspiller.albumName,millisString});
    }
    else{
        overtableModel.addRow(new Object[]{null,dirCounter.getName(),null,null,millisString});
    }
    /*
    jTable1.getTableHeader().setOpaque(false);
    jTable1.getTableHeader().setBackground(Color.black);
    jTable1.getTableHeader().setForeground(Color.gray);
    */
    jScrollPane2.setBorder(BorderFactory.createEmptyBorder());
    jTable1.getColumnModel().getColumn(0).setMaxWidth(1000);
    jTable1.getColumnModel().getColumn(0).setPreferredWidth(25);
    jTable1.getColumnModel().getColumn(2).setMaxWidth(1000);
    jTable1.getColumnModel().getColumn(2).setPreferredWidth(150);
    jTable1.getColumnModel().getColumn(3).setMaxWidth(1000);
    jTable1.getColumnModel().getColumn(3).setPreferredWidth(400);

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


