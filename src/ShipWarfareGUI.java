
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

import static javafx.application.Application.launch;

public class ShipWarfareGUI extends Application {


    private Player player;
    public static void main(String args[]){
        launch(args);
        ShipWarfare ship = new ShipWarfare(new Player());
        ship.peasantFleetAttack();
    }

    private Label label1;
    private HBox hBox1;
    private Button button1;
    private Button button2;

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

        button1.setOnAction(new EventHandler<ActionEvent>(){
               @Override
               public void handle(ActionEvent event){
                   label1.setText("Balance: ");
                   System.out.println("You pressed the button.");
               }
           });

        Scene root = new Scene(BorderPane,600,480);

        stage.setTitle("Ship");
        stage.setResizable(false);
        stage.setScene(root);
        stage.show();

    }
}
