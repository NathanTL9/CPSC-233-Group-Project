package text;

import logic.Player;

public class LoanSharkText extends Player {
    public LoanSharkText(Player player) {
        Player playerDummy = new Player(player);
        setPlayer(playerDummy);
    }

    public void loanMoney() {
    }
}
