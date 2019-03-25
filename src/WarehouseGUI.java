import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class WarehouseGUI extends Player{

    private HBox hBox;
    private VBox vBox;
    private TextField textField;
    private RadioButton generalRadio;
    private ToggleGroup Goods;
    private RadioButton armsRadio;
    private RadioButton silkRadio;
    private RadioButton opiumRadio;
    private Button withdrawButton;
    private Button depositButton;
    private Button quitButton;
    private Label title;
    private HBox hBox0;
    private VBox vBox0;
    private Label playerLabel;
    private Label playerGeneral;
    private Label playerArms;
    private Label playerSilk;
    private Label playerOpium;
    private VBox vBox1;
    private Label houseLabel;
    private Label houseGeneral;
    private Label houseArms;
    private Label houseSilk;
    private Label houseOpium;
    private BorderPane borderPane;

    public WarehouseGUI(Player player) {
        Player playerDummy = new Player(player);
        setPlayer(playerDummy);
    }

    public Stage initializeWarehouse(Stage stage){

        hBox = new HBox();
        vBox = new VBox();
        generalRadio = new RadioButton();
        Goods = new ToggleGroup();
        armsRadio = new RadioButton();
        silkRadio = new RadioButton();
        opiumRadio = new RadioButton();
        withdrawButton = new Button();
        depositButton = new Button();
        quitButton = new Button();
        title = new Label();
        hBox0 = new HBox();
        vBox0 = new VBox();
        playerLabel = new Label();
        playerGeneral = new Label();
        playerArms = new Label();
        playerSilk = new Label();
        playerOpium = new Label();
        vBox1 = new VBox();
        houseLabel = new Label();
        houseGeneral = new Label();
        houseArms = new Label();
        houseSilk = new Label();
        houseOpium = new Label();
        borderPane = new BorderPane();
        textField = new TextField();

        borderPane.setAlignment(hBox, javafx.geometry.Pos.CENTER);
        hBox.setAlignment(javafx.geometry.Pos.CENTER);
        hBox.setPrefHeight(100.0);
        hBox.setPrefWidth(200.0);
        hBox.setSpacing(10.0);

        vBox.setAlignment(javafx.geometry.Pos.CENTER_LEFT);
        vBox.setPrefHeight(200.0);
        vBox.setPrefWidth(100.0);

        generalRadio.setMnemonicParsing(false);
        generalRadio.setSelected(true);
        generalRadio.setText("General");

        generalRadio.setToggleGroup(Goods);

        armsRadio.setMnemonicParsing(false);
        armsRadio.setText("Arms");
        armsRadio.setToggleGroup(Goods);

        silkRadio.setMnemonicParsing(false);
        silkRadio.setText("Silk");
        silkRadio.setToggleGroup(Goods);

        opiumRadio.setMnemonicParsing(false);
        opiumRadio.setText("Opium");
        opiumRadio.setToggleGroup(Goods);

        withdrawButton.setMnemonicParsing(false);
        withdrawButton.setText("Withdraw");

        depositButton.setMnemonicParsing(false);
        depositButton.setText("Deposit");

        quitButton.setMnemonicParsing(false);
        quitButton.setText("Go back");
        borderPane.setBottom(hBox);

        borderPane.setAlignment(title, javafx.geometry.Pos.CENTER);
        title.setText("Hong Kong Warehouse");
        title.setFont(new Font(24.0));
        title.setPadding(new Insets(10.0, 0.0, 0.0, 0.0));
        borderPane.setTop(title);

        borderPane.setAlignment(hBox0, javafx.geometry.Pos.CENTER);
        hBox0.setAlignment(javafx.geometry.Pos.CENTER);
        hBox0.setPrefHeight(100.0);
        hBox0.setPrefWidth(200.0);
        hBox0.setSpacing(10.0);

        vBox0.setAlignment(javafx.geometry.Pos.CENTER_LEFT);
        vBox0.setSpacing(10.0);

        playerLabel.setText("Player:");
        playerLabel.setFont(new Font(18.0));

        playerGeneral.setText("General:");

        playerArms.setText("Arms:");

        playerSilk.setText("Silk:");

        playerOpium.setText("Opium:");

        vBox1.setAlignment(javafx.geometry.Pos.CENTER_LEFT);
        vBox1.setSpacing(10.0);

        houseLabel.setAlignment(javafx.geometry.Pos.TOP_CENTER);
        houseLabel.setText("Warehouse:");
        houseLabel.setFont(new Font(18.0));

        houseGeneral.setText("General:");

        houseArms.setText("Arms:");

        houseSilk.setText("Silk:");

        houseOpium.setText("Opium:");
        borderPane.setMargin(hBox0, new Insets(0.0));
        hBox0.setPadding(new Insets(10.0, 0.0, 0.0, 0.0));
        vBox0.setPadding(new Insets(0, 0.0, 0.0, 0.0));
        borderPane.setCenter(hBox0);

        vBox.getChildren().add(generalRadio);
        vBox.getChildren().add(armsRadio);
        vBox.getChildren().add(silkRadio);
        vBox.getChildren().add(opiumRadio);

        hBox.getChildren().add(vBox);
        hBox.getChildren().add(textField);
        hBox.getChildren().add(withdrawButton);
        hBox.getChildren().add(depositButton);
        hBox.getChildren().add(quitButton);

        vBox0.getChildren().add(playerLabel);
        vBox0.getChildren().add(playerGeneral);
        vBox0.getChildren().add(playerArms);
        vBox0.getChildren().add(playerSilk);
        vBox0.getChildren().add(playerOpium);

        vBox1.getChildren().add(houseLabel);
        vBox1.getChildren().add(houseGeneral);
        vBox1.getChildren().add(houseArms);
        vBox1.getChildren().add(houseSilk);
        vBox1.getChildren().add(houseOpium);

        hBox0.getChildren().add(vBox0);
        hBox0.getChildren().add(vBox1);

        updateLabels();

        //Goes back to shop
        quitButton.setOnAction(event -> {
            TaipanShopGUI taipanShopGUI = new TaipanShopGUI(getPlayer());
            taipanShopGUI.initializeShop(stage);
            stage.show();
        });

        withdrawButton.setOnAction(event -> {
            try {
                int playerInventory = getPlayer().getCargoSpace()-((getPlayer().getGuns()*10)+ getPlayer().getGeneralHeld() + getPlayer().getArmsHeld() + getPlayer().getSilkHeld() + getPlayer().getOpiumHeld());
                int houseInventory = (10000 -(getPlayer().getwGeneral() + getPlayer().getwArms() + getPlayer().getwSilk() + getPlayer().getwOpium()));
                int withdraw = Integer.parseInt(textField.getText());
                if(withdraw <= 0 && (houseInventory-withdraw) <= 0 && (playerInventory+withdraw) >= getCargoSpace()){
                    title.setText("Please enter a valid value");
                }
                else if(Goods.getSelectedToggle() == generalRadio){
                    setGeneralHeld(getPlayer().getGeneralHeld()+withdraw);
                    setwGeneral(getPlayer().getGeneralHeld()-withdraw);
                }
                else if(Goods.getSelectedToggle() == armsRadio){
                    setArmsHeld(getPlayer().getArmsHeld()+withdraw);
                    setwArms(getPlayer().getArmsHeld()-withdraw);
                }
                else if(Goods.getSelectedToggle() == silkRadio){
                    setSilkHeld(getPlayer().getSilkHeld()+withdraw);
                    setwSilk(getPlayer().getSilkHeld()-withdraw);
                }
                else if(Goods.getSelectedToggle() == opiumRadio){
                    setOpiumHeld(getPlayer().getOpiumHeld()+withdraw);
                    setwOpium(getPlayer().getOpiumHeld()-withdraw);
                }
                else{
                    title.setText("Please enter a valid value");
                }
                updateLabels();
            }
            catch (Exception e) {
                title.setText("Please enter a valid value");
            }
        });

        depositButton.setOnAction(event -> {
            try {
                int playerInventory = getPlayer().getCargoSpace()-((getPlayer().getGuns()*10)+ getPlayer().getGeneralHeld() + getPlayer().getArmsHeld() + getPlayer().getSilkHeld() + getPlayer().getOpiumHeld());
                int houseInventory = (10000 -(getPlayer().getwGeneral() + getPlayer().getwArms() + getPlayer().getwSilk() + getPlayer().getwOpium()));
                int deposit = Integer.parseInt(textField.getText());
                if(deposit <= 0 && (houseInventory-deposit) <= 0 && (playerInventory+deposit) >= getCargoSpace()){
                    title.setText("Please enter a valid value");
                }
                else if(Goods.getSelectedToggle() == generalRadio){
                    setGeneralHeld(getPlayer().getGeneralHeld()-deposit);
                    setwGeneral(getPlayer().getGeneralHeld()+deposit);
                }
                else if(Goods.getSelectedToggle() == armsRadio){
                    setArmsHeld(getPlayer().getArmsHeld()-deposit);
                    setwArms(getPlayer().getArmsHeld()+deposit);
                }
                else if(Goods.getSelectedToggle() == silkRadio){
                    setSilkHeld(getPlayer().getSilkHeld()-deposit);
                    setwSilk(getPlayer().getSilkHeld()+deposit);
                }
                else if(Goods.getSelectedToggle() == opiumRadio){
                    setOpiumHeld(getPlayer().getOpiumHeld()-deposit);
                    setwOpium(getPlayer().getOpiumHeld()+deposit);
                }
                else{
                    title.setText("Please enter a valid value");
                }
                updateLabels();
            }
            catch (Exception e) {
                title.setText("Please enter a valid value");
            }
        });



        Scene root = new Scene(borderPane, 600, 480);
        root.getStylesheets().add("styleguide.css");

        stage.setTitle("Warehouse");
        stage.setResizable(false);
        stage.setScene(root);
        return stage;
    }

    public void updateLabels(){
        playerLabel.setText("Player: " + (getPlayer().getCargoSpace()-((getPlayer().getGuns()*10)+ getPlayer().getGeneralHeld() + getPlayer().getArmsHeld() + getPlayer().getSilkHeld() + getPlayer().getOpiumHeld())));
        houseLabel.setText("Warehouse: " + (10000 -(getPlayer().getwGeneral() + getPlayer().getwArms() + getPlayer().getwSilk() + getPlayer().getwOpium())));

        playerGeneral.setText("General: " + getPlayer().getGeneralHeld());
        playerArms.setText("Arms: " + getPlayer().getArmsHeld());
        playerSilk.setText("Silk: " + getPlayer().getSilkHeld() );
        playerOpium.setText("Opium: " + getPlayer().getOpiumHeld());

        houseGeneral.setText("General: " + getPlayer().getwGeneral());
        houseArms.setText("Arms: " + getPlayer().getwArms());
        houseSilk.setText("Silk: " + getPlayer().getwSilk());
        houseOpium.setText("Opium: " + getPlayer().getwOpium());
    }
}
