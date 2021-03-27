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

/**
 * I-can-do-whatever-I-want-and-get-away-with-it
 * 
 * @author Favourite / 13
 * @version %I%, %G%
 *
 */
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
    private final int UNIT = this.WIDTH / 10;
    private final int ORIGIN_X = this.WIDTH / 2;
    private final int ORIGIN_Y = this.HEIGHT / 2;

    private double temp = 0d;

    public GPanel() {
	initPanel();
	run();
    }

    private void initPanel() {
	this.setBackground(Color.black);
	this.setPreferredSize(new Dimension(this.WIDTH, this.HEIGHT));
	running = true;
	timer = new Timer(FPS, this);// TODO timer = new Timer(1000/FPS, this)
	timer.start();
    }

    private void initGraphics(Graphics g) {
	g.setColor(Color.gray);
	for (int i = 1; i < this.WIDTH; i++) {
	    g.drawLine(i * this.UNIT, 0, i * this.UNIT, this.HEIGHT);
	    g.drawLine(0, i * this.UNIT, this.WIDTH, i * this.UNIT);
	}
    }

    private void run() {
	// TODO Auto-generated method stub

    }

    public void paintComponent(Graphics g) {
	super.paintComponent(g);
	initGraphics(g);
	draw(g);
	}

    private void draw(Graphics g) {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	repaint();
    }
}
