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
		int loanAsk = 0;
		System.out.println("Please enter how much you would like to borrow");
		Scanner keyboard = new Scanner(System.in);
		loanAsk = keyboard.nextInt();
			if(loanAsk <= 2*(player.getMoney() - player.getDebt())) {
				player.setDebt(player.getDebt() + loanAsk);
				player.setMoney(player.getMoney() + loanAsk);
			}
	}
	public void addInterest() {
		player.setDebt((int)(player.getDebt() * 1.01));
	}
}
