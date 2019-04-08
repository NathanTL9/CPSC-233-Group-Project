package text;

import logic.Player;
import logic.StartLogic;
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
        StartLogic startLogic = new StartLogic(getPlayer());
        if (input == 1) {
        startLogic.money_and_debt();
        }
        if (input == 2) {
        startLogic.guns();
        }
        // purely for testing purposes.
        if (getName().equalsIgnoreCase("Vikram")) {
            startLogic.cheat();
        }
    }
}
