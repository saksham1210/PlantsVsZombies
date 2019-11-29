package Main;

public class Zombie {
    private int pos_x;
    private int pos_y;
    private int attcak_val;
    private int health;
    private int speed;
    private boolean isAlive;
 //   private Tile myTile;
    public void Attack(Plant plant)
    {}
    public void move()
    {}
    

    public void setPos_x(int pos_x) {
        this.pos_x = pos_x;
    }

    public void setPos_y(int pos_y) {
        this.pos_y = pos_y;
    }

    public void setAttcak_val(int attcak_val) {
        this.attcak_val = attcak_val;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

//    public void setMyTile(Tile myTile) {
//        this.myTile = myTile;
//    }

    public int getPos_x() {
        return pos_x;
    }

    public int getPos_y() {
        return pos_y;
    }

    public int getAttcak_val() {
        return attcak_val;
    }

    public int getHealth() {
        return health;
    }

    public int getSpeed() {
        return speed;
    }

    public boolean isAlive() {
        return isAlive;
    }

//    public Tile getMyTile() {
//        return myTile;
//    }


}
