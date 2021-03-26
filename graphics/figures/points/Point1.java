package graphics.figures.points;

public class Point1 {
    public double x;
    
    public Point1() {
	this(0d);
    }
    
    public Point1(final Point1 p) {
	this(p.x);
    }
    
    public Point1(final double x) {
	this.x = x;
    }
    
    public final static Point1 getNeg(Point1 p) {
	return new Point1(-p.x);
    }
    
    public final void neg() {
	this.x = -x;
    }
    
    @Override
    public final String toString() {
	return "(" + x + ")";
    }
}
