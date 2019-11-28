package Main;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import java.net.URL;
import java.util.ResourceBundle;

public class mainController implements Initializable {
	public Button startButton;

	@Override
	public void initialize(URL url, ResourceBundle resourceBundle) {
		System.out.println("Loading..");
	}

	public void exitGame () {
		System.exit(0);
	}

	public void startNewGame (){
		try {
			Parent root = FXMLLoader.load(getClass().getResource("CreateNewProfile.fxml"));
			Stage primaryStage = (Stage) startButton.getScene().getWindow();
			primaryStage.setTitle("isPvZ : Login");
			primaryStage.setScene(new Scene(root, 1500, 800));
			primaryStage.show();
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}

	public void loadGame () {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("LoadGame.fxml"));
			Stage primaryStage = (Stage) startButton.getScene().getWindow();
			primaryStage.setTitle("isPvZ : Load Game");
			primaryStage.setScene(new Scene(root, 1500, 800));
			primaryStage.show();
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}

	public void chooseLevel () {
		// does nothing as of now
	}
}