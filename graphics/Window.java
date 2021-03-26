package graphics;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferStrategy;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import graphics.figures.vectors.IVector;
import graphics.figures.vectors.Vector1;
import graphics.figures.vectors.Vector2;
import graphics.figures.vectors.Vector3;

public class Window extends Canvas implements Runnable {

    private static final long serialVersionUID = 1L;
    private Thread thread;
    private JFrame frame;
    private static String TITLE = "no you";
    private final int WIDTH = 800;
    private final int HEIGHT = 600;
    private boolean RUNNING = false;
    private final static Image IMAGE = new ImageIcon(Window.class.getResource("../icon.png")).getImage();
    private final float FPS = 75f;

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
	    e.printStackTrace();
	}

    }

    @Override
    public void run() {
	long lastTime = System.nanoTime();
	long startTime = System.currentTimeMillis();
	final double ns = 10e+8 / this.FPS;
	double delta = 0;
	int frames = 0;

	init();

	while (this.RUNNING) {
	    long now = System.nanoTime();
	    delta += (now - lastTime) / ns;
	    lastTime = now;
	    while (delta >= 1) {
		update();
		delta -= 1;

		render();
		frames++;
	    }

	    if (System.currentTimeMillis() - startTime > 1000) {
		startTime += 1000;
		this.frame.setTitle(TITLE + "|" + frames + " fps");
		frames = 0;
	    }
	}

	stop();

    }

    private void init() {
	// TODO Auto-generated method stub

    }

    private void update() {
	// TODO Auto-generated method stub
	
    }

    private void render() {
	BufferStrategy bs = this.getBufferStrategy();
	if (bs == null) {
	    this.createBufferStrategy(3);
	    return;
	}

	Graphics g = bs.getDrawGraphics();
	g.setColor(new Color(51, 204, 51));
	g.fillRect(0, 0, this.WIDTH, this.HEIGHT);

	g.setColor(Color.RED);

	int origin_x = this.WIDTH / 2;
	int origin_y = this.HEIGHT / 2;
	Vector1 v1 = new Vector1(1, 2);
	Vector1 v2 = new Vector1(-2, -1);
	
	
	int y1 = 80;
	int y2 = 80;
	g.fill3DRect(500, 100, 200, 300, !RUNNING);

	g.dispose();
	bs.show();
    }

}
