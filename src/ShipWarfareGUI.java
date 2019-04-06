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
import java.util.concurrent.ExecutionException;


/**
 * 2019-03-10 (Edited on 2019-03-23)
 * Author: Haris Muhammad
 * ShipWarfareGUI class, Generates and utilizes ships which the user can attack or run from
 */


public class ShipWarfareGUI extends Player {

    private ShipWarfareGUI ship;
    //private ShipWarfareGUILogic logic;
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


    private int timeCounter;


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


    /**
     * Player attacks enemy ships in an animation
     */
    public void playerShoots(int amountOfShots) {
        shotsFired.setFromX(0);
        shotsFired.setFromY(0);
        shotsFired.setToX(endX);
        shotsFired.setToY(endY);
        shotsFired.setDuration(Duration.seconds(0.5));
        if (getGuns() > 0) {
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

    /*
    public boolean winOrLose(Stage stage) {
        if (logic.destroyLittyShipsOrEscape() == 1) {
            wipe();
            report.setText(logic.getReportMessage());
            continueButton.setVisible(true);
            completeWipe();
            fightButton.setVisible(false);
            runButton.setVisible(false);
            continueButton.setDefaultButton(true);
            return true;


        } else if (logic.destroyLittyShipsOrEscape() == 2) {
            GameEndGUI gameEndGUI = new GameEndGUI(getPlayer());
            gameEndGUI.initializeGameEndGUI(stage);
            stage.show();
            return true;

        } else if (logic.destroyLittyShipsOrEscape() == 3) {
            report.setText(String.format("We made it out at %d%% ship status!", getHP()));

            continueButton.setVisible(true);
            completeWipe();
            fightButton.setVisible(false);
            runButton.setVisible(false);
            continueButton.setDefaultButton(true);
            return true;
        }
    }
    */

    /**
     * Generaties ships and deploys logic for the shipwarfare
     *
     * @param primaryStage sets up the stage to whcih the GUI may be based around
     * @throws Exception in case of interruptions withing the graphical interface
     */
    /*
    public void initializeShip(Stage primaryStage) throws Exception
    */
}