package logic;

public class StartLogic extends Player {

    /**
     * constructor; only runs when a Player object is provided. The constructor is fully encapsulated.
     * @param player is a Player object that will be copied and the player instance variable is set to the copy.
     */
    public StartLogic(Player player) {
        Player playerDummy = new Player(player);
        this.setPlayer(playerDummy);
    }

    /**
     * Used in the Start Class
     * method that sets the player's money and debt to 400 and 5000 respectively.
     * also sets the player's guns to 0.
     */
    public void money_and_debt() {
        setMoney(400);
        setDebt(5000);
        setGuns(0);
    }

    /**
     * Used in the Start Class
     * method that sets the player's guns to 5.
     */
    public void guns() {
        setGuns(5);
    }

    /**
     * Used in the Start Class
     * for testing purposes
     * sets the player's money, bank, guns, hp, ad cargo space to max values.
     */
    public void cheat() {
        setMoney(1000000);
        setBank(1000000);
        setGuns(1000000);
        setHP(1000000);
        setCargoSpace(100000000);
    }
}
