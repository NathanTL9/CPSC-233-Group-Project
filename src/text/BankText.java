package text;

import logic.Player;

import java.util.Scanner;

public class BankText extends Player {

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
                boolean notDone2 = true;
                while(notDone2){
                    System.out.println("How much do you wish to Withdraw?");
                    int withdraw = input.nextInt();
                    //Prompt the user for the amount and check if the bank has sufficient funds
                    if(withdraw <= getBank()){
                        setMoney(withdraw + getMoney());
                        setBank(getBank()-withdraw);
                        notDone2 = false;
                        check = 1;
                    }
                }

            }
            //If the user chooses to deposit the continue to this code
            else if(response.equalsIgnoreCase("D")){
                boolean notDone2 = true;
                while(notDone2){
                    //Prompt the user for the amount they would like to deposit and ensure suffiecent funds
                    System.out.println("How much do you wish to Deposit?");
                    int deposit = input.nextInt();
                    if(deposit <= getMoney()){
                        setBank(deposit + getBank());
                        setMoney(getMoney()-deposit);
                        notDone2 = false;
                        check = 1;
                    }
                }
            }
            if(check == 1){
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
            }
        }

    }

}
