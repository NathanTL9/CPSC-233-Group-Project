public class Player {

    private String name = "Taipan";
    private int bank = 0;
    private int money = 1000;
    private int opiumHeld = 0;
    private int silkHeld = 0;
    private int generalHeld = 0;
    private int armsHeld = 0;
    private int location = 2;
    private int guns = 0;
    private int Hp = 100;

    public int getHp() {
        return Hp;
    }

    public void setHp(int hp) {
        Hp = hp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBank() {
        return bank;
    }

    public void setBank(int bank) {
        this.bank = bank;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getOpiumHeld() {
        return opiumHeld;
    }

    public void setOpiumHeld(int opiumHeld) {
        this.opiumHeld = opiumHeld;
    }

    public int getSilkHeld() {
        return silkHeld;
    }

    public void setSilkHeld(int silkHeld) {
        this.silkHeld = silkHeld;
    }

    public int getGeneralHeld() {
        return generalHeld;
    }

    public void setGeneralHeld(int generalHeld) {
        this.generalHeld = generalHeld;
    }

    public int getArmsHeld() {
        return armsHeld;
    }

    public void setArmsHeld(int armsHeld) {
        this.armsHeld = armsHeld;
    }

    public int getLocation() {
        return location;
    }

    public void setLocation(int location) {
        this.location = location;
    }

    public int getGuns() {
        return guns;
    }

    public void setGuns(int guns) {
        this.guns = guns;
    }
}
