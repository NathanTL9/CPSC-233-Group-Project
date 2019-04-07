package logic; /**
 * TaipanShopLogic deals with the computations necessary for the shop such as randomizing prices.
 *
 * Author: Vikram Bawa
 */
import java.util.Random;

public class TaipanShopLogic extends Player {

    /**
     * constructor; only runs when a Player object is provided. The constructor is fully encapsulated.
     *
     * @param player is a Player object that will be copied and the player instance variable is set to the copy.
     */
    public TaipanShopLogic(Player player) {
        Player playerDummy = new Player(player);
        setPlayer(playerDummy);
    }

    /**
     * this method is when the shop is accessed, randomizing the prices of all the items.
     */
    public String updatePrices() {
        String s = "\t" + getName() + ", the price of ";
        String a = "";
        double value = 0 * Math.random();
        Random rand = new Random();
        setOpiumPrice((rand.nextInt(201) + 60) * 100);
        setSilkPrice((rand.nextInt(201) + 60) * 10);
        setArmsPrice((rand.nextInt(21) + 6) * 10);
        setGeneralPrice((rand.nextInt(17) + 4));
        
        // there is a 10% chance that the price of an item is increased/decreased beyond its regular range.
        if (value < 8) {
            if (value < 2) {
                if (value < 1) {
                    setOpiumPrice(getOpiumPrice() / 5);
                    a = s + "Opium has dropped to " + getOpiumPrice() + "!!!\n";
                } else {
                    setOpiumPrice(getOpiumPrice() * 5);
                    a = s + "Opium has risen to " + getOpiumPrice() + "!!!\n" ;
                }
            } else if (value < 4) {
                if (value < 3) {
                    setSilkPrice(getSilkPrice() / 5);
                    a = s + "Silk has dropped to " + getSilkPrice() + "!!!\n";
                } else {
                    setSilkPrice(getSilkPrice() * 5);
                    a = s + "Silk has risen to " + getSilkPrice() + "!!!\n";
                }
            } else if (value < 6) {
                if (value < 3) {
                    setArmsPrice(getArmsPrice() / 5);
                    a = s + "Arms has dropped to " + getArmsPrice() + "!!!\n";
                } else {
                    setArmsPrice(getArmsPrice() * 5);
                    a = s + "Arms has risen to " + getArmsPrice() + "!!!\n";
                }
            } else {
                if (value < 7) {
                    setGeneralPrice(1);
                    a = s + "General Cargo has dropped to 1!!!\n";
                } else {
                    setGeneralPrice(getGeneralPrice() * 5);
                    a = s + "General Cargo has risen to " + getGeneralPrice() + "!!!\n";
                }
            }
        }
        return a;
    }

    /**
     * returns the user's condition based upon their current HP.
     *
     * @return shipStatus -- a representation of their ship's health in words.
     */
    public String shipStatusString(){
        String shipStatus;
        switch(getHP()/10){
            case 10: shipStatus = "Mint Condition"; break;
            case 9: shipStatus = "Near Perfect"; break;
            case 8: shipStatus = "Great"; break;
            case 7: shipStatus = "Good"; break;
            case 6: shipStatus = "Acceptable"; break;
            case 5: shipStatus = "Tolerable"; break;
            case 4: shipStatus = "Needs Repair"; break;
            case 3: shipStatus = "Damaged"; break;
            case 2: shipStatus = "Indangered"; break;
            case 1: shipStatus = "Near Sinking"; break;
            case 0: shipStatus = "Sinking"; break;
            default: shipStatus = "Invincible"; break;
        }
        return shipStatus;
    }

    /**
     * converts the user's location (an integer) to a String, and returns it.
     *
     * @return location -- the user's location as a string; the actual name of the location.
     */
    public String getStringLocation(){
        String location;
        switch(getLocation()){
            case 1: location = "Hong Kong"; break;
            case 2: location = "Shanghai"; break;
            case 3: location = "Nagasaki"; break;
            case 4: location = "Saigon"; break;
            case 5: location = "Manila"; break;
            case 6: location = "Singapore"; break;
            case 7: location = "Batavia"; break;
            default: location = "Error"; break;
        }
        return location;
    }


}
