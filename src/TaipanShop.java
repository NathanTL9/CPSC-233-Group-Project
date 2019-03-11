import java.util.Random;
import java.util.Scanner;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
public class TaipanShop extends Application {

    public static void main(String args[]){
        launch(args);
    }
    public void start(Stage stage){
        stage.setTitle("Shop");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10,10,10,10));
        grid.setVgap(20);
        grid.setHgap(20);

        grid.add(new Label("Firm: "+ player.getName()), 2, 0);

        HBox warehouse = new HBox();
        warehouse.setSpacing(20);
        int itemsInWarehouse = player.getwOpium()+player.getwGeneral()+player.getwArms()+player.getwSilk();
        Label ware1 = new Label("Warehouse\n\tOpium\n\tSilk\n\tArms\n\tGeneral");
        Label ware2 = new Label("\n"+player.getwOpium()+"\n"+player.getwSilk()+"\n"+player.getwArms()+"\n"+player.getwGeneral());
        Label ware3 = new Label("\nIn use:\n " + itemsInWarehouse + "\nVacant:\n " + (10000 - itemsInWarehouse));
        warehouse.getChildren().addAll(ware1, ware2, new Label(), ware3);

        HBox inventory = new HBox();
        inventory.setSpacing(20);
        int itemsInInventory = player.getCargoSpace()-player.getSilkHeld()-player.getOpiumHeld()-player.getGeneralHeld()-player.getArmsHeld();
        Label inv1 = new Label("Hold "+itemsInInventory+"\n\tOpium\n\tSilk\n\tArms\n\tGeneral");
        Label inv2 = new Label("\n"+player.getOpiumHeld()+"\n"+player.getSilkHeld()+"\n"+player.getArmsHeld()+"\n"+player.getGeneralHeld());
        Label inv3 = new Label("Guns "+player.getGuns());
        inventory.getChildren().addAll(inv1, inv2, new Label(), inv3);

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

        grid.add(warehouse, 1, 1);
        grid.add(inventory, 1, 2);
        grid.add(new Label("\n\n\n Location\n"+location),3, 1 );
        grid.add(new Label("Debt\n"+player.getDebt()), 3, 2);

        Scene root = new Scene(grid, 600, 480);
        stage.setResizable(false);
        stage.setScene(root);
        stage.show();
    }

    private Player player;
    private int opiumPrice = 16000;
    private int silkPrice = 1600;
    private int armsPrice = 160;
    private int generalPrice = 8;

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
     * constructor; only runs when a Player object is provided. The constructor is fully encapsulated.
     *
     * @param player is a Player object that will be copied and the player instance variable is set to the copy.
     */
    public TaipanShop(Player player){
        Player playerDummy = new Player(player);
        this.player = playerDummy;
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
     * this method is evoked if the user has decided to travel elsewhere.
     */
    public void travel(){
        Travel travel = new Travel(player);
        travel.travelTo();
        player = travel.getPlayer();
    }

    /**
     * this method is evoked if the user wants to use the warehouse to store items or take items out.
     */
    public void warehouse(){
        Warehouse warehouse = new Warehouse(player);
        warehouse.changeWarehouse();
        player = warehouse.getPlayer();
    }

    /**
     * this method is evoked if the user wants to use the bank to deposit or withdraw money.
     */
    public void bank(){
        Bank bank = new Bank(player);
        bank.bank();
        player = bank.getPlayer();
    }

    /**
     * this method is evoked if the user wants to use get a loan or pay a loan off.
     */
    public void loan(){
        loanShark loan = new loanShark(player);
        loan.loanMoney();
        player = loan.getPlayer();
    }

    /**
     * this method is when the shop is accessed, randomizing the prices of all the items.
     */
    public void updatePrices(){
        String s = "\n" + player.getName() + ", the price of ";
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
                    System.out.println(s + "Opium has dropped to " + opiumPrice +"!!!\n");
                }else{
                    opiumPrice *= 5;
                    System.out.println(s + "Opium has risen to " + opiumPrice +"!!!\n");
                }
            }else if(value < 4){
                if(value < 3){
                    silkPrice /= 5;
                    System.out.println(s + "Silk has dropped to " + silkPrice +"!!!\n");
                }else{
                    silkPrice *= 5;
                    System.out.println(s + "Silk has risen to " + silkPrice +"!!!\n");
                }
            }else if(value < 6){
                if(value < 3){
                    armsPrice /= 5;
                    System.out.println(s + "Arms has dropped to " + armsPrice +"!!!\n");
                }else{
                    armsPrice *= 5;
                    System.out.println(s + "Arms has risen to " + armsPrice +"!!!\n");
                }
            }else{
                if(value < 7){
                    generalPrice = 1;
                    System.out.println(s + "General Cargo has dropped to 1!!!\n");
                }else{
                    generalPrice *= 5;
                    System.out.println(s + "General Cargo has risen to " + generalPrice + "!!!\n");
                }
            }
        }
    }

    /**
     * this method prints the shop UI and the player's inventory and status.
     */
    public void printShop(){
        int currentCargo = player.getOpiumHeld()+player.getGuns()*10+player.getSilkHeld()+player.getArmsHeld()+player.getGeneralHeld();
        if(player.getCargoSpace() - currentCargo < 0){
            System.out.println("Hold: Overloaded" + "          Guns: " + player.getGuns() + "          HP: " + player.getHP() +"%");
        }else{
            System.out.println("Hold: " + (player.getCargoSpace()-currentCargo) + "          Guns: " + player.getGuns() + "          HP: " + player.getHP() +"%");
        }
        System.out.println("-------------------------------------------------------------");
        System.out.println("     Opium: " + player.getOpiumHeld() + "      Silk: " + player.getSilkHeld());
        System.out.println("     Arms: " + player.getArmsHeld() + "       General: " + player.getGeneralHeld());
        System.out.println("-------------------------------------------------------------");
        System.out.println("Cash: " + player.getMoney() + "         Bank: " + player.getBank()+ "          Debt: " + player.getDebt()+"\n");
        System.out.println(player.getName() + ", present prices per unit here are:");
        System.out.println("     Opium: " + opiumPrice + "    Silk: " + silkPrice);
        System.out.println("     Arms: " + armsPrice + "       General: " + generalPrice);
    }

    /**
     * This method is evoked if the user is at the location one port.
     */
    public void atLocationOne(){
        boolean notDone = true;
        Scanner input = new Scanner(System.in);

        // as long as the user does not enter a valid input, the code will run in a loop forever.
        while(notDone){
            printShop();
            System.out.println("\nShall I Buy, Sell, Visit Bank, Get Loans, Transfer Cargo, or Quit Trading?");
            String response = input.next();
            if (response.equalsIgnoreCase("B")) {
                boolean notDone2 = true;
                System.out.println("What do you wish me to buy, " + player.getName() + "?");

                // when buying an item, the user must have the right amount of money, and buy non-negative amounts.
                while (notDone2) {
                    response = input.nextLine();
                    if (response.equalsIgnoreCase("O")) {
                        System.out.println("\nHow much Opium shall I buy, " + player.getName() + "? (You can afford " + player.getMoney() / opiumPrice + ")");
                        while (notDone2) {
                            int num = input.nextInt();
                            if (num <= player.getMoney() / opiumPrice && num >= 0) {
                                player.setOpiumHeld(player.getOpiumHeld()+num);
                                player.setMoney(player.getMoney()-num * opiumPrice);
                                notDone2 = false;
                            } else if (num >= 0) {
                                System.out.println(player.getName() + ", you can't afford that!");
                            } else {
                                System.out.println(player.getName() + ", how am I supposed to buy " + "'" + num + "'" + " Opium?");
                            }
                        }
                    } else if (response.equalsIgnoreCase("S")) {
                        System.out.println("\nHow much Silk shall I buy, " + player.getName() + "? (You can afford " + player.getMoney() / silkPrice + ")");
                        while (notDone2) {
                            int num = input.nextInt();
                            if (num <= player.getMoney() / silkPrice && num >= 0) {
                                player.setSilkHeld(player.getSilkHeld()+num);
                                player.setMoney(player.getMoney()-num * silkPrice);
                                notDone2 = false;
                            } else if (num >= 0) {
                                System.out.println(player.getName() + ", you can't afford that!");
                            } else {
                                System.out.println(player.getName() + ", how am I supposed to buy " + "'" + num + "'" + " Silk?");
                            }
                        }
                    } else if (response.equalsIgnoreCase("A")) {
                        System.out.println("\nHow many Arms shall I buy, " + player.getName() + "? (You can afford " + player.getMoney() / armsPrice + ")");
                        while (notDone2) {
                            int num = input.nextInt();
                            if (num <= player.getMoney() / armsPrice && num >= 0) {
                                player.setArmsHeld(player.getArmsHeld()+num);
                                player.setMoney(player.getMoney() - num*armsPrice);
                                notDone2 = false;
                            } else if (num >= 0) {
                                System.out.println(player.getName() + ", you can't afford that!");
                            } else {
                                System.out.println(player.getName() + ", how am I supposed to buy " + "'" + num + "'" + " Arms?");
                            }
                        }
                    } else if (response.equalsIgnoreCase("G")) {
                        System.out.println("\nHow much General Cargo shall I buy, " + player.getName() + "? (You can afford " + player.getMoney() / generalPrice + ")");
                        while (notDone2) {
                            int num = input.nextInt();
                            if (num <= player.getMoney() / generalPrice && num >= 0) {
                                player.setGeneralHeld(player.getGeneralHeld()+num);
                                player.setMoney(player.getMoney() - num*generalPrice);
                                notDone2 = false;
                            } else if (num >= 0) {
                                System.out.println(player.getName() + ", you can't afford that!");
                            } else {
                                System.out.println(player.getName() + ", how am I supposed to buy " + "'" + num + "'" + " General Cargo?");
                            }
                        }
                    }

                }

            } // when selling, the user must enter a non-negative amount of items, and not more than what they have.
            else if (response.equalsIgnoreCase("S")) {
                boolean notDone2 = true;
                System.out.println("What do you wish me to sell, " + player.getName() + "?");
                while (notDone2) {
                    response = input.nextLine();
                    if (response.equalsIgnoreCase("O")) {
                        System.out.println("\nHow much Opium shall I sell, " + player.getName() + "? (You have " + player.getOpiumHeld() + ")");
                        while (notDone2) {
                            int num = input.nextInt();
                            if (num <= player.getOpiumHeld() && num >= 0) {
                                player.setOpiumHeld(player.getOpiumHeld()-num);
                                player.setMoney(player.getMoney() + num*opiumPrice);
                                notDone2 = false;
                            } else if (num >= 0) {
                                System.out.println(player.getName() + ", you don't have that many to sell!");
                            } else {
                                System.out.println(player.getName() + ", how am I supposed to sell " + "'" + num + "'" + " Opium?");
                            }
                        }
                    } else if (response.equalsIgnoreCase("S")) {
                        System.out.println("\nHow much Silk shall I sell, " + player.getName() + "? (You have " + player.getSilkHeld() + ")");
                        while (notDone2) {
                            int num = input.nextInt();
                            if (num <= player.getSilkHeld() && num >= 0) {
                                player.setSilkHeld(player.getSilkHeld()-num);
                                player.setMoney(player.getMoney() + num*silkPrice);
                                notDone2 = false;
                            } else if (num >= 0) {
                                System.out.println(player.getName() + ", you don't have that many to sell!");
                            } else {
                                System.out.println(player.getName() + ", how am I supposed to sell " + "'" + num + "'" + " Silk?");
                            }
                        }
                    } else if (response.equalsIgnoreCase("A")) {
                        System.out.println("\nHow many Arms shall I sell, " + player.getName() + "? (You have " + player.getArmsHeld() + ")");
                        while (notDone2) {
                            int num = input.nextInt();
                            if (num <= player.getArmsHeld() && num >= 0) {
                                player.setArmsHeld(player.getArmsHeld()-num);
                                player.setMoney(player.getMoney() + num*armsPrice);
                                notDone2 = false;
                            } else if (num >= 0) {
                                System.out.println(player.getName() + ", you don't have that many to sell!");
                            } else {
                                System.out.println(player.getName() + ", how am I supposed to sell " + "'" + num + "'" + " Arms?");
                            }
                        }
                    } else if (response.equalsIgnoreCase("G")) {
                        System.out.println("\nHow much General Cargo shall I sell, " + player.getName() + "? (You have " + player.getGeneralHeld() + ")");
                        while (notDone2) {
                            int num = input.nextInt();
                            if (num <= player.getGeneralHeld() && num >= 0) {
                                player.setGeneralHeld(player.getGeneralHeld()-num);
                                player.setMoney(player.getMoney() + num*generalPrice);
                                notDone2 = false;
                            } else if (num >= 0) {
                                System.out.println(player.getName() + ", you don't have that many to sell!");
                            } else {
                                System.out.println(player.getName() + ", how am I supposed to sell " + "'" + num + "'" + " General Cargo?");
                            }
                        }
                    }

                }

            } else if (response.equalsIgnoreCase("V")) {
                bank();
            } else if (response.equalsIgnoreCase("T")) {
                warehouse();
            }else if (response.equalsIgnoreCase("G")||response.equalsIgnoreCase("L")) {
                loan();
            } // if the user wishes to quit trading, they may do so. Doing this breaks them out of the loop.
            else if (response.equalsIgnoreCase("Q")) {
                travel();
                notDone = false;
            }
        }
    }

    /**
     * This method is evoked when the user is at any port other than location one.
     */
    public void notAtLocationOne(){
        boolean notDone = true;
        Scanner input = new Scanner(System.in);

        // as long as the user does not enter a valid input, the code will run in a loop forever.
        while(notDone){
            printShop();
            System.out.println("\nShall I Buy, Sell, or Quit Trading?");
            String response = input.next();
            if (response.equalsIgnoreCase("B")) {
                boolean notDone2 = true;
                System.out.println("What do you wish me to buy, " + player.getName() + "?");

                // when buying an item, the user must have the right amount of money, and buy non-negative amounts.
                while (notDone2) {
                    response = input.nextLine();
                    if (response.equalsIgnoreCase("O")) {
                        System.out.println("\nHow much Opium shall I buy, " + player.getName() + "? (You can afford " + player.getMoney() / opiumPrice + ")");
                        while (notDone2) {
                            int num = input.nextInt();
                            if (num <= player.getMoney() / opiumPrice && num >= 0) {
                                player.setOpiumHeld(player.getOpiumHeld()+num);
                                player.setMoney(player.getMoney() - num*opiumPrice);
                                notDone2 = false;
                            } else if (num >= 0) {
                                System.out.println(player.getName() + ", you can't afford that!");
                            } else {
                                System.out.println(player.getName() + ", how am I supposed to buy " + "'" + num + "'" + " Opium?");
                            }
                        }
                    } else if (response.equalsIgnoreCase("S")) {
                        System.out.println("\nHow much Silk shall I buy, " + player.getName() + "? (You can afford " + player.getMoney() / silkPrice + ")");
                        while (notDone2) {
                            int num = input.nextInt();
                            if (num <= player.getMoney() / silkPrice && num >= 0) {
                                player.setSilkHeld(player.getSilkHeld()+num);
                                player.setMoney(player.getMoney() - num*silkPrice);
                                notDone2 = false;
                            } else if (num >= 0) {
                                System.out.println(player.getName() + ", you can't afford that!");
                            } else {
                                System.out.println(player.getName() + ", how am I supposed to buy " + "'" + num + "'" + " Silk?");
                            }
                        }
                    } else if (response.equalsIgnoreCase("A")) {
                        System.out.println("\nHow many Arms shall I buy, " + player.getName() + "? (You can afford " + player.getMoney() / armsPrice + ")");
                        while (notDone2) {
                            int num = input.nextInt();
                            if (num <= player.getMoney() / armsPrice && num >= 0) {
                                player.setArmsHeld(player.getArmsHeld()+num);
                                player.setMoney(player.getMoney() - num*armsPrice);
                                notDone2 = false;
                            } else if (num >= 0) {
                                System.out.println(player.getName() + ", you can't afford that!");
                            } else {
                                System.out.println(player.getName() + ", how am I supposed to buy " + "'" + num + "'" + " Arms?");
                            }
                        }
                    } else if (response.equalsIgnoreCase("G")) {
                        System.out.println("\nHow much General Cargo shall I buy, " + player.getName() + "? (You can afford " + player.getMoney() / generalPrice + ")");
                        while (notDone2) {
                            int num = input.nextInt();
                            if (num <= player.getMoney() / generalPrice && num >= 0) {
                                player.setGeneralHeld(player.getGeneralHeld()+num);
                                player.setMoney(player.getMoney() - num*generalPrice);
                                notDone2 = false;
                            } else if (num >= 0) {
                                System.out.println(player.getName() + ", you can't afford that!");
                            } else {
                                System.out.println(player.getName() + ", how am I supposed to buy " + "'" + num + "'" + " General Cargo?");
                            }
                        }
                    }

                }

            } // when selling, the user must enter a non-negative amount of items, and not more than what they have.
            else if (response.equalsIgnoreCase("S")) {
                boolean notDone2 = true;
                System.out.println("What do you wish me to sell, " + player.getName() + "?");
                while (notDone2) {
                    response = input.nextLine();
                    if (response.equalsIgnoreCase("O")) {
                        System.out.println("\nHow much Opium shall I sell, " + player.getName() + "? (You have " + player.getOpiumHeld() + ")");
                        while (notDone2) {
                            int num = input.nextInt();
                            if (num <= player.getOpiumHeld() && num >= 0) {
                                player.setOpiumHeld(player.getOpiumHeld()-num);
                                player.setMoney(player.getMoney() + num*opiumPrice);
                                notDone2 = false;
                            } else if (num >= 0) {
                                System.out.println(player.getName() + ", you don't have that many to sell!");
                            } else {
                                System.out.println(player.getName() + ", how am I supposed to sell " + "'" + num + "'" + " Opium?");
                            }
                        }
                    } else if (response.equalsIgnoreCase("S")) {
                        System.out.println("\nHow much Silk shall I sell, " + player.getName() + "? (You have " + player.getSilkHeld() + ")");
                        while (notDone2) {
                            int num = input.nextInt();
                            if (num <= player.getSilkHeld() && num >= 0) {
                                player.setSilkHeld(player.getSilkHeld()-num);
                                player.setMoney(player.getMoney() + num*silkPrice);
                                notDone2 = false;
                            } else if (num >= 0) {
                                System.out.println(player.getName() + ", you don't have that many to sell!");
                            } else {
                                System.out.println(player.getName() + ", how am I supposed to sell " + "'" + num + "'" + " Silk?");
                            }
                        }
                    } else if (response.equalsIgnoreCase("A")) {
                        System.out.println("\nHow many Arms shall I sell, " + player.getName() + "? (You have " + player.getArmsHeld() + ")");
                        while (notDone2) {
                            int num = input.nextInt();
                            if (num <= player.getArmsHeld() && num >= 0) {
                                player.setArmsHeld(player.getArmsHeld()-num);
                                player.setMoney(player.getMoney() + num*armsPrice);
                                notDone2 = false;
                            } else if (num >= 0) {
                                System.out.println(player.getName() + ", you don't have that many to sell!");
                            } else {
                                System.out.println(player.getName() + ", how am I supposed to sell " + "'" + num + "'" + " Arms?");
                            }
                        }
                    } else if (response.equalsIgnoreCase("G")) {
                        System.out.println("\nHow much General Cargo shall I sell, " + player.getName() + "? (You have " + player.getGeneralHeld() + ")");
                        while (notDone2) {
                            int num = input.nextInt();
                            if (num <= player.getGeneralHeld() && num >= 0) {
                                player.setGeneralHeld(player.getGeneralHeld()-num);
                                player.setMoney(player.getMoney() + num*generalPrice);
                                notDone2 = false;
                            } else if (num >= 0) {
                                System.out.println(player.getName() + ", you don't have that many to sell!");
                            } else {
                                System.out.println(player.getName() + ", how am I supposed to sell " + "'" + num + "'" + " General Cargo?");
                            }
                        }
                    }
                }
            } // if the user wishes to quit trading, they may do so. Doing this breaks them out of the loop.
            else if (response.equalsIgnoreCase("Q")) {
                travel();
                notDone = false;
            }
        }
    }

    /**
     * this method is run if the user is eligible to win, and is at location one.
     */
    public void retireAndLocationOne(){
        boolean notDone = true;
        Scanner input = new Scanner(System.in);

        // as long as the user does not enter a valid input, the code will run in a loop forever.
        while(notDone){
            printShop();
            System.out.println("\nShall I Buy, Sell, Visit Bank, Transfer Cargo, Get Loans, Retire, or Quit Trading?");
            String response = input.next();
            if (response.equalsIgnoreCase("B")) {
                boolean notDone2 = true;
                System.out.println("What do you wish me to buy, " + player.getName() + "?");

                // when buying an item, the user must have the right amount of money, and buy non-negative amounts.
                while (notDone2) {
                    response = input.nextLine();
                    if (response.equalsIgnoreCase("O")) {
                        System.out.println("\nHow much Opium shall I buy, " + player.getName() + "? (You can afford " + player.getMoney() / opiumPrice + ")");
                        while (notDone2) {
                            int num = input.nextInt();
                            if (num <= player.getMoney() / opiumPrice && num >= 0) {
                                player.setOpiumHeld(player.getOpiumHeld()+num);
                                player.setMoney(player.getMoney()-num * opiumPrice);
                                notDone2 = false;
                            } else if (num >= 0) {
                                System.out.println(player.getName() + ", you can't afford that!");
                            } else {
                                System.out.println(player.getName() + ", how am I supposed to buy " + "'" + num + "'" + " Opium?");
                            }
                        }
                    } else if (response.equalsIgnoreCase("S")) {
                        System.out.println("\nHow much Silk shall I buy, " + player.getName() + "? (You can afford " + player.getMoney() / silkPrice + ")");
                        while (notDone2) {
                            int num = input.nextInt();
                            if (num <= player.getMoney() / silkPrice && num >= 0) {
                                player.setSilkHeld(player.getSilkHeld()+num);
                                player.setMoney(player.getMoney()-num * silkPrice);
                                notDone2 = false;
                            } else if (num >= 0) {
                                System.out.println(player.getName() + ", you can't afford that!");
                            } else {
                                System.out.println(player.getName() + ", how am I supposed to buy " + "'" + num + "'" + " Silk?");
                            }
                        }
                    } else if (response.equalsIgnoreCase("A")) {
                        System.out.println("\nHow many Arms shall I buy, " + player.getName() + "? (You can afford " + player.getMoney() / armsPrice + ")");
                        while (notDone2) {
                            int num = input.nextInt();
                            if (num <= player.getMoney() / armsPrice && num >= 0) {
                                player.setArmsHeld(player.getArmsHeld()+num);
                                player.setMoney(player.getMoney() - num*armsPrice);
                                notDone2 = false;
                            } else if (num >= 0) {
                                System.out.println(player.getName() + ", you can't afford that!");
                            } else {
                                System.out.println(player.getName() + ", how am I supposed to buy " + "'" + num + "'" + " Arms?");
                            }
                        }
                    } else if (response.equalsIgnoreCase("G")) {
                        System.out.println("\nHow much General Cargo shall I buy, " + player.getName() + "? (You can afford " + player.getMoney() / generalPrice + ")");
                        while (notDone2) {
                            int num = input.nextInt();
                            if (num <= player.getMoney() / generalPrice && num >= 0) {
                                player.setGeneralHeld(player.getGeneralHeld()+num);
                                player.setMoney(player.getMoney() - num*generalPrice);
                                notDone2 = false;
                            } else if (num >= 0) {
                                System.out.println(player.getName() + ", you can't afford that!");
                            } else {
                                System.out.println(player.getName() + ", how am I supposed to buy " + "'" + num + "'" + " General Cargo?");
                            }
                        }
                    }
                }

            } // when selling, the user must enter a non-negative amount of items, and not more than what they have.
            else if (response.equalsIgnoreCase("S")) {
                boolean notDone2 = true;
                System.out.println("What do you wish me to sell, " + player.getName() + "?");
                while (notDone2) {
                    response = input.nextLine();
                    if (response.equalsIgnoreCase("O")) {
                        System.out.println("\nHow much Opium shall I sell, " + player.getName() + "? (You have " + player.getOpiumHeld() + ")");
                        while (notDone2) {
                            int num = input.nextInt();
                            if (num <= player.getOpiumHeld() && num >= 0) {
                                player.setOpiumHeld(player.getOpiumHeld()-num);
                                player.setMoney(player.getMoney() + num*opiumPrice);
                                notDone2 = false;
                            } else if (num >= 0) {
                                System.out.println(player.getName() + ", you don't have that many to sell!");
                            } else {
                                System.out.println(player.getName() + ", how am I supposed to sell " + "'" + num + "'" + " Opium?");
                            }
                        }
                    } else if (response.equalsIgnoreCase("S")) {
                        System.out.println("\nHow much Silk shall I sell, " + player.getName() + "? (You have " + player.getSilkHeld() + ")");
                        while (notDone2) {
                            int num = input.nextInt();
                            if (num <= player.getSilkHeld() && num >= 0) {
                                player.setSilkHeld(player.getSilkHeld()-num);
                                player.setMoney(player.getMoney() + num*silkPrice);
                                notDone2 = false;
                            } else if (num >= 0) {
                                System.out.println(player.getName() + ", you don't have that many to sell!");
                            } else {
                                System.out.println(player.getName() + ", how am I supposed to sell " + "'" + num + "'" + " Silk?");
                            }
                        }
                    } else if (response.equalsIgnoreCase("A")) {
                        System.out.println("\nHow many Arms shall I sell, " + player.getName() + "? (You have " + player.getArmsHeld() + ")");
                        while (notDone2) {
                            int num = input.nextInt();
                            if (num <= player.getArmsHeld() && num >= 0) {
                                player.setArmsHeld(player.getArmsHeld()-num);
                                player.setMoney(player.getMoney() + num*armsPrice);
                                notDone2 = false;
                            } else if (num >= 0) {
                                System.out.println(player.getName() + ", you don't have that many to sell!");
                            } else {
                                System.out.println(player.getName() + ", how am I supposed to sell " + "'" + num + "'" + " Arms?");
                            }
                        }
                    } else if (response.equalsIgnoreCase("G")) {
                        System.out.println("\nHow much General Cargo shall I sell, " + player.getName() + "? (You have " + player.getGeneralHeld() + ")");
                        while (notDone2) {
                            int num = input.nextInt();
                            if (num <= player.getGeneralHeld() && num >= 0) {
                                player.setGeneralHeld(player.getGeneralHeld()-num);
                                player.setMoney(player.getMoney() + num*generalPrice);
                                notDone2 = false;
                            } else if (num >= 0) {
                                System.out.println(player.getName() + ", you don't have that many to sell!");
                            } else {
                                System.out.println(player.getName() + ", how am I supposed to sell " + "'" + num + "'" + " General Cargo?");
                            }
                        }
                    }

                }

            } else if (response.equalsIgnoreCase("V")) {
                bank();
            } else if (response.equalsIgnoreCase("T")) {
                warehouse();
            } else if (response.equalsIgnoreCase("G")||response.equalsIgnoreCase("L")) {
                loan();
            } // if the user wishes to quit trading, they may do so. Doing this breaks them out of the loop.
            else if (response.equalsIgnoreCase("Q")) {
                travel();
                notDone = false;
            } // if the user wishes to retire and win the game, they may do so. Doing this breaks them out of the loop.
            else if (response.equalsIgnoreCase("R")) {
                retire();
                notDone = false;
            }
        }
    }

    /**
     * the general method that utilizes all the other methods to form a fully functioning shop.
     */
    public void shop() {
        updatePrices();

        // first case is triggered if the user is at location one, and has less than $1 million net worth
        if (player.getLocation() == 1 && player.getBank()+player.getMoney()-player.getDebt() < 1000000) {
            atLocationOne();
        } // the second case is triggered if the user is at a location other than location one.
        else if(player.getLocation() != 1) {
            notAtLocationOne();
        } // the last case is triggered when the other conditions are not met; it is triggered when the user has a net
        // worth that is greater than or equal to $1 million and is at location one.
        else{
            retireAndLocationOne();
        }
    }
}
