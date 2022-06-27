import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class Day7 {

    private static HashMap<String, String> instructions = new HashMap<String, String>();

    public static void main(String[] args) {
        try {
            File inFile = new File("input/day7.txt");
            Scanner inData = new Scanner(inFile);
            while(inData.hasNextLine()){
                String lineBuffer = inData.nextLine();
                instructions.put(lineBuffer.substring(lineBuffer.indexOf(" -> ") + 4), lineBuffer.substring(0, lineBuffer.indexOf(" -> ")));
            }
        }
        catch(FileNotFoundException e){
            e.printStackTrace();
        }
        instructions.put("b", "3176");

        System.out.println(traceWire("a"));
        System.out.println(instructions);
    }

    static int traceWire(String wireName) {
        String toEval = instructions.get(wireName);
        try{
            int toReturn = Integer.parseInt(wireName);
//            System.out.println(wireName + " is " + toReturn);
            return toReturn;
        }catch(NumberFormatException e){}

        System.out.println("Running " + wireName +": "+ toEval);
        if (toEval == null) return -1;
        if (toEval.contains("AND")){
            String op1 = toEval.substring(0, toEval.indexOf(" AND "));
            String op2 = toEval.substring(toEval.indexOf(" AND ") + 5);
//            System.out.println(op1 + " AND " + op2);
            int toReturn = traceWire(op1) & traceWire(op2);
            System.out.println(wireName + " is " + toReturn);
            instructions.put(wireName, String.valueOf(toReturn));
            return toReturn;
        }
        if (toEval.contains("OR")){
            String op1 = toEval.substring(0, toEval.indexOf(" OR "));
            String op2 = toEval.substring(toEval.indexOf(" OR ") + 4);
//            System.out.println(op1 + " OR " + op2);
            int toReturn = traceWire(op1) | traceWire(op2);
            System.out.println(wireName + " is " + toReturn);
            instructions.put(wireName, String.valueOf(toReturn));
            return toReturn;
        }
        if (toEval.contains("LSHIFT")){
            String op1 = toEval.substring(0, toEval.indexOf(" LSHIFT "));
            int op2 = Integer.parseInt(toEval.substring(toEval.indexOf(" LSHIFT ") + 8));
//            System.out.println(op1 + " LSHIFT " + op2);
            int toReturn = traceWire(op1) << op2;
            System.out.println(wireName + " is " + toReturn);
            instructions.put(wireName, String.valueOf(toReturn));
            return toReturn;
        }
        if (toEval.contains("RSHIFT")){
            String op1 = toEval.substring(0, toEval.indexOf(" RSHIFT "));
            int op2 = Integer.parseInt(toEval.substring(toEval.indexOf(" RSHIFT ") + 8));
//            System.out.println(op1 + " RSHIFT " + op2);
            int toReturn = traceWire(op1) >> op2;
            System.out.println(wireName + " is " + toReturn);
            instructions.put(wireName, String.valueOf(toReturn));
            return toReturn;
        }
        if (toEval.contains("NOT")){
            String op1 = toEval.substring(toEval.indexOf("NOT ") + 4);
            int toReturn = ~traceWire(op1) & 65535;
            System.out.println(wireName + " is " + toReturn);
            instructions.put(wireName, String.valueOf(toReturn));
            return toReturn;
        }

        return traceWire(toEval);
    }
}
