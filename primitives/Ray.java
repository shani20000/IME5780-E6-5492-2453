package primitives;

import java.util.Objects;
/**
 * Class Ray is the class representing a Ray
 */
public class Ray {

    private Point3D point;
    private Vector vector;

    /**
     * parameter constructor
     * @param point
     * @param vector
     */
    public Ray(Point3D point, Vector vector) {
        if(vector.length()!=1)
            vector.normalize();
        this.point = point;
        this.vector = vector;
    }

    /**
     * copy constructor
     * @param r - other ray
     */
    public Ray (Ray r)
    {
        this.point=r.getPoint();
        this.vector=r.getVector();
    }

    /**
     * getter
     * @return the point value
     */
    public Point3D getPoint() {
        return point;
    }

    /**
     * getter
     * @return the vector value
     */
    public Vector getVector() {
        return vector;
    }

    /**
     * to string
     * @return a string of the ray data
     */
    @Override
    public String toString() {
        return "" + point
                + vector
                ;
    }

    /**
     * equals function
     * @param o - the object to compare
     * @return a boolean value - the objects are equal or not
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ray ray = (Ray) o;
        return Objects.equals(point, ray.point) &&
                Objects.equals(vector, ray.vector);
    }

    public Point3D getIntersectionPoint(double t)
    {
        return(point.add(vector.scale(t)));
    }

}
