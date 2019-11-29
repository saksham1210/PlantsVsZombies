package Main;

//        -toAttack : boolean
//        -isAlive : boolean
//        -isActive : boolean
//        -lastBought : int
//        -Cost : int
public class Plant {
    private int pos_x;
    private int pos_y;
    private boolean isActive;
    private boolean toAttack;
    private int health;
    private int Cost;
    private int lastBought;
    private boolean isAlive;
    private Tile myTile;

    public void getAttacked(int attack_val)
    {
        this.health-=attack_val;
    }

    public void setPos_x(int pos_x) {
        this.pos_x = pos_x;
    }

    public void setPos_y(int pos_y) {
        this.pos_y = pos_y;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public void setToAttack(boolean toAttack) {
        this.toAttack = toAttack;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setCost(int cost) {
        Cost = cost;
    }

    public void setLastBought(int lastBought) {
        this.lastBought = lastBought;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    public void setMyTile(Tile myTile) {
        this.myTile = myTile;
    }

    public int getPos_x() {
        return pos_x;
    }

    public int getPos_y() {
        return pos_y;
    }

    public boolean isActive() {
        return isActive;
    }

    public boolean isToAttack() {
        return toAttack;
    }

    public int getHealth() {
        return health;
    }

    public int getCost() {
        return Cost;
    }

    public int getLastBought() {
        return lastBought;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public Tile getMyTile() {
        return myTile;
    }
}
