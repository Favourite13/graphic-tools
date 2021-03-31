package graphics.figures.points;

/**
 * I-can-do-whatever-I-want-and-get-away-with-it
 * <li>{@linkplain #getNeg() getNeg}
 * <li>{@linkplain #revolve(Vector3, double) revolve} //TODO
 * <li>{@linkplain #toString() toString}
 * 
 * @author Favourite / 13
 * @version %I%, %G%
 *
 */
public class Point3 {
    private final double CMP_EPSILON = 1E-6;
    private final int ACC = 100;
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
	String acc = "#";
	int temp = 1;
	while ((temp * this.CMP_EPSILON) < 1) {
	    temp *= this.ACC;
	    acc += "#";
	}
	java.text.NumberFormat nf = new java.text.DecimalFormat("0." + acc + "E0");
	String xSign = this.x < 0 ? "-" : "";
	double xAbs = Math.abs(this.x);
	String ySign = this.y < 0 ? "-" : "";
	double yAbs = Math.abs(this.y);
	String zSign = this.y < 0 ? "-" : "";
	double zAbs = Math.abs(this.y);

	String xStr = nf.format(xAbs).replaceFirst("E", "*10^(") + ")";
	String yStr = nf.format(yAbs).replaceFirst("E", "*10^(") + ")";
	String zStr = nf.format(zAbs).replaceFirst("E", "*10^(") + ")";

	return "(" + xSign + xStr + ";" + ySign + yStr + ";"+ zSign + zStr + ")";
    }
}
