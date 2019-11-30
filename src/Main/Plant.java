package Main;

public class Plant {
    private boolean isAlive = true;
    private static int health = 3;

    public void die () {
        isAlive = false;
    }
}

class PeaShooter extends Plant{

}

class SunFlower extends Plant{
    static int timeInterval = 3;
    public void produceSun () {

    }
}

class Walnut extends Plant{

}

class CherryBomb extends Plant{

}