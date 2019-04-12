package text;

import gui.TaipanShopGUI;
import logic.Player;
import logic.RandomEventLogic;

import java.util.Scanner;

public class RandomEventText extends Player {
    public RandomEventText(Player player) {
        Player playerDummy = new Player(player);
        setPlayer(playerDummy);
    }

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

        if((eventNumber == 1 && getCargoSpace() < 10)){
            TaipanShopText taipanShopText = new TaipanShopText(getPlayer());
            taipanShopText.shop();
        }
        if((eventNumber == 3 && getPlayer().getHP() >= 100)){
            TaipanShopText taipanShopText = new TaipanShopText(getPlayer());
            taipanShopText.shop();
        }


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
            if(input.equalsIgnoreCase("N")){
                System.out.println("Aye aye Taipan, we'll send them off!\n");
                TaipanShopText taipanShopText = new TaipanShopText(getPlayer());
                taipanShopText.shop();
            }
        }

    }
}
