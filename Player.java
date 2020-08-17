import java.awt.Graphics;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.io.IOException;

public class Player extends Mob {
  public Player(float pos_x, float pos_y) {
    super(pos_x, pos_y);

    width = 16;
    height = 16;
    user_speed = 400;

    try {
      image = Renderer.loadImage("/Sprite/user_ship.png");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void update (float delta_time) {

    float move_x = 0;
    float move_y = 0;

    if (Input.getKey(KeyEvent.VK_LEFT) && pos_x > 0) {
      move_x -= user_speed;
      pos_x += move_x * delta_time;
    }

    if (Input.getKey(KeyEvent.VK_RIGHT) && pos_x < 1350) {
      move_x += user_speed;
      pos_x += move_x * delta_time;
    }

    if (Input.getKey(KeyEvent.VK_UP) && pos_y > 0) {
      move_y -= user_speed;
      pos_y += move_y * delta_time;
    }

    if (Input.getKey(KeyEvent.VK_DOWN) && pos_y < 850) {
      move_y += user_speed;
      pos_y += move_y * delta_time;
    }

    if (Input.getKey(KeyEvent.VK_SPACE)) {
      User_Bullet bullet = new User_Bullet(pos_x, pos_y);
      World.curr_world.addSprite(bullet);
    }
  }

  @Override
  public void render(Graphics g) {
    if(image == null) {
      return;
    }

    g.drawImage(image, (int)pos_x, (int)pos_y, image.getWidth(),image.getHeight(), null);
  }
}
