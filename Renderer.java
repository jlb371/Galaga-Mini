import java.awt.Canvas;
import javax.swing.JFrame;
import java.awt.Toolkit;
import java.awt.Dimension;
import java.awt.GraphicsConfiguration;
import java.awt.image.VolatileImage;
import java.awt.Graphics;
import java.awt.Color;

public class Renderer {

  private static JFrame frame;
  private static Canvas canvas;
  //screen_width and screen_height are used for the user's screen size
  private static int screen_width = 0;
  private static int screen_height = 0;
  //HEIGHT and WIDTH are used to make a more pixelated look for the game
  private static final int WIDTH = 400;
  private static final int HEIGHT = 250;
  //game_width and game_height are used as the scaled image width and height to maintain pixelated appearance
  private static int game_width = 0;
  private static int game_height = 0;

  //scales the game's size to the user's computer screen
  private static void scaleSize() {
    boolean is_done = false;

    while (!is_done) {
      game_width += WIDTH;
      game_height += HEIGHT;

      if(game_width > screen_width || game_height > screen_height) {
        game_width -= WIDTH;
        game_height -= HEIGHT;
        is_done = true;
      }
    }

    int x_diff = screen_width - game_width;
    int y_diff = screen_height - game_height;
    int factor = game_width / WIDTH;

    game_width = (game_width / factor) + (x_diff / factor);
    game_height = (game_height / factor) + (y_diff / factor);

    game_width = game_width * factor;
    game_height = game_height * factor;
  } //end scaleSize()

  //create the window
  public static void init() {
    Dimension screen_size = Toolkit.getDefaultToolkit().getScreenSize();
    screen_width = screen_size.width;
    screen_height = screen_size.height;

    scaleSize();

    frame = new JFrame("GameFrame");
    canvas = new Canvas();
    frame.setSize(screen_width, screen_size.height);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.add(canvas);
    frame.setVisible(true);

    startRendering();
  } //end init()

  //start the process of actually running the game 
  private static void startRendering() {
    Thread thread = new Thread() {
      public void run() {
        GraphicsConfiguration gc = canvas.getGraphicsConfiguration();
        VolatileImage v_image = gc.createCompatibleVolatileImage(game_width, game_height);
        while(true) {
          if(v_image.validate(gc) == VolatileImage.IMAGE_INCOMPATIBLE) {
            v_image = gc.createCompatibleVolatileImage(game_width, game_height);
          }

          Graphics g = v_image.getGraphics();
          g.setColor(Color.black);
          g.fillRect(0, 0, game_width, game_height);
          g.setColor(Color.red);
          g.drawRect(10, 10, 100, 100);
          g.dispose();

          g = canvas.getGraphics();
          g.drawImage(v_image, 0, 0, game_width, game_height, null);

          g.dispose();
        }
      }
    };

    thread.start();
  }
} //end Renderer
