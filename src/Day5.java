import java.util.regex.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day5 {
    public static void main(String[] args) {

        Pattern p1_p1 = Pattern.compile("(.*[aeiou]){3}");
        Pattern p1_p2 = Pattern.compile("(.)\\1");
        Pattern p1_p3 = Pattern.compile("ab|cd|pq|xy");

        Pattern p2_p1 = Pattern.compile("(..).*\\1");
        Pattern p2_p2 = Pattern.compile("(.).\\1");


        int p1_nice = 0;
        int p2_nice = 0;

        try{
            File inFile = new File("input/day5.txt");
            Scanner inScan = new Scanner(inFile);
            while(inScan.hasNextLine()) {
                String dataString = inScan.nextLine();
                if(p1_p1.matcher(dataString).find() &&
                   p1_p2.matcher(dataString).find() &&
                   !p1_p3.matcher(dataString).find()){
                   p1_nice++;
                }

                if(p2_p1.matcher(dataString).find() &&
                   p2_p2.matcher(dataString).find()) {
                   p2_nice++;
                }
            }
            System.out.println("p1_nice: " + p1_nice);
            System.out.printf("p2_nice: " + p2_nice);
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }


}
