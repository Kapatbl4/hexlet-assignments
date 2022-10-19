package exercise;

// BEGIN
public class Cottage implements Home {
    private double area;
    private int floorCount;

    public Cottage(double area, int floorCount) {
        this.area = area;
        this.floorCount = floorCount;
    }

    @Override
    public double getArea() {
        return area;
    }

    public int getFloorCount() {
        return floorCount;
    }

    @Override
    public int compareTo(Home home) {
        int result = 0;
        if (this.getArea() == home.getArea()) {
            return result;
        } else {
            result = this.getArea() > home.getArea() ? 1 : -1;
        }
        return result;
    }

    @Override
    public String toString() {
        return String.format("%d этажный коттедж площадью %s метров", this.getFloorCount(), this.getArea());
    }
}
// END
