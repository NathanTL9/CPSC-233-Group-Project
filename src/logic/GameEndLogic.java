package logic;

public class GameEndLogic extends Player{
    /**
     * Calculates the networth of the player by the end of the game
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
}
