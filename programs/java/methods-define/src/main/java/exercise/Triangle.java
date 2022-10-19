package exercise;

class Triangle {
    // BEGIN
    public static void main(String[] args) {
        System.out.println(getSquare(4, 5, 45));
    }
    public static double getSquare(double firstSide, int secondSide, int degrees) {
        return (firstSide * secondSide) / 2 * (Math.sin(degrees * Math.PI / 180));
    }
    // END
}
