package text;

import logic.Player;
import logic.WarehouseLogic;

import java.util.Scanner;

public class WarehouseText extends Player {

    public WarehouseText(Player player) {
        Player playerDummy = new Player(player);
        setPlayer(playerDummy);
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
        Scanner keyboard = new Scanner(System.in);

        System.out.println("Please enter the amount of the good you would like to deposit.");
        String amount = keyboard.nextLine();
        //Asks the user for the amount of the good they would like to add
         /*The try function ensures that the program does not crash
         due to any errors while giving the program an incorrect input*/
        System.out.println("Please enter a good to transfer O, S, A, G :");
        String good = keyboard.nextLine();
        WarehouseLogic warehouseLogic = new WarehouseLogic(getPlayer());
        if(good.equalsIgnoreCase("g")){
            System.out.println(warehouseLogic.deposit(amount,1));
        }
        else if(good.equalsIgnoreCase("a")){
            System.out.println(warehouseLogic.deposit(amount,2));
        }
        else if(good.equalsIgnoreCase("s")){
            System.out.println(warehouseLogic.deposit(amount,3));
        }
        else if(good.equalsIgnoreCase("o")){
            System.out.println(warehouseLogic.deposit(amount,4));
        }
        setPlayer(warehouseLogic.getPlayer());
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
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Please enter the amount of the good you would like to withdraw.");
        String amount = keyboard.nextLine();
        //Asks the user for the amount of the good they would like to withdraw
         /*The try function ensures that the program does not crash
         due to any errors while giving the program an incorrect input*/
        System.out.println("Please enter a good to withdraw (O)pium, (S)ilk, (A)rms, (G)eneral:");
        String good = keyboard.nextLine();
        WarehouseLogic warehouseLogic = new WarehouseLogic(getPlayer());
        if(good.equalsIgnoreCase("g")){
            System.out.println(warehouseLogic.withdraw(amount,1));
        }
        else if(good.equalsIgnoreCase("a")){
            System.out.println(warehouseLogic.withdraw(amount,2));
        }
        else if(good.equalsIgnoreCase("s")){
            System.out.println(warehouseLogic.withdraw(amount,3));
        }
        else if(good.equalsIgnoreCase("o")){
            System.out.println(warehouseLogic.withdraw(amount,4));
        }
        setPlayer(warehouseLogic.getPlayer());
    }

    /**
     * This method prints the stock that is in the warehouse currently using the get and set
     * methods from the player class. This is to allow the user to be able to know how much they have
     * stored in the warehouse
     */
    public void showWarehouse() {
        System.out.println("--------------------\nWarehouse\n--------------------");
        System.out.println("Opium : " + getwOpium());
        System.out.println("Silk : " + getwSilk());
        System.out.println("General : " + getwGeneral());
        System.out.println("Arms : " + getwArms());
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
            System.out.println("Would you like to (D)eposit or (W)ithdraw resources? ");
            Scanner keyboard = new Scanner(System.in);
            String input = keyboard.next();
            if (input.equalsIgnoreCase("D")) {
                this.addAmount();
                this.showWarehouse();
            } else if (input.equalsIgnoreCase("W")) {
                this.removeAmount();
                this.showWarehouse();
            }
            else{
                System.out.println("Don't waste the warehouse's time, try again later with a valid input");
            }

            //Check to see if the player wants to continue in the warehouse or they are done
            System.out.println("Would you like to do any other business? Y / N?");
            String check = keyboard.nextLine();
            check = keyboard.nextLine();

            if (check.equalsIgnoreCase("Y")) {
                keepGoing = true;
            } else if (check.equalsIgnoreCase("N")) {
                keepGoing = false;
            }
        }
    }
}
