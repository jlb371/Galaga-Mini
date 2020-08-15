import java.awt.Graphics;
import java.util.*;

public class World {

  public static World curr_world = null;
  public ArrayList<Sprite> sprites = new ArrayList<Sprite>();
  private static long last_time = System.nanoTime();

  public static void update() {
    float delta_time = (System.nanoTime() - last_time) / 1000000000.0f;
    last_time = System.nanoTime();
    for(Sprite sprite : curr_world.sprites) {
      sprite.update(delta_time);
    }
  }

  public static void render(Graphics g) {
    for(Sprite sprite : curr_world.sprites) {
      sprite.render(g);
    }
  }
}
