package graphics.figures.points;

/**
 * I-can-do-whatever-I-want-and-get-away-with-it
 * <li>{@linkplain #getNeg() getNeg}
 * <li>{@linkplain #revolve(Vector3, double) revolve}
 * <li>{@linkplain #toString() toString}
 * 
 * @author Favourite / 13
 * @version %I%, %G%
 *
 */
public class Point3 {
    /**
     * Location <b>x</b> of the Point3.
     */
    public double x;
    /**
     * Location <b>y</b> of the Point3.
     */
    public double y;
    /**
     * Location <b>z</b> of the Point3.
     */
    public double z;

    /**
     * Creates a Point3 at location 0, 0, 0.
     */
    public Point3() {
	this(0d, 0d, 0d);
    }

    /**
     * Creates a Point3 at the same location as <b>p</b>.
     * 
     * @param p is another Point3.
     */
    public Point3(Point3 p) {
	this(p.x, p.y, p.x);
    }

    /**
     * Creates a Point3 at location <b>x</b>.
     * 
     * @param x is a given x location.
     * @param y is a given y location.
     * @param z is a given z location.
     */
    public Point3(final double x, final double y, final double z) {
	this.x = x;
	this.y = y;
	this.z = z;
    }

    /**
     * Returns a Point3 which is negative to a given <b>p</b>.
     * 
     * @param p is another Point3.
     */
    public final static Point3 getNeg(Point3 p) {
	return new Point3(-p.x, -p.y, -p.z);
    }

    /**
     * Changes the location <b>x, y</b> of the Point2 <b>p</b> to <b>-x, -y, -z</b>
     */
    public void neg() {
	this.x = -x;
	this.y = -y;
	this.z = -z;
    }

    /**
     * Converts Point3 to a string format
     */
    @Override
    public String toString() {
	return "(" + x + ";" + y + ";" + z + ")";
    }
}
