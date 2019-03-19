import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * 2019-03-10
 * Authors: Harkamal, Vikram, Haris, Siddhant, Nathan
 * WarehouseGUI class, Initializes and displays the graphical interface for the warehouse in Taipan
 *
 */
public class WarehouseGUI extends Player{

    private Text title;
    private HBox hBox;
    private Button withdraw;
    private Button deposit;
    private Button goBack;
    private VBox vBox;
    private Text playerName;
    private Text text;
    private Label opiumPlayer;
    private Label silkPlayer;
    private Label armsPlayer;
    private Label generalPlayer;
    private VBox vBox0;
    private Text text0;
    private Text text1;
    private Text opiumWarehouse;
    private Text silkWarehouse;
    private Text armsWarehouse;
    private Text generalWarehouse;
    private VBox vBox1;
    private Text inUseWarehouse;
    private Text vacantWarehouse;
    private BorderPane borderPane;
    private TextField textIn;
    private SplitMenuButton splitMenu;
    private CheckMenuItem general;
    private CheckMenuItem arms;
    private CheckMenuItem silk;
    private CheckMenuItem opium;

    /**
     * A constructor that takes an object of type Player as an argument
     *
     * @param player object of the class Player
     */
    public WarehouseGUI(Player player) {
        Player playerDummy = new Player(player);
        setPlayer(playerDummy);
    }

    /**
     * initializes the GUI for the warehouse aspect of our game.
     *
     * @param stage an object of type Stage
     * @return returns the stage of the GUI
     */
    public Stage initializeWarehouse(Stage stage) {

        title = new Text();
        hBox = new HBox();
        withdraw = new Button();
        deposit = new Button();
        vBox = new VBox();
        playerName = new Text();
        text = new Text();
        opiumPlayer = new Label();
        silkPlayer = new Label();
        armsPlayer = new Label();
        generalPlayer = new Label();
        vBox0 = new VBox();
        text0 = new Text();
        text1 = new Text();
        opiumWarehouse = new Text();
        silkWarehouse = new Text();
        armsWarehouse = new Text();
        generalWarehouse = new Text();
        vBox1 = new VBox();
        inUseWarehouse = new Text();
        vacantWarehouse = new Text();
        borderPane = new BorderPane();
        textIn = new TextField();
        splitMenu = new SplitMenuButton();
        general = new CheckMenuItem();
        arms = new CheckMenuItem();
        silk = new CheckMenuItem();
        opium = new CheckMenuItem();

        borderPane.setPrefHeight(480.0);
        borderPane.setPrefWidth(600.0);

        /**
         * Sets the preferred width and height of the borderpane window to 600 by 480.
         *
         */
        borderPane.setPrefHeight(480.0);
        borderPane.setPrefWidth(600.0);

        /**
         * Creates a label "Hong Kong Warehouse: at the top of the borderpane.
         *
         */
        BorderPane.setAlignment(title, javafx.geometry.Pos.CENTER);

        title.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        title.setStrokeWidth(0.0);
        title.setText("Hong Kong Warehouse");
        title.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        title.setWrappingWidth(393.63671875);
        title.setFont(new Font(24.0));
        borderPane.setPrefHeight(480.0);
        borderPane.setPrefWidth(600.0);

        BorderPane.setAlignment(title, javafx.geometry.Pos.CENTER);
        title.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        title.setStrokeWidth(0.0);
        title.setText("Hong Kong Warehouse");
        title.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        title.setWrappingWidth(393.63671875);
        title.setFont(new Font(24.0));
        borderPane.setTop(title);


        /**
         * creates an HBox at the center of the borderpane with a width of 200 and height of 100.
         *
         */
        BorderPane.setAlignment(hBox, javafx.geometry.Pos.CENTER);
        hBox.setAlignment(javafx.geometry.Pos.CENTER);
        hBox.setPrefHeight(100.0);
        hBox.setPrefWidth(200.0);

        /**
         * Creates a button with text "Withdraw" which handles user events.
         *
         */
        withdraw.setContentDisplay(javafx.scene.control.ContentDisplay.CENTER);
        withdraw.setMnemonicParsing(false);
        withdraw.setText("Withdraw");
        updateLabels();
        withdraw.setOnAction(new EventHandler<ActionEvent>() {
                                 /**
                                  * Creates a button with text "Deposit" which handles user events.
                                  *
                                  */
                                 @Override
                                 public void handle(ActionEvent event) {

                                     int withdraw = Integer.parseInt(textIn.getText());
                                     updateLabels();
                                     if (opium.isSelected()) {
                                         if (getwOpium() >= withdraw) {
                                             setwOpium(getwOpium() - withdraw);
                                             setOpiumHeld(getOpiumHeld() + withdraw);
                                         } else {
                                             title.setText("You don't have that much opium stored in the warehouse!");
                                         }
                                     }
                                     if (silk.isSelected()) {
                                         if (getwSilk() >= withdraw) {
                                             setwSilk(getwSilk() - withdraw);
                                             setSilkHeld(getSilkHeld() + withdraw);
                                         } else {
                                             title.setText("You don't have that much silk stored in the warehouse!");
                                         }
                                     }
                                     if (arms.isSelected()) {
                                         if (getwArms() >= withdraw) {
                                             setwArms(getwArms() - withdraw);
                                             setArmsHeld(getArmsHeld() + withdraw);
                                         } else {
                                             title.setText("You don't have that much arms stored in the warehouse!");
                                         }
                                     }
                                     if (general.isSelected()) {
                                         if (getwGeneral() >= withdraw) {
                                             setwGeneral(getwGeneral() - withdraw);
                                             setGeneralHeld(getGeneralHeld() + withdraw);
                                         } else {
                                             title.setText("You don't have that much general stored in the warehouse!");
                                         }
                                     }
                                 }
                             }
        );

        deposit.setMnemonicParsing(false);
        deposit.setText("Deposit");
        deposit.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        borderPane.setBottom(hBox);

        deposit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                updateLabels();
                int deposit = Integer.parseInt(textIn.getText());
                if (opium.isSelected()) {
                    if (getOpiumHeld() >= deposit) {
                        setwOpium(getwOpium() + deposit);
                        setOpiumHeld(getOpiumHeld() - deposit);
                    } else {
                        title.setText("You don't have that much opium stored in the ship!");
                    }
                }
                if (silk.isSelected()) {
                    if (getwSilk() >= deposit) {
                        setwSilk(getwSilk() + deposit);
                        setSilkHeld(getSilkHeld() - deposit);
                    } else {
                        title.setText("You don't have that much silk stored in the ship!");
                    }
                }
                if (arms.isSelected()) {
                    if (getwArms() >= deposit) {
                        setwArms(getwArms() + deposit);
                        setArmsHeld(getArmsHeld() - deposit);
                    } else {
                        title.setText("You don't have that much arms stored in the ship!");
                    }
                }
                if (general.isSelected()) {
                    if (getwGeneral() >= deposit) {
                        setwGeneral(getwGeneral() + deposit);
                        setGeneralHeld(getGeneralHeld() - deposit);
                    } else {
                        title.setText("You don't have that much general stored in the ship!");
                    }
                }
            }
        });

        splitMenu.setMnemonicParsing(false);
        splitMenu.setText("Item");

        general.setMnemonicParsing(false);
        general.setText("General");

        arms.setMnemonicParsing(false);
        arms.setText("Arms");

        silk.setMnemonicParsing(false);
        silk.setText("Silk");

        opium.setMnemonicParsing(false);
        opium.setText("Opium");
        borderPane.setBottom(hBox);

        BorderPane.setAlignment(vBox, javafx.geometry.Pos.CENTER_LEFT);
        vBox.setPrefHeight(156.0);
        vBox.setPrefWidth(106.0);

        /**
         * Creates a label with text "Player" with size 18 font and default font style.
         *
         */
        playerName.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        playerName.setStrokeWidth(0.0);
        playerName.setText("Player");
        playerName.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        playerName.setWrappingWidth(103.47265625);
        playerName.setFont(new Font(18.0));

        /**
         * Creates a label with no text for aesthetic spacing purposes.
         *
         */
        text.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text.setStrokeWidth(0.0);
        text.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        text.setWrappingWidth(103.47265625);
        text.setFont(new Font(18.0));

        /**
         * Creates a label with text "Opium" under the "Player" label with size 18 font and default font style
         *
         */
        opiumPlayer.setAlignment(javafx.geometry.Pos.CENTER);
        opiumPlayer.setContentDisplay(javafx.scene.control.ContentDisplay.CENTER);
        opiumPlayer.setPrefWidth(100.0);
        opiumPlayer.setText("Opium");
        opiumPlayer.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        opiumPlayer.setFont(new Font(18.0));

        /**
         * Creates a label with text "Silk" under the "Player" label with size 18 font and default font style.
         *
         */
        silkPlayer.setAlignment(javafx.geometry.Pos.CENTER);
        silkPlayer.setPrefWidth(100.0);
        silkPlayer.setText("Silk");
        silkPlayer.setFont(new Font(18.0));

        /**
         * Creates a label with text "Arms" under the "Player" label with size 18 font and default font style.
         *
         */
        armsPlayer.setAlignment(javafx.geometry.Pos.CENTER);
        armsPlayer.setPrefWidth(100.0);
        armsPlayer.setText("Arms");
        armsPlayer.setFont(new Font(18.0));

        /**
         * Creates a label with text "General" under the "Player" label with size 18 font and default font style.
         *
         */
        generalPlayer.setAlignment(javafx.geometry.Pos.CENTER);
        generalPlayer.setPrefWidth(100.0);
        generalPlayer.setText("General");
        generalPlayer.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        generalPlayer.setFont(new Font(18.0));
        borderPane.setLeft(vBox);

        /**
         * Creates a VBox at the center of the borderpane with a width of 261 and a height of 343.
         *
         */
        BorderPane.setAlignment(vBox0, javafx.geometry.Pos.TOP_LEFT);
        vBox0.setAlignment(javafx.geometry.Pos.CENTER);
        vBox0.setPrefHeight(343.0);
        vBox0.setPrefWidth(261.0);

        text0.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text0.setStrokeWidth(0.0);
        text0.setText("Warehouse");
        text0.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        text0.setWrappingWidth(103.47265625);
        text0.setFont(new Font(18.0));

        text1.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text1.setStrokeWidth(0.0);
        text1.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        text1.setWrappingWidth(103.47265625);
        text1.setFont(new Font(18.0));

        opiumWarehouse.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        opiumWarehouse.setStrokeWidth(0.0);
        opiumWarehouse.setText("Opium");
        opiumWarehouse.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        opiumWarehouse.setWrappingWidth(103.47265625);
        opiumWarehouse.setFont(new Font(18.0));

        silkWarehouse.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        silkWarehouse.setStrokeWidth(0.0);
        silkWarehouse.setText("Silk");
        silkWarehouse.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        silkWarehouse.setWrappingWidth(103.47265625);
        silkWarehouse.setFont(new Font(18.0));

        armsWarehouse.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        armsWarehouse.setStrokeWidth(0.0);
        armsWarehouse.setText("Arms");
        armsWarehouse.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        armsWarehouse.setWrappingWidth(103.47265625);
        armsWarehouse.setFont(new Font(18.0));

        generalWarehouse.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        generalWarehouse.setStrokeWidth(0.0);
        generalWarehouse.setText("General");
        generalWarehouse.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        generalWarehouse.setWrappingWidth(103.47265625);
        generalWarehouse.setFont(new Font(18.0));
        borderPane.setCenter(vBox0);

        BorderPane.setAlignment(vBox1, javafx.geometry.Pos.CENTER);
        vBox1.setPrefHeight(48.0);
        vBox1.setPrefWidth(152.0);

        inUseWarehouse.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        inUseWarehouse.setStrokeWidth(0.0);
        inUseWarehouse.setText("In use:");
        inUseWarehouse.setFont(new Font(18.0));

        vacantWarehouse.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        vacantWarehouse.setStrokeWidth(0.0);
        vacantWarehouse.setText("Vacant:");
        vacantWarehouse.setFont(new Font(18.0));
        borderPane.setRight(vBox1);
        borderPane.setTop(title);

        BorderPane.setAlignment(hBox, javafx.geometry.Pos.CENTER);
        hBox.setAlignment(javafx.geometry.Pos.CENTER);
        hBox.setPrefHeight(100.0);
        hBox.setPrefWidth(200.0);

        withdraw.setContentDisplay(javafx.scene.control.ContentDisplay.CENTER);
        withdraw.setMnemonicParsing(false);
        withdraw.setText("Withdraw");

        deposit.setMnemonicParsing(false);
        deposit.setText("Deposit");
        deposit.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);

        splitMenu.setMnemonicParsing(false);
        splitMenu.setText("Item");

        general.setMnemonicParsing(false);
        general.setText("General");

        arms.setMnemonicParsing(false);
        arms.setText("Arms");

        silk.setMnemonicParsing(false);
        silk.setText("Silk");

        opium.setMnemonicParsing(false);
        opium.setText("Opium");
        borderPane.setBottom(hBox);

        BorderPane.setAlignment(vBox, javafx.geometry.Pos.CENTER_LEFT);
        vBox.setPrefHeight(156.0);
        vBox.setPrefWidth(106.0);

        playerName.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        playerName.setStrokeWidth(0.0);
        playerName.setText("Player");
        playerName.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        playerName.setWrappingWidth(103.47265625);
        playerName.setFont(new Font(18.0));

        text.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text.setStrokeWidth(0.0);
        text.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        text.setWrappingWidth(103.47265625);
        text.setFont(new Font(18.0));

        opiumPlayer.setAlignment(javafx.geometry.Pos.CENTER);
        opiumPlayer.setContentDisplay(javafx.scene.control.ContentDisplay.CENTER);
        opiumPlayer.setPrefWidth(100.0);
        opiumPlayer.setText("Opium");
        opiumPlayer.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        opiumPlayer.setFont(new Font(18.0));

        silkPlayer.setAlignment(javafx.geometry.Pos.CENTER);
        silkPlayer.setPrefWidth(100.0);
        silkPlayer.setText("Silk");
        silkPlayer.setFont(new Font(18.0));

        armsPlayer.setAlignment(javafx.geometry.Pos.CENTER);
        armsPlayer.setPrefWidth(100.0);
        armsPlayer.setText("Arms");
        armsPlayer.setFont(new Font(18.0));

        generalPlayer.setAlignment(javafx.geometry.Pos.CENTER);
        generalPlayer.setPrefWidth(100.0);
        generalPlayer.setText("General");
        generalPlayer.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        generalPlayer.setFont(new Font(18.0));
        borderPane.setLeft(vBox);

        BorderPane.setAlignment(vBox0, javafx.geometry.Pos.TOP_LEFT);
        vBox0.setAlignment(javafx.geometry.Pos.CENTER);
        vBox0.setPrefHeight(343.0);
        vBox0.setPrefWidth(261.0);

        /**
         * Creates a label with text "Warehouse" with size 18 font and default font style.
         *
         */
        text0.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text0.setStrokeWidth(0.0);
        text0.setText("Warehouse");
        text0.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        text0.setWrappingWidth(103.47265625);
        text0.setFont(new Font(18.0));

        /**
         * Creates a label with no text for aesthetic spacing purposes.
         *
         */
        text1.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text1.setStrokeWidth(0.0);
        text1.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        text1.setWrappingWidth(103.47265625);
        text1.setFont(new Font(18.0));

        /**
         * Creates a label with text "Opium" under the "Warehouse" label with size 18 font and default font style.
         *
         */
        opiumWarehouse.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        opiumWarehouse.setStrokeWidth(0.0);
        opiumWarehouse.setText("Opium");
        opiumWarehouse.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        opiumWarehouse.setWrappingWidth(103.47265625);
        opiumWarehouse.setFont(new Font(18.0));

        /**
         * Creates a label with text "Silk" under the "Warehouse" label with size 18 font and default font style.
         *
         */
        silkWarehouse.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        silkWarehouse.setStrokeWidth(0.0);
        silkWarehouse.setText("Silk");
        silkWarehouse.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        silkWarehouse.setWrappingWidth(103.47265625);
        silkWarehouse.setFont(new Font(18.0));

        /**
         * Creates a label with text "Arms" under the "Warehouse" label with size 18 font and default font style.
         *
         */
        armsWarehouse.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        armsWarehouse.setStrokeWidth(0.0);
        armsWarehouse.setText("Arms");
        armsWarehouse.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        armsWarehouse.setWrappingWidth(103.47265625);
        armsWarehouse.setFont(new Font(18.0));

        /**
         * Creates a label with text "General" under the "Warehouse" label with size 18 font and default font style.
         *
         */
        generalWarehouse.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        generalWarehouse.setStrokeWidth(0.0);
        generalWarehouse.setText("General");
        generalWarehouse.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        generalWarehouse.setWrappingWidth(103.47265625);
        generalWarehouse.setFont(new Font(18.0));
        borderPane.setCenter(vBox0);

        /**
         * Creates a VBox at the center of the borderpane with a width of 152 and a height of 48.
         *
         */
        BorderPane.setAlignment(vBox1, javafx.geometry.Pos.CENTER);
        vBox1.setPrefHeight(48.0);
        vBox1.setPrefWidth(152.0);

        /**
         * Creates a label with "In use:" text with size 18 font and default font style.
         *
         */
        inUseWarehouse.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        inUseWarehouse.setStrokeWidth(0.0);
        inUseWarehouse.setText("In use:");
        inUseWarehouse.setFont(new Font(18.0));

        /**
         * Creates a label with "Vacant:" text with size 18 font and default font style.
         *
         */
        vacantWarehouse.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        vacantWarehouse.setStrokeWidth(0.0);
        vacantWarehouse.setText("Vacant:");
        vacantWarehouse.setFont(new Font(18.0));
        borderPane.setRight(vBox1);

        /**
         * Adds all the labels and buttons to their respective boxes.
         *
         */
        splitMenu.getItems().add(general);
        splitMenu.getItems().add(arms);
        splitMenu.getItems().add(silk);
        splitMenu.getItems().add(opium);
        hBox.getChildren().add(textIn);
        hBox.getChildren().add(withdraw);
        hBox.getChildren().add(deposit);
        hBox.getChildren().add(splitMenu);
        vBox.getChildren().add(playerName);
        vBox.getChildren().add(text);
        vBox.getChildren().add(opiumPlayer);
        vBox.getChildren().add(silkPlayer);
        vBox.getChildren().add(armsPlayer);
        vBox.getChildren().add(generalPlayer);
        vBox0.getChildren().add(text0);
        vBox0.getChildren().add(text1);
        vBox0.getChildren().add(opiumWarehouse);
        vBox0.getChildren().add(silkWarehouse);
        vBox0.getChildren().add(armsWarehouse);
        vBox0.getChildren().add(generalWarehouse);
        vBox1.getChildren().add(inUseWarehouse);
        vBox1.getChildren().add(vacantWarehouse);

        Scene root = new Scene(borderPane, 600, 480);

        stage.setTitle("Warehouse");
        stage.setResizable(false);
        stage.setScene(root);
        updateLabels();

        return stage;
    }

    /**
     * When run, shows the stage as a graphical interface through JavaFX.
     *
     * @param primaryStage object of type Stage
     */
    public void start(Stage primaryStage) {
        WarehouseGUI warehouseGUI = new WarehouseGUI(getPlayer());
        warehouseGUI.initializeWarehouse(primaryStage);
        primaryStage.show();
    }

    /**
     * The purpose of this class is to create a warehouse where the goods
     * can be safely stored without holing space on the ship!
     */
    public void updateLabels() {
        generalPlayer.setText("General: " + getGeneralHeld());
        armsPlayer.setText("Arms: " + getArmsHeld());
        silkPlayer.setText("Silk: " + getSilkHeld());
        opiumPlayer.setText("Opium: " + getOpiumHeld());

        generalWarehouse.setText("General: " + getwGeneral());
        armsWarehouse.setText("Arms: " + getwArms());
        silkWarehouse.setText("Silk: " + getwSilk());
        opiumWarehouse.setText("Opium: " + getwOpium());
    }
}
