import java.util.Random;
import java.util.Scanner;

public class Travel extends Player {

    private void seaAtlas(int locationOfTravel){
        switch (locationOfTravel) {
            case 1:
                System.out.println("\nArriving at Hong Kong");
                setLocation(1);
                break;
            case 2:
                System.out.println("\nArriving at Shanghai");
                setLocation(2);
                break;
            case 3:
                System.out.println("\nArriving at Nagasaki");
                setLocation(3);
                break;
            case 4:
                System.out.println("\nArriving at Saigon");
                setLocation(4);
                break;
            case 5:
                System.out.println("\nArriving at Manila");
                setLocation(5);
                break;
            case 6:
                System.out.println("\nArriving at Singapore");
                setLocation(6);
                break;
            case 7:
                System.out.println("\nArriving at Batavia");
                setLocation(7);
                break;
        }
    }

    private void randomEventSea(int locationOfTravel) throws Exception {
        ShipWarfare attackShip = new ShipWarfare();
        Random rand = new Random();
        int randGenNum = rand.nextInt(3) + 1;
        if(randGenNum == 1){
            attackShip.peasantFleetAttack();
        }
        else if(randGenNum == 2){
            disaster(locationOfTravel);
        }
        System.out.println("We made it!");
    }

    private void disaster(int locationOfTravel){
        System.out.print("Storm "+getName()+"! ");
        Random rand = new Random();
        int randGenNum = rand.nextInt(5) + 1;

        if(randGenNum <= 2){
            System.out.println(" We made it through!");
        }
        else{
            while(randGenNum == locationOfTravel){
                randGenNum = rand.nextInt(7) + 1;
                if (randGenNum != locationOfTravel) {
                    System.out.println("We've been blown off course!");
                    seaAtlas(randGenNum);
                }
            }
        }
    }

    public void travelTo(){
        Scanner keyboard = new Scanner(System.in);
        String response;
        int tempInt;
        boolean hasTraveled = false;

        while (true) {
            System.out.println("\n" + getName() + ", do you wish to go to:\n");
            System.out.println("1) Hong Kong, 2) Shanghai, 3) Nagasaki,\n4) Saigon, 5) Manila, 6) Singapore, or 7) Batavia?");

            response = keyboard.nextLine();
            try {
                tempInt = Integer.parseInt(response);
                System.out.println(tempInt + " " + getLocation());
                if(tempInt != getLocation()){
                    randomEventSea(tempInt);
                    seaAtlas(tempInt);
                    hasTraveled = true;
                }
                else System.out.println("\nYou're already here " + getName() + ".");
            }
            catch (Exception e){
                System.out.print("\nSorry, " + getName() + " could you say that again?");
            }
            if(hasTraveled){break;}
        }
    }

    public static void main(String[] args){
        Travel ship = new Travel();
        ship.travelTo();
    }
}
