package exercise;

// BEGIN
public class Flat implements Home {
    private double area;
    private double balconyArea;
    private int floor;
    public Flat(double area, double balconyArea, int floor) {
        this.area = area;
        this.balconyArea = balconyArea;
        this.floor = floor;
    }
    @Override
    public double getArea() {
        return area + balconyArea;
    }

    public int getFloor() {
        return floor;
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
        return String.format("Квартира площадью %s метров на %d этаже", this.getArea(), this.getFloor());
    }
}
// END
