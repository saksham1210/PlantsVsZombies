package Main;

import javafx.animation.TranslateTransition;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelReader;
import javafx.scene.input.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.awt.image.BufferedImage;
import java.util.stream.IntStream;

public class gamePreviewController {
	public Button pauseButton;
	public ImageView peashooter;
	public ImageView sunflower;
	public ImageView cherrybomb;
	public ImageView threepeater;
	public ImageView landmine;
	public ImageView shoot;
	public ImageView pea;
	public ImageView lawnmower1;
	public ImageView lawnmower2;
	public ImageView lawnmower3;
	public ImageView lawnmower4;
	public ImageView lawnmower5;
	public ImageView zombie1;
	public GridPane gridPane_;
	public Image img;

//	public double computeSnapshotSimilarity(Image image1, Image image2) {
//		int width = (int) image1.getWidth();
//		int height = (int) image1.getHeight();
//		PixelReader reader1 = image1.getPixelReader();
//		PixelReader reader2 = image2.getPixelReader();
//		double nbNonSimilarPixels = IntStream.range(0, width).parallel()
//									.mapToLong(i -> IntStream.range(0, height).parallel().filter(j -> reader1.getArgb(i, j) != reader2.getArgb(i, j)).count()).sum();
//		System.out.println("Im here!!!");
//		return 100d - nbNonSimilarPixels / (width * height) * 100d;
//	}

	public void pauseGame() {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("GamePauseMenu.fxml"));
			Stage primaryStage = (Stage) pauseButton.getScene().getWindow();
			primaryStage.setTitle("isPvZ : Game Paused");
			primaryStage.setScene(new Scene(root, 1500, 800));
			primaryStage.show();
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	public void handleDragDetect(MouseEvent event)
	{
		if (event.getSource()==peashooter)
		{
			Dragboard db= peashooter.startDragAndDrop(TransferMode.ANY);
			img = new Image(".\\Main\\PvZpics\\plant_peashooter_thumb.png");
			ClipboardContent cb =new ClipboardContent();
			cb.putImage(img);
			db.setContent(cb);
		}
		if (event.getSource()==sunflower)
		{
			Dragboard db= sunflower.startDragAndDrop(TransferMode.ANY);
			img = new Image(".\\Main\\PvZpics\\Sunflower2009HD.png");
			ClipboardContent cb =new ClipboardContent();
			cb.putImage(img);
			db.setContent(cb);
		}
		if (event.getSource()==landmine)
		{
			Dragboard db= landmine.startDragAndDrop(TransferMode.ANY);
			img = new Image(".\\Main\\PvZpics\\PotatoMineHD.png");
			ClipboardContent cb =new ClipboardContent();
			cb.putImage(img);
			db.setContent(cb);
		}
		if (event.getSource()==threepeater)
		{
			Dragboard db= threepeater.startDragAndDrop(TransferMode.ANY);
			img = new Image(".\\Main\\PvZpics\\Threepeater2009HD.png");
			ClipboardContent cb =new ClipboardContent();
			cb.putImage(img);
			db.setContent(cb);
		}
		if (event.getSource()==cherrybomb)
		{
			Dragboard db= cherrybomb.startDragAndDrop(TransferMode.ANY);
			img = new Image(".\\Main\\PvZpics\\Cherrybomb.png");
			ClipboardContent cb =new ClipboardContent();
			cb.putImage(img);
			db.setContent(cb);
		}
		event.consume();
	}
	public void handleDragOver(DragEvent event)
	{
		if (event.getDragboard().hasImage())
		{
			event.acceptTransferModes(TransferMode.ANY);
		}
	}

	public void handleDragDropped(DragEvent event)
	{
		Image clipboard_img= (Image) event.getDragboard().getContent(DataFormat.IMAGE);
//		Image peashooter_img=new Image("file:C:/Users/Saksham Dhull/Desktop/PlantVSZombies/src/Main/PvZpics/1769829-plant_peashooter_thumb.png");
//		Image sunflower_img=new Image("file:C:/Users/Saksham Dhull/Desktop/PlantVSZombies/src/Main/PvZpics/Sunflower2009HD.png");
//		Image cherrybomb_img= new Image("file:C:/Users/Saksham Dhull/Desktop/PlantVSZombies/src/Main/PvZpics/Cherrybomb.png");
//		Image threepeater_img=new Image("file:C:/Users/Saksham Dhull/Desktop/PlantVSZombies/src/Main/PvZpics/Threepeater2009HD.png");
//		Image landmine_img=new Image("file:C:/Users/Saksham Dhull/Desktop/PlantVSZombies/src/Main/PvZpics/PotatoMineHD.png");
//		if (computeSnapshotSimilarity(clipboard_img,peashooter_img)>95)
//		{
//			Image image=new Image("file:C:/Users/Saksham Dhull/Desktop/PlantVSZombies/src/Main/PvZpics/Peashooter_transparent_gif.gif");
//			ImageView imgview = new ImageView(image);
//			Node node= event.getPickResult().getIntersectedNode();
//			Integer index_x=GridPane.getColumnIndex(node);
//			Integer index_y=GridPane.getRowIndex(node);
//			System.out.print(index_x + " ");
//			System.out.println(index_y) ;
//			gridPane_.add(imgview,index_x,index_y);
//		}
//		else if (computeSnapshotSimilarity(clipboard_img,sunflower_img)>95)
//		{
//			System.out.println("Im here!!!");
//			Image image1=new Image("file:C:/Users/Saksham Dhull/Desktop/PlantVSZombies/src/Main/PvZpics/5dbd90c75276b768463076.gif");
//			ImageView imgview1 = new ImageView(image1);
//			Node node= event.getPickResult().getIntersectedNode();
//			Integer index_x=GridPane.getColumnIndex(node);
//			Integer index_y=GridPane.getRowIndex(node);
//			System.out.print(index_x + " ");
//			System.out.println(index_y) ;
//			gridPane_.add(imgview1,index_x,index_y);
//		}
//		else if (computeSnapshotSimilarity(clipboard_img,landmine_img)>95)
//		{
//			Image image2=new Image("file:C:/Users/Saksham Dhull/Desktop/PlantVSZombies/src/Main/PvZpics/5dbd919ed7c8e419512925.gif");
//			ImageView imgview2 = new ImageView(image2);
//			Node node= event.getPickResult().getIntersectedNode();
//			Integer index_x=GridPane.getColumnIndex(node);
//			Integer index_y=GridPane.getRowIndex(node);
//			System.out.print(index_x + " ");
//			System.out.println(index_y) ;
//			gridPane_.add(imgview2,index_x,index_y);
//		}
//		else if (computeSnapshotSimilarity(clipboard_img,threepeater_img)>95)
//		{
//			Image image3=new Image("file:C:/Users/Saksham Dhull/Desktop/PlantVSZombies/src/Main/PvZpics/Threepeater2009HD.png");
//			ImageView imgview3 = new ImageView(image3);
//			Node node= event.getPickResult().getIntersectedNode();
//			Integer index_x=GridPane.getColumnIndex(node);
//			Integer index_y=GridPane.getRowIndex(node);
//			System.out.print(index_x + " ");
//			System.out.println(index_y) ;
//			gridPane_.add(imgview3,index_x,index_y);
//		}
//		else if (computeSnapshotSimilarity(clipboard_img,cherrybomb_img)>95)
//		{
//			Image image4=new Image("file:C:/Users/Saksham Dhull/Desktop/PlantVSZombies/src/Main/PvZpics/Cherrybomb.png");
			ImageView imgview = new ImageView(clipboard_img);
			imgview.setOnMouseClicked(e -> shootPea(e));
			Node node= event.getPickResult().getIntersectedNode();
			Integer index_x=GridPane.getColumnIndex(node);
			Integer index_y=GridPane.getRowIndex(node);
			System.out.print(index_x + " ");
			System.out.println(index_y) ;
			gridPane_.add(imgview,index_x,index_y);
//		}

	}
	public void handleDragDone() {	}
	public void moveZombie()
    {
		TranslateTransition transition = new TranslateTransition();
		transition.setDuration(Duration.seconds(50));
		transition.setNode(zombie1);
		transition.setToX(-950);
		transition.play();
		transition.setOnFinished((e)->{
			zombie1.setVisible(false);
		});
    }
    public void moveLawnMower(MouseEvent event)
    {

        TranslateTransition transition = new TranslateTransition();
        transition.setDuration(Duration.seconds(3.5));
        if (event.getSource()==lawnmower1)
		{
			transition.setNode(lawnmower1);
			transition.setToX(+750);
			transition.play();
			transition.setOnFinished((e)->{
				lawnmower1.setVisible(false);
			});
		}
		if (event.getSource()==lawnmower2)
		{
			transition.setNode(lawnmower2);
			transition.setToX(+750);
			transition.play();
			transition.setOnFinished((e)->{
				lawnmower2.setVisible(false);
			});
		}
		if (event.getSource()==lawnmower3)
		{
			transition.setNode(lawnmower3);
			transition.setToX(+750);
			transition.play();
			transition.setOnFinished((e)->{
				lawnmower3.setVisible(false);
			});
		}
		if (event.getSource()==lawnmower4)
		{
			transition.setNode(lawnmower4);
			transition.setToX(+750);
			transition.play();
			transition.setOnFinished((e)->{
				lawnmower4.setVisible(false);
			});
		}
		if (event.getSource()==lawnmower5)
		{
			transition.setNode(lawnmower5);
			transition.setToX(+750);
			transition.play();
			transition.setOnFinished((e)->{
				lawnmower5.setVisible(false);
			});
		}
    }
    public void shootPea(MouseEvent event)
	{
		pea=new ImageView();
		pea.setImage(new Image(".\\Main\\PvZpics\\Pea_1.png"));
		Node node= event.getPickResult().getIntersectedNode();
		Integer index_x=GridPane.getColumnIndex(node);
		Integer index_y=GridPane.getRowIndex(node);
		gridPane_.add(pea,index_x,index_y);
		TranslateTransition transition = new TranslateTransition();
		transition.setDuration(Duration.seconds(2));
		transition.setNode(pea);
		pea.setVisible(true);
		transition.setToX(+700);
		transition.play();
		transition.setOnFinished((e)->{
			pea.setVisible(false);
		});
	}
}
