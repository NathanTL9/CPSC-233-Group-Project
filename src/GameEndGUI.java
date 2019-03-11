
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class GameEndGUI {

    private Label title;
    private VBox vBox;
    private Label firmName;
    private Label gunsHeld;
    private Label netWorth;
    private BorderPane borderPane;
    private Player player;

    public GameEndGUI(Player player) {
        Player playerDummy = new Player(player);
        this.player = playerDummy;
    }

    public void setPlayer(Player player) {
        Player playerDummy = new Player(player);
        this.player = playerDummy;
    }

    public Player getPlayer(){
        Player playerDummy = new Player(player);
        return playerDummy;
    }


    public Stage initializeGameEndGUI(Stage stage){

        title = new Label();
        vBox = new VBox();
        firmName = new Label();
        gunsHeld = new Label();
        netWorth = new Label();
        borderPane = new BorderPane();
        int netWorthInt = 0;

        borderPane.setPrefHeight(480.0);
        borderPane.setPrefWidth(600.0);

        BorderPane.setAlignment(title, javafx.geometry.Pos.CENTER);
        title.setText("Game Over!");
        title.setFont(new Font(43.0));
        BorderPane.setMargin(title, new Insets(0.0));
        title.setPadding(new Insets(50.0, 0.0, 0.0, 0.0));
        borderPane.setTop(title);

        BorderPane.setAlignment(vBox, javafx.geometry.Pos.CENTER);
        vBox.setAlignment(javafx.geometry.Pos.CENTER);
        vBox.setPrefHeight(200.0);
        vBox.setPrefWidth(100.0);

        firmName.setText("Name:");
        firmName.setFont(new Font(22.0));

        gunsHeld.setText("Guns Held:");
        gunsHeld.setFont(new Font(22.0));

        netWorth.setText("Net Worth:");
        netWorth.setFont(new Font(22.0));
        borderPane.setCenter(vBox);


        vBox.getChildren().add(firmName);
        vBox.getChildren().add(gunsHeld);
        vBox.getChildren().add(netWorth);

        if(player.getHP() <= 0){
            title.setText("Game Over!");
        }
        else{
            title.setText("Congratulations!");
        }

        netWorthInt = player.getMoney() + (player.getOpiumHeld()*16000) + (player.getSilkHeld()*160) + (player.getArmsHeld()*160) + (player.getGeneralHeld()* 8);
        netWorthInt += (player.getwOpium()*16000) + (player.getwSilk()*160) + (player.getwArms()*160) + (player.getwGeneral()* 8);
        netWorthInt -= player.getDebt();

        firmName.setText("Firm Name: " + player.getName());
        gunsHeld.setText("Guns Held: " + player.getGuns());
        netWorth.setText("Net Worth: " + netWorthInt);

        Scene root = new Scene(borderPane, 600, 480);

        stage.setTitle("End Game Stats");
        stage.setResizable(false);
        stage.setScene(root);

        return stage;
    }


    public void start(Stage primaryStage) {
        GameEndGUI gameEndGUI = new GameEndGUI(player);
        gameEndGUI.initializeGameEndGUI(primaryStage);
        primaryStage.show();
    }
}
