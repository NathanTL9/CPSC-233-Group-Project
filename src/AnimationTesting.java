
import javafx.animation.TranslateTransition;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
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
    private BorderPane centeringLittyShipPane;
    private BorderPane encompassingPane;
    private  VBox buttonBox;
    private  HBox fightRunBox;
    private  Button fightButton;
    private  Button runButton;
    private  Button continueButton;
    private  VBox labelBox;
    private  Label title;
    private  Label HPLeft;
    private  Label gunsLeftOrTaken;
    private  Label runAwayOrLeft;
    private  Label shipsRemaining;
    private  Label report;

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
        HBox usAgainstEnemyDivisor;
        BorderPane centeringUserShipPane = new BorderPane();
        Circle cannon;
        BorderPane centeringLittyShipPane = new BorderPane();
        BorderPane encompassingPane = new BorderPane();
        usAgainstEnemyDivisor = new HBox();
        cannon = new Circle();

        buttonBox = new VBox();
        fightRunBox = new HBox();
        fightButton = new Button();
        runButton = new Button();
        continueButton = new Button();
        labelBox = new VBox();
        title = new Label();
        HPLeft = new Label();
        gunsLeftOrTaken = new Label();
        runAwayOrLeft = new Label();
        shipsRemaining = new Label();
        report = new Label();

        title.setText("7 ships from Liu Yuen's Fleet are attacking, Would you like to fight or run?");

        HPLeft.setText("Ship Status: 100%");

        gunsLeftOrTaken.setText("Guns: 5");

        runAwayOrLeft.setText("6 Ships Ran Away:");

        shipsRemaining.setText("Number Of Ships Remaining:");

        report.setText("Report: Ships hit 4, Shots missed 1");



        fightButton.setText("Fight");
        runButton.setText("Run");
        continueButton.setText("Continue");



        final int USER_SHOOTS_X = 150;
        final int USER_SHOOTS_Y = 245;

        final int CLEAN_SHOT_X = 350;
        final int CLEAN_SHOT_Y = 90;

        encompassingPane.setAlignment(labelBox, javafx.geometry.Pos.CENTER);
        labelBox.setAlignment(javafx.geometry.Pos.CENTER);
        labelBox.setPrefHeight(41.0);
        labelBox.setPrefWidth(600.0);
        labelBox.setSpacing(20.0);

        labelBox.setPadding(new Insets(10.0, 0.0, 0.0, 0.0));

        encompassingPane.setAlignment(buttonBox, javafx.geometry.Pos.CENTER);
        buttonBox.setAlignment(javafx.geometry.Pos.TOP_CENTER);

        fightButton.setVisible(true);
        runButton.setVisible(true);
        continueButton.setVisible(true);

        fightRunBox.setAlignment(javafx.geometry.Pos.CENTER);
        fightRunBox.setPrefHeight(100.0);
        fightRunBox.setPrefWidth(200.0);
        fightRunBox.setSpacing(10.0);

        VBox.setMargin(continueButton, new Insets(0.0, 0.0, 20.0, 0.0));



        root.getChildren().add(cannon);

        encompassingPane.setPrefHeight(480);
        encompassingPane.setPrefWidth(600);


        usAgainstEnemyDivisor.setPrefHeight(0.0);
        usAgainstEnemyDivisor.setPrefWidth(600.0);

        centeringUserShipPane.setPrefHeight(200.0);
        centeringUserShipPane.setPrefWidth(200.0);

        Image ourShip = new Image(new FileInputStream("src/images/ourShip.png"));
        Image enemyShip = new Image(new FileInputStream("src/images/enemyShip.png"));


        //Setting the image view
        ImageView userShip = new ImageView(ourShip);
        ImageView littyShip = new ImageView(enemyShip);

        BorderPane.setAlignment(userShip, javafx.geometry.Pos.CENTER);
        userShip.setFitHeight(150.0);
        userShip.setFitWidth(248.0);
        userShip.setPickOnBounds(true);
        userShip.setPreserveRatio(true);
        centeringUserShipPane.setCenter(userShip);

        BorderPane.setAlignment(buttonBox, javafx.geometry.Pos.CENTER);
        buttonBox.setAlignment(javafx.geometry.Pos.TOP_CENTER);

        usAgainstEnemyDivisor.setTranslateY(-20.0);

        cannon.setRadius(10.0);
        cannon.setStroke(javafx.scene.paint.Color.BLACK);
        cannon.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);
        centeringUserShipPane.setRight(cannon);

        centeringLittyShipPane.setPrefHeight(200.0);
        centeringLittyShipPane.setPrefWidth(200.0);
        centeringLittyShipPane.setOpaqueInsets(new Insets(0.0));
        HBox.setMargin(centeringLittyShipPane, new Insets(0.0, 0.0, 0.0, 200.0));

        encompassingPane.setAlignment(littyShip, javafx.geometry.Pos.CENTER);
        littyShip.setFitHeight(165.0);
        littyShip.setFitWidth(180.0);
        littyShip.setPickOnBounds(true);
        littyShip.setPreserveRatio(true);
        encompassingPane.setMargin(littyShip, new Insets(0.0, 0.0, 20.0, 0.0));
        centeringLittyShipPane.setCenter(littyShip);

        usAgainstEnemyDivisor.getChildren().add(centeringUserShipPane);
        usAgainstEnemyDivisor.getChildren().add(centeringLittyShipPane);
        fightRunBox.getChildren().add(fightButton);
        fightRunBox.getChildren().add(continueButton);
        fightRunBox.getChildren().add(runButton);
        buttonBox.getChildren().add(fightRunBox);
        labelBox.getChildren().add(title);
        labelBox.getChildren().add(HPLeft);
        labelBox.getChildren().add(gunsLeftOrTaken);
        labelBox.getChildren().add(runAwayOrLeft);
        labelBox.getChildren().add(shipsRemaining);
        labelBox.getChildren().add(report);

        encompassingPane.setTop(labelBox);
        encompassingPane.setCenter(usAgainstEnemyDivisor);

        encompassingPane.setBottom(buttonBox);

        root.getChildren().addAll(encompassingPane, cannon);

        // start
        cannon.setLayoutX(USER_SHOOTS_X);
        cannon.setLayoutY(USER_SHOOTS_Y);

        TranslateTransition shotsFired = new TranslateTransition();

        shotsFired.setDuration(Duration.seconds(3));
        shotsFired.setToX(CLEAN_SHOT_X);
        shotsFired.setToY(CLEAN_SHOT_Y);
        shotsFired.setCycleCount(getGuns());
        shotsFired.setNode(cannon);
        shotsFired.play();



        Scene scene = new Scene(root, 600, 480);
        root.getStylesheets().add("styleguide.css");

        primaryStage.setResizable(false);

        primaryStage.setScene(scene);
        primaryStage.show();

    }

}


