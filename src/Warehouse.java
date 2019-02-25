import java.util.Scanner;

public class Warehouse {
	private int wOpium = 25;
	private int wSilk = 0;
	private int wGeneral = 0;
	private int wArms = 0;
	private int finalAmount = 0;
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

	
	public void addAmount(int amount) {
		String good;
		System.out.println("Please enter a good to transfer O, S, G, A :");
		Scanner keyboard = new Scanner(System.in);
		good = keyboard.nextLine();
		int held = 0;
		if (amount > 0) {
			if (good.equalsIgnoreCase("O")) {
				this.wOpium += amount;
				held = player.getOpiumHeld();
				player.setOpiumHeld(held - amount);
				System.out.println(player.getOpiumHeld());
			}
			else if(good.equalsIgnoreCase("S")) {
				this.wSilk += amount;
				held = player.getSilkHeld();
				player.setSilkHeld(held - amount);
			}
			else if(good.equalsIgnoreCase("G")) {
				this.wGeneral += amount;
				held = player.getGeneralHeld();
				player.setGeneralHeld(held - amount);
			}
			else if(good.equalsIgnoreCase("A")) {
				this.wArms += amount;
				held = player.getArmsHeld();
				player.setArmsHeld(held - amount);
			}
		}
		else {
			System.out.println("Sorry this transfer cannot be made");
		}
	}
	public void removeAmount(int amount) {
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

	public void askAddAmount() {
		int amount = 0;
			System.out.println("Please enter the amount of the good you would like to ADD.");
			Scanner keyboard = new Scanner(System.in);
			amount = keyboard.nextInt();
				if(this.good.equalsIgnoreCase("O") && amount <= player.getOpiumHeld()) {
					finalAmount = amount;
				}
				else if(this.good.equalsIgnoreCase("S") && amount <= player.getSilkHeld()) {
					finalAmount = amount;
				}
				else if(this.good.equalsIgnoreCase("G") && amount <= player.getGeneralHeld()) {
					finalAmount = amount;
				}
				else if(this.good.equalsIgnoreCase("A") && amount <= player.getArmsHeld()) {
					finalAmount = amount;
				}
	}

	public void askRemoveAmount() {
		int amount = 0;
		System.out.println("Please enter the amount of the good you would like to REMOVE");
		Scanner keyboard = new Scanner(System.in);
		amount = keyboard.nextInt();
		if(this.good.equalsIgnoreCase("O") && amount <= this.wOpium) {
			finalAmount = amount;
		}
		else if(this.good.equalsIgnoreCase("S") && amount <= this.wSilk) {
			finalAmount = amount;
		}
		else if(this.good.equalsIgnoreCase("G") && amount <= this.wGeneral) {
			finalAmount = amount;
		}
		else if(this.good.equalsIgnoreCase("A") && amount <= this.wArms) {
			finalAmount = amount;
		}

	}
	
	public void changeWarehouse() {
		this.showWarehouse();
		String input = " ";
		System.out.println("Would you like to add(A) or remove(R) resources? ");
		Scanner keyboard = new Scanner(System.in);
		input = keyboard.next();
		if(input.equalsIgnoreCase("R")) {
			this.askRemoveAmount();
			this.removeAmount(this.good, this.finalAmount);
			this.showWarehouse();
		}
		else if(input.equalsIgnoreCase("A")) {
			this.askAddAmount();
			this.addAmount(this.good, this.finalAmount);
			this.showWarehouse();
		}
	}
}
