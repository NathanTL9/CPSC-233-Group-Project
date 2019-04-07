package text;
import logic.Player;

public class TravelText extends Player {

    public TravelText(Player player) {
        Player playerDummy = new Player(player);
        setPlayer(playerDummy);
    }

    public void travelTo() {
    }
}
