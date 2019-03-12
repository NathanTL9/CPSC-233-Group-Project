import java.util.Scanner;

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
        Player playerDumy = new Player(player);
        this.player = playerDumy;
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
