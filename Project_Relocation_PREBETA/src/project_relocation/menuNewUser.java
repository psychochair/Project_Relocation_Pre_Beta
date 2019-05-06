package project_relocation;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import static project_relocation.Project_Relocation.buttonStyle1;
import static project_relocation.Project_Relocation.comboBoxStyle1;
import static project_relocation.Project_Relocation.labelStyle1;
import static project_relocation.Project_Relocation.user;

/**
 *
 * @author chasa
 */
public class menuNewUser extends BorderPane implements UI {
    
    public menuNewUser(){

        
//Background image
        Image background = new Image("menu1Background2.png",1300,650,true,true);
        ImageView backgroundView = new ImageView(background);
        
        this.getChildren().add(backgroundView);
        
        
        
//Creating UserNameFile
        File usernameFile = new File("resources/usernames.txt");
        
        
//Creating interface
        GridPane mainPane = new GridPane();
        mainPane.setAlignment(Pos.CENTER);
        VBox vBox=new VBox(10);
        HBox buttonBox=new HBox(10);
        
        Label message=new Label("Enter your username \nthen press confirm!");
        message.setStyle(labelStyle1);
        TextField usernameInput=new TextField();
        
        Button confirm=new Button("Confirm");
        confirm.setStyle(buttonStyle1);
        Button back=new Button("Back");
        back.setStyle(buttonStyle1);
        
        Label errorMessage=new Label("");
        errorMessage.setStyle(labelStyle1);
        errorMessage.setVisible(false);
        
        buttonBox.getChildren().addAll(confirm,back);
        vBox.getChildren().addAll(message,usernameInput,buttonBox,errorMessage);
        
        mainPane.getChildren().addAll(vBox);
        
        this.setCenter(mainPane);
        
        
//Confirm button
        confirm.setOnAction(new EventHandler <ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
//Number of line in username file
                int count = 0;
                try {
                    Scanner lineCount=new Scanner(usernameFile);
                    
                    while (lineCount.hasNextLine()) {
                        count++;
                        lineCount.nextLine();
                    }        
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(menuNewUser.class.getName()).log(Level.SEVERE, null, ex);
                }      
                
//Reading textFile, storing usernames in a String array
                String[] usernameList=new String[count];
                try {
                    Scanner lineScan=new Scanner(usernameFile);
                    int i=0;
                    while (lineScan.hasNextLine()) {
                        usernameList[i]=lineScan.nextLine();
                        i++;
                        
                    }        
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(menuNewUser.class.getName()).log(Level.SEVERE, null, ex);
                } 
                
                
                
//Checking new user validity
    //comparing to previous users
                String username=usernameInput.getText();
                String fileUsername="\n"+username;
                
                boolean alreadyExists=false;
                for(int i=0;i<usernameList.length;i++){
                    if (username.equals(usernameList[i])){
                        alreadyExists=true;
                    }
                }
    //checking name validity
                boolean invalidName=false;
                boolean invalidChar=false;
                boolean emptyName=false;
                if (    (username.contains("."))||(username.contains("\\"))||(username.contains("\t"))||(username.contains("\n"))  ){
                    invalidChar=true;
                }
                if(username.trim().isEmpty()||username==null){
                    emptyName=true;
                    System.out.println(emptyName);
                }
                if(invalidChar||emptyName){
                    invalidName=true;
                }
    //if name already exists
                if(alreadyExists==true){
                    errorMessage.setText("\""+username+"\""+" is already taken!");
                    errorMessage.setVisible(true);
                }
    //if name is invalid
                if(invalidChar==true){
                    errorMessage.setText("\""+username+"\""+" is invalid, remove \nnon alpha numerical characters in your username\nalso, try removing any spaces!");
                    errorMessage.setVisible(true);    
                }
                if(emptyName==true){
                    errorMessage.setText("Write your username first!");
                    errorMessage.setVisible(true);
                }
    //if username is valid, creating new user
                Boolean userCreated=false;
                if(alreadyExists==false&&invalidName==false){
                    
                    try {
                        Files.write(Paths.get("resources/usernames.txt"), fileUsername.getBytes(), StandardOpenOption.APPEND);
    //Creating new UserFile
                        userCreated=true;
                    } catch (IOException ex) {
                        Logger.getLogger(menuNewUser.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if(userCreated){            
                    user.setUsername(username);
                    user.setFilePath("resources/usernames/"+username+".txt");
                    try {
                        user.writeFile();
                    } catch (IOException ex) {
                        Logger.getLogger(menuNewUser.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                    Project_Relocation.setScene(Project_Relocation.getNewGameMenu());
                }
            }
        });
        
        back.setOnAction(new EventHandler <ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                Project_Relocation.setScene(Project_Relocation.getMenu1());
            }
        });
    }
}
