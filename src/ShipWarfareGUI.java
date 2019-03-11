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
import java.util.Random;

public class ShipWarfareGUI {


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
    private int counter1;
    private Button continueButton;



    /*
        /**
         * constructor; only runs when a Player object is provided. The constructor is fully encapsulated.
         *
         * @param player is a Player object that will be copied and the player instance variable is set to the copy.
         */
    public ShipWarfareGUI(Player player){
        Player playerDummy = new Player(player);
        this.player = playerDummy;
    }

    //public static void main(String args[]) {
    //    launch(args);
    //}

    private int numOfPeasantShips = 0;
    private int numOfLittyShips = 0;
    private boolean userAttacks = true;
    private int startingPeasantShips = 0;
    private int startingLittyShips = 0;
    private int howMuchRun = 0;
    private int counter = 0;
    private String pirateName = "Liu Yen";

    /**
     * setter method for player
     * @param player object of the class Player
     */
    public void setPlayer(Player player) {
        Player playerDummy = new Player(player);
        this.player = playerDummy;
    }

    /**
     * getter method for obtaining a player object.
     * @return returns player object
     */
    public Player getPlayer() {
        Player playerDummy = new Player(player);
        return playerDummy;
    }

    /**
     * setter method that takes in an integer as an argument
     * @param numOfPeasantShips the number of ships to be used in the peasant fleet attack
     */
    public void setNumOfPeasantShips(int numOfPeasantShips){
        counter1++;
        this.numOfPeasantShips = numOfPeasantShips;
        if(counter1==1) {
            startingPeasantShips = numOfPeasantShips;
        }

    }

    /**
     * The number of ships that attack is based on the amount of money one has on hand
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
     * @return true if the user is allowed to run, false if not, the "default" is false
     */
    public boolean runFromShips() {
        userAttacks = false;
        Random randomValue = new Random();
        int runSuccessChance = randomValue.nextInt(10) + 1;
        if (runSuccessChance == 2) {
            return true;
        } else if (runSuccessChance == 1) {
            return false;
        }
        return false;
    }

    /**
     * Sets most of the labels invisible except for the "fight or run" label
     */
    public void wipe(){
        title.setVisible(false);
        runAwayOrLeft.setVisible(false);
        shipsRemaining.setVisible(false);
        HPLeft.setVisible(false);
        gunsLeftOrTaken.setVisible(false);
        continueToFight.setVisible(false);


    }

    /**
     * Sets most of the  labels invisible including the fight or run label
     */
    public void completeWipe() {
        title.setVisible(false);
        chooseFightOrRun.setVisible(false);
        runAwayOrLeft.setVisible(false);
        shipsRemaining.setVisible(false);
        HPLeft.setVisible(false);
        gunsLeftOrTaken.setVisible(false);
        continueToFight.setVisible(false);
    }

    /**
     * The user faces off against the peasant ships and either prevails, dies, or runs away
     * @return true if the user wins, loses, or flees, it returns false otherwise
     * @throws Exception in case of errors due to the delay
     */
    public boolean destroyPeasantShipsOrEscape() throws Exception {
        int calculateLoot = 0;
        int chanceOfEnemyRun = 0;
        int hitCounter = 0;
        int missCounter = 0;
        boolean gunFrustration = false;

        title.setVisible(true);
        chooseFightOrRun.setVisible(true);
        report.setVisible(true);
        runAwayOrLeft.setVisible(true);
        shipsRemaining.setVisible(true);
        HPLeft.setVisible(true);
        gunsLeftOrTaken.setVisible(true);
        continueToFight.setVisible(true);
        continueButton.setVisible(false);


        runAwayOrLeft.setText("No ships ran away");

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
            }if(userAttacks==true) {
                report.setText(String.format("Report: Ships hit: %d, Shots missed: %d", hitCounter, missCounter));
            }
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
                    if (userAttacks == true) {
                        if (howMuchRun > 0) {
                            runAwayOrLeft.setText(String.format("Cowards! %d ships ran away %s! ", howMuchRun, player.getName()));
                            //runAwayOrLeft.setVisible(true);
                        }

                    } else {
                        report.setText((String.format("Escaped %d of them %s!", howMuchRun,player.getName())));
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

        if (exitValue == 1) {
            wipe();
            chooseFightOrRun.setText(String.format("Ayy! We won and survived at %d%% ship status!", player.getHP()));
            calculateLoot = (startingPeasantShips *100) + randomValue.nextInt(startingPeasantShips) *200;
            player.setMoney(player.getMoney() + calculateLoot);
            report.setText(String.format("Our firm has earned $%,d in loot! ", calculateLoot));
            continueButton.setVisible(true);
            return true;
        } else if (exitValue == 2) {
            player.gameOver();
            return true;
        } else if (exitValue == 3) {
            System.out.printf("We made it out at %d%% ship status!\n", player.getHP());
            continueButton.setVisible(true);
            return true;
        }
        return false;
    }

    public Stage initializeShip(Stage stage){
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
        continueButton = new Button();

        continueButton.setVisible(false);



        BorderPane.setPrefHeight(400.0);
        BorderPane.setPrefWidth(600.0);
        hBox.setAlignment(javafx.geometry.Pos.CENTER);
        hBox.setPrefHeight(100.0);
        hBox.setPrefWidth(200.0);
        hBox.setSpacing(10.0);

        title.setAlignment(javafx.geometry.Pos.TOP_CENTER);
        title.setContentDisplay(javafx.scene.control.ContentDisplay.CENTER);
        title.setId("Label1");
        title.setText(String.format("%d ships attacking. Would you like to Fight or Run?",numOfPeasantShips));
        title.setPadding(new Insets(6.0, 0.0, 0.0, 0.0));

        continueButton.setMnemonicParsing(false);
        continueButton.setText("Continue?");

        fightButton.setAlignment(javafx.geometry.Pos.CENTER);
        fightButton.setContentDisplay(javafx.scene.control.ContentDisplay.CENTER);
        fightButton.setId("Button1");
        fightButton.setMnemonicParsing(false);
        fightButton.setText("Fight");

        runButton.setAlignment(javafx.geometry.Pos.CENTER);
        runButton.setId("Button2");
        runButton.setMnemonicParsing(false);

        BorderPane.setBottom(hBox);runButton.setText("Run");

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
        vBox.getChildren().add(continueButton);


        //Fight
        fightButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                counter++;
                chooseFightOrRun.setText("Ohh, Fight ehh?");
                try {
                    if (destroyPeasantShipsOrEscape()){
                        completeWipe();
                        continueButton.setVisible(true);
                        fightButton.setVisible(false);
                        runButton.setVisible(false);
                        continueButton.setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent event) {
                                TaipanShopGUI shop = new TaipanShopGUI(player);
                                shop.initializeShop(stage);
                                stage.show();
                            }
                        });


                    }
                } catch (Exception e) {
                }

                if (counter >= 2) {
                    title.setVisible(false);

                }
            }
        });

        //Flee
        runButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                chooseFightOrRun.setText("Ayy captain we will try to run!");
                counter++;

                if (runFromShips() == false) {
                    title.setVisible(false);
                    chooseFightOrRun.setVisible(false);
                    report.setText(("Couldn't run away"));
                    try {
                        if(destroyPeasantShipsOrEscape()==true){
                            completeWipe();
                            continueButton.setVisible(true);
                            fightButton.setVisible(false);
                            runButton.setVisible(false);
                            continueButton.setOnAction(new EventHandler<ActionEvent>() {
                                @Override
                                public void handle(ActionEvent event) {
                                    TaipanShopGUI shop = new TaipanShopGUI(player);
                                    shop.initializeShop(stage);
                                    stage.show();
                                }
                            });
                        }

                    } catch (Exception e) {
                    }
                } else {
                    completeWipe();
                    report.setText("Phew! Got away safely");
                    TaipanShopGUI shop = new TaipanShopGUI(player);
                    shop.initializeShop(stage);
                    stage.show();


                }
                if (counter>=2){
                    title.setVisible(false);
                }
            }
        });


        Scene root = new Scene(BorderPane, 600, 480);

        stage.setTitle("Ship");
        stage.setResizable(false);
        stage.setScene(root);
        return stage;
    }

    public void start(Stage primaryStage){
        primaryStage = initializeShip(primaryStage);
        primaryStage.show();
    }
}
