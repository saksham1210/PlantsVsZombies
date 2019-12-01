package Main;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class chooseLevelController {
        public Button level1;
        public Button level2;
        public Button level3;
        public Button level4;
        public Button level5;
        public Button goBackButton;
        public void startLevel1 () {
            try {
                Parent root = FXMLLoader.load(getClass().getResource("gamePreview.fxml"));
                Stage primaryStage = (Stage) level1.getScene().getWindow();
                primaryStage.setTitle("isPvZ : Level 1");
                primaryStage.setScene(new Scene(root, 1500, 800));
                primaryStage.show();
            }
            catch(Exception e){
                System.out.println(e.getMessage());
            }
        }

        public void startLevel2 () {
            try {
                Parent root = FXMLLoader.load(getClass().getResource("gamePreview1.fxml"));
                Stage primaryStage = (Stage) level1.getScene().getWindow();
                primaryStage.setTitle("isPvZ : Level 2");
                primaryStage.setScene(new Scene(root, 1500, 800));
                primaryStage.show();
            }
            catch(Exception e){
                System.out.println(e.getMessage());
            }

        }

        public void startLevel3 () {
            try {
                Parent root = FXMLLoader.load(getClass().getResource("gamePreview2.fxml"));
                Stage primaryStage = (Stage) level1.getScene().getWindow();
                primaryStage.setTitle("isPvZ : Level 3");
                primaryStage.setScene(new Scene(root, 1500, 800));
                primaryStage.show();
            }
            catch(Exception e){
                System.out.println(e.getMessage());
            }

        }

        public void startLevel4 () {
            try {
                Parent root = FXMLLoader.load(getClass().getResource("gamePreview2.fxml"));
                Stage primaryStage = (Stage) level1.getScene().getWindow();
                primaryStage.setTitle("isPvZ : Level 4");
                primaryStage.setScene(new Scene(root, 1500, 800));
                primaryStage.show();
            }
            catch(Exception e){
                System.out.println(e.getMessage());
            }
        }

        public void startLevel5 () {
            try {
                Parent root = FXMLLoader.load(getClass().getResource("gamePreview2.fxml"));
                Stage primaryStage = (Stage) level1.getScene().getWindow();
                primaryStage.setTitle("isPvZ : Level 5");
                primaryStage.setScene(new Scene(root, 1500, 800));
                primaryStage.show();
            }
            catch(Exception e){
                System.out.println(e.getMessage());
            }

        }
        public void goBack () {
            try {
                Parent root = FXMLLoader.load(getClass().getResource("main.fxml"));
                Stage primaryStage = (Stage) goBackButton.getScene().getWindow();
                primaryStage.setTitle("isPvZ : Main Menu");
                primaryStage.setScene(new Scene(root, 1500, 800));
                primaryStage.show();
            }
            catch(Exception e){
                System.out.println(e.getMessage());
            }
        }
}
