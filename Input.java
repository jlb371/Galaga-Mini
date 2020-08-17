import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class Input implements KeyListener {

  private static boolean[] curr_keys = new boolean[128];
  private static boolean[] last_keys = new boolean[128];

  public static boolean getKey (int key_code) {
    return curr_keys[key_code];
  }

  public static boolean getKeyDown(int key_code) {
    return curr_keys[key_code] && last_keys[key_code];
  }

  public static boolean getKeyUp(int key_code) {
    return !curr_keys[key_code] && last_keys[key_code];
  }

  public static void cleanUp (){
    last_keys = curr_keys.clone();
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
