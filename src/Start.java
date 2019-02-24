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
        if (name.length() <= 22) {
            player.setName(name);
        }
    }
    public void intialize()
    {
        Scanner userInput = new Scanner(System.in);
        System.out.println("Taipan, \nWhat will you name your \nFirm: ");
        setFirm(userInput.nextLine());
        System.out.println("Do you want to start . . .\n1) With cash (and a debt)\n>> or <<\n" +
                "With five guns and no cash (But no debt!)\n? ");
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
