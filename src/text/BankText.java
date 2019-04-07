package text;

import logic.Player;

public class BankText extends Player {
    public BankText(Player player) {
        Player playerDummy = new Player(player);
        setPlayer(playerDummy);
    }

    public void bank() {
    }
}
