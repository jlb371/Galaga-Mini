import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Sprite {

  public float pos_x = 0;
  public float pos_y = 0;
  public BufferedImage image = null;

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

    int real_x = (int)pos_x - (image.getWidth() / 2);
    int real_y = (int)pos_y - (image.getHeight() / 2);

    g.drawImage(image, real_x, real_y, image.getWidth(),image.getHeight(), null);
  }
}
