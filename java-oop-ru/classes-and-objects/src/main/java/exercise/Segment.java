package exercise;

// BEGIN
public class Segment {
    private Point beginPoint;
    private Point endPoint;
    public Segment(Point point1, Point point2) {
        this.beginPoint = point1;
        this.endPoint = point2;
    }

    public Point getBeginPoint() {
        return beginPoint;
    }

    public Point getEndPoint() {
        return endPoint;
    }

    public Point getMidPoint() {
        int x = (getBeginPoint().getX() + getEndPoint().getX()) / 2;
        int y = (getBeginPoint().getY() + getEndPoint().getY()) / 2;
        return new Point(x, y);
    }
}
// END
