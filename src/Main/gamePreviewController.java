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
import java.util.Arrays;
import java.util.HashMap;
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
	public ArrayList<Zombie> zombie_list;
	public ArrayList<Plant> plant_list;
	public HashMap<ImageView,Zombie> zombie_hash;
	public HashMap<ImageView,Plant> plant_hash;
	public ArrayList<ImageView> Plants;
	public ArrayList<ImageView> Suns;
	public ArrayList<ImageView> Peas;
	public double lastNanoTime;
	public ArrayList<Boolean> zombie_in_row;

	public gamePreviewController()
	{
		zombie_in_row=new ArrayList<Boolean>();
		for (int i=0;i<5;i++)
		{
			zombie_in_row.add(false);
		}
		Plants=new ArrayList<ImageView>();
		Zombies=new ArrayList<ImageView>();
		zombie_list=new ArrayList<Zombie>();
		Suns=new ArrayList<ImageView>();
		Peas=new ArrayList<ImageView>();
		zombie_hash=new HashMap<ImageView, Zombie>();
		lastNanoTime=System.nanoTime();
	}
	@FXML
	public void initialize()
	{
		final int[] counter = {0};
		AnimationTimer timer = new AnimationTimer() {
			@Override
			public void handle(long now) {

				double time = (now - lastNanoTime)/1000000000;
				if (Zombies.size()<=7) {
					if(time >= 5.0)
					{
						counter[0]++;
						spawn_Zombie();
						if (counter[0] %2 ==0)
							spawn_Sun();
						lastNanoTime = now;
					}
				}
				if (time>=10){
					spawn_Sun();
					lastNanoTime = now;
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
//
//		for (ImageView zombie : Zombies)
//		{
//			ChangeListener<Number> checkIntersection = (ob, n, n1)->{
//				if (img_v.getBoundsInParent().intersects(zombie.getBoundsInParent())){
//					System.out.println("Intersection detected Zombie");
//
//				}
//			};
//		}


//		AnimationTimer timer = new AnimationTimer() {
//			@Override
//			public void handle(long now) {
//				if () {
//					gridPane_.getChildren().remove(pea);
////					pea.setImage(null);
//					pea.setX(img.getX());
//				}
//				if (clipboard_img.getHeight()==81.0) //PEASHOOTER
//				{
//					if (zombie_in_row.get(index_y))
//					{
//						shootPea(img_v);
//					}
//				}
//			}
//		};
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


	public void shootPea(ImageView img)
	{
		ImageView pea= new ImageView(".\\Main\\PvZpics\\Pea_1.png");
		Peas.add(pea);
		ChangeListener<Number> checkIntersection = (ob, n, n1)->{
			for (ImageView target : Zombies) {
				if (pea.getBoundsInParent().intersects(target.getBoundsInParent())) {
					//gridPane_.getChildren().remove(pea);
					Zombie temp = zombie_hash.get(target);
					temp.getAttacked();
					if (!temp.isAlive()) {gridPane_.getChildren().remove(target); }
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
					//gridPane_.getChildren().remove(pea);
//					pea.setImage(null);
					pea.setX(img.getX());
				}
				pea.translateXProperty().addListener(checkIntersection);
				pea.translateXProperty().setValue(pea.getX());
				pea.setX(pea.getX() + 2);
				//System.out.println(pea.getX());
			}
		};
		timer.start();
	}


	public void spawn_Zombie()
	{
		ImageView zombie=new ImageView(new Image(".\\Main\\PvZpics\\Conehead_Zombie.gif"));
		Zombie zom=new Zombie(zombie);
		zombie_list.add(zom);
		zombie_hash.put(zombie,zom);
		Random random=new Random();
		int index_y=random.nextInt(5);
		zombie_in_row.set(index_y,true);
		gridPane_.add(zombie,9,index_y);
		zombie.setVisible(true);
		Zombies.add(zombie);
		moveZombie(zombie);
	}
	public void spawn_Sun()
	{
		ImageView sun=new ImageView(new Image(".\\Main\\PvZpics\\Sun_PvZ2.png"));
		Random random=new Random();
		int index_x=random.nextInt(8);
		index_x+=1;
		//sun.setX(300+(30*index_x));
		gridPane_.add(sun,index_x,0);
		Suns.add(sun);
		moveSun(sun);
	}

	public void sunCollect () {
		Game.collectSun();
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
//		AnimationTimer timer = new AnimationTimer() {
//			@Override
//			public void handle(long now) {
//				if (img.getY()<(-750))
//				{
//					img.setVisible(false);
//				}
//				//System.out.println(img.getY());
//				img.translateYProperty().setValue(img.getY());
//				img.setX(img.getY() + 0.15);
//			}
//		};
//		timer.start();
		TranslateTransition transition = new TranslateTransition();
		transition.setDuration(Duration.seconds(15));
		sunflower.setOnMouseClicked((e)->sunCollect());
		transition.setNode(img);
		transition.setToY(500);
		transition.play();
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
					moveLawnMower(GridPane.getColumnIndex(img), GridPane.getRowIndex(img));
				}
				//System.out.println(img.getX());
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




	public void moveLawnMower(double col,double row)
	{
		AnimationTimer timer = new AnimationTimer() {
			@Override
			public void handle(long now) {

//				if (pea.getX()>700)
//				{
//					//pea=null;
//					pea.setX(img.getX());
//				}
//				pea.translateXProperty().addListener(checkIntersection);
//				pea.translateXProperty().setValue(pea.getX());
//				pea.setX(pea.getX() + 1.5);
//				System.out.println(pea.getX());
				if (col==1 & row==0 )
				{
					System.out.println("hoooooooooooo");
					lawnmower1.translateXProperty().setValue(lawnmower1.getX());
					lawnmower1.setX(lawnmower1.getX() + 3);
//				for (int i=0;i<12;i++)
//				{
//					gridPane_.
//				}
				}
				if (col==1 & row==1 )
				{
					System.out.println("hoooooooooooo");
					lawnmower2.translateXProperty().setValue(lawnmower2.getX());
					lawnmower2.setX(lawnmower2.getX() + 3);
				}
				if (col==1 & row==2 )
				{
					System.out.println("hoooooooooooo");
					lawnmower3.translateXProperty().setValue(lawnmower3.getX());
					lawnmower3.setX(lawnmower3.getX() + 3);
				}
				if (col==1 & row==3 )
				{
					System.out.println("hoooooooooooo");
					lawnmower4.translateXProperty().setValue(lawnmower4.getX());
					lawnmower4.setX(lawnmower4.getX() + 3);
				}
				if (col==1 & row==4 )
				{
					System.out.println("hoooooooooooo");
					lawnmower5.translateXProperty().setValue(lawnmower5.getX());
					lawnmower5.setX(lawnmower5.getX() + 3);
				}
			}
		};
//        TranslateTransition transition = new TranslateTransition();
//        transition.setDuration(Duration.seconds(3.5));
//        if (event.getSource()==lawnmower1)
//		{
//			transition.setNode(lawnmower1);
//			transition.setToX(+750);
//			transition.play();
//			transition.setOnFinished((e)->
//				lawnmower1.setVisible(false));
//		}
//		if (event.getSource()==lawnmower2)
//		{
//			transition.setNode(lawnmower2);
//			transition.setToX(+750);
//			transition.play();
//			transition.setOnFinished((e)-> lawnmower2.setVisible(false));
//		}
//		if (event.getSource()==lawnmower3)
//		{
//			transition.setNode(lawnmower3);
//			transition.setToX(+750);
//			transition.play();
//			transition.setOnFinished((e)-> lawnmower3.setVisible(false));
//		}
//		if (event.getSource()==lawnmower4)
//		{
//			transition.setNode(lawnmower4);
//			transition.setToX(+750);
//			transition.play();
//			transition.setOnFinished((e)-> lawnmower4.setVisible(false));
//		}
//		if (event.getSource()==lawnmower5)
//		{
//			transition.setNode(lawnmower5);
//			transition.setToX(+750);
//			transition.play();
//			transition.setOnFinished((e)-> lawnmower5.setVisible(false));
//		}
	}

}
