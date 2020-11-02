package application;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;

//Main Method loads the Mancala board to start off the program.

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception {
		Parent root = FXMLLoader.load(Main.class.getResource("/application/boardFX.fxml"));
		primaryStage.setTitle("Mancala");
		primaryStage.setScene(new Scene(root, 1000, 580));
		primaryStage.show();
	}
	//hello
	public static void main(String[] args) {
		launch(args);
	}
}
