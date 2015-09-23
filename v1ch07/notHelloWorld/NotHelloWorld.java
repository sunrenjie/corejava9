package notHelloWorld;

import javax.swing.JFrame;
import javax.swing.JComponent;
import java.awt.EventQueue;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Color;

/**
 * @version 1.32 2007-06-12
 * @author Cay Horstmann
 */
public class NotHelloWorld
{
   public static void main(String[] args)
   {
      EventQueue.invokeLater(new Runnable()
         {
            public void run()
            {
               JFrame frame = new NotHelloWorldFrame(
                       new Font("Times New Roman", 0, 12), Color.RED);
               frame.setTitle("NotHelloWorld");
               frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
               frame.setVisible(true);
            }
         });
   }
}

/**
 * A frame that contains a message panel
 */
class NotHelloWorldFrame extends JFrame
{
   public NotHelloWorldFrame(Font font, Color color)
   {
      add(new NotHelloWorldComponent(font, color));
      pack();
   }
}

/**
 * A component that displays a message.
 */
class NotHelloWorldComponent extends JComponent
{
   public static final int MESSAGE_X = 75;
   public static final int MESSAGE_Y = 100;

   private static final int DEFAULT_WIDTH = 300;
   private static final int DEFAULT_HEIGHT = 200;
   private static final String text = "Not a Hello, World program";

   private Font textFont;
   private Color textColor;

   public NotHelloWorldComponent(Font font, Color color)
   {
      textFont = font;
      textColor = color;
   }

   public void paintComponent(Graphics g)
   {
      g.setFont(textFont);
      g.setColor(textColor);
      int widthText = g.getFontMetrics(textFont).stringWidth(text);
      int width = this.getWidth();
      // Try to put the text in the middle. Text height, considered relatively
      // small, is ignored. Stolen from:
      // http://stackoverflow.com/questions/18483768/draw-text-in-middle-of-the-screen
      int left = width < widthText ? 0 : (width - widthText) / 2;
      g.drawString(text, left, this.getHeight() / 2);
   }
   
   public Dimension getPreferredSize() { return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT); }
}
