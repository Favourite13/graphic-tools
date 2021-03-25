package graphics;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Window extends Canvas implements Runnable {

    private static final long serialVersionUID = 1L;
    private Thread thread;
    private JFrame frame;
    private static String TITLE = "no you";
    private final int WIDTH = 800;
    private final int HEIGHT = 600;
    private boolean RUNNING = false;
    private final static Image IMAGE = new ImageIcon(Window.class.getResource("../icon.png")).getImage();

    public Window() {
	this.frame = new JFrame();
	Dimension size = new Dimension(this.WIDTH, this.HEIGHT);
	this.setPreferredSize(size);
    }

    public static void main(String[] args) {
	Window win = new Window();
	
	win.frame.setTitle(TITLE);
	win.frame.add(win);
	win.frame.pack();
	win.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	win.frame.setLocationRelativeTo(null);
	win.frame.setResizable(false);
	win.frame.setVisible(true);
	win.frame.setIconImage(IMAGE);
	win.start();
	
    }

    public synchronized void start() {
	this.RUNNING = true;
	this.thread = new Thread(this, "Window");
	this.thread.start();
    }

    public synchronized void stop() {
	this.RUNNING = false;
	try {
	    this.thread.join();
	} catch (InterruptedException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
	
    }

    @Override
    public void run() {

    }

}
