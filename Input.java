import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

/*handles input from the user's keyboard*/

public class Input implements KeyListener {

  //boolean arrays for each key on a keyboard
  private static boolean[] curr_keys = new boolean[128]; //keys that are currently being pressed
  private static boolean[] last_keys = new boolean[128]; //keys that were pressed before and have since been released

  /*get the key that is currently being pressed*/
  public static boolean getKey (int key_code) {
    return curr_keys[key_code];
  }

  /*return if a key is currently being held down*/
  public static boolean getKeyDown(int key_code) {
    return curr_keys[key_code] && !last_keys[key_code];
  }

  /*return if a key was pressed last frame*/
  public static boolean getKeyUp(int key_code) {
    return !curr_keys[key_code] && last_keys[key_code];
  }

  /*any keys that were pressed last frame should be added to last_keys and any that were not held down last
    frame should be removed from last_keys*/
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
