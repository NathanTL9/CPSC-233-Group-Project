
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.animation.PauseTransition;
import javafx.util.Duration;
import javafx.animation.AnimationTimer;


import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import static javafx.application.Application.launch;

public class ShipWarfareGUI extends Application {


    private Player player = new Player();
    private ShipWarfare shipWarfare = new ShipWarfare(player);
    private  HBox hBox;
    private  Button button1;
    private  Button button2;
    private  VBox vBox;
    private  Label label1;
    private  Label label;
    private  VBox vBox0;
    private  Label label0;


    public static void main(String args[]) {
        launch(args);
    }


    private int counter = 0;

/*
    public boolean destroyPeasantShipsOrEscape(){
        int calculateLoot = 0;
        String userStrikes="";


        int exitValue = 0;
        int chanceOfEnemyRun = 0;
        Random randomValue = new Random();

        //Player volley
        while (exitValue == 0) {
            if (player.getGuns() > 0) {

                for (int j = 0; j < player.getGuns(); j++) {
                    if (shipWarfare.isUserAttacks() == true) {
                        int hitOrMiss = randomValue.nextInt(2) + 1;
                        if (hitOrMiss == 2) {
                            shipWarfare.setNumOfPeasantShips(shipWarfare.getNumOfPeasantShips()-1);

                            if (shipWarfare.getNumOfPeasantShips() <= 0) {
                                exitValue = 1;
                                break;
                            }
                            userStrikes+= "Got eem\n";
                            System.out.println("Got eem");
                            delayForSeconds(1);
                        } else {
                            System.out.printf("ARRG! We missed %s\n", player.getName());
                            delayForSeconds(1);
                        }


                    } else {
                        continue;
                    }
                }

                label0.setText(userStrikes);
            }
            else{
                System.out.printf("%s! We don't have any GUNS!!!!\n", player.getName());
                delayForSeconds(1);

            }


            if (shipWarfare.getNumOfPeasantShips() <= 0) {
                exitValue = 1;
                break;
            }
            if (player.getGuns() > 0) {
                chanceOfEnemyRun = randomValue.nextInt(2) + 1;
                if (chanceOfEnemyRun == 2) {
                    shipWarfare.setHowMuchRun(randomValue.nextInt(15) + 1);
                    if (shipWarfare.getHowMuchRun() != 0 && shipWarfare.getHowMuchRun() < shipWarfare.getHowMuchRun()) {


                        shipWarfare.setNumOfPeasantShips(shipWarfare.getNumOfPeasantShips() - shipWarfare.getHowMuchRun());
                        if (shipWarfare.isUserAttacks() == true) {
                            System.out.printf("Ahhh, %d ships ran away %s!\n", shipWarfare.getHowMuchRun(), player.getName());
                        } else {
                            System.out.printf("Escaped %d of them!\n", shipWarfare.getHowMuchRun());
                        }
                    }
                }
            }

            System.out.printf("%d ships remaining\n", shipWarfare.getNumOfPeasantShips());
            delayForSeconds(1);
            System.out.println("Oh no, they are taking the offensive!");
            delayForSeconds(1);
            //Computer volley
            int takeGunChance = randomValue.nextInt(4) + 1;
            if (takeGunChance == 1 && player.getGuns() > 0) {
                player.setGuns(player.getGuns() - 1);
                System.out.println("Dang it! They destroyed one of our guns");
            } else {
                player.setHP(player.getHP() - (1 + randomValue.nextInt(10)));
            }
            if (player.getHP() <= 0) {
                exitValue = 2;
                break;
            }
            System.out.printf("EEK, our current ship status is %d%% \n", player.getHP());
            delayForSeconds(1);
            if (shipWarfare.isUserAttacks() == false) {
                shipWarfare.setUserAttacks() = true;
            }

            System.out.printf("Shall we continue to fight? Enter \"f\" to fight, and \"r\" to run (We have %d gun(s) left)\n", player.getGuns());

            if (response.equalsIgnoreCase("r")) {
                if (shipWarfare.runFromShips() == false) {
                    System.out.println("Couldn't run away");
                } else {
                    exitValue = 3;
                    break;
                }
            }


        }


        if (exitValue == 1) {
            System.out.printf("\nGot eem\nVictory!\nIt appears we have defeated the enemy fleet and made it out at %d%% ship status\n", player.getHP());
            delayForSeconds(1);
            calculateLoot = (randomValue.nextInt(shipWarfare.getStartingPeasantShips()) + shipWarfare.getStartingPeasantShips()) * 100;
            player.setMoney(player.getMoney() + calculateLoot);
            System.out.printf("We got $%,d!", calculateLoot);
            delayForSeconds(2);
            return true;
        } else if (exitValue == 2) {
            player.gameOver();
            return true;
        } else if (exitValue == 3) {
            System.out.printf("We made it out at %d%% ship status!\n", player.getHP());
            delayForSeconds(2);
            return true;
        }
        return false;


    }
    */



    public void delayForSeconds(int num) {
        try {
            TimeUnit.SECONDS.sleep(num);
        } catch (Exception e) {

        }
    }


    public void setPlayer(Player player) {
        this.player = new Player(player);
    }

    public Player getPlayer() {
        return new Player(player);
    }

    public void setLabel1(String sysOut) {
        label1.setText(sysOut);
    }

    /*
    public void peasantFleet() throws Exception {
        ShipWarfare attackShip = new ShipWarfare(player);
        attackShip.peasantFleetAttack();
        player = attackShip.getPlayer();
    }
    */

    public void start(Stage stage) throws Exception {
        shipWarfare.setNumOfPeasantShips(shipWarfare.numOfShips());


        BorderPane BorderPane = new BorderPane();

        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10.0, 10.0, 10.0, 10.0));
        gridPane.setVgap(5.0);

        hBox = new HBox();
        button1 = new Button();
        button2 = new Button();
        vBox = new VBox();
        label1 = new Label();
        label = new Label();
        vBox0 = new VBox();
        label0 = new Label();

        BorderPane.setPrefHeight(400.0);
        BorderPane.setPrefWidth(600.0);
        hBox.setAlignment(javafx.geometry.Pos.CENTER);
        hBox.setPrefHeight(100.0);
        hBox.setPrefWidth(200.0);
        hBox.setSpacing(10.0);

        button1.setAlignment(javafx.geometry.Pos.CENTER);
        button1.setContentDisplay(javafx.scene.control.ContentDisplay.CENTER);
        button1.setId("Button1");
        button1.setMnemonicParsing(false);
        button1.setText("Fight");

        button2.setAlignment(javafx.geometry.Pos.CENTER);
        button2.setId("Button2");
        button2.setMnemonicParsing(false);
        button2.setText("Run");
        BorderPane.setBottom(hBox);

        BorderPane.setAlignment(vBox, javafx.geometry.Pos.CENTER);
        vBox.setAlignment(javafx.geometry.Pos.TOP_CENTER);
        vBox.setPrefHeight(200.0);
        vBox.setPrefWidth(100.0);
        vBox.setSpacing(20.0);

        label1.setAlignment(javafx.geometry.Pos.TOP_CENTER);
        label1.setContentDisplay(javafx.scene.control.ContentDisplay.CENTER);
        label1.setId("Label1");
        label1.setPadding(new Insets(6.0, 0.0, 0.0, 0.0));
        vBox.setPadding(new Insets(0.0, 0.0, 10.0, 0.0));
        BorderPane.setTop(vBox);
        BorderPane.setPadding(new Insets(6.0, 0.0, 0.0, 0.0));
        vBox0.setAlignment(javafx.geometry.Pos.TOP_CENTER);
        vBox0.setPrefHeight(200.0);
        vBox0.setPrefWidth(100.0);
        vBox0.setSpacing(5.0);

        hBox.getChildren().add(button1);
        hBox.getChildren().add(button2);
        vBox.getChildren().add(label1);
        vBox.getChildren().add(label);
        vBox0.getChildren().add(label0);
        vBox.getChildren().add(vBox0);


        ShipWarfareGUI ship = new ShipWarfareGUI();

        label1.setText(String.format("By Golly! We have $%,d and are being attacked by %d Merchant ships\nCurrently our ship status is %d%%\n", player.getMoney(), shipWarfare.getNumOfPeasantShips(), player.getHP()));
        label.setText("What would you like to do?");


        //Fight
        button1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                counter++;
                if (counter == 1) {
                    int calculateLoot = 0;
                    int chanceOfEnemyRun = 0;
                    label.setText("Ohh, Fight ehh?");




                    label0.setText("Got eem");


                }
                if (counter == 2) {
                    System.out.println("You pressed the button.");
                    button1.setVisible(false);
                    button2.setVisible(false);
                    button1.setDisable(true);
                    button2.setDisable(true);
                }
            }
        });

        //Flee
        button2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                counter++;
                if (counter == 1) {
                    label1.setText("Ohh, Run ehh?");

                }
                if (counter == 2) {
                    System.out.println("You pressed the button.");
                    button1.setVisible(false);
                    button2.setVisible(false);
                    button1.setDisable(true);
                    button2.setDisable(true);
                }
            }
        });


        Scene root = new Scene(BorderPane, 600, 480);

        stage.setTitle("Ship");
        stage.setResizable(false);
        stage.setScene(root);
        stage.show();

    }
}
