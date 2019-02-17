package TeamProject;

import java.util.Scanner;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class ShipWarfare {

    private int money = 0;
    private int guns = 3;
    private int hp = 100;
    private int numOfPeasantShips= 0;

    public void peasantFleetAttack() throws Exception{
        Scanner userResponse = new Scanner(System.in);
        numOfPeasantShips=numOfShips();
        System.out.printf("By Golly! You have $%,d \nYou are being attacked by %d ships\n", getMoney(), getNumOfPeasantShips());
        System.out.println("What do you want to do?");
        System.out.println("Ohh, fight ehh?");
        fightShips(getNumOfPeasantShips());

    }

    public int getMoney() {
        return money;
    }

    public int getGuns() {
        return guns;
    }

    public int getHp() {
        return hp;
    }

    public int getNumOfPeasantShips() {
        return numOfPeasantShips;
    }

    public void delayForASecond() throws Exception {
        TimeUnit.SECONDS.sleep(1);
    }

    public void gameOver(){
        System.out.flush();
        System.out.println("Game over");
    }

    public int numOfShips(){

        int numOfShipsAttacking = 0;
        Random randomValue = new Random();

        if (getMoney() <= 100000){
            //Minimum one ship will attack, maximum 20
             numOfShipsAttacking = randomValue.nextInt(20) + 1;
        }

        else if (getMoney() <= 200000){
            //Minimum 30 Ships will attack, maximum 70
            numOfShipsAttacking = randomValue.nextInt(40) + 30;
        }

        else if (getMoney() <= 500000){
            //Minimum 50 ships will attack, maximum 140
            numOfShipsAttacking = randomValue.nextInt(90) + 50;
        }

        else if (getMoney() > 1000000){
            //Minimum 100 ships will attack, maximum 300 ships
            numOfShipsAttacking = randomValue.nextInt(3) + 100;
        }

        return numOfShipsAttacking;

    }

    public void fightShips(int typeOfShip)  throws Exception {

        Random randomValue = new Random();
        int shipsRemaining = typeOfShip;
        int exitValue=0;

        if(typeOfShip==getNumOfPeasantShips()) {
            //Player volley
            while (exitValue==0){
                for (int i = 0; i < shipsRemaining; i++) {
                    for (int j = 0; j < getGuns(); j++) {
                        int hitOrMiss = randomValue.nextInt(2) + 1;
                        if (hitOrMiss == 2) {
                            shipsRemaining--;
                            if (shipsRemaining <= 0) {
                                exitValue = 1;
                                break;
                            }
                            System.out.println("Got eem");
                            delayForASecond();
                        } else {
                            System.out.println("ARRG! We missed captain");
                            delayForASecond();
                        }


                    }

                    if (shipsRemaining <= 0) {
                        exitValue = 1;
                        break;
                    }

                    System.out.printf("%d ships remaining\n", shipsRemaining);
                    System.out.println("Oh no, they are taking the offensive!");
                    delayForASecond();
                    //Computer volley
                    hp -= randomValue.nextInt(10);
                    if(getHp()<=0){
                        exitValue=2;
                        break;
                    }
                    System.out.printf("EEk, you have %d health left\n", getHp());
                    delayForASecond();

                }
        }
            if(exitValue==1) {
                System.out.printf("Got eem!\nIt appears we have defeated the enemy fleet and made it out at %d health", hp);
            }
            else if(exitValue==2){
                gameOver();
            }

        }
        //Type of ship implied to be Liu Yen fleet

        else{

        }
    }

    public static void main(String[] args) throws Exception  {
        ShipWarfare littyObject = new ShipWarfare();
        littyObject.peasantFleetAttack();
    }

}
