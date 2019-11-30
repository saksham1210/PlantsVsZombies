package Main;

import javafx.animation.Animation;
import javafx.animation.AnimationTimer;
import javafx.animation.TranslateTransition;
import javafx.beans.value.ChangeListener;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.beans.EventHandler;
import java.util.ArrayList;
import java.util.Random;

public class gamePreviewController {
	public Button pauseButton;
	public ImageView peashooter;
	public ImageView sunflower;
	public ImageView cherrybomb;
	public ImageView threepeater;
	public ImageView landmine;
	public ImageView pea;
	public ImageView lawnmower1;
	public ImageView lawnmower2;
	public ImageView lawnmower3;
	public ImageView lawnmower4;
	public ImageView lawnmower5;
	//public ImageView zombie1;
	public GridPane gridPane_;
	public Image img;
	public ArrayList<ImageView> Zombies;
	public ArrayList<ImageView> Plants;
	public gamePreviewController()
	{
		Plants=new ArrayList<ImageView>();
		Zombies=new ArrayList<ImageView>();
		//spawn_Zombie();
	}


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
		Node node= event.getPickResult().getIntersectedNode();
		ImageView img_v=new ImageView(clipboard_img);
//		ImageView img_v=(ImageView) node;
//		if (img_v.getImage()==null)
//		{
//			img_v.setImage(clipboard_img);
//		}
		Integer index_x=GridPane.getColumnIndex(node);
		Integer index_y=GridPane.getRowIndex(node);
		System.out.print(index_x + " ");
		System.out.println(index_y) ;
		gridPane_.add(img_v,index_x,index_y);
		if (clipboard_img.getHeight()==81.0) //PEASHOOTER
		{
			System.out.println("Im Peashooter");
			this.Plants.add(img_v);
//			System.out.println(Plants.size());
			shootPea(img_v);
			//img_v.setOnMouseClicked(this::shootPea);

		}
		else if (clipboard_img.getHeight()==85.0) //SUNFLOWER
		{
			System.out.println("Im Sunflower");
		}
		else if (clipboard_img.getHeight()==110.0) //THREEPEATER
		{
			System.out.println("Im Threepeater");
		}
		else if (clipboard_img.getHeight()==97.0) //CHERRYBOMB
		{
			System.out.println("Im Cherrybomb");
		}
		else if (clipboard_img.getHeight()==66.0) //LANDMINE
		{
			System.out.println("Im Landmine");
		}

	}
	public void spawn_Zombie()
	{
		ImageView zombie=new ImageView(new Image(".\\Main\\PvZpics\\Conehead_Zombie.gif"));
		Random random=new Random();
		int index_y=random.nextInt(5);
		gridPane_.add(zombie,9,index_y);
		Zombies.add(zombie);
		moveZombie(zombie);
	}

	public void moveZombie(ImageView img)
    {
		TranslateTransition transition = new TranslateTransition();
		transition.setDuration(Duration.seconds(50));
		transition.setNode(img);
		transition.setToX(-950);
		transition.play();
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
			transition.setOnFinished((e)->
				lawnmower1.setVisible(false));
		}
		if (event.getSource()==lawnmower2)
		{
			transition.setNode(lawnmower2);
			transition.setToX(+750);
			transition.play();
			transition.setOnFinished((e)-> lawnmower2.setVisible(false));
		}
		if (event.getSource()==lawnmower3)
		{
			transition.setNode(lawnmower3);
			transition.setToX(+750);
			transition.play();
			transition.setOnFinished((e)-> lawnmower3.setVisible(false));
		}
		if (event.getSource()==lawnmower4)
		{
			transition.setNode(lawnmower4);
			transition.setToX(+750);
			transition.play();
			transition.setOnFinished((e)-> lawnmower4.setVisible(false));
		}
		if (event.getSource()==lawnmower5)
		{
			transition.setNode(lawnmower5);
			transition.setToX(+750);
			transition.play();
			transition.setOnFinished((e)-> lawnmower5.setVisible(false));
		}
    }
    public void shootPea(ImageView img)
	{
		System.out.println("Trying to shoot");
		pea = new ImageView();
		ChangeListener<Number> checkIntersection = (ob, n, n1)->{
			for (int i=0;i<Zombies.size();i++)
			{
				ImageView target=Zombies.get(i);
				if (pea.getBoundsInParent().intersects(target.getBoundsInParent())){
					System.out.println("Intersection detected");
					pea.setVisible(false);
				}
			}
		};
		pea.translateXProperty().addListener(checkIntersection);
		pea.setImage(new Image(".\\Main\\PvZpics\\Pea_1.png"));
		Integer index_x=GridPane.getColumnIndex(img);
		Integer index_y=GridPane.getRowIndex(img);
		gridPane_.add(pea,index_x,index_y);
		TranslateTransition transition = new TranslateTransition();
		transition.setDuration(Duration.seconds(3));
		transition.setNode(pea);
		pea.setVisible(true);
		transition.setToX(+700);
		transition.setCycleCount(-1);
		transition.play();
		transition.setOnFinished((e)-> pea.setVisible(false));
	}
	public void collectSun(MouseEvent event)
	{

	}
}
