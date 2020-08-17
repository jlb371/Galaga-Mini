import java.awt.Graphics;
import java.awt.Color;
import java.io.IOException;

public class EnemyShip extends Mob {

  public EnemyShip(float pos_x, float pos_y) {
    super(pos_x, pos_y);
    user_speed = 200.0f;
    width = 10;
    height = 10;

    try {
      image = Renderer.loadImage("/Sprite/enemy_ship.png");
    } catch (IOException e) {
      e.printStackTrace();
    }

  }

@Override
  public void update(float delta_time) {
    pos_y += user_speed * delta_time;
  }

@Override
  public void render(Graphics g) {
    if(image == null) {
      return;
    }

    g.drawImage(image, (int)pos_x, (int)pos_y, image.getWidth(),image.getHeight(), null);
  }
}
