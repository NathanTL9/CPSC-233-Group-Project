
import javafx.application.Application;
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

public class WarehouseGUI {

    private Player player;

    private Text title;
    private HBox hBox;
    private Button withdraw;
    private Button deposit;
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

    public WarehouseGUI(Player player) {
        Player playerDummy = new Player(player);
        this.player = playerDummy;
    }

    public void setPlayer(Player player) {
        Player playerDummy = new Player(player);
        this.player = playerDummy;
    }

    public Player getPlayer(){
        Player playerDummy = new Player(player);
        return playerDummy;
    }

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

        borderPane.setPrefHeight(480.0);
        borderPane.setPrefWidth(600.0);

        borderPane.setAlignment(title, javafx.geometry.Pos.CENTER);
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

        BorderPane.setAlignment(hBox, javafx.geometry.Pos.CENTER);
        hBox.setAlignment(javafx.geometry.Pos.CENTER);
        hBox.setPrefHeight(100.0);
        hBox.setPrefWidth(200.0);

        withdraw.setContentDisplay(javafx.scene.control.ContentDisplay.CENTER);
        withdraw.setMnemonicParsing(false);
        withdraw.setText("Withdraw");

        // Set the event handler when the deposit button is clicked
        withdraw.setOnAction(new EventHandler<ActionEvent>() {
               @Override
               public void handle(ActionEvent event) {
                   int withdraw = Integer.parseInt(textIn.getText());
                   if(opium.isSelected()){
                       if (player.getwOpium() >= withdraw) {
                           player.setwOpium(player.getwOpium() - withdraw);
                           player.setOpiumHeld(player.getOpiumHeld() + withdraw);
                       } else {
                           title.setText("You don't have that much opium stored in the warehouse!");
                       }
                   }
               }
           }
        );

        deposit.setMnemonicParsing(false);
        deposit.setText("Deposit");
        deposit.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);

        // Set the event handler when the deposit button is clicked
        deposit.setOnAction(new EventHandler<ActionEvent>() {
                 @Override
                 public void handle(ActionEvent event) {
                     int deposit = Integer.parseInt(textIn.getText());
                 }
             }
        );


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

        borderPane.setAlignment(hBox, javafx.geometry.Pos.CENTER);
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

        borderPane.setAlignment(vBox, javafx.geometry.Pos.CENTER_LEFT);
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

        borderPane.setAlignment(vBox0, javafx.geometry.Pos.TOP_LEFT);
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

        borderPane.setAlignment(vBox1, javafx.geometry.Pos.CENTER);
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
        return stage;
    }

    public void start(Stage primaryStage) {
        WarehouseGUI warehouseGUI = new WarehouseGUI(player);
        warehouseGUI.initializeWarehouse(primaryStage);
        primaryStage.show();
    }
}
