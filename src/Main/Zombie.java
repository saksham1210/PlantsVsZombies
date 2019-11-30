package Main;

import javafx.scene.image.ImageView;

public class Zombie {
    private static ImageView image;
    private boolean isAlive = true;
    private int health = 4;
    private static  int attackVal = 1;

    public boolean isAlive() {
        return isAlive;
    }

    public Zombie (ImageView input) {
        image = input;
    }

    public void getAttacked () {
        health = health - 1;

        if(health == 0)
            this.die();
    }

    public void die () {
        isAlive = false;
        System.out.println("DIE");
        //image.setImage(null);
    }
}


class NormalZombie extends Zombie{
    public NormalZombie (ImageView image) {
        super (image);
    }
}

class FootballZombie extends Zombie{
    static int timeInterval = 3;
    public void produceSun () {  }
    public FootballZombie (ImageView image) {
        super (image);
    }
}

class ConeHead extends Zombie{
    public ConeHead (ImageView image) {
        super (image);
    }
}