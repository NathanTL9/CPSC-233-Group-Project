import java.util.Scanner;

public class Player {

    private String name = "Taipan";
    private int bank = 0;
    private int money = 0;
    private int opiumHeld = 0;
    private int silkHeld = 0;
    private int generalHeld = 0;
    private int armsHeld = 0;
    private int location = 1;
    private int guns = 0;
    private int HP = 100;
    private int debt = 0;
    private int wOpium = 0;
    private int wSilk = 0;
    private int wGeneral = 0;
    private int wArms = 0;
    private boolean retire = false;
    private int cargoSpace = 60;

    public Player(){

    }

    public Player(Player player){
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

    }

    /**
     * getter method for the instance variable cargoSpace.
     * @return cargoSpace
     */
    public int getCargoSpace() {
        return cargoSpace;
    }

    /**
     * setter method for cargoSpace.
     * @param cargoSpace
     */
    public void setCargoSpace(int cargoSpace) {
        if(cargoSpace > 0){
            this.cargoSpace = cargoSpace;
        }
    }

    public boolean getRetire(){
        return retire;
    }

    public void setRetire(boolean retire){
        if(retire){
            this.retire = retire;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHP() {
        return HP;
    }

    public void setHP(int HP) {

        this.HP = HP;

    }

    public int getBank() {
        return bank;
    }

    public void setBank(int bank) {
        if (bank >= 0) {
            this.bank = bank;
        }
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        if (money >= 0) {
            this.money = money;
        }
    }

    public int getOpiumHeld() {
        return opiumHeld;
    }

    public void setOpiumHeld(int opiumHeld) {
        if (opiumHeld >= 0) {
            this.opiumHeld = opiumHeld;
        }
    }

    public int getSilkHeld() {
        return silkHeld;
    }

    public void setSilkHeld(int silkHeld) {
        if (silkHeld >= 0) {
            this.silkHeld = silkHeld;
        }
    }

    public int getGeneralHeld() {
        return generalHeld;
    }

    public void setGeneralHeld(int generalHeld) {
        if (generalHeld >= 0) {
            this.generalHeld = generalHeld;
        }
    }

    public int getArmsHeld() {
        return armsHeld;
    }

    public void setArmsHeld(int armsHeld) {
        if (armsHeld >= 0) {
            this.armsHeld = armsHeld;
        }
    }

    public int getLocation() {
        return location;
    }

    public void setLocation(int location) {
        if (location >= 0) {
            this.location = location;
        }
    }

    public int getGuns() {
        return guns;
    }

    public void setGuns(int guns) {
        if (guns >= 0) {
            this.guns = guns;
        }
        
    }
    public int getDebt() {
        return debt;
    }
        
    public void setDebt(int debt) {
        if (debt >= 0) {
            this.debt = debt;
        }
    }

    public int getwOpium(){ return wOpium; }

    public void setwOpium(int wOpium) {
        if (wOpium >= 0){
            this.wOpium = wOpium;
        }
    }

    public int getwSilk(){return wSilk;}

    public void setwSilk(int wSilk) {
        if (wSilk >= 0){
            this.wSilk = wSilk;
        }
    }

    public int getwGeneral(){return wGeneral;}

    public void setwGeneral(int wGeneral) {
        if (wGeneral >= 0){
            this.wGeneral = wGeneral;
        }
    }

    public int getwArms(){return wArms;}

    public void setwArms(int wArms) {
        if (wArms >= 0){
            this.wArms = wArms;
        }
    }

    public void gameOver(){
        System.out.flush();
        System.out.println("Game over");
        System.exit(0);
    }

}
