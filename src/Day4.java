import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.regex.*;

public class Day4 {

    private final static String puzzleInput = "ckczppom";

    public static void main(String[] args) {
        for(int li = 0; !checkMd5(li); li++);
    }

    private static boolean checkMd5(int passedInt){
        String toTest = getMd5(puzzleInput + Integer.toString(passedInt));
        if(Pattern.matches("0{6,}.*", toTest)){
            System.out.println("We have a match on: " + passedInt +"!");
            System.out.printf("The hash is: " + toTest);
            return true;
        }
        else return false;
    }

    private static String getMd5(String input){
        try{
            MessageDigest md = MessageDigest.getInstance("MD5");

            byte[] messageDigest = md.digest(input.getBytes());

            BigInteger no = new BigInteger(1, messageDigest);

            String hashtext = no.toString(16);
            while(hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        }

        catch (NoSuchAlgorithmException e){
            throw new RuntimeException(e);
        }
    }
}
