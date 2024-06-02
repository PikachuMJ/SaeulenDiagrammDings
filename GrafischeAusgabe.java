/**
 * erzeugt eine grafische Ausgabe
 * 
 * @author MAP
 * @version 20240529.3
 */
import java.awt.*;                      //Benutzt Programmteile aus dem Paket JAVA AWT
import javax.swing.*;

public class GrafischeAusgabe extends JFrame{
    private final int fWidth;                 //Breite des Programmfensters
    private final int fHeight;                //Höhe   des Programmfensters
    private Insets Iset;                //Objekt für die Innenmaße des Fensters
    private int orgX;                   //erste x - Position der inneren Zeichenfläche
    private int orgY;                   //erste y - Position der inneren Zeichenfläche
    private int iWidth;                 //Breite             der inneren Zeichenfläche
    private int iHeight;                //Höhe               der inneren Zeichenfläche
    private final Color farbeHintergrund;
    private final Color farbeVordergrund;
    private final Color[] farben;
    private int[][] linien;
    private int[][] rechtecke;
    private int[][] kreise;
    private boolean firstPaint=true;    //Merker für den ersten Aufruf der paint Methode
    /**
     * Konstruktor
     */
    public GrafischeAusgabe(int breite, int hoehe, String txtTitle)
    {
        fWidth = breite;
        fHeight = hoehe;
        //allgemeine Fenstereinstellungen        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle(txtTitle);
        setSize(fWidth,fHeight);
        //Zeichenbereich über Insets ermitteln und speichern
        //dafür das Fenster sichtbar machen damit die Abmessungen bekannt sind.
        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);
        Iset=getInsets();
        setSize(fWidth+Iset.left+Iset.right,
                     fHeight+Iset.top+Iset.bottom);
        setResizable(false);
        //ausgabeAbmessungen("Konstruktor:45");
        farbeHintergrund=Color.white;
        farbeVordergrund=Color.black;
        farben = new Color[13];
        farben[0]=farbeVordergrund;
        farben[1]=Color.WHITE;
        farben[2]=Color.BLACK;
        farben[3]=Color.RED;
        farben[4]=Color.GREEN;
        farben[5]=Color.BLUE;
        farben[6]=Color.YELLOW;
        farben[7]=Color.MAGENTA;
        farben[8]=Color.CYAN;
        farben[9]=Color.PINK;
        farben[10]=Color.ORANGE;
        farben[11]=Color.LIGHT_GRAY;
        farben[12]=Color.DARK_GRAY;
    }

    /**Zeichnen Methode des Hauptfensters. Wird vom System aufgerufen, wenn das Fenster
    *angezeigt oder verändert wird (jedes Mal!!!)
    *Sie bekommt als Parameter die Zeichenfläche ZFl auf der gezeichnet werden kann*/
    public void paint(Graphics ZFl){
        int i;
        int cnr;
        if(firstPaint){
            firstPaint=false;
            Iset=getInsets();
            setSize(fWidth+Iset.left+Iset.right,
                         fHeight+Iset.top+Iset.bottom);
            Iset=getInsets();
            orgX=Iset.left;
            orgY=Iset.top;
            iWidth=getSize().width-Iset.left-Iset.right;
            iHeight=getSize().height-Iset.top-Iset.bottom;
        }
        ZFl.setColor(farbeHintergrund);      
        ZFl.fillRect(orgX, orgY, iWidth, iHeight);  //gefülltes Rechteck in der Farbe zeichnen
        ZFl.setColor(farbeVordergrund);                  //Zeichenfarbe auf Schwarz zurücksetzen
        
        if(linien!=null){
            for(i=0;i<linien[0].length;i++){
                cnr=Math.min(Math.abs(linien[4][i]),15);
                ZFl.setColor(farben[cnr]);
                ZFl.drawLine(linien[0][i]+orgX,linien[1][i]+orgY, linien[2][i]+orgX, linien[3][i]+orgY);
                ZFl.setColor(farbeVordergrund);
            }
        }
        if(rechtecke!=null){
            for(i=0;i<rechtecke[0].length;i++){
                cnr=Math.min(Math.abs(rechtecke[4][i]),15);
                ZFl.setColor(farben[cnr]);
                if(rechtecke[4][i]>=0){
                    ZFl.drawRect(rechtecke[0][i]+orgX, rechtecke[1][i]+orgY, rechtecke[2][i], rechtecke[3][i]);
                }else{
                    ZFl.drawRect(rechtecke[0][i]+orgX, rechtecke[1][i]+orgY, rechtecke[2][i], rechtecke[3][i]);
                    ZFl.fillRect(rechtecke[0][i]+orgX, rechtecke[1][i]+orgY, rechtecke[2][i], rechtecke[3][i]);
                }
                ZFl.setColor(farbeVordergrund);
            }
        }
        if(kreise!=null){
            for(i=0;i<kreise[0].length;i++){
                cnr=Math.min(Math.abs(kreise[4][i]),15);
                ZFl.setColor(farben[cnr]);
                if(kreise[4][i]>=0){
                    ZFl.drawOval(kreise[0][i]+orgX, kreise[1][i]+orgY, kreise[2][i], kreise[3][i]);
                }else{
                    ZFl.drawOval(kreise[0][i]+orgX, kreise[1][i]+orgY, kreise[2][i], kreise[3][i]);
                    ZFl.fillOval(kreise[0][i]+orgX, kreise[1][i]+orgY, kreise[2][i], kreise[3][i]);
                }
                ZFl.setColor(farbeVordergrund);
            }
        }
    }
        
    public void zLinie(int p1X, int p1Y, int p2X, int p2Y, int farbe){
        final int iArgs = 5;
        int i;
        int j;
        int idx;
        int[][] tmp;
        if(linien!=null){
            idx= linien[0].length;
            tmp = new int[iArgs][idx+1];
            for(i=0;i<idx;i++){
                for(j=0;j<iArgs;j++){
                    tmp[j][i]=linien[j][i];
                }
            }
        }else{
            tmp= new int[iArgs][1];
            idx=0;
        }
        tmp[0][idx]=p1X;
        tmp[1][idx]=p1Y;
        tmp[2][idx]=p2X;
        tmp[3][idx]=p2Y;
        tmp[4][idx]=farbe;
        linien = tmp;
        repaint();
    }
    
    public void zRechteck(int p1X, int p1Y, int width, int height, int fill){
        final int iArgs = 5;
        int i;
        int j;
        int idx;
        int[][] tmp;
        if(rechtecke!=null){
            idx= rechtecke[0].length;
            tmp = new int[iArgs][idx+1];
            for(i=0;i<idx;i++){
                for(j=0;j<iArgs;j++){
                    tmp[j][i]=rechtecke[j][i];
                }
            }
        }else{
            tmp= new int[iArgs][1];
            idx=0;
        }
        tmp[0][idx]=p1X;
        tmp[1][idx]=p1Y;
        tmp[2][idx]=width;
        tmp[3][idx]=height;
        tmp[4][idx]=fill;
        rechtecke = tmp;
        repaint();
    }

    public void zKreis(int p1X, int p1Y, int width, int fill){
        final int iArgs = 5;
        int i;
        int j;
        int idx;
        int[][] tmp;
        if(kreise!=null){
            idx= kreise[0].length;
            tmp = new int[iArgs][idx+1];
            for(i=0;i<idx;i++){
                for(j=0;j<iArgs;j++){
                    tmp[j][i]=kreise[j][i];
                }
            }
        }else{
            tmp= new int[iArgs][1];
            idx=0;
        }
        tmp[0][idx]=p1X;
        tmp[1][idx]=p1Y;
        tmp[2][idx]=width;
        tmp[3][idx]=width;
        tmp[4][idx]=fill;
        kreise = tmp;
        repaint();
    }

    public void zOval(int p1X, int p1Y, int width, int height, int fill){
        final int iArgs = 5;
        int i;
        int j;
        int idx;
        int[][] tmp;
        if(kreise!=null){
            idx= kreise[0].length;
            tmp = new int[iArgs][idx+1];
            for(i=0;i<idx;i++){
                for(j=0;j<iArgs;j++){
                    tmp[j][i]=kreise[j][i];
                }
            }
        }else{
            tmp= new int[iArgs][1];
            idx=0;
        }
        tmp[0][idx]=p1X;
        tmp[1][idx]=p1Y;
        tmp[2][idx]=width;
        tmp[3][idx]=height;
        tmp[4][idx]=fill;
        kreise = tmp;
        repaint();
    }

}