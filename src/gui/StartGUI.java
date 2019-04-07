package gui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import logic.Player;
import logic.FileSaving;

/**
 * 2019-03-10
 * Authors: Harkamal, Vikram, Haris, Siddhant, Nathan
 * StartGUI class, Initializes and displays the start menu for Taipan
 *
 */


public class StartGUI extends Player {

    private BorderPane borderPane = new BorderPane();
    private HBox hBox = new HBox();
    private TextField nameField = new TextField();
    private Button startButton = new Button();
    private Button continueButton = new Button();
    private VBox vBox = new VBox();
    private Label choiceLabel = new Label();
    private RadioButton gunChoice = new RadioButton();
    private ToggleGroup Start = new ToggleGroup();
    private RadioButton cashChoice = new RadioButton();
    private VBox vBox0 = new VBox();
    private Label title = new Label();
    private Label authors = new Label();

    /**
     * Copy constructor.
     * @param player object of the class Player
     */
    public StartGUI(Player player) {
        Player playerTemp = new Player(player);
        setPlayer(playerTemp);
    }

    /**
     * Asks the user to input the name that they would like to be called in the game
     *
     * @param name the name that you would like to be called in the game
     */
    public void setFirm(String name) {
        if (name.length() <= 22) {
            super.setName(name);
        } else {
            super.setName("Taipan");
        }
    }

    /**
     * Initializes the Start GUI the game.
     *
     * @param stage object of type Stage
     * @return returns the stage of GUI
     */
    public Stage initializeStart(Stage stage) {

        /**
         * Creates an HBox at the center of the borderpane with a width of 200, height of 100 and spacing of 10.
         *
         */
        BorderPane.setAlignment(hBox, javafx.geometry.Pos.CENTER);
        hBox.setAlignment(javafx.geometry.Pos.CENTER);
        hBox.setPrefHeight(100.0);
        hBox.setPrefWidth(200.0);
        hBox.setSpacing(10.0);

        /**
         * Creates a borderpane window of width 600 and height 480.
         *
         */
        borderPane.setPrefHeight(480.0);
        borderPane.setPrefWidth(600.0);

        /**
         * Creates a prompt text field that asks for your firm name and has a default text set to "Taipan".
         *
         */
        nameField.setPromptText("Enter Firm Name.");
        nameField.setText("Taipan");

        /**
         * Creates a button with text "Start"
         *
         */
        startButton.setMnemonicParsing(false);
        startButton.setText("New");

        /**
         * Creates a button with text "Continue"
         *
         */
        continueButton.setMnemonicParsing(false);
        continueButton.setText("Load");

        /**
         * Creates a VBox at the left of center of the borderpane.
         *
         */
        vBox.setAlignment(javafx.geometry.Pos.CENTER_LEFT);

        /**
         * Creates a label with text "Do you want to start with..." to indicate the user has to choose between 2 given scenarios.
         *
         */
        choiceLabel.setText("Do you want to start with...");

        /**
         * Label for scenario one which is you start with five guns and no cash or debt.
         *
         */
        gunChoice.setMnemonicParsing(false);
        gunChoice.setSelected(true);
        gunChoice.setText("Five guns and no cash (But no debt!)?");

        gunChoice.setToggleGroup(Start);

        /**
         * Label for scenario 2 which is you start with cash but also a debt.
         *
         */
        cashChoice.setAlignment(javafx.geometry.Pos.TOP_LEFT);
        cashChoice.setMnemonicParsing(false);
        cashChoice.setText("Cash (and a debt)");
        cashChoice.setToggleGroup(Start);
        borderPane.setBottom(hBox);

        /**
         * Creates a VBox at the center of the borderpane with a width of 100 and height of 200.
         *
         */
        BorderPane.setAlignment(vBox0, javafx.geometry.Pos.CENTER);
        vBox0.setAlignment(javafx.geometry.Pos.CENTER);
        vBox0.setPrefHeight(200.0);
        vBox0.setPrefWidth(100.0);

        /**
         * Creates a label with text "Taipan" in size 66 font and default font style.
         *
         */
        title.setText("Taipan");
        title.setFont(new Font(66.0));

        /**
         * Creates a label with our names as text
         *
         */
        authors.setPrefHeight(80.0);
        authors.setPrefWidth(480.0);
        authors.setText("By Vikram Bawa, Haris Muhammad, Siddhant Dewani, Nathan Lum \nand Harkamal Randhawa");

        /**
         * Puts Vbox0 in the center of the borderpane.
         *
         */
        authors.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        authors.setAlignment(Pos.CENTER);
        vBox0.setAlignment(Pos.CENTER);
        borderPane.setCenter(vBox0);

        /**
         * Adds all the buttons and labels to their respective boxes.
         *
         */
        hBox.getChildren().add(nameField);
        hBox.getChildren().add(startButton);
        hBox.getChildren().add(continueButton);
        vBox.getChildren().add(choiceLabel);
        vBox.getChildren().add(gunChoice);
        vBox.getChildren().add(cashChoice);
        hBox.getChildren().add(vBox);
        vBox0.getChildren().add(title);
        vBox0.getChildren().add(authors);
        startButton.setDefaultButton(true);

        /**
         * Adds function to the "Start" button, scenario 1 gives the player $400 and a $5000 debt at the start of the game;
         * scenario 2 gives the player 5 guns.
         *
         */
        startButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (Start.getSelectedToggle() == cashChoice) {
                    setMoney(400);
                    setDebt(5000);
                    setGuns(0);
                }
                if (Start.getSelectedToggle() == gunChoice) {
                    setGuns(5);
                }

                String response = nameField.getText();
                // purely for testing purposes.
                if (response.equalsIgnoreCase("Vikram")) {
                    setMoney(999999999);
                    setBank(999999999);
                    setGuns(999);
                    setHP(99999999);
                    setCargoSpace(Integer.MAX_VALUE);
                }
                setFirm(response);

                TaipanShopGUI shop = new TaipanShopGUI(getPlayer());
                shop.initializeShop(stage);
                stage.show();
            }
        });

        continueButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                FileSaving saving = new FileSaving();
                if(saving.loadFile() != null){
                    TaipanShopGUI shop = new TaipanShopGUI(saving.loadFile());
                    shop.initializeShop(stage);
                    stage.show();
                }
                else{
                    authors.setText("There are no previous saves!");
                }
            }
        });

        Scene root = new Scene(borderPane, 600, 480);
        root.getStylesheets().add("styleguide.css");

        stage.setTitle("Start");
        stage.setResizable(false);
        stage.setScene(root);
        stage.setHeight(510);
        stage.setWidth(600);
        return stage;
    }
}
