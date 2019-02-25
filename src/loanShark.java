import java.util.Scanner;

public class loanShark {
	private Player player;
	public void setPlayer(Player player) {
		Player playerDummy = new Player(player);
		this.player = playerDummy;
	}

	public Player getPlayer(){
		Player playerDummy = new Player(player);
		return playerDummy;
	}

	public loanShark(Player player){
		Player playerDummy = new Player(player);
		this.player = playerDummy;
	}

	public void loanMoney() {
		boolean keepGoing = true;
		while(keepGoing) {
			String check;
			Scanner keyboard = new Scanner(System.in);
			System.out.println("Would you like to return money or borrow money?");
			check = keyboard.nextLine();
			if(check.equalsIgnoreCase("r")){
				int returnAsk = 0;
				System.out.println("Please enter how much you would like to return?");
				returnAsk = keyboard.nextInt();
				if(returnAsk <= player.getDebt() && returnAsk >= 0) {
					player.setDebt(player.getDebt() - returnAsk);
					player.setMoney(player.getMoney() - returnAsk);
				}//updated
				else if(returnAsk > player.getDebt()){
					System.out.println("You don't need to return that much!");
				}else{
					System.out.println("You can't return a negative amount.");
				}
			}else if(check.equalsIgnoreCase("b")){
				int loanAsk = 0;
				System.out.println("Please enter how much you would like to borrow");
				loanAsk = keyboard.nextInt();
				if(loanAsk <= 2*(player.getMoney() - player.getDebt())&& loanAsk >= 0) {
					player.setDebt(player.getDebt() + loanAsk);
					player.setMoney(player.getMoney() + loanAsk);
				}//updated
				else{
					System.out.println("Sorry you can't be loaned that much");
					break;
				}
			}
				
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
