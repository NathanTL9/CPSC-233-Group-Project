package text;

import java.util.Scanner;

import logic.Player;
import logic.TaipanShopLogic;

/**
 * TaipanShopText deals with the text based version of the shop.
 *
 * Author: Vikram Bawa
 */
public class TaipanShopText extends Player {
    /**
     * This method is evoked if the user is eligible to win, and chooses to end the game (by winning).
     */
    public void retire(){
        setRetire(true);
        System.out.println("You win!");
        System.exit(0);
    }

    /**
     * constructor; only runs when a Player object is provided. The constructor is fully encapsulated.
     *
     * @param player is a Player object that will be copied and the player instance variable is set to the copy.
     */
    public TaipanShopText(Player player){
        Player playerDummy = new Player(player);
        setPlayer(playerDummy);
    }

    /**
     * this method is evoked if the user has decided to travel elsewhere.
     */
    public void travel(){
        TravelText travel = new TravelText(getPlayer());
        travel.travelTo();
        setPlayer(travel.getPlayer());
    }

    /**
     * this method is evoked if the user wants to use the warehouse to store items or take items out.
     */
    public void warehouse(){
        WarehouseText warehouse = new WarehouseText(getPlayer());
        warehouse.changeWarehouse();
        setPlayer(warehouse.getPlayer());
    }

    /**
     * this method is evoked if the user wants to use the bank to deposit or withdraw money.
     */
    public void bank(){
        BankText bank = new BankText(getPlayer());
        bank.bank();
        setPlayer(bank.getPlayer());
    }

    /**
     * this method is evoked if the user wants to use get a loan or pay a loan off.
     */
    public void loan(){
        loanSharkText loan = new loanSharkText(getPlayer());
        loan.loanMoney();
        setPlayer(loan.getPlayer());
    }


    /**
     * this method prints the shop UI and the player's inventory and status.
     */
    public void printShop(){
        int currentCargo = getOpiumHeld()+getGuns()*10+getSilkHeld()+getArmsHeld()+getGeneralHeld();
        if(getCargoSpace() - currentCargo < 0){
            System.out.println("Hold: Overloaded" + "          Guns: " + getGuns() + "          HP: " + getHP() +"%");
        }else{
            System.out.println("Hold: " + (getCargoSpace()-currentCargo) + "          Guns: " + getGuns() + "          HP: " + getHP() +"%");
        }
        System.out.println("-------------------------------------------------------------");
        System.out.println("     Opium: " + getOpiumHeld() + "      Silk: " + getSilkHeld());
        System.out.println("     Arms: " + getArmsHeld() + "       General: " + getGeneralHeld());
        System.out.println("-------------------------------------------------------------");
        System.out.println("Cash: " + getMoney() + "         Bank: " + getBank()+ "          Debt: " + getDebt()+"\n");
        System.out.println(getName() + ", present prices per unit here are:");
        System.out.println("     Opium: " + getOpiumPrice() + "    Silk: " + getSilkPrice());
        System.out.println("     Arms: " + getArmsPrice() + "       General: " + getGeneralPrice());
    }

    /**
     * this is the shop method. Activates the shopping screen.
     */
    public void shop(){
        TaipanShopLogic logic = new TaipanShopLogic(getPlayer());
        System.out.println(logic.updatePrices());
        setPlayer(logic.getPlayer());

        boolean notDone = true;
        int caseNum;
        String optionText;

        // first case is triggered if the user is at location one, and has less than $1 million net worth
        if (getLocation() == 1 && getBank()+getMoney()-getDebt() < 1000000) {
            caseNum = 1;
            optionText = " Visit Bank, Transfer Cargo, Get Loans,";
        } // the second case is triggered if the user is at a location other than location one.
        else if(getLocation() != 1) {
            caseNum = 2;
            optionText = "";
        } // the last case is triggered when the other conditions are not met; it is triggered when the user has a net
        // worth that is greater than or equal to $1 million and is at location one.
        else{
            caseNum = 3;
            optionText = " Visit Bank, Transfer Cargo, Get Loans, Retire,";
        }

        Scanner input = new Scanner(System.in);

        // as long as the user does not enter a valid input, the code will run in a loop forever.
        while(notDone){
            printShop();
            System.out.printf("\nShall I Buy, Sell,%s or Quit Trading?\n", optionText);
            String response = input.next();
            if (response.equalsIgnoreCase("B")) {
                boolean notDone2 = true;
                System.out.println("What do you wish me to buy, " + getName() + "?");

                // when buying an item, the user must have the right amount of money, and buy non-negative amounts.
                while (notDone2) {
                    response = input.nextLine();
                    if (response.equalsIgnoreCase("O")) {
                        System.out.println("\nHow much Opium shall I buy, " + getName() + "? (You can afford " + getMoney() / getOpiumPrice() + ")");
                        while (notDone2) {
                            int num = input.nextInt();
                            if (num <= getMoney() /getOpiumPrice() && num >= 0) {
                                setOpiumHeld(getOpiumHeld()+num);
                                setMoney(getMoney()-num *getOpiumPrice());
                                notDone2 = false;
                            } else if (num >= 0) {
                                System.out.println(getName() + ", you can't afford that!");
                            } else {
                                System.out.println(getName() + ", how am I supposed to buy " + "'" + num + "'" + " Opium?");
                            }
                        }
                    } else if (response.equalsIgnoreCase("S")) {
                        System.out.println("\nHow much Silk shall I buy, " + getName() + "? (You can afford " + getMoney() /getSilkPrice() + ")");
                        while (notDone2) {
                            int num = input.nextInt();
                            if (num <= getMoney() /getSilkPrice() && num >= 0) {
                                setSilkHeld(getSilkHeld()+num);
                                setMoney(getMoney()-num *getSilkPrice());
                                notDone2 = false;
                            } else if (num >= 0) {
                                System.out.println(getName() + ", you can't afford that!");
                            } else {
                                System.out.println(getName() + ", how am I supposed to buy " + "'" + num + "'" + " Silk?");
                            }
                        }
                    } else if (response.equalsIgnoreCase("A")) {
                        System.out.println("\nHow many Arms shall I buy, " + getName() + "? (You can afford " + getMoney() /getArmsPrice() + ")");
                        while (notDone2) {
                            int num = input.nextInt();
                            if (num <= getMoney() /getArmsPrice() && num >= 0) {
                                setArmsHeld(getArmsHeld()+num);
                                setMoney(getMoney() - num*getArmsPrice());
                                notDone2 = false;
                            } else if (num >= 0) {
                                System.out.println(getName() + ", you can't afford that!");
                            } else {
                                System.out.println(getName() + ", how am I supposed to buy " + "'" + num + "'" + " Arms?");
                            }
                        }
                    } else if (response.equalsIgnoreCase("G")) {
                        System.out.println("\nHow much General Cargo shall I buy, " + getName() + "? (You can afford " + getMoney() /getGeneralPrice() + ")");
                        while (notDone2) {
                            int num = input.nextInt();
                            if (num <= getMoney() /getGeneralPrice() && num >= 0) {
                                setGeneralHeld(getGeneralHeld()+num);
                                setMoney(getMoney() - num*getGeneralPrice());
                                notDone2 = false;
                            } else if (num >= 0) {
                                System.out.println(getName() + ", you can't afford that!");
                            } else {
                                System.out.println(getName() + ", how am I supposed to buy " + "'" + num + "'" + " General Cargo?");
                            }
                        }
                    }
                }

            } // when selling, the user must enter a non-negative amount of items, and not more than what they have.
            else if (response.equalsIgnoreCase("S")) {
                boolean notDone2 = true;
                System.out.println("What do you wish me to sell, " + getName() + "?");
                while (notDone2) {
                    response = input.nextLine();
                    if (response.equalsIgnoreCase("O")) {
                        System.out.println("\nHow much Opium shall I sell, " + getName() + "? (You have " + getOpiumHeld() + ")");
                        while (notDone2) {
                            int num = input.nextInt();
                            if (num <= getOpiumHeld() && num >= 0) {
                                setOpiumHeld(getOpiumHeld()-num);
                                setMoney(getMoney() + num*getOpiumPrice());
                                notDone2 = false;
                            } else if (num >= 0) {
                                System.out.println(getName() + ", you don't have that many to sell!");
                            } else {
                                System.out.println(getName() + ", how am I supposed to sell " + "'" + num + "'" + " Opium?");
                            }
                        }
                    } else if (response.equalsIgnoreCase("S")) {
                        System.out.println("\nHow much Silk shall I sell, " + getName() + "? (You have " + getSilkHeld() + ")");
                        while (notDone2) {
                            int num = input.nextInt();
                            if (num <= getSilkHeld() && num >= 0) {
                                setSilkHeld(getSilkHeld()-num);
                                setMoney(getMoney() + num*getSilkPrice());
                                notDone2 = false;
                            } else if (num >= 0) {
                                System.out.println(getName() + ", you don't have that many to sell!");
                            } else {
                                System.out.println(getName() + ", how am I supposed to sell " + "'" + num + "'" + " Silk?");
                            }
                        }
                    } else if (response.equalsIgnoreCase("A")) {
                        System.out.println("\nHow many Arms shall I sell, " + getName() + "? (You have " + getArmsHeld() + ")");
                        while (notDone2) {
                            int num = input.nextInt();
                            if (num <= getArmsHeld() && num >= 0) {
                                setArmsHeld(getArmsHeld()-num);
                                setMoney(getMoney() + num*getArmsPrice());
                                notDone2 = false;
                            } else if (num >= 0) {
                                System.out.println(getName() + ", you don't have that many to sell!");
                            } else {
                                System.out.println(getName() + ", how am I supposed to sell " + "'" + num + "'" + " Arms?");
                            }
                        }
                    } else if (response.equalsIgnoreCase("G")) {
                        System.out.println("\nHow much General Cargo shall I sell, " + getName() + "? (You have " + getGeneralHeld() + ")");
                        while (notDone2) {
                            int num = input.nextInt();
                            if (num <= getGeneralHeld() && num >= 0) {
                                setGeneralHeld(getGeneralHeld()-num);
                                setMoney(getMoney() + num*getGeneralPrice());
                                notDone2 = false;
                            } else if (num >= 0) {
                                System.out.println(getName() + ", you don't have that many to sell!");
                            } else {
                                System.out.println(getName() + ", how am I supposed to sell " + "'" + num + "'" + " General Cargo?");
                            }
                        }
                    }

                }

            } else if (response.equalsIgnoreCase("V") && (caseNum == 1 || caseNum == 3)) {
                bank();
            } else if (response.equalsIgnoreCase("T") && (caseNum == 1 || caseNum == 3)) {
                warehouse();
            } else if ((response.equalsIgnoreCase("G")||response.equalsIgnoreCase("L")) && (caseNum == 1 || caseNum == 3)) {
                loan();
            } // if the user wishes to quit trading, they may do so. Doing this breaks them out of the loop.
            else if (response.equalsIgnoreCase("Q") && (caseNum == 1 || caseNum == 3)) {
                travel();
                notDone = false;
            } // if the user wishes to retire and win the game, they may do so. Doing this breaks them out of the loop.
            else if (response.equalsIgnoreCase("R") && caseNum == 3) {
                retire();
                notDone = false;
            }
        }
    }
}
