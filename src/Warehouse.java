import java.util.Scanner;

public class Warehouse {
	private int wOpium = 25;
	private int wSilk = 0;
	private int wGeneral = 0;
	private int wArms = 0;
	private Player player;

	
	public void setPlayer(Player player) {
		Player playerDumy = new Player(player);
		this.player= playerDumy;
	}
	
	 public Player getPlayer(){
	        Player playerDummy = new Player(player);
	        return playerDummy;
	    }
	 
	 public Warehouse(Player player){
	        Player playerDummy = new Player(player);
	        this.player = playerDummy;
	    }

	
	public void addAmount() {
		int amount = 0;
		int finalAmount;
		System.out.println("Please enter the amount of the good you would like to ADD.");
		Scanner keyboard = new Scanner(System.in);
		amount = keyboard.nextInt();
			if(amount <= player.getOpiumHeld()) {
				finalAmount = amount;
			}
			else if(amount <= player.getSilkHeld()) {
				finalAmount = amount;
			}
			else if(amount <= player.getGeneralHeld()) {
				finalAmount = amount;
			}
			else if(amount <= player.getArmsHeld()) {
				finalAmount = amount;
			}
		String good;
		System.out.println("Please enter a good to transfer O, S, G, A :");
		Scanner keyboard = new Scanner(System.in);
		good = keyboard.nextLine();
		int held = 0;
		if (amount > 0) {
			if (good.equalsIgnoreCase("O")) {
				this.wOpium += finalAmount;
				held = player.getOpiumHeld();
				player.setOpiumHeld(held - finalAmount);
				System.out.println(player.getOpiumHeld());
			}
			else if(good.equalsIgnoreCase("S")) {
				this.wSilk += finalAmount;
				held = player.getSilkHeld();
				player.setSilkHeld(held - amount);
			}
			else if(good.equalsIgnoreCase("G")) {
				this.wGeneral += finalAmount;
				held = player.getGeneralHeld();
				player.setGeneralHeld(held - amount);
			}
			else if(good.equalsIgnoreCase("A")) {
				this.wArms += finalAmount;
				held = player.getArmsHeld();
				player.setArmsHeld(held - amount);
			}
		}
		else {
			System.out.println("Sorry this transfer cannot be made");
		}
	}
	public void removeAmount() {
		int amount = 0;
		int finalAmount;
		System.out.println("Please enter the amount of the good you would like to REMOVE");
		Scanner keyboard = new Scanner(System.in);
		amount = keyboard.nextInt();
		if(amount <= this.wOpium) {
			finalAmount = amount;
		}
		else if(amount <= this.wSilk) {
			finalAmount = amount;
		}
		else if(amount <= this.wGeneral) {
			finalAmount = amount;
		}
		else if(amount <= this.wArms) {
			finalAmount = amount;
		}

	}
		String good;
		System.out.println("Please enter a good to transfer O, S, G, A :");
		Scanner keyboard = new Scanner(System.in);
		good = keyboard.nextLine();
		int held = 0;
		if (amount > 0) {
			if (good.equalsIgnoreCase("O")) {
				this.wOpium -= amount;
				held = player.getOpiumHeld();
				player.setOpiumHeld(held + amount);
			}
			else if(good.equalsIgnoreCase("S")) {
				this.wSilk -= amount;
				held = player.getSilkHeld();
				player.setSilkHeld(held + amount);
			}
			else if(good.equalsIgnoreCase("G")) {
				this.wGeneral -= amount;
				held = player.getGeneralHeld();
				player.setGeneralHeld(held + amount);
			}
			else if(good.equalsIgnoreCase("A")) {
				this.wArms -= amount;
				held = player.getArmsHeld();
				player.setArmsHeld(held + amount);
			}
		}
		else {
			System.out.println("Sorry this transfer cannot be made");
		}

	}

	public void showWarehouse() {
		System.out.println("Opium : " + this.wOpium);
		System.out.println("Silk : " + this.wSilk);
		System.out.println("General : " + this.wGeneral);
		System.out.println("Arms : " + this.wArms);
	}

	
	public void changeWarehouse() {
		boolean keepGoing = true;
		while(keepGoing) {
			this.showWarehouse();
			String input = " ";
			System.out.println("Would you like to add(A) or remove(R) resources? ");
			Scanner keyboard = new Scanner(System.in);
			input = keyboard.next();
			if(input.equalsIgnoreCase("R")) {
				this.removeAmount();
				this.showWarehouse();
			}
			else if(input.equalsIgnoreCase("A")) {
				this.addAmount();
				this.showWarehouse();
			}
			
			String check;
			System.out.println("Would you like to do any other business? Y / N?");
			Scanner keyboard = new Scanner(System.in);
			check = keyboard.nextLine();
			
			if(check.equalsIgnoreCase("Y")) {
				keepGoing = true;
		}
			else if(check.equalsIgnoreCase("N")) {
				keepGoing = false;
			}
		}
	}
	public static void main(String[] args){

    }
}
