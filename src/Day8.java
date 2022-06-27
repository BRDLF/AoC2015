import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day8 {

    static ArrayList<String> inputStrings = new ArrayList<>();

    public static void main(String[] args) {

        try{
            File inFile = new File("input/day8.txt");
            Scanner inScan = new Scanner(inFile);
            while (inScan.hasNextLine()){
                inputStrings.add(inScan.nextLine());
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }

        int codeChars = inputStrings.stream().mapToInt(str ->  str.length()).sum();
        int memoryChars = inputStrings.stream().mapToInt(str -> getCharCount(str)).sum();
        int encodedChars = inputStrings.stream().mapToInt(str -> getEncodeCount(str)).sum();

        System.out.println("Literals - Encoded = " + (codeChars - memoryChars));
        System.out.println("Encoded - codeChars = " + (encodedChars - codeChars));
    }

    private static int getCharCount(String str){
        String trimmed = str.substring(1, str.length()-1)
                .replaceAll("\\\\", "@")
                .replaceAll("@\\\"", "!")
                .replaceAll("@@", "#")
                .replaceAll("@x..", "%");
        int toReturn = trimmed.length();
//        System.out.println(str + ": " + trimmed + ": " + str.length() + " to " + toReturn);
        return toReturn;
    }

    private static int getEncodeCount(String str){
        String encoded = "\"".concat(
                str.replaceAll("\\\\", "@")
                        .replaceAll("\"", "\\\\\"")
                        .replaceAll("@", "\\\\\\\\")
                ).concat("\"");
        System.out.println(str + " : " + encoded);
        return encoded.length();
    }

}
