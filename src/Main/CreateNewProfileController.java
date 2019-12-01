package Main;
import java.util.concurrent.TimeUnit;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class CreateNewProfileController {

	public Button goBackMainMenuButton;
	public TextField nameTextBox;
	public Button startButton;
	public Label userCreatedLabel;

	public void userCreation() throws InterruptedException {
		String name = nameTextBox.getText();
		nameTextBox.setText("");
		userCreatedLabel.setVisible(true);
		System.out.print("");
		//TimeUnit.SECONDS.sleep(2);
		try {
			Parent root = FXMLLoader.load(getClass().getResource("gamePreview.fxml"));
			Stage primaryStage = (Stage) goBackMainMenuButton.getScene().getWindow();
			primaryStage.setTitle("isPvZ : Main Menu");
			primaryStage.setScene(new Scene(root, 1500, 800));
			primaryStage.show();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void gobackMainMenu(){
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
