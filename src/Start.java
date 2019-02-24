import java.util.Scanner;
public class Start
{
    private Player player;

    public Player getPlayer() {
        Player playerTemp = new Player(player);
        return playerTemp;
    }

    public void setPlayer(Player player) {
        Player playerTemp = new Player(player);
        this.player = playerTemp;
    }

    public void setFirm (String name) {
        System.out.println("Taipan, \nWhat will you name your \nFirm: ");
        if (name.length() <= 22) {
            player.setName(name);
        }
    }
    public void main(String[] args)
    {
        System.out.println("Do you want to start . . .\n1) With cash (and a debt)\n>> or <<\n" +
                "With five guns and no cash (But no debt!)\n? ");
        Scanner userInput = new Scanner(System.in);
        if (userInput.nextInt() == 1)
        {
            player.setMoney(400);
            player.setDebt(5000);

        }
        if (userInput.nextInt() == 2)
        {
            player.setGuns(5);
        }
    }


    public Start(Player player)
    {
        Player playerTemp = new Player(player);
        this.player = playerTemp;
    }
}
