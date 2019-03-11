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

public class TaipanShopGUI {
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
    private Button retireButton = new Button();
    private Button bankButton = new Button();
    private Button sellButton = new Button();
    private Button buyButton = new Button();
    private Button loanButton = new Button();
    private Button cargoButton = new Button();
    private Button opiumButton = new Button();
    private Button silkButton = new Button();
    private Button armsButton  = new Button();
    private Button generalButton = new Button();
    private TextField numberInput = new TextField();
    private int opiumPrice = 16000;
    private int silkPrice = 1600;
    private int armsPrice = 160;
    private int generalPrice = 8;

    /**
     * constructor; only runs when a Player object is provided. The constructor is fully encapsulated.
     *
     * @param player is a Player object that will be copied and the player instance variable is set to the copy.
     */
    public TaipanShopGUI(Player player){
        Player playerDummy = new Player(player);
        this.player = playerDummy;
    }

    public void startTaipanShop(Stage stage){
        stage = initializeShop(stage);
        updateStage();
        updatePrices();
        stage.show();
    }

    /**
     * This method is evoked if the user is eligible to win, and chooses to end the game (by winning).
     */
    public void retire(){
        player.setRetire(true);
        System.out.println("You win!");
        System.exit(0);
    }

    /**
     * sets the player instance variable equal to a copy of the parameter -- a copy is used for encapsulation purposes.
     *
     * @param player is a Player object that will replace the current instance of the player instance variable.
     */
    public void setPlayer(Player player) {
        Player playerDummy = new Player(player);
        this.player = playerDummy;
    }

    /**
     * gets the player instance variable. The method returns a copy of the instance variable for encapsulation purposes.
     *
     * @return playerDummy -- playerDummy is a copy of the player instance variable.
     */
    public Player getPlayer(){
        Player playerDummy = new Player(player);
        return playerDummy;
    }

    /**
     * getter for opiumPrice instance variable.
     *
     * @return opiumPrice -- the price of opium in the shop
     */
    public int getOpiumPrice() {
        return opiumPrice;
    }

    /**
     * setter for the opiumPrice instance variable. Runs as long as the parameter is greater than 0.
     *
     * @param opiumPrice -- what the instance variable opiumPrice should be changed to.
     */
    public void setOpiumPrice(int opiumPrice) {
        if(opiumPrice > 0){
            this.opiumPrice = opiumPrice;
        }
    }

    /**
     * getter for silkPrice instance variable.
     *
     * @return silkPrice -- the price of silk in the shop.
     */
    public int getSilkPrice() {
        return silkPrice;
    }

    /**
     * setter for the silkPrice instance variable. Runs as long as the parameter is greater than 0.
     *
     * @param silkPrice -- what the instance variable silkPrice should be changed to.
     */
    public void setSilkPrice(int silkPrice) {
        if(silkPrice > 0){
            this.silkPrice = silkPrice;
        }
    }

    /**
     * getter for armsPrice instance variable.
     *
     * @return armsPrice -- the price of arms in the shop.
     */
    public int getArmsPrice() {
        return armsPrice;
    }

    /**
     * setter for the armsPrice instance variable. Runs as long as the parameter is greater than 0.
     *
     * @param armsPrice -- what the instance variable armsPrice should be changed to.
     */
    public void setArmsPrice(int armsPrice) {
        if(armsPrice > 0){
            this.armsPrice = armsPrice;
        }
    }

    /**
     * getter for generalPrice instance variable.
     *
     * @return generalPrice -- the price of general cargo in the shop.
     */
    public int getGeneralPrice() {
        return generalPrice;
    }

    /**
     * setter for the generalPrice instance variable. Runs as long as the parameter is greater than 0.
     *
     * @param generalPrice -- what the instance variable generalPrice should be changed to.
     */
    public void setGeneralPrice(int generalPrice) {
        if(generalPrice > 0){
            this.generalPrice = generalPrice;
        }
    }

    /**
     * this method is when the shop is accessed, randomizing the prices of all the items.
     */
    public void updatePrices(){
        String s = "\t" + player.getName() + ", the price of ";
        double value = 80*Math.random();
        Random rand = new Random();
        opiumPrice = (rand.nextInt(201) + 60)*100;
        silkPrice = (rand.nextInt(201) + 60)*10;
        armsPrice = (rand.nextInt(21) + 6)*10;
        generalPrice = rand.nextInt(17) + 4;

        // there is a 10% chance that the price of an item is increased/decreased beyond its regular range.
        if(value < 8){
            if(value < 2){
                if(value < 1){
                    opiumPrice /= 5;
                    textOut.setText(s + "Opium has dropped to " + opiumPrice +"!!!\n"+textOut.getText());
                }else{
                    opiumPrice *= 5;
                    textOut.setText(s + "Opium has risen to " + opiumPrice +"!!!\n"+textOut.getText());
                }
            }else if(value < 4){
                if(value < 3){
                    silkPrice /= 5;
                    textOut.setText(s + "Silk has dropped to " + silkPrice +"!!!\n"+textOut.getText());
                }else{
                    silkPrice *= 5;
                    textOut.setText(s + "Silk has risen to " + silkPrice +"!!!\n"+textOut.getText());
                }
            }else if(value < 6){
                if(value < 3){
                    armsPrice /= 5;
                    textOut.setText(s + "Arms has dropped to " + armsPrice +"!!!\n"+textOut.getText());
                }else{
                    armsPrice *= 5;
                    textOut.setText(s + "Arms has risen to " + armsPrice +"!!!\n"+textOut.getText());
                }
            }else{
                if(value < 7){
                    generalPrice = 1;
                    textOut.setText(s + "General Cargo has dropped to 1!!!\n"+textOut.getText());
                }else{
                    generalPrice *= 5;
                    textOut.setText(s + "General Cargo has risen to " + generalPrice + "!!!\n"+textOut.getText());
                }
            }
        }
    }

    public void defaultTextOut(){
        textOut.setText(String.format("\t%s, present prices per unit here are:\n\n\t\tOpium: %d\t\t\tSilk: %d\n\t\tArms: %d\t\t\tGeneral: %d", player.getName(), getOpiumPrice(), getSilkPrice(), getArmsPrice(), getGeneralPrice()));

    }

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
            if (player.getLocation() != 1 && player.getBank() + player.getMoney() - player.getDebt() < 1000000) {
                buyButton.setVisible(true);
                sellButton.setVisible(true);
                bankButton.setVisible(false);
                cargoButton.setVisible(false);
                loanButton.setVisible(false);
                armsButton.setVisible(false);
                quitButton.setVisible(true);
                opiumButton.setVisible(false);
                silkButton.setVisible(false);
                numberInput.setVisible(false);
                generalButton.setVisible(false);
                retireButton.setVisible(false);
            }else if(player.getBank() + player.getMoney() - player.getDebt() < 1000000){
                buyButton.setVisible(true);
                sellButton.setVisible(true);
                bankButton.setVisible(true);
                cargoButton.setVisible(true);
                loanButton.setVisible(true);
                quitButton.setVisible(true);
                opiumButton.setVisible(false);
                silkButton.setVisible(false);
                numberInput.setVisible(false);
                generalButton.setVisible(false);
                armsButton.setVisible(false);
                retireButton.setVisible(false);
            }else{
                buyButton.setVisible(true);
                sellButton.setVisible(true);
                bankButton.setVisible(true);
                cargoButton.setVisible(true);
                loanButton.setVisible(true);
                numberInput.setVisible(false);
                quitButton.setVisible(true);
                opiumButton.setVisible(false);
                silkButton.setVisible(false);
                generalButton.setVisible(false);
                armsButton.setVisible(false);
                retireButton.setVisible(true);
            }
        } else if(state.equals("input")){
            buyButton.setVisible(false);
            sellButton.setVisible(false);
            bankButton.setVisible(false);
            cargoButton.setVisible(false);
            loanButton.setVisible(false);
            numberInput.setVisible(true);
            quitButton.setVisible(false);
            opiumButton.setVisible(false);
            silkButton.setVisible(false);
            generalButton.setVisible(false);
            armsButton.setVisible(false);
            retireButton.setVisible(false);
        }
    }

    public void shop(){
        String originalDialogue = textOut.getText();
        int num = Integer.parseInt(numberInput.getText().replace(" ", ""));
        if(buyButton.getText().contains(".")){
            if(opiumButton.getText().contains(".") && num <= player.getMoney() / opiumPrice && num >= 0){
                player.setMoney(player.getMoney()-num*opiumPrice);
                player.setOpiumHeld(player.getOpiumHeld()+num);
            }else if (num >= 0 && opiumButton.getText().contains(".")) {
                textOut.setText(originalDialogue+"\n\t"+ player.getName() + ", you can't afford that!");
            }else if(opiumButton.getText().contains(".")) {
                textOut.setText(originalDialogue+"\n\t"+ player.getName() +", how am I supposed to buy " + "'" + num + "'" + " Opium?");
            }else if(silkButton.getText().contains(".") && num <= player.getMoney() / silkPrice && num >= 0){
                player.setSilkHeld(player.getSilkHeld()+num);
                player.setMoney(player.getMoney()-num * silkPrice);
            }else if (num >= 0 && silkButton.getText().contains(".")) {
                textOut.setText(originalDialogue+"\n\t"+ player.getName() + ", you can't afford that!");
            }else if(silkButton.getText().contains(".")) {
                textOut.setText(originalDialogue+"\n\t"+ player.getName() +", how am I supposed to buy " + "'" + num + "'" + " Silk?");
            }else if(armsButton.getText().contains(".") && num <= player.getMoney() / armsPrice && num >= 0){
                player.setArmsHeld(player.getArmsHeld()+num);
                player.setMoney(player.getMoney() - num*armsPrice);
            }else if(num >= 0 && armsButton.getText().contains(".")){
                textOut.setText(originalDialogue+"\n\t"+ player.getName() + ", you can't afford that!");
            }else if(armsButton.getText().contains(".")){
                textOut.setText(originalDialogue+"\n\t"+ player.getName() +", how am I supposed to buy " + "'" + num + "'" + " Arms?");
            }else if(generalButton.getText().contains(".") && num <= player.getMoney() / generalPrice && num >= 0){
                player.setArmsHeld(player.getArmsHeld()+num);
                player.setMoney(player.getMoney() - num*generalPrice);
            }else if(num >= 0 && generalButton.getText().contains(".")){
                textOut.setText(originalDialogue+"\n\t"+ player.getName() + ", you can't afford that!");
            }else if(generalButton.getText().contains(".")){
                textOut.setText(originalDialogue+"\n\t"+ player.getName() +", how am I supposed to buy " + "'" + num + "'" + " General Cargo?");
            }
        }else if(sellButton.getText().contains(".")){
            if(opiumButton.getText().contains(".") && num <= player.getOpiumHeld() && num >= 0){
                player.setOpiumHeld(player.getOpiumHeld()-num);
                player.setMoney(player.getMoney() + num*opiumPrice);
            }else if (num >= 0 && opiumButton.getText().contains(".")) {
                textOut.setText(originalDialogue+"\n\t"+ player.getName() + ", you don't have that many to sell!");
            }else if(opiumButton.getText().contains(".")) {
                textOut.setText(originalDialogue+"\n\t"+ player.getName() +", how am I supposed to sell " + "'" + num + "'" + " Opium?");
            }else if(silkButton.getText().contains(".") && num <= player.getSilkHeld() && num >= 0){
                player.setSilkHeld(player.getSilkHeld()-num);
                player.setMoney(player.getMoney() + num*silkPrice);
            }else if (num >= 0 && silkButton.getText().contains(".")) {
                textOut.setText(originalDialogue+"\n\t"+ player.getName() + ", you don't have that many to sell!");
            }else if(silkButton.getText().contains(".")) {
                textOut.setText(originalDialogue+"\n\t"+ player.getName() +", how am I supposed to sell " + "'" + num + "'" + " Silk?");
            }else if(armsButton.getText().contains(".") && num <= player.getArmsHeld() && num >= 0){
                player.setArmsHeld(player.getArmsHeld()-num);
                player.setMoney(player.getMoney() + num*armsPrice);
            }else if(num >= 0 && armsButton.getText().contains(".")){
                textOut.setText(originalDialogue+"\n\t"+ player.getName() + ", you don't have that many to sell!");
            }else if(armsButton.getText().contains(".")){
                textOut.setText(originalDialogue+"\n\t"+ player.getName() +", how am I supposed to sell " + "'" + num + "'" + " Arms?");
            }else if(generalButton.getText().contains(".") && num <= player.getGeneralHeld() && num >= 0){
                player.setGeneralHeld(player.getGeneralHeld()-num);
                player.setMoney(player.getMoney() + num*generalPrice);
            }else if(num >= 0 && generalButton.getText().contains(".")){
                textOut.setText(originalDialogue+"\n\t"+ player.getName() + ", you don't have that many to sell!");
            }else{
                textOut.setText(originalDialogue+"\n\t"+ player.getName() +", how am I supposed to sell " + "'" + num + "'" + " General Cargo?");
            }
        }
    }

    public Stage initializeShop(Stage stage){
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

        buyButton.setMnemonicParsing(false);
        buyButton.setPrefHeight(25.0);
        buyButton.setPrefWidth(45.0);
        buyButton.setText("Buy");
        buyButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                buttonSetup("shop");
                buyButton.setText("Buy.");
                defaultTextOut();
                textOut.setText(textOut.getText()+"\n\tWhich good would you like to purchase?");
            }
        });

        sellButton.setPrefHeight(25.0);
        sellButton.setText("Sell");
        sellButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                buttonSetup("shop");
                sellButton.setText("Sell.");
                defaultTextOut();
                textOut.setText(textOut.getText()+"\n\tWhich good would you like to sell?");
            }
        });
        sellButton.setPrefWidth(45.0);
        sellButton.setMnemonicParsing(false);

        bankButton.setPrefHeight(25.0);
        bankButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                bankGUI bank = new bankGUI(getPlayer());
                bank.initializeBank(stage);
                stage.show();
            }
        });
        bankButton.setMnemonicParsing(false);
        bankButton.setPrefWidth(74.0);
        bankButton.setText("Visit Bank");

        cargoButton.setPrefHeight(25.0);
        cargoButton.setText("Transfer Cargo");
        cargoButton.setMnemonicParsing(false);
        cargoButton.setPrefWidth(94.0);
        cargoButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                WarehouseGUI warehouseGUI = new WarehouseGUI(player);
                warehouseGUI.initializeWarehouse(stage);
                stage.show();
            }
        });


        loanButton.setMnemonicParsing(false);
        loanButton.setPrefHeight(25.0);
        loanButton.setPrefWidth(73.0);
        loanButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                loanSharkGUI loan = new loanSharkGUI(getPlayer());
                loan.initializeLoanShark(stage);
                stage.show();
            }
        });
        loanButton.setText("Get Loans");

        quitButton.setPrefHeight(25.0);
        quitButton.setMnemonicParsing(false);
        quitButton.setPrefWidth(90.0);
        quitButton.setText("Quit Trading");
        quitButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                TravelGUI travelGUI = new TravelGUI(player);
                travelGUI.initializeTravel(stage);
                stage.show();
                //System.out.println("PLACEHOLDER FOR TRAVEL");
            }
        });

        retireButton.setPrefHeight(25.0);
        retireButton.setPrefWidth(49.0);
        retireButton.setText("Retire");
        retireButton.setVisible(false);
        retireButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                retire();
            }
        });
        retireButton.setMnemonicParsing(false);

        opiumButton.setMnemonicParsing(false);
        opiumButton.setPrefWidth(86.0);
        opiumButton.setPrefHeight(25.0);
        opiumButton.setText("Opium");
        opiumButton.setVisible(false);
        opiumButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                buttonSetup("input");
                opiumButton.setText("Opium.");
                defaultTextOut();
                String extraText;
                if(buyButton.getText().contains(".")){
                    extraText = String.format(" (You can afford %d)", player.getMoney()/opiumPrice);
                }else{
                    extraText = String.format(" (You have %d)", player.getOpiumHeld());
                }
                textOut.setText(textOut.getText()+"\n\tWhat quantity of Opium?" + extraText);
            }
        });

        silkButton.setPrefHeight(25.0);
        silkButton.setPrefWidth(86.0);
        silkButton.setMnemonicParsing(false);
        silkButton.setText("Silk");
        silkButton.setVisible(false);
        silkButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                buttonSetup("input");
                silkButton.setText("Silk.");
                defaultTextOut();
                String extraText;
                if(buyButton.getText().contains(".")){
                    extraText = String.format(" (You can afford %d)", player.getMoney()/silkPrice);
                }else{
                    extraText = String.format(" (You have %d)", player.getSilkHeld());
                }
                textOut.setText(textOut.getText()+"\n\tWhat quantity of Silk?" + extraText);
            }
        });

        armsButton.setPrefWidth(86.0);
        armsButton.setMnemonicParsing(false);
        armsButton.setVisible(false);
        armsButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                buttonSetup("input");
                armsButton.setText("Arms.");
                defaultTextOut();
                String extraText;
                if(buyButton.getText().contains(".")){
                    extraText = String.format(" (You can afford %d)", player.getMoney()/armsPrice);
                }else{
                    extraText = String.format(" (You have %d)", player.getArmsHeld());
                }
                textOut.setText(textOut.getText()+"\n\tWhat quantity of Arms?" + extraText);
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
            @Override
            public void handle(ActionEvent event) {
                buttonSetup("input");
                generalButton.setText("General.");
                defaultTextOut();
                String extraText;
                if(buyButton.getText().contains(".")){
                    extraText = String.format(" (You can afford %d)", player.getMoney()/generalPrice);
                }else{
                    extraText = String.format(" (You have %d)", player.getGeneralHeld());
                }
                textOut.setText(textOut.getText()+"\n\tWhat quantity of General Cargo?" + extraText);
            }
        });

        numberInput.setAlignment(javafx.geometry.Pos.CENTER_RIGHT);
        numberInput.setText("Enter amount here...");
        numberInput.setVisible(false);
        numberInput.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                boolean exit = true;
                defaultTextOut();
                if(event.getCode().equals(KeyCode.ENTER)||event.getCode().equals(KeyCode.Z)) {
                    while(true){
                        if(!textOut.getText().contains("You entered an invalid input!")&& !exit){
                            textOut.setText(textOut.getText()+"\n\n\tYou entered an invalid input! Please try again.");
                            break;
                        }
                        try{
                            shop();
                        }catch(Exception e){
                            exit = false;
                        }
                        if(exit){
                            break;
                        }
                    }
                    updateStage();
                    
                    buttonSetup("reset");
                }
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
        defaultTextOut();
        textOut.setFont(size14);

        anchorPane.getChildren().addAll(dialogueRectangle, inventoryRectangle, warehouseRectangle);

        hBox.getChildren().addAll(warehouseText, wItemsText, wItemSpaceText, locationText);

        hBox0.getChildren().addAll(inventoryText, inventoryHeldText, gunsText, shipStatusText);

        flowPane.getChildren().addAll(buyButton, sellButton, bankButton, cargoButton, loanButton, quitButton, retireButton, opiumButton, silkButton, armsButton, generalButton, numberInput);

        gridPane.getColumnConstraints().add(columnConstraints);
        gridPane.getRowConstraints().addAll(rowConstraints, rowConstraints0, rowConstraints1, rowConstraints2, rowConstraints3, rowConstraints4);
        gridPane.getChildren().addAll(firm, hBox, hBox0, cashText, bankText, textOut, flowPane);

        anchorPane.getChildren().add(gridPane);

        Scene root = new Scene(anchorPane, 600, 480);
        
        stage.setTitle("Shop");
        stage.setResizable(false);
        stage.setScene(root);

        buttonSetup("reset");
        updatePrices();
        defaultTextOut();
        updateStage();

        return stage;
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
        cashText.setText(String.format("  Cash: $%,d", player.getMoney()));
        bankText.setText(String.format("Bank: %d", player.getBank()));
    }
    
}
