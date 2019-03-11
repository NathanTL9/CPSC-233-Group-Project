
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class StartGUI {

    private Player player;
    private BorderPane borderPane = new BorderPane();
    private HBox hBox = new HBox();
    private TextField nameField = new TextField();
    private Button startButton = new Button();
    private VBox vBox = new VBox();
    private Label choiceLabel = new Label();
    private RadioButton gunChoice = new RadioButton();
    private ToggleGroup Start = new ToggleGroup();
    private RadioButton cashChoice = new RadioButton();
    private VBox vBox0 = new VBox();
    private Label title = new Label();
    private Label authors = new Label();

    /**
     * gets the player instance variable. The method returns a copy of the instance variable for encapsulation purposes.
     *
     * @return playerDummy -- playerDummy is a copy of the player instance variable.
     */
    public Player getPlayer() {
        Player playerTemp = new Player(player);
        return playerTemp;
    }

    /**
     * sets the player instance variable equal to a copy of the parameter -- a copy is used for encapsulation purposes.
     *
     * @param player is a Player object that will replace the current instance of the player instance variable.
     */
    public void setPlayer(Player player) {
        Player playerTemp = new Player(player);
        this.player = playerTemp;
    }

    /**
     * Asks the user to input the name that they would like to be called in the game
     *
     * @param name the name that you would like to be called in the game
     */
    public void setFirm (String name) {
        if (name.length() <= 22) {
            player.setName(name);
        }
        else{
            player.setName("Taipan");
        }
    }


    /*
    **
     * Copy constructor.
     * @param player object of the class Player
     */
    public StartGUI(Player player)
    {
        Player playerTemp = new Player(player);
        this.player = playerTemp;
    }

    public Stage initializeStart(Stage stage){

        borderPane.setAlignment(hBox, javafx.geometry.Pos.CENTER);
        hBox.setAlignment(javafx.geometry.Pos.CENTER);
        hBox.setPrefHeight(100.0);
        hBox.setPrefWidth(200.0);
        hBox.setSpacing(10.0);

        nameField.setPromptText("Enter your name.");
        nameField.setText("Taipan");

        startButton.setMnemonicParsing(false);
        startButton.setText("Start");

        vBox.setAlignment(javafx.geometry.Pos.CENTER_LEFT);

        choiceLabel.setText("Do you want to start with...");

        gunChoice.setMnemonicParsing(false);
        gunChoice.setSelected(true);
        gunChoice.setText("Five guns and no cash (But no debt!)?");

        gunChoice.setToggleGroup(Start);

        cashChoice.setAlignment(javafx.geometry.Pos.TOP_LEFT);
        cashChoice.setMnemonicParsing(false);
        cashChoice.setText("Cash (and a debt)");
        cashChoice.setToggleGroup(Start);
        borderPane.setBottom(hBox);

        BorderPane.setAlignment(vBox0, javafx.geometry.Pos.CENTER);
        vBox0.setAlignment(javafx.geometry.Pos.CENTER);
        vBox0.setPrefHeight(200.0);
        vBox0.setPrefWidth(100.0);

        title.setText("Taipan");
        title.setFont(new Font(66.0));

        authors.setPrefHeight(80.0);
        authors.setPrefWidth(499.0);
        authors.setText("By Vikram Bawa, Haris Muhammad, Siddhant Dewani, Nathan Lum and Harkamal Randhawa");

        authors.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        borderPane.setCenter(vBox0);

        hBox.getChildren().add(nameField);
        hBox.getChildren().add(startButton);
        vBox.getChildren().add(choiceLabel);
        vBox.getChildren().add(gunChoice);
        vBox.getChildren().add(cashChoice);
        hBox.getChildren().add(vBox);
        vBox0.getChildren().add(title);
        vBox0.getChildren().add(authors);

        startButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (Start.getSelectedToggle() == cashChoice) {
                    player.setMoney(400);
                    player.setDebt(5000);

                }
                if (Start.getSelectedToggle() == gunChoice) {
                    player.setGuns(5);
                }

                String response = nameField.getText();
                // purely for testing purposes.
                if (player.getName().equalsIgnoreCase("Vikram")) {
                    player.setMoney(999999999);
                    player.setBank(999999999);
                    player.setGuns(999);
                    player.setHP(99999999);
                    player.setCargoSpace(99999999);
                }
                else{
                    setFirm(response);
                }

                TaipanShopGUI shop = new TaipanShopGUI(player);
                shop.initializeShop(stage);
                stage.show();
                //title.setText("SHOP PLACEHOLDER");
            }
        });

        Scene root = new Scene(borderPane, 600, 480);

        stage.setTitle("Start");
        stage.setResizable(false);
        stage.setScene(root);
        return stage;
    }
}
