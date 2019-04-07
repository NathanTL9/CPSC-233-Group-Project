import java.util.Scanner;
import java.util.Random;
import java.util.concurrent.TimeUnit;


public class ShipWarfareText extends Player {

    ShipWarfareLogic logic = new ShipWarfareLogic(getPlayer());

    private boolean userAttacks = true;
    private int howMuchRun = 0;
    private Player player;

    /**
     * Class Constructor that takes in a type player as a parameter
     * @param player object of the class Player
     */
    public ShipWarfareText(Player player) {
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
        logic.setNumOfShips(logic.numOfShips());

        System.out.printf("By Golly! We have $%,d and are being attacked by %d Merchant ships\nCurrently our ship status is %d%%\n", player.getMoney(), logic.getNumOfShips(), player.getHP());

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
                if (logic.runFromShips(userAttacks) == false) {
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

   

    /**
     * Asks user if they would like to fight or run against ships
     */

    public void fightOrRunMessage() {
        System.out.printf("What do you want to do? Enter \"f\" to fight, and \"r\" to run (we have %d guns)\n", player.getGuns());

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
            if (player.getGuns() > 0) {

                for (int j = 0; j < player.getGuns(); j++) {
                    if (userAttacks == true) {
                        int hitOrMiss = randomValue.nextInt(2) + 1;
                        if (hitOrMiss == 2) {
                            logic.setNumOfShips(logic.getNumOfShips()-1);
                            if (logic.getNumOfShips() <= 0) {
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


            if (logic.getNumOfShips() <= 0) {
                exitValue = 1;
                break;
            }
            if (player.getGuns() > 0) {
                chanceOfEnemyRun = randomValue.nextInt(2) + 1;
                if (chanceOfEnemyRun == 2) {
                    howMuchRun = randomValue.nextInt(15) + 1;
                    if (howMuchRun != 0 && howMuchRun < logic.getNumOfShips()) {


                        logic.setNumOfShips(logic.getNumOfShips() - howMuchRun);
                        if (userAttacks == true) {
                            System.out.printf("Ahhh, %d ships ran away %s!\n", howMuchRun, player.getName());
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
            if (takeGunChance == 1 && player.getGuns() > 0) {
                player.setGuns(player.getGuns() - 1);
                System.out.println("Dang it! They destroyed one of our guns");
            } else {
                player.setHP(player.getHP() - (1 + randomValue.nextInt(10)));
            }
            if (player.getHP() > 0) {
                displayQuery(userInput);
                String response ="";
                if (response.equalsIgnoreCase("r")) {
                    if (logic.runFromShips(userAttacks) == false) {
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
            System.out.printf("\nGot eem\nVictory!\nIt appears we have defeated the enemy fleet and made it out at %d%% ship status\n", player.getHP());
            delayForSeconds(1);
            calculateLoot = logic.calculateLoot();
            System.out.printf("We got $%,d!", calculateLoot);
            delayForSeconds(2);
            return true;
        } else if (exitValue == 2) {
            player.gameOver();
            return true;
        }
        return false;


    }

    public void displayQuery(Scanner userInput) throws Exception {
        System.out.printf("EEK, our current ship status is %d%% \n", player.getHP());
        delayForSeconds(1);
        if (userAttacks == false) {
            userAttacks = true;
        }

        System.out.printf("Shall we continue to fight? Enter \"f\" to fight, and \"r\" to run (We have %d gun(s) left)\n", player.getGuns());

        String response = userInput.nextLine();
    }

    public static void main(String[] args) throws Exception {
        Player littyBoi = new Player();
        littyBoi.setHP(100);
        littyBoi.setGuns(5);
        littyBoi.setMoney(1000);
        littyBoi.setName("Taipan");
        ShipWarfareText test = new ShipWarfareText(littyBoi);
        test.peasantFleetAttack();
    }

}