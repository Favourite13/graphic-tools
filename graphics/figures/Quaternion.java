package graphics.figures;

/**
 * @version %I%, %G%
 * @author Favourite / 13
 */

public class Quaternion {

    /**
     * The {@code double} value of accuracy
     */
    private final double CMP_EPSILON = 1E-6;

    private final int ACC = 100;

    private double[] quaternion = new double[4];

    public Quaternion() {
	this(0, 0, 0, 0);
    }

    public Quaternion(Quaternion q) {
	this(q.quaternion[0], q.quaternion[1], q.quaternion[2], q.quaternion[3]);

    }

    public Quaternion(double a, double i, double j, double k) {
	this.quaternion[0] = a;
	this.quaternion[1] = i;
	this.quaternion[2] = j;
	this.quaternion[3] = k;
    }

    /**
     * 
     * @param i
     * @return
     *         <li>the real part of quatrnion if {@code 1}
     *         <li>the i imaginary part of quatrnion if {@code 2}
     *         <li>the j imaginary part of quatrnion if {@code 3}
     *         <li>the k imaginary part of quatrnion if {@code 4}
     *         <li>0 otherwise
     */
    public double getEl(int i) {
	switch (i) {
	case 0:
	    return this.quaternion[0];
	case 1:
	    return this.quaternion[1];
	case 2:
	    return this.quaternion[2];
	case 3:
	    return this.quaternion[3];
	default:
	    return 0d;
	}
    }

    /**
     * adds up other quaternion to this one
     * <p>
     * the result is (a0+b0) + (a1+b1)*i + (a2+b2)*j + (a3+b3)*k
     * </p>
     */
    public void addQ(Quaternion other) {
	for (int i = 0; i < 4; i++) {
	    this.quaternion[i] += other.quaternion[i];
	}
    }

    /**
     * adds up two quaternions
     * <p>
     * returns the result (a0+b0) + (a1+b1)*i + (a2+b2)*j + (a3+b3)*k
     * </p>
     */
    public static Quaternion addQQ(Quaternion q1, Quaternion q2) {
	Quaternion q = new Quaternion(q1);
	q.addQ(q2);
	return new Quaternion(q);
    }
    
    /**
     * subtracts two quaternions
     * <p>
     * the result is (a0+b0) + (a1+b1)*i + (a2+b2)*j + (a3+b3)*k
     * </p>
     */
    public void subtractQ(Quaternion other) {
	for (int i = 0; i < 4; i++) {
	    this.quaternion[i] -= other.quaternion[i];
	}
    }

    /**
     * subtracts two quaternions
     * <p>
     * returns the result (a0-b0) + (a1-b1)*i + (a2-b2)*j + (a3-b3)*k
     * </p>
     */
    public static Quaternion subtractQQ(Quaternion q1, Quaternion q2) {
	Quaternion q = new Quaternion(q1);
	q.subtractQ(q2);
	return new Quaternion(q);
    }

    /**
     * returns the multiplication of this quaternion by other
     * <p>
     * (a0*b0-a1*b1-a2*b2-a3*b3)*1
     * </p>
     * <p>
     * (a1*b0+a0*b1+a2*b3-a3*b2)*i
     * </p>
     * <p>
     * (a2*b0+a0*b2-a1*b3+a3*b1)*j
     * </p>
     * <p>
     * (a3*b0+a0*b3+a1*b2-a2*b1)*k
     * </p>
     */
    public void multiplyQ(Quaternion other) {

	if (this.isConjugateTo(other)) {
	    this.quaternion[0] *= this.quaternion[0];
	    this.quaternion[0] += this.quaternion[1] * this.quaternion[1] + this.quaternion[2] * this.quaternion[2]
		    + this.quaternion[3] * this.quaternion[3];
	    this.quaternion[1] = 0d;
	    this.quaternion[2] = 0d;
	    this.quaternion[3] = 0d;
	    return;
	}

	double a0, a1, a2, a3;
	a0 = this.quaternion[0];
	a1 = this.quaternion[1];
	a2 = this.quaternion[2];
	a3 = this.quaternion[3];

	/**
	 * Real part (a0*b0-a1*b1-a2*b2-a3*b3)*1
	 */
	this.quaternion[0] *= other.quaternion[0];
	for (int i = 1; i < 4; i++) {
	    this.quaternion[0] -= this.quaternion[i] * other.quaternion[i];
	}
	/**
	 * Imaginary i part (a1*b0+a0*b1+a2*b3-a3*b2)*i
	 */
	this.quaternion[1] *= other.quaternion[0];
	this.quaternion[1] += a0 * other.quaternion[1];
	this.quaternion[1] += a2 * other.quaternion[3];
	this.quaternion[1] -= a3 * other.quaternion[2];
	/**
	 * Imaginary j part (a2*b0+a0*b2-a1*b3+a3*b1)*j
	 */
	this.quaternion[2] *= other.quaternion[0];
	this.quaternion[2] += a0 * other.quaternion[2];
	this.quaternion[2] -= a1 * other.quaternion[3];
	this.quaternion[2] += a3 * other.quaternion[1];
	/**
	 * Imaginary k part (a3*b0+a0*b3+a1*b2-a2*b1)*k
	 */
	this.quaternion[3] *= other.quaternion[0];
	this.quaternion[3] += a0 * other.quaternion[3];
	this.quaternion[3] += a1 * other.quaternion[2];
	this.quaternion[3] -= a2 * other.quaternion[1];

    }

    public double toReal() {
	return this.quaternion[0];
    }

    public static double toReal(Quaternion q) {
	return q.toReal();
    }

    /**
     * returns the multiplication of two quaternions
     * <p>
     * (a0*b0-a1*b1-a2*b2-a3*b3)*1
     * </p>
     * <p>
     * (a1*b0+a0*b1+a2*b3-a3*b2)*i
     * </p>
     * <p>
     * (a2*b0+a0*b2-a1*b3+a3*b1)*j
     * </p>
     * <p>
     * (a3*b0+a0*b3+a1*b2-a2*b1)*k
     * </p>
     */
    public static Quaternion multiplyQQ(Quaternion q1, Quaternion q2) {
	Quaternion q = new Quaternion(q1);
	q.multiplyQ(q2);
	return new Quaternion(q);

    }

    /**
     * the conjugate of quaternion q* = a - b*i - c*j - d*k
     * <p>
     * returns a new conjugate quaternion for original
     * </p>
     */
    public static Quaternion conjugateQ(Quaternion other) {
	return new Quaternion(other.quaternion[0], -other.quaternion[1], -other.quaternion[2], -other.quaternion[3]);
    }

    /**
     * the conjugate of quaternion q* = a - b*i - c*j - d*k
     * <p>
     * converts the quaternion to its conjugate
     * </p>
     */
    public void conjugateQ() {
	quaternion[1] = -quaternion[1];
	quaternion[2] = -quaternion[2];
	quaternion[3] = -quaternion[3];
    }

    public boolean isConjugateTo(Quaternion other) {
	return this.doubleEqual(this.quaternion[0], other.quaternion[0])
		&& this.doubleEqual(this.quaternion[1], -other.quaternion[1])
		&& this.doubleEqual(this.quaternion[2], -other.quaternion[2])
		&& this.doubleEqual(this.quaternion[3], -other.quaternion[3]);
    }

    /**
     * Compares two double values with default accuracy <i>CMP_EPSILON</i>
     * 
     * @see #CMP_EPSILON
     */
    private boolean doubleEqual(double a, double b) {
	return this.doubleEqual(a, b, this.CMP_EPSILON);
    }

    /**
     * Compares two double values with accuracy <b>exp</b>
     */
    private boolean doubleEqual(double a, double b, double exp) {
	double diff = Math.abs(a - b);
	double A = Math.abs(a);
	double B = Math.abs(b);
	double large = (A > B) ? A : B;
	return diff <= large * exp;
    }

    /**
     * Compares whether the real and imaginary parts of one quaternion are the same
     * as ones of another quaternion
     * 
     * @param other
     * @return
     */
    public boolean equalsQ(Quaternion other) {
	return this.doubleEqual(this.quaternion[0], other.quaternion[0])
		&& this.doubleEqual(this.quaternion[1], other.quaternion[1])
		&& this.doubleEqual(this.quaternion[2], other.quaternion[2])
		&& this.doubleEqual(this.quaternion[3], other.quaternion[3]);
    }

    // Деление кватернионов
    /**
     * this/other = this*(other*)/norm(other)
     * <p>
     * whereas other* is the conjugate for other
     * </p>
     * 
     * @param other
     */
    public void divideQ(Quaternion other) {
	this.multiplyQ(Quaternion.conjugateQ(other));
	double sqAbs = Quaternion.norm(other);
	for (int i = 0; i < 4; i++) {
	    this.quaternion[i] /= sqAbs;
	}
    }

    public static Quaternion divideQQ(Quaternion q1, Quaternion q2) {
	q1.divideQ(q2);
	return q1;
    }

    public static double norm(Quaternion q) {
	Quaternion other = new Quaternion(q);
	other.multiplyQ(Quaternion.conjugateQ(q));
	return other.quaternion[0];
    }

    @Override
    public String toString() {
	String acc = "#";
	int temp = 1;
	while ((temp * this.CMP_EPSILON) < 1) {
	    temp *= this.ACC;
	    acc += "#";
	}
	java.text.NumberFormat nf = new java.text.DecimalFormat("0." + acc + "E0");
	String aSign = this.quaternion[0] < 0 ? " - " : " + ";
	double aAbs = Math.abs(this.quaternion[0]);
	String iSign = this.quaternion[1] < 0 ? " - " : " + ";
	double iAbs = Math.abs(this.quaternion[1]);
	String jSign = this.quaternion[2] < 0 ? " - " : " + ";
	double jAbs = Math.abs(this.quaternion[2]);
	String kSign = this.quaternion[3] < 0 ? " - " : " + ";
	double kAbs = Math.abs(this.quaternion[3]);

	String aStr = nf.format(aAbs).replaceFirst("E", "*10^(") + ")";
	String iStr = nf.format(iAbs).replaceFirst("E", "*10^(") + ")";
	String jStr = nf.format(jAbs).replaceFirst("E", "*10^(") + ")";
	String kStr = nf.format(kAbs).replaceFirst("E", "*10^(") + ")";

	return aSign + aStr + iSign + iStr + "i" + jSign + jStr + "j" + kSign + kStr + "k";
    }

}
