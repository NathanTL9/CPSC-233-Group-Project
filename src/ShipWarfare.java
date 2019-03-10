import java.util.Scanner;
import java.util.Random;
import java.util.concurrent.TimeUnit;


public class ShipWarfare {

    private int numOfPeasantShips = 0;
    private int numOfLittyShips = 0;
    private boolean userAttacks = true;
    private int startingPeasantShips = 0;
    private int startingLittyShips = 0;
    private int howMuchRun = 0;
    private String pirateName = "Liu Yen";
    private Player player;

    /**
     * Class Constructor that takes in a type player as a parameter
     * @param player object of the class Player
     */
    public ShipWarfare(Player player) {
        Player playerDummy = new Player(player);
        this.player = playerDummy;
    }

    /**
     * setter method for player
     * @param player object of the class Player
     */
    public void setPlayer(Player player) {
        Player playerDummy = new Player(player);
        this.player = playerDummy;
    }

    /**
     * getter method for obtaining a player object.
     * @return returns player object
     */
    public Player getPlayer() {
        Player playerDummy = new Player(player);
        return playerDummy;
    }

    /**
     * This fleet is easy to defeat as a maximum of 15 ships can run away each volley, they can not tank hits
     * @throws Exception in case of errors due to the delay
     */
    public void peasantFleetAttack() throws Exception {
        Scanner userResponse = new Scanner(System.in);
        setNumOfPeasantShips(numOfShips());

        System.out.printf("By Golly! We have $%,d and are being attacked by %d Merchant ships\nCurrently our ship status is %d%%\n", player.getMoney(), getNumOfPeasantShips(), player.getHP());

        fightOrRunMessage();
        while (true) {
            String response = userResponse.nextLine();
            if (response.equalsIgnoreCase("f")) {
                setUserAttacks(true);
                System.out.println("Ohh, fight ehh?");
                delayForSeconds(1);
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
                    delayForSeconds(2);
                    break;
                }

            }

        }


    }

    public int getNumOfPeasantShips() {
        return numOfPeasantShips;
    }

    public int getNumOfLittyShips() {
        return numOfLittyShips;
    }

    public boolean isUserAttacks() {
        return userAttacks;
    }

    public int getStartingPeasantShips() {
        return startingPeasantShips;
    }

    public int getStartingLittyShips() {
        return startingLittyShips;
    }

    public int getHowMuchRun() {
        return howMuchRun;
    }

    public String getPirateName() {
        return pirateName;
    }

    public void setUserAttacks(boolean userAttacks) {
        this.userAttacks = userAttacks;
    }

    /**
     * This fleet is difficult to defeat as a maximum of 10 ships can run away each volley, they can tank hits
     * @throws Exception in case of errors due to the delay
     */
    public void littyFleetAttack() throws Exception {
        Scanner userResponse = new Scanner(System.in);
        setNumOfLittyShips(numOfShips());
        System.out.printf("By Golly! We have $%,d and are being attacked by %d of %s's ships\nCurrently our ship status is %d%%\n", player.getMoney(), getNumOfLittyShips(), getPirateName(), player.getHP());
        fightOrRunMessage();
        while (true) {
            String response = userResponse.nextLine();
            if (response.equalsIgnoreCase("f")) {
                setUserAttacks(true);
                System.out.println("Ohh, fight ehh?");
                boolean winOrLose = destroyLittyShipsOrEscape();
                if (winOrLose == true) {
                    break;
                }


            } else if (response.equalsIgnoreCase("r")) {
                if (runFromShips() == false) {
                    System.out.println("Couldn't run away!");
                    delayForSeconds(1);
                    if (destroyLittyShipsOrEscape())
                        break;
                } else {
                    System.out.println("Phew! Got away safely");
                    delayForSeconds(2);
                    break;
                }

            }

        }


    }

    /**
     * Asks user if they would like to fight or run against ships
     */

    public void fightOrRunMessage() {
        System.out.printf("What do you want to do? Enter \"f\" to fight, and \"r\" to run (we have %d guns)\n", player.getGuns());

    }

    /**
     * setter method that takes in an integer as an argument
     * @param numOfLittyShips the number of ships to be used in the litty fleet attack
     */
    public void setNumOfLittyShips(int numOfLittyShips) {
        this.numOfLittyShips = numOfLittyShips;
        startingLittyShips = numOfLittyShips;

    }

    /**
     * setter method that takes in an integer as an argument
     * @param numOfPeasantShips the number of ships to be used in the peasant fleet attack
     */

    public void setNumOfPeasantShips(int numOfPeasantShips) {
        this.numOfPeasantShips = numOfPeasantShips;
        startingPeasantShips = numOfPeasantShips;

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
     * The number of ships that attack is based on the amount of money one has on hand
     * @return the number of ships which will attack
     */
    public int numOfShips() {

        int numOfShipsAttacking = 0;
        Random randomValue = new Random();

        if (player.getMoney() <= 100000) {
            //Minimum one ship will attack, maximum 20
            numOfShipsAttacking = randomValue.nextInt(20) + 1;
        } else if (player.getMoney() <= 200000) {
            //Minimum 30 Ships will attack, maximum 70
            numOfShipsAttacking = randomValue.nextInt(40) + 30;
        } else if (player.getMoney() <= 500000) {
            //Minimum 50 ships will attack, maximum 140
            numOfShipsAttacking = randomValue.nextInt(90) + 50;
        } else if (player.getMoney() > 1000000) {
            //Minimum 100 ships will attack, maximum 300 ships
            numOfShipsAttacking = randomValue.nextInt(3) + 100;
        }

        return numOfShipsAttacking;

    }

    /**
     * One in two chance of running away
     * @return true if the user is allowed to run, false if not, the "default" is false
     */

    public boolean runFromShips() {
        setUserAttacks(false);
        Random randomValue = new Random();
        int runSuccessChance = randomValue.nextInt(2) + 1;
        if (runSuccessChance == 2) {
            return true;
        } else if (runSuccessChance == 1) {
            return false;
        }
        return false;
    }

    public void setHowMuchRun(int howMuchRun) {
        this.howMuchRun = howMuchRun;
    }

    /**
     * The user faces off against the litty ships and either prevails, dies, or runs away
     * The loot for defeating a litty fleet is much higher than that of a peasant one
     * @return true if the user wins, loses, or flees, it returns false otherwise
     * @throws Exception in case of errors due to the delay
     */
    public boolean destroyLittyShipsOrEscape() throws Exception {
        int calculateLoot = 0;
        int chanceOfEnemyRun = 0;


        Scanner userInput = new Scanner(System.in);
        Random randomValue = new Random();
        int exitValue = 0;

        //Player volley
        while (exitValue == 0) {
            if (player.getGuns() > 0) {
                for (int j = 0; j < player.getGuns(); j++) {
                    if (isUserAttacks()==true) {
                        int hitOrMiss = randomValue.nextInt(3) + 1;
                        if (hitOrMiss == 1) {
                            setNumOfPeasantShips(getNumOfPeasantShips()-1);
                            if (getNumOfLittyShips() <= 0) {
                                exitValue = 1;
                                break;
                            }
                            System.out.println("Got eem");
                            delayForSeconds(1);
                        } else if (hitOrMiss == 2) {
                            System.out.printf("ARRG! We missed %s\n", player.getName());
                            delayForSeconds(1);
                        } else {
                            System.out.println("Darn! Their fleet tanked our attack");
                            delayForSeconds(1);
                        }


                    } else {
                        continue;
                    }
                }
            } else {
                System.out.printf("%s! We don't have any GUNS!!!!\n",player.getName());
                delayForSeconds(1);
            }


            if (getNumOfLittyShips() <= 0) {
                exitValue = 1;
                break;
            }
            if (player.getGuns() > 0) {
                if (chanceOfEnemyRun == 2) {
                    chanceOfEnemyRun = randomValue.nextInt(2) + 1;
                    setHowMuchRun(randomValue.nextInt(10) + 1);
                    if (getHowMuchRun() != 0 && getHowMuchRun() < getNumOfLittyShips()) {


                        setNumOfLittyShips(getNumOfLittyShips() - getHowMuchRun());
                        if (isUserAttacks()==true) {
                            System.out.printf("Cowards! %d ships ran away %s!\n", getHowMuchRun(), player.getName());
                        } else {
                            System.out.printf("Escaped %d of them!\n", getHowMuchRun());
                        }
                    }
                }
            }

            System.out.printf("%d ships remaining\n", getNumOfLittyShips());
            System.out.println("Oh no, they are taking the offensive!");
            delayForSeconds(1);
            //Computer volley
            int takeGunChance = randomValue.nextInt(4) + 1;
            if (takeGunChance == 1 && player.getGuns() > 0) {
                player.setGuns(player.getGuns() - 1);
                System.out.println("Dang it! They destroyed one of our guns");
            } else {
                player.setHP(player.getHP() - (1 + randomValue.nextInt(15)));
            }
            if (player.getHP() <= 0) {
                exitValue = 2;
                break;
            }
            System.out.printf("EEK, our current ship status is %d%% \n", player.getHP());
            delayForSeconds(1);
            if (isUserAttacks() == false) {
                setUserAttacks(true);
            }

            System.out.printf("Shall we continue to fight? Enter \"f\" to fight, and \"r\" to run (We have %d gun(s) left)\n", player.getGuns());

            String response = userInput.nextLine();
            if (response.equalsIgnoreCase("r")) {
                if (runFromShips() == false) {
                    System.out.println("Couldn't run away");
                    delayForSeconds(1);
                } else {
                    System.out.println("Phew! Got away safely");
                    delayForSeconds(2);
                    break;
                }
            }


        }


        if (exitValue == 1) {
            System.out.printf("\nGot eem\nVictory!\nIt appears we have defeated the enemy fleet and made it out at %d%% ship status\n", player.getHP());
            delayForSeconds(1);
            calculateLoot = (randomValue.nextInt(getStartingLittyShips()) + getStartingLittyShips()) * 300;
            player.setMoney(player.getMoney() + calculateLoot);
            System.out.printf("We got $%,d!\n", calculateLoot);
            delayForSeconds(2);
            return true;
        } else if (exitValue == 2) {
            player.gameOver();

            return true;
        } else if (exitValue == 3) {
            System.out.printf("We made it out at %d%% ship status!\n", player.getHP());
            delayForSeconds(2);
            return true;
        }
        return false;


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
            if (player.getGuns() > 0) {

                for (int j = 0; j < player.getGuns(); j++) {
                    if (isUserAttacks()==true) {
                        int hitOrMiss = randomValue.nextInt(2) + 1;
                        if (hitOrMiss == 2) {
                            setNumOfPeasantShips(getNumOfPeasantShips()-1);
                            if (getNumOfPeasantShips() <= 0) {
                                exitValue = 1;
                                break;
                            }
                            System.out.println("Got eem");
                            delayForSeconds(1);
                        } else {
                            System.out.printf("ARRG! We missed %s\n", player.getName());
                            delayForSeconds(1);
                        }


                    } else {
                        continue;
                    }
                }
            }
            else{
                System.out.printf("%s! We don't have any GUNS!!!!\n", player.getName());
                delayForSeconds(1);

            }


            if (getNumOfPeasantShips() <= 0) {
                exitValue = 1;
                break;
            }
            if (player.getGuns() > 0) {
                chanceOfEnemyRun = randomValue.nextInt(2) + 1;
                if (chanceOfEnemyRun == 2) {
                    setHowMuchRun(randomValue.nextInt(15) + 1);
                    if (getHowMuchRun() != 0 && getHowMuchRun() < getNumOfPeasantShips()) {


                        setNumOfPeasantShips(getNumOfPeasantShips() - getHowMuchRun());
                        if ( isUserAttacks()==true) {
                            System.out.printf("Ahhh, %d ships ran away %s!\n", getHowMuchRun(), player.getName());
                        } else {
                            System.out.printf("Escaped %d of them!\n", getHowMuchRun());
                        }
                    }
                }
            }

            System.out.printf("%d ships remaining\n", getNumOfPeasantShips());
            delayForSeconds(1);
            System.out.println("Oh no, they are taking the offensive!");
            delayForSeconds(1);
            //Computer volley
            int takeGunChance = randomValue.nextInt(4) + 1;
            if (takeGunChance == 1 && player.getGuns() > 0) {
                player.setGuns(player.getGuns() - 1);
                System.out.println("Dang it! They destroyed one of our guns");
            } else {
                player.setHP(player.getHP() - (1 + randomValue.nextInt(10)));
            }
            if (player.getHP() <= 0) {
                exitValue = 2;
                break;
            }
            System.out.printf("EEK, our current ship status is %d%% \n", player.getHP());
            delayForSeconds(1);
            if (isUserAttacks()==false) {
                setUserAttacks(true);
            }

            System.out.printf("Shall we continue to fight? Enter \"f\" to fight, and \"r\" to run (We have %d gun(s) left)\n", player.getGuns());

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
            System.out.printf("\nGot eem\nVictory!\nIt appears we have defeated the enemy fleet and made it out at %d%% ship status\n", player.getHP());
            delayForSeconds(1);
            calculateLoot = (randomValue.nextInt(getStartingPeasantShips()) + getStartingPeasantShips()) * 100;
            player.setMoney(player.getMoney() + calculateLoot);
            System.out.printf("We got $%,d!", calculateLoot);
            delayForSeconds(2);
            return true;
        } else if (exitValue == 2) {
            player.gameOver();
            return true;
        } else if (exitValue == 3) {
            System.out.printf("We made it out at %d%% ship status!\n", player.getHP());
            delayForSeconds(2);
            return true;
        }
        return false;


    }

}

