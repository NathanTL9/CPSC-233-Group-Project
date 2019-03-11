import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class bankGUI{
    private Player player = new Player();
    /**
     * setter method that takes in a Player object as an argument.
     *
     * @param player object of the class Player
     */
    public void setPlayer(Player player) {
        Player playerDummy = new Player(player);
        this.player = playerDummy;
    }
    /**
     * getter method for obtaining a player object.
     *
     * @return returns player object
     */
    public Player getPlayer(){
        Player playerDummy = new Player(player);
        return playerDummy;
    }
    /**
     * Class Constructor that takes in a type player as a parameter
     *
     //* @param player object of the class Player
     */
    //public bankGUI(Player player){
    //    Player playerDummy = new Player(player);
    //    this.player = playerDummy;
    //}

    public Stage initializeBank(Stage primaryStage) {
        primaryStage.setTitle("Bank");

        //Declaring each Layout
        BorderPane brdr1 = new BorderPane();
        HBox hbx1 = new HBox(10);
        HBox hbx2 = new HBox(10);
        VBox vbx1 = new VBox(10);

        //Declaring all Variables
        Label l1 = new Label("Player:  " + player.getName());
        Label l2 = new Label("Current Balance: " + player.getBank());
        Label l3 = new Label("Enter Amount: ");
        Label l4 = new Label("Current cash: " + player.getMoney());
        Label l5 = new Label(" ");

        //Declaring All Buttons
        Button b1 = new Button("Withdraw");
        Button b2 = new Button("Deposit");
        Button b3 = new Button("Go back");

        //Declaring All TextFields
        TextField txtField1 = new TextField();

        //Creating the buttons at the bottom of the screen
        hbx1.setAlignment(Pos.CENTER);
        hbx1.getChildren().add(b1);
        hbx1.getChildren().add(b2);
        hbx1.getChildren().add(b3);

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
        brdr1.setTop(vbx1);

        // Set the event handler when the deposit button is clicked
        boolean keepGoing = true;
        b1.setOnAction(new EventHandler<ActionEvent>() {
                           @Override
                           public void handle(ActionEvent event) {
                               int withdraw = Integer.parseInt(txtField1.getText());
                               if(withdraw <= player.getBank()){
                                   player.setMoney(withdraw + player.getMoney());
                                   player.setBank(player.getBank()-withdraw);
                               }
                               else {
                                   l5.setText("Sorry you cannot withdraw that much");
                               }
                               l2.setText("Current Balance: " + player.getBank());
                               l4.setText("Current cash: " + player.getMoney());
                           }
                       }
        );

        // Set the event handler when the withdraw button is clicked
        b2.setOnAction(new EventHandler<ActionEvent>() {
                           @Override
                           public void handle(ActionEvent event) {
                               int deposit = Integer.parseInt(txtField1.getText());
                               if(deposit <= player.getMoney()){
                                   player.setBank(deposit + player.getBank());
                                   player.setMoney(player.getMoney()-deposit);
                               }
                               else{
                                   l5.setText("Sorry you cannot deposit that much");
                               }
                               l2.setText("Current Balance: " + player.getBank());
                               l4.setText("Current cash: " + player.getMoney());

                           }
                       }
        );

        b3.setOnAction(new EventHandler<ActionEvent>() {
               @Override
               public void handle(ActionEvent event) {
                   TaipanShopGUI shopGUI = new TaipanShopGUI(player);
                   shopGUI.initializeShop(primaryStage);
                   primaryStage.show();
               }
           }
        );



        //Setting the Scene and displaying it
        Scene scene = new Scene(brdr1, 600, 480);
        primaryStage.setScene(scene);
        //primaryStage.show();
        return primaryStage;
    }


    public void start(Stage primaryStage) {
        bankGUI bank = new bankGUI();
        bank.initializeBank(primaryStage);
        primaryStage.show();
    }
}
