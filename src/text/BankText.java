package text;

import logic.BankLogic;
import logic.Player;

import java.util.Scanner;

public class BankText extends Player {

    /**
     * Class Constructor that takes in a type player as a parameter
     * @param player object of the class Player
     */
    public BankText(Player player) {
        Player playerDummy = new Player(player);
        setPlayer(playerDummy);
    }

    /**
     * This method is used to withdraw or deposit money into the bank account
     * by prompting the user if they would like to withdraw or deposit. Followed
     * by prompting them to enter an amount to transfer. This method also uses the
     * player class to see if the transfer can be made,and if it can it changes the
     * values accordingly
     */
    public void bank(){
        Scanner input = new Scanner(System.in);
        boolean notDone = true;
        int check = 0;
        while(notDone){
            //Prompt the user if they want to withdraw or deposit
            System.out.println("Would you like to Withdraw or Deposit?");
            String response = input.nextLine();
            //If user chose withdraw then subtract the amount from bank account and add it to cash
            if(response.equalsIgnoreCase("W")){
                check = withdraw(input, check);
            }
            //If the user chooses to deposit the continue to this code
            else if(response.equalsIgnoreCase("D")){
                check = deposit(input, check);
            }
            if(check == 1){
                notDone = notContinue(input, notDone);
            }
        }
    }

    /**
     * Asks the user if they want to continue staying in Bank
     * @param input The Scanner object which is used for asking user questions
     * @param notDone Boolean statement which if is false stops the loop in the Bank method
     * @return a boolean value which can turn off the original while loop this method is inside
     */
    public boolean notContinue(Scanner input, boolean notDone) {
        String response;
        boolean notDone3 = true;
        // Asks user if they would like to continue in bank or not
        while(notDone3){
            System.out.println("Would you like to continue? Y/N");
            response = input.nextLine();
            response = input.nextLine();
            if(response.equalsIgnoreCase("Y")){
                notDone3 = false;
            }else if(response.equalsIgnoreCase("N")){
                notDone = false;
                notDone3 = false;
            }
        }
        return notDone;
    }

    /**
     * Asks the user how much they want to deposit
     * @param input The Scanner object which is used for asking user questions
     * @param check an integer value which changes depending on the stages of the bank class
     * @return a boolean value which can turn off the original while loop this method is inside
     */
    public int deposit(Scanner input, int check) {
        boolean notDone2 = true;
        while(notDone2){
            //Prompt the user for the amount they would like to deposit and ensure suffiecent funds
            System.out.println("How much do you wish to Deposit?");
            int deposit = input.nextInt();
            if(deposit <= getMoney()){
                BankLogic bankLogic = new BankLogic(getPlayer());
                bankLogic.depositing(deposit);
                setPlayer(bankLogic.getPlayer());
                notDone2 = false;
                check = 1;
            }
        }
        return check;
    }

    /**
     * Asks the user how much they want to withdrawe
     * @param input The Scanner object which is used for asking user questions
     * @param check an integer value which changes depending on the stages of the bank class
     * @return a boolean value which can turn off the original while loop this method is inside
     */
    public int withdraw(Scanner input, int check) {
        boolean notDone2 = true;
        while(notDone2){
            System.out.println("How much do you wish to Withdraw?");
            int withdraw = input.nextInt();
            //Prompt the user for the amount and check if the bank has sufficient funds
            if(withdraw <= getBank()){
                BankLogic bankLogic = new BankLogic(getPlayer());
                bankLogic.withdrawing(withdraw);
                setPlayer(bankLogic.getPlayer());
                notDone2 = false;
                check = 1;
            }
        }
        return check;
    }

}
