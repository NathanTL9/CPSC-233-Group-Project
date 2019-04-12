package text;

import logic.Player;

/**
 * Updates main class with player data and starts the game.
 * The game will only run as long as the player has not retired or has been destroyed.
 */
public class MainText extends Player {
    public MainText(Player player) {
        Player playerDummy = new Player(player);
        setPlayer(playerDummy);
    }

    public static void main(String[] args) {
        StartText startText = new StartText(new Player());
        startText.start();
    }
}
