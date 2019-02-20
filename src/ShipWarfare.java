import java.util.Scanner;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class ShipWarfare extends Player {

    private int numOfPeasantShips = 0;
    private boolean userAttacks = true;


    public void peasantFleetAttack() throws Exception {
        Scanner userResponse = new Scanner(System.in);
        setNumOfPeasantShips(numOfShips());
        System.out.printf("By Golly! We have $%,d \nwe are being attacked by %d ships\n", getMoney(), getNumOfPeasantShips());
        fightOrRunMessage();
        while (true) {
            String response = userResponse.nextLine();
            if (response.equalsIgnoreCase("f")) {
                userAttacks = true;
                System.out.println("Ohh, fight ehh?");
                boolean winOrLose = destroyShipsOrEscape(getNumOfPeasantShips());
                if (winOrLose == true) {
                    break;
                }


            } else if (response.equalsIgnoreCase("r")) {
                runFromShips();
                if (runFromShips() == false) {
                    System.out.println("Couldn't run away!");
                    destroyShipsOrEscape(getNumOfPeasantShips());
                } else {
                    break;
                }

            }

        }


    }


    public void fightOrRunMessage() {
        System.out.printf("What do you want to do? Enter \"f\" to fight, and \"r\" to run (we have %d guns)", getGuns());

    }

    public int getNumOfPeasantShips() {
        return numOfPeasantShips;
    }

    public void setNumOfPeasantShips(int numOfPeasantShips) {
        this.numOfPeasantShips = numOfPeasantShips;
    }

    public void delayForASecond() throws Exception {
        TimeUnit.SECONDS.sleep(1);
    }


    public int numOfShips() {

        int numOfShipsAttacking = 0;
        Random randomValue = new Random();

        if (getMoney() <= 100000) {
            //Minimum one ship will attack, maximum 20
            numOfShipsAttacking = randomValue.nextInt(20) + 1;
        } else if (getMoney() <= 200000) {
            //Minimum 30 Ships will attack, maximum 70
            numOfShipsAttacking = randomValue.nextInt(40) + 30;
        } else if (getMoney() <= 500000) {
            //Minimum 50 ships will attack, maximum 140
            numOfShipsAttacking = randomValue.nextInt(90) + 50;
        } else if (getMoney() > 1000000) {
            //Minimum 100 ships will attack, maximum 300 ships
            numOfShipsAttacking = randomValue.nextInt(3) + 100;
        }

        return numOfShipsAttacking;

    }

    public boolean runFromShips() {
        userAttacks = false;
        Random randomValue = new Random();
        int runSuccessChance = randomValue.nextInt(2) + 1;
        if (runSuccessChance == 2) {
            return true;
        } else if (runSuccessChance == 1) {
            return false;
        }
        return false;
    }

    public boolean destroyShipsOrEscape(int typeOfShip) throws Exception {
        Scanner userInput = new Scanner(System.in);
        Random randomValue = new Random();
        numOfPeasantShips = typeOfShip;
        int exitValue = 0;

        //Player volley
        if (exitValue == 0) {
            while (exitValue == 0) {
                for (int i = 0; i < numOfPeasantShips; i++) {

                    for (int j = 0; j < getGuns(); j++) {
                        if (userAttacks == true) {
                            int hitOrMiss = randomValue.nextInt(2) + 1;
                            if (hitOrMiss == 2) {
                                numOfPeasantShips--;
                                if (numOfPeasantShips <= 0) {
                                    exitValue = 1;
                                    break;
                                }
                                System.out.println("Got eem");
                                delayForASecond();
                            } else {
                                System.out.println("ARRG! We missed captain");
                                delayForASecond();
                            }


                        } else {
                            continue;
                        }
                    }


                    if (numOfPeasantShips <= 0) {
                        exitValue = 1;
                        break;
                    }

                    System.out.printf("%d ships remaining\n", getNumOfPeasantShips());
                    System.out.println("Oh no, they are taking the offensive!");
                    delayForASecond();
                    //Computer volley
                    int takeGunChance = randomValue.nextInt(4) + 1;
                    if (takeGunChance == 1 && getGuns() > 0) {
                        setGuns(getGuns() - 1);
                        System.out.println("Dang it! They destroyed one of our guns");
                    } else {
                        setHP(getHP() - (1 + randomValue.nextInt(10)));
                    }
                    if (getHP() <= 0) {
                        exitValue = 2;
                        break;
                    }
                    System.out.printf("EEK, we have %d health left\n", getHP());
                    delayForASecond();
                    if (userAttacks == false) {
                        userAttacks = true;
                    }

                    System.out.printf("Shall we continue to fight? Enter \"f\" to fight, and \"r\" to run (We have %d guns left)", getGuns());

                    String response = userInput.nextLine();
                    if (response.equalsIgnoreCase("r")) {
                        runFromShips();
                        if (runFromShips() == false) {
                            System.out.println("Couldn't run away");
                        } else {
                            exitValue = 3;
                            break;
                        }
                    }


                }
                if (runFromShips() == true) {
                    break;
                }
            }
        }
        if (exitValue == 1) {
            System.out.printf("\nGot eem\nVictory!\nIt appears we have defeated the enemy fleet and made it out at %d health\n", getHP());
            return true;
        } else if (exitValue == 2) {
            gameOver();
            return true;
        } else if (exitValue == 3) {
            System.out.printf("We made it out at %d health!\n", getHP());
            return true;
        }
        return false;


    }
    //Type of ship implied to be Liu Yen fleet


    public static void main(String[] args) throws Exception {
        ShipWarfare littyObject = new ShipWarfare();
        littyObject.peasantFleetAttack();
    }

}


