package graphics.figures.points;

public class Point3 {
    public double x, y, z;

    public Point3() {
	this(0d, 0d, 0d);
    }

    public Point3(Point3 p) {
	this(p.x, p.y, p.x);
    }

    public Point3(final double x, final double y, final double z) {
	this.x = x;
	this.y = y;
	this.z = z;
    }
    
    public final static Point3 getNeg(Point3 p) {
	return new Point3(-p.x, -p.y, -p.z);
    }
    
    public void neg() {
	this.x = -x;
	this.y = -y;
	this.z = -z;
    }

    @Override
    public String toString() {
	return "(" + x + ";" + y + ";" + z + ")";
    }
}
