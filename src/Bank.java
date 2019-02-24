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

	public int promtMoney() {
		int addVal = 0;
		int retVal = 0;
		System.out.println("Please enter an amount");
		Scanner keyboard = new Scanner(System.in);
		addVal = keyboard.nextInt();
		if(addVal >= 0) {
			retVal = addVal;
		}
		return retVal;
	}
	
	public void addMoney() {
		int addMon = promtMoney();
		if(addMon >= 0) {
			player.setBank(promtMoney() + player.getMoney());
		}
		
	}
	
	public void removeMoney() {
		int subMon = promtMoney();
		if(subMon <= player.getMoney()) {
			player.setBank(subMon - player.getMoney());
		}
		
	}
	
	public void addInterest() {
		setBank((int)((player.getBank() * 1.05)));
	}
}
