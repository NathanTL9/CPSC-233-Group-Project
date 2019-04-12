package logic;

import java.util.Random;

public class TravelLogic extends Player {

    public TravelLogic(Player player) {
        Player playerDummy = new Player(player);
        setPlayer(playerDummy);
    }


    /**
     * When provided a location number: the method returns a print statement stating the location's name and call another
     * method to change the location of the Player object.
     *
     * @param locationOfTravel is a Player object that will be copied and the player instance variable is set to the copy.
     */
    public void seaAtlas(int locationOfTravel) {
        switch (locationOfTravel) {
            case 1:
                System.out.println("\nArriving at Hong Kong");
                setLocation(1);
                break;
            case 2:
                System.out.println("\nArriving at Shanghai");
                setLocation(2);
                break;
            case 3:
                System.out.println("\nArriving at Nagasaki");
                setLocation(3);
                break;
            case 4:
                System.out.println("\nArriving at Saigon");
                setLocation(4);
                break;
            case 5:
                System.out.println("\nArriving at Manila");
                setLocation(5);
                break;
            case 6:
                System.out.println("\nArriving at Singapore");
                setLocation(6);
                break;
            case 7:
                System.out.println("\nArriving at Batavia");
                setLocation(7);
                break;
        }
    }


    /**
     * Based on random chance either throws the player character off course, or continues them on their way to their
     * destination.
     *
     * @param locationOfTravel is used to see where the player is going to travel, just in case their location is changed
     *                         by a typhoon.
     **/
    public String disaster(int locationOfTravel) {
        //Tells player that there is a storm approaching.
        Random rand = new Random();
        int randGenNum = rand.nextInt(5) + 1;

        //If the player lands within this range, nothing happens to them
        //Else they randomly get thrown into a location they weren't planning on going to(Anything but location of Travel).
        if (randGenNum <= 2) {
            return "We got through the storm " + getName() + "!";
        }else {
            while (randGenNum == locationOfTravel) {
                randGenNum = rand.nextInt(7) + 1;
                if (randGenNum != locationOfTravel) {
                    seaAtlas(randGenNum);
                    return "We've been blown off course!";
                }
            }
        }
        return null;
    }
}
