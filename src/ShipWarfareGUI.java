import javafx.animation.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.FileInputStream;
import java.util.Random;

/**
 * 2019-03-10 (Edited on 2019-03-23)
 * Author: Haris Muhammad
 * ShipWarfareGUI class, Generates and utilizes ships which the user can attack or run from
 */


public class ShipWarfareGUI extends Player {

    ShipWarfareLogic logic = new ShipWarfareLogic(getPlayer());

    private ShipWarfareGUI ship;
    private Circle cannon;
    private VBox buttonBox;
    private HBox fightRunBox;
    private Button fightButton;
    private Button runButton;
    private Button continueButton;
    private VBox labelBox;
    private Label title;
    private Label HPLeft;
    private Label gunsLeftOrTaken;
    private Label runAwayOrLeft;
    private Label shipsRemaining;
    private Label report;

    private boolean winOrLose = false;


    private boolean userAttacks = true;
    private int howMuchRun = 0;
    private int counter = 0;
    private String pirateName = "Liu Yen";

    private int beginningX = 150;
    private int beginningY = 245;

    private int endX = 350;
    private int endY = 90;

    private TranslateTransition shotsFired = new TranslateTransition();
    private TranslateTransition enemyShots = new TranslateTransition();

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
     * Sets most of the labels invisible except for the "fight or run" label
     */
    public void wipe() {
        wipeWithTitle(title);


    }

    public void wipeWithTitle(Label title) {
        title.setVisible(false);
        runAwayOrLeft.setVisible(false);
        shipsRemaining.setVisible(false);
        HPLeft.setVisible(false);
        gunsLeftOrTaken.setVisible(false);
    }

    /**
     * Sets most of the  labels invisible including the fight or run label
     */
    public void completeWipe() {
        wipe();
        report.setVisible(false);
    }


    /**
     * The user faces off against the  ships and either prevails, dies, or runs away
     *
     * @return true if the user wins, loses, or flees, it returns false otherwise
     */
    public boolean destroyShipsOrEscape(Stage stage) throws Exception {

        cannon.setLayoutX(beginningX);
        cannon.setLayoutY(beginningY);
        int calculateLoot = 0;
        int chanceOfEnemyRun = 0;
        int hitCounter = 0;
        int missCounter = 0;
        boolean gunFrustration = false;


        runAwayOrLeft.setText("No ships ran away");
        Random randomValue = new Random();
        int exitValue = 0;
        //Player volley
        if (super.getGuns() > 0) {

            for (int j = 0; j < super.getGuns(); j++) {
                if (userAttacks == true) {

                    int hitOrMiss = randomValue.nextInt(2) + 1;
                    if (hitOrMiss == 2) {
                        logic.setNumOfShips(logic.getNumOfShips()-1);

                        if (logic.getNumOfShips() <= 0) {
                            exitValue = 1;
                        }
                        hitCounter++;



                    } else {
                        missCounter++;

                    }


                }
            }
            if (userAttacks == true) {
                report.setText(String.format("Report: Ships hit: %d, Shots missed: %d", hitCounter, missCounter));
            }
        } else {
            report.setText("We don't have any guns!!!");

        }




        if (logic.getNumOfShips() <= 0) {
            exitValue = 1;
        }

        if (super.getGuns() > 0) {
            chanceOfEnemyRun = randomValue.nextInt(2) + 1;
            if (chanceOfEnemyRun == 2) {
                howMuchRun = randomValue.nextInt(15) + 1;
                if (howMuchRun != 0 && howMuchRun < logic.getNumOfShips()) {


                    logic.setNumOfShips(logic.getNumOfShips() - howMuchRun);
                    if (userAttacks == true) {
                        if (howMuchRun > 0) {
                            runAwayOrLeft.setText(String.format("Cowards! %d ships ran away %s! ", howMuchRun, super.getName()));
                        }

                    } else {
                        report.setText((String.format("Escaped %d of them %s!", howMuchRun, super.getName())));
                    }

                }
            }
        }

        shipsRemaining.setText(String.format("%d ships remaining and they look angry!", logic.getNumOfShips()));
        //Computer volley
        int takeGunChance = randomValue.nextInt(4) + 1;
        if (takeGunChance == 1 && super.getGuns() > 0) {
            super.setGuns(super.getGuns() - 1);
            gunFrustration = true;
        } else {
            if (logic.getNumOfShips() > 0) {
                int HPTaken = randomValue.nextInt(10) + 1;
                super.setHP(super.getHP() - (HPTaken));


            }
        }
        if (super.getHP() <= 0) {
            exitValue = 2;
            //break;
        }
        if (gunFrustration == true) {
            gunsLeftOrTaken.setText(String.format("Dang it! We only have %d guns left", super.getGuns()));
            playerShoots(getGuns() + 1);

        } else {
            gunsLeftOrTaken.setText(String.format("We still have %d guns left", super.getGuns()));
        }

        HPLeft.setText(String.format("EEK, our current ship status is %d%% ", super.getHP()));
        if (userAttacks == false) {
            userAttacks = true;
        }


        //The user defeats the enemy fleet
        if (exitValue == 1) {
            wipe();
            calculateLoot = logic.calculateLoot();
            super.setMoney(logic.getMoney());
            report.setText(String.format("Our firm has earned $%,d in loot! ", calculateLoot));
            continueButton.setVisible(true);
            completeWipe();
            fightButton.setVisible(false);
            runButton.setVisible(false);
            continueButton.setDefaultButton(true);
            return true;

        } else if (exitValue == 2) {
            GameEndGUI gameEndGUI = new GameEndGUI(getPlayer());
            gameEndGUI.initializeGameEndGUI(stage);
            stage.show();
            return true;
        }

        return false;

    }

    /**
     * Player attacks enemy ships in an animation
     */
    public void playerShoots(int amountOfShots) {
        shotsFired.setFromX(0);
        shotsFired.setFromY(0);
        shotsFired.setToX(endX);
        shotsFired.setToY(endY);
        shotsFired.setDuration(Duration.seconds(0.5));
        if (super.getGuns() > 0) {
            shotsFired.setCycleCount(amountOfShots);
        } else {
            shotsFired.setCycleCount(0);
            shotsFired.stop();
            cannon.setVisible(false);
        }
        shotsFired.setNode(cannon);
        shotsFired.play();
    }

    /**
     * Ships attack player ship back in an animation
     */

    public void shipsRetaliate() {
        cannon.setVisible(true);
        enemyShots.setFromX(270);
        enemyShots.setFromY(0);
        enemyShots.setToX(-30);
        enemyShots.setToY(90);
        enemyShots.setDuration(Duration.seconds(0.5));
        enemyShots.setCycleCount(1);
        enemyShots.setNode(cannon);
        enemyShots.play();
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


    /**
     * Generaties ships and deploys logic for the shipwarfare
     *
     * @param primaryStage sets up the stage to whcih the GUI may be based around
     * @throws Exception in case of interruptions withing the graphical interface
     */
    public void initializeShip(Stage primaryStage) throws Exception {

        logic.setNumOfShips(logic.numOfShips());

        Pane root = new Pane();
        HBox usAgainstEnemyDivisor;
        BorderPane centeringUserShipPane = new BorderPane();
        Circle cannon;
        BorderPane centeringShipPane = new BorderPane();
        BorderPane encompassingPane = new BorderPane();
        usAgainstEnemyDivisor = new HBox();
        cannon = new Circle();
        this.cannon = cannon;


        cannon.setVisible(false);

        buttonBox = new VBox();
        fightRunBox = new HBox();
        fightButton = new Button();
        runButton = new Button();
        continueButton = new Button();
        labelBox = new VBox();
        title = new Label();
        HPLeft = new Label();
        gunsLeftOrTaken = new Label();
        runAwayOrLeft = new Label();
        shipsRemaining = new Label();
        report = new Label();

        title.setText(String.format("%d ships from Liu Yuen's Fleet are attacking, Would you like to fight or run?", logic.getNumOfShips()));


        fightButton.setText("Fight");
        runButton.setText("Run");
        continueButton.setText("Continue");

        fightButton.setVisible(true);
        runButton.setVisible(true);
        continueButton.setVisible(false);


        encompassingPane.setAlignment(labelBox, javafx.geometry.Pos.CENTER);
        labelBox.setAlignment(javafx.geometry.Pos.CENTER);
        labelBox.setPrefHeight(41.0);
        labelBox.setPrefWidth(600.0);
        labelBox.setSpacing(20.0);

        labelBox.setPadding(new Insets(10.0, 0.0, 0.0, 0.0));

        encompassingPane.setAlignment(buttonBox, javafx.geometry.Pos.CENTER);
        buttonBox.setAlignment(javafx.geometry.Pos.TOP_CENTER);


        fightRunBox.setAlignment(javafx.geometry.Pos.CENTER);
        fightRunBox.setPrefHeight(100.0);
        fightRunBox.setPrefWidth(200.0);
        fightRunBox.setSpacing(10.0);

        VBox.setMargin(continueButton, new Insets(0.0, 0.0, 20.0, 0.0));


        root.getChildren().add(cannon);

        encompassingPane.setPrefHeight(480);
        encompassingPane.setPrefWidth(600);


        usAgainstEnemyDivisor.setPrefHeight(0.0);
        usAgainstEnemyDivisor.setPrefWidth(600.0);

        centeringUserShipPane.setPrefHeight(200.0);
        centeringUserShipPane.setPrefWidth(200.0);

        Image ourShip;
        Image enemyShip;

        try {
            ourShip = new Image(new FileInputStream("src/images/ourShip.png"));
            enemyShip = new Image(new FileInputStream("src/images/enemyShip.png"));

        } catch (Exception e) {
            ourShip = new Image(new FileInputStream("images/ourShip.png"));
            enemyShip = new Image(new FileInputStream("images/enemyShip.png"));
        }


        //Setting the image view
        ImageView userShip = new ImageView(ourShip);
        ImageView Ship = new ImageView(enemyShip);

        BorderPane.setAlignment(userShip, javafx.geometry.Pos.CENTER);
        userShip.setFitHeight(150.0);
        userShip.setFitWidth(248.0);
        userShip.setPickOnBounds(true);
        userShip.setPreserveRatio(true);
        centeringUserShipPane.setCenter(userShip);

        BorderPane.setAlignment(buttonBox, javafx.geometry.Pos.CENTER);
        buttonBox.setAlignment(javafx.geometry.Pos.TOP_CENTER);

        usAgainstEnemyDivisor.setTranslateY(-20.0);

        cannon.setRadius(10.0);
        cannon.setStroke(javafx.scene.paint.Color.BLACK);
        cannon.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);
        centeringUserShipPane.setRight(cannon);

        centeringShipPane.setPrefHeight(200.0);
        centeringShipPane.setPrefWidth(200.0);
        centeringShipPane.setOpaqueInsets(new Insets(0.0));
        HBox.setMargin(centeringShipPane, new Insets(0.0, 0.0, 0.0, 200.0));

        encompassingPane.setAlignment(Ship, javafx.geometry.Pos.CENTER);
        Ship.setFitHeight(165.0);
        Ship.setFitWidth(180.0);
        Ship.setPickOnBounds(true);
        Ship.setPreserveRatio(true);
        encompassingPane.setMargin(Ship, new Insets(0.0, 0.0, 20.0, 0.0));
        centeringShipPane.setCenter(Ship);

        usAgainstEnemyDivisor.getChildren().add(centeringUserShipPane);
        usAgainstEnemyDivisor.getChildren().add(centeringShipPane);
        fightRunBox.getChildren().add(fightButton);
        fightRunBox.getChildren().add(continueButton);
        fightRunBox.getChildren().add(runButton);
        buttonBox.getChildren().add(fightRunBox);
        labelBox.getChildren().add(title);
        labelBox.getChildren().add(HPLeft);
        labelBox.getChildren().add(gunsLeftOrTaken);
        labelBox.getChildren().add(runAwayOrLeft);
        labelBox.getChildren().add(shipsRemaining);
        labelBox.getChildren().add(report);

        encompassingPane.setTop(labelBox);
        encompassingPane.setCenter(usAgainstEnemyDivisor);

        encompassingPane.setBottom(buttonBox);

        root.getChildren().addAll(encompassingPane, cannon);

        Scene scene = new Scene(root, 600, 480);
        root.getStylesheets().add("styleguide.css");

        primaryStage.setResizable(false);

        primaryStage.setTitle("Ship Warfare");
        primaryStage.setScene(scene);
        primaryStage.show();
        continueButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            /**
             * Continue Button, engages in run logic and graphical interface
             * @param event, once button is clicked, executes graphical information
             */
            public void handle(ActionEvent event) {
                shotsFired.stop();

                /**
                 * Switches to Taipan Shop scene
                 */

                TaipanShopGUI shop = new TaipanShopGUI(getPlayer());
                shop.initializeShop(primaryStage);
                primaryStage.show();

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
                userAttacks = false;

                report.setVisible(true);
                title.setVisible(true);
                shipsRemaining.setVisible(true);
                gunsLeftOrTaken.setVisible(true);

                title.setText("Ayy captain we will try to run!");
                counter++;

                if (logic.runFromShips(userAttacks) == false) {
                    report.setText(("Couldn't run away"));
                    try {
                        winOrLose = destroyShipsOrEscape(primaryStage);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    if (winOrLose == true) {
                        report.setVisible(false);
                        title.setVisible(false);
                        shipsRemaining.setVisible(false);
                        gunsLeftOrTaken.setVisible(false);

                    }
                } else {

                    report.setText("Phew! Got away safely");
                    setVisibilitiesAndTransition(primaryStage);


                }

            }
        });

        //Fight
        fightButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            /**
             * Fight Button, engages in fight logic and graphical interface
             * @param event, once button is clicked, executes graphical information
             */
            public void handle(ActionEvent event) {
                userAttacks = true;

                wipeWithTitle(report);
                fightButton.setVisible(false);
                runButton.setVisible(false);

                try {
                    winOrLose = destroyShipsOrEscape(primaryStage);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                counter++;

                cannon.setVisible(true);
                cannon.setLayoutX(beginningX);
                cannon.setLayoutY(beginningY);

                if (counter >= 1) {
                    title.setVisible(false);

                }

                playerShoots(getGuns());

                shotsFired.setOnFinished(new EventHandler<ActionEvent>() {
                    @Override
                    /**
                     * When the user is completed their volley this information will be accessed
                     * @param event, once the shots fired transition is completed, execute graphical information
                     */
                    public void handle(ActionEvent event) {
                        shotsFired.stop();
                        if (!winOrLose) {
                            shipsRetaliate();
                        } else {
                            report.setVisible(true);
                            continueButton.setVisible(true);
                            usAgainstEnemyDivisor.setVisible(false);
                            cannon.setVisible(false);
                            shotsFired.stop();

                        }
                        enemyShots.setOnFinished(new EventHandler<ActionEvent>() {
                            @Override
                            /**
                             * When the user is completed their volley, this information will be accessed
                             * @param event, once the enemy shots transition is completed, execute graphical information
                             */
                            public void handle(ActionEvent event) {
                                fightButton.setVisible(true);
                                runButton.setVisible(true);
                                report.setVisible(true);
                                cannon.setVisible(false);
                                runAwayOrLeft.setVisible(true);
                                gunsLeftOrTaken.setVisible(true);
                                shipsRemaining.setVisible(true);
                                HPLeft.setVisible(true);
                                gunsLeftOrTaken.setVisible(true);

                                if (winOrLose == true) {
                                    usAgainstEnemyDivisor.setVisible(false);
                                }

                            }
                        });

                    }

                });


            }
        });

    }
}

