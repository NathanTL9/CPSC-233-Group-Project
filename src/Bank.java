import java.sql.SQLOutput;
import java.util.Scanner;

public class Bank{
	
	 private Player player;
	 public void setPlayer(Player player) {
	        Player playerDummy = new Player(player);
	        this.player = playerDummy;
	 }

	 public Player getPlayer(){
	 	Player playerDummy = new Player(player);
	 	return playerDummy;
	 }

	 public Bank(Player player){
	 	Player playerDummy = new Player(player);
	 	this.player = playerDummy;
	 }

	 public void bank(){
	 	Scanner input = new Scanner(System.in);
	 	boolean notDone = true;
	 	 int check = 0;
	 	while(notDone){
			System.out.println("Would you like to Withdraw or Deposit?");
			String response = input.nextLine();
			if(response.equalsIgnoreCase("W")){
				boolean notDone2 = true;
				while(notDone2){
					System.out.println("How much do you wish to Withdraw");
					int withdraw = input.nextInt();
					if(withdraw <= player.getBank()){
						player.setMoney(withdraw + player.getMoney());
						player.setBank(player.getBank()-withdraw);
						notDone2 = false;
						check = 1;
					}
				}
			}else if(response.equalsIgnoreCase("D")){
				boolean notDone2 = true;
				while(notDone2){
					System.out.println("How much do you wish to Deposit");
					int deposit = input.nextInt();
					if(deposit <= player.getMoney()){
						player.setBank(deposit + player.getBank());
						player.setMoney(player.getMoney()-deposit);
						notDone2 = false;
						check = 1;
					}
				}
			}
			if(check == 1){
				boolean notDone3 = true;
				while(notDone3){
					System.out.println("Would you like to continue? Y/N");
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
