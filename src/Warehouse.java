import java.util.Scanner;

public class Warehouse {
    private int wOpium = 0;
    private int wSilk = 0;
    private int wGeneral = 0;
    private int wArms = 0;
    private Player player;


    public void setPlayer(Player player) {
        Player playerDumy = new Player(player);
        this.player = playerDumy;
    }

    public Player getPlayer() {
        Player playerDummy = new Player(player);
        return playerDummy;
    }

    public Warehouse(Player player) {
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
            if (Integer.parseInt(amount) <= player.getOpiumHeld() || Integer.parseInt(amount) <= player.getSilkHeld() || Integer.parseInt(amount) <= player.getGeneralHeld() || Integer.parseInt(amount) <= player.getArmsHeld()) {
                finalAmount = Integer.parseInt(amount);
                askGood = true;
            } else {
                System.out.println("Nice try but you don't have any items of that quantity!");
                askGood = false;
            }
            if (askGood == true) {
                String good;
                System.out.println("Please enter a good to transfer O, S, G, A :");
                good = keyboard.nextLine();
                int held = 0;
                if (Integer.parseInt(amount) > 0) {
                    if (good.equalsIgnoreCase("O")) {
                        if (player.getOpiumHeld() >= Integer.parseInt(amount)) {
                            this.wOpium += finalAmount;
                            held = player.getOpiumHeld();
                            player.setOpiumHeld(held - finalAmount);
                            System.out.println(player.getOpiumHeld());
                        } else {
                            System.out.println("You don't even have that much opium!");
                        }
                    } else if (good.equalsIgnoreCase("S")) {
                        if (player.getSilkHeld() >= Integer.parseInt(amount)) {
                            this.wSilk += finalAmount;
                            held = player.getSilkHeld();
                            player.setSilkHeld(held - finalAmount);
                        } else {
                            System.out.println("You don't even have that much silk!");

                        }
                    } else if (good.equalsIgnoreCase("G")) {
                        if (player.getGeneralHeld() >= Integer.parseInt(amount)) {
                            this.wGeneral += finalAmount;
                            held = player.getGeneralHeld();
                            player.setGeneralHeld(held - finalAmount);
                        } else {
                            System.out.println("You don't even have that much general cargo!");

                        }
                    } else if (good.equalsIgnoreCase("A")) {
                        if (player.getArmsHeld() >= Integer.parseInt(amount)) {
                            this.wArms += finalAmount;
                            held = player.getArmsHeld();
                            player.setArmsHeld(held - finalAmount);
                        } else {
                            System.out.println("You don't even have that much Arms!");
                        }
                    }
                } else {
                    System.out.println("Sorry this transfer cannot be made");
                }
            }
        } catch (Exception e) {
            System.out.println("Wait, that's not a valid input please try again");
        }
    }

    public void removeAmount() {
        String amount;
        boolean askGood = false;
        int finalAmount = 0;
        System.out.println("Please enter the amount of the good you would like to REMOVE");
        Scanner keyboard = new Scanner(System.in);
        amount = keyboard.nextLine();
        if (Integer.parseInt(amount) <= wOpium || Integer.parseInt(amount) <=wSilk || Integer.parseInt(amount) <= wGeneral || Integer.parseInt(amount) <= wArms) {
            finalAmount = Integer.parseInt(amount);
            askGood = true;
        } else {
            System.out.println("Nice try but you don't have any items of that quantity in the warehouse!");
            askGood = false;
        }

        if (askGood == true) {
            String good;
            System.out.println("Please enter a good to transfer O, S, G, A :");
            good = keyboard.nextLine();
            int held = 0;
            if (Integer.parseInt(amount) > 0) {
                if (good.equalsIgnoreCase("O")) {
                    if (this.wOpium >= Integer.parseInt(amount)) {
                        this.wOpium -= Integer.parseInt(amount);
                        held = player.getOpiumHeld();
                        player.setOpiumHeld(held + finalAmount);
                    } else {
                        System.out.println("You don't have that much opium stored in the warehouse!");
                    }
                } else if (good.equalsIgnoreCase("S")) {
                    if (this.wSilk >= Integer.parseInt(amount)) {
                        this.wSilk -= Integer.parseInt(amount);
                        held = player.getSilkHeld();
                        player.setSilkHeld(held + finalAmount);
                    }
                    else{
                        System.out.println("You don't have that much silk stored in the warehouse!");
                    }
                } else if (good.equalsIgnoreCase("G")) {
                    if (this.wGeneral >= Integer.parseInt(amount)) {
                        this.wGeneral -= Integer.parseInt(amount);
                        held = player.getGeneralHeld();
                        player.setGeneralHeld(held + finalAmount);
                    }
                    else{
                        System.out.println("You don't have that much general cargo stored in the warehouse!");

                    }
                } else if (good.equalsIgnoreCase("A")) {
                    if (this.wArms >= Integer.parseInt(amount)) {
                        this.wArms -= Integer.parseInt(amount);
                        held = player.getArmsHeld();
                        player.setArmsHeld(held + finalAmount);
                    }
                    else{
                        System.out.println("You don't have that much arms stored in the warehouse!");

                    }
                }
            } else {
                System.out.println("Sorry this transfer cannot be made");
            }
        }
    }


    public void showWarehouse() {
        System.out.println("--------------------\nWarehouse\n--------------------");
        System.out.println("Opium : " + this.wOpium);
        System.out.println("Silk : " + this.wSilk);
        System.out.println("General : " + this.wGeneral);
        System.out.println("Arms : " + this.wArms);
    }


    public void changeWarehouse() {
        boolean keepGoing = true;
        while (keepGoing) {
            this.showWarehouse();
            String input = " ";
            System.out.println("Would you like to add(A) or remove(R) resources? ");
            Scanner keyboard = new Scanner(System.in);
            input = keyboard.next();
            if (input.equalsIgnoreCase("R")) {
                this.removeAmount();
                this.showWarehouse();
            } else if (input.equalsIgnoreCase("A")) {
                this.addAmount();
                this.showWarehouse();
            }

            String check;
            System.out.println("Would you like to do any other business? Y / N?");
            check = keyboard.nextLine();
            check = keyboard.nextLine();

            if (check.equalsIgnoreCase("Y")) {
                keepGoing = true;
            } else if (check.equalsIgnoreCase("N")) {
                keepGoing = false;
            }
        }
    }

    public static void main(String[] args) {

    }
}
