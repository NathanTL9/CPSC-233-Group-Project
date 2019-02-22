import java.util.Scanner;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class ShipWarfare extends Player {

    private int numOfPeasantShips = 0;
    private int numOfLittyShips = 0;
    private boolean userAttacks = true;
    private int startingPeasantShips = 0;
    private int startingLittyShips =0;
    private int howMuchRun = 0;
    private String pirateName = "Liu Yen";


    public void peasantFleetAttack() throws Exception {
        Scanner userResponse = new Scanner(System.in);
        setNumOfPeasantShips(numOfShips());

        System.out.printf("By Golly! We have $%,d and are being attacked by %d Merchant ships\nCurrently our ship status is %d%%\n", getMoney(), numOfLittyShips, getHP());

        fightOrRunMessage();
        while (true) {
            String response = userResponse.nextLine();
            if (response.equalsIgnoreCase("f")) {
                userAttacks = true;
                System.out.println("Ohh, fight ehh?");
                boolean winOrLose = destroyPeasantShipsOrEscape();
                if (winOrLose == true) {
                    break;
                }


            } else if (response.equalsIgnoreCase("r")) {
                if (runFromShips() == false) {
                    System.out.println("Couldn't run away!");
                    if (destroyPeasantShipsOrEscape())
                        break;
                } else {
                    System.out.println("Phew! Got away safely");
                    break;
                }

            }

        }


    }

    public void littyFleetAttack() throws Exception {
        Scanner userResponse = new Scanner(System.in);
        setNumOfLittyShips(numOfShips());
        System.out.printf("By Golly! We have $%,d and are being attacked by %d of %s's ships\nCurrently our ship status is %d%%\n", getMoney(), numOfLittyShips, pirateName, getHP());
        fightOrRunMessage();
        while (true) {
            String response = userResponse.nextLine();
            if (response.equalsIgnoreCase("f")) {
                userAttacks = true;
                System.out.println("Ohh, fight ehh?");
                boolean winOrLose = destroyLittyShipsOrEscape();
                if (winOrLose == true) {
                    break;
                }


            } else if (response.equalsIgnoreCase("r")) {
                if (runFromShips() == false) {
                    System.out.println("Couldn't run away!");
                    if (destroyLittyShipsOrEscape())
                        break;
                } else {
                    System.out.println("Phew! Got away safely");
                    break;
                }

            }

        }


    }


    public void fightOrRunMessage() {
        System.out.printf("What do you want to do? Enter \"f\" to fight, and \"r\" to run (we have %d guns)", getGuns());

    }

    public int numOfPeasantShips() {
        return numOfPeasantShips;

    }

    public void setNumOfLittyShips(int numOfLittyShips) {
        this.numOfLittyShips = numOfLittyShips;
        startingLittyShips = numOfLittyShips;

    }

    public void setNumOfPeasantShips(int numOfPeasantShips) {
        this.numOfPeasantShips = numOfPeasantShips;
        startingPeasantShips = numOfPeasantShips;

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

    public boolean destroyLittyShipsOrEscape() throws Exception {
        int calculateLoot = 0;
        int chanceOfEnemyRun = 0;


        Scanner userInput = new Scanner(System.in);
        Random randomValue = new Random();
        int exitValue = 0;

        //Player volley
        while (exitValue == 0) {
            for (int j = 0; j < getGuns(); j++) {
                if (userAttacks == true) {
                    int hitOrMiss = randomValue.nextInt(3) + 1;
                    if (hitOrMiss == 1) {
                        numOfLittyShips--;
                        if (numOfLittyShips <= 0) {
                            exitValue = 1;
                            break;
                        }
                        System.out.println("Got eem");
                        delayForASecond();
                    } else if (hitOrMiss == 2) {
                        System.out.printf("ARRG! We missed %s\n", getName());
                        delayForASecond();
                    } else {
                        System.out.println("Darn! Their fleet tanked our attack");
                        delayForASecond();
                    }


                } else {
                    continue;
                }
            }


            if (numOfLittyShips <= 0) {
                exitValue = 1;
                break;
            }
            chanceOfEnemyRun = randomValue.nextInt(2) + 1;
            if (chanceOfEnemyRun == 2) {
                howMuchRun = randomValue.nextInt(10) + 1;
                if (howMuchRun != 0 && howMuchRun < numOfLittyShips) {


                    setNumOfLittyShips(numOfLittyShips - howMuchRun);
                    if (userAttacks == true) {
                        System.out.printf("Cowards! %d ships ran away %s!\n", howMuchRun, getName());
                    } else {
                        System.out.printf("Escaped %d of them!\n", howMuchRun);
                    }
                }
            }

            System.out.printf("%d ships remaining\n", numOfLittyShips);
            System.out.println("Oh no, they are taking the offensive!");
            delayForASecond();
            //Computer volley
            int takeGunChance = randomValue.nextInt(4) + 1;
            if (takeGunChance == 1 && getGuns() > 0) {
                setGuns(getGuns() - 1);
                System.out.println("Dang it! They destroyed one of our guns");
            } else {
                setHP(getHP() - (1 + randomValue.nextInt(15)));
            }
            if (getHP() <= 0) {
                exitValue = 2;
                break;
            }
            System.out.printf("EEK, our current ship status is %d%% \n", getHP());
            delayForASecond();
            if (userAttacks == false) {
                userAttacks = true;
            }

            System.out.printf("Shall we continue to fight? Enter \"f\" to fight, and \"r\" to run (We have %d gun(s) left)\n", getGuns());

            String response = userInput.nextLine();
            if (response.equalsIgnoreCase("r")) {
                if (runFromShips() == false) {
                    System.out.println("Couldn't run away");
                } else {
                    exitValue = 3;
                    break;
                }
            }


        }


        if (exitValue == 1) {
            System.out.printf("\nGot eem\nVictory!\nIt appears we have defeated the enemy fleet and made it out at %d%% ship status\n", getHP());
            calculateLoot = (randomValue.nextInt(startingPeasantShips) + startingPeasantShips) * 100;
            setMoney(getMoney() + calculateLoot);
            System.out.printf("We got $%,d!\n", calculateLoot);
            return true;
        } else if (exitValue == 2) {
            gameOver();
            return true;
        } else if (exitValue == 3) {
            System.out.printf("We made it out at %d%% ship status!\n", getHP());
            return true;
        }
        return false;


    }


    public boolean destroyPeasantShipsOrEscape() throws Exception {
        int calculateLoot = 0;
        int chanceOfEnemyRun = 0;


        Scanner userInput = new Scanner(System.in);
        Random randomValue = new Random();
        int exitValue = 0;

        //Player volley
        while (exitValue == 0) {
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
                        System.out.printf("ARRG! We missed %s\n", getName());
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
            chanceOfEnemyRun = randomValue.nextInt(2) + 1;
            if (chanceOfEnemyRun == 2) {
                howMuchRun = randomValue.nextInt(15) + 1;
                if (howMuchRun != 0 && howMuchRun < numOfPeasantShips) {


                    setNumOfPeasantShips(numOfPeasantShips - howMuchRun);
                    if (userAttacks == true) {
                        System.out.printf("Ahhh, %d ships ran away %s!\n", howMuchRun, getName());
                    } else {
                        System.out.printf("Escaped %d of them!\n", howMuchRun);
                    }
                }
            }

            System.out.printf("%d ships remaining\n", numOfPeasantShips);
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
            System.out.printf("EEK, our current ship status is %d%% \n", getHP());
            delayForASecond();
            if (userAttacks == false) {
                userAttacks = true;
            }

            System.out.printf("Shall we continue to fight? Enter \"f\" to fight, and \"r\" to run (We have %d gun(s) left)\n", getGuns());

            String response = userInput.nextLine();
            if (response.equalsIgnoreCase("r")) {
                if (runFromShips() == false) {
                    System.out.println("Couldn't run away");
                } else {
                    exitValue = 3;
                    break;
                }
            }


        }


        if (exitValue == 1) {
            System.out.printf("\nGot eem\nVictory!\nIt appears we have defeated the enemy fleet and made it out at %d%% ship status\n", getHP());
            calculateLoot = (randomValue.nextInt(startingPeasantShips) + startingPeasantShips) * 100;
            setMoney(getMoney() + calculateLoot);
            System.out.printf("We got $%,d!", calculateLoot);
            return true;
        } else if (exitValue == 2) {
            gameOver();
            return true;
        } else if (exitValue == 3) {
            System.out.printf("We made it out at %d%% ship status!\n", getHP());
            return true;
        }
        return false;


    }


    public static void main(String[] args) throws Exception {
        ShipWarfare littyObject = new ShipWarfare();
        littyObject.littyFleetAttack();
    }

}

