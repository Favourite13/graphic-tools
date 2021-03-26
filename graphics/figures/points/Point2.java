package graphics.figures.points;

public class Point2 {
    public double x, y;

    public Point2() {
	this(0d, 0d);
    }

    public Point2(final Point2 p) {
	this(p.x, p.y);
    }

    public Point2(final double x, final double y) {
	this.x = x;
	this.y = y;
    }
    
    public final static Point2 getNeg(Point2 p) {
	return new Point2(-p.x, -p.y);
    }
    
    public final void neg() {
	this.x = -x;
	this.y = -y;
    }

    @Override
    public final String toString() {
	return "(" + x + ";" + y + ")";
    }
}
