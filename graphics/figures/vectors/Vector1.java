package graphics.figures.vectors;

import graphics.figures.points.Point1;

/**
 * I-can-do-whatever-I-want-and-get-away-with-it
 * 
 * @author Favorite / 13
 * @version %I%, %G%
 *
 */
public class Vector1 {

    Point1 p1, p2;

    public Vector1() {
	this(0d, 1d);
    }

    public Vector1(Vector1 v) {
	this(v.getStart(), v.getEnd());
    }

    public Vector1(Point1 p1, Point1 p2) {
	this(p1.x, p2.x);
    }

    public Vector1(double x1, double x2) {
	this.p1 = new Point1(x1);
	this.p2 = new Point1(x2);
    }

    public void scale(double ratio) {
	this.p2.x -= this.p1.x;
	this.p2.x *= ratio;
	this.p2.x += this.p1.x;
    }

    public void set(Point1 p1, Point1 p2) {
	this.p1 = new Point1(p1);
	this.p2 = new Point1(p2);
    }

    public Point1 getStart() {
	return this.p1;
    }
    
    public Point1 getEnd() {
	return this.p2;
    }

    public static Vector1 add(Vector1 v1, Vector1 v2) {
	Vector1 v = new Vector1(v1);
	v.add(v2);
	return v;
    }

    public void add(Vector1 other) {
	this.getEnd().x += other.getEnd().x;
	this.getEnd().x -= other.getStart().x;
    }

    public static Vector1 subtract(Vector1 v1, Vector1 v2) {
	Vector1 v = new Vector1(v1);
	v.subtract(v2);
	return v;
    }

    public void subtract(Vector1 v) {
	add(Vector1.getNeg(v));
    }

    public static double dotProduct(Vector1 v1, Vector1 v2) {
	return v1.getNorm() * v2.getNorm();
    }

    public static Vector1 crossProduct(Vector1 v1, Vector1 v2) {
	return new Vector1(0, 0);
    }

    public double getNorm() {
	return Math.abs(this.p1.x - this.p2.x);
    }

    public Vector1 getConjugate() {
	return new Vector1(this.getStart(), this.getEnd());
    }

    public double getNormSq() {
	return (this.p1.x - this.p2.x) * (this.p1.x - this.p2.x);

    }

    @Override
    public String toString() {

	return "[" + this.p1.toString() + ";" + this.p2.toString() + "]";
    }

    public static Vector1 getNeg(Vector1 v) {
	Point1 p1 = v.getStart();
	Point1 p2 = v.getEnd();
	return new Vector1(Point1.getNeg(p1), Point1.getNeg(p2));
    }

    public void neg() {
	this.p1.neg();
	this.p2.neg();
    }

}
