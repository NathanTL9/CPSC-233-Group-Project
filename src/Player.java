public class Player {

    private String name = "Taipan";
    private int bank = 0;
    private int money = 0;
    private int opiumHeld = 0;
    private int silkHeld = 0;
    private int generalHeld = 0;
    private int armsHeld = 0;
    private int location = 1;
    private int guns = 5;
    private int HP = 100;
    private int debt = 0;
    private int wOpium = 0;
    private int wSilk = 0;
    private int wGeneral = 0;
    private int wArms = 0;
    private boolean retire = false;
    private int cargoSpace = 60;

    public Player() {
        this.name = "Taipan";
        this.bank = 0;
        this.money = 0;
        this.opiumHeld = 0;
        this.silkHeld = 0;
        this.generalHeld = 0;
        this.armsHeld = 0;
        this.location = 1;
        this.guns = 0;
        this.HP = 100;
        this.debt = 0;
        this.wOpium = 0;
        this.wSilk = 0;
        this.wGeneral = 0;
        this.wArms = 0;
        this.retire = false;
        this.cargoSpace = 60;
    }

    /**
     * Copy constructor
     *
     * @param player object of the class Player
     */
    public Player(Player player) {
        this.name = player.name;
        this.bank = player.bank;
        this.money = player.money;
        this.opiumHeld = player.opiumHeld;
        this.silkHeld = player.silkHeld;
        this.generalHeld = player.generalHeld;
        this.armsHeld = player.armsHeld;
        this.location = player.location;
        this.guns = player.guns;
        this.HP = player.HP;
        this.debt = player.debt;
        this.wOpium = player.wOpium;
        this.wSilk = player.wSilk;
        this.wGeneral = player.wGeneral;
        this.wArms = player.wArms;
        this.cargoSpace = player.cargoSpace;
    }

    /**
     * getter method for the instance variable cargoSpace.
     *
     * @return returns the instance variable cargoSpace
     */

    public int getCargoSpace() {
        return cargoSpace;
    }

    /**
     * setter method for the instance variable cargoSpace.
     *
     * @param cargoSpace takes an int that is greater than 0 as an argument
     */

    public void setCargoSpace(int cargoSpace) {
        if (cargoSpace > 0) {
            this.cargoSpace = cargoSpace;
        }
    }

    /**
     * getter method for the instance variable retire.
     *
     * @return returns the instance variable retire
     */

    public boolean getRetire() {
        return retire;
    }

    /**
     * setter method for the instance variable retire.
     *
     * @param retire takes a boolean as an argument
     */

    public void setRetire(boolean retire) {
        if (retire) {
            this.retire = retire;
        }
    }

    /**
     * getter method for the instance variable name.
     *
     * @return returns the instance variable name
     */

    public String getName() {
        return name;
    }

    /**
     * setter method for the instance variable name.
     *
     * @param name takes a string as an argument
     */

    public void setName(String name) {
        this.name = name;
    }

    /**
     * getter method for the instance variable HP.
     *
     * @return returns the instance variable HP
     */

    public int getHP() {
        return HP;
    }

    /**
     * setter method for the instance variable HP.
     *
     * @param HP takes an int as an argument
     */

    public void setHP(int HP) {

        this.HP = HP;
    }

    /**
     * getter method for the instance variable bank.
     *
     * @return returns the instance variable bank
     */

    public int getBank() {
        return bank;
    }

    /**
     * setter method for the instance variable bank.
     *
     * @param bank takes an int that is greater than or equal to 0 as an argument
     */

    public void setBank(int bank) {
        if (bank >= 0) {
            this.bank = bank;
        }
    }

    /**
     * getter method for the instance variable money.
     *
     * @return returns the instance variable money
     */

    public int getMoney() {
        return money;
    }

    /**
     * setter method for the instance variable money.
     *
     * @param money takes an int that is greater than or equal to 0 as an argument
     */

    public void setMoney(int money) {
        if (money >= 0) {
            this.money = money;
        }
    }

    /**
     * getter method for the instance variable opiumHeld.
     *
     * @return returns the instance variable opiumHeld
     */

    public int getOpiumHeld() {
        return opiumHeld;
    }

    /**
     * setter method for the instance variable opiumHeld.
     *
     * @param opiumHeld takes an int that is greater than or equal to 0 as an argument
     */

    public void setOpiumHeld(int opiumHeld) {
        if (opiumHeld >= 0) {
            this.opiumHeld = opiumHeld;
        }
    }

    /**
     * getter method for the instance variable silkHeld.
     *
     * @return returns the instance variable silkHeld
     */

    public int getSilkHeld() {
        return silkHeld;
    }

    /**
     * setter method for the instance variable silkHeld.
     *
     * @param silkHeld takes an int that is greater than or equal to 0 as an argument
     */

    public void setSilkHeld(int silkHeld) {
        if (silkHeld >= 0) {
            this.silkHeld = silkHeld;
        }
    }

    /**
     * getter method for the instance variable generalHeld.
     *
     * @return returns the instance variable generalHeld
     */

    public int getGeneralHeld() {
        return generalHeld;
    }

    /**
     * setter method for the instance variable generalHeld.
     *
     * @param generalHeld takes an int that is greater than or equal to 0 as an argument
     */

    public void setGeneralHeld(int generalHeld) {
        if (generalHeld >= 0) {
            this.generalHeld = generalHeld;
        }
    }

    /**
     * getter method for the instance variable armsHeld.
     *
     * @return returns the instance variable armsHeld
     */

    public int getArmsHeld() {
        return armsHeld;
    }

    /**
     * setter method for the instance variable armsHeld.
     *
     * @param armsHeld takes an int that is greater than or equal to 0 as an argument
     */

    public void setArmsHeld(int armsHeld) {
        if (armsHeld >= 0) {
            this.armsHeld = armsHeld;
        }
    }

    /**
     * getter method for the instance variable location.
     *
     * @return returns the instance variable location
     */

    public int getLocation() {
        return location;
    }

    /**
     * setter method for the instance variable location.
     *
     * @param location takes an int that is greater than or equal to 0 as an argument
     */

    public void setLocation(int location) {
        if (location >= 0) {
            this.location = location;
        }
    }

    /**
     * getter method for the instance variable guns.
     *
     * @return returns the instance variable guns
     */

    public int getGuns() {
        return guns;
    }

    /**
     * setter method for the instance variable guns.
     *
     * @param guns takes an int that is greater than or equal to 0 as an argument
     */

    public void setGuns(int guns) {
        if (guns >= 0) {
            this.guns = guns;
        }

    }

    /**
     * getter method for the instance variable debt.
     *
     * @return returns the instance variable debt
     */

    public int getDebt() {
        return debt;
    }

    /**
     * setter method for the instance variable debt.
     *
     * @param debt takes an int that is greater than or equal to 0 as an argument
     */

    public void setDebt(int debt) {
        if (debt >= 0) {
            this.debt = debt;
        }
    }

    /**
     * getter method for the instance variable wOpium.
     *
     * @return returns the instance variable wOpium
     */

    public int getwOpium() {
        return wOpium;
    }

    /**
     * setter method for the instance variable wOpium.
     *
     * @param wOpium takes an int that is greater than or equal to 0 as an argument
     */

    public void setwOpium(int wOpium) {
        if (wOpium >= 0) {
            this.wOpium = wOpium;
        }
    }

    /**
     * getter method for the instance variable wSilk.
     *
     * @return returns the instance variable wSilk
     */

    public int getwSilk() {
        return wSilk;
    }

    /**
     * setter method for the instance variable wSilk.
     *
     * @param wSilk takes an int that is greater than or equal to 0 as an argument
     */

    public void setwSilk(int wSilk) {
        if (wSilk >= 0) {
            this.wSilk = wSilk;
        }
    }

    /**
     * getter method for the instance variable wGeneral.
     *
     * @return returns the instance variable wGeneral
     */

    public int getwGeneral() {
        return wGeneral;
    }

    /**
     * setter method for the instance variable wGeneral.
     *
     * @param wGeneral takes an int that is greater than or equal to 0 as an argument
     */

    public void setwGeneral(int wGeneral) {
        if (wGeneral >= 0) {
            this.wGeneral = wGeneral;
        }
    }

    /**
     * getter method for the instance variable wArms.
     *
     * @return returns the instance variable wArms
     */

    public int getwArms() {
        return wArms;
    }

    /**
     * setter method for the instance variable wArms.
     *
     * @param wArms takes an int that is greater than or equal to 0 as an argument
     */

    public void setwArms(int wArms) {
        if (wArms >= 0) {
            this.wArms = wArms;
        }
    }

    /**
     * Method to indicate that you have lost the game. If the player has lost, console will be cleared and will only
     * show the statement "Game Over". After showing the message the game closes.
     **/

    public void gameOver() {
        System.out.flush();
        System.out.println("Game over");
        System.exit(0);
    }
}
