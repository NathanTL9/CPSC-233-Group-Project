import java.util.Scanner;

public class Warehouse {
	private int wOpium = 0;
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
		boolean askGood = false;
		String amount;
		int finalAmount = 0;
		System.out.println("Please enter the amount of the good you would like to ADD.");
		Scanner keyboard = new Scanner(System.in);
		amount = keyboard.nextLine();
		try {
			if (Integer.parseInt(amount) <= player.getOpiumHeld() || Integer.parseInt(amount) <= player.getSilkHeld() ||Integer.parseInt(amount) <= player.getGeneralHeld() || Integer.parseInt(amount) <= player.getArmsHeld()) {
				finalAmount = Integer.parseInt(amount);
				askGood=true;
			} else {
				System.out.println("Nice try but you don't have any items of that quantity!");
				askGood=false;
			}
			if(askGood==true) {
				String good;
				System.out.println("Please enter a good to transfer O, S, G, A :");
				good = keyboard.nextLine();
				int held = 0;
				if (Integer.parseInt(amount) > 0) {
					if (good.equalsIgnoreCase("O")) {
						this.wOpium += finalAmount;
						held = player.getOpiumHeld();
						player.setOpiumHeld(held - finalAmount);
						System.out.println(player.getOpiumHeld());
					} else if (good.equalsIgnoreCase("S")) {
						this.wSilk += finalAmount;
						held = player.getSilkHeld();
						player.setSilkHeld(held - finalAmount);
					} else if (good.equalsIgnoreCase("G")) {
						this.wGeneral += finalAmount;
						held = player.getGeneralHeld();
						player.setGeneralHeld(held - finalAmount);
					} else if (good.equalsIgnoreCase("A")) {
						this.wArms += finalAmount;
						held = player.getArmsHeld();
						player.setArmsHeld(held - finalAmount);
					}
				} else {
					System.out.println("Sorry this transfer cannot be made");
				}
			}
		}catch(Exception e){
			System.out.println("Wait, that's not a valid input please try again");
		}
	}
	public void removeAmount() {
		String amount;
		int finalAmount = 0;
		System.out.println("Please enter the amount of the good you would like to REMOVE");
		Scanner keyboard = new Scanner(System.in);
		amount = keyboard.nextLine();
		if(Integer.parseInt(amount) <= this.wOpium) {
			finalAmount = Integer.parseInt(amount);
		}
		else if(Integer.parseInt(amount) <= this.wSilk) {
			finalAmount = Integer.parseInt(amount);
		}
		else if(Integer.parseInt(amount) <= this.wGeneral) {
			finalAmount = Integer.parseInt(amount);
		}
		else if(Integer.parseInt(amount) <= this.wArms) {
			finalAmount = Integer.parseInt(amount);
		}

	
		String good;
		System.out.println("Please enter a good to transfer O, S, G, A :");
		good = keyboard.nextLine();
		int held = 0;
		if (Integer.parseInt(amount) > 0) {
			if (good.equalsIgnoreCase("O")) {
				this.wOpium -= Integer.parseInt(amount);
				held = player.getOpiumHeld();
				player.setOpiumHeld(held + finalAmount);
			}
			else if(good.equalsIgnoreCase("S")) {
				this.wSilk -= Integer.parseInt(amount);
				held = player.getSilkHeld();
				player.setSilkHeld(held + finalAmount);
			}
			else if(good.equalsIgnoreCase("G")) {
				this.wGeneral -= Integer.parseInt(amount);
				held = player.getGeneralHeld();
				player.setGeneralHeld(held + finalAmount);
			}
			else if(good.equalsIgnoreCase("A")) {
				this.wArms -= Integer.parseInt(amount);
				held = player.getArmsHeld();
				player.setArmsHeld(held + finalAmount);
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
			check = keyboard.nextLine();
			check=keyboard.nextLine();
			
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
