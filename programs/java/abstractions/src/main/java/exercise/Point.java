package exercise;

class Point {
    // BEGIN
    int x;
    int y;
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public static Point makePoint(int x, int y) {
        return new Point(x, y);
    }
    public static int getX(Point point) {
        return point.x;
    }
    public static int getY(Point point) {
        return point.y;
    }

    public static String pointToString(Point point) {
        StringBuilder sb = new StringBuilder();
        return sb.append("(").append(getX(point)).append(", ").append(getY(point)).append(")").toString();
    }

    public static int getQuadrant(Point point) {
        int result = 0;
        if (getX(point) > 0 && getY(point) > 0) result = 1;
        else if (getX(point) < 0 && getY(point) > 0) result = 2;
        else if (getX(point) < 0 && getY(point) < 0) result = 3;
        else if (getX(point) > 0 && getY(point) < 0) result = 4;
        return result;
    }
    // END

    // самостоятельная работа
    public static Point getSymmetricalPointByX(Point point) {
        return makePoint(getX(point), -getY(point));
    }

    public static double calculateDistance(Point a, Point b) {
        int x1 = getX(a);
        int x2 = getX(b);
        int y1 = getY(a);
        int y2 = getY(b);
        return Math.sqrt(Math.pow((x1 - x2), 2) + Math.pow((y1 - y2), 2));
    }
}
