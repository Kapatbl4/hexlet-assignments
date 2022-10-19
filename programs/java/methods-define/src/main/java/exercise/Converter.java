package exercise;

class Converter {
    // BEGIN
    public static void main(String[] args) {
        System.out.println("10 Kb = " + convert(10, "b") + " b");
    }
    public static int convert(int data, String vector) {
        int result;
        if (vector.equals("b")) {
            result = data * 1024;
        }
        else if (vector.equals("Kb")) {
            result = data / 1024;
        }
        else result = 0;
        return result;
    }
    // END
}
