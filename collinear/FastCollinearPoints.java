/* *****************************************************************************
 *  Name: Yifan
 *  Date: 2022-Dec-02
 *  Description: O(N^2log(N)) solution
 **************************************************************************** */

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayList;
import java.util.Arrays;

public class FastCollinearPoints {
    private ArrayList<LineSegment> lines = new ArrayList<LineSegment>();

    public FastCollinearPoints(Point[] points)
    // finds all line segments containing 4 or more points
    {
        edgeCases(points);

        Point[] cpPoints = points.clone();
        Arrays.sort(cpPoints);

        for (Point p : cpPoints) {
            Arrays.sort(cpPoints, p.slopeOrder());
            int first = 1, last = 2;
            while (last < cpPoints.length) {
                while (last < cpPoints.length && p.slopeTo(cpPoints[first]) == p.slopeTo(
                        cpPoints[last])) {
                    last++;
                }
                if (last - first > 2 && p.compareTo(cpPoints[first]) < 0) {
                    lines.add(new LineSegment(p, cpPoints[last - 1]));
                }
                first = last;
                last++;
            }
            Arrays.sort(cpPoints);
        }
    }

    private void edgeCases(Point[] points) {
        if (points == null) throw new IllegalArgumentException();
        for (int i = 0; i < points.length; i++) {
            if (points[i] == null) {
                throw new IllegalArgumentException();
            }
            for (int j = i + 1; j < points.length; j++) {
                if (points[i].equals(points[j])) {
                    throw new IllegalArgumentException();
                }
            }
        }
    }

    public int numberOfSegments()
    // the number of line segments
    {
        return lines.size();
    }

    public LineSegment[] segments()
    // the line segments
    {
        return lines.toArray(new LineSegment[numberOfSegments()]);
    }

    public static void main(String[] args) {
        // read the n points from a file
        In in = new In(args[0]);
        int n = in.readInt();
        Point[] points = new Point[n];
        for (int i = 0; i < n; i++) {
            int x = in.readInt();
            int y = in.readInt();
            points[i] = new Point(x, y);
        }

        // draw the points
        StdDraw.enableDoubleBuffering();
        StdDraw.setXscale(0, 32768);
        StdDraw.setYscale(0, 32768);
        for (Point p : points) {
            p.draw();
        }
        StdDraw.show();

        // print and draw the line segments
        FastCollinearPoints collinear = new FastCollinearPoints(points);
        for (LineSegment segment : collinear.segments()) {
            StdOut.println(segment);
            segment.draw();
        }
        StdDraw.show();
    }
}
