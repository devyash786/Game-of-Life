package gameoflife;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Application extends Frame implements Runnable, MouseWheelListener {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private Game game;
    private int framesPerSecond = 1;

    public static void main(String[] args) {
        Application a = new Application();
        a.setVisible(true);
    }

    public Application() {
        Board initial = Initializer.initializeGlider();
        resizeClientArea(25 * 10, 25 * 10);
        game = new Game(initial);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                setVisible(false);
                dispose();
                System.exit(0);
            }
        });

        addMouseWheelListener(this);

        new Thread(this).start();
    }

    private void resizeClientArea(int width, int height) {
        Insets insets = getInsets();
        setSize(width + insets.left + insets.right, height + insets.top + insets.bottom);
    }

    @Override
    public void update(Graphics g) {
        paint(g);
    }

    @Override
    public void paint(Graphics g) {
        resizeClientArea(25 * 10, 25 * 10);
        Image buffer = createImage(getSize().width, getSize().height);
        game.draw(buffer.getGraphics());
        Insets insets = getInsets();
        g.drawImage(buffer, insets.left, insets.top, this);
    }

    public void run() {
        long prev = System.currentTimeMillis();
        float accumulator = 0;
        float millisecondsPerFrame = 1000 / framesPerSecond;

        repaint();

        while (true) {
            long cur = System.currentTimeMillis();
            accumulator += cur - prev;
            prev = cur;

            while (accumulator >= millisecondsPerFrame) {
                try {
                    game.advance();
                    accumulator -= millisecondsPerFrame;
                    repaint();
                } catch (CloneNotSupportedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
               
            }
        }
    }
    
    @Override
    public void mouseWheelMoved(MouseWheelEvent e)
    {
        int clicks = e.getWheelRotation();
        setResolution(getResolution() + clicks);
    }
    
    private int getResolution()
    {
        // implement me!
        return 10;
    }
    
    private void setResolution(int resolution)
    {
        // implement me!
    }
}
