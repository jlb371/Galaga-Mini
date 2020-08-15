import java.io.IOException;

public class TestSprite extends Sprite {
  public TestSprite(float pos_x, float pos_y) {
    super(pos_x, pos_y);

    try {
      image = Renderer.loadImage("/Sprite/user_ship.png");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
