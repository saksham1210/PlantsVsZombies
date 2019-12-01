package Main;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class GamePauseMenuController {
	public Button resumeButton;
	public Button saveButton;
	public Button exitButton;

	public void saveGame () {

	}

	public void exitToMainMenu() {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("main.fxml"));
			Stage primaryStage = (Stage) exitButton.getScene().getWindow();
			primaryStage.setTitle("isPvZ : Main Menu");
			primaryStage.setScene(new Scene(root, 1500, 800));
			primaryStage.show();
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}

	public void resumeGame () {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("gamePreview.fxml"));
			Stage primaryStage = (Stage) exitButton.getScene().getWindow();
			primaryStage.setTitle("isPvZ : Level 1");
			primaryStage.setScene(new Scene(root, 1500, 800));
			primaryStage.show();
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
}
