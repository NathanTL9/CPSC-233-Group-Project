import java.util.Scanner;

public class Bank extends Player {
	
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
			setBank(promtMoney() + getMoney());
		}
		
	}
	
	public void removeMoney() {
		int subMon = promtMoney();
		if(subMon <= getMoney()) {
			setBank(subMon - getMoney());
		}
		
	}
	
	public void addInterest() {
		setBank((int)((getBank() * 1.05)));
	}
	
	
}
