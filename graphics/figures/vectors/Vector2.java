package graphics.figures.vectors;

import graphics.figures.points.Point2;
import graphics.figures.points.Point3;

public class Vector2 {

    private Point2 p1, p2;

    public Vector2() {
	this(0, 0, 1, 1);
    }

    public Vector2(Vector2 v) {
	this(v.getStart(), v.getEnd());
    }

    public Vector2(final Point2 p1, final Point2 p2) {
	this(p1.x, p1.y, p2.x, p2.y);
    }

    public Vector2(double x1, double y1, double x2, double y2) {
	this.p1 = new Point2(x1, y1);
	this.p2 = new Point2(x2, y2);
    }

    public void scale(double ratio) {
	this.p2.x -= this.p1.x;
	this.p2.x *= ratio;
	this.p2.x += this.p1.x;

	this.p2.y -= this.p1.y;
	this.p2.y *= ratio;
	this.p2.y += this.p1.y;
    }

    public void set(Point2 p1, Point2 p2) {
	this.p1 = new Point2(p1);
	this.p2 = new Point2(p2);
    }

    public Point2 getStart() {
	return this.p1;
    }

    public Point2 getEnd() {
	return this.p2;
    }

    public static Vector2 add(Vector2 v1, Vector2 v2) {
	Vector2 v = new Vector2(v1);
	v.add(v2);
	return v;
    }

    public void add(Vector2 other) {
	this.getEnd().x += other.getEnd().x;
	this.getEnd().x -= other.getStart().x;

	this.getEnd().y += other.getEnd().y;
	this.getEnd().y -= other.getStart().y;
    }

    public static Vector2 subtract(Vector2 v1, Vector2 v2) {
	Vector2 v = new Vector2(v1);
	v.subtract(v2);
	return v;
    }

    public void subtract(Vector2 v) {
	add(neg(v));
    }

    public static double dotProduct(Vector2 v1, Vector2 v2) {
	return (v1.getEnd().x - v1.getStart().x) * (v2.getEnd().x - v2.getStart().x)
		+ (v1.getEnd().y - v1.getStart().y) * (v2.getEnd().y - v2.getStart().y);
    }

    public static Vector3 crossProduct(Vector2 v1, Vector2 v2) {
	Point3 p1 = new Point3(v1.getStart().x, v1.getStart().y, 0d);
	Point3 p2 = new Point3(v1.getStart().x, v1.getStart().y, v1.getNorm() * v2.getNorm() * Math.sin(angle(v1, v2)));
	return new Vector3(p1, p2);
    }

    private static double angle(Vector2 v1, Vector2 v2) {
	double angle = Math.acos(Vector2.dotProduct(v1, v2) / (v1.getNorm() * v2.getNorm()));
	return angle;
    }

    public double getNorm() {
	return Math.sqrt(getNormSq());
    }

    public double getNormSq() {
	return (this.p1.x - this.p2.x) * (this.p1.x - this.p2.x) + (this.p1.y - this.p2.y) * (this.p1.y - this.p2.y);
    }

    public Vector2 getConjugate() {
	return new Vector2(this.getStart(), Point2.getNeg(this.getEnd()));
    }

    public static Vector2 neg(Vector2 v) {
	Point2 p1 = v.getStart();
	Point2 p2 = v.getEnd();
	return new Vector2(Point2.getNeg(p1), Point2.getNeg(p2));
    }

    public void neg() {
	this.p1.neg();
	this.p2.neg();
    }

    public void revolve(Point2 p, double rad) {	
	this.getStart().revolve(p, rad);
	this.getEnd().revolve(p, rad);
    }
    
    public void revolveC(Point2 p, double rad) {
	this.getStart().revolveC(p, rad);
	this.getEnd().revolveC(p, rad);	
    }

    @Override
    public String toString() {

	return "[" + this.p1.toString() + ";" + this.p2.toString() + "]";
    }
}
