import java.awt.image.BufferedImage;
import java.io.IOException;

public class Main {

  //this is the function that runs the game
  public static void main(String[] args) {
    Renderer.init();

    World.curr_world = new World();
    World.curr_world.sprites.add(new TestSprite(100, 100));

    try {
      BufferedImage image = Renderer.loadImage("/Sprite/user_ship.png");
      System.out.println(image);
    } catch(IOException e) {
      e.printStackTrace();
    }
  }

  public static void quit() {
    System.exit(0);
  } //end quit()
} //end Main
