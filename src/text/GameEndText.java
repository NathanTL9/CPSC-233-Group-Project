package text;

import logic.Player;

public class GameEndText extends Player {

    public GameEndText(Player player) {
        Player playerDummy = new Player(player);
        setPlayer(playerDummy);
    }

}
