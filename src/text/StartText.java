package text;

import gui.TaipanShopGUI;
import logic.FileSaving;
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

        System.out.println("Taipan, do you want to...\n\t1) load a save file?\n\t\t\t>> or <<\n\t2) make a new save file?");
        while (true) {
            int input = userInput.nextInt();
            if(input == 1){
                FileSaving saving = new FileSaving();
                if(saving.loadFile() != null){
                    TaipanShopText taipanShopText = new TaipanShopText(saving.loadFile());
                    taipanShopText.shop();
                }
                else{
                    System.out.println("There are no previous saves!");
                }
                break;
            }
            else if(input == 2){
                break;
            }
            else{
                System.out.println("Invalid input, please try again.");
            }
        }



        System.out.println("Taipan, \nWhat will you name your firm:");
        setName(userInput.nextLine());
        System.out.println("Do you want to start . . .\n\t1) With cash (and a debt)\n\t\t\t>> or <<\n\t" + "2) With five guns and no cash (But no debt!)?\n ");
        while (true) {
            int input = userInput.nextInt();
            StartLogic startLogic = new StartLogic(getPlayer());
            if (input == 1) {
                startLogic.money_and_debt();
                break;
            }
            else if (input == 2) {
                startLogic.guns();
                break;
            }
            // purely for testing purposes.
            else if (getName().equalsIgnoreCase("Vikram")) {
                startLogic.cheat();
            }
            else {
                System.out.println("Invalid input, please try again.");
            }
        }
        TaipanShopText taipanShopText = new TaipanShopText(getPlayer());
        taipanShopText.shop();
    }
}
