package graphics.figures;

/**
 * @version %I%, %G%
 * @author Favourite / 13
 */

public class Vector3 {
    
    public Point p1;
    public Point p2;

    public Vector3() {
	this(new Point(0, 0, 0),
		new Point(1, 1, 1));	
    }

    public Vector3(double x1, double y1, double z1, double x2, double y2, double z2) {
	this(new Point(x1, y1, z1),
		new Point(x2, y2, z2));	
    }
    
    public Vector3(Point p) {
	this(new Point(0, 0, 0), p);
    }

    public Vector3(Point p1, Point p2) {
	this.p1 = p1;
	this.p2 = p2;
    }
    
    public void revolve(Quaternion q) {
	p1.revolve(q);
	p2.revolve(q);
    };

    @Override
    public String toString() {
	return "[" + p1.toString() + ", " + p2.toString() + "]";
	}
}
