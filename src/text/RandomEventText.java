package text;

import logic.Player;

public class RandomEventText extends Player {
    public RandomEventText(Player player) {
        Player playerDummy = new Player(player);
        setPlayer(playerDummy);
    }
}
