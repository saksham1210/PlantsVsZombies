package Main;

import javafx.animation.*;
import javafx.beans.value.ChangeListener;
import javafx.fxml.FXML;
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
import java.util.ArrayList;
import java.util.Random;

public class gamePreviewController {
	public Button pauseButton;
	public ImageView peashooter;
	public ImageView sunflower;
	public ImageView cherrybomb;
	public ImageView threepeater;
	public ImageView landmine;
	public ImageView lawnmower1;
	public ImageView lawnmower2;
	public ImageView lawnmower3;
	public ImageView lawnmower4;
	public ImageView lawnmower5;
	public GridPane gridPane_;
	public Image img;
	public ArrayList<ImageView> Zombies;
	public ArrayList<ImageView> Plants;
	public ArrayList<ImageView> Suns;
	public double lastNanoTime;
	public gamePreviewController()
	{
		Plants=new ArrayList<ImageView>();
		Zombies=new ArrayList<ImageView>();
		lastNanoTime=System.nanoTime();
	}
	@FXML
	public void initialize()
	{
		AnimationTimer timer = new AnimationTimer() {
			@Override
			public void handle(long now) {
				double time = (now - lastNanoTime)/1000000000;
				if(time >= 5.0) {
					if (Zombies.size()==7)
					{
						stop();
					}
					lastNanoTime = now;
					spawn_Zombie();
					spawn_Sun();
				}
			}
		};
		timer.start();
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
		Integer index_x=GridPane.getColumnIndex(node);
		Integer index_y=GridPane.getRowIndex(node);
		System.out.print(index_x + " ");
		System.out.println(index_y) ;
		gridPane_.add(img_v,index_x,index_y);
		if (clipboard_img.getHeight()==81.0) //PEASHOOTER
		{
			System.out.println("Im Peashooter");
			this.Plants.add(img_v);
			for (ImageView ignored : Plants) {
				shootPea(img_v);
			}
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
		zombie.setVisible(true);
		Zombies.add(zombie);
		moveZombie(zombie);
	}
	public void spawn_Sun()
	{
		ImageView sun=new ImageView(new Image(".\\Main\\PvZpics\\Sun_PvZ2.png"));
		Random random=new Random();
		int index_x=random.nextInt(5);
		gridPane_.add(sun,index_x,0);
		Suns.add(sun);
		moveSun(sun);
	}
	public void moveSun(ImageView img)
	{
//		ChangeListener<Number> checkIntersection = (ob, n, n1)->{
//				if (img.getBoundsInParent().intersects(pea.getBoundsInParent())){
//					System.out.println("Intersection detected Zombie");
//					//transition.stop();
//				}
//		};
		img.setVisible(true);
		//img.translateXProperty().addListener(checkIntersection);
		AnimationTimer timer = new AnimationTimer() {
			@Override
			public void handle(long now) {
				if (img.getY()<(-750))
				{
					img.setVisible(false);
				}
				System.out.println(img.getY());
				img.translateYProperty().setValue(img.getY());
				img.setX(img.getY() - 0.15);
			}
		};
		timer.start();
//		TranslateTransition transition = new TranslateTransition();
//		transition.setDuration(Duration.seconds(50));
//		transition.setNode(img);
//		transition.setToX(-950);
//		transition.play();
	}

	public void moveZombie(ImageView img)
    {
//		ChangeListener<Number> checkIntersection = (ob, n, n1)->{
//				if (img.getBoundsInParent().intersects(pea.getBoundsInParent())){
//					System.out.println("Intersection detected Zombie");
//					//transition.stop();
//				}
//		};
		img.setVisible(true);
    	//img.translateXProperty().addListener(checkIntersection);
		AnimationTimer timer = new AnimationTimer() {
			@Override
			public void handle(long now) {
				if (img.getX()<(-750))
				{
					img.setVisible(false);
				}
				System.out.println(img.getX());
				img.translateXProperty().setValue(img.getX());
				img.setX(img.getX() - 0.35);
			}
		};
		timer.start();
//		TranslateTransition transition = new TranslateTransition();
//		transition.setDuration(Duration.seconds(50));
//		transition.setNode(img);
//		transition.setToX(-950);
//		transition.play();
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
		ImageView pea= new ImageView(".\\Main\\PvZpics\\Pea_1.png");
		System.out.println("Trying to shoot");
//		pea = new ImageView();
		ChangeListener<Number> checkIntersection = (ob, n, n1)->{
			for (ImageView target : Zombies) {
				//if (target.getX()-pea.getX()==0){
				if (pea.getBoundsInParent().intersects(target.getBoundsInParent())) {
					System.out.println("Intersection detected");
					pea.setX(img.getX());
				}
			}
		};

		Integer index_x=GridPane.getColumnIndex(img);
		Integer index_y=GridPane.getRowIndex(img);
		gridPane_.add(pea,index_x,index_y);

		AnimationTimer timer = new AnimationTimer() {
			@Override
			public void handle(long now) {

				if (pea.getX()>700)
				{
					pea.setX(img.getX());
				}
				pea.translateXProperty().addListener(checkIntersection);
				pea.translateXProperty().setValue(pea.getX());
				pea.setX(pea.getX() + 1.5);
				System.out.println(pea.getX());
			}
		};
		timer.start();
//		TranslateTransition transition = new TranslateTransition();
//		transition.setDuration(Duration.seconds(3));
//		transition.setNode(pea);
//		pea.setVisible(true);
//		transition.setToX(+700);
//		transition.setCycleCount(-1);
//		transition.play();
//		transition.setOnFinished((e)-> pea.setVisible(false));
	}

}
