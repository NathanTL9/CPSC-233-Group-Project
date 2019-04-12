package text;

import logic.Player;
import logic.TravelLogic;

import java.util.Random;
import java.util.Scanner;

public class TravelText extends Player {

    /**
     * constructor; only runs when a Player object is provided. The constructor is fully encapsulated.
     *
     * @param player is a Player object that will be copied and the player instance variable is set to the copy.
     */
    public TravelText(Player player) {
        Player playerDummy = new Player(player);
        setPlayer(playerDummy);
    }

    /**
     * Based on random chance either attacks the player with enemy ships, throws them to a different location or does nothing.
     *
     * @param locationOfTravel is used to see where the player is going to travel, just in case their location is changed
     *                         by a typhoon.
     **/
    private void randomEventSea(int locationOfTravel) throws Exception {
        Random rand = new Random();
        int randGenNum = rand.nextInt(3) + 1;
        if (randGenNum == 1) {
            ShipWarfareText shipWarfareText = new ShipWarfareText(getPlayer());
            shipWarfareText.peasantFleetAttack();
            setPlayer(shipWarfareText.getPlayer());
        } else if (randGenNum == 2) {
            TravelLogic travelLogic = new TravelLogic(getPlayer());
            travelLogic.disaster(locationOfTravel);
            setPlayer(travelLogic.getPlayer());

            System.out.println("We made it!");
        }
    }

    /**
     * Used to travel between different areas inside of the game world.
     * If the player's inventory is too full it won't run.
     * Also calculates loan and bank interest between the jumps between islands.
     **/
    public void travelTo() {
        Scanner keyboard = new Scanner(System.in);
        boolean hasTraveled = false;

        //Only lets the player leave the port if their inventory is greater than or equal to the sum of the items in the inventory.
        if (getCargoSpace() >= (getOpiumHeld() + (getGuns() * 10) + getSilkHeld() + getArmsHeld() + getGeneralHeld())) {
            traveling(keyboard, hasTraveled);
        } else {
            System.out.println(getName() + " the cargo is too heavy! We can't set sail!");
            TaipanShopText taipanShopText = new TaipanShopText(getPlayer());
            taipanShopText.shop();
            setPlayer(taipanShopText.getPlayer());
        }
    }

    /**
     * The traveling method, it changes the location of the player and increments their interest and debt everytime the player travels
     * Also allows for the player to be attacked by enemy ships and to be hit by random encounters.
     * @param keyboard The Scanner object which allows for the program to respond to the user
     * @param hasTraveled Checks whether the user has traveled or not
     */
    public void traveling(Scanner keyboard, boolean hasTraveled) {
        String response;
        int tempInt;
        while (true) {
            System.out.println("\n" + getName() + ", do you wish to go to:\n");
            System.out.println("1) Hong Kong, 2) Shanghai, 3) Nagasaki,\n4) Saigon, 5) Manila, 6) Singapore, or 7) Batavia?");

            response = keyboard.nextLine();
            //Sends the player back to shop if they want to quit
            //if(response.equalsIgnoreCase("Q")){
            //    TaipanShopText taipanShopText = new TaipanShopText(getPlayer());
            //    taipanShopText.shop();
            //}
            //Just in case the player types something that was not intended. It will refresh the question and ask it again
            try {
                tempInt = Integer.parseInt(response);
                //Makes sure you can't travel to your own location.
                if (tempInt != getLocation()) {
                    randomEventSea(tempInt);

                    //Checks the seaAtlas to see if the player can go to their location
                    TravelLogic travelLogic = new TravelLogic(getPlayer());
                    travelLogic.seaAtlas(tempInt);
                    setPlayer(travelLogic.getPlayer());

                    hasTraveled = true;
                    setBank((int) (getBank() * 1.01));
                    setDebt((int) (getDebt() * 1.01));
                    setIsPriceChanged(2);

                } else System.out.println("\nYou're already here " + getName() + ".");
            } catch (Exception e) {
                System.out.print("\nSorry, " + getName() + " could you say that again?");
            }
            //If they've traveled then it randomly selects whether the player should go to the shop or a random event
            if (hasTraveled) {

                Random rand = new Random();
                int randGenNum = rand.nextInt(3) + 1;
                //Chance of going to shop
                if(randGenNum >= 2) {
                    TaipanShopText taipanShopText = new TaipanShopText(getPlayer());
                    taipanShopText.shop();
                }
                //Chance of reaching a random event
                else {
                    RandomEventText randomEventText = new RandomEventText(getPlayer());
                    randomEventText.randomEvent();
                    setPlayer(randomEventText.getPlayer());
                }
                break;

            }
        }
    }
}

