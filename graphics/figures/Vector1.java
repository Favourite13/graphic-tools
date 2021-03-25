package graphics.figures;

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
	this.x2 = x2 * ratio;
	return;
    }

    @Override
    public void set(double[] p1, double[] p2) {
	this.x1 = p1[0];
	this.x2 = p2[0];

    }

    @Override
    public double[] get() {
	return new double[] { this.x1, this.x2 };
    }

    @Override
    public void add(IVector v1, IVector v2) {
	// TODO Auto-generated method stub

    }

    @Override
    public void substract(IVector v1, IVector v2) {
	// TODO Auto-generated method stub

    }

    @Override
    public void dotProduct(IVector v1, IVector v2) {
	// TODO Auto-generated method stub

    }

    @Override
    public void crossProduct(IVector v1, IVector v2) {
	// TODO Auto-generated method stub

    }

    @Override
    public void getNorm(IVector v) {
	// TODO Auto-generated method stub

    }

    @Override
    public void getConjugate(IVector v) {
	// TODO Auto-generated method stub

    }

    @Override
    public void getNormSq(IVector v) {
	// TODO Auto-generated method stub

    }

    @Override
    public String toString() {

	return "[" + this.x1 + ";" + this.x2 + "]";
    }

}
