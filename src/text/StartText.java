package text;

import logic.Player;

public class StartText extends Player {
    public StartText(Player player) {
        Player playerDummy = new Player(player);
        setPlayer(playerDummy);
    }
}
