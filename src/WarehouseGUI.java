import java.util.Scanner;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * A class that makes the GUI for the Warehouse class.
 *
 */
public class WarehouseGUI {

    private Player player;

    private Text title;
    private HBox hBox;
    private Button withdraw;
    private Button deposit;
    private Button goBack;
    private VBox vBox;
    private Text playerName;
    private Text text;
    private Label opiumPlayer;
    private Label silkPlayer;
    private Label armsPlayer;
    private Label generalPlayer;
    private VBox vBox0;
    private Text text0;
    private Text text1;
    private Text opiumWarehouse;
    private Text silkWarehouse;
    private Text armsWarehouse;
    private Text generalWarehouse;
    private VBox vBox1;
    private Text inUseWarehouse;
    private Text vacantWarehouse;
    private BorderPane borderPane;

    /**
     * A constructor that takes an object of type Player as an argument
     *
     * @param player object of the class Player
     */
    public WarehouseGUI(Player player) {
        Player playerDummy = new Player(player);
        this.player = playerDummy;
    }

    /**
     * Setter method for the Player object, player
     *
     * @param player an object of type Player
     */
    public void setPlayer(Player player) {
        Player playerDummy = new Player(player);
        this.player = playerDummy;
    }

    /**
     * Getter method for the Player object, player.
     *
     * @return returns a copy of the Player object, player
     */
    public Player getPlayer(){
        Player playerDummy = new Player(player);
        return playerDummy;
    }

    /**
     * initializes the GUI for the warehouse aspect of our game.
     *
     * @param stage an object of type Stage
     * @return returns the stage of the GUI
     */
    public Stage initializeWarehouse(Stage stage) {

        title = new Text();
        hBox = new HBox();
        withdraw = new Button();
        deposit = new Button();
        vBox = new VBox();
        playerName = new Text();
        text = new Text();
        opiumPlayer = new Label();
        silkPlayer = new Label();
        armsPlayer = new Label();
        generalPlayer = new Label();
        vBox0 = new VBox();
        text0 = new Text();
        text1 = new Text();
        opiumWarehouse = new Text();
        silkWarehouse = new Text();
        armsWarehouse = new Text();
        generalWarehouse = new Text();
        vBox1 = new VBox();
        inUseWarehouse = new Text();
        vacantWarehouse = new Text();
        borderPane = new BorderPane();

        /**
         * Sets the preferred width and height of the borderpane window to 600 by 480.
         *
         */
        borderPane.setPrefHeight(480.0);
        borderPane.setPrefWidth(600.0);

        /**
         * Creates a label "Hong Kong Warehouse: at the top of the borderpane.
         *
         */
        borderPane.setAlignment(title, javafx.geometry.Pos.CENTER);
        title.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        title.setStrokeWidth(0.0);
        title.setText("Hong Kong Warehouse");
        title.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        title.setWrappingWidth(393.63671875);
        title.setFont(new Font(24.0));
        borderPane.setTop(title);

        /**
         * creates an HBox at the center of the borderpane with a width of 200 and height of 100.
         *
         */
        borderPane.setAlignment(hBox, javafx.geometry.Pos.CENTER);
        hBox.setAlignment(javafx.geometry.Pos.CENTER);
        hBox.setPrefHeight(100.0);
        hBox.setPrefWidth(200.0);

        /**
         * Creates a button with text "Withdraw" which handles user events.
         *
         */
        withdraw.setContentDisplay(javafx.scene.control.ContentDisplay.CENTER);
        withdraw.setMnemonicParsing(false);
        withdraw.setPrefWidth(250.0);
        withdraw.setText("Withdraw");

        withdraw.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("hello");
            }
        });

        /**
         * Creates a button with text "Deposit" which handles user events.
         *
         */
        deposit.setMnemonicParsing(false);
        deposit.setPrefWidth(250.0);
        deposit.setText("Deposit");
        deposit.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        borderPane.setBottom(hBox);

        deposit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("hello");

            }
        });

        /**
         * Creates a button with text "Go Back" which handles user events.
         *
         */
        goBack.setMnemonicParsing(false);
        goBack.setPrefWidth(250.0);
        goBack.setText("Go Back");
        goBack.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        borderPane.setBottom(hBox);

        goBack.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("hello");

            }
        });

        /**
         * Creates a VBox at the left of the center of the borderpane with a width of 106 and a height of 156.
         *
         */
        borderPane.setAlignment(vBox, javafx.geometry.Pos.CENTER_LEFT);
        vBox.setPrefHeight(156.0);
        vBox.setPrefWidth(106.0);

        /**
         * Creates a label with text "Player" with size 18 font and default font style.
         *
         */
        playerName.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        playerName.setStrokeWidth(0.0);
        playerName.setText("Player");
        playerName.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        playerName.setWrappingWidth(103.47265625);
        playerName.setFont(new Font(18.0));

        /**
         * Creates a label with no text for aesthetic spacing purposes.
         *
         */
        text.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text.setStrokeWidth(0.0);
        text.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        text.setWrappingWidth(103.47265625);
        text.setFont(new Font(18.0));

        /**
         * Creates a label with text "Opium" under the "Player" label with size 18 font and default font style
         *
         */
        opiumPlayer.setAlignment(javafx.geometry.Pos.CENTER);
        opiumPlayer.setContentDisplay(javafx.scene.control.ContentDisplay.CENTER);
        opiumPlayer.setPrefWidth(100.0);
        opiumPlayer.setText("Opium");
        opiumPlayer.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        opiumPlayer.setFont(new Font(18.0));

        /**
         * Creates a label with text "Silk" under the "Player" label with size 18 font and default font style.
         *
         */
        silkPlayer.setAlignment(javafx.geometry.Pos.CENTER);
        silkPlayer.setPrefWidth(100.0);
        silkPlayer.setText("Silk");
        silkPlayer.setFont(new Font(18.0));

        /**
         * Creates a label with text "Arms" under the "Player" label with size 18 font and default font style.
         *
         */
        armsPlayer.setAlignment(javafx.geometry.Pos.CENTER);
        armsPlayer.setPrefWidth(100.0);
        armsPlayer.setText("Arms");
        armsPlayer.setFont(new Font(18.0));

        /**
         * Creates a label with text "General" under the "Player" label with size 18 font and default font style.
         *
         */
        generalPlayer.setAlignment(javafx.geometry.Pos.CENTER);
        generalPlayer.setPrefWidth(100.0);
        generalPlayer.setText("General");
        generalPlayer.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        generalPlayer.setFont(new Font(18.0));
        borderPane.setLeft(vBox);

        /**
         * Creates a VBox at the center of the borderpane with a width of 261 and a height of 343.
         *
         */
        BorderPane.setAlignment(vBox0, javafx.geometry.Pos.TOP_LEFT);
        vBox0.setAlignment(javafx.geometry.Pos.CENTER);
        vBox0.setPrefHeight(343.0);
        vBox0.setPrefWidth(261.0);

        /**
         * Creates a label with text "Warehouse" with size 18 font and default font style.
         *
         */
        text0.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text0.setStrokeWidth(0.0);
        text0.setText("Warehouse");
        text0.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        text0.setWrappingWidth(103.47265625);
        text0.setFont(new Font(18.0));

        /**
         * Creates a label with no text for aesthetic spacing purposes.
         *
         */
        text1.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text1.setStrokeWidth(0.0);
        text1.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        text1.setWrappingWidth(103.47265625);
        text1.setFont(new Font(18.0));

        /**
         * Creates a label with text "Opium" under the "Warehouse" label with size 18 font and default font style.
         *
         */
        opiumWarehouse.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        opiumWarehouse.setStrokeWidth(0.0);
        opiumWarehouse.setText("Opium");
        opiumWarehouse.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        opiumWarehouse.setWrappingWidth(103.47265625);
        opiumWarehouse.setFont(new Font(18.0));

        /**
         * Creates a label with text "Silk" under the "Warehouse" label with size 18 font and default font style.
         *
         */
        silkWarehouse.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        silkWarehouse.setStrokeWidth(0.0);
        silkWarehouse.setText("Silk");
        silkWarehouse.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        silkWarehouse.setWrappingWidth(103.47265625);
        silkWarehouse.setFont(new Font(18.0));

        /**
         * Creates a label with text "Arms" under the "Warehouse" label with size 18 font and default font style.
         *
         */
        armsWarehouse.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        armsWarehouse.setStrokeWidth(0.0);
        armsWarehouse.setText("Arms");
        armsWarehouse.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        armsWarehouse.setWrappingWidth(103.47265625);
        armsWarehouse.setFont(new Font(18.0));

        /**
         * Creates a label with text "General" under the "Warehouse" label with size 18 font and default font style.
         *
         */
        generalWarehouse.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        generalWarehouse.setStrokeWidth(0.0);
        generalWarehouse.setText("General");
        generalWarehouse.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        generalWarehouse.setWrappingWidth(103.47265625);
        generalWarehouse.setFont(new Font(18.0));
        borderPane.setCenter(vBox0);

        /**
         * Creates a VBox at the center of the borderpane with a width of 152 and a height of 48.
         *
         */
        borderPane.setAlignment(vBox1, javafx.geometry.Pos.CENTER);
        vBox1.setPrefHeight(48.0);
        vBox1.setPrefWidth(152.0);

        /**
         * Creates a label with "In use:" text with size 18 font and default font style.
         *
         */
        inUseWarehouse.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        inUseWarehouse.setStrokeWidth(0.0);
        inUseWarehouse.setText("In use:");
        inUseWarehouse.setFont(new Font(18.0));

        /**
         * Creates a label with "Vacant:" text with size 18 font and default font style.
         *
         */
        vacantWarehouse.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        vacantWarehouse.setStrokeWidth(0.0);
        vacantWarehouse.setText("Vacant:");
        vacantWarehouse.setFont(new Font(18.0));
        borderPane.setRight(vBox1);

        /**
         * Adds all the labels and buttons to their respective boxes.
         *
         */
        hBox.getChildren().add(withdraw);
        hBox.getChildren().add(deposit);
        vBox.getChildren().add(playerName);
        vBox.getChildren().add(text);
        vBox.getChildren().add(opiumPlayer);
        vBox.getChildren().add(silkPlayer);
        vBox.getChildren().add(armsPlayer);
        vBox.getChildren().add(generalPlayer);
        vBox0.getChildren().add(text0);
        vBox0.getChildren().add(text1);
        vBox0.getChildren().add(opiumWarehouse);
        vBox0.getChildren().add(silkWarehouse);
        vBox0.getChildren().add(armsWarehouse);
        vBox0.getChildren().add(generalWarehouse);
        vBox1.getChildren().add(inUseWarehouse);
        vBox1.getChildren().add(vacantWarehouse);

        Scene root = new Scene(borderPane, 600, 480);

        stage.setTitle("Warehouse");
        stage.setResizable(false);
        stage.setScene(root);
        return stage;
    }

    /**
     * When run, shows the stage as a graphical interface through JavaFX.
     *
     * @param primaryStage object of type Stage
     */
    public void start(Stage primaryStage) {
        WarehouseGUI warehouseGUI = new WarehouseGUI(player);
        warehouseGUI.initializeWarehouse(primaryStage);
        primaryStage.show();
    }

    /**
     * The purpose of this class is to create a warehouse where the goods
     * can be safely stored without holing space on the ship!
     */

    public class Warehouse {
        /*private int wOpium = 0;
        private int wSilk = 0;
        private int wGeneral = 0;
        private int wArms = 0;*/
        private Player player;

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

        public Player getPlayer() {
            Player playerDummy = new Player(player);
            return playerDummy;
        }

        /**
         * Class Constructor that takes in a type player as a parameter
         *
         * @param player object of the class Player
         */

        public Warehouse(Player player) {
            Player playerDummy = new Player(player);
            this.player = playerDummy;
        }

        /**
         * This method adds an amount of a certain good
         * the user is prompted to enter the amount they would like to
         * add followed by the good they would like to add to the warehouse.
         * the method checks if the player has sufficient goods to transfer, and if the player does
         * then the method executes the transfer
         *
         */
        public void addAmount() {
            boolean askGood = false;
            String amount;
            int finalAmount = 0;
            System.out.println("Please enter the amount of the good you would like to ADD.");
            Scanner keyboard = new Scanner(System.in);
            amount = keyboard.nextLine();//Asks the user for the amount of the good they would like to add
         /*The try function ensures that the program does not crash
         due to any errors while giving the program an incorrect input*/
            try {
                //The if statement checks that you have enough resources to make the transfer
                if (Integer.parseInt(amount) <= player.getOpiumHeld() || Integer.parseInt(amount) <= player.getSilkHeld() || Integer.parseInt(amount) <= player.getGeneralHeld() || Integer.parseInt(amount) <= player.getArmsHeld()) {
                    finalAmount = Integer.parseInt(amount);
                    askGood = true;
                }
                //Else statement lets the user know that they do not hav enough goods to make the requested transfer
                else {
                    System.out.println("Nice try but you don't have any items of that quantity!");
                    askGood = false;
                }
                //Ensures that goods are only transferred if they have the specified amount
                //The user is prompted to enter which good they want to transfer
                if (askGood == true) {
                    String good;
                    System.out.println("Please enter a good to transfer O, S, G, A :");
                    good = keyboard.nextLine();
                    int held = 0;
                    //The following set of loops check to see which good the user has selected and makes the transfer
                    if (Integer.parseInt(amount) > 0) {
                        if (good.equalsIgnoreCase("O")) {
                            if (player.getOpiumHeld() >= Integer.parseInt(amount)) {
                                player.setwOpium(player.getwOpium() + finalAmount);
                                held = player.getOpiumHeld();
                                player.setOpiumHeld(held - finalAmount);
                                System.out.println(player.getOpiumHeld());
                            } else {
                                System.out.println("You don't even have that much opium!");
                            }
                        } else if (good.equalsIgnoreCase("S")) {
                            if (player.getSilkHeld() >= Integer.parseInt(amount)) {
                                player.setwSilk(player.getwSilk() + finalAmount);
                                held = player.getSilkHeld();
                                player.setSilkHeld(held - finalAmount);
                            } else {
                                System.out.println("You don't even have that much silk!");

                            }
                        } else if (good.equalsIgnoreCase("G")) {
                            if (player.getGeneralHeld() >= Integer.parseInt(amount)) {
                                player.setwGeneral(player.getwGeneral() + finalAmount);
                                held = player.getGeneralHeld();
                                player.setGeneralHeld(held - finalAmount);
                            } else {
                                System.out.println("You don't even have that much general cargo!");

                            }
                        } else if (good.equalsIgnoreCase("A")) {
                            if (player.getArmsHeld() >= Integer.parseInt(amount)) {
                                player.setwArms(player.getwArms() + finalAmount);
                                held = player.getArmsHeld();
                                player.setArmsHeld(held - finalAmount);
                            } else {
                                System.out.println("You don't even have that much Arms!");
                            }
                        }
                    }
                    //Ensures no negative amounts are entered
                    else {
                        System.out.println("Sorry this transfer cannot be made");
                    }
                }
                //If the program errors out this is the message displayed and the method is re-run, so that the game does not end.
            } catch (Exception e) {
                System.out.println("Wait, that's not a valid input please try again");
            }
        }

        /**
         * This method removes an amount of a certain good
         * the user is prompted to enter the amount they would like to
         * remove followed by the good they would like to remove from the warehouse.
         * the method checks if the player has sufficient goods to transfer, and if the player does
         * then the method executes the transfer
         *
         */

        public void removeAmount() {
            String amount;
            boolean askGood = false;
            int finalAmount = 0;
            System.out.println("Please enter the amount of the good you would like to REMOVE");
            Scanner keyboard = new Scanner(System.in);
            //Prompts the user for the amount they would like to remove
            amount = keyboard.nextLine();
            //The if statement checks that you have enough resources to make the transfer
            try {
                //The if statement checks that you have enough resources to make the transfer
                if (Integer.parseInt(amount) <= player.getwOpium() || Integer.parseInt(amount) <= player.getwSilk() || Integer.parseInt(amount) <= player.getwGeneral() || Integer.parseInt(amount) <= player.getwArms()) {
                    finalAmount = Integer.parseInt(amount);
                    askGood = true;
                }
                //Else statement lets the user know that they do not hav enough goods to make the requested transfer
                else {
                    System.out.println("Nice try but you don't have any items of that quantity in the warehouse!");
                    askGood = false;
                }

                //Ensures that goods are only transferred if they have the specified amount
                //The user is prompted to enter which good they want to transfer

                if (askGood == true) {
                    String good;
                    System.out.println("Please enter a good to transfer O, S, G, A :");
                    good = keyboard.nextLine();
                    int held = 0;
                    //The following set of loops check to see which good the user has selected and makes the transfer and amount > 0
                    if (Integer.parseInt(amount) > 0) {
                        if (good.equalsIgnoreCase("O")) {
                            if (player.getwOpium() >= Integer.parseInt(amount)) {
                                player.setwOpium(player.getwOpium() - Integer.parseInt(amount));
                                held = player.getOpiumHeld();
                                player.setOpiumHeld(held + finalAmount);
                            } else {
                                System.out.println("You don't have that much opium stored in the warehouse!");
                            }
                        } else if (good.equalsIgnoreCase("S")) {
                            if (player.getwSilk() >= Integer.parseInt(amount)) {
                                player.setwSilk(player.getwSilk() - Integer.parseInt(amount));
                                held = player.getSilkHeld();
                                player.setSilkHeld(held + finalAmount);
                            } else {
                                System.out.println("You don't have that much silk stored in the warehouse!");
                            }
                        } else if (good.equalsIgnoreCase("G")) {
                            if (player.getwGeneral() >= Integer.parseInt(amount)) {
                                player.setwGeneral(player.getwGeneral() - Integer.parseInt(amount));
                                held = player.getGeneralHeld();
                                player.setGeneralHeld(held + finalAmount);
                            } else {
                                System.out.println("You don't have that much general cargo stored in the warehouse!");

                            }
                        } else if (good.equalsIgnoreCase("A")) {
                            if (player.getwArms() >= Integer.parseInt(amount)) {
                                player.setwArms(player.getwArms() - Integer.parseInt(amount));
                                held = player.getArmsHeld();
                                player.setArmsHeld(held + finalAmount);
                            } else {
                                System.out.println("You don't have that much arms stored in the warehouse!");

                            }
                        }
                    }
                    //Ensures the value entered is positive
                    else {
                        System.out.println("Sorry this transfer cannot be made");
                    }
                }
            }
            //If the program errors out this is the message displayed and the method is re-run, so that the game does not end.
            catch (Exception e){
                System.out.println("Wait, that's not a valid input please try again");
            }
        }

        /**
         * This method prints the stock that is in the warehouse currently using the get and set
         * methods from the player class. This is to allow the user to be able to know how much they have
         * stored in the warehouse
         */
        public void showWarehouse() {
            System.out.println("--------------------\nWarehouse\n--------------------");
            System.out.println("Opium : " + player.getwOpium());
            System.out.println("Silk : " + player.getwSilk());
            System.out.println("General : " + player.getwGeneral());
            System.out.println("Arms : " + player.getwArms());
        }

        /**
         * This method combines the add and remove methods and prompts the user to
         * enter what they would like to do. Add or remove and accordingly invokes
         * the required methods
         */
        public void changeWarehouse() {
            boolean keepGoing = true;
            while (keepGoing) {
                this.showWarehouse();
                String input = " ";
                System.out.println("Would you like to add(A) or remove(R) resources? ");
                Scanner keyboard = new Scanner(System.in);
                input = keyboard.next();
                if (input.equalsIgnoreCase("R")) {
                    this.removeAmount();
                    this.showWarehouse();
                } else if (input.equalsIgnoreCase("A")) {
                    this.addAmount();
                    this.showWarehouse();

                }
                else{
                    System.out.println("Don't waste the warehouse's time, try again later with a valid input");
                }

                String check;
                //Check to see if the player wants to continue in the warehouse or they are done
                System.out.println("Would you like to do any other business? Y / N?");
                check = keyboard.nextLine();
                check = keyboard.nextLine();

                if (check.equalsIgnoreCase("Y")) {
                    keepGoing = true;
                } else if (check.equalsIgnoreCase("N")) {
                    keepGoing = false;
                }
            }
        }

    }

}
