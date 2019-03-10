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
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import static javafx.application.Application.launch;

@SuppressWarnings("Duplicates")
public class ShipWarfareGUI extends Application {


    private Player player = new Player();
    private ShipWarfare shipWarfare = new ShipWarfare(player);
    private HBox hBox;
    private Button fightButton;
    private Button runButton;
    private VBox vBox;
    private Label title;
    private Label chooseFightOrRun;
    private Label report;
    private Label runAwayOrLeft;
    private Label shipsRemaining;
    private Label HPLeft;
    private Label gunsLeftOrTaken;
    private Label continueToFight;


    public static void main(String args[]) {
        launch(args);
    }

    private int numOfPeasantShips = 0;
    private int numOfLittyShips = 0;
    private boolean userAttacks = true;
    private int startingPeasantShips = 0;
    private int startingLittyShips = 0;
    private int howMuchRun = 0;
    private String pirateName = "Liu Yen";
    private Boolean isScreenFull = false;


    /**
     * setter method for player
     *
     * @param player object of the class Player
     */
    public void setPlayer(Player player) {
        Player playerDummy = new Player(player);
        this.player = playerDummy;
    }

    /**
     * getter method for obtaining a player object.
     *
     * @return returns player object
     */
    public Player getPlayer() {
        Player playerDummy = new Player(player);
        return playerDummy;
    }

    /**
     * This fleet is easy to defeat as a maximum of 15 ships can run away each volley, they can not tank hits
     *
     * @throws Exception in case of errors due to the delay
     */
    public void peasantFleetAttack() throws Exception {
        Scanner userResponse = new Scanner(System.in);
        setNumOfPeasantShips(numOfShips());

        title.setText(String.format("By Golly! We have $%,d and are being attacked by %d Merchant ships\nCurrently our ship status is %d%%\n", player.getMoney(), numOfPeasantShips, player.getHP()));
        fightOrRunMessage();
        while (true) {
            String response = userResponse.nextLine();
            if (response.equalsIgnoreCase("f")) {
                userAttacks = true;
                System.out.println("Ohh, fight ehh?");
                boolean winOrLose = destroyPeasantShipsOrEscape();
                if (winOrLose == true) {
                    break;
                }


            } else if (response.equalsIgnoreCase("r")) {
                if (runFromShips() == false) {
                    System.out.println("Couldn't run away!");
                    if (destroyPeasantShipsOrEscape())
                        break;
                } else {
                    System.out.println("Phew! Got away safely");
                    break;
                }

            }

        }


    }

    /**
     * This fleet is difficult to defeat as a maximum of 10 ships can run away each volley, they can tank hits
     *
     * @throws Exception in case of errors due to the delay
     */
    public void littyFleetAttack() throws Exception {
        Scanner userResponse = new Scanner(System.in);
        setNumOfLittyShips(numOfShips());
        System.out.printf("By Golly! We have $%,d and are being attacked by %d of %s's ships\nCurrently our ship status is %d%%\n", player.getMoney(), numOfLittyShips, pirateName, player.getHP());
        fightOrRunMessage();
        while (true) {
            String response = userResponse.nextLine();
            if (response.equalsIgnoreCase("f")) {
                userAttacks = true;
                System.out.println("Ohh, fight ehh?");
                boolean winOrLose = destroyLittyShipsOrEscape();
                if (winOrLose == true) {
                    break;
                }


            } else if (response.equalsIgnoreCase("r")) {
                if (runFromShips() == false) {
                    System.out.println("Couldn't run away!");
                    if (destroyLittyShipsOrEscape())
                        break;
                } else {
                    System.out.println("Phew! Got away safely");
                    break;
                }

            }

        }


    }

    /**
     * Asks user if they would like to fight or run against ships
     */

    public void fightOrRunMessage() {
        System.out.printf("What do you want to do? Enter \"f\" to fight, and \"r\" to run (we have %d guns)\n", player.getGuns());

    }

    /**
     * setter method that takes in an integer as an argument
     *
     * @param numOfLittyShips the number of ships to be used in the litty fleet attack
     */
    public void setNumOfLittyShips(int numOfLittyShips) {
        this.numOfLittyShips = numOfLittyShips;
        startingLittyShips = numOfLittyShips;

    }

    /**
     * setter method that takes in an integer as an argument
     *
     * @param numOfPeasantShips the number of ships to be used in the peasant fleet attack
     */

    public void setNumOfPeasantShips(int numOfPeasantShips) {
        this.numOfPeasantShips = numOfPeasantShips;
        startingPeasantShips = numOfPeasantShips;

    }


    /**
     * The number of ships that attack is based on the amount of money one has on hand
     *
     * @return the number of ships which will attack
     */
    public int numOfShips() {

        int numOfShipsAttacking = 0;
        Random randomValue = new Random();

        if (player.getMoney() <= 100000) {
            //Minimum one ship will attack, maximum 20
            numOfShipsAttacking = randomValue.nextInt(20) + 1;
        } else if (player.getMoney() <= 200000) {
            //Minimum 30 Ships will attack, maximum 70
            numOfShipsAttacking = randomValue.nextInt(40) + 31;
        } else if (player.getMoney() <= 500000) {
            //Minimum 50 ships will attack, maximum 140
            numOfShipsAttacking = randomValue.nextInt(90) + 51;
        } else if (player.getMoney() >= 1000000) {
            //Minimum 100 ships will attack, maximum 300 ships
            numOfShipsAttacking = randomValue.nextInt(200) + 101;
        }

        return numOfShipsAttacking;

    }

    /**
     * One in two chance of running away
     *
     * @return true if the user is allowed to run, false if not, the "default" is false
     */

    public boolean runFromShips() {
        userAttacks = false;
        Random randomValue = new Random();
        int runSuccessChance = randomValue.nextInt(2) + 1;
        if (runSuccessChance == 2) {
            return true;
        } else if (runSuccessChance == 1) {
            return false;
        }
        return false;
    }

    /**
     * The user faces off against the litty ships and either prevails, dies, or runs away
     * The loot for defeating a litty fleet is much higher than that of a peasant one
     *
     * @return true if the user wins, loses, or flees, it returns false otherwise
     * @throws Exception in case of errors due to the
     */
    public boolean destroyLittyShipsOrEscape() throws Exception {
        int calculateLoot = 0;
        int chanceOfEnemyRun = 0;


        Scanner userInput = new Scanner(System.in);
        Random randomValue = new Random();
        int exitValue = 0;

        //Player volley
        while (exitValue == 0) {
            if (player.getGuns() > 0) {
                for (int j = 0; j < player.getGuns(); j++) {
                    if (userAttacks == true) {
                        int hitOrMiss = randomValue.nextInt(3) + 1;
                        if (hitOrMiss == 1) {
                            numOfLittyShips--;
                            if (numOfLittyShips <= 0) {
                                exitValue = 1;
                                break;
                            }
                            System.out.println("Got eem");
                        } else if (hitOrMiss == 2) {
                            System.out.printf("ARRG! We missed %s\n", player.getName());
                        } else {
                            System.out.println("Darn! Their fleet tanked our attack");
                        }


                    } else {
                        continue;
                    }
                }
            } else {
                System.out.printf("%s! We don't have any GUNS!!!!\n", player.getName());
            }


            if (numOfLittyShips <= 0) {
                exitValue = 1;
                break;
            }
            if (player.getGuns() > 0) {
                if (chanceOfEnemyRun == 2) {
                    chanceOfEnemyRun = randomValue.nextInt(2) + 1;
                    howMuchRun = randomValue.nextInt(10) + 1;
                    if (howMuchRun != 0 && howMuchRun < numOfLittyShips) {


                        setNumOfLittyShips(numOfLittyShips - howMuchRun);
                        if (userAttacks == true) {
                            System.out.printf("Cowards! %d ships ran away %s!\n", howMuchRun, player.getName());
                        } else {
                            System.out.printf("Escaped %d of them!\n", howMuchRun);
                        }
                    }
                }
            }

            System.out.printf("%d ships remaining\n", numOfLittyShips);
            System.out.println("Oh no, they are taking the offensive!");
            //Computer volley
            int takeGunChance = randomValue.nextInt(4) + 1;
            if (takeGunChance == 1 && player.getGuns() > 0) {
                player.setGuns(player.getGuns() - 1);
                System.out.println("Dang it! They destroyed one of our guns");
            } else {
                player.setHP(player.getHP() - (1 + randomValue.nextInt(15)));
            }
            if (player.getHP() <= 0) {
                exitValue = 2;
                break;
            }
            System.out.printf("EEK, our current ship status is %d%% \n", player.getHP());
            if (userAttacks == false) {
                userAttacks = true;
            }

            System.out.printf("Shall we continue to fight? Enter \"f\" to fight, and \"r\" to run (We have %d gun(s) left)\n", player.getGuns());

            String response = userInput.nextLine();
            if (response.equalsIgnoreCase("r")) {
                if (runFromShips() == false) {
                    System.out.println("Couldn't run away");
                } else {
                    System.out.println("Phew! Got away safely");
                    break;
                }
            }


        }


        if (exitValue == 1) {
            System.out.printf("\nGot eem\nVictory!\nIt appears we have defeated the enemy fleet and made it out at %d%%% ship status\n", player.getHP());
            calculateLoot = (randomValue.nextInt(startingLittyShips) + startingLittyShips) * 300;
            player.setMoney(player.getMoney() + calculateLoot);
            System.out.printf("We got $%,d!\n", calculateLoot);
            return true;
        } else if (exitValue == 2) {
            player.gameOver();

            return true;
        } else if (exitValue == 3) {
            System.out.printf("We made it out at %d%% ship status!\n", player.getHP());
            return true;
        }
        return false;


    }


    public void wipe() {
        title.setVisible(false);
        runAwayOrLeft.setVisible(false);
        shipsRemaining.setVisible(false);
        HPLeft.setVisible(false);
        gunsLeftOrTaken.setVisible(false);
        continueToFight.setVisible(false);


    }

    /**
     * The user faces off against the peasant ships and either prevails, dies, or runs away
     *
     * @return true if the user wins, loses, or flees, it returns false otherwise
     * @throws Exception in case of errors due to the delay
     */

    public boolean destroyPeasantShipsOrEscape() throws Exception {
        int calculateLoot = 0;
        int chanceOfEnemyRun = 0;
        int hitCounter = 0;
        int missCounter = 0;
        boolean gunFrustration = false;
        //runAwayOrLeft.setVisible(false);
        runAwayOrLeft.setText("No ships ran away");

        Scanner userInput = new Scanner(System.in);
        Random randomValue = new Random();
        int exitValue = 0;

        //Player volley
        //while (exitValue == 0) {
        if (player.getGuns() > 0) {

            for (int j = 0; j < player.getGuns(); j++) {
                if (userAttacks == true) {
                    int hitOrMiss = randomValue.nextInt(2) + 1;
                    if (hitOrMiss == 2) {
                        numOfPeasantShips--;
                        if (numOfPeasantShips <= 0) {
                            exitValue = 1;
                            //break;
                        }
                        hitCounter++;
                    } else {
                        missCounter++;
                    }


                } else {
                    //continue;
                }
            }
            report.setText(String.format("Report: Ships hit: %d, Shots missed: %d", hitCounter, missCounter));
        } else {
            report.setText("We don't have any guns!!!");

        }


        if (numOfPeasantShips <= 0) {
            exitValue = 1;
            //break;
        }
        if (player.getGuns() > 0) {
            chanceOfEnemyRun = randomValue.nextInt(2) + 1;
            if (chanceOfEnemyRun == 2) {
                howMuchRun = randomValue.nextInt(15) + 1;
                if (howMuchRun != 0 && howMuchRun < numOfPeasantShips) {


                    setNumOfPeasantShips(numOfPeasantShips - howMuchRun);
                    if (howMuchRun > 0) {
                        runAwayOrLeft.setText(String.format("Cowards! %d ships ran away %s! ", howMuchRun, player.getName()));
                        //runAwayOrLeft.setVisible(true);
                    } else {
                        runAwayOrLeft.setText("None chose to flee!");
                    }

                }
            }
        }

        shipsRemaining.setText(String.format("%d ships remaining and they look angry!", numOfPeasantShips));
        //Computer volley
        int takeGunChance = randomValue.nextInt(4) + 1;
        if (takeGunChance == 1 && player.getGuns() > 0) {
            player.setGuns(player.getGuns() - 1);
            gunFrustration = true;
        } else {
            player.setHP(player.getHP() - (1 + randomValue.nextInt(10)));
        }
        if (player.getHP() <= 0) {
            exitValue = 2;
            //break;
        }
        if (gunFrustration == true) {
            gunsLeftOrTaken.setText(String.format("Dang it! We only have %d guns left", player.getGuns()));
        } else {
            gunsLeftOrTaken.setText(String.format("We still have %d guns left", player.getGuns()));
        }

        HPLeft.setText(String.format("EEK, our current ship status is %d%% ", player.getHP()));
        if (userAttacks == false) {
            userAttacks = true;
        }

        continueToFight.setText(String.format("Shall we continue to fight? (Click the fight button or the run button)", player.getGuns()));

        if (runButton.isPressed()) {

            if (runFromShips() == false) {
                wipe();
                chooseFightOrRun.setText("Couldn't run away");
            } else {
                exitValue = 3;
                //break;
            }
        } else if (fightButton.isPressed()) {
            title.setText("AYYYYYYYYYYY");
        } else {

        }


        //}


        if (exitValue == 1) {
            wipe();
            chooseFightOrRun.setText(String.format("Ayy We won! We survived at %d%% ship status!", player.getHP()));
            System.out.printf("\nGot eem\nVictory!\nIt appears we have defeated the enemy fleet and made it out at %d%% ship status\n", player.getHP());
            calculateLoot = (randomValue.nextInt(startingPeasantShips) + startingPeasantShips) * 100;
            player.setMoney(player.getMoney() + calculateLoot);
            report.setText(String.format("We got $%,d! ", calculateLoot));
            return true;
        } else if (exitValue == 2) {
            player.gameOver();
            return true;
        } else if (exitValue == 3) {
            System.out.printf("We made it out at %d%% ship status!\n", player.getHP());
            return true;
        }
        return false;


    }


    //Main G
    private int counter = 0;


    /**
     * delays for a specific amount of seconds, takes an integer as an argument
     *
     * @param num the seconds to delay
     * @throws Exception in case of errors due to the delay
     */

    public void delayForSeconds(int num) {
        try {
            TimeUnit.SECONDS.sleep(num);
        } catch (Exception e) {

        }
    }


    public void setLabel1(String sysOut) {
        report.setText(sysOut);
    }

    /*
    public void peasantFleet() throws Exception {
        ShipWarfare attackShip = new ShipWarfare(player);
        attackShip.peasantFleetAttack();
        player = attackShip.getPlayer();
    }
    */

    public void start(Stage stage) throws Exception {
        setNumOfPeasantShips(numOfShips());

        BorderPane BorderPane = new BorderPane();

        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10.0, 10.0, 10.0, 10.0));
        gridPane.setVgap(5.0);

        hBox = new HBox();
        fightButton = new Button();
        runButton = new Button();
        vBox = new VBox();
        title = new Label();
        chooseFightOrRun = new Label();
        report = new Label();
        runAwayOrLeft = new Label();
        shipsRemaining = new Label();
        HPLeft = new Label();
        gunsLeftOrTaken = new Label();
        continueToFight = new Label();


        BorderPane.setPrefHeight(400.0);
        BorderPane.setPrefWidth(600.0);
        hBox.setAlignment(javafx.geometry.Pos.CENTER);
        hBox.setPrefHeight(100.0);
        hBox.setPrefWidth(200.0);
        hBox.setSpacing(10.0);

        title.setAlignment(javafx.geometry.Pos.TOP_CENTER);
        title.setContentDisplay(javafx.scene.control.ContentDisplay.CENTER);
        title.setId("Label1");
        title.setText(String.format("%d ships attacking. Would you like to Fight or Run?", numOfPeasantShips));
        title.setPadding(new Insets(6.0, 0.0, 0.0, 0.0));

        fightButton.setAlignment(javafx.geometry.Pos.CENTER);
        fightButton.setContentDisplay(javafx.scene.control.ContentDisplay.CENTER);
        fightButton.setId("Button1");
        fightButton.setMnemonicParsing(false);
        fightButton.setText("Fight");

        runButton.setAlignment(javafx.geometry.Pos.CENTER);
        runButton.setId("Button2");
        runButton.setMnemonicParsing(false);
        runButton.setText("Run");
        BorderPane.setBottom(hBox);

        BorderPane.setAlignment(vBox, javafx.geometry.Pos.CENTER);
        vBox.setAlignment(javafx.geometry.Pos.TOP_CENTER);
        vBox.setPrefHeight(200.0);
        vBox.setPrefWidth(100.0);
        vBox.setSpacing(20.0);

        report.setAlignment(javafx.geometry.Pos.TOP_CENTER);
        report.setContentDisplay(javafx.scene.control.ContentDisplay.CENTER);
        report.setId("Label1");
        report.setPadding(new Insets(6.0, 0.0, 0.0, 0.0));
        vBox.setPadding(new Insets(0.0, 0.0, 10.0, 0.0));
        BorderPane.setTop(vBox);
        BorderPane.setPadding(new Insets(6.0, 0.0, 0.0, 0.0));

        hBox.getChildren().add(fightButton);
        hBox.getChildren().add(runButton);
        vBox.getChildren().add(title);
        vBox.getChildren().add(chooseFightOrRun);
        vBox.getChildren().add(report);
        vBox.getChildren().add(runAwayOrLeft);
        vBox.getChildren().add(shipsRemaining);
        vBox.getChildren().add(HPLeft);
        vBox.getChildren().add(gunsLeftOrTaken);
        vBox.getChildren().add(continueToFight);


        //report.setText(String.format("By Golly! We have $%,d and are being attacked by %d Merchant ships\nCurrently our ship status is %d%%\n", player.getMoney(), shipWarfare.getNumOfPeasantShips(), player.getHP()));


        //Fight
        fightButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                counter++;
                chooseFightOrRun.setText("Ohh, Fight ehh?");
                try {
                    destroyPeasantShipsOrEscape();
                } catch (Exception e) {
                }
                if (counter == 2) {
                    title.setVisible(false);

                }
            }
        });

        //Flee
        runButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                counter++;
                if (counter == 1) {
                    chooseFightOrRun.setText("Ohh, Run ehh?");


                }
                if (counter == 2) {
                    System.out.println("You pressed the button twice.");
                    fightButton.setVisible(false);
                    runButton.setVisible(false);
                    fightButton.setDisable(true);
                    runButton.setDisable(true);
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