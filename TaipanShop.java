import java.util.Random;
import java.util.Scanner;
public class TaipanShop {

    private String name = "Taipan";
    private int bank = 0;
    private int money = 1000;
    private int opiumHeld = 0;
    private int silkHeld = 0;
    private int generalHeld = 0;
    private int armsHeld = 0;
    private int cargoSpace = 60;
    private int currentCargo = 0;
    private int opiumPrice = 16000;
    private int silkPrice = 1600;
    private int armsPrice = 160;
    private int generalPrice = 8;
    private int location = 2;
    private int guns = 0;

    public void updatePrices(){
        String s = "\n" + name + ", the price of ";
        double value = 80*Math.random();
        Random rand = new Random();
        opiumPrice = (rand.nextInt(201) + 60)*100;
        silkPrice = (rand.nextInt(201) + 60)*10;
        armsPrice = (rand.nextInt(21) + 6)*10;
        generalPrice = rand.nextInt(17) + 4;
        if(value < 8){
            if(value < 2){
                if(value < 1){
                    opiumPrice /= 5;
                    System.out.println(s + "Opium has dropped to " + opiumPrice +"!!!\n");
                }else{
                    opiumPrice *= 5;
                    System.out.println(s + "Opium has risen to " + opiumPrice +"!!!\n");
                }
            }else if(value < 4){
                if(value < 3){
                    silkPrice /= 5;
                    System.out.println(s + "Silk has dropped to " + silkPrice +"!!!\n");
                }else{
                    silkPrice *= 5;
                    System.out.println(s + "Silk has risen to " + silkPrice +"!!!\n");
                }
            }else if(value < 6){
                if(value < 3){
                    armsPrice /= 5;
                    System.out.println(s + "Arms has dropped to " + armsPrice +"!!!\n");
                }else{
                    armsPrice *= 5;
                    System.out.println(s + "Arms has risen to " + armsPrice +"!!!\n");
                }
            }else{
                if(value < 7){
                    generalPrice = 1;
                    System.out.println(s + "General Cargo has dropped to 1!!!\n");
                }else{
                    generalPrice *= 5;
                    System.out.println(s + "General Cargo has risen to " + generalPrice + "!!!\n");
                }
            }
        }
    }

    public void printShop(){
        currentCargo = opiumHeld+guns*10+silkHeld+armsHeld+generalHeld;
        if(cargoSpace - currentCargo < 0){
            System.out.println("Hold: Overloaded" + "          Guns: " + guns);
        }else{
            System.out.println("Hold: " + (cargoSpace-currentCargo) + "          Guns: " + guns);
        }
        System.out.println("-------------------------------------------------------------");
        System.out.println("     Opium: " + opiumHeld + "      Silk: " + silkHeld);
        System.out.println("     Arms: " + armsHeld + "       General: " + generalHeld);
        System.out.println("-------------------------------------------------------------");
        System.out.println("Cash: " + money + "           Bank: " + bank+"\n");
        System.out.println(name + ", present prices per unit here are:");
        System.out.println("     Opium: " + opiumPrice + "    Silk: " + silkPrice);
        System.out.println("     Arms: " + armsPrice + "       General: " + generalPrice);
    }

    public void shop() {
        updatePrices();
        Scanner input = new Scanner(System.in);
        boolean notDone = true;
        if (location == 1) {
            while (notDone) {
                printShop();
                System.out.println("\nShall I Buy, Sell, Visit Bank, Transfer Cargo, or Quit Trading?");
                String response = input.next();
                if (response.equalsIgnoreCase("B")) {
                    boolean notDone2 = true;
                    System.out.println("What do you wish me to buy, " + name + "?");
                    while (notDone2) {
                        response = input.nextLine();
                        if (response.equalsIgnoreCase("O")) {
                            System.out.println("\nHow much Opium shall I buy, " + name + "? (You can afford " + money / opiumPrice + ")");
                            while (notDone2) {
                                int num = input.nextInt();
                                if (num <= money / opiumPrice && num >= 0) {
                                    opiumHeld += num;
                                    money -= num * opiumPrice;
                                    notDone2 = false;
                                } else if (num >= 0) {
                                    System.out.println(name + ", you can't afford that!");
                                } else {
                                    System.out.println(name + ", how am I supposed to buy " + "'" + num + "'" + " Opium?");
                                }
                            }
                        } else if (response.equalsIgnoreCase("S")) {
                            System.out.println("\nHow much Silk shall I buy, " + name + "? (You can afford " + money / silkPrice + ")");
                            while (notDone2) {
                                int num = input.nextInt();
                                if (num <= money / silkPrice && num >= 0) {
                                    silkHeld += num;
                                    money -= num * silkPrice;
                                    notDone2 = false;
                                } else if (num >= 0) {
                                    System.out.println(name + ", you can't afford that!");
                                } else {
                                    System.out.println(name + ", how am I supposed to buy " + "'" + num + "'" + " Silk?");
                                }
                            }
                        } else if (response.equalsIgnoreCase("A")) {
                            System.out.println("\nHow many Arms shall I buy, " + name + "? (You can afford " + money / armsPrice + ")");
                            while (notDone2) {
                                int num = input.nextInt();
                                if (num <= money / armsPrice && num >= 0) {
                                    armsHeld += num;
                                    money -= num * armsPrice;
                                    notDone2 = false;
                                } else if (num >= 0) {
                                    System.out.println(name + ", you can't afford that!");
                                } else {
                                    System.out.println(name + ", how am I supposed to buy " + "'" + num + "'" + " Arms?");
                                }
                            }
                        } else if (response.equalsIgnoreCase("G")) {
                            System.out.println("\nHow much General Cargo shall I buy, " + name + "? (You can afford " + money / generalPrice + ")");
                            while (notDone2) {
                                int num = input.nextInt();
                                if (num <= money / generalPrice && num >= 0) {
                                    generalHeld += num;
                                    money -= num * generalPrice;
                                    notDone2 = false;
                                } else if (num >= 0) {
                                    System.out.println(name + ", you can't afford that!");
                                } else {
                                    System.out.println(name + ", how am I supposed to buy " + "'" + num + "'" + " General Cargo?");
                                }
                            }
                        }

                    }

                } else if (response.equalsIgnoreCase("S")) {
                    boolean notDone2 = true;
                    System.out.println("What do you wish me to sell, " + name + "?");
                    while (notDone2) {
                        response = input.nextLine();
                        if (response.equalsIgnoreCase("O")) {
                            System.out.println("\nHow much Opium shall I sell, " + name + "? (You have " + opiumHeld + ")");
                            while (notDone2) {
                                int num = input.nextInt();
                                if (num <= opiumHeld && num >= 0) {
                                    opiumHeld -= num;
                                    money += num * opiumPrice;
                                    notDone2 = false;
                                } else if (num >= 0) {
                                    System.out.println(name + ", you don't have that many to sell!");
                                } else {
                                    System.out.println(name + ", how am I supposed to sell " + "'" + num + "'" + " Opium?");
                                }
                            }
                        } else if (response.equalsIgnoreCase("S")) {
                            System.out.println("\nHow much Silk shall I sell, " + name + "? (You have " + silkHeld + ")");
                            while (notDone2) {
                                int num = input.nextInt();
                                if (num <= silkHeld && num >= 0) {
                                    silkHeld -= num;
                                    money += num * silkPrice;
                                    notDone2 = false;
                                } else if (num >= 0) {
                                    System.out.println(name + ", you don't have that many to sell!");
                                } else {
                                    System.out.println(name + ", how am I supposed to sell " + "'" + num + "'" + " Silk?");
                                }
                            }
                        } else if (response.equalsIgnoreCase("A")) {
                            System.out.println("\nHow many Arms shall I sell, " + name + "? (You have " + armsHeld + ")");
                            while (notDone2) {
                                int num = input.nextInt();
                                if (num <= armsHeld && num >= 0) {
                                    armsHeld -= num;
                                    money += num * armsPrice;
                                    notDone2 = false;
                                } else if (num >= 0) {
                                    System.out.println(name + ", you don't have that many to sell!");
                                } else {
                                    System.out.println(name + ", how am I supposed to sell " + "'" + num + "'" + " Arms?");
                                }
                            }
                        } else if (response.equalsIgnoreCase("G")) {
                            System.out.println("\nHow much General Cargo shall I sell, " + name + "? (You have " + generalHeld + ")");
                            while (notDone2) {
                                int num = input.nextInt();
                                if (num <= generalHeld && num >= 0) {
                                    generalHeld -= num;
                                    money += num * generalPrice;
                                    notDone2 = false;
                                } else if (num >= 0) {
                                    System.out.println(name + ", you don't have that many to sell!");
                                } else {
                                    System.out.println(name + ", how am I supposed to sell " + "'" + num + "'" + " General Cargo?");
                                }
                            }
                        }

                    }

                } else if (response.equalsIgnoreCase("V")) {
                    System.out.println("\n*** PLACEHOLDER FOR BANK ***\n");
                } else if (response.equalsIgnoreCase("T")) {
                    System.out.println("\n*** PLACEHOLDER FOR WAREHOUSE ***\n");
                } else if (response.equalsIgnoreCase("Q")) {
                    System.out.println("\n*** PLACEHOLDER FOR TRAVEL ***\n");
                    notDone = false;
                }
            }
        } else {
            while (notDone) {
                printShop();
                System.out.println("\nShall I Buy, Sell, or Quit Trading?");
                String response = input.next();
                if (response.equalsIgnoreCase("B")) {
                    boolean notDone2 = true;
                    System.out.println("What do you wish me to buy, " + name + "?");
                    while (notDone2) {
                        response = input.nextLine();
                        if (response.equalsIgnoreCase("O")) {
                            System.out.println("\nHow much Opium shall I buy, " + name + "? (You can afford " + money / opiumPrice + ")");
                            while (notDone2) {
                                int num = input.nextInt();
                                if (num <= money / opiumPrice && num >= 0) {
                                    opiumHeld += num;
                                    money -= num * opiumPrice;
                                    notDone2 = false;
                                } else if (num >= 0) {
                                    System.out.println(name + ", you can't afford that!");
                                } else {
                                    System.out.println(name + ", how am I supposed to buy " + "'" + num + "'" + " Opium?");
                                }
                            }
                        } else if (response.equalsIgnoreCase("S")) {
                            System.out.println("\nHow much Silk shall I buy, " + name + "? (You can afford " + money / silkPrice + ")");
                            while (notDone2) {
                                int num = input.nextInt();
                                if (num <= money / silkPrice && num >= 0) {
                                    silkHeld += num;
                                    money -= num * silkPrice;
                                    notDone2 = false;
                                } else if (num >= 0) {
                                    System.out.println(name + ", you can't afford that!");
                                } else {
                                    System.out.println(name + ", how am I supposed to buy " + "'" + num + "'" + " Silk?");
                                }
                            }
                        } else if (response.equalsIgnoreCase("A")) {
                            System.out.println("\nHow many Arms shall I buy, " + name + "? (You can afford " + money / armsPrice + ")");
                            while (notDone2) {
                                int num = input.nextInt();
                                if (num <= money / armsPrice && num >= 0) {
                                    armsHeld += num;
                                    money -= num * armsPrice;
                                    notDone2 = false;
                                } else if (num >= 0) {
                                    System.out.println(name + ", you can't afford that!");
                                } else {
                                    System.out.println(name + ", how am I supposed to buy " + "'" + num + "'" + " Arms?");
                                }
                            }
                        } else if (response.equalsIgnoreCase("G")) {
                            System.out.println("\nHow much General Cargo shall I buy, " + name + "? (You can afford " + money / generalPrice + ")");
                            while (notDone2) {
                                int num = input.nextInt();
                                if (num <= money / generalPrice && num >= 0) {
                                    generalHeld += num;
                                    money -= num * generalPrice;
                                    notDone2 = false;
                                } else if (num >= 0) {
                                    System.out.println(name + ", you can't afford that!");
                                } else {
                                    System.out.println(name + ", how am I supposed to buy " + "'" + num + "'" + " General Cargo?");
                                }
                            }
                        }

                    }

                } else if (response.equalsIgnoreCase("S")) {
                    boolean notDone2 = true;
                    System.out.println("What do you wish me to sell, " + name + "? (You have " + opiumHeld + ")");
                    while (notDone2) {
                        response = input.nextLine();
                        if (response.equalsIgnoreCase("O")) {
                            System.out.println("\nHow much Opium shall I sell, " + name + "?");
                            while (notDone2) {
                                int num = input.nextInt();
                                if (num <= opiumHeld && num >= 0) {
                                    opiumHeld -= num;
                                    money += num * opiumPrice;
                                    notDone2 = false;
                                } else if (num >= 0) {
                                    System.out.println(name + ", you don't have that many to sell!");
                                } else {
                                    System.out.println(name + ", how am I supposed to sell " + "'" + num + "'" + " Opium?");
                                }
                            }
                        } else if (response.equalsIgnoreCase("S")) {
                            System.out.println("\nHow much Silk shall I sell, " + name + "? (You have " + silkHeld + ")");
                            while (notDone2) {
                                int num = input.nextInt();
                                if (num <= silkHeld && num >= 0) {
                                    silkHeld -= num;
                                    money += num * silkPrice;
                                    notDone2 = false;
                                } else if (num >= 0) {
                                    System.out.println(name + ", you don't have that many to sell!");
                                } else {
                                    System.out.println(name + ", how am I supposed to sell " + "'" + num + "'" + " Silk?");
                                }
                            }
                        } else if (response.equalsIgnoreCase("A")) {
                            System.out.println("\nHow many Arms shall I sell, " + name + "? (You have " + armsHeld + ")");
                            while (notDone2) {
                                int num = input.nextInt();
                                if (num <= armsHeld && num >= 0) {
                                    armsHeld -= num;
                                    money += num * armsPrice;
                                    notDone2 = false;
                                } else if (num >= 0) {
                                    System.out.println(name + ", you don't have that many to sell!");
                                } else {
                                    System.out.println(name + ", how am I supposed to sell " + "'" + num + "'" + " Arms?");
                                }
                            }
                        } else if (response.equalsIgnoreCase("G")) {
                            System.out.println("\nHow much General Cargo shall I sell, " + name + "? (You have " + generalHeld + ")");
                            while (notDone2) {
                                int num = input.nextInt();
                                if (num <= generalHeld && num >= 0) {
                                    generalHeld -= num;
                                    money += num * generalPrice;
                                    notDone2 = false;
                                } else if (num >= 0) {
                                    System.out.println(name + ", you don't have that many to sell!");
                                } else {
                                    System.out.println(name + ", how am I supposed to sell " + "'" + num + "'" + " General Cargo?");
                                }
                            }
                        }
                    }
                } else if (response.equalsIgnoreCase("Q")) {
                    System.out.println("\n*** PLACEHOLDER FOR TRAVEL ***\n");
                    notDone = false;
                }
            }

        }
    }
    public static void main(String[] args){
        TaipanShop shop = new TaipanShop();
        shop.shop();
    }
}

