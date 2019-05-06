/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project_relocation;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import static project_relocation.Project_Relocation.buttonStyle1;
import static project_relocation.Project_Relocation.buttonStyle2;
import static project_relocation.Project_Relocation.comboBoxStyle1;
import static project_relocation.Project_Relocation.insetSize1;
import static project_relocation.Project_Relocation.labelStyle1;
import static project_relocation.Project_Relocation.labelStyle2;
import static project_relocation.Project_Relocation.sceneHeight;
import static project_relocation.Project_Relocation.sceneWidth;

/**
 *
 * @author sandr
 */
public class menuSelection extends Pane implements UI {
    
        double heightImage = 120;
        double widthImage = 120;
        
        
        GridPane table = new GridPane();
                //GRID PANE FOR BUTTONS CHOICE
        
        static Button bMission1 = new Button("1");
        static Button bMission2 = new Button("2");
        static Button bMission3 = new Button("3");
        static Button bMission4 = new Button("4");
        static Button bMission5 = new Button("5");
        static Button bMission6 = new Button("6");
        static Button bMission7 = new Button("7");
        static Button bMission8 = new Button("8");
        static Button bMission9 = new Button("9");
        static Button bMission10= new Button("10");
        static Button bMission11= new Button("11");
        static Button bMission12= new Button("12");
        static Button bMission13= new Button("13");
        static Button bMission14= new Button("14");
        static Button bMission15= new Button("15");
        static Button bMission16= new Button("16");
        static Button bMission17= new Button("17");
        static Button bMission18= new Button("18");
        
        
        
    public menuSelection(){
        

        
//Background image
        Image background = new Image("menu1Background2.png",1300,650,true,true);
        ImageView backgroundView = new ImageView(background);
        
        this.getChildren().add(backgroundView);



        imageLevelLayout("planet1.png", 1, table);
        imageLevelLayout("planet1.png",  2, table);
        imageLevelLayout("planet1.png",  3, table);
        imageLevelLayout("planet2.png",  4, table);
        imageLevelLayout("planet2.png",  5, table);
        imageLevelLayout("planet2.png",  6, table);
        imageLevelLayout("planet3.png",  7, table);
        imageLevelLayout("planet3.png",  8, table);
        imageLevelLayout("planet3.png",  9, table);
        imageLevelLayout("planet4.png",  10, table);
        imageLevelLayout("planet4.png",  11, table);
        imageLevelLayout("planet4.png",  12, table);
        imageLevelLayout("planet5.png",  13, table);
        imageLevelLayout("planet5.png",  14, table);
        imageLevelLayout("planet5.png",  15, table);
        imageLevelLayout("planet6.png",  16, table);
        imageLevelLayout("planet6.png",  17, table);
        imageLevelLayout("planet6.png",  18, table);

//Code starts here        
        
        
        table.setLayoutX(sceneWidth /4 );
        table.setLayoutY(70);
        table.setAlignment(Pos.CENTER);
        table.setHgap(widthImage);
        table.setVgap(heightImage/4);
        
        //BACK TO MENU BUTTON
        
        HBox buttonBack = new HBox();
        buttonBack.setLayoutX(sceneWidth - 270);
        buttonBack.setLayoutY(sceneHeight - 330);
        Button backMenu = new Button("Back");
        backMenu.setStyle(buttonStyle1);
        buttonBack.getChildren().add(backMenu);
        buttonBack.setAlignment(Pos.BOTTOM_RIGHT);
        
        this.getChildren().add(buttonBack);
        
        backMenu.setOnMouseClicked(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent event) {
                
            Project_Relocation.setScene(Project_Relocation.getMenu1());
               
            }
    });
        //SHOP MENU
        
        HBox shopMenu = new HBox();
        shopMenu.setLayoutX(sceneWidth - 272);
        shopMenu.setLayoutY(sceneHeight - 400);
        Button buttonShop = new Button("Shop");
        buttonShop.setStyle(buttonStyle1);
        shopMenu.getChildren().add(buttonShop);
        
        this.getChildren().add(shopMenu);
        
        buttonShop.setOnMouseClicked(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent event) {
                
            Project_Relocation.setScene(Project_Relocation.getSceneShopMenu());
               
            }
    });
        //TITLE 
        
        HBox titleBox = new HBox();
        titleBox.setLayoutX(sceneWidth /2 -130);
        titleBox.setLayoutY(0);
        Label title= new Label("Missions");
        title.setStyle(labelStyle2);
        titleBox.getChildren().add(title);
        titleBox.setAlignment(Pos.TOP_CENTER);
        
        this.getChildren().add(titleBox);
        
        

        
        bMission1.setStyle(buttonStyle2);
        bMission2.setStyle(buttonStyle2);
        bMission3.setStyle(buttonStyle2);
        bMission4.setStyle(buttonStyle2);
        bMission5.setStyle(buttonStyle2);
        bMission6.setStyle(buttonStyle2);
        bMission7.setStyle(buttonStyle2);
        bMission8.setStyle(buttonStyle2);
        bMission9.setStyle(buttonStyle2);
        bMission10.setStyle(buttonStyle2);
        bMission11.setStyle(buttonStyle2);
        bMission12.setStyle(buttonStyle2);
        bMission13.setStyle(buttonStyle2);
        bMission14.setStyle(buttonStyle2);
        bMission15.setStyle(buttonStyle2);
        bMission16.setStyle(buttonStyle2);
        bMission17.setStyle(buttonStyle2);
        bMission18.setStyle(buttonStyle2);
        
        
        
        
        

         this.getChildren().add(table);
        
       
        
        
        buttonLevelLayout(bMission1, 1, table);
        buttonLevelLayout(bMission2,  2, table);
        buttonLevelLayout(bMission3,  3, table);
        buttonLevelLayout(bMission4,  4, table);
        buttonLevelLayout(bMission5,  5, table);
        buttonLevelLayout(bMission6,  6, table);
        buttonLevelLayout(bMission7,  7, table);
        buttonLevelLayout(bMission8,  8, table);
        buttonLevelLayout(bMission9,  9, table);
        buttonLevelLayout(bMission10,  10, table);
        buttonLevelLayout(bMission11,  11, table);
        buttonLevelLayout(bMission12,  12, table);
        buttonLevelLayout(bMission13,  13, table);
        buttonLevelLayout(bMission14,  14, table);
        buttonLevelLayout(bMission15,  15, table);
        buttonLevelLayout(bMission16,  16, table);
        buttonLevelLayout(bMission17,  17, table);
        buttonLevelLayout(bMission18,  18, table);

            
        bMission1.setOnAction(new EventHandler <ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
            Project_Relocation.setScene(Project_Relocation.getSceneLevel1());
            }
        });
        bMission2.setOnAction(new EventHandler <ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
            Project_Relocation.setScene(Project_Relocation.getSceneLevel2());
            }
        });
        bMission3.setOnAction(new EventHandler <ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
            Project_Relocation.setScene(Project_Relocation.getSceneLevel3());
            }
        });
        bMission4.setOnAction(new EventHandler <ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
            Project_Relocation.setScene(Project_Relocation.getSceneLevel4());
            }
        });
        bMission4.setOnAction(new EventHandler <ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
            Project_Relocation.setScene(Project_Relocation.getSceneLevel4());
            }
        });
        bMission5.setOnAction(new EventHandler <ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
            Project_Relocation.setScene(Project_Relocation.getSceneLevel5());
            }
        });
        bMission6.setOnAction(new EventHandler <ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
            Project_Relocation.setScene(Project_Relocation.getSceneLevel6());
            }
        });
        bMission7.setOnAction(new EventHandler <ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
            Project_Relocation.setScene(Project_Relocation.getSceneLevel7());
            }
        });
        bMission8.setOnAction(new EventHandler <ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
            Project_Relocation.setScene(Project_Relocation.getSceneLevel8());
            }
        });
        bMission9.setOnAction(new EventHandler <ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
            Project_Relocation.setScene(Project_Relocation.getSceneLevel9());
            }
        });
        bMission10.setOnAction(new EventHandler <ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
            Project_Relocation.setScene(Project_Relocation.getSceneLevel10());
            }
        });
        bMission11.setOnAction(new EventHandler <ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
            Project_Relocation.setScene(Project_Relocation.getSceneLevel11());
            }
        });
        bMission12.setOnAction(new EventHandler <ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
            Project_Relocation.setScene(Project_Relocation.getSceneLevel12());
            }
        });
        bMission13.setOnAction(new EventHandler <ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
            Project_Relocation.setScene(Project_Relocation.getSceneLevel13());
            }
        });
        bMission14.setOnAction(new EventHandler <ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
            Project_Relocation.setScene(Project_Relocation.getSceneLevel14());
            }
        });
        bMission15.setOnAction(new EventHandler <ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
            Project_Relocation.setScene(Project_Relocation.getSceneLevel15());
            }
        });
        bMission16.setOnAction(new EventHandler <ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
            Project_Relocation.setScene(Project_Relocation.getSceneLevel16());
            }
        });
        bMission17.setOnAction(new EventHandler <ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
            Project_Relocation.setScene(Project_Relocation.getSceneLevel17());
            }
        });
        bMission18.setOnAction(new EventHandler <ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
            Project_Relocation.setScene(Project_Relocation.getSceneLevel18());
            }
        });
        
            
    }
        public void imageLevelLayout(String url, Integer numberMission, GridPane table){
        
            int x=0;
            int y=0;
            ImageView image1 = new ImageView();
            Image imageMission1 = new Image(url);
            image1.setPreserveRatio(true);
            image1.setFitHeight(heightImage);
            image1.setFitWidth(widthImage);
            image1.setImage(imageMission1);
//            if(numberMission>levelsCompleted+1){
//            image1.setOpacity(0.5);
//            }
            if(numberMission==1 || numberMission==4 || numberMission==7 || numberMission==10 || numberMission==13 || numberMission==16 ){
                x= 0;
                y= (numberMission+2) /3 -1;
            }
            
            else if(numberMission%3 == 0){
                if(numberMission==3 || numberMission==6 || numberMission==9 || numberMission==12 || numberMission==15 || numberMission==18 ){
                    x= 2;
                    y= (numberMission/3) - 1;
                }
            }
               else if((numberMission+1) %3 == 0){
                
                    x= 1;
                    y= ((numberMission+1)/3) - 1;
                
            }
            
            
            table.add(image1, x, y);
            
        }
        
        public void buttonLevelLayout(Button bMission, Integer numberMission, GridPane table){
        
            int x=0;
            int y=0;
            
           
            if(numberMission==1 || numberMission==4 || numberMission==7 || numberMission==10 || numberMission==13 || numberMission==16 ){
                x= 0;
                y= (numberMission+2) /3 -1;
            }
            
            else if(numberMission%3 == 0){
                if(numberMission==3 || numberMission==6 || numberMission==9 || numberMission==12 || numberMission==15 || numberMission==18 ){
                    x= 2;
                    y= (numberMission/3) - 1;
                }
            }
            else if((numberMission+1) %3 == 0){
                
                    x= 1;
                    y= ((numberMission+1)/3) - 1;
                
            }
             
            table.add(bMission, x, y);
            
        }
        
        public static void renderSelectionMenu() throws IOException{
            
            int levelsCompleted = Project_Relocation.user.getLevelsCompleted();
            System.out.println(levelsCompleted);

            if(levelsCompleted==0){
            bMission2.setDisable(true);
            bMission3.setDisable(true);
            bMission4.setDisable(true);
            bMission5.setDisable(true);
            bMission6.setDisable(true);
            bMission7.setDisable(true);
            bMission8.setDisable(true);
            bMission9.setDisable(true);
            bMission10.setDisable(true);
            bMission11.setDisable(true);
            bMission12.setDisable(true);
            bMission13.setDisable(true);
            bMission14.setDisable(true);
            bMission15.setDisable(true);
            bMission16.setDisable(true);
            bMission17.setDisable(true);
            bMission18.setDisable(true);

            bMission2.setOpacity(0.5);
            bMission3.setOpacity(0.5);
            bMission4.setOpacity(0.5);
            bMission5.setOpacity(0.5);
            bMission6.setOpacity(0.5);
            bMission7.setOpacity(0.5);
            bMission8.setOpacity(0.5);
            bMission9.setOpacity(0.5);
            bMission10.setOpacity(0.5);
            bMission11.setOpacity(0.5);
            bMission12.setOpacity(0.5);
            bMission13.setOpacity(0.5);
            bMission14.setOpacity(0.5);
            bMission15.setOpacity(0.5);
            bMission16.setOpacity(0.5);
            bMission17.setOpacity(0.5);
            bMission18.setOpacity(0.5);






            }else if(levelsCompleted==1){
            bMission3.setDisable(true);
            bMission4.setDisable(true);
            bMission5.setDisable(true);
            bMission6.setDisable(true);
            bMission7.setDisable(true);
            bMission8.setDisable(true);
            bMission9.setDisable(true);
            bMission10.setDisable(true);
            bMission11.setDisable(true);
            bMission12.setDisable(true);
            bMission13.setDisable(true);
            bMission14.setDisable(true);
            bMission15.setDisable(true);
            bMission16.setDisable(true);
            bMission17.setDisable(true);
            bMission18.setDisable(true);


            bMission3.setOpacity(0.5);
            bMission4.setOpacity(0.5);
            bMission5.setOpacity(0.5);
            bMission6.setOpacity(0.5);
            bMission7.setOpacity(0.5);
            bMission8.setOpacity(0.5);
            bMission9.setOpacity(0.5);
            bMission10.setOpacity(0.5);
            bMission11.setOpacity(0.5);
            bMission12.setOpacity(0.5);
            bMission13.setOpacity(0.5);
            bMission14.setOpacity(0.5);
            bMission15.setOpacity(0.5);
            bMission16.setOpacity(0.5);
            bMission17.setOpacity(0.5);
            bMission18.setOpacity(0.5);






                }else if(levelsCompleted==2){
            bMission4.setDisable(true);
            bMission5.setDisable(true);
            bMission6.setDisable(true);
            bMission7.setDisable(true);
            bMission8.setDisable(true);
            bMission9.setDisable(true);
            bMission10.setDisable(true);
            bMission11.setDisable(true);
            bMission12.setDisable(true);
            bMission13.setDisable(true);
            bMission14.setDisable(true);
            bMission15.setDisable(true);
            bMission16.setDisable(true);
            bMission17.setDisable(true);
            bMission18.setDisable(true);


            bMission4.setOpacity(0.5);
            bMission5.setOpacity(0.5);
            bMission6.setOpacity(0.5);
            bMission7.setOpacity(0.5);
            bMission8.setOpacity(0.5);
            bMission9.setOpacity(0.5);
            bMission10.setOpacity(0.5);
            bMission11.setOpacity(0.5);
            bMission12.setOpacity(0.5);
            bMission13.setOpacity(0.5);
            bMission14.setOpacity(0.5);
            bMission15.setOpacity(0.5);
            bMission16.setOpacity(0.5);
            bMission17.setOpacity(0.5);
            bMission18.setOpacity(0.5);






                }else if(levelsCompleted==3){

            bMission5.setDisable(true);
            bMission6.setDisable(true);
            bMission7.setDisable(true);
            bMission8.setDisable(true);
            bMission9.setDisable(true);
            bMission10.setDisable(true);
            bMission11.setDisable(true);
            bMission12.setDisable(true);
            bMission13.setDisable(true);
            bMission14.setDisable(true);
            bMission15.setDisable(true);
            bMission16.setDisable(true);
            bMission17.setDisable(true);
            bMission18.setDisable(true);


            bMission5.setOpacity(0.5);
            bMission6.setOpacity(0.5);
            bMission7.setOpacity(0.5);
            bMission8.setOpacity(0.5);
            bMission9.setOpacity(0.5);
            bMission10.setOpacity(0.5);
            bMission11.setOpacity(0.5);
            bMission12.setOpacity(0.5);
            bMission13.setOpacity(0.5);
            bMission14.setOpacity(0.5);
            bMission15.setOpacity(0.5);
            bMission16.setOpacity(0.5);
            bMission17.setOpacity(0.5);
            bMission18.setOpacity(0.5);






            }else if(levelsCompleted==4){
            bMission6.setDisable(true);
            bMission7.setDisable(true);
            bMission8.setDisable(true);
            bMission9.setDisable(true);
            bMission10.setDisable(true);
            bMission11.setDisable(true);
            bMission12.setDisable(true);
            bMission13.setDisable(true);
            bMission14.setDisable(true);
            bMission15.setDisable(true);
            bMission16.setDisable(true);
            bMission17.setDisable(true);
            bMission18.setDisable(true);


            bMission6.setOpacity(0.5);
            bMission7.setOpacity(0.5);
            bMission8.setOpacity(0.5);
            bMission9.setOpacity(0.5);
            bMission10.setOpacity(0.5);
            bMission11.setOpacity(0.5);
            bMission12.setOpacity(0.5);
            bMission13.setOpacity(0.5);
            bMission14.setOpacity(0.5);
            bMission15.setOpacity(0.5);
            bMission16.setOpacity(0.5);
            bMission17.setOpacity(0.5);
            bMission18.setOpacity(0.5);






                }else if(levelsCompleted==5){
            bMission7.setDisable(true);
            bMission8.setDisable(true);
            bMission9.setDisable(true);
            bMission10.setDisable(true);
            bMission11.setDisable(true);
            bMission12.setDisable(true);
            bMission13.setDisable(true);
            bMission14.setDisable(true);
            bMission15.setDisable(true);
            bMission16.setDisable(true);
            bMission17.setDisable(true);
            bMission18.setDisable(true);


            bMission7.setOpacity(0.5);
            bMission8.setOpacity(0.5);
            bMission9.setOpacity(0.5);
            bMission10.setOpacity(0.5);
            bMission11.setOpacity(0.5);
            bMission12.setOpacity(0.5);
            bMission13.setOpacity(0.5);
            bMission14.setOpacity(0.5);
            bMission15.setOpacity(0.5);
            bMission16.setOpacity(0.5);
            bMission17.setOpacity(0.5);
            bMission18.setOpacity(0.5);

                }else if(levelsCompleted==6){
            bMission8.setDisable(true);
            bMission9.setDisable(true);
            bMission10.setDisable(true);
            bMission11.setDisable(true);
            bMission12.setDisable(true);
            bMission13.setDisable(true);
            bMission14.setDisable(true);
            bMission15.setDisable(true);
            bMission16.setDisable(true);
            bMission17.setDisable(true);
            bMission18.setDisable(true);


            bMission8.setOpacity(0.5);
            bMission9.setOpacity(0.5);
            bMission10.setOpacity(0.5);
            bMission11.setOpacity(0.5);
            bMission12.setOpacity(0.5);
            bMission13.setOpacity(0.5);
            bMission14.setOpacity(0.5);
            bMission15.setOpacity(0.5);
            bMission16.setOpacity(0.5);
            bMission17.setOpacity(0.5);
            bMission18.setOpacity(0.5);

                }else if(levelsCompleted==7){
            bMission9.setDisable(true);
            bMission10.setDisable(true);
            bMission11.setDisable(true);
            bMission12.setDisable(true);
            bMission13.setDisable(true);
            bMission14.setDisable(true);
            bMission15.setDisable(true);
            bMission16.setDisable(true);
            bMission17.setDisable(true);
            bMission18.setDisable(true);


            bMission9.setOpacity(0.5);
            bMission10.setOpacity(0.5);
            bMission11.setOpacity(0.5);
            bMission12.setOpacity(0.5);
            bMission13.setOpacity(0.5);
            bMission14.setOpacity(0.5);
            bMission15.setOpacity(0.5);
            bMission16.setOpacity(0.5);
            bMission17.setOpacity(0.5);
            bMission18.setOpacity(0.5);

                }else if(levelsCompleted==8){
            bMission10.setDisable(true);
            bMission11.setDisable(true);
            bMission12.setDisable(true);
            bMission13.setDisable(true);
            bMission14.setDisable(true);
            bMission15.setDisable(true);
            bMission16.setDisable(true);
            bMission17.setDisable(true);
            bMission18.setDisable(true);

            bMission10.setOpacity(0.5);
            bMission11.setOpacity(0.5);
            bMission12.setOpacity(0.5);
            bMission13.setOpacity(0.5);
            bMission14.setOpacity(0.5);
            bMission15.setOpacity(0.5);
            bMission16.setOpacity(0.5);
            bMission17.setOpacity(0.5);
            bMission18.setOpacity(0.5);

                }else if(levelsCompleted==9){
            bMission11.setDisable(true);
            bMission12.setDisable(true);
            bMission13.setDisable(true);
            bMission14.setDisable(true);
            bMission15.setDisable(true);
            bMission16.setDisable(true);
            bMission17.setDisable(true);
            bMission18.setDisable(true);

            bMission11.setOpacity(0.5);
            bMission12.setOpacity(0.5);
            bMission13.setOpacity(0.5);
            bMission14.setOpacity(0.5);
            bMission15.setOpacity(0.5);
            bMission16.setOpacity(0.5);
            bMission17.setOpacity(0.5);
            bMission18.setOpacity(0.5);

                }else if(levelsCompleted==10){
            bMission12.setDisable(true);
            bMission13.setDisable(true);
            bMission14.setDisable(true);
            bMission15.setDisable(true);
            bMission16.setDisable(true);
            bMission17.setDisable(true);
            bMission18.setDisable(true);

            bMission12.setOpacity(0.5);
            bMission13.setOpacity(0.5);
            bMission14.setOpacity(0.5);
            bMission15.setOpacity(0.5);
            bMission16.setOpacity(0.5);
            bMission17.setOpacity(0.5);
            bMission18.setOpacity(0.5);

                }else if(levelsCompleted==11){
            bMission13.setDisable(true);
            bMission14.setDisable(true);
            bMission15.setDisable(true);
            bMission16.setDisable(true);
            bMission17.setDisable(true);
            bMission18.setDisable(true);

            bMission13.setOpacity(0.5);
            bMission14.setOpacity(0.5);
            bMission15.setOpacity(0.5);
            bMission16.setOpacity(0.5);
            bMission17.setOpacity(0.5);
            bMission18.setOpacity(0.5);

                }else if(levelsCompleted==12){
            bMission14.setDisable(true);
            bMission15.setDisable(true);
            bMission16.setDisable(true);
            bMission17.setDisable(true);
            bMission18.setDisable(true);

            bMission14.setOpacity(0.5);
            bMission15.setOpacity(0.5);
            bMission16.setOpacity(0.5);
            bMission17.setOpacity(0.5);
            bMission18.setOpacity(0.5);

                }else if(levelsCompleted==13){
            bMission15.setDisable(true);
            bMission16.setDisable(true);
            bMission17.setDisable(true);
            bMission18.setDisable(true);


            bMission15.setOpacity(0.5);
            bMission16.setOpacity(0.5);
            bMission17.setOpacity(0.5);
            bMission18.setOpacity(0.5);

                }else if(levelsCompleted==14){
            bMission16.setDisable(true);
            bMission17.setDisable(true);
            bMission18.setDisable(true);


            bMission16.setOpacity(0.5);
            bMission17.setOpacity(0.5);
            bMission18.setOpacity(0.5);

                }else if(levelsCompleted==15){
            bMission17.setDisable(true);
            bMission18.setDisable(true);

            bMission17.setOpacity(0.5);
            bMission18.setOpacity(0.5);

                }
                else if(levelsCompleted==16){
            bMission18.setDisable(true);

            bMission18.setOpacity(0.5);

                }
        }
}

