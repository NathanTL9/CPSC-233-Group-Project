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

/**
 * 2019-03-10
 * Authors: Siddhant Dewani
 * LoanShark GUI Class allows the user to get a loan from the loan shark
 */

public class LoanSharkGUI extends Player {

    /**
     * Class Constructor that takes in a type player as a parameter
     *
     * @param player object of the class Player
     */
    public LoanSharkGUI(Player player) {
        Player playerDummy = new Player(player);
        setPlayer(playerDummy);
    }

    /**
     * This methods purpose is to loan the player the funds it wants
     * or pay its outstanding debts. The method prompts the user if they
     * would like to borrow money or repay. depending on what the player chooses
     * the corresponding loop is evoked. The player can only be loaned 2 times the
     * money they have minus the debt if their debt exceeds the cash balance, the loan
     * cannot be given.
     *
     * @param primaryStage the stage upon which the GUI will be imposed
     */
    public Stage initializeLoanShark(Stage primaryStage) {
        primaryStage.setTitle("Loan Shark");

        //Declaring each Layout
        BorderPane brdr1 = new BorderPane();
        HBox hbx1 = new HBox(10);
        HBox hbx2 = new HBox(10);
        VBox vbx1 = new VBox(10);

        //Declaring all Variables
        Label l1 = new Label("Player:  " + getName());
        Label l2 = new Label("Debt " + getDebt());
        Label l4 = new Label("Cash: " + getMoney());
        Label l3 = new Label("Enter Amount: ");
        Label l5 = new Label(" ");

        //Declaring All Buttons
        Button b1 = new Button("Borrow");
        Button b2 = new Button("Repay");
        Button b3 = new Button("Go back");

        //Declaring All TextFields
        TextField txtField1 = new TextField();

        //Creating the buttons at the bottom of the screen
        hbx1.setAlignment(Pos.CENTER);
        hbx1.getChildren().add(b1);
        hbx1.getChildren().add(b2);
        hbx1.getChildren().add(b3);
        hbx1.setPadding(new Insets(0,0,20,0));

        brdr1.setBottom(hbx1);


        //Creating the TextField at the center of the screen
        hbx2.setAlignment(Pos.CENTER);
        hbx2.getChildren().add(l3);
        hbx2.getChildren().add(txtField1);
        brdr1.setCenter(hbx2);

        //Creating the Labels at the top of the Screen
        vbx1.setAlignment(Pos.CENTER);
        vbx1.getChildren().add(l1);
        vbx1.getChildren().add(l2);
        vbx1.getChildren().add(l4);
        vbx1.getChildren().add(l5);
        vbx1.setPadding(new Insets(20,0,0,0));
        brdr1.setTop(vbx1);

        // Set the event handler when the deposit button is clicked
        b1.setOnAction(new EventHandler<ActionEvent>() {
                           @Override
                           public void handle(ActionEvent event) {
                               try {

                                   int loanAsk = Integer.parseInt(txtField1.getText());
                                   if (loanAsk <= 2 * (getMoney() - getDebt()) && loanAsk >= 0) {
                                       setDebt(getDebt() + loanAsk);
                                       setMoney(getMoney() + loanAsk);
                                       l4.setText("Cash: " + getMoney());
                                   } else if (loanAsk < 0) {
                                       l5.setText("Sorry you cannot enter negative numbers");
                                   }
                                   else{
                                       l5.setText("Sorry you cannot get the loan requested");
                                   }


                                   l2.setText("Debt: " + getDebt());
                               } catch (Exception e) {
                                   l5.setText("Please enter a valid value");
                               }

                           }
                       }

        );

        // Set the event handler when the withdraw button is clicked
        b2.setOnAction(new EventHandler<ActionEvent>() {
                           @Override
                           public void handle(ActionEvent event) {
                               try {


                                   int returnAsk = Integer.parseInt(txtField1.getText());
                                   if (returnAsk > getDebt()) {
                                       l5.setText("You do not need to return that much.");
                                   }
                                   else if (returnAsk <= getDebt() && returnAsk >= 0 && getMoney() >= returnAsk) {
                                       setDebt(getDebt() - returnAsk);
                                       setMoney(getMoney() - returnAsk);
                                       l4.setText("Cash: " + getMoney());
                                   }
                                   else if(getMoney() < returnAsk)  {
                                       l5.setText("Look " + getName() + ", you are being cheap!");
                                   }
                                   else  {
                                       l5.setText("Sorry, you can not return a negative amount!");
                                   }
                                   l2.setText("Debt: " + getDebt());
                               }
                               catch (Exception e) {
                                   l5.setText("Please enter a valid value");
                               }
                           }
                       }
        );

        b3.setOnAction(new EventHandler<ActionEvent>() {
                           @Override
                           public void handle(ActionEvent event) {
                               TaipanShopGUI shopGUI = new TaipanShopGUI(getPlayer());
                               shopGUI.initializeShop(primaryStage);
                               primaryStage.show();
                           }
                       }
        );


        //Setting the Scene and displaying it
        Scene scene = new Scene(brdr1, 600, 480);
        scene.getStylesheets().add("styleguide.css");
        primaryStage.setScene(scene);
        //primaryStage.show();
        return primaryStage;
    }


    public void start(Stage primaryStage) {
        LoanSharkGUI loan = new LoanSharkGUI(getPlayer());
        loan.initializeLoanShark(primaryStage);
        primaryStage.show();
    }
}





