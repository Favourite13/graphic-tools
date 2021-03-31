package graphics.figures.points;

/**
 * I-can-do-whatever-I-want-and-get-away-with-it
 * 
 * @author Favourite / 13
 * @version %I%, %G%
 *
 */
public class Point2 {
    private final double CMP_EPSILON = 1E-6;
    private final int ACC = 100;
    /**
     * Location <b>x</b> of the Point2.
     */
    public double x;
    /**
     * Location <b>y</b> of the Point2.
     */
    public double y;

    /**
     * Creates a Point2 at location 0, 0.
     */
    public Point2() {
	this(0d, 0d);
    }

    /**
     * Creates a Point2 at the same location as <b>p</b>.
     * 
     * @param p is another Point2.
     */
    public Point2(final Point2 p) {
	this(p.x, p.y);
    }

    /**
     * Creates a Point2 at location <b>x</b>.
     * 
     * @param x is a given x location.
     * @param y is a given y location.
     */
    public Point2(final double x, final double y) {
	this.x = x;
	this.y = y;
    }

    /**
     * Returns a Point2 which is negative to a given <b>p</b>.
     * 
     * @param p is another Point2.
     */
    public final static Point2 getNeg(Point2 p) {
	return new Point2(-p.x, -p.y);
    }

    /**
     * Changes the location <b>x, y</b> of the Point2 <b>p</b> to <b>-x, -y</b>
     */
    public final void neg() {
	this.x = -x;
	this.y = -y;
    }

    /**
     * Revolves <b>this</b> Point2 round another Point2 <b>p</b> at angle <b>a</b>.
     * Uses basic trigonometric algebra.
     * 
     * @param p is another Point2.
     * @param a is an angle, in radians.
     */
    public final void revolve(Point2 p, double a) {
	double theta, distance, x, y;
	x = this.x - p.x;
	y = this.y - p.y;
	distance = Math.sqrt(x * x + y * y);
	theta = Math.atan2(y, x) + a;
	this.x = distance * Math.cos(theta) + p.x;
	this.y = distance * Math.sin(theta) + p.y;
    }

    /**
     * Revolves <b>this</b> Point2 round another Point2 <b>p</b> at angle <b>a</b>.
     * Uses complex number algebra.
     * 
     * @param p is another Point2.
     * @param a is an angle, in radians.
     */
    public final void revolveC(Point2 p, double rad) {
	double a1, b1, a2, b2;
	a1 = this.x - p.x;
	b1 = this.y - p.y;
	a2 = Math.cos(rad);
	b2 = Math.sin(rad);
	this.x = a1 * a2 - b1 * b2 + p.x;
	this.y = b1 * a2 + a1 * b2 + p.y;
    }

    /**
     * 
     * @param p1
     * @param p2
     * @return distance between two Point2 objects
     */
    public final static double getDistance(Point2 p1, Point2 p2) {
	return Math.sqrt((p1.x - p2.x) * (p1.x - p2.x) + (p1.y - p2.y) * (p1.y - p2.y));
    }

    /**
     * 
     * @param p1
     * @param p2
     * @return angle between the line through two Point2 objects and the x-axis, in
     *         radians
     */
    public final static double getAngle(Point2 p1, Point2 p2) {
	return Math.atan2(p2.y - p1.y, p2.x - p1.x);
    }

    /**
     * Converts Point2 to a string format
     */
    @Override
    public final String toString() {
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
	String xStr = nf.format(xAbs).replaceFirst("E", "*10^(") + ")";
	String yStr = nf.format(yAbs).replaceFirst("E", "*10^(") + ")";

	return "(" + xSign + xStr + ";" + ySign + yStr + ")";
    }

    public final boolean equals(Point2 p) {
	if (this.x == p.x && this.y == p.y) {
	    return true;
	}
	return false;
    }
}
