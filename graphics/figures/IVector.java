package graphics.figures;

public interface IVector {//Vector1 pass
    //TODO Vector2, Vector3, Quaternion
    
    public void scale(double ratio);

    public void set(double[] p1, double[] p2);

    public double[] get();

    public void add(IVector v);

    public void subtract(IVector v);

    public double getNorm();

    public double getNormSq();

    public IVector getConjugate();

    public void neg();
    
    public String toString();
}
