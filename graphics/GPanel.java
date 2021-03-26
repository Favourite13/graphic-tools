package graphics;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

import graphics.figures.points.*;
import graphics.figures.vectors.*;

public class GPanel extends JPanel implements ActionListener {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private Timer timer;
    private boolean running = false;
    private final int FPS = 75;
    private final int WIDTH = 820;
    private final int HEIGHT = 820;
    private final int ORIGIN_X = this.WIDTH / 2;
    private final int ORIGIN_Y = this.HEIGHT / 2;
    
    private double temp = 0d;
    public GPanel() {
	initPanel();
	initGraphics();
	run();
    }

    private void initPanel() {
	this.setPreferredSize(new Dimension(this.WIDTH, this.HEIGHT));
	running = true;
	timer = new Timer(FPS*2, this);// TODO timer = new Timer(1000/FPS, this)
	timer.start();
    }

    private void initGraphics() {
    }

    private void run() {
	// TODO Auto-generated method stub

    }

    public void paintComponent(Graphics g) {
	super.paintComponent(g);
	g.setColor(Color.black);
	g.drawLine(ORIGIN_X, 0, ORIGIN_X, this.HEIGHT);
	g.drawLine(0, ORIGIN_Y, this.WIDTH, ORIGIN_Y);
	
	draw(g);
	int size = 100;
	Point2 p1 = new Point2(2, 2);
	Point2 p2 = new Point2(3, 1);
	Point2 p3 = new Point2(-1, -1);
	Point2 p0 = new Point2(0, 0);
	Vector2 v = new Vector2(p1, p2);
	g.setColor(Color.red);
	g.drawLine((int) (v.getStart().x * size + this.ORIGIN_X),
		(int) (v.getStart().y* size + this.ORIGIN_Y),
		(int) (v.getEnd().x* size + this.ORIGIN_X),
		(int) (v.getEnd().y* size + this.ORIGIN_Y));
	if (temp > 10) {

		g.setColor(Color.green);
	v.revolve(p3, this.temp);
	}
	else {

		g.setColor(Color.blue);
	    v.revolve(p0, this.temp);
	}
	this.temp += 0.1;
	g.drawLine((int) (v.getStart().x * size + this.ORIGIN_X),
		(int) (v.getStart().y* size + this.ORIGIN_Y),
		(int) (v.getEnd().x* size + this.ORIGIN_X),
		(int) (v.getEnd().y* size + this.ORIGIN_Y));
    }

    private void draw(Graphics g) {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	repaint();
    }
}
