import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class day2 {
    public static void main(String[] args) {
        try{
            int tPaper = 0;
            int tRibbon = 0;
            File inFile = new File("input/day2.txt");
            Scanner inScan = new Scanner(inFile);
            while(inScan.hasNextLine()){
                String sBuffer = inScan.nextLine();
                String[] convertMe = sBuffer.split("x");
                int pL = Integer.parseInt(convertMe[0]);
                int pW = Integer.parseInt(convertMe[1]);
                int pH = Integer.parseInt(convertMe[2]);
                System.out.println(pL + "x" + pW + "x" + pH);
                tPaper += calcPaper(pL, pW, pH);
                tRibbon += calcRibbon(pL,pW, pH);
            }
        inScan.close();
            System.out.println("Total paper:" + tPaper);
            System.out.println("Total Ribbon: " + tRibbon);
        } catch (FileNotFoundException e){
            System.out.println("Error");
            e.printStackTrace();
        }
    }

    static int calcPaper(int l, int w, int h){
        int toReturn;
        toReturn = 2*(l*w + w*h + l*h);
        toReturn += Math.min(l*w,Math.min(w*h,l*h));
        System.out.println("returning: " + toReturn);
        return toReturn;
    }

    static int calcRibbon(int l, int w, int h){
        int toReturn;
        toReturn = 2*(l + w + h);
        toReturn -= 2*(Math.max(l, Math.max(w, h)));
        toReturn += l*w*h;
        return toReturn;
    }
}
