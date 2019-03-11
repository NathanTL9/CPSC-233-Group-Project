import javafx.application.Application;
import javafx.stage.Stage;

/**
* 2019-03-10
* Authors: Harkamal, Vikram, Haris, Siddhant, Nathan
* MainGUI class, Initializes the entire game and runs the game for user to play
*
*/

public class MainGUI extends Application {
    private Player player = new Player();

    /**
     * getter method for the Player object player.
     *
     * @return returns a copy of the object player
     */

    public Player getPlayer() {
        Player copy = new Player(player);
        return copy;
    }

    /**
     * Initializes the Taipan shop with the players stats after the player finishes shopping, it updates the player object and returns it.
     *
     * @param shop player object from the main class used to update the shop class
     */

    public void shop(TaipanShopGUI shop) {
        shop.setPlayer(player);
        shop.shop();
        player = shop.getPlayer();
    }

    /**
     * Updates main class with player data and starts the game.
     * The game will only run as long as the player has not retired or has been destroyed.
     *
     * @param args Just the console for the player to look at.
     */
    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) throws Exception {
        StartGUI start = new StartGUI(player);
        start.initializeStart(primaryStage);
        primaryStage.show();
    }
}
