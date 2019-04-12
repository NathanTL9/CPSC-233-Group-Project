package text;

import logic.LoanSharkLogic;
import logic.Player;

import java.util.Scanner;

public class LoanSharkText extends Player {

    /**
     * constructor; only runs when a Player object is provided. The constructor is fully encapsulated.
     *
     * @param player is a Player object that will be copied and the player instance variable is set to the copy.
     */
    public LoanSharkText(Player player) {
        Player playerDummy = new Player(player);
        setPlayer(playerDummy);
    }

    /**
     * Either give the player a loan or it allows the player to pay a debt
     */
    public void loanMoney() {
        System.out.println("Debt: " + getDebt());
        System.out.println("Cash: " + getMoney());
        System.out.println("Would you like you get a (l)oan or (p)ay a debt?");

        Scanner keyboard = new Scanner(System.in);
        String response = keyboard.nextLine();
        //Pay off loan
        if (response.equalsIgnoreCase("p")) {
            try {
                System.out.println("How much of your debt would you like to pay?");
                int returnAsk = Integer.parseInt(keyboard.nextLine());
                //If the player enters a invalid number
                if (returnAsk > getDebt()) {
                    System.out.println("You do not need to return that much.");
                }
                //If the player enters a valid number
                else if (returnAsk <= getDebt() && returnAsk >= 0 && getMoney() >= returnAsk) {
                    LoanSharkLogic loanSharkLogic = new LoanSharkLogic(getPlayer());
                    loanSharkLogic.changeLoan(getDebt() - returnAsk, getMoney() - returnAsk);
                    setPlayer(loanSharkLogic.getPlayer());
                }
                //If the player enters a invalid number
                else if (getMoney() < returnAsk) {
                    System.out.println("Look " + getName() + ", you are being cheap!");
                }
                //If the player enters a negative number
                else {
                    System.out.println("Sorry, you can not return a negative amount!");
                }
            }
            //Only runs if the user gives an invalid input
            catch (Exception e) {
                System.out.println("Please enter a valid value");
            }
        }
        //Ask for Loan
        if (response.equalsIgnoreCase("l")) {
            try {
                System.out.println("How big of a loan would you like?");
                int loanAsk = Integer.parseInt(keyboard.nextLine());
                //If the player enters a valid number
                if (loanAsk <= 2 * (getMoney() - getDebt()) && loanAsk >= 0) {
                    LoanSharkLogic loanSharkLogic = new LoanSharkLogic(getPlayer());
                    loanSharkLogic.changeLoan(getDebt() + loanAsk, getMoney() + loanAsk);
                    setPlayer(loanSharkLogic.getPlayer());
                    System.out.println("Cash: " + getMoney());
                }
                //If the player enters a negative number
                else if (loanAsk < 0) {
                    System.out.println("Sorry you cannot enter negative numbers");
                }
                //If the player enters a invalid number
                else {
                    System.out.println("Sorry you cannot get the loan requested");
                }
            }
            //Only runs if the user gives an invalid input
            catch (Exception e) {
                System.out.println("Please enter a valid value");
            }
        }
    }
}
