package graphics.figures.vectors;

import graphics.figures.points.Point3;

/**
 * @version %I%, %G%
 * @author Favourite / 13
 */

public class Vector3 {
    Point3 p1, p2;
    public Vector3(Point3 p1, Point3 p2) {
	// TODO Auto-generated constructor stub
    }
    @Override
    public String toString() {

	return "[" + this.p1.toString() + ";" + this.p2.toString() + "]";
    }
}
