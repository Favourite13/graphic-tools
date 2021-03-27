package graphics.figures.points;

/**
 * I-can-do-whatever-I-want-and-get-away-with-it
 * 
 * @author Favourite / 13
 * @version %I%, %G%
 *
 */

public class Point1 {

    /**
     * Location <b>x</b> of the Point1
     */
    public double x;

    /**
     * Creates a Point1 at location 0
     */
    public Point1() {
	this(0d);
    }

    /**
     * Creates a Point1 at the same location as <b>p</b>
     * 
     * @param p is another Point1
     */
    public Point1(final Point1 p) {
	this(p.x);
    }

    /**
     * Creates a Point1 at location <b>x</b>
     * 
     * @param x is a given location
     */
    public Point1(final double x) {
	this.x = x;
    }

    /**
     * Returns a Point1 which is negative to a given <b>p</b>
     * 
     * @param p is another Point1
     */
    public final static Point1 getNeg(Point1 p) {
	return new Point1(-p.x);
    }

    /**
     * Changes the location <b>x</b> of the Point1 <b>p</b> to <b>-x</b>
     */
    public final void neg() {
	this.x = -x;
    }

    /**
     * Converts Point1 to a string format
     */
    @Override
    public final String toString() {
	return "(" + x + ")";
    }
}
