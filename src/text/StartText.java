package text;

import gui.TaipanShopGUI;
import logic.FileSaving;
import logic.Player;
import logic.StartLogic;
import java.util.Scanner;

public class StartText extends Player {

    /**
     * Class Constructor that takes in a type player as a parameter
     *
     * @param player object of the class Player
     */
    public StartText(Player player) {
        Player playerDummy = new Player(player);
        setPlayer(playerDummy);
    }

    /**
     * Initializes the game by asking for your name and if you would like to start with either: 1) money and a debt or
     * 2) guns and no cash/debt.
     */
    public void start() {
        try{
            Scanner userInput = new Scanner(System.in);

            //See if the player wants to load up a previous save
            System.out.println("Taipan, do you want to...\n\t1) load a save file?\n\t\t\t>> or <<\n\t2) make a new save file?");
            while (true) {
                int input = userInput.nextInt();
                //Will attempt to load the save if it's not empty
                if (input == 1) {
                    FileSaving saving = new FileSaving();
                    if (saving.loadFile() != null) {
                        TaipanShopText taipanShopText = new TaipanShopText(saving.loadFile());
                        taipanShopText.shop();
                    } else {
                        System.out.println("There are no previous saves!");
                    }
                    break;
                }
                //Just makes a new save
                else if (input == 2) {
                    break;
                } else {
                    System.out.println("Invalid input, please try again.");
                }
            }

            //Asks the player about their firm name and what kind of start they want
            System.out.println("Taipan, \nWhat will you name your firm:");
            setName(userInput.nextLine());
            setName(userInput.nextLine());
            System.out.println("Do you want to start . . .\n\t1) With cash (and a debt)\n\t\t\t>> or <<\n\t" + "2) With five guns and no cash (But no debt!)?\n ");
            while (true) {
                int input = userInput.nextInt();
                StartLogic startLogic = new StartLogic(getPlayer());
                //If the player wants the money and debt starting
                if (input == 1) {
                    startLogic.money_and_debt();
                    setPlayer(startLogic.getPlayer());
                    break;
                }
                //If the player wants the gun start
                else if (input == 2) {
                    startLogic.guns();
                    setPlayer(startLogic.getPlayer());
                    break;
                }
                else {
                    System.out.println("Invalid input, please try again.");
                }
            }
            // purely for testing purposes.
            StartLogic startLogic = new StartLogic(getPlayer());
            if (getName().equalsIgnoreCase("Vikram")) {
                startLogic.cheat();
                setPlayer(startLogic.getPlayer());
            }
            TaipanShopText taipanShopText = new TaipanShopText(startLogic.getPlayer());
            taipanShopText.shop();
        }
        catch (Exception e){
            StartText startText = new StartText(getPlayer());
            startText.start();
        }
    }
}
