package logic;

import java.util.Random;

/**
 * 2019-03-10 (Edited on 2019-04-07)
 * Author: Haris Muhammad
 * ShipWarfareLogic class, logic for ships which the user can attack or run from
 */


public class ShipWarfareLogic extends Player {

    private int numOfShips = 0;
    private int startingShips = 0;
    private int counter = 0;

    /**
     * constructor; only runs when a Player object is provided. The constructor is fully encapsulated.
     *
     * @param player is a Player object that will be copied and the player instance variable is set to the copy.
     */

    public ShipWarfareLogic(Player player) {
        Player playerDummy = new Player(player);
        this.setPlayer(playerDummy);
    }


    /**
     * setter method that takes in an integer as an argument
     *
     * @param numOfShips the number of ships to be used in the peasant fleet attack
     */
    public void setNumOfShips(int numOfShips) {
        counter++;
        this.numOfShips = numOfShips;
        if (counter == 1) {
            startingShips = numOfShips;
        }
    }

    /**
     * get the number of ships attacking
     *
     * @return the number of ships attacking
     */
    public int getNumOfShips() {
        return numOfShips;
    }

    /**
     * One in two chance of running away
     *
     * @return true if the user is allowed to run, false if not, the "default" is false
     */
    public boolean runFromShips() {
        Random randomValue = new Random();
        int runSuccessChance = randomValue.nextInt(5) + 1;
        if (runSuccessChance == 2) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * The number of ships that attack is based on the amount of money one has on hand
     *
     * @return the number of ships which will attack
     */
    public int numOfShips() {

        int numOfShipsAttacking = 0;
        Random randomValue = new Random();

        if (super.getMoney() <= 100000) {
            //Minimum one ship will attack, maximum 20
            numOfShipsAttacking = randomValue.nextInt(20) + 1;
        } else if (super.getMoney() <= 200000) {
            //Minimum 30 Ships will attack, maximum 70
            numOfShipsAttacking = randomValue.nextInt(40) + 31;
        } else if (super.getMoney() <= 500000) {
            //Minimum 50 ships will attack, maximum 140
            numOfShipsAttacking = randomValue.nextInt(90) + 51;
        } else if (super.getMoney() >= 1000000) {
            //Minimum 100 ships will attack, maximum 300 ships
            numOfShipsAttacking = randomValue.nextInt(200) + 101;
        }

        return numOfShipsAttacking;
    }

    /**
     * Calculates the loot for defeating a fleet
     *
     * @return the loot for defeating the fleet
     */
    public int calculateLoot() {

        Random randomValue = new Random();
        int calculateLoot;
        calculateLoot = (startingShips * 100) + randomValue.nextInt(startingShips) * 200;
        super.setMoney(super.getMoney() + calculateLoot);
        return calculateLoot;

    }
}
