package Main;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class User {
    private String username;
    private Game myGame;

    public User (String username) {
        this.username = username;
        myGame = new Game (this);
        startGame();
    }

    public String getUsername() {
        return username;
    }

    public void serialize () throws IOException {
        String name_file = getUsername() + ".txt";
        ObjectOutputStream out = null;
        try {
            out = new ObjectOutputStream( new FileOutputStream(name_file));
            out.writeObject(this);
        }
        finally {
            out.close();
        }
    }

    public void startGame() {
        myGame.startGame();
    }

    public void resumeGame () {
        myGame.resumeGame();
    }
}