import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class Day3 {

    private static HashMap<String, Integer> presentMap = new HashMap<String, Integer>();
    private static int santaX, santaY;
    private static int roboSantaX, roboSantaY;

    public static void main(String[] args) {
        try{
            sendPresent('r');
            sendPresent('s');
            File inFile = new File("input/day3.txt");
            Scanner inScan = new Scanner(inFile);
            while(inScan.hasNextLine()){
                String dataString = inScan.nextLine();
                for(int n = 0; n < dataString.length() ; n++){
                    if(n%2 == 1){ move(dataString.charAt(n), 'r'); }
                    else{ move(dataString.charAt(n), 's');}
                }
            }

            System.out.println("Santa has visited " + presentMap.size() + " houses.");

            inScan.close();
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }

//    static String makeCoord(){ return (santaX + ":" + santaY);}
    static String makeCoord(char w){
        if(w == 's'){ return (santaX + ":" + santaY); }
        else if(w == 'r'){ return (roboSantaX + ":" + roboSantaY); }
        else{
            System.out.println("Code error");
            return "";
        }
    }

    static void move(char c, char w){
        if(w=='r'){
            switch (c){
                case '<':
                    roboSantaX--;
                    break;
                case '>':
                    roboSantaX++;
                    break;
                case 'v':
                    roboSantaY--;
                    break;
                case '^':
                    roboSantaY++;
                    break;
                default:
                    System.out.println("Something went wrong! invalid char");
            }
            System.out.println("RoboSanta is at " + makeCoord('r'));
            sendPresent('r');
        }
        else if(w == 's'){
            switch (c){
                case '<':
                    santaX--;
                    break;
                case '>':
                    santaX++;
                    break;
                case 'v':
                    santaY--;
                    break;
                case '^':
                    santaY++;
                    break;
                default:
                    System.out.println("Something went wrong! invalid char");
            }
            System.out.println("Santa is at " + makeCoord('s'));
            sendPresent('s');
        }

        return;
    }

    static void sendPresent(char w){
        if(presentMap.get(makeCoord(w)) == null){
            System.out.println("Currently empty");
        }
        else{
            System.out.println("We have been here, the value was " + presentMap.get(makeCoord(w)));
        }
        presentMap.put(makeCoord(w), presentMap.getOrDefault(makeCoord(w), 0)+1);
        System.out.println("Value is now " + presentMap.get(makeCoord(w)));
        return;
    }
}
