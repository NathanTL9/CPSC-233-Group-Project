package text;

import logic.Player;

import java.util.Scanner;

public class StartText extends Player {

    public StartText(Player player) {
        Player playerDummy = new Player(player);
        setPlayer(playerDummy);
    }

    /**
     * Initializes the game by asking for your name and if you would like to start with either: 1) money and a debt or
     * 2) guns and no cash/debt.
     */
    public void start() {
        Scanner userInput = new Scanner(System.in);
        System.out.println("Taipan, \nWhat will you name your firm:");
        setName(userInput.nextLine());
        System.out.println("Do you want to start . . .\n\t1) With cash (and a debt)\n\t\t\t>> or <<\n\t" + "2) With five guns and no cash (But no debt!)?\n ");
        int input = userInput.nextInt();
        if (input == 1) {
            setMoney(400);
            setDebt(5000);

        }
        if (input == 2) {
            setGuns(5);
        }
        // purely for testing purposes.
        if (getName().equalsIgnoreCase("Vikram")) {
            setMoney(999999999);
            setBank(999999999);
            setGuns(999);
            setHP(99999999);
            setCargoSpace(99999999);
        }
    }
}
