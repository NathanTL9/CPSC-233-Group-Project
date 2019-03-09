
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.util.Random;

import static javafx.application.Application.launch;

public class ShipWarfareGUI extends Application {


    private Player player = new Player();
    public static void main(String args[]){
        launch(args);
    }

    private Label label1;
    private HBox hBox1;
    private Button button1;
    private Button button2;
    private int counter = 0;

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

    public void setPlayer(Player player) {
        this.player = new Player(player);
    }

    public Player getPlayer() {
        return new Player(player);
    }

    public void setLabel1(String sysOut) {
        label1.setText(sysOut);
    }

    /*
    public void peasantFleet() throws Exception {
        ShipWarfare attackShip = new ShipWarfare(player);
        attackShip.peasantFleetAttack();
        player = attackShip.getPlayer();
    }
    */

    public void start(Stage stage){



        BorderPane BorderPane = new BorderPane();

        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10.0, 10.0, 10.0, 10.0));
        gridPane.setVgap(5.0);

        label1 = new Label();
        hBox1 = new HBox();
        button1 = new Button();
        button2 = new Button();

        BorderPane.setPrefHeight(400.0);
        BorderPane.setPrefWidth(600.0);

        BorderPane.setAlignment(label1, javafx.geometry.Pos.CENTER);
        label1.setText("Would you like to fight or Run?");
        BorderPane.setCenter(label1);

        BorderPane.setAlignment(hBox1, javafx.geometry.Pos.CENTER);
        hBox1.setAlignment(javafx.geometry.Pos.CENTER);
        hBox1.setPrefHeight(100.0);
        hBox1.setPrefWidth(200.0);
        hBox1.setSpacing(10.0);

        button1.setAlignment(javafx.geometry.Pos.CENTER);
        button1.setContentDisplay(javafx.scene.control.ContentDisplay.CENTER);
        button1.setMnemonicParsing(false);
        button1.setText("Fight");

        button2.setAlignment(javafx.geometry.Pos.CENTER);
        button2.setMnemonicParsing(false);
        button2.setText("Run");
        BorderPane.setBottom(hBox1);

        hBox1.getChildren().add(button1);
        hBox1.getChildren().add(button2);

        ShipWarfareGUI ship = new ShipWarfareGUI();
        label1.setText(ship.numOfShips() + " Merchant Ships are attacking you.");

        button1.setOnAction(new EventHandler<ActionEvent>(){
               @Override
               public void handle(ActionEvent event){
                   counter++;
                   if(counter == 1){
                       label1.setText("Ohh, fight ehh?");

                   }
                   if(player.getHP() <= 0){
                       System.out.println("You pressed the button.");
                       button1.setVisible(false);
                       button2.setVisible(false);
                       button1.setDisable(true);
                       button2.setDisable(true);
                   }
               }
           });

        Scene root = new Scene(BorderPane,600,480);

        stage.setTitle("Ship");
        stage.setResizable(false);
        stage.setScene(root);
        stage.show();

    }
}
