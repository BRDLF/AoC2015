import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day1 {
    public static void main(String[] args) {
        int floor = 0;
        try {
            File inFile = new File("input/day1.txt");
            Scanner myScanner = new Scanner(inFile);
            while (myScanner.hasNextLine()) {
                String data = myScanner.nextLine();

                for (int n = 0; n < data.length(); n++) {
                    if (data.charAt(n) == '(') {
//                        System.out.print("Up ");
                        floor++;
//                        System.out.print(n+1);
//                        System.out.println(" " + floor);
                    } else if (data.charAt(n) == ')') {
//                        System.out.println("Down ");
                        floor--;
//                        System.out.print(n+1);
//                        System.out.println(" " + floor);

                    }
                    if(floor == -1){
                        System.out.println("\r\n" + "Santa reaches basement at position " + (n+1));
                    }
                }

                System.out.println("Santa finishes on floor " + floor);
            }
            myScanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error.");
            e.printStackTrace();
        }
    }
}
