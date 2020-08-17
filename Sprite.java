import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Sprite {

  public float pos_x = 0;
  public float pos_y = 0;
  public BufferedImage image = null;
  public float width = 0;
  public float height = 0;
  public boolean is_solid = false;

  public Sprite (float pos_x, float pos_y) {
    this.pos_x = pos_x;
    this.pos_y = pos_y;
  }

  public void update(float delta_time) {

  }
  public void render(Graphics g) {

    if(image == null) {
      return;
    }

    g.drawImage(image, (int)pos_x, (int)pos_y, image.getWidth(),image.getHeight(), null);
  }
}
