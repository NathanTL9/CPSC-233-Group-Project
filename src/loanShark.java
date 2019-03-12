import java.util.Scanner;

public class loanShark {
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
	public Player getPlayer(){
		Player playerDummy = new Player(player);
		return playerDummy;
	}
	/**
	 * Class Constructor that takes in a type player as a parameter
	 *
	 * @param player object of the class Player
	 */
	public loanShark(Player player){
		Player playerDummy = new Player(player);
		this.player = playerDummy;
	}

	/**
	 * This methods purpose is to loan the player the funds it wants
	 * or pay its outstanding debts. The method prompts the user if they
	 * would like to borrow money or repay. depending on what the player chooses
	 * the corresponding loop is evoked. The player can only be loaned 2 times the
	 * money they have minus the debt id their debt exceeds the cash balance, the loan
	 * cannot be given.
	 */
	public void loanMoney() {
		boolean keepGoing = true;
		while(keepGoing) {
			String check;
			Scanner keyboard = new Scanner(System.in);
			System.out.println("Would you like to return money or borrow money?");
			//Prompts the user or what they would like to do
			check = keyboard.nextLine();
			//If the user chooses to return money, the money is subtracted from the cash amount and debt
			if(check.equalsIgnoreCase("r")){
				int returnAsk = 0;
				System.out.println("Please enter how much you would like to return?");
				returnAsk = keyboard.nextInt();
				if(returnAsk <= player.getDebt() && returnAsk >= 0) {
					player.setDebt(player.getDebt() - returnAsk);
					player.setMoney(player.getMoney() - returnAsk);
				}
				//if you try to return more money than you owe it wont allow you to
				else if(returnAsk > player.getDebt()){
					System.out.println("You don't need to return that much!");
				}
				//No negative amounts are allowed
				else{
					System.out.println("You can't return a negative amount.");
				}

			}
			//If the user chooses to borrow, the money is added to cash and the debt is increased
			else if(check.equalsIgnoreCase("b")){
				int loanAsk = 0;
				System.out.println("Please enter how much you would like to borrow");
				//Prompts user for the amount they would like to borrow
				loanAsk = keyboard.nextInt();
				if(loanAsk <= 2*(player.getMoney() - player.getDebt())&& loanAsk >= 0) {
					player.setDebt(player.getDebt() + loanAsk);
					player.setMoney(player.getMoney() + loanAsk);
				}
				//If the requested money exceeds 2*(cash - debt) then the loan cannot be given
				else{
					System.out.println("Sorry you can't be loaned that much");
					break;
				}
			}
			//Asks the player if they have any other things to do with the load shark
			System.out.println("Would you like to do any other business? Y / N?");
			check = keyboard.nextLine();
			check = keyboard.nextLine();

			if(check.equalsIgnoreCase("Y")) {
				keepGoing = true;
			}
			else if(check.equalsIgnoreCase("N")) {
				keepGoing = false;
			}
		}
	}
}
