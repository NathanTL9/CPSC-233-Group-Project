import javafx.stage.Stage;

import java.util.Random;

/**
 * 2019-03-10 (Edited on 2019-04-1)
 * Author: Haris Muhammad
 * ShipWarfareGUILogic class, logic for ships which the user can attack or run from
 */


public class ShipWarfareGUILogic extends Player {

    private String titleMessage;
    private String HPLeftMessage;
    private String gunsLeftOrTakenMessage;
    private String runAwayOrLeftMessage;
    private String shipsRemainingMessage;
    private String reportMessage;

    private int numOfLittyShips = 0;
    private boolean userAttacks = true;
    private int startingLittyShips = 0;
    private int howMuchRun = 0;
    private int counter = 0;
    private String pirateName = "Liu Yen";

    private boolean winOrLose = false;

    private int counter1;
    private int avenue;

    public ShipWarfareGUILogic(Player player) {
        Player playerDummy = new Player(player);
        this.setPlayer(playerDummy);
    }


    /**
     * setter method that takes in an integer as an argument
     *
     * @param numOfLittyShips the number of ships to be used in the peasant fleet attack
     */
    public void setNumOfLittyShips(int numOfLittyShips) {
        counter1++;
        this.numOfLittyShips = numOfLittyShips;
        if (counter1 == 1) {
            startingLittyShips = numOfLittyShips;
        }
    }

    public int getNumOfLittyShips(){
        return numOfLittyShips;
    }

    /**
     * One in two chance of running away
     *
     * @return true if the user is allowed to run, false if not, the "default" is false
     */
    public boolean runFromShips() {
        userAttacks = false;
        Random randomValue = new Random();
        int runSuccessChance = randomValue.nextInt(10) + 1;
        if (runSuccessChance == 2) {
            return true;
        } else if (runSuccessChance == 1) {
            return false;
        }
        return false;
    }

    public String getTitleMessage() {
        return titleMessage;
    }

    public void setTitleMessage(String titleMessage) {
        this.titleMessage = titleMessage;
    }

    public String getHPLeftMessage() {
        return HPLeftMessage;
    }

    public void setHPLeftMessage(String HPLeftMessage) {
        this.HPLeftMessage = HPLeftMessage;
    }

    public String getGunsLeftOrTakenMessage() {
        return gunsLeftOrTakenMessage;
    }

    public void setGunsLeftOrTakenMessage(String gunsLeftOrTakenMessage) {
        this.gunsLeftOrTakenMessage = gunsLeftOrTakenMessage;
    }

    public String getRunAwayOrLeftMessage() {
        return runAwayOrLeftMessage;
    }

    public void setRunAwayOrLeftMessage(String runAwayOrLeftMessage) {
        this.runAwayOrLeftMessage = runAwayOrLeftMessage;
    }

    public String getShipsRemainingMessage() {
        return shipsRemainingMessage;
    }

    public void setShipsRemainingMessage(String shipsRemainingMessage) {
        this.shipsRemainingMessage = shipsRemainingMessage;
    }

    public String getReportMessage() {
        return reportMessage;
    }

    public void setReportMessage(String reportMessage) {
        this.reportMessage = reportMessage;
    }


    public int getAvenue() {
        return avenue;
    }

    public void setAvenue(int avenue) {
        this.avenue = avenue;
    }

    /**
     * The number of ships that attack is based on the amount of money one has on hand
     *
     * @return the number of ships which will attack
     */
    public int numOfShips() {

        int numOfShipsAttacking = 0;
        Random randomValue = new Random();

        if (getMoney() <= 100000) {
            //Minimum one ship will attack, maximum 20
            numOfShipsAttacking = randomValue.nextInt(20) + 1;
        } else if (getMoney() <= 200000) {
            //Minimum 30 Ships will attack, maximum 70
            numOfShipsAttacking = randomValue.nextInt(40) + 31;
        } else if (getMoney() <= 500000) {
            //Minimum 50 ships will attack, maximum 140
            numOfShipsAttacking = randomValue.nextInt(90) + 51;
        } else if (getMoney() >= 1000000) {
            //Minimum 100 ships will attack, maximum 300 ships
            numOfShipsAttacking = randomValue.nextInt(200) + 101;
        }

        return numOfShipsAttacking;

    }


    /**
     * The user faces off against the litty ships and either prevails, dies, or runs away
     *
     * @return true if the user wins, loses, or flees, it returns false otherwise
     */
    public int destroyLittyShipsOrEscape(int tempLittyShips) {

        this.numOfLittyShips = tempLittyShips;
        int calculateLoot = 0;
        int chanceOfEnemyRun = 0;
        int hitCounter = 0;
        int missCounter = 0;
        boolean gunFrustration = false;

        this.setRunAwayOrLeftMessage("No Ships ran away");


        Random randomValue = new Random();
        int exitValue = 0;
        //Player volley
        //while (exitValue == 0) {
        if (getGuns() > 0) {

            for (int j = 0; j < getGuns(); j++) {
                if (userAttacks == true) {

                    int hitOrMiss = randomValue.nextInt(2) + 1;
                    if (hitOrMiss == 2) {
                        numOfLittyShips--;
                        if (numOfLittyShips <= 0) {
                            exitValue = 1;
                            //break;
                        }
                        hitCounter++;


                    } else {
                        missCounter++;

                    }


                } else {
                    //continue;
                }
            }
            if (userAttacks == true) {
                this.setReportMessage(String.format("Report: Ships hit: %d, Shots missed: %d", hitCounter, missCounter));
            }
        } else {
            this.setReportMessage(("We don't have any guns!!!"));
        }


        if (numOfLittyShips <= 0) {
            exitValue = 1;
            //break;
        }
        if (getGuns() > 0) {
            chanceOfEnemyRun = randomValue.nextInt(2) + 1;
            if (chanceOfEnemyRun == 2) {
                howMuchRun = randomValue.nextInt(15) + 1;
                if (howMuchRun != 0 && howMuchRun < numOfLittyShips) {


                    this.setNumOfLittyShips(numOfLittyShips - howMuchRun);
                    if (userAttacks == true) {
                        if (howMuchRun > 0) {
                            this.setRunAwayOrLeftMessage(String.format("Cowards! %d ships ran away %s! ", howMuchRun, getName()));
                        }

                    } else {
                        this.setReportMessage((String.format("Escaped %d of them %s!", howMuchRun, getName())));
                    }

                }
            }
        }

        this.setShipsRemainingMessage(String.format("%d ships remaining and they look angry!", numOfLittyShips));

        //Computer volley
        int takeGunChance = randomValue.nextInt(4) + 1;
        if (takeGunChance == 1 && getGuns() > 0) {
            this.setGuns(getGuns() - 1);
            gunFrustration = true;
        } else {
            if (getNumOfLittyShips() > 0) {
                int HPTaken = randomValue.nextInt(10);
                this.setHP(getHP() - (HPTaken));

            }
        }
        if (getHP() <= 0) {
            exitValue = 2;
            //break;
        }
        if (gunFrustration == true) {
            this.setGunsLeftOrTakenMessage(String.format("Dang it! We only have %d guns left", getGuns()));
            //playerShoots(getGuns() + 1);

        } else {
            this.setGunsLeftOrTakenMessage(String.format("We still have %d guns left", getGuns()));
        }

        this.setHPLeftMessage(String.format("EEK, our current ship status is %d%% ", getHP()));

        if (userAttacks == false) {
            userAttacks = true;
        }


        if (exitValue == 1) {
            setAvenue(1);
            calculateLoot = (startingLittyShips * 100) + randomValue.nextInt(startingLittyShips) * 200;
            this.setMoney(getMoney() + calculateLoot);
            this.setReportMessage(String.format("Our firm has earned $%,d in loot! ", calculateLoot));

            return 1;

        } else if (exitValue == 2) {
            this.setAvenue(2);
            return 2;

        } else if (exitValue == 3) {
            this.setAvenue(3);
            this.setReportMessage(String.format("We made it out at %d%% ship status!", getHP()));
            return 3;
        }
        else{
            return 4;
        }

    }

    /*
     if (destroyLittyShipsOrEscape() == 1) {
            wipe();
            calculateLoot = (startingLittyShips * 100) + randomValue.nextInt(startingLittyShips) * 200;
            this.setMoney(getMoney() + calculateLoot);
            reportMessage = String.format("Our firm has earned $%,d in loot! ", calculateLoot);

            continueButton.this.setVisible(true);
            completeWipe();
            fightButton.this.setVisible(false);
            runButton.this.setVisible(false);
            continueButton.this.setDefaultButton(true);
            return true;


        } else if (destroyLittyShipsOrEscape() == 2) {
            GameEndGUI gameEndGUI = new GameEndGUI(getPlayer());
            gameEndGUI.initializeGameEndGUI(stage);
            stage.show();
            return true;

        } else if (destroyLittyShipsOrEscape() == 3) {
            report.this.setText(String.format("We made it out at %d%% ship status!", getHP()));

            continueButton.this.setVisible(true);
            completeWipe();
            fightButton.this.setVisible(false);
            runButton.this.setVisible(false);
            continueButton.this.setDefaultButton(true);
            return true;
        }
     */




}
