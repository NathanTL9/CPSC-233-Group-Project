
import javafx.animation.*;

import javafx.event.ActionEvent;
import javafx.event.Event;
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
import java.io.FileNotFoundException;
import java.util.Random;

/**
 * 2019-03-10 (Edited on 2019-03-23)
 * Author: Haris Muhammad
 * ShipWarfareGUI class, Generates and utilizes ships which the user can attack or run from
 */


public class AnimationTesting extends Player {

    private ShipWarfareGUI ship;
    private HBox usAgainstEnemyDivisor;
    private BorderPane centeringUserShipPane;
    private Circle cannon;
    private BorderPane centeringLittyShipPane;
    private BorderPane encompassingPane;
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

    private boolean winOrLose= false;


    private int counter1;
    private int timeCounter;

    private int numOfLittyShips = 0;
    private boolean userAttacks = true;
    private int startingLittyShips = 0;
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
    public AnimationTesting(Player player) {
        Player playerDummy = new Player(player);
        this.ship = new ShipWarfareGUI(player);
        setPlayer(playerDummy);
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


    }

    /**
     * Sets most of the  labels invisible including the fight or run label
     */
    public void completeWipe() {
        title.setVisible(false);
        runAwayOrLeft.setVisible(false);
        shipsRemaining.setVisible(false);
        HPLeft.setVisible(false);
        gunsLeftOrTaken.setVisible(false);
        report.setVisible(false);
    }



    public boolean destroyLittyShipsOrEscape(Stage stage) throws Exception {
        cannon.setLayoutX(beginningX);
        cannon.setLayoutY(beginningY);
        int calculateLoot = 0;
        int chanceOfEnemyRun = 0;
        int hitCounter = 0;
        int missCounter = 0;
        boolean gunFrustration = false;

        report.setVisible(false);
        runAwayOrLeft.setVisible(false);
        shipsRemaining.setVisible(false);
        HPLeft.setVisible(false);
        gunsLeftOrTaken.setVisible(false);




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
                int HPTaken = randomValue.nextInt(10);
                setHP(getHP() - (HPTaken));


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


        if (exitValue == 1) {
            wipe();
            calculateLoot = (startingLittyShips * 100) + randomValue.nextInt(startingLittyShips) * 200;
            setMoney(getMoney() + calculateLoot);
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
        } else if (exitValue == 3) {
            report.setText(String.format("We made it out at %d%% ship status!", getHP()));

            continueButton.setVisible(true);
            completeWipe();
            fightButton.setVisible(false);
            runButton.setVisible(false);
            continueButton.setDefaultButton(true);
            return true;
        }
        return false;

    }

    public void playerShoots() {
        userAttacks=true;
        shotsFired.setFromX(0);
        shotsFired.setFromY(0);
        shotsFired.setToX(endX);
        shotsFired.setToY(endY);
        shotsFired.setDuration(Duration.seconds(1));
        shotsFired.setCycleCount(getGuns());
        shotsFired.setNode(cannon);
        shotsFired.play();
    }

    public void shipsRetaliate(){
        enemyShots.setFromX(270);
        enemyShots.setFromY(0);
        enemyShots.setToX(-30);
        enemyShots.setToY(90);
        enemyShots.setDuration(Duration.seconds(1));
        enemyShots.setCycleCount(1);
        enemyShots.setNode(cannon);
        enemyShots.play();
    }


    public void startShipAnimation(Stage primaryStage) throws Exception {
        setNumOfLittyShips(numOfShips());

        Pane root = new Pane();
        HBox usAgainstEnemyDivisor;
        BorderPane centeringUserShipPane = new BorderPane();
        Circle cannon;
        BorderPane centeringLittyShipPane = new BorderPane();
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

        title.setText(String.format("%d ships from Liu Yuen's Fleet are attacking, Would you like to fight or run?", numOfLittyShips));


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

        Image ourShip = new Image(new FileInputStream("src/images/ourShip.png"));
        Image enemyShip = new Image(new FileInputStream("src/images/enemyShip.png"));


        //Setting the image view
        ImageView userShip = new ImageView(ourShip);
        ImageView littyShip = new ImageView(enemyShip);

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

        centeringLittyShipPane.setPrefHeight(200.0);
        centeringLittyShipPane.setPrefWidth(200.0);
        centeringLittyShipPane.setOpaqueInsets(new Insets(0.0));
        HBox.setMargin(centeringLittyShipPane, new Insets(0.0, 0.0, 0.0, 200.0));

        encompassingPane.setAlignment(littyShip, javafx.geometry.Pos.CENTER);
        littyShip.setFitHeight(165.0);
        littyShip.setFitWidth(180.0);
        littyShip.setPickOnBounds(true);
        littyShip.setPreserveRatio(true);
        encompassingPane.setMargin(littyShip, new Insets(0.0, 0.0, 20.0, 0.0));
        centeringLittyShipPane.setCenter(littyShip);

        usAgainstEnemyDivisor.getChildren().add(centeringUserShipPane);
        usAgainstEnemyDivisor.getChildren().add(centeringLittyShipPane);
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

        primaryStage.setScene(scene);
        primaryStage.show();
        continueButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                shotsFired.stop();

                /**
                 * Switches to Taipan Shop scene
                 * @param event, once button is clicked, executes graphical information
                 */


                TaipanShopGUI shop = new TaipanShopGUI(getPlayer());
                shop.initializeShop(primaryStage);
                primaryStage.show();

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

                try {
                     winOrLose= destroyLittyShipsOrEscape(primaryStage);
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

                playerShoots();

                shotsFired.setOnFinished(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                            shotsFired.stop();
                            if(!winOrLose) {
                                shipsRetaliate();
                            }
                            else{
                                report.setVisible(true);
                                continueButton.setVisible(true);
                                shotsFired.stop();

                            }
                            enemyShots.setOnFinished(new EventHandler<ActionEvent>() {
                                @Override
                                public void handle(ActionEvent event) {
                                    report.setVisible(true);
                                    cannon.setVisible(false);
                                    runAwayOrLeft.setVisible(true);
                                    gunsLeftOrTaken.setVisible(true);
                                    shipsRemaining.setVisible(true);
                                    HPLeft.setVisible(true);
                                    gunsLeftOrTaken.setVisible(true);

                                    if(winOrLose==true){
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







            /*
                for (int i = 0; i < 5; i++) {
                    cannon.setLayoutX(beginningX);
                    cannon.setLayoutY(beginningY);


                        @Override
                        public void handle(Event event) {
                            for (int i = 0; i < 5; i++) {
                                if (i == 2) {
                                    shotsFired.setFromX(0);
                                    shotsFired.setFromY(0);
                                    shotsFired.setToX(endX + 60);
                                    shotsFired.setToY(endY + 70);

                                    shotsFired.setFromX(0);
                                    shotsFired.setFromY(0);
                                    shotsFired.setToX(endX);
                                    shotsFired.setToY(endY);
                                    shotsFired.setNode(cannon);
                                    shotsFired.play();

                                } else {
                                    shotsFired.setFromX(0);
                                    shotsFired.setFromY(0);
                                    shotsFired.setToX(endX );
                                    shotsFired.setToY(endY );

                                    shotsFired.setFromX(0);
                                    shotsFired.setFromY(0);
                                    shotsFired.setToX(endX);
                                    shotsFired.setToY(endY);
                                    shotsFired.setNode(cannon);
                                    shotsFired.get
                                    shotsFired.play();

                                }
                            }
                        }

                    });
                    shotsFired.setDuration(Duration.seconds(3));
                    shotsFired.setCycleCount(5);


                    shotsFired.play();


                    shotsFired.setOnFinished(new EventHandler<ActionEvent>() {
                        @Override

                        public void handle(ActionEvent event) {
                            shotsFired.stop();


                        }
                    });


                }


                    /*
                destroyLittyShipsOrEscape(primaryStage);

                } catch (Exception e) {
                }



                if (counter >= 1) {
                    title.setVisible(false);

                }
            }

            }
        });


        Scene scene = new Scene(root, 600, 480);
        root.getStylesheets().add("styleguide.css");

        primaryStage.setResizable(false);

        primaryStage.setScene(scene);
        primaryStage.show();

    }
    */





