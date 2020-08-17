import java.awt.Graphics;
import java.util.*;
import java.util.Random;

public class World {

  public static World curr_world = null;
  public ArrayList<Sprite> sprites = new ArrayList<Sprite>();
  public ArrayList<Sprite> add_sprites = new ArrayList<Sprite>();
  public ArrayList<Sprite> remove_sprites = new ArrayList<Sprite>();

  private static long last_time = System.nanoTime();
  private static Random rand = new Random();

  public static void update() {
    float delta_time = (System.nanoTime() - last_time) / 1000000000.0f;
    last_time = System.nanoTime();

    for(Sprite sprite : curr_world.sprites) {
      sprite.update(delta_time);
    }

    for(Sprite sprite : curr_world.add_sprites) {
      if (!curr_world.sprites.contains(sprite)) {
        curr_world.sprites.add(sprite);
      }
    }

    curr_world.add_sprites.clear();

    for(Sprite sprite : curr_world.remove_sprites) {
      if (curr_world.sprites.contains(sprite)) {
        curr_world.sprites.remove(sprite);
      }
    }

    curr_world.remove_sprites.clear();
  }

  public static void render(Graphics g) {
    for(Sprite sprite : curr_world.sprites) {
      sprite.render(g);
    }
  }

  public void addSprite (Sprite sprite_to_add) {
    if(!add_sprites.contains(sprite_to_add)) {
      add_sprites.add(sprite_to_add);
    }
  }

  public void removeSprite (Sprite sprite_to_remove) {
    if(!remove_sprites.contains(sprite_to_remove)) {
      remove_sprites.add(sprite_to_remove);
    }
  }
}
