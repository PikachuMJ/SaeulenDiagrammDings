import java.util.Arrays;

import static javax.swing.JOptionPane.*;
/**  Ich habe noch median und eine Legende hinzugefügt (Ja sieht nicht so gut aus sorry).
 *  Da <code>JOptionPane</code> selbst eine klasse ist, und <code>showMessageDialog</code> ja nur eine methode ist, kann
 *  ich durch das importierten der statischen methoden, das <code>JOptionPane.</code> weglassen.
 *  Einfach gesagt, bin faul*/

public class PRGGA3 {
    static double scale = 2;
    public static void main(String[] args) {
        int[] median = new int[10];
        int gY = 275;
        int sY = (int) (gY*scale);
        int X = 0;
        int width = (int) (500 * scale);
        int height = (int) (350 * scale);
        int answer;
        double avg = 0;
        double med;
        GrafischeAusgabe GA = new GrafischeAusgabe(width, height, "Ausgabefenster");
        //Linie: x1, y1, x2, y2, farbe

        // y-Achse
        GA.zLinie((int) (20 * scale), (int) (275 * scale), (int) (20 * scale), (int) (50 * scale), 2);
        GA.zLinie((int) (4 * scale), (int)(250*scale), (int)(4 * scale), (int) (260 * scale), 2);
        GA.zLinie((int) (4 * scale), (int)(250*scale), (int)(1 * scale), (int) (255 * scale), 2);
        GA.zOval((int)(5*scale),(int)(250*scale), 13, (int)(20*(scale/2)),2);
        // x-Achse
        GA.zLinie((int) (20 * scale), (int) (275 * scale), (int) (470 * scale), (int) (275 * scale), 2);
        //X
        GA.zLinie((int) (455 * scale), (int) (282 * scale), (int) (465 * scale), (int) (297 * scale), 2);
        GA.zLinie((int) (465 * scale), (int) (282 * scale), (int) (455 * scale), (int) (297 * scale), 2);
        //Y
        GA.zLinie((int) (5 * scale), (int) (65 * scale), (int) (10 * scale), (int) (50 * scale), 2);
        GA.zLinie((int) (7 * scale), (int) (60 * scale), (int) (2 * scale), (int) (50 * scale), 2);

        //med kasten blau
        //Rechteck: X, y, width, height, farbe
        GA.zRechteck((int) (150*scale), (int) (300 * scale), (int) (10*scale), (int) (10*scale), -5);
        //med ausgeschrieben
        //M
        GA.zLinie((int) (175*scale), (int) (295 * scale), (int) (175*scale), (int) (310*scale), 2);
        GA.zLinie((int) (175*scale), (int) (295 * scale), (int) (180*scale), (int) (310*scale), 2);
        GA.zLinie((int) (185*scale), (int) (295 * scale), (int) (180*scale), (int) (310*scale), 2);
        GA.zLinie((int)(185*scale), (int) (295 * scale), (int) (185*scale), (int) (310*scale), 2);
        //E
        GA.zLinie((int)(190*scale), (int) (305*scale), (int) (195*scale), (int) (305*scale),2);
        GA.zLinie((int)(195*scale), (int) (305*scale), (int) (195*scale), (int) (301*scale),2);
        GA.zLinie((int)(190*scale), (int) (301*scale), (int) (195*scale), (int) (301*scale),2);
        GA.zLinie((int)(190*scale), (int) (310*scale), (int) (190*scale), (int) (301*scale),2);
        GA.zLinie((int)(190*scale), (int) (310*scale), (int) (195*scale), (int) (310*scale),2);
        //D
        GA.zLinie((int)(200*scale), (int) (310*scale), (int) (200*scale), (int) (303*scale), 2);
        GA.zLinie((int)(200*scale), (int) (310*scale), (int) (204*scale), (int) (310*scale), 2);
        GA.zLinie((int)(200*scale), (int) (303*scale), (int) (204*scale), (int) (303*scale), 2);
        GA.zLinie((int)(204*scale), (int) (310*scale), (int) (204*scale), (int) (298*scale), 2);
        //I (hardest)
        GA.zLinie((int)(208*scale), (int) (311*scale), (int) (208*scale), (int) (298*scale), 2);
        GA.zRechteck((int)(207*scale), (int)(294*scale), (int)(2*scale), (int)(2*scale), -2);
        //a
        GA.zKreis((int)(211*scale), (int)(303*scale), (int)(7*scale), 2);
        GA.zLinie((int)(218*scale),(int)(310*scale), (int)(218*scale), (int)(303*scale), 2);
        //n
        GA.zLinie((int)(222*scale),(int)(311*scale),(int)(222*scale),(int)(302*scale),2);
        GA.zLinie((int)(222*scale),(int)(302*scale),(int)(226*scale),(int)(302*scale),2);
        GA.zLinie((int)(226*scale),(int)(311*scale),(int)(226*scale),(int)(302*scale),2);
        //avg kasten rot
        GA.zRechteck((int) (240*scale), (int) (300 * scale), (int) (10*scale), (int) (10*scale), -3);
        //a
        GA.zKreis((int)(260*scale), (int)(303*scale), (int)(7*scale), 2);
        GA.zLinie((int)(267*scale),(int)(310*scale), (int)(267*scale), (int)(303*scale), 2);
        //v
        GA.zLinie((int)(274*scale),(int)(310*scale), (int)(271*scale), (int)(303*scale), 2);
        GA.zLinie((int)(274*scale),(int)(310*scale), (int)(277*scale), (int)(303*scale), 2);
        //g
        GA.zKreis((int)(280*scale), (int)(303*scale), (int)(7*scale), 2);
        GA.zLinie((int)(287*scale),(int)(313*scale), (int)(287*scale), (int)(303*scale), 2);
        GA.zLinie((int)(280*scale),(int)(313*scale), (int)(287*scale), (int)(313*scale), 2);
        // Höhe verbildlichen
        for (int i = 0; i <= 100; i += 2) {
            if (i % 10 == 0 && i != 0) {
                //Linie für 10
                GA.zLinie((int) (15 * scale), sY, (int) (25 * scale), sY, 2);
            } else if(i % 10 != 0){
                //Linie für 2
                GA.zLinie((int) (18 * scale), sY, (int) (22 * scale), sY, 2);
            }
            sY -= (int) (4 * scale);
        }
        // Pfeile X
        GA.zLinie((int) (470 * scale), (int) (275 * scale), (int) (460 * scale), (int) (270 * scale), 2);
        GA.zLinie((int) (470 * scale), (int) (275 * scale), (int) (460 * scale), (int) (280 * scale), 2);

        // Pfeile Y
        GA.zLinie((int) (20 * scale), (int) (50 * scale), (int) (15 * scale), (int) (60 * scale), 2);
        GA.zLinie((int) (20 * scale), (int) (50 * scale), (int) (25 * scale), (int) (60 * scale), 2);

        // Säulen
        for (int i = 0; i < 10; i++) {
            int rngHeight = (int) (Math.random() * 100) + 1;
            median[i] = rngHeight;
            avg += rngHeight;
            int sclHeight = rngHeight * 2;
            X += (int) (40 * scale);
            System.out.println("Säule: " + (i+1) + " höhe: " + rngHeight);
            GA.zRechteck(X, (int) (275 * scale) - (int) (sclHeight * scale), (int) (20 * scale), (int) (sclHeight * scale), 2);
        }

        avg = avg / 10;
        avg *= 2;
        System.out.println("avg: " + avg / 2);

        X = (int)(20*scale);
        // Gestrichelte Linie für durchschnitt
        for (int i = 0; i < 20; i++) {
            X += (int) (20 * scale);
            GA.zLinie(X, (int) (275 * scale) - (int) (avg * scale), X + (int) (8 * scale), (int) (275 * scale) - (int) (avg * scale), 3);
        }
        //Median
        Arrays.sort(median);
        med = (median[median.length / 2 - 1] + median[median.length / 2]);
        System.out.println("Median: " + med/2);
        X = (int)(10*scale);
        //Gestrichelte Linie für median
        for(int i = 0; i < 20; i++) {
            X += (int) (20 * scale);
            GA.zLinie(X, (int) (275 * scale) - (int) (med * scale), X + (int) (8* scale), (int) (275 * scale) - (int) (med * scale), 5);
        }

        answer = showConfirmDialog(null,
                "Durchschnitt: "+avg / 2+"\n"+"Median: "+med/2+"\nWollen sie nochmal laden?");

        if (answer == 0) {
            GA.dispose();
            PRGGA3.main(args);
        } else {
            System.exit(0);
        }
    }
}
