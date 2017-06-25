package ordernow;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class OrderNow extends Application {

	private int width = 900;
	private int height = 500;

	@Override
	public void start(Stage primaryStage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("./view/MainPane.fxml"));
		primaryStage.setTitle("Order Now");
		primaryStage.setScene(new Scene(root));
		primaryStage.setWidth(width);
		primaryStage.setHeight(height);
		primaryStage.setMinWidth(width);
		primaryStage.setMinHeight(height);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
