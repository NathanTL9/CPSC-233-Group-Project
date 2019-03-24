
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;


public class AnimationTesting extends Player {

    private ShipWarfareGUI ship;
    private HBox usAgainstEnemyDivisor;
    private BorderPane centeringUserShipPane;
    private Circle cannon;
    private BorderPane centeringMerchantShipPane;
    private BorderPane encompassingPane;

    /**
     * constructor; only runs when a Player object is provided. The constructor is fully encapsulated.
     *
     * @param player is a Player object that will be copied and the player instance variable is set to the copy.
     */
    public AnimationTesting(Player player) {
        Player playerDummy = new Player(player);
        this.ship = new ShipWarfareGUI(player);
        setPlayer(playerDummy);
    }


}


