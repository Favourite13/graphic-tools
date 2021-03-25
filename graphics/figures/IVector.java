package graphics.figures;

public interface IVector {
    public void scale(double ratio);

    public void set(double[] p1, double[] p2);

    public double[] get();

    public void add(IVector v1, IVector v2);

    public void substract(IVector v1, IVector v2);

    public void dotProduct(IVector v1, IVector v2);

    public void crossProduct(IVector v1, IVector v2);

    public void getNorm(IVector v);

    public void getConjugate(IVector v);

    public void getNormSq(IVector v);

    public String toString();
}
