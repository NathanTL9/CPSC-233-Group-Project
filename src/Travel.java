import java.util.Random;
import java.util.Scanner;

public class Travel extends Player {

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
                if(tempInt != getLocation()){
                    switch (tempInt) {
                        case 1:
                            randomEventSea();
                            System.out.println("\nArriving at Hong Kong");
                            setLocation(1);
                            hasTraveled = true;
                            break;
                        case 2:
                            randomEventSea();
                            System.out.println("\nArriving at Shanghai");
                            setLocation(2);
                            hasTraveled = true;
                            break;
                        case 3:
                            randomEventSea();
                            System.out.println("\nArriving at Nagasaki");
                            setLocation(3);
                            hasTraveled = true;
                            break;
                        case 4:
                            randomEventSea();
                            System.out.println("\nArriving at Saigon");
                            setLocation(4);
                            hasTraveled = true;
                            break;
                        case 5:
                            randomEventSea();
                            System.out.println("\nArriving at Manila");
                            setLocation(5);
                            hasTraveled = true;
                            break;
                        case 6:
                            randomEventSea();
                            System.out.println("\nArriving at Singapore");
                            setLocation(6);
                            hasTraveled = true;
                            break;
                        case 7:
                            randomEventSea();
                            System.out.println("\nArriving at Batavia");
                            setLocation(7);
                            hasTraveled = true;
                            break;
                    }
                }
                else System.out.println("\nYou're already here Taipan.");
            }
            catch (Exception e){
                System.out.print("\nSorry, Taipan could you say that again?");
            }
            if(hasTraveled){break;}
        }
    }

    private void randomEventSea() throws Exception {
        ShipWarfare attackShip = new ShipWarfare();
        Random rand = new Random();
        int randGenNum = rand.nextInt(2) + 1;
        System.out.println("\n");

        if(randGenNum == 1){
            attackShip.peasantFleetAttack();
            System.out.println("We made it " + getName());
        }
        else if(randGenNum == 2){
            disaster();
            System.out.println("We made it " + getName());
        }
    }

    private void disaster(){
        System.out.println("Storm Taipan!");

    }

    public static void main(String[] args){
        Travel ship = new Travel();
        ship.travelTo();
    }
}
