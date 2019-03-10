
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class WarehouseGUI extends BorderPane {

    private final Text text;
    private final HBox hBox;
    private final Button button;
    private final Button button0;
    private final VBox vBox;
    private final Text text0;
    private final Text text1;
    private final Label label;
    private final Label label0;
    private final Label label1;
    private final Label label2;
    private final VBox vBox0;
    private final Text text2;
    private final Text text3;
    private final Text text4;
    private final Text text5;
    private final Text text6;
    private final Text text7;
    private final VBox vBox1;
    private final Text text8;
    private final Text text9;

    public WarehouseGUI() {

        text = new Text();
        hBox = new HBox();
        button = new Button();
        button0 = new Button();
        vBox = new VBox();
        text0 = new Text();
        text1 = new Text();
        label = new Label();
        label0 = new Label();
        label1 = new Label();
        label2 = new Label();
        vBox0 = new VBox();
        text2 = new Text();
        text3 = new Text();
        text4 = new Text();
        text5 = new Text();
        text6 = new Text();
        text7 = new Text();
        vBox1 = new VBox();
        text8 = new Text();
        text9 = new Text();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(480.0);
        setPrefWidth(600.0);

        BorderPane.setAlignment(text, javafx.geometry.Pos.CENTER);
        text.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text.setStrokeWidth(0.0);
        text.setText("Hong Kong Warehouse");
        text.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        text.setWrappingWidth(393.63671875);
        text.setFont(new Font(24.0));
        setTop(text);

        BorderPane.setAlignment(hBox, javafx.geometry.Pos.CENTER);
        hBox.setAlignment(javafx.geometry.Pos.CENTER);
        hBox.setPrefHeight(100.0);
        hBox.setPrefWidth(200.0);

        button.setContentDisplay(javafx.scene.control.ContentDisplay.CENTER);
        button.setMnemonicParsing(false);
        button.setPrefWidth(250.0);
        button.setText("Withdraw");

        button0.setMnemonicParsing(false);
        button0.setPrefWidth(250.0);
        button0.setText("Deposit");
        button0.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        setBottom(hBox);

        BorderPane.setAlignment(vBox, javafx.geometry.Pos.CENTER_LEFT);
        vBox.setMaxHeight(USE_PREF_SIZE);
        vBox.setMaxWidth(USE_PREF_SIZE);
        vBox.setMinHeight(USE_PREF_SIZE);
        vBox.setMinWidth(USE_PREF_SIZE);
        vBox.setPrefHeight(156.0);
        vBox.setPrefWidth(106.0);

        text0.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text0.setStrokeWidth(0.0);
        text0.setText("Player");
        text0.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        text0.setWrappingWidth(103.47265625);
        text0.setFont(new Font(18.0));

        text1.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text1.setStrokeWidth(0.0);
        text1.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        text1.setWrappingWidth(103.47265625);
        text1.setFont(new Font(18.0));

        label.setAlignment(javafx.geometry.Pos.CENTER);
        label.setContentDisplay(javafx.scene.control.ContentDisplay.CENTER);
        label.setPrefWidth(100.0);
        label.setText("Opium");
        label.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        label.setFont(new Font(18.0));

        label0.setAlignment(javafx.geometry.Pos.CENTER);
        label0.setPrefWidth(100.0);
        label0.setText("Silk");
        label0.setFont(new Font(18.0));

        label1.setAlignment(javafx.geometry.Pos.CENTER);
        label1.setPrefWidth(100.0);
        label1.setText("Arms");
        label1.setFont(new Font(18.0));

        label2.setAlignment(javafx.geometry.Pos.CENTER);
        label2.setPrefWidth(100.0);
        label2.setText("General");
        label2.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        label2.setFont(new Font(18.0));
        setLeft(vBox);

        BorderPane.setAlignment(vBox0, javafx.geometry.Pos.TOP_LEFT);
        vBox0.setAlignment(javafx.geometry.Pos.CENTER);
        vBox0.setMaxHeight(USE_PREF_SIZE);
        vBox0.setMaxWidth(USE_PREF_SIZE);
        vBox0.setMinHeight(USE_PREF_SIZE);
        vBox0.setMinWidth(USE_PREF_SIZE);
        vBox0.setPrefHeight(343.0);
        vBox0.setPrefWidth(261.0);

        text2.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text2.setStrokeWidth(0.0);
        text2.setText("Warehouse");
        text2.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        text2.setWrappingWidth(103.47265625);
        text2.setFont(new Font(18.0));

        text3.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text3.setStrokeWidth(0.0);
        text3.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        text3.setWrappingWidth(103.47265625);
        text3.setFont(new Font(18.0));

        text4.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text4.setStrokeWidth(0.0);
        text4.setText("Opium");
        text4.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        text4.setWrappingWidth(103.47265625);
        text4.setFont(new Font(18.0));

        text5.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text5.setStrokeWidth(0.0);
        text5.setText("Silk");
        text5.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        text5.setWrappingWidth(103.47265625);
        text5.setFont(new Font(18.0));

        text6.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text6.setStrokeWidth(0.0);
        text6.setText("Arms");
        text6.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        text6.setWrappingWidth(103.47265625);
        text6.setFont(new Font(18.0));

        text7.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text7.setStrokeWidth(0.0);
        text7.setText("General");
        text7.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        text7.setWrappingWidth(103.47265625);
        text7.setFont(new Font(18.0));
        setCenter(vBox0);

        BorderPane.setAlignment(vBox1, javafx.geometry.Pos.CENTER);
        vBox1.setMaxHeight(USE_PREF_SIZE);
        vBox1.setMaxWidth(USE_PREF_SIZE);
        vBox1.setPrefHeight(48.0);
        vBox1.setPrefWidth(152.0);

        text8.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text8.setStrokeWidth(0.0);
        text8.setText("In use:");
        text8.setFont(new Font(18.0));

        text9.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text9.setStrokeWidth(0.0);
        text9.setText("Vacant:");
        text9.setFont(new Font(18.0));
        setRight(vBox1);

        hBox.getChildren().add(button);
        hBox.getChildren().add(button0);
        vBox.getChildren().add(text0);
        vBox.getChildren().add(text1);
        vBox.getChildren().add(label);
        vBox.getChildren().add(label0);
        vBox.getChildren().add(label1);
        vBox.getChildren().add(label2);
        vBox0.getChildren().add(text2);
        vBox0.getChildren().add(text3);
        vBox0.getChildren().add(text4);
        vBox0.getChildren().add(text5);
        vBox0.getChildren().add(text6);
        vBox0.getChildren().add(text7);
        vBox1.getChildren().add(text8);
        vBox1.getChildren().add(text9);

    }
}
