package text;

import logic.GameEndLogic;
import logic.Player;

public class GameEndText extends Player {

    /**
     * Class Constructor that takes in a type player as a parameter
     *
     * @param player object of the class Player
     */
    public GameEndText(Player player) {
        Player playerDummy = new Player(player);
        setPlayer(playerDummy);
    }

    /**
     * At the end of the game, the end game stats appear the Firm's name, the number of guns held by the player and the networth of the player
     */
    public void gameEnd(){
        //Calculating the netWorth of the Player
        GameEndLogic gameEndLogic = new GameEndLogic(getPlayer());
        int netWorthInt = gameEndLogic.getNetWorth();

        String[] strings = gameEndLogic.endGameStats(netWorthInt);
        //Updating the endgame stats of the player
        System.out.println(strings[0]);
        System.out.println(strings[1]);
        System.out.println(strings[2]);
        System.exit(0);
    }

}
