package gui;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import logic.Player;

/**
 * 2019-03-19
 * Authors:Siddhant, Vikram, Harkamal, Haris, Nathan
 * WarehouseGUI allows the user to store goods in a warehouse in order to have more hold on the ship
 */

public class WarehouseGUI extends Player {
    //Create the labels, buttons and textfields required
    private HBox hBox;
    private VBox vBox;
    private TextField textField;
    private RadioButton generalRadio;
    private ToggleGroup Goods;
    private RadioButton armsRadio;
    private RadioButton silkRadio;
    private RadioButton opiumRadio;
    private Button withdrawButton;
    private Button depositButton;
    private Button quitButton;
    private Label title;
    private HBox hBox0;
    private VBox vBox0;
    private Label playerLabel;
    private Label playerGeneral;
    private Label playerArms;
    private Label playerSilk;
    private Label playerOpium;
    private VBox vBox1;
    private Label houseLabel;
    private Label houseGeneral;
    private Label houseArms;
    private Label houseSilk;
    private Label houseOpium;
    private BorderPane borderPane;

    /**
     * constructor that creates an object of type player
     * @param player
     */
    public WarehouseGUI(Player player) {
        Player playerDummy = new Player(player);
        setPlayer(playerDummy);
    }

    /**
     *
     * @param stage
     * @return stage after creating buttons and layout
     */
    public Stage initializeWarehouse(Stage stage){

        //Initializes the instances created above to a new type
        hBox = new HBox();
        vBox = new VBox();
        generalRadio = new RadioButton();
        Goods = new ToggleGroup();
        armsRadio = new RadioButton();
        silkRadio = new RadioButton();
        opiumRadio = new RadioButton();
        withdrawButton = new Button();
        depositButton = new Button();
        quitButton = new Button();
        title = new Label();
        hBox0 = new HBox();
        vBox0 = new VBox();
        playerLabel = new Label();
        playerGeneral = new Label();
        playerArms = new Label();
        playerSilk = new Label();
        playerOpium = new Label();
        vBox1 = new VBox();
        houseLabel = new Label();
        houseGeneral = new Label();
        houseArms = new Label();
        houseSilk = new Label();
        houseOpium = new Label();
        borderPane = new BorderPane();
        textField = new TextField();

        //Creating the box for the warehouse GUI
        borderPane.setAlignment(hBox, javafx.geometry.Pos.CENTER);
        hBox.setAlignment(javafx.geometry.Pos.CENTER);
        hBox.setPrefHeight(100.0);
        hBox.setPrefWidth(200.0);
        hBox.setSpacing(10.0);

        vBox.setAlignment(javafx.geometry.Pos.CENTER_LEFT);
        vBox.setPrefHeight(200.0);
        vBox.setPrefWidth(100.0);

        //Adding general button
        generalRadio.setMnemonicParsing(false);
        generalRadio.setSelected(true);
        generalRadio.setText("General");

        generalRadio.setToggleGroup(Goods);

        //Adding Arms Button
        armsRadio.setMnemonicParsing(false);
        armsRadio.setText("Arms");
        armsRadio.setToggleGroup(Goods);

        //Adding Silk button
        silkRadio.setMnemonicParsing(false);
        silkRadio.setText("Silk");
        silkRadio.setToggleGroup(Goods);

        // Adding opium button
        opiumRadio.setMnemonicParsing(false);
        opiumRadio.setText("Opium");
        opiumRadio.setToggleGroup(Goods);

        // Remove materials button
        withdrawButton.setMnemonicParsing(false);
        withdrawButton.setText("Withdraw");

        // Add materials button
        depositButton.setMnemonicParsing(false);
        depositButton.setText("Deposit");

        //Go back to the previous screen button
        quitButton.setMnemonicParsing(false);
        quitButton.setText("Go back");
        borderPane.setBottom(hBox);


        //Takes you to the HK warehouse
        borderPane.setAlignment(title, javafx.geometry.Pos.CENTER);
        title.setText("Hong Kong Warehouse");
        title.setFont(new Font(24.0));
        title.setPadding(new Insets(10.0, 0.0, 0.0, 0.0));
        borderPane.setTop(title);

        // Making the BOX again
        borderPane.setAlignment(hBox0, javafx.geometry.Pos.CENTER);
        hBox0.setAlignment(javafx.geometry.Pos.CENTER);
        hBox0.setPrefHeight(100.0);
        hBox0.setPrefWidth(200.0);
        hBox0.setSpacing(10.0);

        vBox0.setAlignment(javafx.geometry.Pos.CENTER_LEFT);
        vBox0.setSpacing(10.0);

        playerLabel.setText("Player:");
        playerLabel.setFont(new Font(18.0));

        // displays the hold of general
        playerGeneral.setText("General:");

        // displays the hold of Arms

        playerArms.setText("Arms:");

        // displays the hold of Silk

        playerSilk.setText("Silk:");

        // displays the hold of Opium

        playerOpium.setText("Opium:");

        vBox1.setAlignment(javafx.geometry.Pos.CENTER_LEFT);
        vBox1.setSpacing(10.0);

        houseLabel.setAlignment(javafx.geometry.Pos.TOP_CENTER);
        houseLabel.setText("Warehouse:");
        houseLabel.setFont(new Font(18.0));


        houseGeneral.setText("General:");

        houseArms.setText("Arms:");

        houseSilk.setText("Silk:");

        houseOpium.setText("Opium:");

        //Shows the values of the goods that are in the warehouse
        borderPane.setMargin(hBox0, new Insets(0.0));
        hBox0.setPadding(new Insets(10.0, 0.0, 0.0, 0.0));
        vBox0.setPadding(new Insets(0, 0.0, 0.0, 0.0));
        borderPane.setCenter(hBox0);

        //Add buttons for the goods
        vBox.getChildren().add(generalRadio);
        vBox.getChildren().add(armsRadio);
        vBox.getChildren().add(silkRadio);
        vBox.getChildren().add(opiumRadio);

        //Adds the buttons for withdraw, deposit and quitting
        hBox.getChildren().add(vBox);
        hBox.getChildren().add(textField);
        hBox.getChildren().add(withdrawButton);
        hBox.getChildren().add(depositButton);
        hBox.getChildren().add(quitButton);

        //Adds the buttons for the amount of the good the player has
        vBox0.getChildren().add(playerLabel);
        vBox0.getChildren().add(playerGeneral);
        vBox0.getChildren().add(playerArms);
        vBox0.getChildren().add(playerSilk);
        vBox0.getChildren().add(playerOpium);

        //Amount of stock the warehouse has of the goods
        vBox1.getChildren().add(houseLabel);
        vBox1.getChildren().add(houseGeneral);
        vBox1.getChildren().add(houseArms);
        vBox1.getChildren().add(houseSilk);
        vBox1.getChildren().add(houseOpium);

        hBox0.getChildren().add(vBox0);
        hBox0.getChildren().add(vBox1);

        updateLabels();

        //Goes back to shop
        quitButton.setOnAction(event -> {
            TaipanShopGUI taipanShopGUI = new TaipanShopGUI(getPlayer());
            taipanShopGUI.initializeShop(stage);
            stage.show();
        });
        //Runs when the withdraw button is selected. and removes the amount of the selected good
        withdrawButton.setOnAction(event -> {
            try {
                int withdraw = Integer.parseInt(textField.getText());

                if(withdraw <= 0){
                    title.setText("Please enter a valid value");
                }
                //Transfers general amount
                else if(Goods.getSelectedToggle() == generalRadio && withdraw <= getwGeneral()){
                    setGeneralHeld(getPlayer().getGeneralHeld()+withdraw);
                    setwGeneral(getPlayer().getwGeneral()-withdraw);
                }
                //Transfers Arms amount
                else if(Goods.getSelectedToggle() == armsRadio && withdraw <= getwArms()){
                    setArmsHeld(getPlayer().getArmsHeld()+withdraw);
                    setwArms(getPlayer().getwArms()-withdraw);
                }
                //Transfers Silk Amount
                else if(Goods.getSelectedToggle() == silkRadio && withdraw <= getwSilk()){
                    setSilkHeld(getPlayer().getSilkHeld()+withdraw);
                    setwSilk(getPlayer().getwSilk()-withdraw);
                }
                //Transfers Opium amount
                else if(Goods.getSelectedToggle() == opiumRadio && withdraw <= getwOpium()) {
                    setOpiumHeld(getPlayer().getOpiumHeld() + withdraw);
                    setwOpium(getPlayer().getwOpium() - withdraw);
                }
                // Ensures a valid value is entered
                else{
                    title.setText("Please enter a valid value");
                }
                updateLabels();
            }
            catch (Exception e) {
                title.setText("Please enter a valid value");
            }
        });
        //Button to add a user entered amount to the warehouse
        depositButton.setOnAction(event -> {
            try {
                int deposit = Integer.parseInt(textField.getText());

                if(deposit <= 0){
                    title.setText("Please enter a valid value");
                }
                //Transfers general amount
                else if(Goods.getSelectedToggle() == generalRadio && deposit <= getGeneralHeld()){
                    setGeneralHeld(getPlayer().getGeneralHeld()-deposit);
                    setwGeneral(getPlayer().getwGeneral()+deposit);
                }
                //Transfers Arms  amount
                else if(Goods.getSelectedToggle() == armsRadio && deposit <= getArmsHeld()){
                    setArmsHeld(getPlayer().getArmsHeld()-deposit);
                    setwArms(getPlayer().getwArms()+deposit);
                }
                //Transfers Silk amount
                else if(Goods.getSelectedToggle() == silkRadio && deposit <= getSilkHeld()){
                    setSilkHeld(getPlayer().getSilkHeld()-deposit);
                    setwSilk(getPlayer().getwSilk()+deposit);
                }
                //Transfers Opium amount
                else if(Goods.getSelectedToggle() == opiumRadio && deposit <= getOpiumHeld()){
                    setOpiumHeld(getPlayer().getOpiumHeld()-deposit);
                    setwOpium(getPlayer().getwOpium()+deposit);
                }
                //Checks if the correct value is entered
                else{
                    title.setText("Please enter a valid value");
                }
                updateLabels();
            }
            catch (Exception e) {
                title.setText("Please enter a valid value");
            }
        });


        //Create the sceene and box of the desired size
        Scene root = new Scene(borderPane, 600, 480);
        root.getStylesheets().add("styleguide.css");

        stage.setTitle("Warehouse");
        stage.setResizable(false);
        stage.setScene(root);
        return stage;
    }

    /**
     * As soon as the transfer is made the table of the amount of goods is updated using this method
     */
    public void updateLabels(){
        playerLabel.setText("Player: " + (getPlayer().getCargoSpace()-((getPlayer().getGuns()*10)+ getPlayer().getGeneralHeld() + getPlayer().getArmsHeld() + getPlayer().getSilkHeld() + getPlayer().getOpiumHeld())));
        houseLabel.setText("Warehouse: " + (10000 -(getPlayer().getwGeneral() + getPlayer().getwArms() + getPlayer().getwSilk() + getPlayer().getwOpium())));

        playerGeneral.setText("General: " + getPlayer().getGeneralHeld());
        playerArms.setText("Arms: " + getPlayer().getArmsHeld());
        playerSilk.setText("Silk: " + getPlayer().getSilkHeld() );
        playerOpium.setText("Opium: " + getPlayer().getOpiumHeld());

        houseGeneral.setText("General: " + getPlayer().getwGeneral());
        houseArms.setText("Arms: " + getPlayer().getwArms());
        houseSilk.setText("Silk: " + getPlayer().getwSilk());
        houseOpium.setText("Opium: " + getPlayer().getwOpium());
    }
}
