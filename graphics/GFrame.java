package graphics;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class GFrame extends JFrame {
    
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    public final String TITLE = "in particular";
    private final static Image IMAGE = new ImageIcon(GFrame.class.getResource("../icon.png")).getImage();
    
    public GFrame() {
	this.add(new GPanel());
	this.setTitle(TITLE);
	this.setIconImage(IMAGE);
	this.setDefaultCloseOperation(GFrame.EXIT_ON_CLOSE);
	this.setResizable(false);
	this.pack();
	this.setVisible(true);
	this.setLocationRelativeTo(null);
    }
}
