package graphics.figures;

/**
 * I-can-do-whatever-I-want-and-get-away-with-it
 * 
 * @author Favorite / 13
 * @version %I%, %G%
 *
 */
public class Vector1 implements IVector {

    private double x1;
    private double x2;

    public Vector1() {
	this(0d, 1d);
    }

    public Vector1(Vector1 v) {
	this(v.get()[0], v.get()[1]);
    }

    public Vector1(double x1, double x2) {
	this.x1 = x1;
	this.x2 = x2;
    }

    @Override
    public void scale(double ratio) {
	this.x2 -= this.x1;
	this.x2 *= ratio;
	this.x2 += this.x1;
    }

    @Override
    public void set(double[] x1, double[] x2) {
	this.x1 = x1[0];
	this.x2 = x2[0];
    }

    @Override
    public double[] get() {
	return new double[] { this.x1, this.x2 };
    }

    public static IVector add(IVector v1, IVector v2) {
	double resLen = v1.get()[1] - v1.get()[0] + v2.get()[1] - v2.get()[0];
	return new Vector1(v1.get()[0], v1.get()[0] + resLen);
    }

    @Override
    public void add(IVector v) {
	this.x1 = add(this, v).get()[0];
	this.x2 = add(this, v).get()[1];
    }

    public static IVector subtract(IVector v1, IVector v2) {
	return add(v1, Vector1.neg(v2));
    }

    @Override
    public void subtract(IVector v) {
	add(neg(v));
    }

    public static double dotProduct(IVector v1, IVector v2) {
	return v1.getNorm() * v2.getNorm();
    }

    public static IVector crossProduct(IVector v1, IVector v2) {
	return new Vector1(0, 0);
    }

    @Override
    public double getNorm() {
	return Math.abs(this.x1 - this.x2);
    }

    @Override
    public IVector getConjugate() {
	return new Vector1(this.get()[0], this.get()[1]);
    }

    @Override
    public double getNormSq() {
	return (this.x1 - this.x2) * (this.x1 - this.x2);

    }

    @Override
    public String toString() {

	return "[" + this.x1 + ";" + this.x2 + "]";
    }

    public static IVector neg(IVector v) {
	return new Vector1(-v.get()[0], -v.get()[1]);
    }

    @Override
    public void neg() {
	this.x1 = -this.x1;
	this.x2 = -this.x2;
    }

}
