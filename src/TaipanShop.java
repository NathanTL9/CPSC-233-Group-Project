import java.util.Random;
import java.util.Scanner;
public class TaipanShop extends Player {

    private int cargoSpace = 60;
    private int currentCargo = 0;
    private int opiumPrice = 16000;
    private int silkPrice = 1600;
    private int armsPrice = 160;
    private int generalPrice = 8;

    public int getOpiumPrice() {
        return opiumPrice;
    }

    public void setOpiumPrice(int opiumPrice) {
        this.opiumPrice = opiumPrice;
    }

    public int getSilkPrice() {
        return silkPrice;
    }

    public void setSilkPrice(int silkPrice) {
        this.silkPrice = silkPrice;
    }

    public int getArmsPrice() {
        return armsPrice;
    }

    public void setArmsPrice(int armsPrice) {
        this.armsPrice = armsPrice;
    }

    public int getGeneralPrice() {
        return generalPrice;
    }

    public void setGeneralPrice(int generalPrice) {
        this.generalPrice = generalPrice;
    }

    private void updatePrices(){
        String s = "\n" + getName() + ", the price of ";
        double value = 80*Math.random();
        Random rand = new Random();

        setOpiumPrice((rand.nextInt(201) + 60)*100);
        setSilkPrice((rand.nextInt(201) + 60)*10);
        setArmsPrice((rand.nextInt(21) + 6)*10);
        setGeneralPrice(rand.nextInt(17) + 4);

        if(value < 8){
            if(value < 2){
                if(value < 1){
                    setOpiumPrice(getOpiumPrice()/5);
                    System.out.println(s + "Opium has dropped to " + getOpiumPrice() +"!!!\n");
                }else{
                    setOpiumPrice(getOpiumPrice()*5);
                    System.out.println(s + "Opium has risen to " + getOpiumPrice() +"!!!\n");
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
        currentCargo = getOpiumHeld()+getGuns()*10+getSilkHeld()+getArmsHeld()+getGeneralHeld();
        if(cargoSpace - currentCargo < 0){
            System.out.println("Hold: Overloaded" + "          Guns: " + getGuns());
        }else{
            System.out.println("Hold: " + (cargoSpace-currentCargo) + "          Guns: " + getGuns());
        }
        System.out.println("-------------------------------------------------------------");
        System.out.println("     Opium: " + getOpiumHeld() + "      Silk: " + getSilkHeld());
        System.out.println("     Arms: " + getArmsHeld() + "       General: " + getGeneralHeld());
        System.out.println("-------------------------------------------------------------");
        System.out.println("Cash: " + getMoney() + "           Bank: " + getBank()+"\n");
        System.out.println(getName() + ", present prices per unit here are:");
        System.out.println("     Opium: " + opiumPrice + "    Silk: " + silkPrice);
        System.out.println("     Arms: " + armsPrice + "       General: " + generalPrice);
    }

    public void shop() {
        updatePrices();
        Scanner input = new Scanner(System.in);
        boolean notDone = true;
        if (getLocation() == 1) {
            while (notDone) {
                printShop();
                System.out.println("\nShall I Buy, Sell, Visit Bank, Transfer Cargo, or Quit Trading?");
                String response = input.next();
                if (response.equalsIgnoreCase("B")) {
                    boolean notDone2 = true;
                    System.out.println("What do you wish me to buy, " + getName() + "?");
                    while (notDone2) {
                        response = input.nextLine();
                        if (response.equalsIgnoreCase("O")) {
                            System.out.println("\nHow much Opium shall I buy, " + getName() + "? (You can afford " + getMoney() / opiumPrice + ")");
                            while (notDone2) {
                                int num = input.nextInt();
                                if (num <= getMoney() / opiumPrice && num >= 0) {
                                    setOpiumHeld(getOpiumHeld()+num);
                                    setMoney(getMoney()-num * opiumPrice);
                                    notDone2 = false;
                                } else if (num >= 0) {
                                    System.out.println(getName() + ", you can't afford that!");
                                } else {
                                    System.out.println(getName() + ", how am I supposed to buy " + "'" + num + "'" + " Opium?");
                                }
                            }
                        } else if (response.equalsIgnoreCase("S")) {
                            System.out.println("\nHow much Silk shall I buy, " + getName() + "? (You can afford " + getMoney() / silkPrice + ")");
                            while (notDone2) {
                                int num = input.nextInt();
                                if (num <= getMoney() / silkPrice && num >= 0) {
                                    setSilkHeld(getSilkHeld()+num);
                                    setMoney(getMoney()-num * silkPrice);
                                    notDone2 = false;
                                } else if (num >= 0) {
                                    System.out.println(getName() + ", you can't afford that!");
                                } else {
                                    System.out.println(getName() + ", how am I supposed to buy " + "'" + num + "'" + " Silk?");
                                }
                            }
                        } else if (response.equalsIgnoreCase("A")) {
                            System.out.println("\nHow many Arms shall I buy, " + getName() + "? (You can afford " + getMoney() / armsPrice + ")");
                            while (notDone2) {
                                int num = input.nextInt();
                                if (num <= getMoney() / armsPrice && num >= 0) {
                                    setArmsHeld(getArmsHeld()+num);
                                    setMoney(getMoney() - num*armsPrice);
                                    notDone2 = false;
                                } else if (num >= 0) {
                                    System.out.println(getName() + ", you can't afford that!");
                                } else {
                                    System.out.println(getName() + ", how am I supposed to buy " + "'" + num + "'" + " Arms?");
                                }
                            }
                        } else if (response.equalsIgnoreCase("G")) {
                            System.out.println("\nHow much General Cargo shall I buy, " + getName() + "? (You can afford " + getMoney() / generalPrice + ")");
                            while (notDone2) {
                                int num = input.nextInt();
                                if (num <= getMoney() / generalPrice && num >= 0) {
                                    setGeneralHeld(getGeneralHeld()+num);
                                    setMoney(getMoney() - num*generalPrice);
                                    notDone2 = false;
                                } else if (num >= 0) {
                                    System.out.println(getName() + ", you can't afford that!");
                                } else {
                                    System.out.println(getName() + ", how am I supposed to buy " + "'" + num + "'" + " General Cargo?");
                                }
                            }
                        }

                    }

                } else if (response.equalsIgnoreCase("S")) {
                    boolean notDone2 = true;
                    System.out.println("What do you wish me to sell, " + getName() + "?");
                    while (notDone2) {
                        response = input.nextLine();
                        if (response.equalsIgnoreCase("O")) {
                            System.out.println("\nHow much Opium shall I sell, " + getName() + "? (You have " + getOpiumHeld() + ")");
                            while (notDone2) {
                                int num = input.nextInt();
                                if (num <= getOpiumHeld() && num >= 0) {
                                    setOpiumHeld(getOpiumHeld()-num);
                                    setMoney(getMoney() + num*opiumPrice);
                                    notDone2 = false;
                                } else if (num >= 0) {
                                    System.out.println(getName() + ", you don't have that many to sell!");
                                } else {
                                    System.out.println(getName() + ", how am I supposed to sell " + "'" + num + "'" + " Opium?");
                                }
                            }
                        } else if (response.equalsIgnoreCase("S")) {
                            System.out.println("\nHow much Silk shall I sell, " + getName() + "? (You have " + getSilkHeld() + ")");
                            while (notDone2) {
                                int num = input.nextInt();
                                if (num <= getSilkHeld() && num >= 0) {
                                    setSilkHeld(getSilkHeld()-num);
                                    setMoney(getMoney() + num*silkPrice);
                                    notDone2 = false;
                                } else if (num >= 0) {
                                    System.out.println(getName() + ", you don't have that many to sell!");
                                } else {
                                    System.out.println(getName() + ", how am I supposed to sell " + "'" + num + "'" + " Silk?");
                                }
                            }
                        } else if (response.equalsIgnoreCase("A")) {
                            System.out.println("\nHow many Arms shall I sell, " + getName() + "? (You have " + getArmsHeld() + ")");
                            while (notDone2) {
                                int num = input.nextInt();
                                if (num <= getArmsHeld() && num >= 0) {
                                    setArmsHeld(getArmsHeld()-num);
                                    setMoney(getMoney() + num*armsPrice);
                                    notDone2 = false;
                                } else if (num >= 0) {
                                    System.out.println(getName() + ", you don't have that many to sell!");
                                } else {
                                    System.out.println(getName() + ", how am I supposed to sell " + "'" + num + "'" + " Arms?");
                                }
                            }
                        } else if (response.equalsIgnoreCase("G")) {
                            System.out.println("\nHow much General Cargo shall I sell, " + getName() + "? (You have " + getGeneralHeld() + ")");
                            while (notDone2) {
                                int num = input.nextInt();
                                if (num <= getGeneralHeld() && num >= 0) {
                                    setGeneralHeld(getGeneralHeld()-num);
                                    setMoney(getMoney() + num*generalPrice);
                                    notDone2 = false;
                                } else if (num >= 0) {
                                    System.out.println(getName() + ", you don't have that many to sell!");
                                } else {
                                    System.out.println(getName() + ", how am I supposed to sell " + "'" + num + "'" + " General Cargo?");
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
                    System.out.println("What do you wish me to buy, " + getName() + "?");
                    while (notDone2) {
                        response = input.nextLine();
                        if (response.equalsIgnoreCase("O")) {
                            System.out.println("\nHow much Opium shall I buy, " + getName() + "? (You can afford " + getMoney() / opiumPrice + ")");
                            while (notDone2) {
                                int num = input.nextInt();
                                if (num <= getMoney() / opiumPrice && num >= 0) {
                                    setOpiumHeld(getOpiumHeld()+num);
                                    setMoney(getMoney() - num*opiumPrice);
                                    notDone2 = false;
                                } else if (num >= 0) {
                                    System.out.println(getName() + ", you can't afford that!");
                                } else {
                                    System.out.println(getName() + ", how am I supposed to buy " + "'" + num + "'" + " Opium?");
                                }
                            }
                        } else if (response.equalsIgnoreCase("S")) {
                            System.out.println("\nHow much Silk shall I buy, " + getName() + "? (You can afford " + getMoney() / silkPrice + ")");
                            while (notDone2) {
                                int num = input.nextInt();
                                if (num <= getMoney() / silkPrice && num >= 0) {
                                    setSilkHeld(getSilkHeld()+num);
                                    setMoney(getMoney() - num*silkPrice);
                                    notDone2 = false;
                                } else if (num >= 0) {
                                    System.out.println(getName() + ", you can't afford that!");
                                } else {
                                    System.out.println(getName() + ", how am I supposed to buy " + "'" + num + "'" + " Silk?");
                                }
                            }
                        } else if (response.equalsIgnoreCase("A")) {
                            System.out.println("\nHow many Arms shall I buy, " + getName() + "? (You can afford " + getMoney() / armsPrice + ")");
                            while (notDone2) {
                                int num = input.nextInt();
                                if (num <= getMoney() / armsPrice && num >= 0) {
                                    setArmsHeld(getArmsHeld()+num);
                                    setMoney(getMoney() - num*armsPrice);
                                    notDone2 = false;
                                } else if (num >= 0) {
                                    System.out.println(getName() + ", you can't afford that!");
                                } else {
                                    System.out.println(getName() + ", how am I supposed to buy " + "'" + num + "'" + " Arms?");
                                }
                            }
                        } else if (response.equalsIgnoreCase("G")) {
                            System.out.println("\nHow much General Cargo shall I buy, " + getName() + "? (You can afford " + getMoney() / generalPrice + ")");
                            while (notDone2) {
                                int num = input.nextInt();
                                if (num <= getMoney() / generalPrice && num >= 0) {
                                    setGeneralHeld(getGeneralHeld()+num);
                                    setMoney(getMoney() - num*generalPrice);
                                    notDone2 = false;
                                } else if (num >= 0) {
                                    System.out.println(getName() + ", you can't afford that!");
                                } else {
                                    System.out.println(getName() + ", how am I supposed to buy " + "'" + num + "'" + " General Cargo?");
                                }
                            }
                        }

                    }

                } else if (response.equalsIgnoreCase("S")) {
                    boolean notDone2 = true;
                    System.out.println("What do you wish me to sell, " + getName() + "?");
                    while (notDone2) {
                        response = input.nextLine();
                        if (response.equalsIgnoreCase("O")) {
                            System.out.println("\nHow much Opium shall I sell, " + getName() + "? (You have " + getOpiumHeld() + ")");
                            while (notDone2) {
                                int num = input.nextInt();
                                if (num <= getOpiumHeld() && num >= 0) {
                                    setOpiumHeld(getOpiumHeld()-num);
                                    setMoney(getMoney() + num*opiumPrice);
                                    notDone2 = false;
                                } else if (num >= 0) {
                                    System.out.println(getName() + ", you don't have that many to sell!");
                                } else {
                                    System.out.println(getName() + ", how am I supposed to sell " + "'" + num + "'" + " Opium?");
                                }
                            }
                        } else if (response.equalsIgnoreCase("S")) {
                            System.out.println("\nHow much Silk shall I sell, " + getName() + "? (You have " + getSilkHeld() + ")");
                            while (notDone2) {
                                int num = input.nextInt();
                                if (num <= getSilkHeld() && num >= 0) {
                                    setSilkHeld(getSilkHeld()-num);
                                    setMoney(getMoney() + num*silkPrice);
                                    notDone2 = false;
                                } else if (num >= 0) {
                                    System.out.println(getName() + ", you don't have that many to sell!");
                                } else {
                                    System.out.println(getName() + ", how am I supposed to sell " + "'" + num + "'" + " Silk?");
                                }
                            }
                        } else if (response.equalsIgnoreCase("A")) {
                            System.out.println("\nHow many Arms shall I sell, " + getName() + "? (You have " + getArmsHeld() + ")");
                            while (notDone2) {
                                int num = input.nextInt();
                                if (num <= getArmsHeld() && num >= 0) {
                                    setArmsHeld(getArmsHeld()-num);
                                    setMoney(getMoney() + num*armsPrice);
                                    notDone2 = false;
                                } else if (num >= 0) {
                                    System.out.println(getName() + ", you don't have that many to sell!");
                                } else {
                                    System.out.println(getName() + ", how am I supposed to sell " + "'" + num + "'" + " Arms?");
                                }
                            }
                        } else if (response.equalsIgnoreCase("G")) {
                            System.out.println("\nHow much General Cargo shall I sell, " + getName() + "? (You have " + getGeneralHeld() + ")");
                            while (notDone2) {
                                int num = input.nextInt();
                                if (num <= getGeneralHeld() && num >= 0) {
                                    setGeneralHeld(getGeneralHeld()-num);
                                    setMoney(getMoney() + num*generalPrice);
                                    notDone2 = false;
                                } else if (num >= 0) {
                                    System.out.println(getName() + ", you don't have that many to sell!");
                                } else {
                                    System.out.println(getName() + ", how am I supposed to sell " + "'" + num + "'" + " General Cargo?");
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

