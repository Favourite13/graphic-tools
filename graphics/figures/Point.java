package graphics.figures;

/**
 * @version %I%, %G%
 * @author Favourite / 13
 */

public class Point {
    public double x;
    public double y;
    public double z;

    public Point() {
	this(0, 0, 0);
    }
    
    public Point(Point p) {
	this(p.x, p.y, p.z);
    }

    public Point(double x, double y, double z) {
	this.x = x;
	this.y = y;
	this.z = z;
    }

    private Quaternion toQuaternion() {
	return new Quaternion(0, x, y, z);
    }

    public void revolve(Quaternion q) {
	// TODO input: quaternion
	// TODO (q)*(Point)*(q*)
	// q* - conjugate for q
	System.out.println("revolving xd");
    }
    
    @Override
    public String toString() {
	return "(" + x + "," + y + "," + z + ")";//TODO сделать как в кватернионе
    }
}
