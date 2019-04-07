package gui; /**
 * TaipanShopGUI deals with setting the stage for shop.
 *
 * Author: Vikram Bawa
 */
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeType;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import logic.FileSaving;
import logic.Player;
import logic.TaipanShopLogic;

public class TaipanShopGUI extends Player {
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
    private Button retireButton = new Button();
    private Button bankButton = new Button();
    private Button sellButton = new Button();
    private Button buyButton = new Button();
    private Button loanButton = new Button();
    private Button cargoButton = new Button();
    private Button opiumButton = new Button();
    private Button silkButton = new Button();
    private Button armsButton = new Button();
    private Button generalButton = new Button();
    private TextField numberInput = new TextField();


    /**
     * constructor; only runs when a Player object is provided. The constructor is fully encapsulated.
     *
     * @param player is a Player object that will be copied and the player instance variable is set to the copy.
     */
    public TaipanShopGUI(logic.Player player) {
        Player playerDummy = new Player(player);
        setPlayer(playerDummy);
    }

    /**
     * This method is evoked if the user is eligible to win, and chooses to end the game (by winning).
     */
    public void retire(Stage stage) {
        setRetire(true);
        GameEndGUI gameEndGUI = new GameEndGUI(getPlayer());
        gameEndGUI.initializeGameEndGUI(stage);
        stage.show();
    }

    /**
     * Sets the default dialogue of simply stating the prices of the items.
     */
    public void defaultTextOut() {
        textOut.setText(String.format("\t%s, present prices per unit here are:\n\n\t\tOpium: %d\t\t\tSilk: %d\n\t\tArms: %d\t\t\tGeneral: %d", getName(), getOpiumPrice(), getSilkPrice(), getArmsPrice(), getGeneralPrice()));

    }

    /**
     * Sets up buttons according to which "state" is inputted. When used in "shop", only the item buttons are visible.
     * When used in "reset", all the item buttons are invisible; if the user is at location one and is eligible to win,
     * then all utilities and the retire button are visible. If the user is not at location one, then the user can only
     * buy, sell, or exit. If the user is at location one and is not eligible to win, then all utilities are visible but
     * the retire button is not. When used in "input" everything near the bottom is invisible except for the text area.
     *
     * @param state -- the state determines which buttons are visible and which are not.
     */
    public void buttonSetup(String state) {
        if (state.equals("shop")) {
            buyButton.setVisible(false);
            sellButton.setVisible(false);
            bankButton.setVisible(false);
            numberInput.setVisible(false);
            cargoButton.setVisible(false);
            loanButton.setVisible(false);
            armsButton.setVisible(true);
            quitButton.setVisible(false);
            opiumButton.setVisible(true);
            silkButton.setVisible(true);
            generalButton.setVisible(true);
            retireButton.setVisible(false);
        } else if (state.equals("reset")) {
            buyButton.setText("Buy");
            sellButton.setText("Sell");
            opiumButton.setText("Opium");
            silkButton.setText("Silk");
            armsButton.setText("Arms");
            generalButton.setText("General");
            if (getLocation() != 1) {
                buyButton.setVisible(true);
                sellButton.setVisible(true);
                bankButton.setVisible(false);
                cargoButton.setVisible(false);
                loanButton.setVisible(false);
                armsButton.setVisible(false);
                quitButton.setVisible(true);
                //quitButton.setDefaultButton(true);
                opiumButton.setVisible(false);
                silkButton.setVisible(false);
                numberInput.setVisible(false);
                generalButton.setVisible(false);
                retireButton.setVisible(false);
            }
            if (getBank() + getMoney() - getDebt() < 1000000 && getLocation() == 1) {
                buyButton.setVisible(true);
                sellButton.setVisible(true);
                bankButton.setVisible(true);
                cargoButton.setVisible(true);
                loanButton.setVisible(true);
                quitButton.setVisible(true);
                //quitButton.setDefaultButton(true);
                opiumButton.setVisible(false);
                silkButton.setVisible(false);
                numberInput.setVisible(false);
                generalButton.setVisible(false);
                armsButton.setVisible(false);
                retireButton.setVisible(false);
            } else if (getLocation() == 1) {
                buyButton.setVisible(true);
                sellButton.setVisible(true);
                bankButton.setVisible(true);
                cargoButton.setVisible(true);
                loanButton.setVisible(true);
                numberInput.setVisible(false);
                quitButton.setVisible(true);
                //quitButton.setDefaultButton(true);
                opiumButton.setVisible(false);
                silkButton.setVisible(false);
                generalButton.setVisible(false);
                armsButton.setVisible(false);
                retireButton.setVisible(true);
            }
        } else if (state.equals("input")) {
            buyButton.setVisible(false);
            sellButton.setVisible(false);
            generalButton.setVisible(false);
            bankButton.setVisible(false);
            loanButton.setVisible(false);
            quitButton.setVisible(false);
            opiumButton.setVisible(false);
            cargoButton.setVisible(false);
            silkButton.setVisible(false);
            armsButton.setVisible(false);
            retireButton.setVisible(false);
            numberInput.setVisible(true);
        }
    }

    /**
     * this method is responsible for the actual purchasing/selling of items, and the text associated with the act.
     */
    public void shop() {
        String originalDialogue = textOut.getText();
        int num = Integer.parseInt(numberInput.getText().replace(" ", ""));
        if (buyButton.getText().contains(".")) {
            if (opiumButton.getText().contains(".") && num <= getMoney() / getOpiumPrice() && num >= 0) {
                setMoney(getMoney() - num * getOpiumPrice());
                setOpiumHeld(getOpiumHeld() + num);
            } else if (num >= 0 && opiumButton.getText().contains(".")) {
                textOut.setText(originalDialogue + "\n\t" + getName() + ", you can't afford that!");
            } else if (opiumButton.getText().contains(".")) {
                textOut.setText(originalDialogue + "\n\t" + getName() + ", how am I supposed to buy " + "'" + num + "'" + " Opium?");
            } else if (silkButton.getText().contains(".") && num <= getMoney() / getSilkPrice() && num >= 0) {
                setSilkHeld(getSilkHeld() + num);
                setMoney(getMoney() - num * getSilkPrice());
            } else if (num >= 0 && silkButton.getText().contains(".")) {
                textOut.setText(originalDialogue + "\n\t" + getName() + ", you can't afford that!");
            } else if (silkButton.getText().contains(".")) {
                textOut.setText(originalDialogue + "\n\t" + getName() + ", how am I supposed to buy " + "'" + num + "'" + " Silk?");
            } else if (armsButton.getText().contains(".") && num <= getMoney() / getArmsPrice() && num >= 0) {
                setArmsHeld(getArmsHeld() + num);
                setMoney(getMoney() - num * getArmsPrice());
            } else if (num >= 0 && armsButton.getText().contains(".")) {
                textOut.setText(originalDialogue + "\n\t" + getName() + ", you can't afford that!");
            } else if (armsButton.getText().contains(".")) {
                textOut.setText(originalDialogue + "\n\t" + getName() + ", how am I supposed to buy " + "'" + num + "'" + " Arms?");
            } else if (generalButton.getText().contains(".") && num <= getMoney() / getGeneralPrice() && num >= 0) {
                setGeneralHeld(getGeneralHeld()+num);
                setMoney(getMoney() - num * getGeneralPrice());
            } else if (num >= 0 && generalButton.getText().contains(".")) {
                textOut.setText(originalDialogue + "\n\t" + getName() + ", you can't afford that!");
            } else if (generalButton.getText().contains(".")) {
                textOut.setText(originalDialogue + "\n\t" + getName() + ", how am I supposed to buy " + "'" + num + "'" + " General Cargo?");
            }
        } else if (sellButton.getText().contains(".")) {
            if (opiumButton.getText().contains(".") && num <= getOpiumHeld() && num >= 0) {
                setOpiumHeld(getOpiumHeld() - num);
                setMoney(getMoney() + num * getOpiumPrice());
            } else if (num >= 0 && opiumButton.getText().contains(".")) {
                textOut.setText(originalDialogue + "\n\t" + getName() + ", you don't have that many to sell!");
            } else if (opiumButton.getText().contains(".")) {
                textOut.setText(originalDialogue + "\n\t" + getName() + ", how am I supposed to sell " + "'" + num + "'" + " Opium?");
            } else if (silkButton.getText().contains(".") && num <= getSilkHeld() && num >= 0) {
                setSilkHeld(getSilkHeld() - num);
                setMoney(getMoney() + num * getSilkPrice());
            } else if (num >= 0 && silkButton.getText().contains(".")) {
                textOut.setText(originalDialogue + "\n\t" + getName() + ", you don't have that many to sell!");
            } else if (silkButton.getText().contains(".")) {
                textOut.setText(originalDialogue + "\n\t" + getName() + ", how am I supposed to sell " + "'" + num + "'" + " Silk?");
            } else if (armsButton.getText().contains(".") && num <= getArmsHeld() && num >= 0) {
                setArmsHeld(getArmsHeld() - num);
                setMoney(getMoney() + num * getArmsPrice());
            } else if (num >= 0 && armsButton.getText().contains(".")) {
                textOut.setText(originalDialogue + "\n\t" + getName() + ", you don't have that many to sell!");
            } else if (armsButton.getText().contains(".")) {
                textOut.setText(originalDialogue + "\n\t" + getName() + ", how am I supposed to sell " + "'" + num + "'" + " Arms?");
            } else if (generalButton.getText().contains(".") && num <= getGeneralHeld() && num >= 0) {
                setGeneralHeld(getGeneralHeld() - num);
                setMoney(getMoney() + num * getGeneralPrice());
            } else if (num >= 0 && generalButton.getText().contains(".")) {
                textOut.setText(originalDialogue + "\n\t" + getName() + ", you don't have that many to sell!");
            } else {
                textOut.setText(originalDialogue + "\n\t" + getName() + ", how am I supposed to sell " + "'" + num + "'" + " General Cargo?");
            }
        }
    }

    /**
     * Initializes the shop on the given stage as a parameter.
     *
     * @param stage
     */
    public void initializeShop(Stage stage) {
        FileSaving saving = new FileSaving();
        saving.saveFile(getPlayer());
        FlowPane flowPane = new FlowPane();

        buyButton.setMnemonicParsing(false);
        buyButton.setPrefHeight(25.0);
        buyButton.setPrefWidth(45.0);
        buyButton.setText("Buy");
        buyButton.setOnAction(new EventHandler<ActionEvent>() {

            /**
             * if the buy button is clicked, the main utility buttons are set to be invisible and the buying process begins.
             *
             * @param event -- the event corresponding to the button click
             */
            @Override
            public void handle(ActionEvent event) {
                buttonSetup("shop");
                buyButton.setText("Buy.");
                defaultTextOut();
                textOut.setText(textOut.getText() + "\n\tWhich good would you like to purchase?");
            }
        });

        sellButton.setPrefHeight(25.0);
        sellButton.setText("Sell");
        // if the sell button is clicked, the main utility buttons are set to be invisible and the selling process begins.
        sellButton.setOnAction(new EventHandler<ActionEvent>() {

            /**
             * if the sell button is clicked, the main utility buttons are set to be invisible and the selling process begins.
             *
             * @param event -- the event corresponding to the button click
             */
            @Override
            public void handle(ActionEvent event) {
                buttonSetup("shop");
                sellButton.setText("Sell.");
                defaultTextOut();
                textOut.setText(textOut.getText() + "\n\tWhich good would you like to sell?");
            }
        });
        sellButton.setPrefWidth(45.0);
        sellButton.setMnemonicParsing(false);

        bankButton.setPrefHeight(25.0);
        bankButton.setOnAction(new EventHandler<ActionEvent>() {

            /**
             * opens the bank if the bank button is clicked.
             *
             * @param event -- the event corresponding to the button click
             */
            @Override
            public void handle(ActionEvent event) {
                BankGUI bank = new BankGUI(getPlayer());
                bank.initializeBank(stage);
                stage.show();
            }
        });
        bankButton.setMnemonicParsing(false);
        bankButton.setPrefWidth(74.0);
        bankButton.setText("Bank");

        cargoButton.setPrefHeight(25.0);
        cargoButton.setText("Transfer");
        cargoButton.setMnemonicParsing(false);
        cargoButton.setPrefWidth(94.0);
        cargoButton.setOnAction(new EventHandler<ActionEvent>() {

            /**
             * warehouse is entered when the warehouse button is clicked.
             *
             * @param event -- the event corresponding to the button click
             */
            @Override
            public void handle(ActionEvent event) {
                WarehouseGUI warehouseGUI = new WarehouseGUI(getPlayer());
                warehouseGUI.initializeWarehouse(stage);
                stage.show();
            }
        });


        loanButton.setMnemonicParsing(false);
        loanButton.setPrefHeight(25.0);
        loanButton.setPrefWidth(73.0);
        loanButton.setOnAction(new EventHandler<ActionEvent>() {

            /**
             * loan office is entered when the loan button is clicked.
             *
             * @param event -- the event corresponding to the button click
             */
            @Override
            public void handle(ActionEvent event) {
                LoanSharkGUI loan = new LoanSharkGUI(getPlayer());
                loan.initializeLoanShark(stage);
                stage.show();
            }
        });
        loanButton.setText("Loans");

        quitButton.setPrefHeight(25.0);
        quitButton.setMnemonicParsing(false);
        quitButton.setPrefWidth(90.0);
        quitButton.setText("Quit");
        quitButton.setOnAction(new EventHandler<ActionEvent>() {

            /**
             * the user is free to travel once the quit button is clicked.
             *
             * @param event -- the event corresponding to the button click
             */
            @Override
            public void handle(ActionEvent event) {
                setIsPriceChanged(1);
                TravelGUI travelGUI = new TravelGUI(getPlayer());
                travelGUI.initializeTravel(stage);
                stage.show();
            }
        });

        retireButton.setPrefHeight(25.0);
        retireButton.setPrefWidth(49.0);
        retireButton.setText("Retire");
        retireButton.setVisible(false);
        retireButton.setOnAction(new EventHandler<ActionEvent>() {

            /**
             * the user wins the game when the retire button is clicked.
             *
             * @param event -- the event corresponding to the button click
             */
            @Override
            public void handle(ActionEvent event) {
                retire(stage);
            }
        });
        retireButton.setMnemonicParsing(false);

        opiumButton.setMnemonicParsing(false);
        opiumButton.setPrefWidth(86.0);
        opiumButton.setPrefHeight(25.0);
        opiumButton.setText("Opium");
        opiumButton.setVisible(false);
        opiumButton.setOnAction(new EventHandler<ActionEvent>() {

            /**
             * the opium buying/selling process starts as soon as the user clicks the opium button.
             *
             * @param event -- the event corresponding to the button click
             */
            @Override
            public void handle(ActionEvent event) {
                buttonSetup("input");
                opiumButton.setText("Opium.");
                defaultTextOut();
                String extraText;
                if (buyButton.getText().contains(".")) {
                    extraText = String.format(" (You can afford %d)", getMoney() / getOpiumPrice());
                } else {
                    extraText = String.format(" (You have %d)", getOpiumHeld());
                }
                textOut.setText(textOut.getText() + "\n\tWhat quantity of Opium?" + extraText);
            }
        });

        silkButton.setPrefHeight(25.0);
        silkButton.setPrefWidth(86.0);
        silkButton.setMnemonicParsing(false);
        silkButton.setText("Silk");
        silkButton.setVisible(false);
        silkButton.setOnAction(new EventHandler<ActionEvent>() {

            /**
             * the silk buying/selling process starts as soon as the user clicks the silk button.
             *
             * @param event -- the event corresponding to the button click
             */
            @Override
            public void handle(ActionEvent event) {
                buttonSetup("input");
                silkButton.setText("Silk.");
                defaultTextOut();
                String extraText;
                if (buyButton.getText().contains(".")) {
                    extraText = String.format(" (You can afford %d)", getMoney() / getSilkPrice());
                } else {
                    extraText = String.format(" (You have %d)", getSilkHeld());
                }
                textOut.setText(textOut.getText() + "\n\tWhat quantity of Silk?" + extraText);
            }
        });

        armsButton.setPrefWidth(86.0);
        armsButton.setMnemonicParsing(false);
        armsButton.setVisible(false);
        armsButton.setOnAction(new EventHandler<ActionEvent>() {

            /**
             * the arms buying/selling process starts as soon as the user clicks the arms button.
             *
             * @param event -- the event corresponding to the button click
             */
            @Override
            public void handle(ActionEvent event) {
                buttonSetup("input");
                armsButton.setText("Arms.");
                defaultTextOut();
                String extraText;
                if (buyButton.getText().contains(".")) {
                    extraText = String.format(" (You can afford %d)", getMoney() / getArmsPrice());
                } else {
                    extraText = String.format(" (You have %d)", getArmsHeld());
                }
                textOut.setText(textOut.getText() + "\n\tWhat quantity of Arms?" + extraText);
            }
        });
        armsButton.setText("Arms");
        armsButton.setPrefHeight(25.0);

        generalButton.setMnemonicParsing(false);
        generalButton.setPrefHeight(25.0);
        generalButton.setPrefWidth(86.0);
        generalButton.setText("General");
        generalButton.setVisible(false);
        generalButton.setOnAction(new EventHandler<ActionEvent>() {

            /**
             * the general cargo buying/selling process starts as soon as the user clicks the general cargo button.
             *
             * @param event -- the event corresponding to the button click
             */
            @Override
            public void handle(ActionEvent event) {
                buttonSetup("input");
                generalButton.setText("General.");
                defaultTextOut();
                String extraText;
                if (buyButton.getText().contains(".")) {
                    extraText = String.format(" (You can afford %d)", getMoney() / getGeneralPrice());
                } else {
                    extraText = String.format(" (You have %d)", getGeneralHeld());
                }
                textOut.setText(textOut.getText() + "\n\tWhat quantity of General Cargo?" + extraText);
            }
        });

        numberInput.setAlignment(javafx.geometry.Pos.CENTER_RIGHT);
        numberInput.setText("Enter amount here...");
        numberInput.setVisible(false);
        numberInput.setOnKeyPressed(new EventHandler<KeyEvent>() {

            /**
             * after the user inputs a valid input into the text field and presses Z or ENTER, the buying/selling ends
             * and the user is returned to the regular shop dialogue.
             *
             * @param event -- the event corresponding to the button click
             */
            @Override
            public void handle(KeyEvent event) {
                boolean exit = true;
                defaultTextOut();
                if (event.getCode().equals(KeyCode.ENTER) || event.getCode().equals(KeyCode.Z)) {
                    while (true) {
                        if (!textOut.getText().contains("You entered an invalid input!") && !exit) {
                            textOut.setText(textOut.getText() + "\n\n\tYou entered an invalid input! Please try again.");
                            break;
                        }
                        try {
                            shop();
                        } catch (Exception e) {
                            exit = false;
                        }
                        if (exit) {
                            break;
                        }
                    }
                    updateStage(firm,wItemsText,wItemSpaceText,locationText,gunsText,inventoryText,inventoryHeldText,shipStatusText,cashText,bankText);

                    buttonSetup("reset");
                }
            }
        });

        stage.setTitle("Shop");
        stage.setResizable(false);
        flowPane.getChildren().addAll(buyButton, sellButton, bankButton, cargoButton, loanButton, quitButton, retireButton, opiumButton, silkButton, armsButton, generalButton, numberInput);
        Scene root = new Scene(declareStage(flowPane,firm,wItemsText,wItemSpaceText,locationText,gunsText,inventoryText,inventoryHeldText,shipStatusText,cashText,bankText,textOut), 600, 480);
        stage.setScene(root);
        root.getStylesheets().add("styleguide.css");

        // general updates to the buttons, user stats/inventory, and text.
        buttonSetup("reset");
        if(getIsPriceChanged() == 0 || getIsPriceChanged() == 2){
            TaipanShopLogic logic = new TaipanShopLogic(getPlayer());
            String temp = logic.updatePrices();
            setPlayer(logic.getPlayer());
            defaultTextOut();
            textOut.setText(temp + textOut.getText());
        }
        defaultTextOut();
        updateStage(firm,wItemsText,wItemSpaceText,locationText,gunsText,inventoryText,inventoryHeldText,shipStatusText,cashText,bankText);
    }


    public AnchorPane declareStage(FlowPane flowPane,Label firm, Label wItemsText, Label wItemSpaceText, Label locationText, Label gunsText, Label inventoryText, Label inventoryHeldText, Label shipStatusText, Label cashText, Label bankText, Label textOut) {
        //Declaring all the elements required for the information on screen
        Rectangle dialogueRectangle = new Rectangle();
        Rectangle inventoryRectangle = new Rectangle();
        Rectangle warehouseRectangle = new Rectangle();
        AnchorPane anchorPane = new AnchorPane();
        GridPane gridPane = new GridPane();
        ColumnConstraints columnConstraints = new ColumnConstraints();
        RowConstraints rowConstraints = new RowConstraints();
        RowConstraints rowConstraints0 = new RowConstraints();
        RowConstraints rowConstraints1 = new RowConstraints();
        RowConstraints rowConstraints2 = new RowConstraints();
        RowConstraints rowConstraints3 = new RowConstraints();
        RowConstraints rowConstraints4 = new RowConstraints();
        HBox hBox = new HBox();
        HBox hBox0 = new HBox();
        Font size14 = new Font(14.0);
        Label warehouseText = new Label();

        dialogueRectangle.setFill(Color.WHITE);
        dialogueRectangle.setHeight(180.0);
        dialogueRectangle.setLayoutX(8.0);
        dialogueRectangle.setLayoutY(294.0);
        dialogueRectangle.setStroke(Color.BLACK);
        dialogueRectangle.setStrokeType(StrokeType.INSIDE);
        dialogueRectangle.setWidth(582.0);

        inventoryRectangle.setFill(Color.WHITE);
        inventoryRectangle.setHeight(108.0);
        inventoryRectangle.setLayoutX(8.0);
        inventoryRectangle.setLayoutY(147.0);
        inventoryRectangle.setStroke(Color.BLACK);
        inventoryRectangle.setStrokeType(StrokeType.INSIDE);
        inventoryRectangle.setWidth(405.0);

        warehouseRectangle.setFill(Color.WHITE);
        warehouseRectangle.setHeight(108.0);
        warehouseRectangle.setLayoutY(33.0);
        warehouseRectangle.setLayoutX(8.0);
        warehouseRectangle.setStroke(Color.BLACK);
        warehouseRectangle.setStrokeType(StrokeType.INSIDE);
        warehouseRectangle.setWidth(405.0);

        anchorPane.setPrefHeight(480.0);
        anchorPane.setPrefWidth(600.0);

        gridPane.setPrefHeight(480.0);
        gridPane.setPrefWidth(600.0);

        columnConstraints.setMaxWidth(590.0);
        columnConstraints.setMinWidth(0.0);
        columnConstraints.setPrefWidth(590.0);

        rowConstraints.setMinHeight(20.0);
        rowConstraints.setPrefHeight(20.0);

        rowConstraints0.setMaxHeight(122.0);
        rowConstraints0.setMinHeight(10.0);
        rowConstraints0.setPrefHeight(117.0);

        rowConstraints1.setMaxHeight(163.0);
        rowConstraints1.setMinHeight(10.0);
        rowConstraints1.setPrefHeight(112.0);

        rowConstraints2.setMaxHeight(126.0);
        rowConstraints2.setMinHeight(0.0);
        rowConstraints2.setPrefHeight(42.0);

        rowConstraints3.setMaxHeight(269.0);
        rowConstraints3.setMinHeight(10.0);
        rowConstraints3.setPrefHeight(118.0);

        rowConstraints4.setMaxHeight(179.0);
        rowConstraints4.setMinHeight(10.0);
        rowConstraints4.setPrefHeight(52.0);

        gridPane.setPadding(new Insets(10.0, 10.0, 10.0, 0.0));

        GridPane.setRowIndex(hBox, 1);
        hBox.setPrefHeight(100.0);
        hBox.setPrefWidth(200.0);

        GridPane.setRowIndex(hBox0, 2);
        hBox0.setPrefHeight(100.0);
        hBox0.setPrefWidth(200.0);

        GridPane.setRowIndex(flowPane, 5);
        flowPane.setAlignment(Pos.CENTER);
        flowPane.setHgap(5.0);
        flowPane.setPrefHeight(200.0);
        flowPane.setPrefWidth(200.0);

        firm.setAlignment(Pos.CENTER);
        firm.setPrefHeight(27.0);
        firm.setPrefWidth(632.0);
        firm.setFont(new Font(18.0));

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
        //defaultTextOut();
        textOut.setFont(size14);

        anchorPane.getChildren().addAll(dialogueRectangle, inventoryRectangle, warehouseRectangle);

        hBox.getChildren().addAll(warehouseText, wItemsText, wItemSpaceText, locationText);

        hBox0.getChildren().addAll(inventoryText, inventoryHeldText, gunsText, shipStatusText);

        gridPane.getColumnConstraints().add(columnConstraints);
        gridPane.getRowConstraints().addAll(rowConstraints, rowConstraints0, rowConstraints1, rowConstraints2, rowConstraints3, rowConstraints4);
        gridPane.getChildren().addAll(firm, hBox, hBox0, cashText, bankText, textOut, flowPane);

        anchorPane.getChildren().add(gridPane);

        return anchorPane;
    }

    /**
     * updates the text associated with the user's inventory.
     */
    public void updateStage(Label firm, Label wItemsText, Label wItemSpaceText, Label locationText, Label gunsText, Label inventoryText, Label inventoryHeldText, Label shipStatusText, Label cashText, Label bankText) {
        TaipanShopLogic logic = new TaipanShopLogic(super.getPlayer());
        firm.setText(String.format("Firm: %s, %s", getName(), logic.getStringLocation()));
        wItemsText.setText(String.format("\n %d\n %d\n %d\n %d", getwOpium(), getwSilk(), getwArms(), getwGeneral()));
        int itemsInWarehouse = getwOpium() + getwGeneral() + getwArms() + getwSilk();
        wItemSpaceText.setText(String.format("\n\t\tIn use:\n\t\t %d \n\t\tVacant:\n\t\t %d", itemsInWarehouse, (10000 - itemsInWarehouse)));
        locationText.setText(String.format("Location\n%s", logic.getStringLocation()));
        int itemsInInventory = getCargoSpace() - getSilkHeld() - getOpiumHeld() - getGeneralHeld() - getArmsHeld() - 10 * getGuns();
        if (itemsInInventory < 0) {
            inventoryText.setText("   Overloaded\n\t  Opium\n\t  Silk\n\t  Arms\n\t  General");
        } else {
            inventoryText.setText(String.format("   Hold %d\n\t  Opium\n\t  Silk\n\t  Arms\n\t  General", itemsInInventory));
        }
        gunsText.setText(String.format("Guns %d\n\n\n\n ", getGuns()));
        inventoryHeldText.setText(String.format("\n %d\n %d\n %d\n %d", getOpiumHeld(), getSilkHeld(), getArmsHeld(), getGeneralHeld()));
        shipStatusText.setText(String.format("\tDebt\n\t%d\n\n\tShip status\n\t%s: %d", getDebt(), logic.shipStatusString(), getHP()));
        cashText.setText(String.format("  Cash: $%,d", getMoney()));
        bankText.setText(String.format("Bank: $%,d", getBank()));
    }
}
