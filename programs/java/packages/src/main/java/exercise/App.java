// BEGIN
package exercise;
import exercise.geometry.Point;
import exercise.geometry.Segment;

class App {
    public static double[] getMidpointOfSegment(double[][] segment) {
        double[] result = new double[2];
        result[0] = (Point.getX(segment[0]) + Point.getX(segment[1])) / 2;
        result[1] = (Point.getY(segment[0]) + Point.getY(segment[1])) / 2;
        return result;
    }

    public static double[][] reverse(double[][] segment) {
        double[] point1 = { Point.getX(Segment.getBeginPoint(segment)), Point.getY(Segment.getBeginPoint(segment)) };
        double[] point2 = { Point.getX(Segment.getEndPoint(segment)), Point.getY(Segment.getEndPoint(segment)) };
        return Segment.makeSegment(point2, point1);
    }

    public static boolean isBelongToOneQuadrant(double[][] segment) {
        // Вообще я бы вынес в отдельный метод определение четверти
        int firstPointQuadrant = 0;
        int secondPointQuadrant = 0;
        if(Point.getX(segment[0]) > 0 && Point.getY(segment[0]) > 0) { firstPointQuadrant = 1; }
        else if(Point.getX(segment[0]) < 0 && Point.getY(segment[0]) > 0) { firstPointQuadrant = 2; }
        else if(Point.getX(segment[0]) < 0 && Point.getY(segment[0]) < 0) { firstPointQuadrant = 3; }
        else if(Point.getX(segment[0]) > 0 && Point.getY(segment[0]) < 0) { firstPointQuadrant = 4; }

        if(Point.getX(segment[1]) > 0 && Point.getY(segment[1]) > 0) { secondPointQuadrant = 1; }
        else if(Point.getX(segment[1]) < 0 && Point.getY(segment[1]) > 0) { secondPointQuadrant = 2; }
        else if(Point.getX(segment[1]) < 0 && Point.getY(segment[1]) < 0) { secondPointQuadrant = 3; }
        else if(Point.getX(segment[1]) > 0 && Point.getY(segment[1]) < 0) { secondPointQuadrant = 4; }

        if(firstPointQuadrant == secondPointQuadrant) return true;
        return false;
    }

}
// END
