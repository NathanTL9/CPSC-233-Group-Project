import java.util.Scanner;

public class Warehouse extends Player {
	private int wOpium = 25;
	private int wSilk = 0;
	private int wGeneral = 0;
	private int wArms = 0;
	private String good = "";
	private int finalAmount = 0;
	
	public void addAmount(String good, int amount) {
		int held = 0;
		if (amount > 0) {
			if (this.good.equalsIgnoreCase("O")) {
				this.wOpium += amount;
				held = getOpiumHeld();
				setOpiumHeld(held - amount);
				System.out.println(getOpiumHeld());
			}
			else if(this.good.equalsIgnoreCase("S")) {
				this.wSilk += amount;
				held = getSilkHeld();
				setSilkHeld(held - amount);
			}
			else if(this.good.equalsIgnoreCase("G")) {
				this.wGeneral += amount;
				held = getGeneralHeld();
				setGeneralHeld(held - amount);
			}
			else if(this.good.equalsIgnoreCase("A")) {
				this.wArms += amount;
				held = getArmsHeld();
				setArmsHeld(held - amount);
			}
		}
		else {
			System.out.println("Sorry this transfer cannot be made");
		}
	}
	public void removeAmount(String good, int amount) {
		int held = 0;
		if (amount > 0) {
			if (this.good.equalsIgnoreCase("O")) {
				this.wOpium -= amount;
				held = getOpiumHeld();
				setOpiumHeld(held + amount);
			}
			else if(this.good.equalsIgnoreCase("S")) {
				this.wSilk -= amount;
				held = getSilkHeld();
				setSilkHeld(held + amount);
			}
			else if(this.good.equalsIgnoreCase("G")) {
				this.wGeneral -= amount;
				held = getGeneralHeld();
				setGeneralHeld(held + amount);
			}
			else if(this.good.equalsIgnoreCase("A")) {
				this.wArms -= amount;
				held = getArmsHeld();
				setArmsHeld(held + amount);
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

	private void askGood() {
		String aGood = "k";
		System.out.println("Please enter a good to transfer O, S, G, A :");
		Scanner keyboard = new Scanner(System.in);
		aGood = keyboard.nextLine();
		aGood = aGood.toUpperCase();
		this.good = aGood;
		}
	
	public void askAddAmount() {
		askGood();
		int amount = 0;
			System.out.println("Please enter the amount of the good you would like to transfer, put negative amount to remove");
			Scanner keyboard = new Scanner(System.in);
			amount = keyboard.nextInt();
				if(this.good.equalsIgnoreCase("O") && amount <= getOpiumHeld()) {
					finalAmount = amount;
				}
				else if(this.good.equalsIgnoreCase("S") && amount <= getSilkHeld()) {
					finalAmount = amount;
				}
				else if(this.good.equalsIgnoreCase("G") && amount <= getGeneralHeld()) {
					finalAmount = amount;
				}
				else if(this.good.equalsIgnoreCase("A") && amount <= getArmsHeld()) {
					finalAmount = amount;
				}
	}
	
	public void askRemoveAmount() {
		askGood();
		int amount = 0;
		System.out.println("Please enter the amount of the good you would like to remove");
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
	public static void main(String[] args){
		Warehouse hi = new Warehouse();
		hi.showWarehouse();
		hi.askRemoveAmount();
		hi.removeAmount(hi.good, hi.finalAmount);
		hi.showWarehouse();
		hi.askAddAmount();
		hi.addAmount(hi.good, hi.finalAmount);
		hi.showWarehouse();
    }
}
