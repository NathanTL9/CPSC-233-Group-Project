package text;

import logic.Player;

public class MainText extends Player {
    public MainText(Player player) {
        Player playerDummy = new Player(player);
        setPlayer(playerDummy);
    }
}
