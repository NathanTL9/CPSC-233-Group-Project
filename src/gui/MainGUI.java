package gui;

import javafx.application.Application;
import javafx.stage.Stage;
import logic.Player;

/**
* 2019-03-10
* Authors: Harkamal, Vikram, Haris, Siddhant, Nathan
* MainGUI class, Initializes the entire game and runs the game for user to play
*
*/

public class MainGUI extends Application {

    /**
     * Updates main class with player data and starts the game.
     * The game will only run as long as the player has not retired or has been destroyed.
     * @param args Just the console for the player to look at.
     */
    public static void main(String[] args) {
        launch(args);
    }

    /**
     * Starts the game as a whole, combines all of the other necessary classes
     * @param primaryStage Creates new stage for scene to be utilized
     */
    public void start(Stage primaryStage){
        StartGUI start = new StartGUI(new Player());
        start.initializeStart(primaryStage);
        primaryStage.show();
    }
}
