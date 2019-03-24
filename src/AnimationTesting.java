
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

    public void startShipAnimation(Stage primaryStage) throws Exception {


        Pane root = new Pane();
        usAgainstEnemyDivisor = new HBox();
        centeringUserShipPane = new BorderPane();
        cannon = new Circle();
        centeringMerchantShipPane = new BorderPane();
        encompassingPane = new BorderPane();


        final int USER_SHOOTS_X = 150;
        final int USER_SHOOTS_Y = 180;

        final int CLEAN_SHOT_X= 350;
        final int CLEAN_SHOT_Y = 110;

        root.getChildren().add(cannon);

        encompassingPane.setPrefHeight(480);
        encompassingPane.setPrefWidth(600);

        usAgainstEnemyDivisor.setPrefHeight(480.0);
        usAgainstEnemyDivisor.setPrefWidth(600.0);

        centeringUserShipPane.setPrefHeight(200.0);
        centeringUserShipPane.setPrefWidth(200.0);

        Image ourShip = new Image(new FileInputStream("src/images/ourShip.png"));
        Image enemyShip = new Image(new FileInputStream("src/images/enemyShip.png"));


        //Setting the image view
        ImageView userShip = new ImageView(ourShip);
        ImageView merchantShip = new ImageView(enemyShip);

        BorderPane.setAlignment(userShip, javafx.geometry.Pos.CENTER);
        userShip.setFitHeight(150.0);
        userShip.setFitWidth(248.0);
        userShip.setPickOnBounds(true);
        userShip.setPreserveRatio(true);
        centeringUserShipPane.setCenter(userShip);



        cannon.setRadius(10.0);
        cannon.setStroke(javafx.scene.paint.Color.BLACK);
        cannon.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);
        centeringUserShipPane.setRight(cannon);

        centeringMerchantShipPane.setPrefHeight(200.0);
        centeringMerchantShipPane.setPrefWidth(200.0);
        centeringMerchantShipPane.setOpaqueInsets(new Insets(0.0));
        HBox.setMargin(centeringMerchantShipPane, new Insets(0.0, 0.0, 0.0, 200.0));

        encompassingPane.setAlignment(merchantShip, javafx.geometry.Pos.CENTER);
        merchantShip.setFitHeight(165.0);
        merchantShip.setFitWidth(180.0);
        merchantShip.setPickOnBounds(true);
        merchantShip.setPreserveRatio(true);
        encompassingPane.setMargin(merchantShip, new Insets(0.0, 0.0, 20.0, 0.0));
        centeringMerchantShipPane.setCenter(merchantShip);
        encompassingPane.setCenter(usAgainstEnemyDivisor);

        usAgainstEnemyDivisor.getChildren().add(centeringUserShipPane);
        usAgainstEnemyDivisor.getChildren().add(centeringMerchantShipPane);

        root.getChildren().addAll(encompassingPane,cannon);

        // start
        cannon.setLayoutX(USER_SHOOTS_X);
        cannon.setLayoutY(USER_SHOOTS_Y);

        TranslateTransition shotsFired = new TranslateTransition();
        shotsFired.setDuration(Duration.seconds(3));
        shotsFired.setToX(CLEAN_SHOT_X);
        shotsFired.setToY(CLEAN_SHOT_Y);
        shotsFired.setCycleCount(5);
        shotsFired.setNode(cannon);
        shotsFired.play();

        Scene scene = new Scene(root,600,480);
        root.getStylesheets().add("styleguide.css");

        primaryStage.setScene(scene);
        primaryStage.show();

    }
}


