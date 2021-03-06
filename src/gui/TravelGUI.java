package gui;

/**
 * TravelGUI is the class in which takes the player from location to location
 * Author: Harkamal Randhawa
 */
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
import logic.Player;
import logic.TravelLogic;

import java.util.Random;

public class TravelGUI extends Player {
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
    private FlowPane flowPane = new FlowPane();

    private Button quitButton = new Button();
    private Button continueButton = new Button();
    private TextField numberInput = new TextField();

    private Boolean peasantShipScene = false;
    private Boolean shopScene = false;
    private Boolean stormScene = false;

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
    public void initializeTravel(Stage stage) {


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
            continueButton(stage);
        });

        //Text input for where the player needs to go inside of the game world
        numberInput.setAlignment(javafx.geometry.Pos.CENTER_RIGHT);
        //numberInput.setText("Enter preferred location.");
        numberInput.setOnKeyPressed(event -> {
            numberInput(event);
        });

        firm.setAlignment(Pos.CENTER);
        firm.setPrefHeight(27.0);
        firm.setPrefWidth(632.0);
        firm.setFont(new Font(18.0));
        flowPane.getChildren().addAll(numberInput, quitButton, continueButton);
        TaipanShopGUI shop = new TaipanShopGUI(super.getPlayer());
        Scene root = new Scene(shop.declareStage(flowPane,firm,wItemsText,wItemSpaceText,locationText,gunsText,inventoryText,inventoryHeldText,shipStatusText,cashText,bankText,textOut), 600, 480);
        root.getStylesheets().add("styleguide.css");
        //Updates the stage for the first-time you read it
        shop.updateStage(firm,wItemsText,wItemSpaceText,locationText,gunsText,inventoryText,inventoryHeldText,shipStatusText,cashText,bankText);
        textOut.setText("\tTaipan, do you wish to go to:\n\n\t\t1) Hong Kong, 2) Shanghai, 3) Nagasaki, 4) Saigon,\n\t\t5) Manila, 6) Singapore, or 7) Batavia?\n\n\tAfter typing the number you want to go to press 'Enter' or 'Z'");
        stage.setTitle("Travel");
        stage.setResizable(false);
        stage.setScene(root);
    }

    /**
     * Runs if the continue button is pressed. Used to leave the Travel Screen
     * @param stage the stage in which the JavaFX class is brought into
     */
    public void continueButton(Stage stage) {
        //If there are ships attacking, move to the ShipWarfare method
        if(peasantShipScene && getAttackingShips()){
            ShipWarfareGUI ship = new ShipWarfareGUI(getPlayer());
            try {
                ship.initializeShip(stage);
            } catch (Exception e) {
                e.printStackTrace();
            }
            stage.show();
        }
        //If nothing is happening either create a random event or force the player into the shop
        else if(shopScene){
            Random rand = new Random();
            int randGenNum = rand.nextInt(3) + 1;
            //Forces the player into the shop
            if(randGenNum >= 2) {
                TaipanShopGUI shop = new TaipanShopGUI(getPlayer());
                shop.initializeShop(stage);
                stage.show();
            }
            //Creates a random event for the player
            else {
                RandomEventGUI randomEventGUI = new RandomEventGUI(getPlayer());
                randomEventGUI.initializeRandomEventGUI(stage);
                stage.show();
            }
        }
    }

    /**
     * Runs if the numberInput is given and input and the Player has pressed Enter or Z
     * @param event the input which will be processed and given a proper response afterwars
     */
    public void numberInput(KeyEvent event) {
        //Run the player has pressed Enter or Z
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
                traveling(event, response, hasTraveled);
            }
        }
        //Run if the player cargo is too much
        else if (getCargoSpace() < (getOpiumHeld()+ (getGuns()*10)+getSilkHeld() + getArmsHeld() + getGeneralHeld())){
            textOut.setText("   "+getName() + " the cargo is too heavy! We can't set sail!");
        }
    }

    /**
     * Runs if the numberInput is given and input and the Player has pressed Enter or Z
     * @param event the input which will be processed and given a proper response afterwards
     */
    public void traveling(KeyEvent event, int response, boolean hasTraveled) {
        //Just in case the player types something that was not intended. It will refresh the question and ask it again
        try {
            //Makes sure you can't travel to your own location.
            if (response != getLocation() && response > 0  && 8 > response && event.getCode().equals(KeyCode.ENTER)||event.getCode().equals(KeyCode.Z)){
                hasTraveled = seaAtlas(response);
                randomEventSea(response);
                setBank((int) (getBank() * 1.01));
                setDebt((int) (getDebt() * 1.01));
                setIsPriceChanged(2);
                stormScene = false;

            } else{
                responseTravel(response);
            }
        } catch (Exception e) {
            textOut.setText("\tSorry, " + getName() + " could you say that again?");
        }
        if (hasTraveled) {
            continueButton.setVisible(true);
            continueButton.setDefaultButton(true);
            quitButton.setVisible(false);
            numberInput.setVisible(false);
            shopScene = true;
        }
    }

    /**
     * Takes the User's response to the location they want to travel to and returns a output
     * @param response Based on the number either asks for the player's input again or stops.
     */
    public void responseTravel(int response) {
        if(response == getLocation()){
            textOut.setText("\tYou're already here " + getName() + "\n");
        }
        else{
            textOut.setText("\t" + getName() + "; Sorry but could you say that again?");
        }
        textOut.setText(textOut.getText() + "\n\n\t\t1) Hong Kong, 2) Shanghai, 3) Nagasaki, 4) Saigon,\n\t\t5) Manila, 6) Singapore, or 7) Batavia?");
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
                if(!peasantShipScene && !stormScene) textOut.setText( textOut.getText() + "\n\tArriving at Hong Kong");
                setLocation(1);
                return true;
            case 2:
                if(!peasantShipScene && !stormScene) textOut.setText( textOut.getText() + "\n\tArriving at Shanghai");
                setLocation(2);
                return true;
            case 3:
                if(!peasantShipScene && !stormScene) textOut.setText( textOut.getText() + "\n\tArriving at Nagasaki");
                setLocation(3);
                return true;
            case 4:
                if(!peasantShipScene && !stormScene) textOut.setText( textOut.getText() + "\n\tArriving at Saigon");
                setLocation(4);
                return true;
            case 5:
                if(!peasantShipScene && !stormScene) textOut.setText( textOut.getText() + "\n\tArriving at Manila");
                setLocation(5);
                return true;
            case 6:
                if(!peasantShipScene && !stormScene) textOut.setText( textOut.getText() + "\n\tArriving at Singapore");
                setLocation(6);
                return true;
            case 7:
                if(!peasantShipScene && !stormScene) textOut.setText( textOut.getText() + "\n\tArriving at Batavia");
                setLocation(7);
                return true;
            default:
                textOut.setText("\tSorry but could you say that again " + getName() + "?");
                return false;
        }
    }

    /**
     * Based on random chance either attacks the player with enemy ships, throws them to a different location or does nothing.
     *
     * @param locationOfTravel is used to see where the player is going to travel, just in case their location is changed
     *                         by a typhoon.
     **/
    private void randomEventSea(int locationOfTravel) {
        Random rand = new Random();
        int randGenNum = rand.nextInt(3) + 1;
        if (randGenNum == 1) {
            continueButton.setVisible(true);
            continueButton.setDefaultButton(true);
            quitButton.setVisible(false);
            numberInput.setVisible(false);
            textOut.setText("\tWe see a ship on the horizon " + getName() + "; Prepare for combat!");
            peasantShipScene = true;
        }else if (randGenNum == 2) {
            textOut.setText("\tStorm " + getName() + "! ");
            TravelLogic travelLogic = new TravelLogic(getPlayer());
            textOut.setText(textOut.getText()+"\n\t" + travelLogic.disaster(locationOfTravel));
            setPlayer(travelLogic.getPlayer());
            textOut.setText(textOut.getText() + "\n    " + "We made it!");

        }
    }

}
