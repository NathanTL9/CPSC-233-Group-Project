package logic;

public class BankLogic extends Player {

    /**
     * constructor; only runs when a Player object is provided. The constructor is fully encapsulated.
     * @param player is a Player object that will be copied and the player instance variable is set to the copy.
     */
    public BankLogic(Player player) {
        Player playerDummy = new Player(player);
        setPlayer(playerDummy);
    }

    /**
     * Withdraws a set amount of money from the player's bank account and gives it to the player
     * @param withdraw the amount of money which the player is withdrawing
     */
    public void withdrawing(int withdraw) {
        setMoney(withdraw + getMoney());
        setBank(getBank() - withdraw);
    }

    /**
     * Deposits a set amount of money from the player to the player's bank account
     * @param deposit the amount of money which the player is depositing
     */
    public void depositing(int deposit) {
        setBank(deposit + getBank());
        setMoney(getMoney() - deposit);
    }
}
