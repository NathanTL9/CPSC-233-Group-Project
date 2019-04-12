package logic;

import java.util.Random;

public class RandomEventLogic extends Player{

    /**
     * constructor; only runs when a Player object is provided. The constructor is fully encapsulated.
     * @param player is a Player object that will be copied and the player instance variable is set to the copy.
     */
    public RandomEventLogic(Player player) {
        Player playerDummy = new Player(player);
        setPlayer(playerDummy);
    }

    /**
     * Method that generates a random number and based on that number, a random event happens.
     * @return randGenNum and itemPrice, randGen number is the number which dictates the event, the item price is how much it will cost
     */
    public int[] randEvent() {
        Random rand = new Random();
        int itemPrice;
        int randGenNum = rand.nextInt(3) + 1;
        while(true){
            //Buy Guns
            if (randGenNum == 1) {
                itemPrice = (int) ((getPlayer().getMoney() * 0.1) + 10);
                break;
            }
            //Liu Yuen
            if (randGenNum == 2) {
                itemPrice = (int) ((getPlayer().getMoney() * 0.1) + 10);
                setAttackingShips(true);
                break;
            }
            //Ship Repair
            if (randGenNum == 3 && getHP() < 100) {
                itemPrice = (int) ((100 - getPlayer().getHP()) * 10 + 10);
                break;
            }
            //Forces random event to be gun related if nothing else is avaliable
            else {
                randGenNum = 2;
            }
        }
        return new int[]{randGenNum,itemPrice};
    }

}
