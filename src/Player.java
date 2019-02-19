public class Player {

    private String name = "Taipan";
    private int bank = 0;
    private int money = 1000;
    private int opiumHeld = 0;
    private int silkHeld = 0;
    private int generalHeld = 0;
    private int armsHeld = 0;
    private int location = 1;
    private int guns = 0;
    private int Hp = 100;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHp() {
        return Hp;
    }

    public void setHp(int Hp) {
        if(Hp>= 0){
            this.Hp = Hp;
        }
    }

    public int getBank() {
        return bank;
    }

    public void setBank(int bank) {
        if(bank>= 0) {
            this.bank = bank;
        }
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        if(money>= 0) {
            this.money = money;
        }
    }

    public int getOpiumHeld() {
        return opiumHeld;
    }

    public void setOpiumHeld(int opiumHeld) {
        if(opiumHeld>= 0) {
            this.opiumHeld = opiumHeld;
        }
    }

    public int getSilkHeld() {
        return silkHeld;
    }

    public void setSilkHeld(int silkHeld) {
        if(silkHeld>= 0) {
            this.silkHeld = silkHeld;
        }
    }

    public int getGeneralHeld() {
        return generalHeld;
    }

    public void setGeneralHeld(int generalHeld) {
        if(generalHeld>= 0) {
            this.generalHeld = generalHeld;
        }
    }

    public int getArmsHeld() {
        return armsHeld;
    }

    public void setArmsHeld(int armsHeld) {
        if(armsHeld>= 0) {
            this.armsHeld = armsHeld;
        }
    }

    public int getLocation() {
        return location;
    }

    public void setLocation(int location) {
        if(location>= 0) {
            this.location = location;
        }
    }

    public int getGuns() {
        return guns;
    }

    public void setGuns(int guns) {
        if(guns>= 0) {
            this.guns = guns;
        }
    }
}