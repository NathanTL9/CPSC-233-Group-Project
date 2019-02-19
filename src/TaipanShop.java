import java.util.Random;
import java.util.Scanner;
public class TaipanShop extends Player {

    private Player player = new Player();
    private int cargoSpace = 60;
    private int currentCargo = 0;
    private int opiumPrice = 16000;
    private int silkPrice = 1600;
    private int armsPrice = 160;
    private int generalPrice = 8;

    private void updatePrices(){
        String s = "\n" + player.getName() + ", the price of ";
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

    private void printShop(){
        currentCargo = player.getOpiumHeld()+player.getGuns()*10+player.getSilkHeld()+player.getArmsHeld()+player.getGeneralHeld();
        if(cargoSpace - currentCargo < 0){
            System.out.println("Hold: Overloaded" + "          Guns: " + player.getGuns());
        }else{
            System.out.println("Hold: " + (cargoSpace-currentCargo) + "          Guns: " + player.getGuns());
        }
        System.out.println("-------------------------------------------------------------");
        System.out.println("     Opium: " + player.getOpiumHeld() + "      Silk: " + player.getSilkHeld());
        System.out.println("     Arms: " + player.getArmsHeld() + "       General: " + player.getGeneralHeld());
        System.out.println("-------------------------------------------------------------");
        System.out.println("Cash: " + player.getMoney() + "           Bank: " + player.getBank()+"\n");
        System.out.println(player.getName() + ", present prices per unit here are:");
        System.out.println("     Opium: " + opiumPrice + "    Silk: " + silkPrice);
        System.out.println("     Arms: " + armsPrice + "       General: " + generalPrice);
    }

    public void shop() {
        updatePrices();
        Scanner input = new Scanner(System.in);
        boolean notDone = true;
        if (player.getLocation() == 1) {
            while (notDone) {
                printShop();
                System.out.println("\nShall I Buy, Sell, Visit Bank, Transfer Cargo, or Quit Trading?");
                String response = input.next();
                if (response.equalsIgnoreCase("B")) {
                    boolean notDone2 = true;
                    System.out.println("What do you wish me to buy, " + player.getName() + "?");
                    while (notDone2) {
                        response = input.nextLine();
                        if (response.equalsIgnoreCase("O")) {
                            System.out.println("\nHow much Opium shall I buy, " + player.getName() + "? (You can afford " + player.getMoney() / opiumPrice + ")");
                            while (notDone2) {
                                int num = input.nextInt();
                                if (num <= player.getMoney() / opiumPrice && num >= 0) {
                                    player.setOpiumHeld(player.getOpiumHeld()+num);
                                    player.setMoney(player.getMoney()-num * opiumPrice);
                                    notDone2 = false;
                                } else if (num >= 0) {
                                    System.out.println(player.getName() + ", you can't afford that!");
                                } else {
                                    System.out.println(player.getName() + ", how am I supposed to buy " + "'" + num + "'" + " Opium?");
                                }
                            }
                        } else if (response.equalsIgnoreCase("S")) {
                            System.out.println("\nHow much Silk shall I buy, " + player.getName() + "? (You can afford " + player.getMoney() / silkPrice + ")");
                            while (notDone2) {
                                int num = input.nextInt();
                                if (num <= player.getMoney() / silkPrice && num >= 0) {
                                    player.setSilkHeld(player.getSilkHeld()+num);
                                    player.setMoney(player.getMoney()-num * silkPrice);
                                    notDone2 = false;
                                } else if (num >= 0) {
                                    System.out.println(player.getName() + ", you can't afford that!");
                                } else {
                                    System.out.println(player.getName() + ", how am I supposed to buy " + "'" + num + "'" + " Silk?");
                                }
                            }
                        } else if (response.equalsIgnoreCase("A")) {
                            System.out.println("\nHow many Arms shall I buy, " + player.getName() + "? (You can afford " + player.getMoney() / armsPrice + ")");
                            while (notDone2) {
                                int num = input.nextInt();
                                if (num <= player.getMoney() / armsPrice && num >= 0) {
                                    player.setArmsHeld(player.getArmsHeld()+num);
                                    player.setMoney(player.getMoney() - num*armsPrice);
                                    notDone2 = false;
                                } else if (num >= 0) {
                                    System.out.println(player.getName() + ", you can't afford that!");
                                } else {
                                    System.out.println(player.getName() + ", how am I supposed to buy " + "'" + num + "'" + " Arms?");
                                }
                            }
                        } else if (response.equalsIgnoreCase("G")) {
                            System.out.println("\nHow much General Cargo shall I buy, " + player.getName() + "? (You can afford " + player.getMoney() / generalPrice + ")");
                            while (notDone2) {
                                int num = input.nextInt();
                                if (num <= player.getMoney() / generalPrice && num >= 0) {
                                    player.setGeneralHeld(player.getGeneralHeld()+num);
                                    player.setMoney(player.getMoney() - num*generalPrice);
                                    notDone2 = false;
                                } else if (num >= 0) {
                                    System.out.println(player.getName() + ", you can't afford that!");
                                } else {
                                    System.out.println(player.getName() + ", how am I supposed to buy " + "'" + num + "'" + " General Cargo?");
                                }
                            }
                        }

                    }

                } else if (response.equalsIgnoreCase("S")) {
                    boolean notDone2 = true;
                    System.out.println("What do you wish me to sell, " + player.getName() + "?");
                    while (notDone2) {
                        response = input.nextLine();
                        if (response.equalsIgnoreCase("O")) {
                            System.out.println("\nHow much Opium shall I sell, " + player.getName() + "? (You have " + player.getOpiumHeld() + ")");
                            while (notDone2) {
                                int num = input.nextInt();
                                if (num <= player.getOpiumHeld() && num >= 0) {
                                    player.setOpiumHeld(player.getOpiumHeld()-num);
                                    player.setMoney(player.getMoney() + num*opiumPrice);
                                    notDone2 = false;
                                } else if (num >= 0) {
                                    System.out.println(player.getName() + ", you don't have that many to sell!");
                                } else {
                                    System.out.println(player.getName() + ", how am I supposed to sell " + "'" + num + "'" + " Opium?");
                                }
                            }
                        } else if (response.equalsIgnoreCase("S")) {
                            System.out.println("\nHow much Silk shall I sell, " + player.getName() + "? (You have " + player.getSilkHeld() + ")");
                            while (notDone2) {
                                int num = input.nextInt();
                                if (num <= player.getSilkHeld() && num >= 0) {
                                    player.setSilkHeld(player.getSilkHeld()-num);
                                    player.setMoney(player.getMoney() + num*silkPrice);
                                    notDone2 = false;
                                } else if (num >= 0) {
                                    System.out.println(player.getName() + ", you don't have that many to sell!");
                                } else {
                                    System.out.println(player.getName() + ", how am I supposed to sell " + "'" + num + "'" + " Silk?");
                                }
                            }
                        } else if (response.equalsIgnoreCase("A")) {
                            System.out.println("\nHow many Arms shall I sell, " + player.getName() + "? (You have " + player.getArmsHeld() + ")");
                            while (notDone2) {
                                int num = input.nextInt();
                                if (num <= player.getArmsHeld() && num >= 0) {
                                    player.setArmsHeld(player.getArmsHeld()-num);
                                    player.setMoney(player.getMoney() + num*armsPrice);
                                    notDone2 = false;
                                } else if (num >= 0) {
                                    System.out.println(player.getName() + ", you don't have that many to sell!");
                                } else {
                                    System.out.println(player.getName() + ", how am I supposed to sell " + "'" + num + "'" + " Arms?");
                                }
                            }
                        } else if (response.equalsIgnoreCase("G")) {
                            System.out.println("\nHow much General Cargo shall I sell, " + player.getName() + "? (You have " + player.getGeneralHeld() + ")");
                            while (notDone2) {
                                int num = input.nextInt();
                                if (num <= player.getGeneralHeld() && num >= 0) {
                                    player.setGeneralHeld(player.getGeneralHeld()-num);
                                    player.setMoney(player.getMoney() + num*generalPrice);
                                    notDone2 = false;
                                } else if (num >= 0) {
                                    System.out.println(player.getName() + ", you don't have that many to sell!");
                                } else {
                                    System.out.println(player.getName() + ", how am I supposed to sell " + "'" + num + "'" + " General Cargo?");
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
                    System.out.println("What do you wish me to buy, " + player.getName() + "?");
                    while (notDone2) {
                        response = input.nextLine();
                        if (response.equalsIgnoreCase("O")) {
                            System.out.println("\nHow much Opium shall I buy, " + player.getName() + "? (You can afford " + player.getMoney() / opiumPrice + ")");
                            while (notDone2) {
                                int num = input.nextInt();
                                if (num <= player.getMoney() / opiumPrice && num >= 0) {
                                    player.setOpiumHeld(player.getOpiumHeld()+num);
                                    player.setMoney(player.getMoney() - num*opiumPrice);
                                    notDone2 = false;
                                } else if (num >= 0) {
                                    System.out.println(player.getName() + ", you can't afford that!");
                                } else {
                                    System.out.println(player.getName() + ", how am I supposed to buy " + "'" + num + "'" + " Opium?");
                                }
                            }
                        } else if (response.equalsIgnoreCase("S")) {
                            System.out.println("\nHow much Silk shall I buy, " + player.getName() + "? (You can afford " + player.getMoney() / silkPrice + ")");
                            while (notDone2) {
                                int num = input.nextInt();
                                if (num <= player.getMoney() / silkPrice && num >= 0) {
                                    player.setSilkHeld(player.getSilkHeld()+num);
                                    player.setMoney(player.getMoney() - num*silkPrice);
                                    notDone2 = false;
                                } else if (num >= 0) {
                                    System.out.println(player.getName() + ", you can't afford that!");
                                } else {
                                    System.out.println(player.getName() + ", how am I supposed to buy " + "'" + num + "'" + " Silk?");
                                }
                            }
                        } else if (response.equalsIgnoreCase("A")) {
                            System.out.println("\nHow many Arms shall I buy, " + player.getName() + "? (You can afford " + player.getMoney() / armsPrice + ")");
                            while (notDone2) {
                                int num = input.nextInt();
                                if (num <= player.getMoney() / armsPrice && num >= 0) {
                                    player.setArmsHeld(player.getArmsHeld()+num);
                                    player.setMoney(player.getMoney() - num*armsPrice);
                                    notDone2 = false;
                                } else if (num >= 0) {
                                    System.out.println(player.getName() + ", you can't afford that!");
                                } else {
                                    System.out.println(player.getName() + ", how am I supposed to buy " + "'" + num + "'" + " Arms?");
                                }
                            }
                        } else if (response.equalsIgnoreCase("G")) {
                            System.out.println("\nHow much General Cargo shall I buy, " + player.getName() + "? (You can afford " + player.getMoney() / generalPrice + ")");
                            while (notDone2) {
                                int num = input.nextInt();
                                if (num <= player.getMoney() / generalPrice && num >= 0) {
                                    player.setGeneralHeld(player.getGeneralHeld()+num);
                                    player.setMoney(player.getMoney() - num*generalPrice);
                                    notDone2 = false;
                                } else if (num >= 0) {
                                    System.out.println(player.getName() + ", you can't afford that!");
                                } else {
                                    System.out.println(player.getName() + ", how am I supposed to buy " + "'" + num + "'" + " General Cargo?");
                                }
                            }
                        }

                    }

                } else if (response.equalsIgnoreCase("S")) {
                    boolean notDone2 = true;
                    System.out.println("What do you wish me to sell, " + player.getName() + "?");
                    while (notDone2) {
                        response = input.nextLine();
                        if (response.equalsIgnoreCase("O")) {
                            System.out.println("\nHow much Opium shall I sell, " + player.getName() + "? (You have " + player.getOpiumHeld() + ")");
                            while (notDone2) {
                                int num = input.nextInt();
                                if (num <= player.getOpiumHeld() && num >= 0) {
                                    player.setOpiumHeld(player.getOpiumHeld()-num);
                                    player.setMoney(player.getMoney() + num*opiumPrice);
                                    notDone2 = false;
                                } else if (num >= 0) {
                                    System.out.println(player.getName() + ", you don't have that many to sell!");
                                } else {
                                    System.out.println(player.getName() + ", how am I supposed to sell " + "'" + num + "'" + " Opium?");
                                }
                            }
                        } else if (response.equalsIgnoreCase("S")) {
                            System.out.println("\nHow much Silk shall I sell, " + player.getName() + "? (You have " + player.getSilkHeld() + ")");
                            while (notDone2) {
                                int num = input.nextInt();
                                if (num <= player.getSilkHeld() && num >= 0) {
                                    player.setSilkHeld(player.getSilkHeld()-num);
                                    player.setMoney(player.getMoney() + num*silkPrice);
                                    notDone2 = false;
                                } else if (num >= 0) {
                                    System.out.println(player.getName() + ", you don't have that many to sell!");
                                } else {
                                    System.out.println(player.getName() + ", how am I supposed to sell " + "'" + num + "'" + " Silk?");
                                }
                            }
                        } else if (response.equalsIgnoreCase("A")) {
                            System.out.println("\nHow many Arms shall I sell, " + player.getName() + "? (You have " + player.getArmsHeld() + ")");
                            while (notDone2) {
                                int num = input.nextInt();
                                if (num <= player.getArmsHeld() && num >= 0) {
                                    player.setArmsHeld(player.getArmsHeld()-num);
                                    player.setMoney(player.getMoney() + num*armsPrice);
                                    notDone2 = false;
                                } else if (num >= 0) {
                                    System.out.println(player.getName() + ", you don't have that many to sell!");
                                } else {
                                    System.out.println(player.getName() + ", how am I supposed to sell " + "'" + num + "'" + " Arms?");
                                }
                            }
                        } else if (response.equalsIgnoreCase("G")) {
                            System.out.println("\nHow much General Cargo shall I sell, " + player.getName() + "? (You have " + player.getGeneralHeld() + ")");
                            while (notDone2) {
                                int num = input.nextInt();
                                if (num <= player.getGeneralHeld() && num >= 0) {
                                    player.setGeneralHeld(player.getGeneralHeld()-num);
                                    player.setMoney(player.getMoney() + num*generalPrice);
                                    notDone2 = false;
                                } else if (num >= 0) {
                                    System.out.println(player.getName() + ", you don't have that many to sell!");
                                } else {
                                    System.out.println(player.getName() + ", how am I supposed to sell " + "'" + num + "'" + " General Cargo?");
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

