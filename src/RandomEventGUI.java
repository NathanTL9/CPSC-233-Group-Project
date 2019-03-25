import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Random;

public class RandomEventGUI extends Player{

    private HBox hBox;
    private Button yesButton;
    private Button noButton;
    private VBox vBox;
    private Label paymentLabel;
    private Label sellingItemLabel;
    private Label cannotAffordLabel;
    private VBox vBox0;
    private Label shipHPLabel;
    private Label gunsShipLabel;
    private Label moneyPlayerLabel;
    private Label moneyBankLabel;
    private Label cargoShipLabel;
    private Label cargoWarehouseLabel;
    private BorderPane borderPane;
    private int eventNumber = 0;
    private int itemPrice = 10;

    /**
     * constructor; only runs when a Player object is provided. The constructor is fully encapsulated.
     *
     * @param player is a Player object that will be copied and the player instance variable is set to the copy.
     */
    public RandomEventGUI(Player player) {
        Player playerDummy = new Player(player);
        setPlayer(playerDummy);
    }

    public Stage initializeRandomEventGUI(Stage stage) {

        hBox = new HBox();
        yesButton = new Button();
        noButton = new Button();
        vBox = new VBox();
        paymentLabel = new Label();
        sellingItemLabel = new Label();
        cannotAffordLabel = new Label();
        vBox0 = new VBox();
        shipHPLabel = new Label();
        gunsShipLabel = new Label();
        moneyPlayerLabel = new Label();
        moneyBankLabel = new Label();
        cargoShipLabel = new Label();
        borderPane = new BorderPane();


        borderPane.setAlignment(hBox, javafx.geometry.Pos.CENTER);
        hBox.setAlignment(javafx.geometry.Pos.CENTER);
        hBox.setPrefHeight(100.0);
        hBox.setPrefWidth(200.0);
        hBox.setSpacing(10.0);

        yesButton.setMnemonicParsing(false);
        yesButton.setText("Yes");
        yesButton.setDefaultButton(true);

        noButton.setMnemonicParsing(false);
        noButton.setText("No");
        borderPane.setBottom(hBox);

        borderPane.setAlignment(vBox, javafx.geometry.Pos.CENTER);
        vBox.setAlignment(javafx.geometry.Pos.CENTER);
        vBox.setPrefHeight(200.0);
        vBox.setPrefWidth(100.0);

        paymentLabel.setText("Would you like to pay?");

        sellingItemLabel.setText("for a Gun?");

        cannotAffordLabel.setFocusTraversable(false);
        cannotAffordLabel.setText("You can't afford that!");
        borderPane.setCenter(vBox);

        BorderPane.setAlignment(vBox0, javafx.geometry.Pos.CENTER);
        vBox0.setAlignment(javafx.geometry.Pos.CENTER);
        vBox0.setPrefHeight(200.0);
        vBox0.setPrefWidth(100.0);

        shipHPLabel.setText("Ship Health: " + getPlayer().getHP());

        gunsShipLabel.setText("Number of Guns Remaining: " + getPlayer().getGuns());

        moneyPlayerLabel.setText("Money on Player: " + getPlayer().getMoney());

        moneyBankLabel.setText("Money in Bank: " + getPlayer().getBank());

        cargoShipLabel.setText("Ship Cargo Space: " + getPlayer().getCargoSpace());

        borderPane.setTop(vBox0);

        hBox.getChildren().add(yesButton);
        hBox.getChildren().add(noButton);
        vBox.getChildren().add(sellingItemLabel);
        vBox.getChildren().add(paymentLabel);
        vBox.getChildren().add(cannotAffordLabel);
        vBox0.getChildren().add(shipHPLabel);
        vBox0.getChildren().add(gunsShipLabel);
        vBox0.getChildren().add(moneyPlayerLabel);
        vBox0.getChildren().add(moneyBankLabel);
        vBox0.getChildren().add(cargoShipLabel);

        borderPane.setTop(vBox0);
        borderPane.setCenter(vBox);
        borderPane.setBottom(hBox);

        cannotAffordLabel.setVisible(false);

        Random rand = new Random();
        int randGenNum = rand.nextInt(3) + 1;
        //Buy Guns
        if(randGenNum == 1){
            itemPrice = (int) ((getPlayer().getMoney() * 0.1) + 10);
            sellingItemLabel.setText("Would you like to pay $" + itemPrice + " for a cannon?");
        }
        //Liu Yuen
        if(randGenNum == 2){
            itemPrice = (int) ((getPlayer().getMoney()*0.1)+10);
            sellingItemLabel.setText("Liu Yuen asks $" + itemPrice + " in donation to the temple of Tin Hau, the Sea Goddess");
        }
        //Ship Repair
        if(randGenNum == 3){
            itemPrice = (int) ((100-getPlayer().getHP())*10 + 10);
            sellingItemLabel.setText("Mc Henry from the Hong Kong shipyard has arrived, would be willing to repair your ship for $" + itemPrice);
        }

        eventNumber = randGenNum;

        if((eventNumber == 1 && getCargoSpace() < 10)){
            TaipanShopGUI taipanShopGUI = new TaipanShopGUI(getPlayer());
            taipanShopGUI.initializeShop(stage);
            stage.show();
        }
        if((eventNumber == 3 && getPlayer().getHP() == 100)){
            TaipanShopGUI taipanShopGUI = new TaipanShopGUI(getPlayer());
            taipanShopGUI.initializeShop(stage);
            stage.show();
        }



        yesButton.setOnAction(event -> {
            if(getPlayer().getMoney() > itemPrice) {
                //Buy Guns
                if (eventNumber == 1 && (getCargoSpace() >= 10)) {
                    setGuns(getPlayer().getGuns() + 1);
                    setMoney(getPlayer().getMoney() - itemPrice);

                    TaipanShopGUI taipanShopGUI = new TaipanShopGUI(getPlayer());
                    taipanShopGUI.initializeShop(stage);
                    stage.show();
                }

                //Liu Yuen
                if (eventNumber == 2) {
                    //MAKE LIU YUEN CHANCE BASICALLY 0
                    setMoney(getPlayer().getMoney() - itemPrice);

                    TaipanShopGUI taipanShopGUI = new TaipanShopGUI(getPlayer());
                    taipanShopGUI.initializeShop(stage);
                    stage.show();
                }

                //Ship Repair
                if (eventNumber == 3 && getPlayer().getHP() != 100) {
                    setHP(100);
                    setMoney(getPlayer().getMoney() - itemPrice);
                    TaipanShopGUI taipanShopGUI = new TaipanShopGUI(getPlayer());
                    taipanShopGUI.initializeShop(stage);
                    stage.show();
                }
            }
            else{
                cannotAffordLabel.setVisible(true);
                yesButton.setVisible(false);
                noButton.setDefaultButton(true);
                noButton.setVisible(true);
            }
        });


        //Goes back to shop
        noButton.setOnAction(event -> {
            TaipanShopGUI taipanShopGUI = new TaipanShopGUI(getPlayer());
            taipanShopGUI.initializeShop(stage);
            stage.show();
        });



        Scene root = new Scene(borderPane, 600, 480);
        root.getStylesheets().add("styleguide.css");

        stage.setTitle("Travel");
        stage.setResizable(false);
        stage.setScene(root);
        return stage;
    }
}