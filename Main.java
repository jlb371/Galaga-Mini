import java.awt.image.BufferedImage;
import java.io.IOException;

public class Main {

  //this is the function that runs the game
  public static void main(String[] args) {
    Renderer.init();

    World.curr_world = new World();
    World.curr_world.add_sprites.add(new Player(675, 850));
  }

  public static void quit() {
    System.exit(0);
  } //end quit()
} //end Main
