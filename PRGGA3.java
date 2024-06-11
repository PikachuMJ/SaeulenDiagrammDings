import java.util.Arrays;

import static javax.swing.JOptionPane.*;
public class PRGGA3 {
    public static void main(String[] args) throws InterruptedException {
        String[] save = new String[4];
        if(args.length == 4) {
            save = args;
        } else {
            save[0] = "Durchschnitt: ";
            save[1] = "Median: ";
            save[2] = "Max: ";
            save[3] = "Min: ";
        }
        double avg = 0;
        double med;
        double scale = 2;
        int[] rngHeight = new int[10];
        int[] median = new int[10];
        int baseY = 275;
        int scaledY = (int) (baseY*scale);
        int X = 0;
        int width = (int) (500 * scale);
        int height = (int) (350 * scale);
        int answer;
        int max = 0;
        int min = 101;
        GrafischeAusgabe GA = new GrafischeAusgabe(width, height, "Ausgabefenster");
        /*
           Linie: x1, y1, x2, y2, farbe
           y-Achse
        */
        GA.zLinie((int) (20 * scale), (int) (275 * scale), (int) (20 * scale), (int) (50 * scale), 2);

        GA.drawWords("100",(int) (3 * scale), (int) (95*scale));
        GA.drawWords("10", (int) (3 * scale), (int) (275*scale));
        // x-Achse
        GA.zLinie((int) (20 * scale), (int) (275 * scale), (int) (470 * scale), (int) (275 * scale), 2);
        //X
        GA.zLinie((int) (455 * scale), (int) (282 * scale), (int) (465 * scale), (int) (297 * scale), 2);
        GA.zLinie((int) (465 * scale), (int) (282 * scale), (int) (455 * scale), (int) (297 * scale), 2);
        //Y
        GA.zLinie((int) (5 * scale), (int) (65 * scale), (int) (10 * scale), (int) (50 * scale), 2);
        GA.zLinie((int) (7 * scale), (int) (60 * scale), (int) (2 * scale), (int) (50 * scale), 2);
        /*
          Rechteck: X, y, width, height, farbe
          med kasten blau
        */
        GA.zRechteck((int) (150*scale), (int) (300 * scale), (int) (10*scale), (int) (10*scale), -5);
        GA.drawWords("Median", (int) (165 * scale), (int) (325 * scale));
        //avg kasten rot
        GA.zRechteck((int) (240*scale), (int) (300 * scale), (int) (10*scale), (int) (10*scale), -3);
        GA.drawWords("Durchschnitt", (int) (255 * scale), (int) (325 * scale));
        //Max rechteck
        GA.zRechteck((int) (150*scale), (int) (320 * scale), (int) (10*scale), (int) (10*scale), -4);
        GA.drawWords("Max", (int) (165 * scale), (int) (345 * scale));
        //Min rechteck
        GA.zRechteck((int) (240*scale), (int) (320 * scale), (int) (10*scale), (int) (10*scale), -7);
        GA.drawWords("Min", (int) (255 * scale), (int) (345 * scale));
        // Höhe verbildlichen
        for (int i = 0; i <= 100; i += 2) {
            if (i % 10 == 0 && i != 0) {
                //Linie für 10
                GA.zLinie((int) (15 * scale), scaledY, (int) (25 * scale), scaledY, 2);
            } else if(i % 10 != 0){
                //Linie für 2
                GA.zLinie((int) (18 * scale), scaledY, (int) (22 * scale), scaledY, 2);
            }
            scaledY -= (int) (4 * scale);
        }
        // Pfeile X
        GA.zLinie((int) (470 * scale), (int) (275 * scale), (int) (460 * scale), (int) (270 * scale), 2);
        GA.zLinie((int) (470 * scale), (int) (275 * scale), (int) (460 * scale), (int) (280 * scale), 2);

        // Pfeile Y
        GA.zLinie((int) (20 * scale), (int) (50 * scale), (int) (15 * scale), (int) (60 * scale), 2);
        GA.zLinie((int) (20 * scale), (int) (50 * scale), (int) (25 * scale), (int) (60 * scale), 2);

        for(int i = 0; i < 10; i++) {
            rngHeight[i] = (int) (Math.random() * 100) + 1;
            if(rngHeight[i] > max){
                max = rngHeight[i];
            }
            if(rngHeight[i] < min){
                min = rngHeight[i];
            }
        }
        // Säulen
        for (int i = 0; i < 10; i++) {
            median[i] = rngHeight[i];
            avg += rngHeight[i];
            int sclHeight = rngHeight[i] * 2;
            X += (int) (40 * scale);
            if(rngHeight[i] == max){
                GA.zRechteck(X, (int) (275 * scale) - (int) (sclHeight * scale), (int) (20 * scale), (int) (sclHeight * scale), 4);
            } else if (rngHeight[i] == min){
                GA.zRechteck(X, (int) (275 * scale) - (int) (sclHeight * scale), (int) (20 * scale), (int) (sclHeight * scale), 7);
            }else {
                GA.zRechteck(X, (int) (275 * scale) - (int) (sclHeight * scale), (int) (20 * scale), (int) (sclHeight * scale), 2);
            }
        }

        avg = avg / 10;
        avg *= 2;

        X = (int)(20*scale);
        // Gestrichelte Linie für durchschnitt
        for (int i = 0; i < 20; i++) {
            X += (int) (20 * scale);
            GA.zLinie(X, (int) (275 * scale) - (int) (avg * scale), X + (int) (8 * scale), (int) (275 * scale) - (int) (avg * scale), 3);
        }
        //Median
        Arrays.sort(median);
        med = (median[median.length / 2 - 1] + median[median.length / 2]);
        X = (int)(10*scale);
        //Gestrichelte Linie für median
        for(int i = 0; i < 20; i++) {
            X += (int) (20 * scale);
            GA.zLinie(X, (int) (275 * scale) - (int) (med * scale), X + (int) (8* scale), (int) (275 * scale) - (int) (med * scale), 5);
        }
        Thread.sleep(2000);
        String[] options = {"Wiederholen", "stats"};
        answer = showOptionDialog(null,
                "Wiederholen oder stats?","Frage",
                YES_NO_CANCEL_OPTION,QUESTION_MESSAGE,null, options, options[0]);
        save[0] += avg/2;
        save[1] += med;
        save[2] += max;
        save[3] += min;
        if (answer == 0) {
            GA.dispose();
            save[0] += ", ";
            save[1] += ", ";
            save[2] += ", ";
            save[3] += ", ";
            PRGGA3.main(save);
        } else if(answer == 1){
            showMessageDialog(null,
                    save[0]+"\n"
                            +save[1]+"\n"
                            +save[2]+"\n"
                            +save[3]);
            System.exit(0);
        }
    }
}
