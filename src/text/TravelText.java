package text;

import logic.Player;

import java.util.Random;
import java.util.Scanner;

public class TravelText extends Player {

    public TravelText(Player player) {
        Player playerDummy = new Player(player);
        setPlayer(playerDummy);
    }

    /**
     * When provided a location number: the method returns a print statement stating the location's name and call another
     * method to change the location of the Player object.
     *
     * @param locationOfTravel is a Player object that will be copied and the player instance variable is set to the copy.
     */
    private void seaAtlas(int locationOfTravel) {
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
            disaster(locationOfTravel);
            System.out.println("We made it!");
        }
    }

    /**
     * Based on random chance either throws the player character off course, or continues them on their way to their
     * destination.
     *
     * @param locationOfTravel is used to see where the player is going to travel, just in case their location is changed
     *                         by a typhoon.
     **/
    private void disaster(int locationOfTravel) {
        //Tells player that there is a storm approaching.
        System.out.print("Storm " + getName() + "! ");
        Random rand = new Random();
        int randGenNum = rand.nextInt(5) + 1;

        //If the player lands within this range, nothing happens to them
        //Else they randomly get thrown into a location they weren't planning on going to(Anything but location of Travel).
        if (randGenNum <= 2) {
            System.out.println(" We made it through!");
        } else {
            while (randGenNum == locationOfTravel) {
                randGenNum = rand.nextInt(7) + 1;
                if (randGenNum != locationOfTravel) {
                    System.out.println("We've been blown off course!");
                    seaAtlas(randGenNum);
                }
            }
        }
    }

    /**
     * Used to travel between different areas inside of the game world.
     * If the player's inventory is too full it won't run.
     * Also calculates loan and bank interest between the jumps between islands.
     **/
    public void travelTo() {
        Scanner keyboard = new Scanner(System.in);
        String response;
        int tempInt;
        boolean hasTraveled = false;

        //Only lets the player leave the port if their inventory is greater than or equal to the sum of the items in the inventory.
        if (getCargoSpace() >= (getOpiumHeld() + (getGuns() * 10) + getSilkHeld() + getArmsHeld() + getGeneralHeld())) {
            while (true) {
                System.out.println("\n" + getName() + ", do you wish to go to:\n");
                System.out.println("1) Hong Kong, 2) Shanghai, 3) Nagasaki,\n4) Saigon, 5) Manila, 6) Singapore, or 7) Batavia?");

                response = keyboard.nextLine();
                //Just in case the player types something that was not intended. It will refresh the question and ask it again
                try {
                    tempInt = Integer.parseInt(response);
                    //Makes sure you can't travel to your own location.
                    if (tempInt != getLocation()) {
                        randomEventSea(tempInt);
                        seaAtlas(tempInt);
                        hasTraveled = true;
                        setBank((int) (getBank() * 1.01));
                        setDebt((int) (getDebt() * 1.01));
                    } else System.out.println("\nYou're already here " + getName() + ".");
                } catch (Exception e) {
                    System.out.print("\nSorry, " + getName() + " could you say that again?");
                }
                if (hasTraveled) {
                    break;
                }
            }
        } else {
            System.out.println(getName() + " the cargo is too heavy! We can't set sail!");
        }
    }
}

