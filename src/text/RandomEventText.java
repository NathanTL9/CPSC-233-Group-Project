package text;

import gui.TaipanShopGUI;
import logic.Player;
import logic.RandomEventLogic;

import java.util.Scanner;

public class RandomEventText extends Player {

    /**
     * Class Constructor that takes in a type player as a parameter
     *
     * @param player object of the class Player
     */
    public RandomEventText(Player player) {
        Player playerDummy = new Player(player);
        setPlayer(playerDummy);
    }

    /**
     * Picks a random number and based off that number the player is put into a random event
     * The random event can be anything from ship repair to paying bribes to the enemy fleet
     */
    public void randomEvent(){
        /*Pick a random number dictating the events that could happen.
         * 1: New gun for player
         * 2: Paying Liu Yuen
         * 3: Repairing the Ship
         */
        RandomEventLogic randomEventLogic = new RandomEventLogic(getPlayer());
        int[] randEvent = randomEventLogic.randEvent();
        int eventNumber = randEvent[0];
        int itemPrice = randEvent[1];

        if(eventNumber == 1){
            System.out.println("\nA vendor is selling a gun for $" + itemPrice + " for a gun?");
        }
        if(eventNumber == 2){
            System.out.println("\nLiu Yuen asks $" + itemPrice + " in donation to the temple of Tin Hau, the Sea Goddess");
        }
        if(eventNumber == 3){
            System.out.println("\nMc Henry from the Hong Kong shipyard has arrived,\nwould be willing to repair your ship for $" + itemPrice);
        }

        //Only runs if the player doesn't have enough space and is given a gun
        if((eventNumber == 1 && getCargoSpace() < 10)){
            TaipanShopText taipanShopText = new TaipanShopText(getPlayer());
            taipanShopText.shop();
        }
        //Only runs if the player has 100 or greater HP and they got the ship repair man
        if((eventNumber == 3 && getPlayer().getHP() >= 100)){
            TaipanShopText taipanShopText = new TaipanShopText(getPlayer());
            taipanShopText.shop();
        }

        //Runs for as long as the player doesn't decide if they want to pay
        while(true){
            System.out.println("Would you like to pay? (Y)es or (N)o");
            Scanner keyboard = new Scanner(System.in);
            String input = keyboard.next();
            if (input.equalsIgnoreCase("Y") && getPlayer().getMoney() > itemPrice) {
                //Buy Guns
                if (eventNumber == 1 && (getCargoSpace() >= 10)) {
                    setGuns(getPlayer().getGuns() + 1);
                    setMoney(getPlayer().getMoney() - itemPrice);

                    TaipanShopText taipanShopText = new TaipanShopText(getPlayer());
                    taipanShopText.shop();
                }

                //Liu Yuen
                if (eventNumber == 2) {
                    setAttackingShips(false);
                    setMoney(getPlayer().getMoney() - itemPrice);

                    TaipanShopText taipanShopText = new TaipanShopText(getPlayer());
                    taipanShopText.shop();
                }

                //Ship Repair
                if (eventNumber == 3 && getPlayer().getHP() != 100) {
                    setHP(100);
                    setMoney(getPlayer().getMoney() - itemPrice);

                    TaipanShopText taipanShopText = new TaipanShopText(getPlayer());
                    taipanShopText.shop();
                }


            }
            else {
                System.out.println("Sorry you don't have enough money");
            }
            //If the player decides to leave then it will send them back to TaipanShop
            if(input.equalsIgnoreCase("N")){
                System.out.println("Aye aye Taipan, we'll send them off!\n");
                TaipanShopText taipanShopText = new TaipanShopText(getPlayer());
                taipanShopText.shop();
            }
        }

    }
}
