package gui;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import logic.Player;
import logic.GameEndLogic;

/**
* 2019-03-10
* Authors: Harkamal, Vikram, Haris, Siddhant, Nathan
* GameEndGUI class, Initializes and displays the graphical interface for when you lose
*
*/
public class GameEndGUI extends Player {

    private Label title;
    private VBox vBox;
    private Label firmName;
    private Label gunsHeld;
    private Label netWorth;
    private BorderPane borderPane;

    /**
     * Class Constructor that takes in a type player as a parameter
     *
     * @param player object of the class Player
     */
    public GameEndGUI(Player player) {
        Player playerDummy = new Player(player);
        setPlayer(playerDummy);
    }

    /**
     * Sets up the graphical part of GameEndGUI and includes all logic for the class
     *
     * @param stage sets the stage to which we will execute the scene of the GameEndGUI class
     * @return stage so that another class can switch to the stage
     */
    public void initializeGameEndGUI(Stage stage) {

        //Creating all the nodes
        title = new Label();
        vBox = new VBox();
        firmName = new Label();
        gunsHeld = new Label();
        netWorth = new Label();
        borderPane = new BorderPane();
        int netWorthInt = 0;

        borderPane.setPrefHeight(480.0);
        borderPane.setPrefWidth(600.0);

        //Setting positions and names of all the nodes
        BorderPane.setAlignment(title, javafx.geometry.Pos.CENTER);
        title.setText("Game Over!");
        title.setFont(new Font(43.0));
        BorderPane.setMargin(title, new Insets(0.0));
        title.setPadding(new Insets(50.0, 0.0, 0.0, 0.0));
        borderPane.setTop(title);

        BorderPane.setAlignment(vBox, javafx.geometry.Pos.CENTER);
        vBox.setAlignment(javafx.geometry.Pos.CENTER);
        vBox.setPrefHeight(200.0);
        vBox.setPrefWidth(100.0);

        firmName.setText("Name:");
        firmName.setFont(new Font(22.0));

        gunsHeld.setText("Guns Held:");
        gunsHeld.setFont(new Font(22.0));

        netWorth.setText("Net Worth:");
        netWorth.setFont(new Font(22.0));
        borderPane.setCenter(vBox);

        //Calculating the netWorth of the Player
        GameEndLogic gameEndLogic = new GameEndLogic(getPlayer());
        netWorthInt = gameEndLogic.getNetWorth();

        //Adding the labels to the character's stats to the VBox which will show up on the screen
        vBox.getChildren().add(firmName);
        vBox.getChildren().add(gunsHeld);
        vBox.getChildren().add(netWorth);
        title.setText(gameEndLogic.endGameText());

        String[] strings = gameEndLogic.endGameStats(netWorthInt);
        //Updating the endgame stats of the player
        firmName.setText(strings[0]);
        gunsHeld.setText(strings[1]);
        netWorth.setText(strings[2]);

        Scene root = new Scene(borderPane, 600, 480);
        root.getStylesheets().add("styleguide.css");

        stage.setTitle("End Game Stats");
        stage.setResizable(false);
        stage.setScene(root);
    }


}
