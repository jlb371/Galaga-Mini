import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.*;
import java.util.Random;

public class Main {

  //this is the function that runs the game
  public static void main(String[] args) {
    Renderer.init();

    World.curr_world = new World();
    World.curr_world.add_sprites.add(new Player(675, 850));
    Random rand = new Random();

    Timer t = new Timer();
    t.scheduleAtFixedRate (
      new TimerTask() {
        public void run() {
          int x = rand.nextInt(1350);
          World.curr_world.add_sprites.add(new EnemyShip(x, -96));
        }
      }, 0, 1250

    );
  }

  public static void quit() {
    System.exit(0);
  } //end quit()
} //end Main
