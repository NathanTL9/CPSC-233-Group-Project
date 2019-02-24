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
        System.out.println("Taipan, \nWhat will you name your firm:");
        setFirm(userInput.nextLine());
        System.out.println("Do you want to start . . .\n\t1) With cash (and a debt)\n\t\t\t>> or <<\n\t" +
                "2) With five guns and no cash (But no debt!)?\n ");
        int input = userInput.nextInt();
        if (input == 1)
        {
            player.setMoney(400);
            player.setDebt(5000);

        }
        if (input == 2)
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
