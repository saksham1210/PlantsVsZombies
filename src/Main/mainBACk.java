package Main;

import java.io.*;
        import java.util.ArrayList;

class mainBACK {
    ArrayList<User> users;

    public void StartNewGame (String username) {
        User newuser = new User(username);
        users.add(newuser);
    }

    public void deserialize(String name) throws IOException, ClassNotFoundException {
        String file_name = name + ".txt";
        ObjectInputStream in = null;
        try {
            in = new ObjectInputStream( new FileInputStream(file_name));
            User user = (User) in.readObject();
        }
        catch (FileNotFoundException e){
            System.out.println("This user does not exist.");
        }
        finally {
            in.close();
        }
    }

    public static void main (String args[]) {
        //main
    }
}