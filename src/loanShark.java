import java.util.Scanner;

import static javafx.application.Platform.exit;

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
			int loanAsk = 0;
			System.out.println("Please enter how much you would like to borrow");
			Scanner keyboard = new Scanner(System.in);
			loanAsk = keyboard.nextInt();
			if(loanAsk <= 2*(player.getMoney() - player.getDebt())) {
				player.setDebt(player.getDebt() + loanAsk);
				player.setMoney(player.getMoney() + loanAsk);
			}
			//updated
			else{
				System.out.println("Sorry you can't be loaned that much");
				break;
			}
			String check;
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