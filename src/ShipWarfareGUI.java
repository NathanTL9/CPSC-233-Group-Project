import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Random;


/**
 * 2019-03-10 (Edited on 2019-03-19)
 * Authors: Haris Muhammad
 * ShipWarfareGUI class, Generates and utilizes ships which the user can attack or run from
 */


public class ShipWarfareGUI extends Player {

    private HBox hBox;
    private Button fightButton;
    private Button runButton;
    private VBox vBox;
    private Label title;
    private Label chooseFightOrRun;
    private HBox hBox0;
    private VBox vBox0;
    private Label shipsRemaining;
    private Label report;
    private Label runAwayOrLeft;
    private Label HPLeft;
    private Label gunsLeftOrTaken;
    private Label continueToFight;
    private ImageView imageView;

    private int counter1;
    private Button continueButton;


    private int numOfLittyShips = 0;
    private boolean userAttacks = true;
    private int startingLittyShips = 0;
    private int howMuchRun = 0;
    private int counter = 0;
    private String pirateName = "Liu Yen";

    /**
     * constructor; only runs when a Player object is provided. The constructor is fully encapsulated.
     *
     * @param player is a Player object that will be copied and the player instance variable is set to the copy.
     */
    public ShipWarfareGUI(Player player) {
        Player playerDummy = new Player(player);
        setPlayer(playerDummy);
    }

    /**
     * setter method that takes in an integer as an argument
     *
     * @param numOfLittyShips the number of ships to be used in the peasant fleet attack
     */
    public void setNumOfLittyShips(int numOfLittyShips) {
        counter1++;
        this.numOfLittyShips = numOfLittyShips;
        if (counter1 == 1) {
            startingLittyShips = numOfLittyShips;
        }

    }


    /**
     * The number of ships that attack is based on the amount of money one has on hand
     *
     * @return the number of ships which will attack
     */
    public int numOfShips() {

        int numOfShipsAttacking = 0;
        Random randomValue = new Random();

        if (getMoney() <= 100000) {
            //Minimum one ship will attack, maximum 20
            numOfShipsAttacking = randomValue.nextInt(20) + 1;
        } else if (getMoney() <= 200000) {
            //Minimum 30 Ships will attack, maximum 70
            numOfShipsAttacking = randomValue.nextInt(40) + 31;
        } else if (getMoney() <= 500000) {
            //Minimum 50 ships will attack, maximum 140
            numOfShipsAttacking = randomValue.nextInt(90) + 51;
        } else if (getMoney() >= 1000000) {
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
    public void wipe() {
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
     * The user faces off against the litty ships and either prevails, dies, or runs away
     *
     * @return true if the user wins, loses, or flees, it returns false otherwise
     */
    public boolean destroyLittyShipsOrEscape(Stage stage) throws Exception {
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
        if (getGuns() > 0) {

            for (int j = 0; j < getGuns(); j++) {
                if (userAttacks == true) {
                    int hitOrMiss = randomValue.nextInt(2) + 1;
                    if (hitOrMiss == 2) {
                        numOfLittyShips--;
                        if (numOfLittyShips <= 0) {
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
            if (userAttacks == true) {
                report.setText(String.format("Report: Ships hit: %d, Shots missed: %d", hitCounter, missCounter));
            }
        } else {
            report.setText("We don't have any guns!!!");

        }


        if (numOfLittyShips <= 0) {
            exitValue = 1;
            //break;
        }
        if (getGuns() > 0) {
            chanceOfEnemyRun = randomValue.nextInt(2) + 1;
            if (chanceOfEnemyRun == 2) {
                howMuchRun = randomValue.nextInt(15) + 1;
                if (howMuchRun != 0 && howMuchRun < numOfLittyShips) {


                    setNumOfLittyShips(numOfLittyShips - howMuchRun);
                    if (userAttacks == true) {
                        if (howMuchRun > 0) {
                            runAwayOrLeft.setText(String.format("Cowards! %d ships ran away %s! ", howMuchRun, getName()));

                            //runAwayOrLeft.setVisible(true);
                        }

                    } else {
                        report.setText((String.format("Escaped %d of them %s!", howMuchRun, getName())));
                    }

                }
            }
        }

        shipsRemaining.setText(String.format("%d ships remaining and they look angry!", numOfLittyShips));
        //Computer volley
        int takeGunChance = randomValue.nextInt(4) + 1;
        if (takeGunChance == 1 && getGuns() > 0) {
            setGuns(getGuns() - 1);
            gunFrustration = true;
        } else {
            if (numOfLittyShips > 0) {
                setHP(getHP() - (1 + randomValue.nextInt(10)));

            }
        }
        if (getHP() <= 0) {
            exitValue = 2;
            //break;
        }
        if (gunFrustration == true) {
            gunsLeftOrTaken.setText(String.format("Dang it! We only have %d guns left", getGuns()));
        } else {
            gunsLeftOrTaken.setText(String.format("We still have %d guns left", getGuns()));
        }

        HPLeft.setText(String.format("EEK, our current ship status is %d%% ", getHP()));
        if (userAttacks == false) {
            userAttacks = true;
        }

        continueToFight.setText(String.format("Captain, what are your orders?"));

        if (exitValue == 1) {
            wipe();
            chooseFightOrRun.setText(String.format("Ayy! We won and survived at %d%% ship status!", getHP()));
            calculateLoot = (startingLittyShips * 100) + randomValue.nextInt(startingLittyShips) * 200;
            setMoney(getMoney() + calculateLoot);
            report.setText(String.format("Our firm has earned $%,d in loot! ", calculateLoot));
            continueButton.setVisible(true);
            continueButton.setDefaultButton(true);
            return true;
        } else if (exitValue == 2) {
            GameEndGUI gameEndGUI = new GameEndGUI(getPlayer());
            gameEndGUI.initializeGameEndGUI(stage);
            stage.show();
            return true;
        } else if (exitValue == 3) {
            System.out.printf("We made it out at %d%% ship status!\n", getHP());
            continueButton.setVisible(true);
            continueButton.setDefaultButton(true);
            return true;
        }
        return false;
    }

    /**
     * Sets up the graphical part of ShipWarfare and includes all logic for the class
     *
     * @param stage sets the stage to which we will execute the scene of the ShipWarfare class
     * @return stage so that another class can switch to the stage
     */

    public Stage initializeShip(Stage stage) throws FileNotFoundException {
        setNumOfLittyShips(numOfShips());

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
        hBox0 = new HBox();
        vBox0 = new VBox();
        shipsRemaining = new Label();
        report = new Label();
        runAwayOrLeft = new Label();
        HPLeft = new Label();
        gunsLeftOrTaken = new Label();
        continueToFight = new Label();
        imageView = new ImageView();
        continueButton = new Button();

        chooseFightOrRun.setVisible(false);
        fightButton.setDefaultButton(true);

        continueToFight.setPrefWidth(379);

        continueButton.setVisible(false);
        title.setVisible(true);


        BorderPane.setPrefHeight(400.0);
        BorderPane.setPrefWidth(600.0);
        hBox.setAlignment(javafx.geometry.Pos.CENTER);
        hBox.setPrefHeight(100.0);
        hBox.setPrefWidth(200.0);
        hBox.setSpacing(10.0);

        title.setAlignment(javafx.geometry.Pos.TOP_CENTER);
        title.setContentDisplay(javafx.scene.control.ContentDisplay.CENTER);
        title.setId("Label1");
        title.setText(String.format("%d ships attacking. Would you like to Fight or Run?", numOfLittyShips));
        title.setPadding(new Insets(6.0, 0.0, 0.0, 0.0));


        Image shipsAttacking = new Image(new FileInputStream("src/images/ShipsAttacking.gif"));
        Image shipsRunning = new Image(new FileInputStream("src/images/ShipsRunning.gif"));


        //Setting the image view
        ImageView shipsAttackingOrRunningGif = new ImageView(shipsAttacking);

        shipsAttackingOrRunningGif.setFitHeight(193.0);
        shipsAttackingOrRunningGif.setFitWidth(349.0);
        shipsAttackingOrRunningGif.setPickOnBounds(true);
        shipsAttackingOrRunningGif.setPreserveRatio(true);
        shipsAttackingOrRunningGif.setVisible(false);


        BorderPane.setAlignment(hBox, javafx.geometry.Pos.CENTER);
        hBox.setAlignment(javafx.geometry.Pos.CENTER);
        hBox.setPrefHeight(100.0);
        hBox.setPrefWidth(200.0);
        hBox.setSpacing(10.0);

        fightAndRunButtonSetting();
        runButton.setText("Run");

        BorderPane.setAlignment(vBox, javafx.geometry.Pos.CENTER);
        vBox.setAlignment(javafx.geometry.Pos.TOP_CENTER);
        vBox.setPrefHeight(200.0);
        vBox.setPrefWidth(200);
        vBox.setSpacing(30.0);


        titleSetting(title);

        chooseFightOrRun.setText("Ohh, Fight ehh?");

        hBox0.setPrefHeight(100.0);
        hBox0.setPrefWidth(200.0);

        vBox0.setPrefHeight(102.0);
        vBox0.setPrefWidth(400.0);
        vBox0.setSpacing(30.0);


        continueButton.setMnemonicParsing(false);
        continueButton.setText("Continue?");

        fightAndRunButtonSetting();

        BorderPane.setBottom(hBox);
        runButton.setText("Run");

        javafx.scene.layout.BorderPane.setAlignment(vBox, javafx.geometry.Pos.CENTER);
        vBox.setAlignment(javafx.geometry.Pos.TOP_CENTER);
        vBox.setPrefHeight(200.0);
        vBox.setPrefWidth(400.0);
        vBox.setSpacing(20.0);

        titleSetting(report);
        vBox.setPadding(new Insets(0.0, 0.0, 10.0, 0.0));
        vBox0.setPadding(new Insets(0.0, 0.0, 0.0, 6.0));

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
            /**
             * Fight Button, engages in fight logic and graphical interface
             * @param event, once button is clicked, executes graphical information
             */
            public void handle(ActionEvent event) {
                AnimationTesting test = new AnimationTesting(getPlayer());
                try {
                    test.startShipAnimation(stage);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                stage.show();

                try {
                    shipsAttackingOrRunningGif.setImage(new Image(new FileInputStream("src/images/ShipsAttacking.gif")));
                    chooseFightOrRun.setText("Pressing forward in our attack!");

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                counter++;
                chooseFightOrRun.setVisible(true);
                try {
                    shipsAttackingOrRunningGif.setVisible(true);
                    if (destroyLittyShipsOrEscape(stage)) {
                        shipsAttackingOrRunningGif.setVisible(false);
                        setVisibilitiesAndTransition(stage);


                    }
                } catch (Exception e) {
                }

                if (counter >= 1) {
                    title.setVisible(false);

                }
            }
        });

        //Flee
        runButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            /**
             * Run Button, engages in run logic and graphical interface
             * @param event, once button is clicked, executes graphical information
             */
            public void handle(ActionEvent event) {
                shipsAttackingOrRunningGif.setVisible(true);
                try {
                    shipsAttackingOrRunningGif.setImage(new Image(new FileInputStream("src/images/ShipsRunning.gif")));
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                chooseFightOrRun.setText("Ayy captain we will try to run!");
                counter++;

                if (runFromShips() == false) {
                    title.setVisible(false);
                    chooseFightOrRun.setVisible(false);
                    report.setText(("Couldn't run away"));
                    try {
                        if (destroyLittyShipsOrEscape(stage) == true) {
                            setVisibilitiesAndTransition(stage);
                        }

                    } catch (Exception e) {
                    }
                } else {
                    completeWipe();
                    shipsAttackingOrRunningGif.setVisible(false);
                    report.setText("Phew! Got away safely");
                    setVisibilitiesAndTransition(stage);


                }
                if (counter >= 2) {
                    title.setVisible(false);
                }
            }
        });


        Scene root = new Scene(BorderPane, 600, 480);
        root.getStylesheets().add("styleguide.css");
        stage.setTitle("Ship");
        stage.setResizable(false);
        stage.setScene(root);
        return stage;
    }

    /**
     * sets the title and does basic layout for the label
     *
     * @param title label which is set
     */

    public void titleSetting(Label title) {
        title.setAlignment(javafx.geometry.Pos.TOP_CENTER);
        title.setContentDisplay(javafx.scene.control.ContentDisplay.CENTER);
        title.setId("Label1");
        title.setPadding(new Insets(6.0, 0.0, 0.0, 0.0));
    }


    /**
     * Sets the fightButton and runButton to a specific layout
     */
    public void fightAndRunButtonSetting() {
        fightButton.setAlignment(javafx.geometry.Pos.CENTER);
        fightButton.setContentDisplay(javafx.scene.control.ContentDisplay.CENTER);
        fightButton.setId("Button1");
        fightButton.setMnemonicParsing(false);
        fightButton.setText("Fight");
        fightButton.setDefaultButton(true);

        runButton.setAlignment(javafx.geometry.Pos.CENTER);
        runButton.setId("Button2");
        runButton.setMnemonicParsing(false);
    }


    /**
     * Sets most buttons to being invisble and switches to TaipanShop scene
     *
     * @param stage stage the user incorporates when they utilize the GUI
     */
    public void setVisibilitiesAndTransition(Stage stage) {
        completeWipe();
        continueButton.setVisible(true);
        continueButton.setDefaultButton(true);
        fightButton.setVisible(false);
        runButton.setVisible(false);
        /**
         * Switches to Taipan Shop scene
         * @param event, once button is clicked, executes graphical information
         */
        continueButton.setOnAction(event -> {
            TaipanShopGUI shop = new TaipanShopGUI(getPlayer());
            shop.initializeShop(stage);
            stage.show();
        });
    }
/*

    public void startShipAnimation(Stage primaryStage) throws Exception {


        Pane root = new Pane();
        HBox usAgainstEnemyDivisor = new HBox();
        BorderPane centeringUserShipPane = new BorderPane();
        Circle cannon = new Circle();
        BorderPane centeringMerchantShipPane = new BorderPane();
        BorderPane encompassingPane = new BorderPane();


        final int USER_SHOOTS_X = 150;
        final int USER_SHOOTS_Y = 180;

        final int CLEAN_SHOT_X = 350;
        final int CLEAN_SHOT_Y = 110;

        root.getChildren().add(cannon);

        encompassingPane.setPrefHeight(480);
        encompassingPane.setPrefWidth(600);

        usAgainstEnemyDivisor.setPrefHeight(480.0);
        usAgainstEnemyDivisor.setPrefWidth(600.0);

        centeringUserShipPane.setPrefHeight(200.0);
        centeringUserShipPane.setPrefWidth(200.0);

        Image ourShip = new Image(new FileInputStream("src/images/ourShip.png"));
        Image enemyShip = new Image(new FileInputStream("src/images/enemyShip.png"));


        //Setting the image view
        ImageView userShip = new ImageView(ourShip);
        ImageView merchantShip = new ImageView(enemyShip);

        BorderPane.setAlignment(userShip, javafx.geometry.Pos.CENTER);
        userShip.setFitHeight(150.0);
        userShip.setFitWidth(248.0);
        userShip.setPickOnBounds(true);
        userShip.setPreserveRatio(true);
        centeringUserShipPane.setCenter(userShip);


        cannon.setRadius(10.0);
        cannon.setStroke(javafx.scene.paint.Color.BLACK);
        cannon.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);
        centeringUserShipPane.setRight(cannon);

        centeringMerchantShipPane.setPrefHeight(200.0);
        centeringMerchantShipPane.setPrefWidth(200.0);
        centeringMerchantShipPane.setOpaqueInsets(new Insets(0.0));
        HBox.setMargin(centeringMerchantShipPane, new Insets(0.0, 0.0, 0.0, 200.0));

        encompassingPane.setAlignment(merchantShip, javafx.geometry.Pos.CENTER);
        merchantShip.setFitHeight(165.0);
        merchantShip.setFitWidth(180.0);
        merchantShip.setPickOnBounds(true);
        merchantShip.setPreserveRatio(true);
        encompassingPane.setMargin(merchantShip, new Insets(0.0, 0.0, 20.0, 0.0));
        centeringMerchantShipPane.setCenter(merchantShip);
        encompassingPane.setCenter(usAgainstEnemyDivisor);

        usAgainstEnemyDivisor.getChildren().add(centeringUserShipPane);
        usAgainstEnemyDivisor.getChildren().add(centeringMerchantShipPane);

        root.getChildren().addAll(encompassingPane, cannon);

        // start
        cannon.setLayoutX(USER_SHOOTS_X);
        cannon.setLayoutY(USER_SHOOTS_Y);

        TranslateTransition shotsFired = new TranslateTransition();
        shotsFired.setDuration(Duration.seconds(3));
        shotsFired.setToX(CLEAN_SHOT_X);
        shotsFired.setToY(CLEAN_SHOT_Y);
        shotsFired.setCycleCount(getGuns());
        shotsFired.setNode(cannon);
        shotsFired.play();

        Scene scene = new Scene(root, 600, 480);
        root.getStylesheets().add("styleguide.css");

        primaryStage.setScene(scene);
        primaryStage.show();

    }
 */
    /**
     * sets scene and runs stage
     *
     * @param primaryStage the stage in which the scene may be run and switched to
     */
    public void start(Stage primaryStage) throws FileNotFoundException {
        primaryStage = initializeShip(primaryStage);
        primaryStage.show();
    }
}
