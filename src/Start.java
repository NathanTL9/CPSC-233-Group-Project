import java.util.Scanner;
public class Start extends Player
{
    @Override
    public void setName(String name) {
        System.out.println("Taipan, \nWhat will you name your \nFirm: ");
        if (name.length() <= 22) {
            super.setName(name);
        }
    }
    public void main(String[] args)
    {
        System.out.println("Do you want to start . . .\n1) With cash (and a debt)\n>> or <<\n" +
                "With five guns and no cash (But no debt!)\n? ");
        Scanner userInput = new Scanner(System.in);
        if (userInput.nextInt() == 1)
        {
            setMoney(400);
            setDebt(5000);

        }
        if (userInput.nextInt() == 2)
        {
            setGuns(5);
        }
    }

}
