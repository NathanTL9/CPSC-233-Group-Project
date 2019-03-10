import com.sun.org.apache.xpath.internal.operations.Bool;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;

import java.util.Random;

public class TravelGUI{
    private Player player;
    private Label firm = new Label();
    private Label wItemsText = new Label();
    private Label wItemSpaceText = new Label();
    private Label locationText = new Label();
    private Label inventoryText = new Label();
    private Label inventoryHeldText = new Label();
    private Label gunsText = new Label();
    private Label shipStatusText = new Label();
    private Label cashText = new Label();
    private Label bankText = new Label();
    private Label textOut = new Label();

    private Button quitButton = new Button();
    private Button continueButton = new Button();
    private TextField numberInput = new TextField();
    private int nextScene = 0;


    public TravelGUI(Player player) {
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

    public Stage initializeTravel(Stage stage){
        updateStage();

        Font size14 = new Font(14.0);
        Rectangle dialogueRectangle = new Rectangle();
        dialogueRectangle.setFill(javafx.scene.paint.Color.WHITE);
        dialogueRectangle.setHeight(180.0);
        dialogueRectangle.setLayoutX(8.0);
        dialogueRectangle.setLayoutY(294.0);
        dialogueRectangle.setStroke(javafx.scene.paint.Color.BLACK);
        dialogueRectangle.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);
        dialogueRectangle.setWidth(582.0);

        Rectangle inventoryRectangle = new Rectangle();
        inventoryRectangle.setFill(javafx.scene.paint.Color.WHITE);
        inventoryRectangle.setHeight(108.0);
        inventoryRectangle.setLayoutX(8.0);
        inventoryRectangle.setLayoutY(147.0);
        inventoryRectangle.setStroke(javafx.scene.paint.Color.BLACK);
        inventoryRectangle.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);
        inventoryRectangle.setWidth(405.0);

        Rectangle warehouseRectangle = new Rectangle();
        warehouseRectangle.setFill(javafx.scene.paint.Color.WHITE);
        warehouseRectangle.setHeight(108.0);
        warehouseRectangle.setLayoutY(33.0);
        warehouseRectangle.setLayoutX(8.0);
        warehouseRectangle.setStroke(javafx.scene.paint.Color.BLACK);
        warehouseRectangle.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);
        warehouseRectangle.setWidth(405.0);

        AnchorPane anchorPane = new AnchorPane();
        anchorPane.setPrefHeight(480.0);
        anchorPane.setPrefWidth(600.0);

        GridPane gridPane = new GridPane();
        gridPane.setPrefHeight(480.0);
        gridPane.setPrefWidth(600.0);

        ColumnConstraints columnConstraints = new ColumnConstraints();
        columnConstraints.setMaxWidth(590.0);
        columnConstraints.setMinWidth(0.0);
        columnConstraints.setPrefWidth(590.0);

        RowConstraints rowConstraints = new RowConstraints();
        rowConstraints.setMinHeight(20.0);
        rowConstraints.setPrefHeight(20.0);

        RowConstraints rowConstraints0 = new RowConstraints();
        rowConstraints0.setMaxHeight(122.0);
        rowConstraints0.setMinHeight(10.0);
        rowConstraints0.setPrefHeight(117.0);

        RowConstraints rowConstraints1 = new RowConstraints();
        rowConstraints1.setMaxHeight(163.0);
        rowConstraints1.setMinHeight(10.0);
        rowConstraints1.setPrefHeight(112.0);

        RowConstraints rowConstraints2 = new RowConstraints();
        rowConstraints2.setMaxHeight(126.0);
        rowConstraints2.setMinHeight(0.0);
        rowConstraints2.setPrefHeight(42.0);

        RowConstraints rowConstraints3 = new RowConstraints();
        rowConstraints3.setMaxHeight(269.0);
        rowConstraints3.setMinHeight(10.0);
        rowConstraints3.setPrefHeight(118.0);

        RowConstraints rowConstraints4 = new RowConstraints();
        rowConstraints4.setMaxHeight(179.0);
        rowConstraints4.setMinHeight(10.0);
        rowConstraints4.setPrefHeight(52.0);

        gridPane.setPadding(new Insets(10.0, 10.0, 10.0, 0.0));

        HBox hBox = new HBox();
        GridPane.setRowIndex(hBox, 1);
        hBox.setPrefHeight(100.0);
        hBox.setPrefWidth(200.0);

        HBox hBox0 = new HBox();
        GridPane.setRowIndex(hBox0, 2);
        hBox0.setPrefHeight(100.0);
        hBox0.setPrefWidth(200.0);

        FlowPane flowPane = new FlowPane();
        GridPane.setRowIndex(flowPane, 5);
        flowPane.setAlignment(javafx.geometry.Pos.CENTER);
        flowPane.setHgap(5.0);
        flowPane.setPrefHeight(200.0);
        flowPane.setPrefWidth(200.0);

        quitButton.setPrefHeight(25.0);
        quitButton.setMnemonicParsing(false);
        quitButton.setPrefWidth(90.0);
        quitButton.setText("Go back");

        continueButton.setPrefHeight(25.0);
        continueButton.setMnemonicParsing(false);
        continueButton.setPrefWidth(90.0);
        continueButton.setText("Continue");
        continueButton.setVisible(false);

        //Goes back to shop
        quitButton.setOnAction(event -> {
            TaipanShopGUI taipanShopGUI = new TaipanShopGUI(player);
            taipanShopGUI.initializeShop(stage);
            stage.show();
        });

        //Continues on to either shop or shipwarefare
        continueButton.setOnKeyPressed(event -> {

        });



        //Text input for where the player needs to go.
        numberInput.setAlignment(javafx.geometry.Pos.CENTER_RIGHT);
        numberInput.setText("Enter preferred location.");
        numberInput.setOnKeyPressed(event -> {
            if(event.getCode().equals(KeyCode.ENTER)||event.getCode().equals(KeyCode.Z)) {
                int response;
                response = Integer.parseInt(numberInput.getText().replace(" ", ""));
                boolean hasTraveled = false;

                //Only lets the player leave the port if their inventory is greater than or equal to the sum of the items in the inventory.
                if(player.getCargoSpace() >= (player.getOpiumHeld()+ (player.getGuns()*10)+player.getSilkHeld() + player.getArmsHeld() + player.getGeneralHeld())){
                        //Just in case the player types something that was not intended. It will refresh the question and ask it again
                        try {
                            //Makes sure you can't travel to your own location.
                            if (response != player.getLocation() && response != 0 && event.getCode().equals(KeyCode.ENTER)||event.getCode().equals(KeyCode.Z)){
                                randomEventSea(response,stage);
                                hasTraveled = seaAtlas(response);
                                player.setBank((int) (player.getBank() * 1.01));
                                player.setDebt((int) (player.getDebt() * 1.01));
                            } else{
                                textOut.setText("    " + "You're already here " + player.getName());
                                textOut.setText(textOut.getText() + ", do you wish to go to:\n\n    1) Hong Kong, 2) Shanghai, 3) Nagasaki, 4)Saigon,\n    5) Manila, 6) Singapore, or 7) Batavia?");
                            }
                        } catch (Exception e) {
                            textOut.setText("    " + "Sorry, " + player.getName() + " could you say that again?");
                        }
                        if (hasTraveled) {
                            TaipanShopGUI taipanShopGUI = new TaipanShopGUI(player);
                            taipanShopGUI.initializeShop(stage);
                            stage.show();
                        }
                    }
                }
                else if (player.getCargoSpace() < (player.getOpiumHeld()+ (player.getGuns()*10)+player.getSilkHeld() + player.getArmsHeld() + player.getGeneralHeld())){
                    textOut.setText("   "+player.getName() + " the cargo is too heavy! We can't set sail!");
                }
        });

        firm.setAlignment(Pos.CENTER);
        firm.setPrefHeight(27.0);
        firm.setPrefWidth(632.0);
        firm.setFont(new Font(18.0));

        Label warehouseText = new Label();
        warehouseText.setAlignment(Pos.CENTER);
        warehouseText.setPrefHeight(108.0);
        warehouseText.setPrefWidth(100.0);
        warehouseText.setText("Warehouse\n\tOpium\n\tSilk\n\tArms\n\tGeneral");
        warehouseText.setFont(size14);

        wItemsText.setAlignment(Pos.CENTER);
        wItemsText.setPrefWidth(100.0);
        wItemsText.setPrefHeight(108.0);
        wItemsText.setFont(size14);

        wItemSpaceText.setPrefHeight(108.0);
        wItemSpaceText.setPrefWidth(215.0);
        wItemSpaceText.setFont(size14);

        locationText.setAlignment(Pos.BOTTOM_CENTER);
        locationText.setPrefHeight(106.0);
        locationText.setPrefWidth(175.0);
        locationText.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        locationText.setFont(size14);

        inventoryText.setAlignment(Pos.CENTER);
        inventoryText.setFont(size14);

        inventoryHeldText.setAlignment(Pos.CENTER);
        inventoryHeldText.setPrefHeight(108.0);
        inventoryHeldText.setPrefWidth(100.0);
        inventoryHeldText.setFont(size14);

        gunsText.setPrefHeight(108.0);
        gunsText.setPrefWidth(212.0);
        gunsText.setAlignment(Pos.CENTER_LEFT);
        gunsText.setFont(size14);

        shipStatusText.setAlignment(Pos.TOP_CENTER);
        shipStatusText.setContentDisplay(javafx.scene.control.ContentDisplay.CENTER);
        shipStatusText.setPrefHeight(110.0);
        shipStatusText.setPrefWidth(180.0);
        shipStatusText.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        shipStatusText.setFont(size14);

        GridPane.setRowIndex(cashText, 3);
        cashText.setPrefHeight(17.0);
        cashText.setPrefWidth(209.0);
        cashText.setFont(size14);

        GridPane.setHalignment(bankText, javafx.geometry.HPos.CENTER);
        GridPane.setRowIndex(bankText, 3);
        bankText.setAlignment(Pos.CENTER);
        bankText.setPrefHeight(20.0);
        bankText.setPrefWidth(264.0);
        bankText.setFont(size14);

        GridPane.setRowIndex(textOut, 4);
        textOut.setAlignment(Pos.TOP_LEFT);
        textOut.setContentDisplay(javafx.scene.control.ContentDisplay.TOP);
        textOut.setPrefHeight(163.0);
        textOut.setPrefWidth(583.0);
        textOut.setText("   Taipan, do you wish to go to:\n\n    1) Hong Kong, 2) Shanghai, 3) Nagasaki, 4)Saigon,\n    5) Manila, 6) Singapore, or 7) Batavia?");
        textOut.setFont(size14);

        anchorPane.getChildren().addAll(dialogueRectangle, inventoryRectangle, warehouseRectangle);

        hBox.getChildren().addAll(warehouseText, wItemsText, wItemSpaceText, locationText);

        hBox0.getChildren().addAll(inventoryText, inventoryHeldText, gunsText, shipStatusText);

        flowPane.getChildren().addAll(numberInput, quitButton, continueButton);

        gridPane.getColumnConstraints().add(columnConstraints);
        gridPane.getRowConstraints().addAll(rowConstraints, rowConstraints0, rowConstraints1, rowConstraints2, rowConstraints3, rowConstraints4);
        gridPane.getChildren().addAll(firm, hBox, hBox0, cashText, bankText, textOut, flowPane);

        anchorPane.getChildren().add(gridPane);

        Scene root = new Scene(anchorPane, 600, 480);

        stage.setTitle("Travel");
        stage.setResizable(false);
        stage.setScene(root);
        return stage;
    }

    /**
     * When provided a location number: the method returns a print statement stating the location's name and call another
     * method to change the location of the Player object.
     *
     * @param locationOfTravel is a Player object that will be copied and the player instance variable is set to the copy.
     */
    private Boolean seaAtlas(int locationOfTravel) {
        switch (locationOfTravel) {
            case 1:
                textOut.setText( textOut.getText() + "\n    " + "Arriving at Hong Kong");
                player.setLocation(1);
                return true;
            case 2:
                textOut.setText( textOut.getText() + "\n    " + "Arriving at Shanghai");
                player.setLocation(2);
                return true;
            case 3:
                textOut.setText( textOut.getText() + "\n    " + "Arriving at Nagasaki");
                player.setLocation(3);
                return true;
            case 4:
                textOut.setText( textOut.getText() + "\n    " + "Arriving at Saigon");
                player.setLocation(4);
                return true;
            case 5:
                textOut.setText( textOut.getText() + "\n    " + "Arriving at Manila");
                player.setLocation(5);
                return true;
            case 6:
                textOut.setText( textOut.getText() + "\n    " + "Arriving at Singapore");
                player.setLocation(6);
                return true;
            case 7:
                textOut.setText( textOut.getText() + "\n    " + "Arriving at Batavia");
                player.setLocation(7);
                return true;
            default:
                textOut.setText("    " + "Sorry but could you say that again " + player.getName() + "?");
                return false;
        }
    }

    /**
     * Based on random chance either attacks the player with enemy ships, throws them to a different location or does nothing.
     *
     * @param locationOfTravel is used to see where the player is going to travel, just in case their location is changed
     *                         by a typhoon.
     **/
    private void randomEventSea(int locationOfTravel, Stage stage) {
        Random rand = new Random();
        int randGenNum = rand.nextInt(3) + 1;
        if (randGenNum == 1) {
            ShipWarfareGUI ship = new ShipWarfareGUI(player);
            ship.initializeShip(stage);
            stage.show();
            System.out.println(textOut.getText() + "\n    " + "PLACEHOLDER FOR SHIPWARFARE");
        }else if (randGenNum == 2) {
            disaster(locationOfTravel);
            textOut.setText(textOut.getText() + "\n    " + "We made it!");
        }
    }

    /**
     * Based on random chance either throws the player character off course, or continues them on their way to their
     * destination.
     *
     * @param locationOfTravel is used to see where the player is going to travel, just in case their location is changed
     *                         by a typhoon.
     **/
    private void disaster(int locationOfTravel) {
        //Tells player that there is a storm approaching.
        textOut.setText(textOut.getText() + "\n    " + "Storm " + player.getName() + "! ");
        Random rand = new Random();
        int randGenNum = rand.nextInt(5) + 1;

        //If the player lands within this range, nothing happens to them
        //Else they randomly get thrown into a location they weren't planning on going to(Anything but location of Travel).
        if (randGenNum <= 2) {
            textOut.setText(textOut.getText() + "\n    " + "We made it through!");
        }else {
            while (randGenNum == locationOfTravel) {
                randGenNum = rand.nextInt(7) + 1;
                if (randGenNum != locationOfTravel) {
                    textOut.setText(textOut.getText() + "\n    " + "We've been blown off course!");
                    seaAtlas(randGenNum);
                }
            }
        }
    }

    public String getStringLocation(){
        String location;
        switch(player.getLocation()){
            case 1: location = "Hong Kong"; break;
            case 2: location = "Shanghai"; break;
            case 3: location = "Nagasaki"; break;
            case 4: location = "Saigon"; break;
            case 5: location = "Manila"; break;
            case 6: location = "Singapore"; break;
            case 7: location = "Batavia"; break;
            default: location = "Error"; break;
        }
        return location;
    }

    public String shipStatusString(){
        String shipStatus;
        switch(player.getHP()){
            case 100: shipStatus = "Mint Condition"; break;
            case 80: shipStatus = "Great"; break;
            case 70: shipStatus = "Good"; break;
            case 60: shipStatus = "Acceptable"; break;
            case 50: shipStatus = "Tolerable"; break;
            case 30: shipStatus = "Damaged"; break;
            case 10: shipStatus = "Poor"; break;
            case 1: shipStatus = "Extremely Poor"; break;
            default: shipStatus = "Sinking"; break;
        }
        return shipStatus;
    }

    public void updateStage(){
        firm.setText(String.format("Firm: %s, %s", player.getName(), getStringLocation()));
        wItemsText.setText(String.format("\n %d\n %d\n %d\n %d", player.getwOpium(), player.getwSilk(), player.getwArms(), player.getwGeneral()));
        int itemsInWarehouse = player.getwOpium()+player.getwGeneral()+player.getwArms()+player.getwSilk();
        wItemSpaceText.setText(String.format("\n\t\tIn use:\n\t\t %d \n\t\tVacant:\n\t\t %d", itemsInWarehouse, (10000-itemsInWarehouse)));
        locationText.setText(String.format("Location\n%s", getStringLocation()));
        int itemsInInventory = player.getCargoSpace()-player.getSilkHeld()-player.getOpiumHeld()-player.getGeneralHeld()-player.getArmsHeld()-10*player.getGuns();
        if(itemsInInventory < 0){
            inventoryText.setText("   Overloaded\n\t  Opium\n\t  Silk\n\t  Arms\n\t  General");
        }else{
            inventoryText.setText(String.format("   Hold %d\n\t  Opium\n\t  Silk\n\t  Arms\n\t  General", itemsInInventory));
        }
        gunsText.setText(String.format("Guns %d\n\n\n\n ", player.getGuns()));
        inventoryHeldText.setText(String.format("\n %d\n %d\n %d\n %d", player.getOpiumHeld(), player.getSilkHeld(), player.getArmsHeld(), player.getGeneralHeld()));
        shipStatusText.setText(String.format("\tDebt\n\t%d\n\n\tShip status\n\t%s: %d", player.getDebt(), shipStatusString(), player.getHP()));
        cashText.setText(String.format("  Cash: %d", player.getMoney()));
        bankText.setText(String.format("Bank: %d", player.getBank()));
    }

    public void start(Stage primaryStage) {
        primaryStage = initializeTravel(primaryStage);
        updateStage();
        primaryStage.show();
    }
}
