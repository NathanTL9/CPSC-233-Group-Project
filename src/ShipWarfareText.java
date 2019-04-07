import java.util.Scanner;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * 2019-04-07
 * Author: Haris Muhammad
 * ShipWarfareText class, Based on logic class for ShipWarfare, text-based version which allwos for ship warfare
 */



public class ShipWarfareText extends Player {

    ShipWarfareLogic logic = new ShipWarfareLogic(getPlayer());

    private boolean userAttacks = true;
    private int howMuchRun = 0;

    /**
     * Class Constructor that takes in a type player as a parameter
     *
     * @param player object of the class Player
     */
    public ShipWarfareText(Player player) {
        Player playerDummy = new Player(player);
        setPlayer(playerDummy);
    }


    /**
     * This fleet is easy to defeat as a maximum of 15 ships can run away each volley, they can not tank hits
     *
     * @throws Exception in case of errors due to the delay
     */
    public void peasantFleetAttack() throws Exception {
        Scanner userResponse = new Scanner(System.in);
        logic.setNumOfShips(logic.numOfShips());

        System.out.printf("By Golly! We have $%,d and are being attacked by %d Merchant ships\nCurrently our ship status is %d%%\n", getMoney(), logic.getNumOfShips(), getHP());

        fightOrRunMessage();
        while (true) {
            String response = userResponse.nextLine();
            if (response.equalsIgnoreCase("f")) {
                userAttacks = true;
                System.out.println("Ohh, fight ehh?");
                delayForSeconds(1);
                boolean winOrLose = destroyPeasantShipsOrEscape();
                if (winOrLose == true) {
                    break;
                }


            } else if (response.equalsIgnoreCase("r")) {
                userAttacks = false;
                boolean runSuccess = logic.runFromShips();
                if (runSuccess == false) {
                    System.out.println("Couldn't run away!");
                    if (destroyPeasantShipsOrEscape())
                        break;
                } else {
                    System.out.println("Phew! Got away safely");
                    delayForSeconds(2);
                    break;
                }
            } else {
                System.out.println("Invalid response, please try again");
            }
        }
    }


    /**
     * Asks user if they would like to fight or run against ships
     */
    public void fightOrRunMessage() {
        System.out.printf("What do you want to do? Enter \"f\" to fight, and \"r\" to run (we have %d guns)\n", getGuns());
    }

    /**
     * delays for a specific amount of seconds, takes an integer as an argument
     * @param num the seconds to delay
     * @throws Exception in case of errors due to the delay
     */
    public void delayForSeconds(int num) throws Exception {
        TimeUnit.SECONDS.sleep(num);
    }


    /**
     * The user faces off against the peasant ships and either prevails, dies, or runs away
     * @return true if the user wins, loses, or flees, it returns false otherwise
     * @throws Exception in case of errors due to the delay
     */
    public boolean destroyPeasantShipsOrEscape() throws Exception {
        int calculateLoot = 0;
        int chanceOfEnemyRun = 0;


        Scanner userInput = new Scanner(System.in);
        Random randomValue = new Random();
        int exitValue = 0;

        //Player volley
        while (exitValue == 0) {
            if (getGuns() > 0) {

                for (int j = 0; j < getGuns(); j++) {
                    if (userAttacks == true) {
                        int hitOrMiss = randomValue.nextInt(2) + 1;
                        if (hitOrMiss == 2) {
                            logic.setNumOfShips(logic.getNumOfShips() - 1);
                            if (logic.getNumOfShips() <= 0) {
                                exitValue = 1;
                                break;
                            }
                            System.out.println("Got eem");
                            delayForSeconds(1);
                        } else {
                            System.out.printf("ARRG! We missed %s\n", getName());
                            delayForSeconds(1);
                        }


                    } else {
                        continue;
                    }
                }
            } else {
                System.out.printf("%s! We don't have any GUNS!!!!\n", getName());
                delayForSeconds(1);

            }


            if (logic.getNumOfShips() <= 0) {
                exitValue = 1;
                break;
            }
            if (getGuns() > 0) {
                chanceOfEnemyRun = randomValue.nextInt(2) + 1;
                if (chanceOfEnemyRun == 2) {
                    howMuchRun = randomValue.nextInt(15) + 1;
                    if (howMuchRun != 0 && howMuchRun < logic.getNumOfShips()) {


                        logic.setNumOfShips(logic.getNumOfShips() - howMuchRun);
                        if (userAttacks == true) {
                            System.out.printf("Ahhh, %d ships ran away %s!\n", howMuchRun, getName());
                        } else {
                            System.out.printf("Escaped %d of them!\n", howMuchRun);
                        }
                    }
                }
            }

            System.out.printf("%d ships remaining\n", logic.getNumOfShips());
            delayForSeconds(1);
            System.out.println("Oh no, they are taking the offensive!");
            delayForSeconds(1);
            //Computer volley
            int takeGunChance = randomValue.nextInt(4) + 1;
            if (takeGunChance == 1 && getGuns() > 0) {
                setGuns(getGuns() - 1);
                System.out.println("Dang it! They destroyed one of our guns");
            } else {
                setHP(getHP() - (1 + randomValue.nextInt(10)));
            }
            if (getHP() > 0) {
                String userResponse = displayQuery(userInput);
                if (userResponse.equalsIgnoreCase("r")) {
                    userAttacks = false;
                    if (logic.runFromShips() == false) {
                        System.out.println("Couldn't run away");
                    } else {
                        exitValue = 3;
                        break;
                    }
                }

            } else {
                exitValue = 2;
                break;
            }


        }


        if (exitValue == 1) {
            System.out.printf("\nGot eem\nVictory!\nIt appears we have defeated the enemy fleet and made it out at %d%% ship status\n", getHP());
            delayForSeconds(1);
            calculateLoot = logic.calculateLoot();
            System.out.printf("We got $%,d!", calculateLoot);
            delayForSeconds(2);
            return true;
        } else if (exitValue == 2) {
            gameOver();
            return true;
        } else if (exitValue == 3) {
            System.out.printf("We made it out at %d%% ship status!\n", getHP());
            delayForSeconds(2);
            return true;
        }
        return false;


    }

    /**
     * Ask the user to input either "f" or "r"
     * @param userInput scanner object which is used to ask for user input
     * @return user input which is the users response
     * @throws Exception in case the delay afects this piece of code
     */
    public String displayQuery(Scanner userInput) throws Exception {
        System.out.printf("EEK, our current ship status is %d%% \n", getHP());
        delayForSeconds(1);
        if (userAttacks == false) {
            userAttacks = true;
        }

        System.out.printf("Shall we continue to fight? Enter \"f\" to fight, and \"r\" to run (We have %d gun(s) left)\n", getGuns());

        String response = userInput.nextLine();
        while (!(response.equalsIgnoreCase("f") || response.equalsIgnoreCase("r"))) {
            System.out.println("Invalid response, try again");
            response = userInput.nextLine();
        }
        return response;
    }

}