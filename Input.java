import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class Input implements KeyListener {

  private static boolean[] curr_keys = new boolean[128];

  public static boolean getKey (int key_code) {
    return curr_keys[key_code];
  }

  @Override
  public void keyPressed(KeyEvent e) {
    curr_keys[e.getKeyCode()] = true;
  }

  @Override
  public void keyReleased(KeyEvent e) {
    curr_keys[e.getKeyCode()] = false;
  }

  @Override
  public void keyTyped(KeyEvent e) {

  }
}
