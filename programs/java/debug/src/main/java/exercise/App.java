package exercise;

class App {
    // BEGIN
    public static String getTypeOfTriangle(int a, int b, int c) {
        String result;
        if (a <= 0 || b <= 0 || c <= 0) result = "Треугольник не существует";
        else if ((a + b) < c || (a + c) < b || (b + c) < a) result = "Треугольник не существует";
        else if (a == b && b == c) result = "Равносторонний";
        else if (a == b || a == c || b == c) result = "Равнобедренный";
        else result = "Разносторонний";
        return result;

    }

    public static int getFinalGrade(int exam, int project) {
        int result;
        if (exam > 100 || exam < 0 || project < 0) result = 0;
        else if (exam > 90 || project > 10) result = 100;
        else if (exam > 75 && project >= 5) result = 90;
        else if (exam > 50 && project >= 2) result = 75;
        else result = 0;
        return result;
    }
    // END
}
