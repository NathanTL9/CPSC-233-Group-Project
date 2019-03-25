
import static org.junit.Assert.*;

import org.junit.Test;
import java.io.*;

import static org.junit.Assert.*;

public class PlayerTest {

    @Test
    public void getCargoSpace() {
        Player player = new Player();
        assertEquals("The instance variable for the object does not line up with the rest of the class", 60, player.getCargoSpace());
    }

    @Test
    public void setCargoSpace() {
        Player player = new Player();
        player.setCargoSpace(10);
        assertEquals("The instance variable for the object does not line up with the rest of the class", 10, player.getCargoSpace());
    }

    @Test
    public void getAttackingShips() {
        Player player = new Player();
        assertEquals("The instance variable for the object does not line up with the rest of the class", true, player.getAttackingShips());
    }

    @Test
    public void setAttackingShips() {
        Player player = new Player();
        player.setAttackingShips(false);
        assertEquals("The instance variable for the object does not line up with the rest of the class", false, player.getAttackingShips());
    }

    @Test
    public void getRetire() {
        Player player = new Player();
        assertEquals("The instance variable for the object does not line up with the rest of the class", false, player.getRetire());
    }

    @Test
    public void setRetire() {
        Player player = new Player();
        player.setRetire(true);
        assertEquals("The instance variable for the object does not line up with the rest of the class", true, player.getRetire());
    }

    @Test
    public void getName() {
        Player player = new Player();
        assertEquals("The instance variable for the object does not line up with the rest of the class", "Taipan", player.getName());
    }

    @Test
    public void setName() {
        Player player = new Player();
        player.setName("a");
        assertEquals("The instance variable for the object does not line up with the rest of the class", "a", player.getName());
    }

    @Test
    public void getHP() {
        Player player = new Player();
        assertEquals("The instance variable for the object does not line up with the rest of the class", 100, player.getHP());
    }

    @Test
    public void setHP() {
        Player player = new Player();
        player.setHP(1);
        assertEquals("The instance variable for the object does not line up with the rest of the class", 1, player.getHP());
    }

    @Test
    public void getBank() {
        Player player = new Player();
        assertEquals("The instance variable for the object does not line up with the rest of the class", 0, player.getBank());
    }

    @Test
    public void setBank() {
        Player player = new Player();
        player.setBank(1);
        assertEquals("The instance variable for the object does not line up with the rest of the class", 1, player.getBank());
    }

    @Test
    public void getMoney() {
        Player player = new Player();
        assertEquals("The instance variable for the object does not line up with the rest of the class", 0, player.getMoney());
    }

    @Test
    public void setMoney() {
        Player player = new Player();
        player.setMoney(1);
        assertEquals("The instance variable for the object does not line up with the rest of the class", 1, player.getMoney());
    }

    @Test
    public void getOpiumHeld() {
        Player player = new Player();
        assertEquals("The instance variable for the object does not line up with the rest of the class", 0, player.getOpiumHeld());
    }

    @Test
    public void setOpiumHeld() {
        Player player = new Player();
        player.setOpiumHeld(1);
        assertEquals("The instance variable for the object does not line up with the rest of the class", 1, player.getOpiumHeld());
    }

    @Test
    public void getSilkHeld() {
        Player player = new Player();
        assertEquals("The instance variable for the object does not line up with the rest of the class", 0, player.getSilkHeld());
    }

    @Test
    public void setSilkHeld() {
        Player player = new Player();
        player.setSilkHeld(1);
        assertEquals("The instance variable for the object does not line up with the rest of the class", 1, player.getSilkHeld());
    }

    @Test
    public void getGeneralHeld() {
        Player player = new Player();
        assertEquals("The instance variable for the object does not line up with the rest of the class", 0, player.getGeneralHeld());
    }

    @Test
    public void setGeneralHeld() {
        Player player = new Player();
        player.setGeneralHeld(1);
        assertEquals("The instance variable for the object does not line up with the rest of the class", 1, player.getGeneralHeld());
    }

    @Test
    public void getArmsHeld() {
        Player player = new Player();
        assertEquals("The instance variable for the object does not line up with the rest of the class", 0, player.getArmsHeld());
    }

    @Test
    public void setArmsHeld() {
        Player player = new Player();
        player.setArmsHeld(1);
        assertEquals("The instance variable for the object does not line up with the rest of the class", 1, player.getArmsHeld());
    }

    @Test
    public void getLocation() {
        Player player = new Player();
        assertEquals("The instance variable for the object does not line up with the rest of the class", 1, player.getLocation());
    }

    @Test
    public void setLocation() {
        Player player = new Player();
        player.setLocation(2);
        assertEquals("The instance variable for the object does not line up with the rest of the class", 2, player.getLocation());
    }

    @Test
    public void getGuns() {
        Player player = new Player();
        assertEquals("The instance variable for the object does not line up with the rest of the class", 5, player.getGuns());
    }

    @Test
    public void setGuns() {
        Player player = new Player();
        player.setGuns(1);
        assertEquals("The instance variable for the object does not line up with the rest of the class", 1, player.getGuns());
    }

    @Test
    public void getDebt() {
        Player player = new Player();
        assertEquals("The instance variable for the object does not line up with the rest of the class", 0, player.getDebt());
    }

    @Test
    public void setDebt() {
        Player player = new Player();
        player.setDebt(1);
        assertEquals("The instance variable for the object does not line up with the rest of the class", 1, player.getDebt());
    }

    @Test
    public void getwOpium() {
        Player player = new Player();
        assertEquals("The instance variable for the object does not line up with the rest of the class", 0, player.getwOpium());
    }

    @Test
    public void setwOpium() {
        Player player = new Player();
        player.setwOpium(1);
        assertEquals("The instance variable for the object does not line up with the rest of the class", 1, player.getwOpium());
    }

    @Test
    public void getwSilk() {
        Player player = new Player();
        assertEquals("The instance variable for the object does not line up with the rest of the class", 0, player.getwSilk());
    }

    @Test
    public void setwSilk() {
        Player player = new Player();
        player.setwSilk(1);
        assertEquals("The instance variable for the object does not line up with the rest of the class", 1, player.getwSilk());
    }

    @Test
    public void getwGeneral() {
        Player player = new Player();
        assertEquals("The instance variable for the object does not line up with the rest of the class", 0, player.getwGeneral());
    }

    @Test
    public void setwGeneral() {
        Player player = new Player();
        player.setwGeneral(1);
        assertEquals("The instance variable for the object does not line up with the rest of the class", 1, player.getwGeneral());
    }

    @Test
    public void getwArms() {
        Player player = new Player();
        assertEquals("The instance variable for the object does not line up with the rest of the class", 0, player.getwArms());
    }

    @Test
    public void setwArms() {
        Player player = new Player();
        player.setwArms(1);
        assertEquals("The instance variable for the object does not line up with the rest of the class", 1, player.getwArms());
    }

    @Test
    public void getOpiumPrice() {
        Player player = new Player();
        assertEquals("The instance variable for the object does not line up with the rest of the class", 16000, player.getOpiumPrice());
    }

    @Test
    public void setOpiumPrice() {
        Player player = new Player();
        player.setOpiumPrice(1);
        assertEquals("The instance variable for the object does not line up with the rest of the class", 1, player.getOpiumPrice());
    }

    @Test
    public void getSilkPrice() {
        Player player = new Player();
        assertEquals("The instance variable for the object does not line up with the rest of the class", 1600, player.getSilkPrice());
    }

    @Test
    public void setSilkPrice() {
        Player player = new Player();
        player.setSilkPrice(1);
        assertEquals("The instance variable for the object does not line up with the rest of the class", 1, player.getSilkPrice());
    }

    @Test
    public void getArmsPrice() {
        Player player = new Player();
        assertEquals("The instance variable for the object does not line up with the rest of the class", 160, player.getArmsPrice());
    }

    @Test
    public void setArmsPrice() {
        Player player = new Player();
        player.setArmsPrice(1);
        assertEquals("The instance variable for the object does not line up with the rest of the class", 1, player.getArmsPrice());
    }

    @Test
    public void getGeneralPrice() {
        Player player = new Player();
        assertEquals("The instance variable for the object does not line up with the rest of the class", 8, player.getGeneralPrice());
    }

    @Test
    public void setGeneralPrice() {
        Player player = new Player();
        player.setGeneralPrice(1);
        assertEquals("The instance variable for the object does not line up with the rest of the class", 1, player.getGeneralPrice());
    }

    @Test
    public void getIsPriceChanged() {
        Player player = new Player();
        assertEquals("The instance variable for the object does not line up with the rest of the class", 0, player.getIsPriceChanged());
    }

    @Test
    public void setIsPriceChanged() {
        Player player = new Player();
        player.setIsPriceChanged(1);
        assertEquals("The instance variable for the object does not line up with the rest of the class", 1, player.getIsPriceChanged());
    }
}
