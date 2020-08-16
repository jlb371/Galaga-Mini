import java.io.IOException;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class TestSprite extends Sprite {
  public TestSprite(float pos_x, float pos_y) {
    super(pos_x, pos_y);

    try {
      image = Renderer.loadImage("/Sprite/user_ship.png");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void update (float delta_time) {
    if (Input.getKey(KeyEvent.VK_W)) {
      pos_y -= 80 * delta_time;
    }

    if (Input.getKey(KeyEvent.VK_S)) {
      pos_y += 80 * delta_time;
    }

    if (Input.getKey(KeyEvent.VK_A)) {
      pos_x -= 80 * delta_time;
    }

    if (Input.getKey(KeyEvent.VK_D)) {
      pos_x += 80 * delta_time;
    }
  }
}
