import java.util.Scanner;
public class Start
{
    private Player player;

    /**
     * getter method for obtaining a player object.
     *
     * @return returns player object
     */
    public Player getPlayer() {
        Player playerTemp = new Player(player);
        return playerTemp;
    }

    /**
     * setter method that takes in a Player object as an argument.
     *
     * @param player object of the class Player
     */
    public void setPlayer(Player player) {
        Player playerTemp = new Player(player);
        this.player = playerTemp;
    }

    /**
     * Asks the user to input the name that they would like to be called in the game
     *
     * @param name the name that you would like to be called in the game
     */
    public void setFirm (String name) {
        if (name.length() <= 22) {
            player.setName(name);
        }
    }

    /**
     * Initializes the game by asking for your name and if you would like to start with either: 1) money and a debt or
     * 2) guns and no cash/debt.
     */
    public void initialize()
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
        // purely for testing purposes.
        if(player.getName().equalsIgnoreCase("Vikram")){
            player.setMoney(999999999);
            player.setBank(999999999);
            player.setGuns(999);
            player.setHP(99999999);
        }
    }


    /**
     * Copy constructor.
     * @param player object of the class Player
     */
    public Start(Player player)
    {
        Player playerTemp = new Player(player);
        this.player = playerTemp;
    }
}
