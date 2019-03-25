/**
 * TravelGUI is the class in which takes the player from location to location
 *
 * Author: Harkamal Randhawa
 */
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;

public class TravelGUI extends Player{
    private TaipanShopGUI shop;
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

    private Boolean peasantShipScene = false;
    private Boolean littyShipScene = false;
    private Boolean shopScene = false;
    private Boolean stormScene = false;
    private Boolean sceneContinue = false;

    /**
     * constructor; only runs when a Player object is provided. The constructor is fully encapsulated.
     *
     * @param player is a Player object that will be copied and the player instance variable is set to the copy.
     */
    public TravelGUI(Player player) {
        Player playerDummy = new Player(player);
        setPlayer(playerDummy);
    }

    /**
     * Sets up the graphical part of TravelGUI and includes all logic for the class
     *
     * @param stage sets the stage to which we will execute the scene of the TravelGUI class
     * @return stage so that another class can switch to the stage
     */
    public Stage initializeTravel(Stage stage) {
        //Updates the stage for the first-time you read it
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

        //Creating the continue and quit buttons
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
            TaipanShopGUI taipanShopGUI = new TaipanShopGUI(getPlayer());
            taipanShopGUI.initializeShop(stage);
            stage.show();
        });

        //Continues on to either shop or shipwarfare
        continueButton.setOnAction(event -> {
            if(peasantShipScene){
                ShipWarfareGUI ship = new ShipWarfareGUI(getPlayer());
                try {
                    ship.initializeShip(stage);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                stage.show();
            }
            else if(shopScene){
                Random rand = new Random();
                int randGenNum = rand.nextInt(3) + 1;
                if(randGenNum >= 2) {
                    TaipanShopGUI shop = new TaipanShopGUI(getPlayer());
                    shop.initializeShop(stage);
                    stage.show();
                }
                else {
                    RandomEventGUI randomEventGUI = new RandomEventGUI(getPlayer());
                    randomEventGUI.initializeRandomEventGUI(stage);
                    stage.show();
                }
            }
        });

        //Text input for where the player needs to go inside of the game world
        numberInput.setAlignment(javafx.geometry.Pos.CENTER_RIGHT);
        //numberInput.setText("Enter preferred location.");
        numberInput.setOnKeyPressed(event -> {
            if(event.getCode().equals(KeyCode.ENTER)||event.getCode().equals(KeyCode.Z)) {
                int response;
                try {
                    response = Integer.parseInt(numberInput.getText().replace(" ", ""));
                }
                catch (Exception e){
                    response = 0;
                }
                boolean hasTraveled = false;
                //Only lets the player leave the port if their inventory is greater than or equal to the sum of the items in the inventory.
                if(getCargoSpace() >= (getOpiumHeld()+ (getGuns()*10)+getSilkHeld() + getArmsHeld() + getGeneralHeld())){
                    //Just in case the player types something that was not intended. It will refresh the question and ask it again
                    try {
                        //Makes sure you can't travel to your own location.
                        if (response != getLocation() && response > 0  && 8 > response && event.getCode().equals(KeyCode.ENTER)||event.getCode().equals(KeyCode.Z)){
                            hasTraveled = seaAtlas(response);
                            randomEventSea(response,stage);
                            setBank((int) (getBank() * 1.01));
                            setDebt((int) (getDebt() * 1.01));
                            setIsPriceChanged(2);
                            //shopScene = false;
                            //stormScene = false;

                        } else{
                            if(response == getLocation()){
                                textOut.setText("    " + "You're already here " + getName() + "\n");
                            }
                            else{
                                textOut.setText("    " + getName() + "; Sorry but could you say that again?");
                            }

                            textOut.setText(textOut.getText() + "\n\n    1) Hong Kong, 2) Shanghai, 3) Nagasaki, 4) Saigon,\n    5) Manila, 6) Singapore, or 7) Batavia?");
                        }
                    } catch (Exception e) {
                        textOut.setText("    " + "Sorry, " + getName() + " could you say that again?");
                    }
                    if (hasTraveled) {
                        continueButton.setVisible(true);
                        continueButton.setDefaultButton(true);
                        quitButton.setVisible(false);
                        numberInput.setVisible(false);
                        shopScene = true;
                    }
                }
            }
            else if (getCargoSpace() < (getOpiumHeld()+ (getGuns()*10)+getSilkHeld() + getArmsHeld() + getGeneralHeld())){
                textOut.setText("   "+getName() + " the cargo is too heavy! We can't set sail!");
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
        warehouseText.setText("  Warehouse\n\tOpium\n\tSilk\n\tArms\n\tGeneral");
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
        textOut.setText("   Taipan, do you wish to go to:\n\n    1) Hong Kong, 2) Shanghai, 3) Nagasaki, 4) Saigon,\n    5) Manila, 6) Singapore, or 7) Batavia?\n    After typing the number you want to go to press 'Enter' or 'Z'");
        textOut.setFont(size14);

        //Added all the nodes into a single scene
        anchorPane.getChildren().addAll(dialogueRectangle, inventoryRectangle, warehouseRectangle);

        hBox.getChildren().addAll(warehouseText, wItemsText, wItemSpaceText, locationText);

        hBox0.getChildren().addAll(inventoryText, inventoryHeldText, gunsText, shipStatusText);

        numberInput.requestFocus();
        flowPane.getChildren().addAll(numberInput, quitButton, continueButton);

        gridPane.getColumnConstraints().add(columnConstraints);
        gridPane.getRowConstraints().addAll(rowConstraints, rowConstraints0, rowConstraints1, rowConstraints2, rowConstraints3, rowConstraints4);
        gridPane.getChildren().addAll(firm, hBox, hBox0, cashText, bankText, textOut, flowPane);

        anchorPane.getChildren().add(gridPane);

        Scene root = new Scene(anchorPane, 600, 480);
        root.getStylesheets().add("styleguide.css");

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
                if(!peasantShipScene && !stormScene) textOut.setText( textOut.getText() + "\n    " + "Arriving at Hong Kong");
                setLocation(1);
                return true;
            case 2:
                if(!peasantShipScene && !stormScene) textOut.setText( textOut.getText() + "\n    " + "Arriving at Shanghai");
                setLocation(2);
                return true;
            case 3:
                if(!peasantShipScene && !stormScene) textOut.setText( textOut.getText() + "\n    " + "Arriving at Nagasaki");
                setLocation(3);
                return true;
            case 4:
                if(!peasantShipScene && !stormScene) textOut.setText( textOut.getText() + "\n    " + "Arriving at Saigon");
                setLocation(4);
                return true;
            case 5:
                if(!peasantShipScene && !stormScene) textOut.setText( textOut.getText() + "\n    " + "Arriving at Manila");
                setLocation(5);
                return true;
            case 6:
                if(!peasantShipScene && !stormScene) textOut.setText( textOut.getText() + "\n    " + "Arriving at Singapore");
                setLocation(6);
                return true;
            case 7:
                if(!peasantShipScene && !stormScene) textOut.setText( textOut.getText() + "\n    " + "Arriving at Batavia");
                setLocation(7);
                return true;
            default:
                textOut.setText("    " + "Sorry but could you say that again " + getName() + "?");
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
            continueButton.setVisible(true);
            continueButton.setDefaultButton(true);
            quitButton.setVisible(false);
            numberInput.setVisible(false);
            textOut.setText("    We see a ship on the horizon " + getName() + "; Prepare for combat!");
            peasantShipScene = true;
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
        textOut.setText("    " + "Storm " + getName() + "! ");
        Random rand = new Random();
        int randGenNum = rand.nextInt(5) + 1;

        //If the player lands within this range, nothing happens to them
        //Else they randomly get thrown into a location they weren't planning on going to(Anything but location of Travel).
        if (randGenNum <= 2) {
            textOut.setText(textOut.getText() + "\n    " + "We got through the storm " + getName() + "!");
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

    /**
     * converts the user's location (an integer) to a String, and returns it.
     *
     * @return location -- the user's location as a string; the actual name of the location.
     */
    public String getStringLocation(){
        String location;
        switch(getLocation()){
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

    /**
     * returns the user's condition based upon their current HP.
     *
     * @return shipStatus -- a representation of their ship's health in words.
     */
    public String shipStatusString(){
        String shipStatus;
        switch(getHP()/10){
            case 10: shipStatus = "Mint Condition"; break;
            case 9: shipStatus = "Near Perfect"; break;
            case 8: shipStatus = "Great"; break;
            case 7: shipStatus = "Good"; break;
            case 6: shipStatus = "Acceptable"; break;
            case 5: shipStatus = "Tolerable"; break;
            case 4: shipStatus = "Needs Repair"; break;
            case 3: shipStatus = "Damaged"; break;
            case 2: shipStatus = "Indangered"; break;
            case 1: shipStatus = "Near Sinking"; break;
            case 0: shipStatus = "Sinking"; break;
            default: shipStatus = "Invincible"; break;
        }
        return shipStatus;
    }

    /**
     * updates the text associated with the user's inventory.
     */
    public void updateStage(){
        firm.setText(String.format("Firm: %s, %s", getName(), getStringLocation()));
        wItemsText.setText(String.format("\n %d\n %d\n %d\n %d", getwOpium(), getwSilk(), getwArms(), getwGeneral()));
        int itemsInWarehouse = getwOpium()+getwGeneral()+getwArms()+getwSilk();
        wItemSpaceText.setText(String.format("\n\t\tIn use:\n\t\t %d \n\t\tVacant:\n\t\t %d", itemsInWarehouse, (10000-itemsInWarehouse)));
        locationText.setText(String.format("Location\n%s", getStringLocation()));
        int itemsInInventory = getCargoSpace()-getSilkHeld()-getOpiumHeld()-getGeneralHeld()-getArmsHeld()-10*getGuns();
        if(itemsInInventory < 0){
            inventoryText.setText("   Overloaded\n\t  Opium\n\t  Silk\n\t  Arms\n\t  General");
        }else{
            inventoryText.setText(String.format("   Hold %d\n\t  Opium\n\t  Silk\n\t  Arms\n\t  General", itemsInInventory));
        }
        gunsText.setText(String.format("Guns %d\n\n\n\n ", getGuns()));
        inventoryHeldText.setText(String.format("\n %d\n %d\n %d\n %d", getOpiumHeld(), getSilkHeld(), getArmsHeld(), getGeneralHeld()));
        shipStatusText.setText(String.format("\tDebt\n\t%d\n\n\tShip status\n\t%s: %d", getDebt(), shipStatusString(), getHP()));
        cashText.setText(String.format("  Cash: $%,d", getMoney()));
        bankText.setText(String.format("Bank: %d", getBank()));
    }
}
