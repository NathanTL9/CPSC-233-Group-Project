package logic;

public class LoanSharkLogic extends Player{

    /**
     * constructor; only runs when a Player object is provided. The constructor is fully encapsulated.
     *
     * @param player is a Player object that will be copied and the player instance variable is set to the copy.
     */
    public LoanSharkLogic(Player player) {
        Player playerDummy = new Player(player);
        setPlayer(playerDummy);
    }

    /**
     * Used to set and change loans for the Player
     * @param debt the amount of money the loan is for
     * @param money How much money is either taken or give to the Player
     */
    public void changeLoan(int debt, int money) {
        setDebt(debt);
        setMoney(money);
    }
}
