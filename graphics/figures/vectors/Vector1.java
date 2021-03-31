package graphics.figures.vectors;

import graphics.figures.points.Point1;

/**
 * I-can-do-whatever-I-want-and-get-away-with-it
 * 
 * @author Favourite / 13
 * @version %I%, %G%
 *
 */
public class Vector1 {

    /**
     * The start Point1 of the Vecto1.
     */
    Point1 p1;
    /**
     * The end Point1 of the Vecto1.
     */
    Point1 p2;

    /**
     * Creates a normalised Vector1 with its start Point1 at 0 and its end Point1 at
     * 1.
     */
    public Vector1() {
	this(0d, 1d);
    }

    /**
     * Creates a normalised Vector1 with its start and end Point1 at the same
     * locations as another given Vector1 <b>v</b>.
     * 
     * @param v is another Vector1.
     */
    public Vector1(Vector1 v) {
	this(v.getStart(), v.getEnd());
    }

    /**
     * Creates a Vector1 with its start Point1 at <b>p1</b> and its end Point1
     * <b>p2</b>.
     * 
     * @param p1 is the start Point1
     * @param p2 is the end Point1
     */

    public Vector1(Point1 p1, Point1 p2) {
	this(p1.x, p2.x);
    }

    /**
     * Creates a Vector1 with its start Point1 at <b>x1</b> and its end Point1
     * <b>x2</b>.
     * 
     * @param x1 is the location of the start Point1.
     * @param x2 is the location of the end Point1.
     */
    public Vector1(double x1, double x2) {
	this.p1 = new Point1(x1);
	this.p2 = new Point1(x2);
    }

    /**
     * Scales <b>this</b> Vector1 by <b>ratio</b>. The start Point1 does not change
     * its location.
     * 
     * @param ratio
     */
    public void scale(double ratio) {
	this.p2.x -= this.p1.x;
	this.p2.x *= ratio;
	this.p2.x += this.p1.x;
    }

    /**
     * Sets new <b>start</b> and <b>lend</b> for <b>this</b> Vector1.
     * 
     * @param p1 is a new start Point1.
     * @param p2 is a new end Point1.
     */
    public void set(Point1 p1, Point1 p2) {
	this.p1 = new Point1(p1);
	this.p2 = new Point1(p2);
    }

    /**
     * 
     * @return the start Point1 of <b>this</b> Vector1.
     */
    public Point1 getStart() {
	return this.p1;
    }

    /**
     * 
     * @return the end Point1 of <b>this</b> Vector1.
     */
    public Point1 getEnd() {
	return this.p2;
    }

    /**
     * Adds up two Vectors1. Neither of them is changed.
     * 
     * @param v1
     * @param v2
     * @return a new Vector1 which is the result of addition <b>v1</b> and <b>v2</b>
     */
    public static Vector1 add(Vector1 v1, Vector1 v2) {
	Vector1 v = new Vector1(v1);
	v.add(v2);
	return v;
    }

    /**
     * Adds a given Vector1 to <b>this</b> Vector1.
     * 
     * @param other is another given Vector1.
     */
    public void add(Vector1 other) {
	this.getEnd().x += other.getEnd().x;
	this.getEnd().x -= other.getStart().x;
    }

    /**
     * Subtracts one <b>first</b> Vector1 from another <b>second</b>. Neither of
     * them is changed.
     * 
     * @param v1 is the first Vector1.
     * @param v2 is the second Vector1.
     * @return a new Vector1 which is the result of addition <b>v1</b> and
     *         <b>v2</b>.
     */
    public static Vector1 subtract(Vector1 v1, Vector1 v2) {
	Vector1 v = new Vector1(v1);
	v.subtract(v2);
	return v;
    }

    /**
     * Subtracts a given Vector1 from <b>this</b> Vector1.
     * 
     * @param other is another given Vector1.
     */
    public void subtract(Vector1 other) {
	add(Vector1.getNeg(other));
    }

    /**
     * 
     * @param v1 is a Vector1.
     * @param v2 is a Vector1.
     * @return the dot product of <b>v1</b> and <b>v2</b>
     */
    public static double dotProduct(Vector1 v1, Vector1 v2) {
	return v1.getNorm() * v2.getNorm();
    }

    /**
     * 
     * @param v1 is a Vector1.
     * @param v2 is a Vector1.
     * @return the cross product of <b>v1</b> and <b>v2</b>
     */
    public static Vector1 crossProduct(Vector1 v1, Vector1 v2) {
	return new Vector1(0, 0);
    }

    /**
     * 
     * @return the norm (or the length) of <b>this</b> Vector1.
     */
    public double getNorm() {
	return Math.abs(this.p1.x - this.p2.x);
    }

    /**
     * 
     * @return the norm (or the length) to the power of 2 for <b>this</b> Vector1.
     */
    public double getNormSq() {
	return (this.p1.x - this.p2.x) * (this.p1.x - this.p2.x);

    }

    /**
     * 
     * @return the conjugate for <b>this</b> Vector1.
     */
    public Vector1 getConjugate() {
	return new Vector1(this.getStart(), this.getEnd());
    }

    /**
     * Returns a Vector1 which is negative to a given <b>v</b>.
     * 
     * @param v is another Vector1.
     */
    public static Vector1 getNeg(Vector1 v) {
	Point1 p1 = v.getStart();
	Point1 p2 = v.getEnd();
	return new Vector1(Point1.getNeg(p1), Point1.getNeg(p2));
    }

    /**
     * Changes the location of <b>this</b> Vector1 to <b>its</b> negative ones.
     */
    public void neg() {
	this.p1.neg();
	this.p2.neg();
    }

    /**
     * Converts Vector1 to a string format
     */
    @Override
    public String toString() {
	return "[" + this.p1.toString() + ";" + this.p2.toString() + "]";
    }
}
