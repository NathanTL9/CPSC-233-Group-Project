package gui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import logic.BankLogic;
import logic.Player;

/**
 * 2019-03-10
 * Authors: Siddhant Dewani
 * BankGUI allows the user to store cash and gain interest off of the cash
 */
public class BankGUI extends Player {

    /**
     * Class Constructor that takes in a type player as a parameter
     * @param player object of the class Player
     */
    public BankGUI(Player player) {
        Player playerDummy = new Player(player);
        setPlayer(playerDummy);
    }

    /**
     * Initializes the GUI for the Bank in our game.
     * @param primaryStage the stage in which everything in this class is shown
     * @return Returns the stage in which can be used by other stages
     */
    public void initializeBank(Stage primaryStage) {
        primaryStage.setTitle("Bank");

        /**
         * Creating all the layouts, labels, buttons, and a textfield.
         */
        BorderPane brdr1 = new BorderPane();
        HBox hbx1 = new HBox(30);
        HBox hbx2 = new HBox(30);
        VBox vbx1 = new VBox(30);

        Label l1 = new Label("Player:  " + getName());
        Label l2 = new Label("Balance: " + getBank());
        Label l3 = new Label("Enter Amount: ");
        Label l4 = new Label("Cash: " + getMoney());
        Label l5 = new Label(" ");

        Button b1 = new Button("Withdraw");
        Button b2 = new Button("Deposit");
        Button b3 = new Button("Go back");

        TextField txtField1 = new TextField();

        /**
         * Adds the buttons so that they are at the bottom of the screen.
         */
        hbx1.setAlignment(Pos.CENTER);
        hbx1.getChildren().add(b1);
        hbx1.getChildren().add(b2);
        hbx1.getChildren().add(b3);
        hbx1.setPadding(new Insets(0, 0, 20, 0));
        brdr1.setBottom(hbx1);

        /**
         * Adds the text field to the center of the screen.
         *
         */
        hbx2.setAlignment(Pos.CENTER);
        hbx2.getChildren().add(l3);
        hbx2.getChildren().add(txtField1);
        brdr1.setCenter(hbx2);

        /**
         * Adds the labels to the top of the screen.
         */
        vbx1.setAlignment(Pos.CENTER);
        vbx1.getChildren().add(l1);
        vbx1.getChildren().add(l2);
        vbx1.getChildren().add(l4);
        vbx1.getChildren().add(l5);
        vbx1.setPadding(new Insets(20, 0, 0, 0));
        brdr1.setTop(vbx1);

        /**
         * Adds function to button 1 which, when clicked, withdraws money from your bank to your person but, will not let you overdraw.
         */
        b1.setOnAction(new EventHandler<ActionEvent>() {
               @Override
               public void handle(ActionEvent event) {
                   withdraw(txtField1, l5, l2, l4);
               }
           }
        );

        /**
         * Adds function to button 2 which, when clicked, deposits money into your bank but, will not let you overdraw.
         *
         */
        // Set the event handler when the withdraw button is clicked
        b2.setOnAction(new EventHandler<ActionEvent>() {
               @Override
               public void handle(ActionEvent event) {
                   deposits(txtField1, l5, l2, l4);
               }
           }
        );

        /**
         * Adds function to button 3 which, when clicked, brings you back to the Shop GUI.
         *
         */
        b3.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                   TaipanShopGUI shopGUI = new TaipanShopGUI(getPlayer());
                   shopGUI.initializeShop(primaryStage);
                   primaryStage.show();
                }
            }
        );


        /**
         * Sets the window size to a width of 600 and height of 480 and displays the screen.
         */
        Scene scene = new Scene(brdr1, 600, 480);
        scene.getStylesheets().add("styleguide.css");
        primaryStage.setScene(scene);
    }

    /**
     * The deposit button within the scene above. Runs the deposit logic class when run
     * @param txtField1,l5,l2,l4 assigned from the original element inside of the JavaFX scene
     */
    private void deposits(TextField txtField1, Label l5, Label l2, Label l4) {
        try {
            int deposit = Integer.parseInt(txtField1.getText());
            if (deposit < 0) {
                l5.setText("Nice try! You can not enter negative numbers.");
            } else if (deposit <= getMoney()) {
                BankLogic bankLogic = new BankLogic(getPlayer());
                bankLogic.depositing(deposit);
                setPlayer(bankLogic.getPlayer());
            } else {
                l5.setText("Sorry, you can not deposit that much.");
            }
            l2.setText("Balance: " + getBank());
            l4.setText("Cash: " + getMoney());

        } catch (Exception e) {
            l5.setText("Please enter a valid response.");
        }
    }

    /**
     * The withdraw button within the scene above. Runs the withdraw logic class when run
     * @param txtField1,l5,l2,l4 assigned from the original element inside of the JavaFX scene
     */
    private void withdraw(TextField txtField1, Label l5, Label l2, Label l4) {
        try {
            int withdraw = Integer.parseInt(txtField1.getText());
            if (withdraw < 0) {
                l5.setText("Come on " + getName() + ", are you trying to fool me?\nNo negative numbers please!");
            } else if (withdraw <= getBank()) {
                BankLogic bankLogic = new BankLogic(getPlayer());
                bankLogic.withdrawing(withdraw);
                setPlayer(bankLogic.getPlayer());
            } else {
                l5.setText("Sorry, you can not withdraw that much.");
            }
            l2.setText("Balance: " + getBank());
            l4.setText("Cash: " + getMoney());
        } catch (Exception e) {
            l5.setText("Please enter a valid response.");
        }
    }
}
