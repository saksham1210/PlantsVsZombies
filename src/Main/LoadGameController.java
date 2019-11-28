package Main;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoadGameController {

	public Button goBackMainMenuButton;
	public TextField nameTextBox;
	public Button loadButton;

	public void loginCheck() {
		String name = nameTextBox.getText();
		nameTextBox.setText("");
	}

	public void gobackMainMenu() {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("main.fxml"));
			Stage primaryStage = (Stage) goBackMainMenuButton.getScene().getWindow();
			primaryStage.setTitle("isPvZ : Main Menu");
			primaryStage.setScene(new Scene(root, 1500, 800));
			primaryStage.show();
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}


}
