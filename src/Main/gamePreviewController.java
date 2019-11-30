package Main;

import javafx.animation.*;
import javafx.beans.value.ChangeListener;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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
	public Label sunTockens;
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
	public ArrayList<ImageView> Sunflowers;
	public double lastNanoTime;
	public double lastNanoTime1;
	public ArrayList<Boolean> zombie_in_row;
	public static Game game;

	public gamePreviewController()
	{
		zombie_in_row=new ArrayList<Boolean>();
		for (int i=0;i<5;i++)
		{
			zombie_in_row.add(false);
		}
		Plants=new ArrayList<ImageView>();
		Zombies=new ArrayList<ImageView>();
		Sunflowers=new ArrayList<ImageView>();
		zombie_list=new ArrayList<Zombie>();
		Suns=new ArrayList<ImageView>();
		Peas=new ArrayList<ImageView>();
		zombie_hash=new HashMap<ImageView, Zombie>();
		lastNanoTime=System.nanoTime();
		lastNanoTime1=System.nanoTime();
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
		if (event.getSource()==peashooter & Integer.parseInt(sunTockens.getText())>=100)
		{
			Dragboard db= peashooter.startDragAndDrop(TransferMode.ANY);
			img = new Image(".\\Main\\PvZpics\\plant_peashooter_thumb.png");
			sunTockens.setText(Integer.toString(Integer.parseInt(sunTockens.getText())-100));
			ClipboardContent cb =new ClipboardContent();
			cb.putImage(img);
			db.setContent(cb);
		}
		if (event.getSource()==sunflower & Integer.parseInt(sunTockens.getText())>=50)
		{
			Dragboard db= sunflower.startDragAndDrop(TransferMode.ANY);
			img = new Image(".\\Main\\PvZpics\\Sunflower2009HD.png");
			sunTockens.setText(Integer.toString(Integer.parseInt(sunTockens.getText())-50));
			ClipboardContent cb =new ClipboardContent();
			cb.putImage(img);
			db.setContent(cb);
		}
		if (event.getSource()==landmine & Integer.parseInt(sunTockens.getText())>=25)
		{
			Dragboard db= landmine.startDragAndDrop(TransferMode.ANY);
			img = new Image(".\\Main\\PvZpics\\PotatoMineHD.png");
			sunTockens.setText(Integer.toString(Integer.parseInt(sunTockens.getText())-25));
			ClipboardContent cb =new ClipboardContent();
			cb.putImage(img);
			db.setContent(cb);
		}
		if (event.getSource()==threepeater & Integer.parseInt(sunTockens.getText())>=325)
		{
			Dragboard db= threepeater.startDragAndDrop(TransferMode.ANY);
			img = new Image(".\\Main\\PvZpics\\Threepeater2009HD.png");
			sunTockens.setText(Integer.toString(Integer.parseInt(sunTockens.getText())-325));
			ClipboardContent cb =new ClipboardContent();
			cb.putImage(img);
			db.setContent(cb);
		}
		if (event.getSource()==cherrybomb & Integer.parseInt(sunTockens.getText())>=150)
		{
			Dragboard db= cherrybomb.startDragAndDrop(TransferMode.ANY);
			img = new Image(".\\Main\\PvZpics\\Cherrybomb.png");
			sunTockens.setText(Integer.toString(Integer.parseInt(sunTockens.getText())-150));
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
//	public boolean checkRow()
//	{
//		for
//	}


	public void handleDragDropped(DragEvent event)
	{
		Image clipboard_img= (Image) event.getDragboard().getContent(DataFormat.IMAGE);
		Node node= event.getPickResult().getIntersectedNode();
		ImageView img_v;
		if (clipboard_img.getHeight()==81.0) //PEASHOOTER
		{img_v=new ImageView(".\\Main\\PvZpics\\Peashooter_transparent_gif.gif");}
		else if (clipboard_img.getHeight()==85.0) //SUNFLOWER
		{img_v=new ImageView(".\\Main\\PvZpics\\5dbd90c75276b768463076.gif");}
		else{img_v=new ImageView(clipboard_img);}
		Integer index_x=GridPane.getColumnIndex(node);
		Integer index_y=GridPane.getRowIndex(node);
		System.out.print(index_x + " ");
		System.out.println(index_y) ;
		gridPane_.add(img_v,index_x,index_y);

		AnimationTimer timer = new AnimationTimer() {
			@Override
			public void handle(long now) {
				double time = (now - lastNanoTime1)/1000000000;
				if (time>=10){
					ProduceSun(img_v);
					lastNanoTime1 = now;
				}
			}
		};
		if (clipboard_img.getHeight()==81.0) //PEASHOOTER
		{
			System.out.println("Im Peashooter");
			this.Plants.add(img_v);
			for (ImageView ignored : Plants) {
//				if (zombie_in_row.get(index_y))
//				{
					shootPea(ignored);
//				}
			}
		}
		else if (clipboard_img.getHeight()==85.0) //SUNFLOWER
		{
			System.out.println("Im Sunflower");
			this.Sunflowers.add(img_v);
			for (ImageView ignored : Sunflowers)
			{
				timer.start();
			}
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
	public void ProduceSun(ImageView sunpro)
	{
		ImageView sun=new ImageView(".\\Main\\PvZpics\\Sun_PvZ2.png");
		sun.setFitWidth(50);
		sun.setFitHeight(50);
		gridPane_.add(sun, GridPane.getColumnIndex(sunpro), GridPane.getRowIndex(sunpro));
		sunpro.setOnMouseClicked((e)->sunCollect(sunpro));
	}


	public void shootPea(ImageView img)
	{
		ImageView pea= new ImageView(".\\Main\\PvZpics\\Pea_1.png");
		Peas.add(pea);
		ChangeListener<Number> checkIntersection = (ob, n, n1)->{
			for (ImageView target : Zombies) {
				if (pea.getBoundsInParent().intersects(target.getBoundsInParent())) {
					Zombie temp = zombie_hash.get(target);
					temp.getAttacked();
					if (!temp.isAlive()) {
						gridPane_.getChildren().remove(target);
						target.setImage(null);
						Zombies.remove(target);
						System.gc();
					}
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
				pea.setX(pea.getX() + 2);
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
		gridPane_.add(sun,index_x,0);
		Suns.add(sun);
		moveSun(sun);
	}

	public void sunCollect (ImageView sun) {
		Game.collectSun();
		sun.setVisible(false);
		int val = Integer.parseInt(sunTockens.getText());
		val = val + 25;
		sunTockens.setText((Integer.toString(val)));
		System.out.println("added");
	}
	public void moveSun(ImageView img)
	{
		img.setVisible(true);
		TranslateTransition transition = new TranslateTransition();
		transition.setDuration(Duration.seconds(12));
		img.setOnMouseClicked((e)->sunCollect(img));
		transition.setNode(img);
		transition.setToY(700);
		transition.play();
	}

	public void moveZombie(ImageView img)
    {
		img.setVisible(true);
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
    }




	public void moveLawnMower(double col,double row)
	{
		AnimationTimer timer = new AnimationTimer() {
			@Override
			public void handle(long now) {
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
