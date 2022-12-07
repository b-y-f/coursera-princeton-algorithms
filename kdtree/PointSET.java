/* *****************************************************************************
 *  Name: Yifan
 *  Date: 6/12/22
 **************************************************************************** */

import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.RectHV;

public class PointSET {
    public PointSET()
    // construct an empty set of points
    {

    }

    public boolean isEmpty()
    // is the set empty?
    {
        return false;
    }

    public int size()
    // number of points in the set
    {
        return 0;
    }

    public void insert(Point2D p)
    // add the point to the set (if it is not already in the set)
    {

    }

    public boolean contains(Point2D p)
    // does the set contain point p?
    {
        return false;
    }

    public void draw()
    // draw all points to standard draw
    {

    }

    public Iterable<Point2D> range(RectHV rect)
    // all points that are inside the rectangle (or on the boundary)
    {
        return null;
    }

    public Point2D nearest(Point2D p)
    // a nearest neighbor in the set to point p; null if the set is empty
    {
        return null;
    }

    public static void main(String[] args) {
        PointSET pointSET = new PointSET();
        System.out.println(pointSET.isEmpty());
        for (int i = 0; i < 1000; i++) {
            double x = Math.random();
            double y = Math.random();
            Point2D point2D = new Point2D(x, y);
            pointSET.insert(point2D);
            System.out.println(pointSET.contains(point2D) + " ");
        }
        System.out.println();

        System.out.println("Size = " + pointSET.size());

        System.out.println("Is contains (0.1, 0.1) = " + pointSET.contains(new Point2D(0.1, 0.1)));
        System.out.println();

        Point2D nearest = pointSET.nearest(new Point2D(0.1, 0.1));
        System.out.println("Nearest point to (0.1, 0.1) is " + nearest.toString());
        System.out.println();

        RectHV rangeRect = new RectHV(0.45, 0.45, 0.55, 0.55);
        for (Point2D inRangePoint : pointSET.range(rangeRect)) {
            System.out.println(inRangePoint.toString());
        }

        pointSET.draw();

    }
}