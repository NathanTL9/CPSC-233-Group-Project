package logic;

public class GameEndLogic extends Player{


    /**
     * Class Constructor that takes in a type player as a parameter
     *
     * @param player object of the class Player
     */
    public GameEndLogic(Player player) {
        Player playerDummy = new Player(player);
        setPlayer(playerDummy);
    }

    /**
     * Calculates the networth of the player by the end of the game.
     * Calculation is based off the total guns and items bought throughout the game
     * @return the total networth of the player
     */
    public int getNetWorth() {
        int netWorthInt;
        netWorthInt = getMoney() + (getOpiumHeld() * 16000) + (getSilkHeld() * 160) + (getArmsHeld() * 160) + (getGeneralHeld() * 8);
        netWorthInt += (getwOpium() * 16000) + (getwSilk() * 160) + (getwArms() * 160) + (getwGeneral() * 8);
        netWorthInt -= getDebt();
        return netWorthInt;
    }

    /**
     * If health is below or equal to 0 then the game will either show the gameOver screen or the win screen
     * @return the endGame message
     */
    public String endGameText() {
        if (getHP() <= 0) {
            return "Game Over!";
        } else {
            return "Congratulations!";
        }
    }

    /**
     * A method that creates an array filled will all the user's stats
     * @param netWorthInt the total net worth of the user
     * @return Returns the firm name of the user, the guns they held and their total net worth
     */
    public String[] endGameStats(int netWorthInt) {
        return new String[]{"Firm Name: " + getName(), "Guns Held: " + getGuns(), "Net Worth: " + netWorthInt};
    }
}
