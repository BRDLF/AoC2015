import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class Day6 {

    static boolean[][] lightGrid = new boolean[1000][1000];
    static int[][] lightGridp2 = new int[1000][1000];

    public static void main(String[] args) {
        try{
            File inFile = new File("input/day6.txt");
            Scanner inData = new Scanner(inFile);
            while(inData.hasNextLine()){
                String dataString = inData.nextLine();
                int sX, sY, eX, eY;
                eY = Integer.parseInt(dataString.substring(dataString.lastIndexOf(",")+1));
                eX = Integer.parseInt(
                        dataString.substring(
                                dataString.lastIndexOf(" ", dataString.lastIndexOf(","))+1,
                                dataString.lastIndexOf(",")
                        )
                );
                sY = Integer.parseInt(
                        dataString.substring(
                                dataString.indexOf(",")+1,
                                dataString.indexOf(" ", dataString.indexOf(","))
                        )
                );
                sX = Integer.parseInt(
                        dataString.substring(
                                dataString.lastIndexOf(" ", dataString.indexOf(","))+1,
                                dataString.indexOf(",")
                        )
                );
                String action = dataString.substring(
                        0, dataString.lastIndexOf(" ", dataString.indexOf(","))
                );

//                System.out.printf(action + ": ");
//                System.out.println( sX + "," + sY + " " + eX + "," + eY);

                for(int loopX = sX; loopX <= eX; loopX++){
                    for(int loopY = sY; loopY <= eY; loopY++){
                        if(action.equals("toggle")){
                            lightGrid[loopX][loopY] = !lightGrid[loopX][loopY];
                            lightGridp2[loopX][loopY] += 2;
                        }
                        if(action.equals("turn on")){
                            lightGrid[loopX][loopY] = true;
                            lightGridp2[loopX][loopY] += 1;
                        }
                        if(action.equals("turn off")){
                            lightGrid[loopX][loopY] = false;
                            lightGridp2[loopX][loopY] = (lightGridp2[loopX][loopY]==0) ? 0 : lightGridp2[loopX][loopY] -1;
                        }
                    }
                }

            }
            int lightsOn = 0;
            int lightBrightness = 0;
            for(int nX = 0; nX < 1000 ; nX++){
                for (int nY = 0; nY < 1000; nY++){
                    if(lightGrid[nX][nY]){
                        lightsOn++;
                    }
                    if(lightGridp2[nX][nY] < 0){
                        System.out.println("There was an error somewhere, we got below 0 brightness at " + nX + ":" + nY);
                    }
                    lightBrightness += lightGridp2[nX][nY];

                }
            }
            System.out.println("There are " + lightsOn + " lights on.");
            System.out.println("The lights have " + lightBrightness + " levels of brightness");
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
