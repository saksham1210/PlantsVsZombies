package Main;
    import java.util.ArrayList;

    public class Game {
        private static int sunTockens=100;
        ArrayList<Plant> plants;
        User myUser;
        private static int timer = 0;
        private boolean isOver = false;

        public Game (User user) {
            plants = new ArrayList<Plant>();
            myUser = user;
        }

        public static void collectSun() {
            sunTockens = sunTockens + 25;
        }

        public void buyPlants (int input) {
            switch (input) {
                case 1 :
                    Plant plant1 = new PeaShooter();
                    plants.add(plant1);
                case 2 :
                    Plant plant2 = new SunFlower();
                    plants.add(plant2);
                case 3 :
                    Plant plant3 = new Walnut();
                    plants.add(plant3);
                case 4 :
                    Plant plant4 = new CherryBomb();
                    plants.add(plant4);
                default:
                    System.out.print("wrong plant selection");
            }
        }

        public void startGame () {

        }

        public void resumeGame () {

        }

    }

