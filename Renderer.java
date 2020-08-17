import java.awt.Canvas;
import javax.swing.JFrame;
import java.awt.Toolkit;
import java.awt.Dimension;
import java.awt.GraphicsConfiguration;
import java.awt.image.VolatileImage;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Renderer {

  private static JFrame frame;
  private static Canvas canvas;

  public static int screen_width = 0;
  public static int screen_height = 0;

  private static long last_fps_check = 0;
  private static int current_fps = 0;
  private static int total_frames =  0;

  //create the window
  public static void init() {
    Dimension screen_size = Toolkit.getDefaultToolkit().getScreenSize();
    screen_width = screen_size.width;
    screen_height = screen_size.height;

    frame = new JFrame("Galaga_Mini");
    canvas = new Canvas();
    frame.setSize(screen_width, screen_height);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.add(canvas);
    frame.setVisible(true);

    canvas.addKeyListener(new Input());
    startRendering();
  } //end init()

  //start the process of actually running the game
  private static void startRendering() {
    Thread thread = new Thread() {
      public void run() {
        GraphicsConfiguration gc = canvas.getGraphicsConfiguration();
        VolatileImage v_image = gc.createCompatibleVolatileImage(screen_width, screen_height);
        while(true) {
          total_frames += 1;

          if(System.nanoTime() > last_fps_check + 1000000000) {
              last_fps_check = System.nanoTime();
              current_fps = total_frames;
              total_frames = 0;
          }

          if(v_image.validate(gc) == VolatileImage.IMAGE_INCOMPATIBLE) {
            v_image = gc.createCompatibleVolatileImage(screen_width, screen_height);
          }

          Graphics g = v_image.getGraphics();
          g.setColor(Color.black);
          g.fillRect(0, 0, screen_width, screen_height);
          World.update();
          Input.cleanUp();
          World.render(g);
          g.dispose();

          g = canvas.getGraphics();
          g.drawImage(v_image, 0, 0, screen_width, screen_height, null);

          g.dispose();
        }
      }
    };

    thread.start();
  }

  public static BufferedImage loadImage (String path) throws IOException {
    BufferedImage raw_image = ImageIO.read(Renderer.class.getResource(path));
    BufferedImage final_image = canvas.getGraphicsConfiguration().createCompatibleImage(raw_image.getWidth(), raw_image.getHeight(), raw_image.getTransparency());

    final_image.getGraphics().drawImage(raw_image, 0, 0, raw_image.getWidth(), raw_image.getHeight(), null);
    return final_image;
  }
} //end Renderer
