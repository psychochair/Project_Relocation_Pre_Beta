package project_relocation;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


/**
 *
 * @author chasa
 */
//////////////////////HOW TO USE//////////////////////
/*
-use any "get" or "set" method as you wish, but they only temporarily save the info
-addSpecificStar and getLevelStar require the level # input, not the level #-1. Same for the number of stars
-when you want to permanantly save info the the textfile, use void method wrtieFile(). 
*/

//////////////////////FILE FORMAT/////////////////////
/*

1   levelsCompleted
2   stars
3   fuelCapacity
4   protection
5   engineType
6   lvl_1Stars
7   lvl_2Stars
8   lvl_3Stars
9   lvl_4Stars
10  lvl_5Stars
11  lvl_6Stars
12  lvl_7Stars
13  lvl_8Stars
14  lvl_9Stars
15  lvl_10Stars
16  lvl_11Stars
17  lvl_12Stars
18  lvl_13Stars
19  lvl_14Stars
20  lvl_15Stars
21  lvl_16Stars
22  lvl_17Stars
23  lvl_18Stars

*/
public class User {
    
    private static String username;
    private static String filePath; 
    private static int levelsCompleted;
    private static int stars;
    private static int fuelCapacity;
    private static int protection;
    private static int engineType;
    private static String[] starProgress = new String[18];
    
    
    private File userFile=new File("resources/usernames/"+username+".txt");    
    
    public User(){
        username="default";
        filePath="";
        levelsCompleted=0;
        stars=0;
        fuelCapacity=100;
        protection=10;
        engineType=0;
        for(int i=0;i<starProgress.length;i++){
            starProgress[i]=("0,0,0");
        }
    }
    
    public void actualizeFile() throws FileNotFoundException, IOException{
        filePath="resources/usernames/"+username+".txt";
        File userFile=new File(filePath);
        Scanner reader = new Scanner(userFile);
        
        
        levelsCompleted = reader.nextInt();
        stars = reader.nextInt();
        fuelCapacity = reader.nextInt();
        protection = reader.nextInt();
        int engineType = reader.nextInt();
        for(int i=0;i<=17;i++){
            starProgress[i]=reader.next();
        }    
        writeFile();
    }
    
    public static void writeFile() throws FileNotFoundException, IOException{
        
        FileOutputStream deleter = new FileOutputStream(filePath);
        deleter.write(("").getBytes());
        deleter.close();
        
        PrintWriter writer = new PrintWriter(filePath);
        writer.println(levelsCompleted+"\n"+stars+"\n"+fuelCapacity+"\n"+protection+"\n"+engineType);
        for(int i=0;i<starProgress.length;i++){
            writer.println(starProgress[i]);
        }
        writer.close();
    }
    public static void addSpecificStar(int level, int starNum) throws IOException{
        String tempS=starProgress[level-1];
        String[] tempSA=tempS.split(",");
        tempSA[starNum-1]="1";
        starProgress[level-1]=(tempSA[0]+","+tempSA[1]+","+tempSA[2]);
        addStar();
        writeFile();
    }
    public static int[] getLevelStars(int level){        
        String tempS=starProgress[level-1];
        String[] tempSA=tempS.split(",");
        int[] tempIA=new int[3];
        tempIA[0]=Integer.parseInt(tempSA[0]);
        tempIA[1]=Integer.parseInt(tempSA[1]);
        tempIA[2]=Integer.parseInt(tempSA[2]);
        
        return tempIA;
    }
    
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username=username;
    }
    
    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
    
    public int getLevelsCompleted() throws IOException {
        return levelsCompleted;
    }

    public void setLevelsCompleted(int lvlC) throws FileNotFoundException, IOException {
        levelsCompleted=lvlC; 
        System.out.println("lvlC: "+levelsCompleted);
        writeFile();
    }
    
    public void addLevelsCompleted() throws FileNotFoundException, IOException{
        levelsCompleted++;
        writeFile();
    }
    
    public int getStars() {
        return stars;
    }
    public static void removeStars(int n){
        stars=stars-n;
    }
    public void setStars(int stars) throws FileNotFoundException, IOException {
        this.stars = stars;
        writeFile();
    }
    public static void addStar() throws FileNotFoundException, IOException {
        stars++;
        
    }

    public int getFuelCapacity() {
        return fuelCapacity;
    }

    public void setFuelCapacity(int fuelCapacity) throws FileNotFoundException, IOException {
        this.fuelCapacity = fuelCapacity;
        writeFile();
    }

    public int getProtection() {
        return protection;
    }

    public void setProtection(int protection) throws FileNotFoundException, IOException {
        this.protection = protection;
        writeFile();
    }

    public int getEngineType() {
        return engineType;
    }

    public void setEngineType(int engineType) throws FileNotFoundException, IOException {
        this.engineType = engineType;
        writeFile();
    }
    

}
