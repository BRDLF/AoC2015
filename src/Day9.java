import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Day9 {

    static Map<String, HashMap> nodeMap = new HashMap<>();

    public static void main(String[] args) {
        try(Scanner inScan = new Scanner(new FileReader("input/day9.test.txt"))){
//            File inFile = new File("input/day9test.txt");
//            Scanner inScan = new Scanner(fr);
            while(inScan.hasNextLine()){
                String buffer = inScan.nextLine();
                String loc1 = buffer.substring(0, buffer.indexOf(" to "));
                String loc2 = buffer.substring(buffer.indexOf(" to ")+ 4, buffer.indexOf(" = "));
                int locDist = Integer.parseInt(buffer.substring(buffer.indexOf(" = ") + 3));
                if(!nodeMap.containsKey(loc1)){
                    nodeMap.put(loc1, new HashMap<>());
                }
                if(!nodeMap.containsKey(loc2)){
                    nodeMap.put(loc2, new HashMap<>());
                }
                nodeMap.get(loc1).put(loc2, locDist);
                nodeMap.get(loc2).put(loc1, locDist);
            }
            System.out.println(nodeMap);
        }
        catch(FileNotFoundException e){
            e.printStackTrace();
        }
    }


}

class Node{
    String root;
    HashMap<String, Integer> routes;

    Node(String root, String aDest, int aDist){
        this.root = root;
        this.routes.put(aDest, aDist);
    }

    public String toString(){
        return root.concat(routes.toString());
    }

    void addRoute(String str, Integer dist){
        this.routes.put(str, dist);
    }
}