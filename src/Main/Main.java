package Main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    private Stage primaryStage;

    @Override
    public void start(Stage primaryStage) throws Exception{
        try {
            this.primaryStage = primaryStage;
            Parent root = FXMLLoader.load(getClass().getResource("main.fxml"));
            primaryStage.setTitle("isPvZ : Main Menu");
            primaryStage.setScene(new Scene(root, 1500, 800));
            primaryStage.show();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public static void main(String[] args) {
        launch(args);
    }
    {}

}
